package com.asu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	public List<Expense> getAll(Pageable page) {
		return service.fetchAll(page);
	}

	@GetMapping("/expenseById")
	public Expense getById(@RequestParam("ExpenseId") int id) {
		return service.getById(id);
	}

	@GetMapping("/deleteById")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public String removeById(@RequestParam("ExpenseId") int id) {
		return service.removeById(id);

	}

	@GetMapping("/saveData")
	@ResponseStatus(value = HttpStatus.CREATED)
	public Expense saveData(@RequestBody Expense exp) {

		return service.saveData(exp);
	}

	@GetMapping("/updateData/{identity}")
	public Expense updateData(@PathVariable("identity") int id, @RequestBody Expense exp) {
		return service.updateData(id, exp);
	}
}
