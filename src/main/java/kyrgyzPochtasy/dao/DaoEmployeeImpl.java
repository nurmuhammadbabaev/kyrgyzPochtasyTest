package kyrgyzPochtasy.dao;

import kyrgyzPochtasy.entity.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class DaoEmployeeImpl implements DaoEmployee {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveEmployee(Employee employee) {
        entityManager.persist(employee);
    }

    @Override
    public void removeEmployeeById(int id) {
        entityManager.remove(getEmployeeById(id));
    }

    @Override
    public Employee getEmployeeById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employeeList = entityManager.createQuery("SELECT c from Employee c", Employee.class).getResultList();
        return employeeList;
    }

    @Override
    public void update(int id, Employee employee) {
        Employee employee1 = getEmployeeById(id);
        employee1.setFirstName(employee.getFirstName());
        employee1.setLastName(employee.getLastName());
        employee1.setAge(employee.getAge());
        employee1.setDepartment(employee.getDepartment());
        employee1.setLanguage(employee.getLanguage());
        entityManager.merge(employee1);
    }
}
