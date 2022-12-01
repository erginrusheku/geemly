package com.example.supermarket.service;

import com.example.supermarket.model.Employee;

import com.example.supermarket.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Employee persist(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getById(String id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()) {
            return employeeOptional.get();
        }
        return null;
    }

    public Employee update(String id, Employee employee) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()) {
            Employee existingEmployee = employeeOptional.get();
            existingEmployee.setName(employee.getName());
            existingEmployee.setSurname(employee.getSurname());
            existingEmployee.setAge(employee.getAge());
            existingEmployee.setGender(employee.getGender());
            existingEmployee.setSectorId(employee.getSectorId());
            existingEmployee.setJobPosition(employee.getJobPosition());
            existingEmployee.setSalary(employee.getSalary());


        }
        return employeeRepository.save(employee);
    }

    public void deleteById(String id) {
        employeeRepository.deleteById(id);
    }
}