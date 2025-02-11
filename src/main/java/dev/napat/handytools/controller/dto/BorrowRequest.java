package dev.napat.handytools.controller.dto;

public class BorrowRequest {
    private String borrowerName;
    private String use_location;

    public BorrowRequest() {}

    public BorrowRequest(String borrowerName, String location) {
        this.borrowerName = borrowerName;
        this.use_location = location;
    }

    // Getters & Setters
    public String getBorrowerName() { return borrowerName; }
    public void setBorrowerName(String borrowerName) { this.borrowerName = borrowerName; }

    public String getUse_location() { return use_location; }
    public void setUse_location(String location) { this.use_location = location; }

}
