package com.accommodation.repository;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.accommodation.model.Room;
import com.accommodation.service.HibernateService;

public class RoomRepository implements Repository<Room>{

	@Override
	public Room save(Room entity) {
		try{
			Session databaseSession = HibernateService.getSessionFactory().openSession();
			databaseSession.beginTransaction();
			databaseSession.saveOrUpdate(entity);
			databaseSession.save(entity);
			databaseSession.getTransaction().commit();
			databaseSession.close();
			}catch(HibernateException ex) {
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
	
	public List<Room> findEmpltyRooms(){
		Session databaseSession = HibernateService.getSessionFactory().openSession();
		databaseSession.beginTransaction();
		Query query=databaseSession.createQuery("from com.scheduler.backend.model.Room R where R.studentsNr = 0");
		@SuppressWarnings("unchecked")
		List<Room> result =query.list();
		databaseSession.close();
		return result;
	}
	
	public List<Room> findNotFullRooms(){
		Session databaseSession = HibernateService.getSessionFactory().openSession();
		databaseSession.beginTransaction();
		@SuppressWarnings("unchecked")
		List <Room> result=(List<Room>) databaseSession.createCriteria(Room.class).add(Restrictions.ne("studentsNr", new Integer(4))).list();
		return result;
	}
	
	public DefaultTableModel roomToTableModel( List<Room> rooms ) {
		String[] columns= {"RoomNumber","NrStudents","Orientation"};
		String[][] tuple = new String[rooms.size()][columns.length] ;
		int i=0;
		for(Room room:rooms){
			tuple[i][0] = room.getRoomNumber().toString();
			tuple[i][1] = room.getStudentsNumber().toString();
			tuple[i][2] = room.getOrientation();
			i++;
		}
		DefaultTableModel model = new DefaultTableModel(tuple,columns);		
		return model;
	}

	@Override
	public List<Room> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Room entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	

}