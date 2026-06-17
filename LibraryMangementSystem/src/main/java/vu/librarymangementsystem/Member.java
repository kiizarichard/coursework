package vu.librarymangementsystem;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Member {
    private String memberId;
    private String name;
    private List<Loan> loans;
    
    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.loans = new ArrayList<>();
    }
    
    // Getters and Setters
    public String getMemberId() {
        return memberId;
    }
    
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public List<Loan> getLoans() {
        return new ArrayList<>(loans); // Defensive copy
    }
    
    public void addLoan(Loan loan) {
        if (loan != null && !loans.contains(loan)) {
            loans.add(loan);
        }
    }
    
    public void removeLoan(Loan loan) {
        loans.remove(loan);
    }
    
    public int getActiveLoansCount() {
        return loans.size();
    }
    
    @Override
    public String toString() {
        return String.format("Member{ID='%s', Name='%s', Active Loans=%d}", 
                           memberId, name, loans.size());
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(memberId, member.memberId);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(memberId);
    }
}