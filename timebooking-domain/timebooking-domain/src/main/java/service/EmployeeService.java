package service;

import domain.Employee;
import domain.Employees;
import manager.EmployeeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeManager employeeManager;

    /*-- This method returns all the list of employees */
    public Employees getAllEmployees() {
        return (Employees) employeeManager.findAll();
    }

    public void updateEmployee(Employee employee) {
        employeeManager.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeManager.deleteById(id);
    }
}
