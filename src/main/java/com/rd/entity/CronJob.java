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

/*CREATE TABLE CRONJOB (
		CRONJOB_ID INTEGER NOT NULL,
		RDF_ID INTEGER NOT NULL,
		DESCRIPTION VARCHAR(300)
	);
*/
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "CRONJOB")
public class CronJob {

	@Id
	@Column(name = "CRONJOB_ID")
	@GeneratedValue
	private int id;

	@Column(name = "DESCRIPTION")
	private String cronJob;

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

	public String getCronJob() {
		return cronJob;
	}

	public void setCronJob(String cronJob) {
		this.cronJob = cronJob;
	}

}
