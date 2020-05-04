package test;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import model.Department;
import model.Employee;
import model.EmployeeType;
import model.ParkingSpace;

public class EmployeeJPATest {
	
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
		
			//Alttaki satýr çok önemli "EmployeePersistenceUnit" ismini persistence.xml 'deki persistence-unit 'deki name deðerini atýyoruz..
			//EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
			//javax.persistence.Persistence sinifi yardimiyla EntityManagerFactory oluþturabiliriz. 
			// bunun için persistence unit bilgisini kullanabiliriz. (persistence.xml)
			
			
			//EntityManagerFactory'den N tane EntityManager oluþturabiliriz.
			//Bundan da transaction elde edeceðiz ve sonrasýnda entityManager üzerinden entity'lerimizi kayýt edeceðiz veya entitylerimizi çekeceðiz.
		EntityManager entityManager=entityManagerFactory.createEntityManager();
	
		EmployeeDAO employeeDAO=new EmployeeDAOImpl(entityManager);
		
		/*
			Employee employee1=new Employee(1,"Merve","Kartal",5000);
			Employee employee2=new Employee(2,"Hüseyin","Saðlam",5000);
			Employee employee3=new Employee(5,"Abdullah","Kartal",6000);
			Employee employee4=new Employee(6,"Emine","Baðmancý",5000);
		*/
		
		//id otomatik vermek için(
			Employee employee1=new Employee("Merve","Kartal",5000);
			Employee employee2=new Employee("Hüseyin","Saðlam",5000);
			Employee employee3=new Employee("Abdullah","Kartal",6000);
			Employee employee4=new Employee("Emine","Baðmancý",5000);
			
			
		//@Enumarated 
			System.out.println(EmployeeType.FULL_TIME.ordinal());
			
			employee1.setEmployeeType(EmployeeType.FULL_TIME);
			employee2.setEmployeeType(EmployeeType.PART_TIME);
			employee3.setEmployeeType(EmployeeType.CONTRACTED_EMPLOYEE);
		
		//Date 
			LocalDate date1=LocalDate.of(2017, Month.JULY, 31);
			Date employeeStartDate1=Date.valueOf(date1);
			
			
			LocalDate date2=LocalDate.of(2013, Month.APRIL, 26);
			Date employeeStartDate2=Date.valueOf(date2);
			
			LocalDate date3=LocalDate.of(1990, Month.SEPTEMBER, 12);
			Date employeeStartDate3=Date.valueOf(date3);
			
	
			LocalDate date4=LocalDate.of(1919, Month.MAY, 19);
			Date employeeStartDate4=Date.valueOf(date4);
			
			employee1.setStartDate(employeeStartDate1);
			employee2.setStartDate(employeeStartDate2);
			employee3.setStartDate(employeeStartDate3);
			employee4.setStartDate(employeeStartDate4);
	
		 
		//image
			byte[] image1="image1.jpg".getBytes();
			byte[] image2="image2.jpg".getBytes();
			byte[] image3="image3.jpg".getBytes();
			
			employee1.setPicture(image1);
			employee2.setPicture(image2);
			employee3.setPicture(image3);

		//Department 
			Department department=new Department("IT Department");
			employeeDAO.insertDepartment(department);
			
			Department department2=new Department("Web Developer");
			employeeDAO.insertDepartment(department2);
	
			employee1.setDepartment(department); 	//Employee1 ve Employee2 Many to One iliþkisine sahip..
			employee2.setDepartment(department);
			employee3.setDepartment(department2);
			
		//ParkingSpace
			ParkingSpace ps1=new ParkingSpace(3, "M23");
			ParkingSpace ps2=new ParkingSpace(1, "H31");
			ParkingSpace ps3=new ParkingSpace(-2, "K42");
			
			employeeDAO.insertParkingSpace(ps1);
			employeeDAO.insertParkingSpace(ps2);
			employeeDAO.insertParkingSpace(ps3);
			
			employee1.setParkingSpace(ps1);
			employee2.setParkingSpace(ps3);
			employee3.setParkingSpace(ps2);
			
		//ekleme iþlemi
			employeeDAO.insertEmployee(employee1);
			employeeDAO.insertEmployee(employee2);
			employeeDAO.insertEmployee(employee3);
		

	}
}
