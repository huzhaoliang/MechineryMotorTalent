package com.mmt.entity;

import java.sql.Clob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 求职指导
 * @author hp
 *
 */
@Entity
@Table(name="job_type")
public class JobGuide {
	@Id
	@GeneratedValue
	@Column(name = "id", nullable = false)
	private Long id;
	private String title;
	private Clob content;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
	private SysAdminUser user;
	private Date publishTime;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the content
	 */
	public Clob getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(Clob content) {
		this.content = content;
	}
	/**
	 * @return the user
	 */
	public SysAdminUser getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(SysAdminUser user) {
		this.user = user;
	}
	/**
	 * @return the publishTime
	 */
	public Date getPublishTime() {
		return publishTime;
	}
	/**
	 * @param publishTime the publishTime to set
	 */
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	
}
