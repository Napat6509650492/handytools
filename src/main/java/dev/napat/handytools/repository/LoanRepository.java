package dev.napat.handytools.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dev.napat.handytools.model.Loan;
import jakarta.transaction.Transactional;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    @Query("SELECT l FROM Loan l WHERE l.return_date IS NULL AND l.item.id = :id")
    Loan findActiveLoans(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query("DELETE FROM Loan l WHERE l.item.id = :itemId")
    void deleteByItemId(@Param("itemId") Long itemId);
}
