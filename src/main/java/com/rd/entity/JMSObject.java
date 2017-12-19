package com.rd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/*CREATE TABLE JMS (
		JMS_ID INTEGER NOT NULL,
		RDF_ID INTEGER NOT NULL,
		JMSTYPE VARCHAR(3),
		JNDINAME VARCHAR(50),
		JMSNAME VARCHAR(40),
		CONNECTIONFACTORY VARCHAR(80),
		SUBDEPLOYMENT VARCHAR(50)
	);
*/
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "JMS")
public class JMSObject {

	@Id
	@Column(name = "JMS_ID")
	@GeneratedValue
	private int jmsId;

	@Column(name = "JMSTYPE")
	private String jmsType;

	@Column(name = "JNDINAME")
	private String jndiName;

	@Column(name = "JMSNAME")
	private String jmsName;

	@Column(name = "CONNECTIONFACTORY")
	private String connectionFactory;

	@Column(name = "SUBDEPLOYMENT")
	private String subDeployment;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RDF_ID", nullable = false)
	private ReleaseDetail releaseDetail;

	public ReleaseDetail getReleaseDetail() {
		return releaseDetail;
	}

	public void setReleaseDetail(ReleaseDetail releaseDetail) {
		this.releaseDetail = releaseDetail;
	}

	public String getJmsName() {
		return jmsName;
	}

	public void setJmsName(String jmsName) {
		this.jmsName = jmsName;
	}

	public String getJmsType() {
		return jmsType;
	}

	public void setJmsType(String jmsType) {
		this.jmsType = jmsType;
	}

	public String getJndiName() {
		return jndiName;
	}

	public void setJndiName(String jndiName) {
		this.jndiName = jndiName;
	}

	public String getConnectionFactory() {
		return connectionFactory;
	}

	public void setConnectionFactory(String connectionFactory) {
		this.connectionFactory = connectionFactory;
	}

	public String getSubDeployment() {
		return subDeployment;
	}

	public void setSubDeployment(String subDeployment) {
		this.subDeployment = subDeployment;
	}

	public void setJmsId(int jmsId) {
		this.jmsId = jmsId;
	}

	public int getJmsId() {
		return jmsId;
	}

	@Override
	public String toString() {
		return "JMSObject [jmsId=" + jmsId + ", jmsType=" + jmsType + ", jndiName=" + jndiName + ", jmsName=" + jmsName
				+ ", connectionFactory=" + connectionFactory + ", subDeployment=" + subDeployment + ", releaseDetail="
				+ releaseDetail + "]";
	}

}
