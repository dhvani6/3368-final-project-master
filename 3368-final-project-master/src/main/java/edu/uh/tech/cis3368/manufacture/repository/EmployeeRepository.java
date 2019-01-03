package edu.uh.tech.cis3368.manufacture.repository;

import edu.uh.tech.cis3368.manufacture.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
    Employee findByEmpId(Integer empId);
}
