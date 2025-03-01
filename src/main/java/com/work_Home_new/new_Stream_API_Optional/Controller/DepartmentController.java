package com.work_Home_new.new_Stream_API_Optional.Controller;

import com.work_Home_new.new_Stream_API_Optional.Service.Employee;
import com.work_Home_new.new_Stream_API_Optional.Service.EmployeeServiceNew;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final EmployeeServiceNew employeeServiceNew;

    public DepartmentController(EmployeeServiceNew employeeServiceNew) {
        this.employeeServiceNew = employeeServiceNew;
    }

    @GetMapping("/max-salary")
    public Employee maxSalaryDepartment(@RequestParam int department) {
        return employeeServiceNew.getEmployeeWithMaxSalary(department);
    }

    @GetMapping("/min-salary")
    public Employee minSalaryDepartment(@RequestParam int department) {
        return employeeServiceNew.getEmployeeWithMinSalary(department);
    }

    @GetMapping(value = "/all", params = {"department"})
    public Collection<Employee> allDepartment(@RequestParam int department) {
        return employeeServiceNew.employeesDepartment(department);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> all() {
        return employeeServiceNew.allEmployeesDepartments();
    }
}