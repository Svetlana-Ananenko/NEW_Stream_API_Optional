package com.work_Home_new.new_Stream_API_Optional.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface EmployeeServiceNewInterface {

    Employee getEmployeeWithMaxSalary(int department);

    Employee getEmployeeWithMinSalary(int department);

    Collection<Employee> employeesDepartment(int department);

    Map<Integer, List<Employee>> allEmployeesDepartments();
}