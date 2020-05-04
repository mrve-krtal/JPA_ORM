package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Department {
	
		@Id
		@GeneratedValue(strategy = GenerationType.TABLE)
		private int id;
	
		private String name;
	
		//No-arg constructor GEREKLÝ!!
		public Department() {
			super();
		}

		public Department(String name) {
			super();
			this.name = name;
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

		@Override
		public String toString() {
			return "Department [id=" + id + ", name=" + name + "]";
		}
		
	
}
