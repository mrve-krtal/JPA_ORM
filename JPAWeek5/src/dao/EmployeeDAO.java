package dao;

import java.util.List;

import model.Address;
import model.Department;
import model.Employee;
import model.EmployeeDetail;
import model.ParkingSpace;

public interface EmployeeDAO {
	
	public void insertEmployee(Employee employee) ;
		
	public Employee getEmployeeById(int id);
	
	public List<Employee> getEmployees();
	
	public List<String> getEmployeeName();
	
	public String getEmployeeNameId(int id);
	
	public List<Object[]> getEmployeeNameAndSurname();
	
	public List<EmployeeDetail> getEmployeeConstructorExpression();
	
	public List<String> getEmployeNamesNamedQuery();
	
	public void queryEmployee();
	
	public void queryEmployeeCriteriaAPI();
	
	public void deleteEmployee(int id) ;	
	
	public void raiseSalary(int id, int raise);
	
	public void insertDepartment(Department department);
	
	public void insertParkingSpace(ParkingSpace parkSpace);

	public void insertAddress(Address address);


	



}
