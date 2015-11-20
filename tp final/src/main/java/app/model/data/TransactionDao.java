package app.model.data;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface TransactionDao extends JpaRepository<Transaction, Long> {

	public Transaction findByID(long iD);

	public List<Transaction> findByUsuario(String usr);
}
