package com.mmt.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
/**
 * 个人用户
 * @author hp
 *
 */
@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue
	@Column(name = "id", nullable = false)
	private Long id;
	@Column(name = "email", nullable = false)
	private String email;
	private String password;
	private String name;
	private String birth; // like 1990-10-01
	private Long gender;
	private Long education;
	private Long experience;
	private Long destCityId;
	private String resumePath;
	private String refreshTime;
	// to be added: 投递职位，收藏职位
	private List<Job> postJobs;
	private List<Job> collectJobs;
	
	/**
	 * @return the refreshTime
	 */
	public String getRefreshTime() {
		return refreshTime;
	}
	/**
	 * @param refreshTime the refreshTime to set
	 */
	public void setRefreshTime(String refreshTime) {
		this.refreshTime = refreshTime;
	}
	private Integer status;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the birth
	 */
	public String getBirth() {
		return birth;
	}
	/**
	 * @param birth the birth to set
	 */
	public void setBirth(String birth) {
		this.birth = birth;
	}
	
	/**
	 * @return the gender
	 */
	public Long getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(Long gender) {
		this.gender = gender;
	}
	/**
	 * @return the education
	 */
	public Long getEducation() {
		return education;
	}
	/**
	 * @param education the education to set
	 */
	public void setEducation(Long education) {
		this.education = education;
	}
	/**
	 * @return the experience
	 */
	public Long getExperience() {
		return experience;
	}
	/**
	 * @param experience the experience to set
	 */
	public void setExperience(Long experience) {
		this.experience = experience;
	}
	
	/**
	 * @return the destCityId
	 */
	public Long getDestCityId() {
		return destCityId;
	}
	/**
	 * @param destCityId the destCityId to set
	 */
	public void setDestCityId(Long destCityId) {
		this.destCityId = destCityId;
	}
	/**
	 * @return the resumePath
	 */
	public String getResumePath() {
		return resumePath;
	}
	/**
	 * @param resumePath the resumePath to set
	 */
	public void setResumePath(String resumePath) {
		this.resumePath = resumePath;
	}
	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * @return the postJobs
	 */
	public List<Job> getPostJobs() {
		return postJobs;
	}
	/**
	 * @param postJobs the postJobs to set
	 */
	@ManyToMany(cascade = {
			CascadeType.PERSIST,
	        CascadeType.MERGE
	    })
    @JoinTable(name = "post_user_job",
    	joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "job_id")
    )
	public void setPostJobs(List<Job> postJobs) {
		this.postJobs = postJobs;
	}
	/**
	 * @return the collectJobs
	 */
	public List<Job> getCollectJobs() {
		return collectJobs;
	}
	/**
	 * @param collectJobs the collectJobs to set
	 */
	@ManyToMany(cascade = {
			CascadeType.PERSIST,
	        CascadeType.MERGE
	    })
    @JoinTable(name = "collect_user_job",
    	joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "job_id")
    )
	public void setCollectJobs(List<Job> collectJobs) {
		this.collectJobs = collectJobs;
	}
	
}
