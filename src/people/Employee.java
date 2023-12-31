package people;

import exceptions.InvalidDepartmentException;
import exceptions.InvalidNameException;

import java.util.Objects;

public class Employee extends Person {

    private int employeeId;
    private String department;

    public Employee(String name, String address, String city, int employeeId, String department) throws InvalidNameException, InvalidDepartmentException {
        super(name, address, city);
        this.employeeId = employeeId;
        setDepartment(department);
    }

    public int getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) throws InvalidDepartmentException {
        if (!department.equals("Car Sales") && !department.equals("Sales Processing")) {
            throw new InvalidDepartmentException("Invalid department. Must be 'Car Sales' or 'Sales Processing'.");
        }
        this.department = department;
    }

    @Override
    public String toString() {
        return super.toString() + "\nEmployee ID: " + this.employeeId + "\nDepartment: " + this.department;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), employeeId, department);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return employeeId == employee.employeeId &&
                Objects.equals(department, employee.department);
    }
}