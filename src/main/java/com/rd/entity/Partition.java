package com.rd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/*create table partition(id INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
 * description VARCHAR (30),CONSTRAINT PART_ID PRIMARY KEY (id));
*/
@Entity
@Table(name = "partition")
public class Partition {
	@Id
	@Column(name = "id")
	@GeneratedValue
	private int id;
	
	@Column(name = "description")
	private String description;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
