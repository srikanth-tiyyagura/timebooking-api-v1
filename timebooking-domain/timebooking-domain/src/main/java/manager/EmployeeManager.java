package manager;

import domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeManager  extends JpaRepository<Employee, Long> {
}
