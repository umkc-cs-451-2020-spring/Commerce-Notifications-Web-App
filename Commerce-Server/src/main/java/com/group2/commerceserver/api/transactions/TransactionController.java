package com.group2.commerceserver.api.transactions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group2.commerceserver.models.Transaction;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
	
	@Autowired
	private TransactionDAO transactionDAO;
	
	@GetMapping("/{id}")
	public List<Transaction> getTransactionsByUser(@PathVariable(value = "id") int userId) {
		return transactionDAO.getUserTransactions(userId);
	}
	
	@PostMapping("/add")
	public int addTransaction(@RequestBody Transaction transaction) {
		return transactionDAO.addTransaction(transaction);
	}
}