package transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {
	
	@Autowired
	private TransactionDAO transactionDAO;
	
	
	@GetMapping("/hello")
	public String testSpring(){
		System.out.println("Hello World");
		return "Hello World";
	}
	
}
