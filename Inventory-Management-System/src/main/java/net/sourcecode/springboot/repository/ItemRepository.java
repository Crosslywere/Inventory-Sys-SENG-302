package net.sourcecode.springboot.repository;

import net.sourcecode.springboot.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// this interface extends the jparepository by adding the item(our model) and the type of our id which is long
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByCategory(String category);
    List<Item> findByBrand(String brand);
}
