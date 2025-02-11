package dev.napat.handytools.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.napat.handytools.Model.Item;
import dev.napat.handytools.Model.Loan;
import dev.napat.handytools.Repository.ItemRepository;
import dev.napat.handytools.Repository.LoanRepository;

@Configuration
public class LoadDatabase {

    public static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ItemRepository itemrepository, LoanRepository loanRepository) {

        // S mean Storge
        // R mean Room or Where it is used
        List<Item> items = Arrays.asList(
            new Item("hammer", "napat", "S1", false),
            new Item("screwdriver", "napat", "R1", true),
            new Item("paint brush", "napat", "S1", false)
        );

        List<Loan> loans = Arrays.asList(
            new Loan(items.get(1),"save","S1",null,"R1",new Date(),null),
            new Loan(items.get(2),"save","S1","S2","R1",new Date(),new Date())
        );

        return args -> {
            items.forEach(item->{
                log.info("loading " + itemrepository.save(item));
            });

            loans.forEach(loan->{
                log.info("loading " + loanRepository.save(loan));
            });

        };
    }
}