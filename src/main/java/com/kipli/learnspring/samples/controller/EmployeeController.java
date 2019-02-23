package com.kipli.learnspring.samples.controller;

import com.kipli.learnspring.samples.entity.Employee;
import com.kipli.learnspring.samples.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
        List<Employee> listData = employeeService.findAll();
        model.addAttribute("employees", listData);
        return "/employee/list-employees";
    }

    @GetMapping("/showFormAdd")
    public String formAddEmployee(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "/employee/employee-form";
    }

    @GetMapping("/showFormUpdate")
    public String showFormUpdate(@RequestParam("employeeId") int employeeId, Model model){
        Employee employee = employeeService.findById(employeeId);
        model.addAttribute("employee", employee);
        return "/employee/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.save(employee);
        return "redirect:/employees/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int employeeId){
        employeeService.deleteById(employeeId);
        return "redirect:/employees/list";
    }

}
