package com.asu.service;

import com.asu.model.Expense;


public interface IExpenseService {
	public Iterable<Expense> fetchAll();

}
