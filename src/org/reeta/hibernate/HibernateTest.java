package org.reeta.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.reeta.dto.Employee;
import org.reeta.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {

		UserDetails user = new UserDetails();
		user.setUserName("Reet");
		user.setJoinedDate(new Date());
		user.setDescription("Technical Lead");
		user.setUserId(20);
		
		/*Address address = new Address();
		address.setCity("Pune");
		address.setPincode("440011");
		address.setState("Maharashtra");
		address.setStreetName("Koregoan Park lane 7");
		
		Address officeAddress = new Address();
		officeAddress.setCity("Pune");
		officeAddress.setPincode("440012");
		officeAddress.setState("Maharashtra");
		officeAddress.setStreetName("Kalyani Nagar");
		
		user.getListOfAddresses().add(address);
		user.getListOfAddresses().add(officeAddress);*/
		
		/*Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");
		
		TwoWheeler twoWheeler = new TwoWheeler();
		twoWheeler.setVehicleName("Bike");
		twoWheeler.setSteeringHandle("This is two wheeler");
		
		FourWheeler fourWheeler = new FourWheeler();
		fourWheeler.setVehicleName("Audi");
		fourWheeler.setSteeringWheel("This is four wheeler");*/
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.setProperty("user_id", user.getUserId());
		session.save(user);
		
		/*session.save(vehicle);
		session.save(twoWheeler);
		session.save(fourWheeler);*/
		/*int maxSize = 5;
		Query query = session.createQuery("from Employee where id >"+maxSize);
		Query query1 = session.createQuery("from Employee where id = :userId");
		query1.setParameter("userId", "5");
		List<Employee> empList = query1.getResultList();
		for(Employee emp :empList){
			System.out.println(emp.getEmpName());
		}*/
		
		/*
		 * Query query = session.getNamedQuery("Employee.byId");
		 * //query.setCacheable(true); query.setInteger("empId",1); List<Employee>
		 * empList = query.getResultList(); for(Employee emp :empList){
		 * System.out.println(emp.getEmpName()); } Query query2 =
		 * session.getNamedNativeQuery("Employee.byNames"); query2.uniqueResult();
		 * query2.setString("employeeName", "User"); List<Employee> empNameList =
		 * query2.getResultList(); for(Employee emp :empNameList){
		 * System.out.println(emp.getEmpName()); }
		 */
		session.getTransaction().commit();
		session.close();
		
		/*user = null;*/
		session = sessionFactory.openSession();
		user = session.get(UserDetails.class, 10);
		session.close();
		System.out.println("This is test user : "+user);
	}

}
