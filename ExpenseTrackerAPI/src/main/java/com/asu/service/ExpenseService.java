package com.asu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asu.model.Expense;
import com.asu.repository.IExpenseRepo;

@Service
public class ExpenseService implements IExpenseService {

	@Autowired
	private IExpenseRepo repo;

	@Override
	public Iterable<Expense> fetchAll() {
		return repo.findAll();
	}

}
