package com.asu.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.asu.model.Expense;

public interface IExpenseService {
	public List<Expense> fetchAll(Pageable page);

	public Expense getById(int id);

	public String removeById(int id);

	public Expense saveData(Expense exp);

	public Expense updateData(int id, Expense exp);

}
