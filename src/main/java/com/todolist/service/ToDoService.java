package com.todolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.todolist.entities.ToDoEntity;
import com.todolist.repository.ToDoRepository;

@Component
public class ToDoService {

	@Autowired
	private ToDoRepository todorep;

	// getting a single data

	public ToDoEntity getData(int id) {
		ToDoEntity result = this.todorep.findById(id);
		return result;
	}

	// getting all data

	public List<ToDoEntity> getAllData() {
		List<ToDoEntity> result = this.todorep.findAll();
		return result;
	}

	// adding data
	public ToDoEntity saveData(ToDoEntity todoEntity) {
		return this.todorep.save(todoEntity);
	}

	// deleting data
	public void deleteData(int id) {
		this.todorep.deleteById(id);
	}

	// updating data

	public void updateData(ToDoEntity todoEntity, int id) {
		todoEntity.setId(id);
		this.todorep.save(todoEntity);
	}

}
