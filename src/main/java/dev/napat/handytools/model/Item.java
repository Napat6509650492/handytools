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
    private Boolean isBorrowed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToolDetail() {
        return toolDetail;
    }

    public void setToolDetail(String toolDetail) {
        this.toolDetail = toolDetail;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean getIsBorrowed() {
        return isBorrowed;
    }

    public void setIsBorrowed(Boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }

    Item(){}
    
    public Item(String toolDetail, String ownerName, String location, Boolean isBorrowed) {
        this.toolDetail = toolDetail;
        this.ownerName = ownerName;
        this.location = location;
        this.isBorrowed = (isBorrowed != null) ? isBorrowed : false;
    }
    
}
