package kyrgyzPochtasy.controller;

import kyrgyzPochtasy.entity.Employee;
import kyrgyzPochtasy.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping
    public String getMainPage(Model model) {
        model.addAttribute("employees", "Main Page");
        //Главная страница
        return "main-page";
    }

    @GetMapping("/all")
    public String getAllEmployee(Model model) {
        //Получения всех сотрудников
        model.addAttribute("employees", employeeService.getAllEmployee());
        //Страница всех сотрудников
        return "allEmployees";
    }


    @GetMapping("/new")
    public String newEmployee(@ModelAttribute("employee") Employee employee) {
        //Страница для добавления сотрудников в БД
        return "addEmployee";
    }

    @PostMapping("/save")
    public String addEmployee(@ModelAttribute("employee") Employee employee) {
        //Добавляем сотрудников в БД
        employeeService.saveEmployee(employee);
        //После добавления вернемся обратно в главную страницу
        return "redirect:/employees";
    }

    @GetMapping("/{id}/edit")
    public String editEmployee(@PathVariable("id") int id, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        //Страница для изменения сотрудников
        return "updateEmployee";
    }

    @PatchMapping("/{id}")
    public String updateEmployee(@ModelAttribute("employee") Employee employee, @PathVariable("id") int id, Model model) {
        //Изменяем сотрудников
        employeeService.update(id, employee);
        model.addAttribute("employee", employee);
        //После изменения вернемся обратно на страницу all
        return "redirect:/employees/all";
    }

    @GetMapping("/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        //Удаляем сотрудников
        employeeService.removeEmployeeById(id);
        //После удаления сотрудников вернемся обратно на страницу all
        return "redirect:/employees/all";
    }
}
