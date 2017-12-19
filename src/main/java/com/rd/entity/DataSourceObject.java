package com.rd.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/*CREATE TABLE DATA_SOURCE (
		DS_ID INTEGER NOT NULL,
		RDF_ID INTEGER NOT NULL,
		DSNAME VARCHAR(3),
		DSJNDI VARCHAR(50),
		DBHOST VARCHAR(40),
		DBPORT VARCHAR(20),
		DBSERVERNAME VARCHAR(50),
		USERNAME VARCHAR(50),
		PASSWORD VARCHAR(50)
	);
*/
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "DATA_SOURCE")
public class DataSourceObject {

	@Id
	@Column(name = "DS_ID")
	@GeneratedValue
	private int id;

	@Column(name = "DSNAME")
	private String dataSourceName;

	@Column(name = "DSJNDI")
	private String dataSourceJNDI;

	@Column(name = "DBHOST")
	private String dataBaseHost;

	@Column(name = "DBPORT")
	private String dataBasePort;

	@Column(name = "DBSERVERNAME")
	private String dataBaseServerName;

	@Column(name = "USERNAME")
	private String userName;

	@Column(name = "PASSWORD")
	private String password;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "RDF_ID")
	private ReleaseDetail releaseDetail;

	public ReleaseDetail getReleaseDetail() {
		return releaseDetail;
	}

	public void setReleaseDetail(ReleaseDetail releaseDetail) {
		this.releaseDetail = releaseDetail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDataSourceName() {
		return dataSourceName;
	}

	public void setDataSourceName(String dataSourceName) {
		this.dataSourceName = dataSourceName;
	}

	public String getDataSourceJNDI() {
		return dataSourceJNDI;
	}

	public void setDataSourceJNDI(String dataSourceJNDI) {
		this.dataSourceJNDI = dataSourceJNDI;
	}

	public String getDataBaseHost() {
		return dataBaseHost;
	}

	public void setDataBaseHost(String dataBaseHost) {
		this.dataBaseHost = dataBaseHost;
	}

	public String getDataBasePort() {
		return dataBasePort;
	}

	public void setDataBasePort(String dataBasePort) {
		this.dataBasePort = dataBasePort;
	}

	public String getDataBaseServerName() {
		return dataBaseServerName;
	}

	public void setDataBaseServerName(String dataBaseServerName) {
		this.dataBaseServerName = dataBaseServerName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
