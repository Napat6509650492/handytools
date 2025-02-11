package dev.napat.handytools.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Item {
    private @Id @GeneratedValue Long id;
    private String toolDetail;
    private String ownerName;    
    private String location;
    private Boolean isBorrower;

    Item(){}
    
    public Item(String toolDetail, String ownerName, String location, Boolean isBorrower) {
        this.toolDetail = toolDetail;
        this.ownerName = ownerName;
        this.location = location;
        this.isBorrower = isBorrower;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getOwnerName() {
        return ownerName;
    }
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    public String getName() {
        return toolDetail;
    }
    public void setName(String toolDetail) {
        this.toolDetail = toolDetail;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public Boolean getIsBorrower() {
        return isBorrower;
    }
    public void setIsBorrower(Boolean isBorrower) {
        this.isBorrower = isBorrower;
    }


}
