package com.indus.training.persist.dao;

import com.indus.training.persist.entity.Country;
import com.indus.training.persist.exceptions.CountryDaoException;

/**
 * Interface for CRUD operations related to Country entities. Provides methods
 * for adding, retrieving, updating, and deleting countries.
 */
public interface ICountryDao {

	/**
	 * Adds a new country to the database.
	 * 
	 * @param countryObj The country to add.
	 * @return True if the operation was successful, false otherwise.
	 * @throws CountryDaoException If an error occurs during the operation.
	 */
	public Boolean insertCountry(Country country) throws CountryDaoException;

	/**
	 * Retrieves a country from the database by its ID.
	 * 
	 * @param countryId The ID of the country to retrieve.
	 * @return The country with the specified ID, or null if not found.
	 * @throws CountryDaoException If an error occurs during the operation.
	 */
	public Country fetchCountryById(String countryId) throws CountryDaoException;

	/**
	 * Updates the name of a country identified by its ID.
	 * 
	 * @param countryId   The ID of the country to update.
	 * @param countryName The new name for the country.
	 * @return True if the update was successful, false otherwise.
	 * @throws CountryDaoException If an error occurs during the operation.
	 */
	public Boolean updateCountryById(String countryId, Country country) throws CountryDaoException;

	/**
	 * Deletes a country from the database by its ID.
	 * 
	 * @param countryId The ID of the country to delete.
	 * @return True if the deletion was successful, false otherwise.
	 * @throws CountryDaoException If an error occurs during the operation.
	 */
	public Boolean deleteCountryById(String countryId) throws CountryDaoException;

}
