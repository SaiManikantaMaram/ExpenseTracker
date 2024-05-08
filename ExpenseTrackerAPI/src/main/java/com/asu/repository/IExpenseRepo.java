package com.asu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.asu.model.Expense;

public interface IExpenseRepo extends JpaRepository<Expense, Integer> {

}
