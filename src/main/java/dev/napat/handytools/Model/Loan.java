package dev.napat.handytools.Model;

import java.sql.Date;

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
    private String location;
    private Date loan_date;
    private Date return_date;

    Loan(){}

    public Loan(Item item, String borrowerName, String location, Date loan_date, Date return_date) {
        this.item = item;
        this.borrowerName = borrowerName;
        this.location = location;
        this.loan_date = loan_date;
        this.return_date = return_date;
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

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
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
