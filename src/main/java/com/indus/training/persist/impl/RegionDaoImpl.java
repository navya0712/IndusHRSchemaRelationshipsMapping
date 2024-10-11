package com.indus.training.persist.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.indus.training.persist.dao.IRegionDao;
import com.indus.training.persist.entity.Region;
import com.indus.training.persist.exceptions.RegionDaoException;
import com.indus.training.persist.util.HibernateUtil;

public class RegionDaoImpl implements IRegionDao {

	@Override
	public Boolean insertRegion(Region regionObj) throws RegionDaoException {
		if (regionObj == null) {
			throw new RegionDaoException("Region Object Cannot be null");
		}
		Session session = null;
		boolean isInserted = false;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.getTransaction().begin();
			Region existingRegion = (Region) session.get(Region.class, regionObj.getRegionId());
			if (existingRegion == null) {
				session.save(regionObj);
				isInserted = true;
			}
			session.getTransaction().commit();
		} catch (HibernateException e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			System.out.println(e);
			throw new RegionDaoException("An error Occured while Saving Region Object to database");

		}
		return isInserted;
	}

	@Override
	public Region fetchRegionById(Integer regionId) throws RegionDaoException {
		Session session = null;
		Region regionObj = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.getTransaction().begin();
			regionObj = (Region) session.get(Region.class, regionId);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			throw new RegionDaoException("An error occured while fetching Region Details");
		}
		return regionObj;
	}

	@Override
	public Boolean updateRegionById(Integer regionId, Region region) throws RegionDaoException {
		Session session = null;
		boolean isUpdated = false;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.getTransaction().begin();
			Region existingRegion = (Region) session.get(Region.class, regionId);
			if (existingRegion != null) {
				existingRegion.setRegionName(region.getRegionName());
				session.update(existingRegion);
				isUpdated = true;
			}
			session.getTransaction().commit();
		} catch (HibernateException e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			throw new RegionDaoException("An error occured while Updating Region Name");

		}
		return isUpdated;
	}

	@Override
	public Boolean deleteRegionById(Integer regionId) throws RegionDaoException {
		Session session = null;
		Boolean isDeleted = false;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.getTransaction().begin();
			Region existingRegion = (Region) session.get(Region.class, regionId);
			if (existingRegion != null) {
				session.delete(existingRegion);
				isDeleted = true;
				session.getTransaction().commit();
			}
		} catch (HibernateException e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			throw new RegionDaoException("An error occurred while deleting the Region Object");

		}

		return isDeleted;
	}

}
