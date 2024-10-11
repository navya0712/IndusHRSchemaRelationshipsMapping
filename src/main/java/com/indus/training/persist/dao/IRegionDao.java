package com.indus.training.persist.dao;

import com.indus.training.persist.entity.Region;
import com.indus.training.persist.exceptions.RegionDaoException;

/**
 * Interface for CRUD operations related to the Region entity.
 */
public interface IRegionDao {
	/**
	 * Inserts a new region into the data store.
	 * 
	 * @param regionObj The region object to be inserted.
	 * @return True if the operation was successful, false otherwise.
	 * @throws RegionDaoException If an error occurs during the operation.
	 */
	public Boolean insertRegion(Region region) throws RegionDaoException;

	/**
	 * Fetches a region by its unique identifier.
	 * 
	 * @param regionId The unique identifier of the region to be fetched.
	 * @return The region object with the specified ID.
	 * @throws RegionDaoException If an error occurs during the operation.
	 */
	public Region fetchRegionById(Integer regionId) throws RegionDaoException;

	/**
	 * Updates the name of a region identified by its unique identifier.
	 * 
	 * @param regionId   The unique identifier of the region to be updated.
	 * @param regionName The new name for the region.
	 * @return True if the operation was successful, false otherwise.
	 * @throws RegionDaoException If an error occurs during the operation.
	 */
	public Boolean updateRegionById(Integer regionId, Region region) throws RegionDaoException;

	/**
	 * Deletes a region by its unique identifier.
	 * 
	 * @param regionId The unique identifier of the region to be deleted.
	 * @return True if the operation was successful, false otherwise.
	 * @throws RegionDaoException If an error occurs during the operation.
	 */
	public Boolean deleteRegionById(Integer regionId) throws RegionDaoException;
}
