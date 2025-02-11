package dev.napat.handytools.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.napat.handytools.Model.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {

}
