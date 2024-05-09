package com.asu.model;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tbl_expense")
public class Expense {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank(message = "Expense Name must not be Blank")
	@Size(min = 3, message = "Expense Name must be atleast 3 Characters")
	@Column(name="expense_name")
	private String name;
	private String description;
	@NotNull(message = "Expense Amount must not be Empty")
	private double expense_amount;
	@NotEmpty(message = "Expense Category must not be Empty")
	private String category;
	@NotNull(message = "Expense Date must not be Empty")
	private Date date;

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	private Date created_at;

	@UpdateTimestamp
	private Date updated_at;

	public Expense() {
	}

	public Expense(int id, String expense_name, String description, double expense_amount, String category, Date date) {
		super();
		this.id = id;
		this.name = expense_name;
		this.description = description;
		this.expense_amount = expense_amount;
		this.category = category;
		this.date = date;
	}

	public Expense(String expense_name, String description, double expense_amount, String category, Date date) {
		super();
		this.name = expense_name;
		this.description = description;
		this.expense_amount = expense_amount;
		this.category = category;
		this.date = date;
	}

	@Override
	public String toString() {
		return "id=" + id + ", expense_name=" + name + ", description=" + description + ", expense_amount="
				+ expense_amount + ", category=" + category + ", date=" + date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getExpense_name() {
		return name;
	}

	public void setExpense_name(String expense_name) {
		this.name = expense_name;
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
