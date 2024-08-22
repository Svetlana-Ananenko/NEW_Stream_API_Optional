package com.work_Home_new.new_Stream_API_Optional.Service;

import java.util.Collection;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName);

    Employee addEmployee(String firstName, String lastName, Integer salary, Integer department);

    Employee removeEmployee(String firstName, String lastName);

   Employee removeEmployee(String firstName, String lastName, Integer salary, Integer department);

    Employee findEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName, Integer salary, Integer department);

    Collection<Employee> findAll();
}

