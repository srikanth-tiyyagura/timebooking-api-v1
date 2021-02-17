package service;

import domain.Employee;
import domain.Employees;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class EmployeeManagerFacade {

    @Autowired EmployeeService employeeService;

    public Employees getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        List<Employee> employees = getAllEmployees().getEmployees();
        return employees.stream().filter(e -> e.getId() == id).findFirst();
    }

    public Employee insertEmployee(Employee employee) {
        Long employeeId = 0L;
        try {
            if(employee.getId() == null || employee.getId().toString().length()<7) {
                employee.setId(get64LeastSignificantBitsForVersion1());
            }
            employeeId = employee.getId();
            employeeService.updateEmployee(employee);
        } catch (Exception e) {
            System.out.println(e);
        }
        return getEmployeeById(employeeId).get();
    }

    public Employee updateEmployee(Employee employee) {
        try {
            if(getEmployeeById(employee.getId()).isPresent()) {
                employeeService.updateEmployee(employee);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return getEmployeeById(employee.getId()).get();
    }

    public Long deleteEmployee(Employee employee) {
        Long id = employee.getId();
        try {
            if(getEmployeeById(employee.getId()).isPresent()) {
                employeeService.deleteEmployee(id);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return id;
    }

    private static long get64LeastSignificantBitsForVersion1() {
        Random random = new Random();
        long random63BitLong = random.nextLong() & 0x3FFFFFFFFFFFFFFFL;
        long variant3BitFlag = 0x8000000000000000L;
        return random63BitLong + variant3BitFlag;
    }

    private static long get64MostSignificantBitsForVersion1() {
        LocalDateTime start = LocalDateTime.of(1582, 10, 15, 0, 0, 0);
        Duration duration = Duration.between(start, LocalDateTime.now());
        long seconds = duration.getSeconds();
        long nanos = duration.getNano();
        long timeForUuidIn100Nanos = seconds * 10000000 + nanos * 100;
        long least12SignificatBitOfTime = (timeForUuidIn100Nanos & 0x000000000000FFFFL) >> 4;
        long version = 1 << 12;
        return
                (timeForUuidIn100Nanos & 0xFFFFFFFFFFFF0000L) + version + least12SignificatBitOfTime;
    }
}
