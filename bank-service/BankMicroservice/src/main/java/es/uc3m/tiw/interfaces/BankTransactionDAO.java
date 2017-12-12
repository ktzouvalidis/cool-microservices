package es.uc3m.tiw.interfaces;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import es.uc3m.tiw.domains.BankTransaction;

public interface BankTransactionDAO extends CrudRepository<BankTransaction, Long> {
	public List<BankTransaction> findAll();
}
