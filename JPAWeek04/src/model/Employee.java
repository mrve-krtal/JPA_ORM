package model;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
	
	//EntityManager yardýmýyla bir insert atayacaðýz. Kayýtlarý getireceðiz veya query çalýþtýracaðýz.
	//find metodu, persist gibi metotlar var bunlar bizim veritabanýnda iþ yapmamýzý saðlayan metotlar olmaktadýr.
	
	//Entity'nin ilk iki özellðini kullandýk!!
	
	@Entity
	@Table(name = "EmployeeTable")
	//Varsayýlan olarak Veritabanýndaki tablo ismi ile sýnýf ismi ayný olmak zorunda..
	//Tablo ismini deðiþtirmak için @Table annotation'larýndan yararlanýrýz.
	
	

@NamedQuery(name = "Employee.getAll", query = "Select e from Employee e")

@NamedQueries( {
		@NamedQuery(name = "Employee.getEmployeeName", query = "Select e.name from Employee e"),
		@NamedQuery(name = "Employee.getEmployeeSurname", query = "Select e.surname from Employee e")
		}
		)
// verimlilik noktasinda iyi
	public class Employee {
		
		@Id 
			//Annotation'larý property yada instance variable üzerine koyabiliriz.
			//bununla birlikte getter metotlar üzerine de koyabiliriz.
			//setter üzerine koymak etkisizdir.
		
		
		//Basic gösterimi
			//@GeneratedValue(strategy = GenerationType.AUTO)
		 
				//primary key üretmek için @GeneretedValue annotation'ýný kullanabiliriz.
				//Auto
				//Table
				//Sequence
				//Identity
				
		//Basic gösterim
			//@GeneratedValue(strategy = GenerationType.TABLE)
		
		/*
		 
		Ýlgili entity tablosunu ayýrmak için 
			@TableGenerator(name = "EMP_SEQ")
			@GeneratedValue(generator = "EMP_SEQ")			
		
		*/
		/*
		//YENÝ BÝR TABLO OLUÞTURMAK ÝÇÝN
			@TableGenerator(name = "EMP_GEN_DETAILS",
				table = "KEY_GEN",
				pkColumnName = "id_name",
				valueColumnName = "COUNT",
				initialValue = 200
						)
			@GeneratedValue(generator = "EMP_GEN_DETAILS")
			
		*/
		
		
		/* 
		 // create sequence sequenceName;
			
			TEST Oracle!
		 		@SequenceGenerator(name="generatorName" , sequenceName="sequenceName")
				@GeneratedValue(generator="generatorName")
	 		@GeneratedValue(strategy=GenerationType.SEQUENCE)
	 		
	 		*/
	
		@GeneratedValue(strategy = GenerationType.SEQUENCE)
		
		
		//column/kolon isimlerini deðiþtirmek için @Column annotation'ýný kullanýrýz.
		//Hangi kolon ismini deðiþtirmek istiyorsak o özelliðin hemen üzerinde deðiþiklik yaparýz..
			@Column(name = "emp_id")
			private int id;
			private String name;
	
			@Column(name = "emp_salary")
			private String surname;
			private int salary;
			
			
			@Enumerated(EnumType.STRING)  	//Varsayýlan olarak ordinaldir.String dersek String deðerlerini döner.
			private EmployeeType employeeType;
			
			
			@Temporal(TemporalType.DATE)	//TIMESTAMP dersem; þuan ki zamaný olduðu gibi olacaktýr.
			private Date startDate;
			
			
			
			@Lob
			private byte[] picture;
			
			
			@ManyToOne
			@JoinColumn(name = "emp_dept_id") 	//Ýliþkili veritabanlarýnda Kolon ismini deðiþtirmek için..
			private Department department;
			
			
			@OneToOne
				//Hibernate JPA implemantasyonu icin unique olmazsa HATA veriyor.
				//EclipseLink implementasyonu icin unique olmazsa hata yok. Bunun için aþaðýdaki fonk. kullanmalýyýz..
			@JoinColumn(name="ps_id", unique = true)
			private ParkingSpace parkingSpace;
			
			
			
			//default constructor gerekli!!! deglerasyonlarý yapmýþ olduk. 
			public Employee() {
				super();
			}
		
			/*
				 id otomatik tanýmladýðým için bu constructor 'i kullanmadým.
				 
				public Employee(int id, String name, String surname, int salary) {
					super();
					this.id = id;
					this.name = name;
					this.surname = surname;
					this.salary = salary;
				}
			*/
			
			public Employee(String name, String surname, int salary) {
				super();
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
		
			public EmployeeType getEmployeeType() {
				return employeeType;
			}
		
			public void setEmployeeType(EmployeeType employeeType) {
				this.employeeType = employeeType;
			}
		
			
			public Date getStartDate() {
				return startDate;
			}
		
			public void setStartDate(Date startDate) {
				this.startDate = startDate;
			}
		
			public byte[] getPicture() {
				return picture;
			}
		
			public void setPicture(byte[] picture) {
				this.picture = picture;
			}
		
			public Department getDepartment() {
				return department;
			}
	
			public void setDepartment(Department department) {
				this.department = department;
			}
	
			public ParkingSpace getParkingSpace() {
				return parkingSpace;
			}

			public void setParkingSpace(ParkingSpace parkingSpace) {
				this.parkingSpace = parkingSpace;
			}

			@Override
			public String toString() {
				return "Employee [id=" + id + ", name=" + name + ", surname=" + surname + ", salary=" + salary
						+ ", employeeType=" + employeeType + ", startDate=" + startDate + ", picture="
						+ Arrays.toString(picture) + "]";
			}
		
	
	}
