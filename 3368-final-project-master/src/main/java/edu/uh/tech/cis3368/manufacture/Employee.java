package edu.uh.tech.cis3368.manufacture;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Employee {
    private int empId;
    private String empFirstName;
    private String empLastName;
    private String empEmail;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    @Basic
    @Column(name = "emp_first_name")
    public String getEmpFirstName() {
        return empFirstName;
    }

    public void setEmpFirstName(String empFirstName) {
        this.empFirstName = empFirstName;
    }

    @Basic
    @Column(name = "emp_last_name")
    public String getEmpLastName() {
        return empLastName;
    }

    public void setEmpLastName(String empLastName) {
        this.empLastName = empLastName;
    }

    @Basic
    @Column(name = "emp_email")
    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return empId == employee.empId &&
                Objects.equals(empFirstName, employee.empFirstName) &&
                Objects.equals(empLastName, employee.empLastName) &&
                Objects.equals(empEmail, employee.empEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId, empFirstName, empLastName, empEmail);
    }
}
