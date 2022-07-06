package be.saxomoose.webshop.repositories;

import be.saxomoose.webshop.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>
{
    List<Item> findItemsByCategoryId(Long categoryId);
}
