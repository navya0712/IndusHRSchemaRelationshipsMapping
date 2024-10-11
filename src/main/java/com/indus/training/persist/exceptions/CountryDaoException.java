package com.indus.training.persist.exceptions;

/**
 * Custom exception class for handling errors related to {@code Country} data
 * access operations. This exception is thrown to indicate that an error has
 * occurred in the while performing operations related to {@code Country}
 * entities.
 * 
 */
public class CountryDaoException extends Exception {

	/**
	 * Constructs a new {@code CountryDaoException} with the specified detail
	 * message.
	 * 
	 * @param msg the detail message
	 */
	public CountryDaoException(String msg) {
		super(msg);
	}
}
