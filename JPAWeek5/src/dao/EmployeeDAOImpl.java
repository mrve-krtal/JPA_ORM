package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import model.Address;
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
			EntityTransaction transaction=entityManager.getTransaction();		//e�er transaction'� ba�lat�p commit'lemezsek veritaban� olu�ur ama kay�t eklenmez. Hata da vermez.
			transaction.begin();
			entityManager.persist(employee);		 //persist kal�c� hale getirir. insert atad�m. ilgili objeyi veritaban�na aktard�m. commit ettim.
			transaction.commit();
		}
	
		@Override
		public Employee getEmployeeById(int id) {
			
			//read i�lemi yapt�k bu nedenle transaction.begin/commit kullanmaya gerek yok.
			//id'e g�re kay�t d�nd�rece�iz. dinamik olacak gelen id'e g�re d�necek 
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
			
			//sonu� bulamazsa patlar noResultException hatas� verir.
			return query.getSingleResult();
			
		}
		
		@Override
		public List<Object[]> getEmployeeNameAndSurname(){
			
			TypedQuery<Object[]> query = entityManager.createQuery("Select e.name, e.surname from Employee e ", Object[].class);
			return query.getResultList();
			
		}
		
		@Override
		public List<EmployeeDetail> getEmployeeConstructorExpression(){

			TypedQuery<EmployeeDetail> query = entityManager.createQuery(
					"Select New model.EmployeeDetail(e.name,e.surname,e.department.name) from Employee e",
					EmployeeDetail.class);
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
		public void queryEmployee() {
	/*
	 BETWEEN ICIN
			TypedQuery<Employee> query=entityManager.createQuery("Select e from Employee e where e.salary BETWEEN ?1 and ?2",Employee.class)
				.setParameter(1,5500)
				.setParameter(2,6000);
	*/
		
			
	/*	
	 LIKE ICIN
			TypedQuery<Employee> query=entityManager.createQuery("Select e from Employee e where e.name LIKE 'Mer%' ",Employee.class);
			
			System.out.println("\nqueryEmployee LIKE");
	*/
			
	/*	
	 IN ICIN
			TypedQuery<Employee> query=entityManager.createQuery("Select e from Employee e where e.address.city IN('Istanbul','Izmir') ",Employee.class);
			
			System.out.println("\nqueryEmployee IN");
			List<Employee> emplist=query.getResultList();
			emplist.forEach(System.out::println);
			return emplist;
			
	*/
			
		//	TypedQuery<Long> query=entityManager.createQuery("Select SUM(e.salary) from Employee e",Long.class);

		//	TypedQuery<Integer> query=entityManager.createQuery("Select MAX(e.salary) from Employee e",Integer.class);
		
		//	TypedQuery<Long> query=entityManager.createQuery("Select COUNT(e.id) from Employee e",Long.class);
			
	/*	
		 	TypedQuery<Double> query=entityManager.createQuery("Select AVG(e.salary) from Employee e",Double.class);
			System.out.println("\nqueryEmployee");
			Double result=query.getSingleResult();
			System.out.println(result);
	 */	
			
	/*
		 	TypedQuery<Object[]> query=entityManager.createQuery("Select e.address.city, AVG(e.salary) from Employee e GROUP BY e.address.city",Object[].class);
			List<Object[]> emplist=query.getResultList();
				System.out.println("\nGROUP BY");
			for (Object[] eleman : emplist) {
				System.out.println("�ehiriniz: "+eleman[0]+", Ortalama Maa��n�z: "+eleman[1]);
				
			}
	 */			
	/*			
			TypedQuery<Object[]> query=entityManager.createQuery("Select e.address.city, AVG(e.salary) from Employee e GROUP BY e.address.city HAVING AVG(e.salary)>5000",Object[].class);
			List<Object[]> emplist=query.getResultList();
			
			System.out.println("\nHAVING BY");
			for (Object[] eleman : emplist) {
				System.out.println("�ehiriniz: "+eleman[0]+", Ortalama Maa��n�z: "+eleman[1]);
				
			}
	 */			
			TypedQuery<Integer> query = entityManager.createQuery("Select e.salary from Employee e ORDER BY e.salary DESC",Integer.class);
			System.out.println("\nORDER BY");
			List<Integer> emplist = query.getResultList();
			emplist.forEach(System.out::println);

		}
		
		@Override
		public void queryEmployeeCriteriaAPI() {
			
/*Select i�in
			CriteriaBuilder builder= entityManager.getCriteriaBuilder();
			//Return an instance of CriteriaBuilder for the creation of CriteriaQuery objects
			
			CriteriaQuery<Employee> query=builder.createQuery(Employee.class);
			Root<Employee> root=query.from(Employee.class);
			
			query.select(root);
			
			TypedQuery<Employee> typedQ=entityManager.createQuery(query);
			
			System.out.println("\nCriteria API Query");
			typedQ.getResultList().forEach(System.out::println);
*/			
			

			// 1) EntityManager uzerinden getCriteriaBuilder metodunu cagirdik , CriteriaBuilder
			// 2) CriteriaQuery objesini CriteriaBuilder araciligiyla olusturduk (createQuery)
			// 3) Sonrasinda from metodunu cagirdik , geriye Root dondu.
			// 4) select metodunu cagirdik
			// 5) entityManager uzerinden createQuery metodunu cagirdik.
			// 6) getResultList metodu ile sonuc dondu.
			
/*
 * NAME KOLONUNU D�NME
			CriteriaBuilder builder= entityManager.getCriteriaBuilder();
			//Return an instance of CriteriaBuilder for the creation of CriteriaQuery objects
			
			CriteriaQuery<String> query=builder.createQuery(String.class);
			Root<Employee> root=query.from(Employee.class);
			
			query.select(root.get("name"));
			
			TypedQuery<String> typedQ=entityManager.createQuery(query);
			
			System.out.println("\nCriteria API Query Name");
			typedQ.getResultList().forEach(System.out::println);
*/			

/*Birden fazla kolon �a��rmak i�in (tuple)
			//TUPLE : B�RDEN FAZLA ��E(KOLON) D�NER
			 
			CriteriaBuilder builder= entityManager.getCriteriaBuilder();
			//Return an instance of CriteriaBuilder for the creation of CriteriaQuery objects
			
			CriteriaQuery<Tuple> query=builder.createQuery(Tuple.class);
			Root<Employee> root=query.from(Employee.class);
			
			query.select(builder.tuple(root.get("name"), root.get("salary")));
			
			TypedQuery<Tuple> typedQ=entityManager.createQuery(query);
			
			System.out.println("\nCriteria API Query Tuple");
			List<Tuple> tupleList=typedQ.getResultList();
			for (Tuple t : tupleList) {
				System.out.println(t.get(0)+"'nin maa�� "+t.get(1));
				
			}
*/

/*	Where ile CriteriaQuery
 
			CriteriaBuilder builder= entityManager.getCriteriaBuilder();
			//Return an instance of CriteriaBuilder for the creation of CriteriaQuery objects
			
			CriteriaQuery<String> query=builder.createQuery(String.class);
			Root<Employee> root=query.from(Employee.class);
			
			query.select(root.get("department").get("name")). where (builder.equal(root.get("name"), "Merve"));			
			
			TypedQuery<String> typedQ=entityManager.createQuery(query);
			
			System.out.println("\nCriteria API Query Tuple");
			
			System.out.println(typedQ.getSingleResult());
			
*/			
			
/*
			CriteriaBuilder builder= entityManager.getCriteriaBuilder();
			//Return an instance of CriteriaBuilder for the creation of CriteriaQuery objects
			
			CriteriaQuery<Employee> query=builder.createQuery(Employee.class);
			Root<Employee> root=query.from(Employee.class);
			
			query.select(root).where(builder.greaterThan(root.get("salary"), 5500));
			
			TypedQuery<Employee> typedQ=entityManager.createQuery(query);
			
			System.out.println("\nCriteria API Query");
			typedQ.getResultList().forEach(System.out::println);
			
			
*/			
			

			CriteriaBuilder builder= entityManager.getCriteriaBuilder();
			//Return an instance of CriteriaBuilder for the creation of CriteriaQuery objects
			
			CriteriaQuery<Employee> query=builder.createQuery(Employee.class);
			Root<Employee> root=query.from(Employee.class);
			
			query.select(root).where(builder.between(root.get("salary"),
					builder.parameter(Integer.class,"lowSalary"), builder.parameter(Integer.class,"highSalary")) );


			TypedQuery<Employee> typedQ=entityManager.createQuery(query).setParameter("lowSalary", 5000).setParameter("highSalary", 5500);
			
			System.out.println("\nCriteria API Query Between");
			typedQ.getResultList().forEach(System.out::println);
			

			
			
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
			entityManager.persist(department); //persist kal�c� hale getirir. insert atad�m. ilgili objeyi veritaban�na aktard�m. commit ettim.
			transaction.commit();
			
		}
	
		@Override
		public void insertParkingSpace(ParkingSpace parkSpace) {
	
			EntityTransaction transaction=entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(parkSpace); //persist kal�c� hale getirir. insert atad�m. ilgili objeyi veritaban�na aktard�m. commit ettim.
			transaction.commit();
			
		}

		@Override
		public void insertAddress(Address address) {
			
			EntityTransaction transaction=entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(address); //persist kal�c� hale getirir. insert atad�m. ilgili objeyi veritaban�na aktard�m. commit ettim.
			transaction.commit();
			
		}
	
		

}
