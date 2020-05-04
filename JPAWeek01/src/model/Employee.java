package model;

import javax.persistence.Entity;
import javax.persistence.Id;

//EntityManager yard�m�yla bir insert atayaca��z. Ka�tlar� getirece�iz veya query �al��t�raca��z.
//find metodu, persist gibi metotlar var bunlar bizim veritaban�nda i� yapmam�z� sa�layan metotlar olmaktad�r.

//Entity'nin ilk iki �zell�ini kulland�k!!

@Entity
public class Employee {
	
	@Id //annotationlar� property yada instance de�i�kenleri �zerine koyabiliriz. 
	//Bununla birlikte getter �zerine de koyabiliriz. 
	//setter �zerine de koyarsak etkisi yoktur..
	private int id;
	private String name;
	private String surname;
	private int salary;
	
	
//default constructor gerekli!!! deglerasyonlar� yam�� olduk. 
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
