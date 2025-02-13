package dev.napat.handytools.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.napat.handytools.controller.dto.BorrowRequest;
import dev.napat.handytools.controller.dto.ReturnItemRequest;
import dev.napat.handytools.model.Item;
import dev.napat.handytools.model.Loan;
import dev.napat.handytools.repository.ItemRepository;
import dev.napat.handytools.repository.LoanRepository;

@RestController
@RequestMapping("handytools")
public class HandytoolController {
    private final ItemRepository itemRepository;
    private final LoanRepository loanRepository;

    public HandytoolController(ItemRepository itemRepository, LoanRepository loanRepository) {
        this.itemRepository = itemRepository;
        this.loanRepository = loanRepository;
    }
    
    @GetMapping("")
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        return itemRepository.findById(id)
            .map((item)->ResponseEntity.ok().body((Object) item))
            .orElseGet(()->ResponseEntity
                            .status(HttpStatus.NOT_FOUND)
                            .body("Item ID " + id + " Not Found"));
    }

    @GetMapping("where/{id}")
    public String whereItem(@PathVariable Long id) {
        return itemRepository.findById(id).get().getLocation();
    }

    @GetMapping("history/{id}")
    public ResponseEntity<List<Loan>> loanHistory(@PathVariable Long id) {
        loanRepository.findByItemId(id);
        return ResponseEntity.ok(loanRepository.findByItemId(id));
    }

    @PostMapping("add")
    public Item addNewItem(@RequestBody Item item){
        item.setIsBorrowed(false);
        return itemRepository.save(item);
    }

    // BorrowItem
    @PutMapping("borrow/{id}")
    public ResponseEntity<String> borrowItem(@RequestBody BorrowRequest request,@PathVariable Long id){
        Optional<Item> optionalItem = itemRepository.findById(id);
        if (optionalItem.isEmpty()) 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item not found");

        Item item = optionalItem.get();

        if (item.getIsBorrowed())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Item is being borrowed");
        
        Loan loan = new Loan(item, request.getBorrowerName(), item.getLocation(), null, request.getUse_location(), new Date(), null);
        item.setIsBorrowed(true);
        item.setLocation(request.getUse_location());

        loanRepository.save(loan);
        itemRepository.save(item);

        return ResponseEntity.status(HttpStatus.OK).body("Item borrowed successfully");
    }

    // return Item
    @PutMapping("return/{id}")
    public ResponseEntity<String> returnItem(@PathVariable Long id, @RequestBody ReturnItemRequest request) {
        Optional<Item> optionalItem = itemRepository.findById(id);
        if (optionalItem.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item not found");

        Item item = optionalItem.get();
        if (!item.getIsBorrowed())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The item has not been borrowed yet.");

        Loan loan = loanRepository.findActiveLoans(id);
        if (loan == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something Error");

        loan.setAfter_Location(request.getLocation());
        loan.setReturn_date(new Date());

        item.setIsBorrowed(false);
        item.setLocation(request.getLocation());

        itemRepository.save(item);
        loanRepository.save(loan);
        
        return ResponseEntity.status(HttpStatus.OK).body("Success for return item");
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable Long id){
        Optional<Item> optionalItem = itemRepository.findById(id);
        if (optionalItem.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item not found");

        loanRepository.deleteByItemId(id);
        itemRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Success for delete item");

    }
}
