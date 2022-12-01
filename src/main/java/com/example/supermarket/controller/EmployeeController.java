package com.example.supermarket.controller;

import com.example.supermarket.model.Employee;
import com.example.supermarket.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public ResponseEntity getAll() {
        return ResponseEntity.ok(employeeService.getAll());
    }

    @PostMapping
    public ResponseEntity<Employee> persist(@RequestBody Employee employee) {
        if (employee.getSalary() < 0) {
            return ResponseEntity.status(404).build();
        }


        if (employee.getAge() <= 18 && employee.getAge() >= 65) {
            return ResponseEntity.status(404).build();
        }


        return ResponseEntity.ok(employeeService.persist(employee));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable String id) {
        return ResponseEntity.ok(employeeService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable String id, @RequestBody Employee employee) {
        if (employee.getSalary() < 0) {
            return ResponseEntity.status(404).build();
        }


        if (employee.getAge() <= 18 && employee.getAge() >= 65) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.ok(employeeService.update(id, employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") String id) {
        employeeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
