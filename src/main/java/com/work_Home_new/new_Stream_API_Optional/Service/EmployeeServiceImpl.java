package com.work_Home_new.new_Stream_API_Optional.Service;
import com.work_Home_new.new_Stream_API_Optional.Exception.EmployeeAlreadyAddedException;
import com.work_Home_new.new_Stream_API_Optional.Exception.EmployeeNotFoundException;
import com.work_Home_new.new_Stream_API_Optional.Exception.EmployeeStorageIsFullException;
import com.work_Home_new.new_Stream_API_Optional.Exception.EmployeeValidNameException;
import jakarta.annotation.PostConstruct;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final int MAX_EMPLOYEES = 20;
    private final Map<String, Employee> employees = new HashMap<>();
    public StringUtils listWithEmployees;

    @PostConstruct
    private void listWithEmployees() {
        addEmployee("Костя", "Маласаев", 50_000, 1);
        addEmployee("Андрюха", "Шелков", 70_000, 2);
        addEmployee("Димон", "Вьюшкин", 40_000, 2);
        addEmployee("Серега", "Гореликов", 80_000, 3);
        addEmployee("АндрейКа", "Минин", 65_000, 4);
        addEmployee("Никита", "Мемасиков", 45_000, 1);
        addEmployee("Стас", "Выжил", 80_000, 5);
        addEmployee("Гена", "СпанчБобский", 75_000, 4);
        addEmployee("Турбо", "Джавович", 100_000, 5);
        addEmployee("Дюша", "Кофеинов", 75_000, 3);
    }


    @Override
    public Employee addEmployee(String firstName, String lastName) {
        return null;
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, Integer salary, Integer department) {
                if (!isValidName(firstName,lastName)) {
                    throw new EmployeeValidNameException();
                }

        if (employees.size() >= MAX_EMPLOYEES) {
            throw new EmployeeStorageIsFullException("Зарплаты на всех не хватит, макс. кол-во сотрудников - " + MAX_EMPLOYEES);
        }
        Employee employee = new Employee(firstName, lastName, salary.intValue(), department.intValue());
        if (employees.containsKey(employee.getFullame())) {
            throw new EmployeeAlreadyAddedException("Этот " + firstName + " " + lastName + " сотрудник уже есть");
        }
        employees.put(employee.getFullame(), employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        return null;
    }


    @Override
    public Employee removeEmployee(String firstName, String lastName, Integer salary, Integer department) {
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (!isValidName(firstName,lastName)) {
            throw new EmployeeValidNameException();
        }
        if (employees.containsKey(employee.getFullame())) {
            return employees.remove(employee.getFullame());
        }
        throw new EmployeeNotFoundException("Такого сотрудника " + firstName + " " + lastName + " нет в базе, увы");
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        return null;
    }


    @Override
    public Employee findEmployee(String firstName, String lastName, Integer salary, Integer department) {
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (!isValidName(firstName,lastName)) {
            throw new EmployeeValidNameException();
        }
        if (!employees.containsKey(employee.getFullame())) {
            throw new EmployeeNotFoundException("Такого сотрудника " + firstName + " " + lastName + " нет в базе, увы");
        }
        return employees.get(employee.getFullame());
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }


    private boolean isValidName (String firstName, String lastName) {
      return StringUtils.isAlpha(firstName) && StringUtils.isAlpha(lastName);
    }


}


