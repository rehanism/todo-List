package com.todolist.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ToDoList")
public class ToDoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String description;
	private String status;
	public ToDoEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ToDoEntity(int id, String description, String status) {
		super();
		this.id = id;
		this.description = description;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ToDoEntity [id=" + id + ", description=" + description + ", status=" + status + "]";
	}
	

}
