package com.asu.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_expense")
public class Expense {
	@Id
	private int id;
	private String expense_name;
	private String description;
	private double expense_amount;
	private String category;
	private Date date;

	public Expense() {
	}

	public Expense(int id, String expense_name, String description, double expense_amount, String category, Date date) {
		super();
		this.id = id;
		this.expense_name = expense_name;
		this.description = description;
		this.expense_amount = expense_amount;
		this.category = category;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getExpense_name() {
		return expense_name;
	}

	public void setExpense_name(String expense_name) {
		this.expense_name = expense_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getExpense_amount() {
		return expense_amount;
	}

	public void setExpense_amount(double expense_amount) {
		this.expense_amount = expense_amount;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
