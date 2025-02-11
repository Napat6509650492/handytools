package dev.napat.handytools.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.napat.handytools.Model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
