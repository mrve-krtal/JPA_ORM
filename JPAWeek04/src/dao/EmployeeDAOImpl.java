package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Department;
import model.Employee;
import model.EmployeeDetail;
import model.ParkingSpace;

public class EmployeeDAOImpl implements EmployeeDAO {

		private EntityManager entityManager;
		
		public EmployeeDAOImpl(EntityManager entityManager) {
			super();
			this.entityManager = entityManager;
		}
	
		@Override
		public void insertEmployee(Employee employee) {
			EntityTransaction transaction=entityManager.getTransaction();		//eðer transaction'ý baþlatýp commit'lemezsek veritabaný oluþur ama kayýt eklenmez. Hata da vermez.
			transaction.begin();
			entityManager.persist(employee);		 //persist kalýcý hale getirir. insert atadým. ilgili objeyi veritabanýna aktardým. commit ettim.
			transaction.commit();
		}
	
		@Override
		public Employee getEmployeeById(int id) {
			
			//read iþlemi yaptýk bu nedenle transaction.begin/commit kullanmaya gerek yok.
			//id'e göre kayýt döndüreceðiz. dinamik olacak gelen id'e göre dönecek 
			Employee employee=entityManager.find(Employee.class, id);
			return employee;
		}
	
		@Override
		public List<Employee> getEmployees() {
			
			//Query query=entityManager.createQuery("Selecet e Employee e");
			TypedQuery<Employee> query=entityManager.createQuery("Select e from Employee e",Employee.class);
			return query.getResultList();
		}
		
		@Override
		public List<String> getEmployeeName() {
			
			TypedQuery<String> query=entityManager.createQuery("Select e.name from Employee e",String.class);
			return query.getResultList();
		}
		
		@Override
		public String getEmployeeNameId(int id) {
			
			// positional binding
				//TypedQuery<String> query = entityManager.createQuery("Select e.name from Employee e where e.id=?1", String.class).setParameter(1, id);
			
			// named parameter
				TypedQuery<String> query = entityManager.createQuery("Select e.name from Employee e where e.id=:myEmployeeId", String.class).setParameter("myEmployeeId", id);
			
			//sonuç bulamazsa patlar noResultException hatasý verir.
			return query.getSingleResult();
			
		}
		
		@Override
		public List<Object[]> getEmployeeNameAndSurname(){
			
			TypedQuery<Object[]> query = entityManager.createQuery("Select e.name, e.surname from Employee e ", Object[].class);
			return query.getResultList();
			
		}
		
		@Override
		public List<EmployeeDetail> getEmployeeConstructorExpression(){

			TypedQuery<EmployeeDetail> query = entityManager.
					createQuery("Select New model.EmployeeDetail(e.name, e.surname, e.department.name) from Employee e ", EmployeeDetail.class);
			return query.getResultList();
			
		}
		
		@Override
		public List<String> getEmployeNamesNamedQuery() {
				
				//TypedQuery<String> query = entityManager.createQuery("Select e.name from Employee e", String.class);
				//return query.getResultList();
			TypedQuery<String> query = entityManager.createNamedQuery("Employee.getEmployeeName",String.class);
			return query.getResultList();
		}
		
		@Override
		public void deleteEmployee(int id) {
			
			Employee employee=getEmployeeById(id);
			EntityTransaction transaction=entityManager.getTransaction();
			transaction.begin();
			entityManager.remove(employee);
			transaction.commit();
		}
	
		@Override
		public void raiseSalary(int id, int raise) {
			
			Employee employee=getEmployeeById(id);
			EntityTransaction transaction=entityManager.getTransaction();
			
			transaction.begin();
			employee.setSalary(employee.getSalary()+raise);
			transaction.commit();
			
		}
	
		@Override
		public void insertDepartment(Department department) {
	
			EntityTransaction transaction=entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(department); //persist kalýcý hale getirir. insert atadým. ilgili objeyi veritabanýna aktardým. commit ettim.
			transaction.commit();
			
		}
	
		@Override
		public void insertParkingSpace(ParkingSpace parkSpace) {
	
			EntityTransaction transaction=entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(parkSpace); //persist kalýcý hale getirir. insert atadým. ilgili objeyi veritabanýna aktardým. commit ettim.
			transaction.commit();
			
		}

	
	
	
		

}
