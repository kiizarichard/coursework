package vu.librarymangementsystem;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Manages the library's collection of books, members, and loans
 */
public class Library {
    private List<Book> books;
    private List<Member> members;
    private List<Loan> loans;
    
    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
        this.loans = new ArrayList<>();
    }
    
    /**
     * Adds a book to the library collection
     */
    public void addBook(Book book) {
        if (book != null && !books.contains(book)) {
            books.add(book);
        }
    }
    
    /**
     * Registers a new member
     */
    public void registerMember(Member member) {
        if (member != null && !members.contains(member)) {
            members.add(member);
        }
    }
    
    /**
     * Lends a book to a member
     * @return true if successful, false if book is not available
     */
    public boolean lendBook(String isbn, String memberId) {
        // Find the book
        Book book = findBookByIsbn(isbn);
        if (book == null) {
            System.out.println("Book not found with ISBN: " + isbn);
            return false;
        }
        
        // Check if book is available
        if (!book.isAvailable()) {
            System.out.println("Book '" + book.getTitle() + "' is currently on loan.");
            return false;
        }
        
        // Find the member
        Member member = findMemberById(memberId);
        if (member == null) {
            System.out.println("Member not found with ID: " + memberId);
            return false;
        }
        
        // Create loan
        LocalDate borrowDate = LocalDate.now();
        LocalDate dueDate = borrowDate.plusDays(14); // 2 weeks loan period
        
        Loan loan = new Loan(book, member, borrowDate, dueDate);
        loans.add(loan);
        member.addLoan(loan);
        book.setAvailable(false);
        
        System.out.println("Successfully lent '" + book.getTitle() + "' to " + member.getName());
        return true;
    }
    
    /**
     * Returns a borrowed book
     * @return true if successful
     */
    public boolean returnBook(String isbn) {
        // Find the book
        Book book = findBookByIsbn(isbn);
        if (book == null) {
            System.out.println("Book not found with ISBN: " + isbn);
            return false;
        }
        
        // Check if book is currently on loan
        if (book.isAvailable()) {
            System.out.println("Book '" + book.getTitle() + "' is not currently on loan.");
            return false;
        }
        
        // Find the active loan for this book
        Loan activeLoan = loans.stream()
            .filter(loan -> loan.getBook().equals(book))
            .findFirst()
            .orElse(null);
        
        if (activeLoan == null) {
            System.out.println("No active loan found for this book.");
            return false;
        }
        
        // Remove loan from member and library
        Member member = activeLoan.getMember();
        member.removeLoan(activeLoan);
        loans.remove(activeLoan);
        book.setAvailable(true);
        
        System.out.println("Successfully returned '" + book.getTitle() + "' from " + member.getName());
        return true;
    }
    
    /**
     * Searches for books by title (case-insensitive partial match)
     */
    public List<Book> searchByTitle(String title) {
        return books.stream()
            .filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase()))
            .collect(Collectors.toList());
    }
    
    /**
     * Returns all available books
     */
    public List<Book> getAvailableBooks() {
        return books.stream()
            .filter(Book::isAvailable)
            .collect(Collectors.toList());
    }
    
    /**
     * Helper method to find a book by ISBN
     */
    private Book findBookByIsbn(String isbn) {
        return books.stream()
            .filter(book -> book.getIsbn().equals(isbn))
            .findFirst()
            .orElse(null);
    }
    
    /**
     * Helper method to find a member by ID
     */
    private Member findMemberById(String memberId) {
        return members.stream()
            .filter(member -> member.getMemberId().equals(memberId))
            .findFirst()
            .orElse(null);
    }
    
    /**
     * Returns all loans
     */
    public List<Loan> getLoans() {
        return new ArrayList<>(loans);
    }
    
    /**
     * Returns all books
     */
    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }
    
    /**
     * Returns all members
     */
    public List<Member> getMembers() {
        return new ArrayList<>(members);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("========== LIBRARY STATUS ==========\n");
        sb.append("Total Books: ").append(books.size()).append("\n");
        sb.append("Available Books: ").append(getAvailableBooks().size()).append("\n");
        sb.append("Total Members: ").append(members.size()).append("\n");
        sb.append("Active Loans: ").append(loans.size()).append("\n\n");
        
        sb.append("BOOKS:\n");
        for (Book book : books) {
            sb.append("  ").append(book).append("\n");
        }
        
        sb.append("\nMEMBERS:\n");
        for (Member member : members) {
            sb.append("  ").append(member).append("\n");
        }
        
        sb.append("\nLOANS:\n");
        if (loans.isEmpty()) {
            sb.append("  No active loans\n");
        } else {
            for (Loan loan : loans) {
                sb.append("  ").append(loan).append("\n");
            }
        }
        sb.append("=====================================");
        return sb.toString();
    }
}