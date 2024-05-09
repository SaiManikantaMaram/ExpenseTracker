package com.asu.controller;

import java.sql.Date;
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

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {

	@Autowired
	private IExpenseService service;

	@GetMapping("/hello")
	public String getAllExpenses() {
		return "Hello World";
	}

	@GetMapping("/fetchall")
	public List<Expense> getAll(Pageable page) {
		return service.fetchAll(page);
	}

	@GetMapping("/fetch")
	public Expense getById(@RequestParam("ExpenseId") int id) {
		return service.getById(id);
	}

	@GetMapping("/delete")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public String removeById(@RequestParam("ExpenseId") int id) {
		return service.removeById(id);

	}

	@GetMapping("/save")
	@ResponseStatus(value = HttpStatus.CREATED)
	public Expense saveData(@Valid @RequestBody Expense exp) {

		return service.saveData(exp);
	}

	@GetMapping("/update/{identity}")
	public Expense updateData(@PathVariable("identity") int id, @RequestBody Expense exp) {
		return service.updateData(id, exp);
	}

	@GetMapping("/getbycategory")
	public List<Expense> fetchAllBycategory(@RequestParam("cat") String category, Pageable page) {
		return service.fetchAllByCategory(category, page);
	}

	@GetMapping("/getbyname")
	public List<Expense> fetchAllByName(@RequestParam("Name") String keyword, Pageable page) {
		return service.fetchAllName(keyword, page);
	}

	@GetMapping("/getbydate")
	public List<Expense> fetchByDate(@RequestParam(value = "Start", required = false) Date startDate,
			@RequestParam(value = "End", required = false) Date endDate, Pageable page) {
		return service.fetchByDateBetween(startDate, endDate, page);
	}
}
