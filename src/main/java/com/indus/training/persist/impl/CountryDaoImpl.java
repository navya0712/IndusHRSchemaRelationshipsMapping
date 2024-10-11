package com.indus.training.persist.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.indus.training.persist.dao.ICountryDao;
import com.indus.training.persist.entity.Country;
import com.indus.training.persist.exceptions.CountryDaoException;
import com.indus.training.persist.util.HibernateUtil;

/**
 * Implementation of the {@code ICountryDao} interface. Provides implementation
 * methods for adding, retrieving, updating, and deleting countries from the
 * database.
 */
public class CountryDaoImpl implements ICountryDao {

	/**
	 * Adds a new country to the database.
	 * 
	 * @param countryObj The country to add.
	 * @return True if the operation was successful, false otherwise.
	 * @throws CountryDaoException If an error occurs during the operation.
	 */
	@Override
	public Boolean insertCountry(Country countryObj) throws CountryDaoException {
		if (countryObj == null) {
			throw new CountryDaoException("Country Object Cannot be null");
		}
		Session session = null;
		Boolean isInserted = false;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.getTransaction().begin();
			Country existingCountry = (Country) session.get(Country.class, countryObj.getCountryId());
			if (existingCountry == null) {
				session.save(countryObj);
				isInserted = true;
			}
			session.getTransaction().commit();
		} catch (HibernateException e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			throw new CountryDaoException("An error Occured while Saving Country Object to database");
		}
		return isInserted;
	}

	/**
	 * Retrieves a country from the database by its ID.
	 * 
	 * @param countryId The ID of the country to retrieve.
	 * @return The country with the specified ID, or null if not found.
	 * @throws CountryDaoException If an error occurs during the operation.
	 */
	@Override
	public Country fetchCountryById(String countryId) throws CountryDaoException {
		Session session = null;
		Country countryObj = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.getTransaction().begin();
			countryObj = (Country) session.get(Country.class, countryId);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			throw new CountryDaoException("An error occured while fetching Country Details");
		}
		return countryObj;
	}

	/**
	 * Deletes a country from the database by its ID.
	 * 
	 * @param countryId The ID of the country to delete.
	 * @return True if the deletion was successful, false otherwise.
	 * @throws CountryDaoException If an error occurs during the operation.
	 */
	@Override
	public Boolean deleteCountryById(String countryId) throws CountryDaoException {
		Session session = null;
		Boolean isDeleted = false;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.getTransaction().begin();
			Country existingCountry = (Country) session.get(Country.class, countryId);
			if (existingCountry != null) {
				session.delete(existingCountry);
				isDeleted = true;
				session.getTransaction().commit();
			}
		} catch (HibernateException e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			throw new CountryDaoException("An error occurred while deleting the Country Object");

		}

		return isDeleted;
	}

	/**
	 * Updates the country details for the given country ID.
	 *
	 * This method finds the country by its ID, updates its name and region ID with the 
	 * provided values, and commits the changes to the database.</p>
	 *
	 * @param countryId The ID of the country to update.
	 * @param country The updated country details.
	 * @return {@code true} if the country was successfully updated, {@code false} if no country was found.
	 * @throws CountryDaoException If an error occurs during the update process.
	 */
	@Override
	public Boolean updateCountryById(String countryId, Country country) throws CountryDaoException {
		Session session = null;
		Boolean isUpdated = false;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.getTransaction().begin();
			Country existingCountry = (Country) session.get(Country.class, countryId);
			if (existingCountry != null) {
				existingCountry.setCountryId(countryId);
				existingCountry.setCountryName(country.getCountryName());
				existingCountry.setRegion(country.getRegion());
				session.update(existingCountry);
				isUpdated = true;
			}
			session.getTransaction().commit();
		} catch (HibernateException e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			throw new CountryDaoException("An error occured while Updating CountryName Details");

		}
		return isUpdated;
	}

}
