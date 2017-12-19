package com.rd.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/*CREATE TABLE RELEASE_DETAILS (
		RD_ID INTEGER NOT NULL,
		RELEASE_TYPE VARCHAR(5),
		TICKET_NUMBER INTEGER,
		RELEASE_DATE DATE,
		RELEASE_DESC VARCHAR(50)
	);
*/
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "RELEASE_DETAILS")
public class ReleaseDetail {

	@Id
	@Column(name = "RD_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;// RD_IDll

	@Column(name = "TICKET_NUMBER")
	private Integer ticketNumber;

	@Column(name = "RELEASE_TYPE")
	private String ticketType;//

	@Column(name = "RELEASE_DATE")
	private Date releaseDate;

	@Column(name = "RELEASE_DESC")
	private String releaseDescription;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "releaseDetail", orphanRemoval = true)
	Set<Deployment> deployments;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "RDF_ID")
	Set<JMSObject> jmsObjects;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "RDF_ID")
	Set<DataSourceObject> dataSourceObjects;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "RDF_ID")
	Set<CronJob> cronJobs;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "RDF_ID")
	Set<MDSObject> mdsObjects;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "RDF_ID")
	Set<FTPAdapterObject> ftpAdapterObject;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTicketType() {
		return ticketType;
	}

	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getReleaseDescription() {
		return releaseDescription;
	}

	public void setReleaseDescription(String releaseDescription) {
		this.releaseDescription = releaseDescription;
	}

	public Set<JMSObject> getJmsObjects() {
		return jmsObjects;
	}

	public void setJmsObjects(Set<JMSObject> jmsObjects) {
		this.jmsObjects = jmsObjects;
	}

	public Set<DataSourceObject> getDataSourceObjects() {
		return dataSourceObjects;
	}

	public void setDataSourceObjects(Set<DataSourceObject> dataSourceObjects) {
		this.dataSourceObjects = dataSourceObjects;
	}

	public Set<MDSObject> getMdsObjects() {
		return mdsObjects;
	}

	public void setMdsObjects(Set<MDSObject> mdsObjects) {
		this.mdsObjects = mdsObjects;
	}

	public Set<FTPAdapterObject> getFtpAdapterObject() {
		return ftpAdapterObject;
	}

	public void setFtpAdapterObject(Set<FTPAdapterObject> ftpAdapterObject) {
		this.ftpAdapterObject = ftpAdapterObject;
	}

	public Set<CronJob> getCronJobs() {
		return cronJobs;
	}

	public void setCronJobs(Set<CronJob> cronJobs) {
		this.cronJobs = cronJobs;
	}

	public Set<Deployment> getDeployments() {
		return deployments;
	}

	public void setDeployments(Set<Deployment> deployments) {
		this.deployments = deployments;
	}

	public int getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(Integer ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	/*
	 * @Override public String toString() { return "ReleaseDetails [id=" + id +
	 * ", ticketType=" + ticketType + ", releaseDate=" + releaseDate +
	 * ", releaseDescription=" + releaseDescription + ", deployments=" +
	 * deployments + ", jmsObjects=" + jmsObjects + ", dataSourceObjects=" +
	 * dataSourceObjects + ", mdsObjects=" + mdsObjects +
	 * ", ftpAdapterObjectPs=" + ftpAdapterObject + ", cronJobs=" + cronJobs +
	 * "]"; }
	 */

}
