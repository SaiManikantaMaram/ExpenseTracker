package com.asu.service;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;

import com.asu.model.Expense;

public interface IExpenseService {
	public List<Expense> fetchAll(Pageable page);

	public Expense getById(int id);

	public String removeById(int id);

	public Expense saveData(Expense exp);

	public Expense updateData(int id, Expense exp);

	public List<Expense> fetchAllByCategory(String Category, Pageable page);
	public List<Expense> fetchAllName(String keyword, Pageable page);
	public List<Expense> fetchByDateBetween(Date startDate,Date endDate, Pageable page);
	

}
