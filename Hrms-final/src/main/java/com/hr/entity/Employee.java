package com.hr.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "EMPLOYEE_NAME", length = 100)
    @NotNull
    private String employeeName;

    @Email
    private String email;
    
   

    private String gender;
    private String dateOfBirth;
    private String joinDate;
    private String mobileNumber;
    private String aadhaarNumber;

    private String accountNumber;
    private String department;
    private String designation;
    private String previousCompany;
    private String pfNumber;
    private String salary;
    
    private String password;

    @Size(max = 1000, min = 10)
    private String currentAddress;

    @Size(max = 1000, min = 10)
    private String permanentAddress;

    private boolean active = true;

  
    private String role;

    public Employee() {}



    public Integer getId() { return id; }
    public Employee(Integer id, @NotNull String employeeName, @Email String email, String gender, String dateOfBirth,
			String joinDate, String mobileNumber, String aadhaarNumber, String accountNumber, String department,
			String designation, String previousCompany, String pfNumber, String salary,
			@Size(max = 1000, min = 10) String currentAddress, @Size(max = 1000, min = 10) String permanentAddress,
			boolean active, String role) {
		super();
		this.id = id;
		this.employeeName = employeeName;
		this.email = email;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.joinDate = joinDate;
		this.mobileNumber = mobileNumber;
		this.aadhaarNumber = aadhaarNumber;
		this.accountNumber = accountNumber;
		this.department = department;
		this.designation = designation;
		this.previousCompany = previousCompany;
		this.pfNumber = pfNumber;
		this.salary = salary;
		this.currentAddress = currentAddress;
		this.permanentAddress = permanentAddress;
		this.active = active;
		this.role = role;
	}

	public void setId(Integer id) { this.id = id; }

    public String getEmployeeName() { return employeeName; }
    public void setEmployeeName(String employeeName) { this.employeeName = employeeName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public String getJoinDate() { return joinDate; }
    public void setJoinDate(String joinDate) { this.joinDate = joinDate; }

    public String getMobileNumber() { return mobileNumber; }
    public void setMobileNumber(String mobileNumber) { this.mobileNumber = mobileNumber; }

    public String getAadhaarNumber() { return aadhaarNumber; }
    public void setAadhaarNumber(String aadhaarNumber) { this.aadhaarNumber = aadhaarNumber; }

    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }

    public String getPreviousCompany() { return previousCompany; }
    public void setPreviousCompany(String previousCompany) { this.previousCompany = previousCompany; }

    public String getPfNumber() { return pfNumber; }
    public void setPfNumber(String pfNumber) { this.pfNumber = pfNumber; }

    public String getSalary() { return salary; }
    public void setSalary(String salary) { this.salary = salary; }

    public String getCurrentAddress() { return currentAddress; }
    public void setCurrentAddress(String currentAddress) { this.currentAddress = currentAddress; }

    public String getPermanentAddress() { return permanentAddress; }
    public void setPermanentAddress(String permanentAddress) { this.permanentAddress = permanentAddress; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}
    
    
}
