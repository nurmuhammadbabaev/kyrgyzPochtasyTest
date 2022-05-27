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
    public String getAllEmployee(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployee());
        return "main-page";
    }


    @GetMapping("/new")
    public String newEmployee(@ModelAttribute("employee") Employee employee) {
        //Добавляем компанию в БД

        return "addEmployee";
    }

    @PostMapping("/save")
    public String addEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/{id}/edit")
    public String editEmployee(@PathVariable("id") int id, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        return "updateEmployee";
    }

    @PatchMapping("/{id}")
    public String updateEmployee(@ModelAttribute("employee") Employee employee, @PathVariable("id") int id, Model model) {
        employeeService.update(id, employee);
        model.addAttribute("employee", employee);
        return "redirect:/employees";
    }

    @GetMapping("/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        employeeService.removeEmployeeById(id);
        return "redirect:/employees";
    }

    @GetMapping("/open")
    public String openCompany() {
        return "employee-page";
    }

//@ModelAttribute("headerMessage")
//    public String companyMessage(){
//    return "Welcom to our vebsite!";
//}


}
