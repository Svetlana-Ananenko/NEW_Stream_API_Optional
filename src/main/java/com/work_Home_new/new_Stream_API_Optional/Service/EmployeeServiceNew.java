package com.work_Home_new.new_Stream_API_Optional.Service;


import com.work_Home_new.new_Stream_API_Optional.Exception.EmployeeNotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;

@Service
public class EmployeeServiceNew implements EmployeeServiceNewInterface {
    private final EmployeeServiceImpl employeeServiceImpl;

    public EmployeeServiceNew(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }


            @Override
    public Employee getEmployeeWithMaxSalary(int department) {
        return employeeServiceImpl.findAll().stream()
                .filter(e -> e.getDepartment() == department)
                .max(comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee getEmployeeWithMinSalary(int department) {
        return employeeServiceImpl.findAll().stream()
                .filter(e -> e.getDepartment() == department)
                .min(comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Collection<Employee> employeesDepartment(int department) {
        return employeeServiceImpl.findAll().stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> allEmployeesDepartments() {
        return employeeServiceImpl.findAll().stream()
                .collect(groupingBy(Employee::getDepartment));
    }
}