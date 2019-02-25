package com.mmt.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="enterprise_user")
public class EnterpriseUser {
	
	@Id
	@GeneratedValue
	@Column(name = "id", nullable = false)
	private Long id;
	private String name;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
	private City city;
	private String locate;
	private String description;
	private String logoPath;
	private String contact;
	private String telephone;
	private String postCode;
	private String email;
	private String webSite;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Job> jobs;
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
	 * @return the city
	 */
	public City getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(City city) {
		this.city = city;
	}
	/**
	 * @return the locate
	 */
	public String getLocate() {
		return locate;
	}
	/**
	 * @param locate the locate to set
	 */
	public void setLocate(String locate) {
		this.locate = locate;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the logoPath
	 */
	public String getLogoPath() {
		return logoPath;
	}
	/**
	 * @param logoPath the logoPath to set
	 */
	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}
	/**
	 * @return the contact
	 */
	public String getContact() {
		return contact;
	}
	/**
	 * @param contact the contact to set
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}
	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}
	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	/**
	 * @return the postCode
	 */
	public String getPostCode() {
		return postCode;
	}
	/**
	 * @param postCode the postCode to set
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
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
	 * @return the webSite
	 */
	public String getWebSite() {
		return webSite;
	}
	/**
	 * @param webSite the webSite to set
	 */
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}
	/**
	 * @return the jobs
	 */
	public List<Job> getJobs() {
		return jobs;
	}
	/**
	 * @param jobs the jobs to set
	 */
	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}
	
}
