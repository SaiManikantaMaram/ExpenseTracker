package com.asu.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.asu.model.Expense;

public interface IExpenseRepo extends JpaRepository<Expense, Integer> {

	public List<Expense> findByCategory(String Category, Pageable page);

	public List<Expense> findByNameContaining(String keyword, Pageable page);

	public List<Expense> findByDateBetween(Date startDate, Date endDate, Pageable page);

}
