package org.reeta.dto;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
@NamedQuery(name="Employee.byId", query="from Employee where empId = :empId")
@NamedNativeQuery(name="Employee.byName", query="Select empname from employee where empname = :employeeName", resultClass=Employee.class)
@NamedNativeQuery(name="Employee.byNames", query="Select * from employee where empname = :employeeName", resultClass=Employee.class)
public class Employee {
	@Id
	private String empId;
	private String empName;
	
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
}
