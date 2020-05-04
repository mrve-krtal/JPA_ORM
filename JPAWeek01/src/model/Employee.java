package model;

import javax.persistence.Entity;
import javax.persistence.Id;

//EntityManager yardýmýyla bir insert atayacaðýz. Kaýtlarý getireceðiz veya query çalýþtýracaðýz.
//find metodu, persist gibi metotlar var bunlar bizim veritabanýnda iþ yapmamýzý saðlayan metotlar olmaktadýr.

//Entity'nin ilk iki özellðini kullandýk!!

@Entity
public class Employee {
	
	@Id //annotationlarý property yada instance deðiþkenleri üzerine koyabiliriz. 
	//Bununla birlikte getter üzerine de koyabiliriz. 
	//setter üzerine de koyarsak etkisi yoktur..
	private int id;
	private String name;
	private String surname;
	private int salary;
	
	
//default constructor gerekli!!! deglerasyonlarý yamýþ olduk. 
	public Employee() {
		super();
	}

	public Employee(int id, String name, String surname, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.salary = salary;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", surname=" + surname + ", salary=" + salary + "]";
	}
	
	
	
	

}
