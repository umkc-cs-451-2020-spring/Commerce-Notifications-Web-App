package com.group2.CommerceServer.api.transactions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.group2.commerceserver.api.transactions.TransactionController;
import com.group2.commerceserver.api.transactions.TransactionDAO;
import com.group2.commerceserver.models.Transaction;

@RunWith(SpringRunner.class)

@AutoConfigureMockMvc
public class TransactionControllerTest {

	private MockMvc mockMvc;


	@Mock
	private TransactionDAO transactionDAO;

	@InjectMocks
	private TransactionController transactionController;

	Optional<List<Transaction>> transactionOptional;
	Optional<Integer> resultOptional;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(this.transactionController).build();
	}

	@Test
	public void TestGetTransactionsByUser() throws Exception {
		List<Transaction> tlist = new ArrayList<>();
		Transaction transaction = new Transaction();
		transaction.setTransactionId(1);
		transaction.setAccountNumber(1);
		transaction.setDescription("Test Transaction");
		transaction.setBalance(40.00);
		transaction.setAmount(10.00);
		transaction.setState("MO");
		transaction.setProcessingDate("2020-04-19 12:00:00");
		transaction.setTransactionType(1);
		transaction.setCategory("Food");

		tlist.add(transaction);

		transactionOptional = Optional.of(tlist);

		ObjectMapper mapper = new ObjectMapper();
		String expectedJSONContent = mapper.writeValueAsString(tlist);

		Mockito.when(this.transactionDAO.getUserTransactions(1)).thenReturn(tlist);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/transactions/1")
				.accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk()).andReturn();

		assertEquals(result.getResponse().getContentAsString(), expectedJSONContent);
	}
	
	@Test
	public void TestAddTransaction() throws Exception {
		Transaction transaction = new Transaction();
		transaction.setTransactionId(1);
		transaction.setAccountNumber(1);
		transaction.setDescription("Test Transaction");
		transaction.setBalance(40.00);
		transaction.setAmount(10.00);
		transaction.setState("MO");
		transaction.setProcessingDate("2020-04-19 12:00:00");
		transaction.setTransactionType(1);
		transaction.setCategory("Food");
		
		ObjectMapper mapper = new ObjectMapper();
		String expectedJSONContent = "{\"accountNumber\": 1,\"description\": \"Test_Transaction\",\"amount\": 25.00,\"state\": \"MO\",\"processingDate\": \"2020/04/19 12:12:12\", \"transactionType\": 1, \"category\": \"Food\"}";

		Mockito.when(this.transactionDAO.addTransaction(transaction)).thenReturn(1);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/transactions/add")
				.accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8").content(expectedJSONContent);

		MvcResult result = mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk()).andReturn();

		assertEquals(1, result.getResponse().getContentAsString());
	}

}
