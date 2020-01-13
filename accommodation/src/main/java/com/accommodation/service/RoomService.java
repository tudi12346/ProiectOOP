package com.accommodation.service;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.accommodation.model.Room;
import com.accommodation.repository.RoomRepository;

public class RoomService implements Service<Room>{

	private RoomRepository roomRepository= new RoomRepository();
	
	@Override
	public Room save(Room entity) {
		return roomRepository.save(entity);
	}

	@Override
	public Room findById(Long id) {
		return roomRepository.findById(id);
	}

	@Override
	public List<Room> findAll() {
		return roomRepository.findAll();
	}

	@Override
	public boolean delete(Room entity) {
		return roomRepository.delete(entity);
	}

	@Override
	public boolean deleteById(Long id) {
		return roomRepository.deleteById(id);
	}

	public DefaultTableModel roomToTableModel(List<Room> rooms) {
		String[] columns = { "roomNumber", "studentsNumber", "orientation" };
		String[][] tuple = new String[rooms.size()][columns.length];
		int i = 0;
		for (Room room : rooms) {
			tuple[i][0] = room.getRoomNumber().toString();
			tuple[i][1] = room.getStudentsNumber().toString();
			tuple[i][2] = room.getOrientation();
			i++;
		}
		DefaultTableModel model = new DefaultTableModel(tuple, columns);
		return model;
	}

	public List<Room> findEmptyRooms(){
		return roomRepository.findEmptyRooms();
	}
	
	public List<Room> findNotFullRooms(){
		return roomRepository.findNotFullRooms();
	}
}
