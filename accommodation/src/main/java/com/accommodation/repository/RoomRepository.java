package com.accommodation.repository;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.accommodation.model.Room;
import com.accommodation.service.HibernateService;

public class RoomRepository implements Repository<Room> {

	@Override
	public Room save(Room entity) {
		try {
			Session databaseSession = HibernateService.getSessionFactory().openSession();
			databaseSession.beginTransaction();
			databaseSession.saveOrUpdate(entity);
			databaseSession.save(entity);
			databaseSession.getTransaction().commit();
			databaseSession.close();
		} catch (HibernateException ex) {
			ex.printStackTrace();
		}
		return entity;
	}

	@Override
	public Room findById(Long id) {
		Session databaseSession = HibernateService.getSessionFactory().openSession();
		Room found = (Room) databaseSession.get(Room.class, id);
		databaseSession.close();
		return found;
	}

	public List<Room> findEmptyRooms() {
		Session databaseSession = HibernateService.getSessionFactory().openSession();
		Query query = databaseSession.createQuery("from com.accommodation.model.Room R where R.studentsNumber = 0");
		@SuppressWarnings("unchecked")
		List<Room> result = query.list();
		databaseSession.close();
		return result;
	}

	public List<Room> findNotFullRooms() {// nu se stie inca
		Session databaseSession = HibernateService.getSessionFactory().openSession();
		@SuppressWarnings({ "unchecked" })
		List<Room> result = (List<Room>) databaseSession.createCriteria(Room.class)
				.add(Restrictions.ne("studentsNumber", 4)).list();//posibila problema
		databaseSession.close();
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Room> findAll() {
		Session databaseSession = HibernateService.getSessionFactory().openSession();
		Query query = databaseSession.createQuery("from com.accommodation.model.Room C");
		List<Room> result = query.list();
		databaseSession.close();
		return result;
	}

	@Override
	public boolean delete(Room entity) {
		try {
			Session databaseSession = HibernateService.getSessionFactory().openSession();
			databaseSession.beginTransaction();
			databaseSession.delete(entity);
			databaseSession.getTransaction().commit();
			databaseSession.close();

			return true;
		} catch (HibernateException e) {

			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteById(Long id) {
		Session databaseSession = HibernateService.getSessionFactory().openSession();
		databaseSession.beginTransaction();
		Room found = (Room) databaseSession.get(Room.class, id);
		if (found != null) {
			databaseSession.delete(found);
			databaseSession.getTransaction().commit();
		}
		databaseSession.close();
		if (found != null)
			return true;
		else
			return false;
	}

}