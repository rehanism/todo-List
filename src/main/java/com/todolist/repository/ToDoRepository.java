package com.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todolist.entities.ToDoEntity;

public interface ToDoRepository extends JpaRepository<ToDoEntity, Integer> {

	public ToDoEntity findById(int id);
}
