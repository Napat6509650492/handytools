package dev.napat.handytools.model;



import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Loan {

    @Id @GeneratedValue
    private Long id;
    
    @ManyToOne
    private Item item;
    private String borrowerName;
    private String before_Location;
    private String after_Location;
    private String use_Location;
    private Date loan_date;
    private Date return_date;
    
    Loan(){}

    public Loan(Item item, String borrowerName, String before_Location, String after_Location, String use_Location,
            Date loan_date, Date return_date) {
        this.item = item;
        this.borrowerName = borrowerName;
        this.before_Location = before_Location;
        this.after_Location = after_Location;
        this.use_Location = use_Location;
        this.loan_date = loan_date;
        this.return_date = return_date;
    }
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
    
    public String getUse_Location() {
        return use_Location;
    }

    public void setUse_Location(String user_Location) {
        this.use_Location = user_Location;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Date getLoan_date() {
        return loan_date;
    }
    public void setLoan_date(Date loan_date) {
        this.loan_date = loan_date;
    }

    public String getAfter_Location() {
        return after_Location;
    }

    public void setAfter_Location(String after_Location) {
        this.after_Location = after_Location;
    }

    public String getBefore_Location() {
        return before_Location;
    }
    public void setBefore_Location(String location) {
        this.before_Location = location;
    }

    public String getBorrowerName() {
        return borrowerName;
    }
    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }
    
    
}
