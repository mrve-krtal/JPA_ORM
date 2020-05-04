package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.EmployeeDAO;
import dao.EmployeeDAOImp;
import model.Employee;

@ManagedBean
@SessionScoped
public class EmployeeManagedBean {
	
	
		private Employee employee=new Employee();
		private List<Employee> employees;
		
		public EmployeeManagedBean(){
			employees=new ArrayList<>();
			employee=new Employee();
		}

		public Employee getEmployee() {
			return employee;
		}

		public void setEmployee(Employee employee) {
			this.employee = employee;
		}
		
		public List<Employee> getEmployees() {
			return employees;
		}

		public void setEmployees(List<Employee> employees) {
			this.employees = employees;
		}

		public void addEmployee() {
			
			EmployeeDAO employeeDAO=new EmployeeDAOImp();
			System.out.println(employee);
			employeeDAO.insertEmployee(employee);
			
			employees=employeeDAO.findAddEmployees();
		}
		
		public void deleteEmployee(int id) {
			
			EmployeeDAO employeeDAO=new EmployeeDAOImp();
			employeeDAO.removeEmployee(id);
			

			employees=employeeDAO.findAddEmployees();
			
		}

}
