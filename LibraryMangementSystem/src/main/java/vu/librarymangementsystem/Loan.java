package vu.librarymangementsystem;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents a book loan transaction
 */
public class Loan {
    private Book book;
    private Member member;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    
    public Loan(Book book, Member member, LocalDate borrowDate, LocalDate dueDate) {
        this.book = book;
        this.member = member;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
    }
    
    // Getters and Setters
    public Book getBook() {
        return book;
    }
    
    public void setBook(Book book) {
        this.book = book;
    }
    
    public Member getMember() {
        return member;
    }
    
    public void setMember(Member member) {
        this.member = member;
    }
    
    public LocalDate getBorrowDate() {
        return borrowDate;
    }
    
    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }
    
    public LocalDate getDueDate() {
        return dueDate;
    }
    
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
    
    public boolean isOverdue() {
        return LocalDate.now().isAfter(dueDate);
    }
    
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return String.format("Loan{Book='%s', Member='%s', Borrowed=%s, Due=%s, Overdue=%s}", 
                           book.getTitle(), member.getName(), 
                           borrowDate.format(formatter), 
                           dueDate.format(formatter),
                           isOverdue());
    }
}