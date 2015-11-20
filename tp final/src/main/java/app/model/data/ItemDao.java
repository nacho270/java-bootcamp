package app.model.data;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface ItemDao extends JpaRepository<Item, Long> {

	public Item findByName(String name);

	public Item findByCategory(String category);

}
