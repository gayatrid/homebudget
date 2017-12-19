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

/*CREATE TABLE FTP_ADAPTER (
		FTPADP_ID INTEGER NOT NULL,
		RDF_ID INTEGER NOT NULL,
		JNDI VARCHAR(30),
		CFI VARCHAR(50),
		CI VARCHAR(40),
		CP VARCHAR(20),
		HOST VARCHAR(50),
		USER_NAME VARCHAR(50),
		PORT VARCHAR(50),
		PASSWORD VARCHAR(50),
		SFTP VARCHAR(50)
	);*/
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "FTP_ADAPTER")
public class FTPAdapterObject {

	@Id
	@Column(name = "FTPADP_ID")
	@GeneratedValue
	private int id;

	@Column(name = "JNDI")
	private String ftpJNDI;

	@Column(name = "CFI")
	private String ftpCFI;

	@Column(name = "CI")
	private String ftpCI;

	@Column(name = "CP")
	private String ftpCP;

	@Column(name = "HOST")
	private String host;

	@Column(name = "PORT")
	private String port;

	@Column(name = "USER_NAME")
	private String user;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "SFTP")
	private String sftp;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RDF_ID", nullable = false)
	private ReleaseDetail releaseDetail;

	public ReleaseDetail getReleaseDetail() {
		return releaseDetail;
	}

	public void setReleaseDetail(ReleaseDetail releaseDetail) {
		this.releaseDetail = releaseDetail;
	}

	public String getFtpJNDI() {
		return ftpJNDI;
	}

	public void setFtpJNDI(String ftpJNDI) {
		this.ftpJNDI = ftpJNDI;
	}

	public String getFtpCFI() {
		return ftpCFI;
	}

	public void setFtpCFI(String ftpCFI) {
		this.ftpCFI = ftpCFI;
	}

	public String getFtpCI() {
		return ftpCI;
	}

	public void setFtpCI(String ftpCI) {
		this.ftpCI = ftpCI;
	}

	public String getFtpCP() {
		return ftpCP;
	}

	public void setFtpCP(String ftpCP) {
		this.ftpCP = ftpCP;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSftp() {
		return sftp;
	}

	public void setSftp(String sftp) {
		this.sftp = sftp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
