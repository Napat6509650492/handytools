package dev.napat.handytools.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.napat.handytools.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
