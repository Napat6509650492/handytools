package dev.napat.handytools.Configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.napat.handytools.Model.Item;
import dev.napat.handytools.Repository.ItemRepository;

@Configuration
public class LoadDatabase {

    public static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ItemRepository itemrepository) {

        return args -> {
            log.info("loading " + itemrepository.save(new Item("hammer", "napat", "outside storage", false)));
            log.info("loading " + itemrepository.save(new Item("screwdriver", "napat", "toolbox 2nd floor", false)));
            log.info("loading" + itemrepository.save(new Item("paint brush", "napat", "paint cabinet", false)));
        };
    }
}