package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import model.Employee;
import utility.JPAUtility;

public class EmployeeDAOImp implements EmployeeDAO{
	
	private EntityManager entityManager;
	
	public EmployeeDAOImp() {
		
		EntityManagerFactory emf=JPAUtility.getEntityManagerFactory();
		entityManager=emf.createEntityManager();
	}

	@Override
	public void insertEmployee(Employee employee) {  

		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
		
	}

	@Override
	public Employee findEmployee(int id) {
		
		return entityManager.find(Employee.class, id);
		
	}

	@Override
	public List<Employee> findAddEmployees() {
		
		TypedQuery<Employee> query=entityManager.createQuery("Select e from Employee e",Employee.class);
		return query.getResultList();
		 
	}

	@Override
	public void removeEmployee(int id) {

		Employee employee=findEmployee(id);
		
		entityManager.getTransaction().begin();
		entityManager.remove(employee);
		entityManager.getTransaction().commit(); 
		
	}

}
