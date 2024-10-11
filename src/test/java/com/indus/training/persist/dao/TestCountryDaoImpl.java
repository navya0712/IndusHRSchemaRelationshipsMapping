package com.indus.training.persist.dao;

import com.indus.training.persist.entity.Country;
import com.indus.training.persist.entity.Region;
import com.indus.training.persist.impl.CountryDaoImpl;
import com.indus.training.persist.impl.RegionDaoImpl;

import junit.framework.TestCase;

public class TestCountryDaoImpl extends TestCase {

	private CountryDaoImpl ctryDaoImplObj;
	private RegionDaoImpl regionDaoImplObj;

	@Override
	protected void setUp() throws Exception {
		ctryDaoImplObj = new CountryDaoImpl();
		regionDaoImplObj = new RegionDaoImpl();
	}

	@Override
	protected void tearDown() throws Exception {
		ctryDaoImplObj = null;
		regionDaoImplObj = null;
	}

	public void testInsertCountry() {
		try {
			Region regionObj = new Region();
			regionObj.setRegionId(10);
			regionObj.setRegionName("Asia");
			regionDaoImplObj.insertRegion(regionObj);
			Country countryObj = new Country();
			countryObj.setCountryId("IN");
			countryObj.setCountryName("INDIA");
			countryObj.setRegion(regionObj);

			boolean isInserted = ctryDaoImplObj.insertCountry(countryObj);
			assertTrue("Country should be inserted successfully", isInserted);
		} catch (Exception e) {
			fail("Exception thrown during testInsertCountry: " + e.getMessage());
		}
	}

	public void testFetchCountryById() {
		try {
			Country fetchedCountry = ctryDaoImplObj.fetchCountryById("IN");
			assertNotNull("Country should not be null", fetchedCountry);
			assertEquals("Country ID should be 'IN'", "IN", fetchedCountry.getCountryId());
		} catch (Exception e) {
			fail("Exception thrown during testFetchCountryById: " + e.getMessage());
		}
	}

//
	public void testUpdateCountryById() {
		try {
			Region regionObj = new Region();
			regionObj.setRegionId(10);
			regionObj.setRegionName("Asia");
			regionDaoImplObj.insertRegion(regionObj);
			Country countryObj = new Country();
			countryObj.setCountryId("IN");
			countryObj.setCountryName("Bharat");
			countryObj.setRegion(regionObj);
			boolean isUpdated = ctryDaoImplObj.updateCountryById("IN", countryObj);
			assertTrue("Country name should be updated successfully", isUpdated);
			Country updatedCountry = ctryDaoImplObj.fetchCountryById("IN");
			assertEquals("Country name should be updated to 'Bharat'", "Bharat", updatedCountry.getCountryName());
		} catch (Exception e) {
			fail("Exception thrown during testUpdateCountryNameById: " + e.getMessage());
		}
	}

//	public void testDeleteCountryById() {
//		try {
//			boolean isDeleted = ctryDaoImplObj.deleteCountryById("IN");
//			assertTrue("Country should be deleted successfully", isDeleted);
//			Country deletedCountry = ctryDaoImplObj.fetchCountryById("IN");
//			assertNull("Deleted country should not exist", deletedCountry);
//		} catch (Exception e) {
//			fail("Exception thrown during testDeleteRegionById: " + e.getMessage());
//		}
//	}
}
