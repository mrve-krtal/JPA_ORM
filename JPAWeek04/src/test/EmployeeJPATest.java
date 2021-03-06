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
import model.EmployeeDetail;
import model.EmployeeType;
import model.ParkingSpace;

public class EmployeeJPATest {
	
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
		
			//Alttaki sat�r �ok �nemli "EmployeePersistenceUnit" ismini persistence.xml 'deki persistence-unit 'deki name de�erini at�yoruz..
			//EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
			//javax.persistence.Persistence sinifi yardimiyla EntityManagerFactory olu�turabiliriz. 
			// bunun i�in persistence unit bilgisini kullanabiliriz. (persistence.xml)
			
			
			//EntityManagerFactory'den N tane EntityManager olu�turabiliriz.
			//Bundan da transaction elde edece�iz ve sonras�nda entityManager �zerinden entity'lerimizi kay�t edece�iz veya entitylerimizi �ekece�iz.
		EntityManager entityManager=entityManagerFactory.createEntityManager();
	
		EmployeeDAO employeeDAO=new EmployeeDAOImpl(entityManager);
		
		/*
			Employee employee1=new Employee(1,"Merve","Kartal",5000);
			Employee employee2=new Employee(2,"H�seyin","Sa�lam",5000);
			Employee employee3=new Employee(5,"Abdullah","Kartal",6000);
			Employee employee4=new Employee(6,"Emine","Ba�manc�",5000);
		*/
		
		//id otomatik vermek i�in(
			Employee employee1=new Employee("Merve","Kartal",5000);
			Employee employee2=new Employee("H�seyin","Sa�lam",5000);
			Employee employee3=new Employee("Abdullah","Kartal",6000);
			Employee employee4=new Employee("Emine","Ba�manc�",5000);
			
			
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
	
			employee1.setDepartment(department); 	//Employee1 ve Employee2 Many to One ili�kisine sahip..
			employee2.setDepartment(department);
			employee3.setDepartment(department2);
/*			
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
*/			
			
		//ekleme i�lemi
			employeeDAO.insertEmployee(employee1);
			employeeDAO.insertEmployee(employee2);
			employeeDAO.insertEmployee(employee3);
		
			
		//Tablodaki sadece isimleri getirmek i�in 
			System.out.println("GetEmployeeName :");
			employeeDAO.getEmployeeName().forEach(System.out::println);
			
			
		//id'e g�re �a��rma
			System.out.println("\nGetEmployeeNameId:");
			String employeeNameId2=employeeDAO.getEmployeeNameId(2);
			System.out.println(employeeNameId2);
			
			
		//name ve surname g�re kolon �a��rma
			System.out.println("\nGetEmployeeNameAndSurname:");
			List<Object[]> NameAndSurname=employeeDAO.getEmployeeNameAndSurname();
				
			for (Object[] e : NameAndSurname) {
					System.out.println("Ad�n�z:"+e[0]+"  Soyad�n�z:"+e[1]);
					
				}
			
		//getEmployeeConstructorExpression �a��rma
			System.out.println("\ngetEmployeeConstructorExpression");
			List<EmployeeDetail> employeeDetailsList=employeeDAO.getEmployeeConstructorExpression();
			employeeDetailsList.forEach(System.out::println);
			
			
		//Named Query
			System.out.println("\nNamed Query:");
			List<String> namedQueryNames = employeeDAO.getEmployeNamesNamedQuery();
			namedQueryNames.forEach(System.out::println);
			

	}
}
