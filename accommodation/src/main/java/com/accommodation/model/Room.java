package com.accommodation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "room")
public class Room extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	@Column
	private Integer roomNumber;
	@Column
	private Integer studentsNumber;
	@Column
	private String orientation;
	@Column
	private Integer caminNumber;
	@Column
	private String problems;

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Integer getStudentsNumber() {
		return studentsNumber;
	}

	public void setStudentsNumber(Integer studentsNumber) {
		this.studentsNumber = studentsNumber;
	}

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public Integer getCaminNumber() {
		return caminNumber;
	}

	public void setCaminNumber(Integer caminNumber) {
		this.caminNumber = caminNumber;
	}

	public String getProblems() {
		return problems;
	}

	public void setProblems(String problems) {
		this.problems = problems;
	}

}
