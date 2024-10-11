package com.indus.training.persist.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Name Null? Type ----------------------------------------- --------
 * ---------------------------- REGION_ID NOT NULL NUMBER REGION_NAME
 * VARCHAR2(25) Represents a Region entity
 */
@Entity
@Table(name = "REGIONS")
public class Region {
	@Id
	@Column(name="region_id")
	private Integer regionId;

	@Column(name = "REGION_NAME")
	private String regionName;


	/**
	 * Default constructor for Region class
	 */
	public Region() {

	}

	/**
	 * Gets the unique identifier for the region.
	 * 
	 * @return The region ID.
	 */
	public Integer getRegionId() {
		return regionId;
	}

	/**
	 * Sets the unique identifier for the region.
	 * 
	 * @param regionId The new region ID.
	 */
	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	/**
	 * Gets the name of the region.
	 * 
	 * @return The region name.
	 */
	public String getRegionName() {
		return regionName;
	}

	/**
	 * Sets the name of the region.
	 * 
	 * @param regionName The new region name.
	 */
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	
}
