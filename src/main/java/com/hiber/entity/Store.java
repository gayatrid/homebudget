
package com.hiber.entity;




	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.Id;
	import javax.persistence.Table;



	/*
	 *CREATE TABLE  `homebudget`.`stores` (
	  `ID` int(11) NOT NULL AUTO_INCREMENT,
	  `store_Name` date NOT NULL,
	   PRIMARY KEY (`ID`)
	) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
	 * */
	@Entity
	@Table(name="stores")
	public class Store {
		
		
		@Id
		@Column(name="ID")
		@GeneratedValue
		private int id;
		
		
		@Column(name="store_Name")
		private String storeName ;


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getStoreName() {
			return storeName;
		}


		public void setStoreName(String storeName) {
			this.storeName = storeName;
		}


		@Override
		public String toString() {
			return "Spending [id=" + id + ", storeName=" + storeName + "]";
		}
		
		

}
