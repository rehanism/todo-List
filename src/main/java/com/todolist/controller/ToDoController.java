package com.todolist.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.todolist.entities.ToDoEntity;
import com.todolist.service.ToDoService;

@Controller
public class ToDoController {

	@Autowired
	private ToDoService service;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/makeToDoList")
	public String makeTodoList() {
		return "makeTodoList";
	}
	// getting all data
	@GetMapping("/todolist")
	public ModelAndView getAllData() {
		List<ToDoEntity> td = service.getAllData();
		return new ModelAndView("todoList", "todolist", td);
		
	}
	// getting single data

	/*
	 * @GetMapping("/todolist/{id}") public String getData(@PathVariable("id") int
	 * id) { this.service.getData(id); return ""; }
	 */
	@PostMapping("/save")
	public String saveData(@ModelAttribute ToDoEntity entity) {
		this.service.saveData(entity);
		return "redirect:/todolist";
	}

	@RequestMapping("/delete/{id}")
	public String deleteData(@PathVariable("id") int id) {
		this.service.deleteData(id);
		return "redirect:/todolist";
	}

	@RequestMapping("/update/{id}")
	public String updateData(Model model, @PathVariable ("id") int id ) {
		ToDoEntity td=service.getData(id);
		model.addAttribute("todolist",td);
		return "updateTodo";
	}
}
