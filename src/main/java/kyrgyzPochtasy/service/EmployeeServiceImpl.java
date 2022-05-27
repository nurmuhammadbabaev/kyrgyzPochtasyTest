package kyrgyzPochtasy.service;

import kyrgyzPochtasy.dao.DaoEmployee;
import kyrgyzPochtasy.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private DaoEmployee daoEmployee;

    @Autowired
    public EmployeeServiceImpl(DaoEmployee daoEmployee) {
        this.daoEmployee = daoEmployee;
    }

    @Transactional
    @Override
    public void saveEmployee(Employee employee) {
        daoEmployee.saveEmployee(employee);
    }

    @Transactional
    @Override
    public void removeEmployeeById(int id) {
        daoEmployee.removeEmployeeById(id);
    }

    @Transactional
    @Override
    public Employee getEmployeeById(int id) {
        return daoEmployee.getEmployeeById(id);
    }

    @Transactional
    @Override
    public List<Employee> getAllEmployee() {
        return daoEmployee.getAllEmployee();
    }

    @Transactional
    @Override
    public void update(int id, Employee employee) {
        daoEmployee.update(id, employee);
    }
}
