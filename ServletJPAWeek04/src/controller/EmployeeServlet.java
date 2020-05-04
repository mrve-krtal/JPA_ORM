package controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import dao.EmployeeDAOImp;
import model.Employee;


@WebServlet("/employeeController")
public class EmployeeServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	

		EmployeeDAO employeeDAO=(EmployeeDAO) new EmployeeDAOImp();
		
		String empid=req.getParameter("employeeId");
		
		if(empid!=null) {
			employeeDAO.removeEmployee(Integer.parseInt(empid));
		}
		else {
		
			String name=req.getParameter("name");
			String surname=req.getParameter("surname");
			int salary = Integer.parseInt(req.getParameter("salary"));
			
			Employee employee=new Employee(name, surname, salary);
			employee.setStarDate(new Date());
			employeeDAO.insertEmployee(employee);
			}
		
		List<Employee> employeeList=employeeDAO.findAddEmployees();
		
		//employee.jsp kýsmýnda 	<c:forEach items="${allEmployees}" var="employee"> isimleri ayný olmak zorunda!!!
		req.setAttribute("allEmployees", employeeList);
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("employee.jsp");
		dispatcher.forward(req, resp);
		
		
		}
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
			doPost(req, resp);
		}

}

//http://www.layoutit.com/
//https://datatables.net/examples/styling/bootstrap.html

