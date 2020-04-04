package transaction;

import java.util.List;

public interface TransactionDAO {
	
	public void saveOrUpdate(Transaction transaction);
	
    public void delete(int transactionId);
    
    public Transaction get(int transactionId);
     
    public List<Transaction> list();
}
