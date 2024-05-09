package com.asu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.asu.Exceptions.ExpenseNotFoundException;
import com.asu.model.Expense;
import com.asu.repository.IExpenseRepo;

@Service
public class ExpenseService implements IExpenseService {

	@Autowired
	private IExpenseRepo repo;

	@Override
	public List<Expense> fetchAll(Pageable page) {
		return repo.findAll(page).toList();
	}

	@Override
	public Expense getById(int id) {

		Optional<Expense> result = repo.findById(id);
		if (result.isPresent()) {
			return result.get();
		}
		throw new ExpenseNotFoundException("Expense not Found with Id " + id);
	}

	@Override
	public String removeById(int id) {
		if (getById(id) != null)
			repo.deleteById(id);
		return "Expense Deleted with ID " + id;
	}

	@Override
	public Expense saveData(Expense exp) {
		return repo.save(exp);

	}

	@Override
	public Expense updateData(int id, Expense updatedexpense) {
		Expense expense = getById(id);
		if (updatedexpense.getCreated_at() != null && updatedexpense.getCreated_at() != expense.getCreated_at())
			throw new RuntimeException("Creation date cannot be changed");
		if (updatedexpense.getUpdated_at() != null && updatedexpense.getUpdated_at() != expense.getUpdated_at())
			throw new RuntimeException("Updation date cannot be changed");
		updatedexpense.setId(id);
		updatedexpense.setExpense_name(updatedexpense.getExpense_name() != null ? updatedexpense.getExpense_name()
				: expense.getExpense_name());
		updatedexpense.setDescription(
				updatedexpense.getDescription() != null ? updatedexpense.getDescription() : expense.getDescription());
		updatedexpense.setExpense_amount(updatedexpense.getExpense_amount() != 0.0 ? updatedexpense.getExpense_amount()
				: expense.getExpense_amount());
		updatedexpense.setCategory(
				updatedexpense.getCategory() != null ? updatedexpense.getCategory() : expense.getCategory());
		updatedexpense.setDate(updatedexpense.getDate() != null ? updatedexpense.getDate() : expense.getDate());

		return repo.save(updatedexpense);
	}

	@Override
	public List<Expense> fetchAllByCategory(String Category, Pageable page) {
		return repo.findByCategory(Category, page);
	}

	@Override
	public List<Expense> fetchAllName(String keyword, Pageable page) {
		return repo.findByNameContaining(keyword, page);
	}

}
