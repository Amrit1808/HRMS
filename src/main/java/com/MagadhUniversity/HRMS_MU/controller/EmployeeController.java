package com.MagadhUniversity.HRMS_MU.controller;

import com.MagadhUniversity.HRMS_MU.model.Employee;
import com.MagadhUniversity.HRMS_MU.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "list_employees"; // JSP or Thymeleaf page that lists employees
    }

    @GetMapping("/create")
    public String createEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee()); // Empty employee object for form
        return "create_employee"; // Page for creating new employee
    }

    @PostMapping
    public String createEmployee(@ModelAttribute Employee employee) {
        employeeService.createEmployee(employee);
        return "redirect:/employees"; // Redirect to the list of employees
    }

    @GetMapping("/view/{employeeId}")
    public String viewEmployee(@PathVariable Long employeeId, Model model) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        model.addAttribute("employee", employee);
        return "view_employee"; // Page to view employee details
    }

    @GetMapping("/update/{employeeId}")
    public String updateEmployeeForm(@PathVariable Long employeeId, Model model) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        model.addAttribute("employee", employee);
        return "update_employee"; // Page to edit an employee
    }

    @PostMapping("/update/{employeeId}")
    public String updateEmployee(@PathVariable Long employeeId,
                                 @RequestParam String name,
                                 @RequestParam String address,
                                 @RequestParam String contactNumber,
                                 @RequestParam String email,
                                 @RequestParam String position,
                                 @RequestParam String department,
                                 @RequestParam(required = false) String dateOfJoining) {
        Employee existingEmployee = employeeService.getEmployeeById(employeeId);

        // Only update the date if a new date is provided
        LocalDate joiningDate = existingEmployee.getDateOfJoining();
        if (dateOfJoining != null && !dateOfJoining.isEmpty()) {
            joiningDate = LocalDate.parse(dateOfJoining); // Parsing the date manually
        }

        // Update employee with new values
        employeeService.updateEmployee(employeeId, name, address, contactNumber, email, position, department, joiningDate);
        return "redirect:/employees"; // Redirect after update
    }

    @PostMapping("/delete/{employeeId}")
    public String deleteEmployee(@PathVariable Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return "redirect:/employees"; // Redirect after deletion
    }
}
