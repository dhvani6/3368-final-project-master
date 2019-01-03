package edu.uh.tech.cis3368.manufacture;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Customerss {
    private int customerId;
    private String custFirstName;
    private String custLastName;
    private String custEmail;
    private String custAddress;
    private String custStatus;
    private Integer custPrice;
    private String custPhoneNumber;
    private String custDescription;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "cust_first_name")
    public String getCustFirstName() {
        return custFirstName;
    }

    public void setCustFirstName(String custFirstName) {
        this.custFirstName = custFirstName;
    }

    @Basic
    @Column(name = "cust_last_name")
    public String getCustLastName() {
        return custLastName;
    }

    public void setCustLastName(String custLastName) {
        this.custLastName = custLastName;
    }

    @Basic
    @Column(name = "cust_email")
    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    @Basic
    @Column(name = "cust_address")
    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    @Basic
    @Column(name = "cust_status")
    public String getCustStatus() {
        return custStatus;
    }

    public void setCustStatus(String custStatus) {
        this.custStatus = custStatus;
    }

    @Basic
    @Column(name = "cust_price")
    public Integer getCustPrice() {
        return custPrice;
    }

    public void setCustPrice(Integer custPrice) {
        this.custPrice = custPrice;
    }

    @Basic
    @Column(name = "cust_phone_number")
    public String getCustPhoneNumber() {
        return custPhoneNumber;
    }

    public void setCustPhoneNumber(String custPhoneNumber) {
        this.custPhoneNumber = custPhoneNumber;
    }

    @Basic
    @Column(name = "cust_description")
    public String getCustDescription() {
        return custDescription;
    }

    public void setCustDescription(String custDescription) {
        this.custDescription = custDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customerss that = (Customerss) o;
        return customerId == that.customerId &&
                Objects.equals(custFirstName, that.custFirstName) &&
                Objects.equals(custLastName, that.custLastName) &&
                Objects.equals(custEmail, that.custEmail) &&
                Objects.equals(custAddress, that.custAddress) &&
                Objects.equals(custStatus, that.custStatus) &&
                Objects.equals(custPrice, that.custPrice) &&
                Objects.equals(custPhoneNumber, that.custPhoneNumber) &&
                Objects.equals(custDescription, that.custDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, custFirstName, custLastName, custEmail, custAddress, custStatus, custPrice, custPhoneNumber, custDescription);
    }
}
