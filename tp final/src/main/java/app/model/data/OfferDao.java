package app.model.data;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface OfferDao extends JpaRepository<Offer, Long> {

	public Offer findByName(String name);
}
