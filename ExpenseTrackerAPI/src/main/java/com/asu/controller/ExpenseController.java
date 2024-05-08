package com.asu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asu.model.Expense;
import com.asu.service.IExpenseService;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {
	
	@Autowired
	private IExpenseService service;

	@GetMapping("/hello")
	public String getAllExpenses() {
		return "Hello World";
	}

	@GetMapping("/allexpenses")
	public Iterable<Expense> getAll() {
		return service.fetchAll();
	}

}
