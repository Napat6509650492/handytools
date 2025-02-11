package dev.napat.handytools.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Item {
    private @Id @GeneratedValue Long id;
    
    private String name;
    private String location;
    private Boolean isBorrower;


}
