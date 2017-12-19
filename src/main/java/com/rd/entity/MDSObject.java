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

/*CREATE TABLE MDS (
		MDS_ID INTEGER NOT NULL,
		RDF_ID INTEGER NOT NULL,
		SERVERLOCATION VARCHAR(150),
		TARGET VARCHAR(100)
	);*/
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "MDS")
public class MDSObject {
	@Id
	@Column(name = "MDS_ID")
	@GeneratedValue
	private int id;

	@Column(name = "SERVERLOCATION")
	private String serverLocation;

	@Column(name = "TARGET")
	private String target;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RDF_ID", nullable = false)
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

	public String getServerLocation() {
		return serverLocation;
	}

	public void setServerLocation(String serverLocation) {
		this.serverLocation = serverLocation;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

}
