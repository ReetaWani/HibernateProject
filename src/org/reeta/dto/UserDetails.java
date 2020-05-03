	package org.reeta.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.CascadeType;

@Entity(name="user_details")
public class UserDetails {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;
	@Column(name="user_name")
	private String userName;
	@Temporal(TemporalType.DATE)
	private Date joinedDate;
	@Lob
	private String description;
	@Transient
	//@OneToMany(cascade=CascadeType.PERSIST)
	private Collection<Vehicle> vehicle = new ArrayList<Vehicle>();
	/*@ManyToMany
	@JoinTable(name="user_vehicle", joinColumns=@JoinColumn(name="user_id"),
			inverseJoinColumns=@JoinColumn(name="vehicle_id")
	)
	private Collection<Vehicle> vehicle = new ArrayList<Vehicle>();
	*/
	/* When we don't want new table to be created then provide mappedBy property 
	 * to let hibernate know that column is already mapped by another entity */
	/*@OneToMany(mappedBy="user")
	private Collection<Vehicle> vehicle = new ArrayList<Vehicle>();
	*/
	/*@OneToMany
	@JoinTable(name="user_vehicle" ,joinColumns=@JoinColumn(name="user_id"),
			   inverseJoinColumns=@JoinColumn(name="vehicle_id"))
	private Collection<Vehicle> vehicle = new ArrayList<Vehicle>();*/
	
	/*@OneToOne
	@JoinColumn(name="VEHICLE_ID")
	private Vehicle vehicle;*/
	
	/*@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="user_address", 
			joinColumns=@JoinColumn(name="user_id")
	)
	@GenericGenerator(name="increment",strategy="increment")
	@CollectionId(columns={@Column(name="address_id")},generator="increment",type=@Type(type="long") )
	private Collection<Address> listOfAddresses = new ArrayList();*/
	/*@Embedded
	@AttributeOverrides({
	@AttributeOverride(name="streetName",column=@Column(name="HOME_STREET_NAME")),	
	@AttributeOverride(name="city",column=@Column(name="HOME_CITY_NAME")),
	@AttributeOverride(name="state",column=@Column(name="HOME_STATE_NAME")),
	@AttributeOverride(name="pincode",column=@Column(name="HOME_PIN_CODE"))})
	private Address homeAddress;
	@Embedded
	private Address officeAddress;*/
	
	
	
	/*public Collection<Address> getListOfAddresses() {
		return listOfAddresses;
	}
	public void setListOfAddresses(Collection<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}*/
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	/*public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}*/
	/*public Set<Address> getListOfAddresses() {
		return listOfAddresses;
	}
	public void setListOfAddresses(Set<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}*/
	/*public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}*/
	public Collection<Vehicle> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Collection<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}
}
