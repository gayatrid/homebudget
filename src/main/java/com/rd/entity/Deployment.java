package com.rd.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/*CREATE TABLE DEPLOYMENT (
		COMPOSITE_NAME VARCHAR(50),
		PARTITION_ID INTEGER NOT NULL,
		RDF_ID INTEGER NOT NULL
	);*/
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "DEPLOYMENT")
public class Deployment {

	@Id
	@Column(name = "DEP_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;//

	/*@ManyToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name = "partition_Id")
	 private Partition Partition ;
	*/
	
	@Column(name = "partition_Id")
	private int partition;

	@Column(name = "composite_name")
	private String compositeName;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "RDF_ID")
	private ReleaseDetail releaseDetail;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ReleaseDetail getReleaseDetail() {
		return releaseDetail;
	}

	public void setReleaseDetail(ReleaseDetail releaseDetail) {
		this.releaseDetail = releaseDetail;
	}

	public int getPartition() {
		return partition;
	}

	public void setPartition(int partition) {
		this.partition = partition;
	}

	public String getCompositeName() {
		return compositeName;
	}

	public void setCompositeName(String compositeName) {
		this.compositeName = compositeName;
	}

}
