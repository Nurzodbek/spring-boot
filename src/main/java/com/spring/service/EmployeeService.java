package com.spring.service;


import com.spring.domain.Employee;
import com.spring.repository.EmployeeRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    public Employee findById(Long id){
        return employeeRepository.findById(id).get();
    }

    public List<Employee> findByName(String name){
        return employeeRepository.findByNameQueryNative(name);
    }

    public List<Employee> findByNameAndLastName(String name,String lastName){
        return employeeRepository.findByNameAndLastName(name,lastName);
    }

    public List<Employee> findAllNameParam(String name){
        return employeeRepository.findAllByLike(name);
    }

    public void delete(Long id){
        Employee employee = employeeRepository.getOne(id);
        employeeRepository.delete(employee);
    }

    @Scheduled(cron = "0 31 23 * * *")
    public Employee saveSchedule(){
        Employee employee = new Employee();
        employee.setName("Salom");
        employee.setLastName("Salomov");
        return employeeRepository.save(employee);
    }

}
