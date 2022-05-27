package kyrgyzPochtasy.service;

import kyrgyzPochtasy.entity.Employee;

import java.util.List;

public interface EmployeeService {

    void saveEmployee(Employee employee);

    void removeEmployeeById(int id);

    Employee getEmployeeById(int id);

    List<Employee> getAllEmployee();

    void update(int id,Employee employee);
}
