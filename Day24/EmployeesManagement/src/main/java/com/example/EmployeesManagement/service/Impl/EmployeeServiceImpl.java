package com.example.EmployeesManagement.service.Impl;

import com.example.EmployeesManagement.dto.AddressDTO;
import com.example.EmployeesManagement.dto.DepartmentDTO;
import com.example.EmployeesManagement.dto.EmployeeDTO;
import com.example.EmployeesManagement.dto.ProjectDTO;
import com.example.EmployeesManagement.entity.Address;
import com.example.EmployeesManagement.entity.Department;
import com.example.EmployeesManagement.entity.Employee;
import com.example.EmployeesManagement.entity.Project;
import com.example.EmployeesManagement.repository.DepartmentRepository;
import com.example.EmployeesManagement.repository.EmployeeRepository;
import com.example.EmployeesManagement.repository.ProjectRepository;
import com.example.EmployeesManagement.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final ProjectRepository projectRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository,
                               DepartmentRepository departmentRepository,
                               ProjectRepository projectRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public Employee update(Long id, EmployeeDTO employeeDTO, DepartmentDTO departmentDTO, AddressDTO addressDTO, ProjectDTO projectDTO) {
        Employee existing = getById(id);

        existing.setName(employeeDTO.getName());
        existing.setSalary(employeeDTO.getSalary());

        // Address
        Address address = new Address();
        address.setCity(addressDTO.getCity());
        address.setState(addressDTO.getState());
        existing.setAddress(address);

        // Department
        Department department = departmentRepository.findById(employeeDTO.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found"));
        existing.setDepartment(department);

        // Projects
        List<Project> projects = projectRepository.findAllById(employeeDTO.getProjectIds());
        existing.setProjects(projects);

        return employeeRepository.save(existing);

    }

    @Override
    public Employee save(EmployeeDTO dto) {

        Employee employee = mapToEntity(dto);
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id " + id));
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee update(Long id, EmployeeDTO dto) {

        Employee existing = getById(id);

        existing.setName(dto.getName());
        existing.setSalary(dto.getSalary());

        // Address
        Address address = new Address();
        address.setCity(dto.getAddress().getCity());
        address.setState(dto.getAddress().getState());
        existing.setAddress(address);

        // Department
        Department department = departmentRepository.findById(dto.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found"));
        existing.setDepartment(department);

        // Projects
        List<Project> projects = projectRepository.findAllById(dto.getProjectIds());
        existing.setProjects(projects);

        return employeeRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    // 🔁 DTO → Entity Mapper
    private Employee mapToEntity(EmployeeDTO dto) {

        Employee employee = new Employee();
        employee.setName(dto.getName());
        employee.setSalary(dto.getSalary());

        Address address = new Address();
        address.setCity(dto.getAddress().getCity());
        address.setState(dto.getAddress().getState());
        employee.setAddress(address);

        Department department = departmentRepository.findById(dto.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found"));
        employee.setDepartment(department);

        List<Project> projects = projectRepository.findAllById(dto.getProjectIds());
        employee.setProjects(projects);

        return employee;
    }
}
