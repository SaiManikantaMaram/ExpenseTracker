package com.asu.repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.asu.model.Expense;

public interface IExpenseRepo extends JpaRepository<Expense, Integer> {

	public List<Expense> findByUserIdAndCategory(int userId, String category, Pageable page);

	public List<Expense> findByUserIdAndNameContaining(int userId, String keyword, Pageable page);

	public List<Expense> findByUserIdAndDateBetween(int userId, Date startDate, Date endDate, Pageable page);

	public List<Expense> findByUserId(int id, Pageable page);

	public Optional<Expense> findByUserIdAndId(int userId, int id);

	public void deleteByUserIdAndId(int userId, int id);

}
