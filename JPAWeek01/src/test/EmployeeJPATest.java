package test;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import model.Employee;

public class EmployeeJPATest {
	
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
		//javax.persistence.Persistence sinifi yardimiyla EntityManagerFactory oluþturabiliriz. 
		// bunun için persistence unit bilgisini kullanabiliriz. (persistence.xml)
		
		
		//EntityManagerFactory'den N tane EntityManager oluþturabiliriz.
		//Bundan da transaction elde edeceðiz ve sonrasýnda entityManager üzerinden entity'lerimizi kayýt edeceðiz veya entitylerimizi çekeceðiz.
		EntityManager entityManager=entityManagerFactory.createEntityManager();
	
		EmployeeDAO employeeDAO=new EmployeeDAOImpl(entityManager);
		
		Employee employee1=new Employee(1,"Merve","Kartal",5000);
		Employee employee2=new Employee(2,"Hüseyin","Saðlam",5000);
		Employee employee3=new Employee(3, "Kadir", "Kartal", 5555);
		Employee employee4=new Employee(4, "Serpil", "Kartal", 2555);
		
		
		employeeDAO.insertEmployee(employee1);
		employeeDAO.insertEmployee(employee2);
		employeeDAO.insertEmployee(employee3);
		employeeDAO.insertEmployee(employee4);
		
	
		
		Employee employeeFound=employeeDAO.getEmployeeById(2);
		
		System.out.println(employeeFound); 
		
		
		System.out.println();
		
		List<Employee> employeeList= employeeDAO.getEmployees();
		
		//employeeList.forEach(System.out::println);
		// veya basit bir for döngüsü ile bastýrabiliriz. 
		for (Employee e : employeeList) {
			System.out.println(e);
			
		}
		
		employeeDAO.deleteEmployee(3);
		
		System.out.println("after delete..");
		employeeList=employeeDAO.getEmployees();
		
		//employeeList.forEach(System.out::println);
				
		for (Employee e : employeeList) {
			System.out.println(e);
					
		}
		
		
		System.out.println("after raise");
		employeeDAO.raiseSalary(2,1000);
		Employee employeeFound2=employeeDAO.getEmployeeById(2);
		System.out.println(employeeFound2);
		
	}
 
}
