package vu.librarymangementsystem;
import java.util.List;
public class LibraryDemo {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("LIBRARY MANAGEMENT SYSTEM DEMO");
        System.out.println("========================================\n");
        
        // Create library
        Library library = new Library();
        
        // Create books
        Book b1 = new Book("978-0-7475-3269-6", "Harry Potter and the Philosopher's Stone", "J.K. Rowling");
        Book b2 = new Book("978-0-452-28423-4", "1984", "George Orwell");
        Book b3 = new Book("978-0-06-112008-4", "To Kill a Mockingbird", "Harper Lee");
        Book b4 = new Book("978-0-14-143951-8", "Pride and Prejudice", "Jane Austen");
        
        // Create members
        Member m1 = new Member("M001", "Richard Johnson");
        Member m2 = new Member("M002", "Brian Smith");
        Member m3 = new Member("M003", "Emily Davis");
        
        // Add books to library
        System.out.println("=== ADDING BOOKS TO LIBRARY ===");
        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);
        library.addBook(b4);
        System.out.println("Added 4 books to the library\n");
        
        // Register members
        System.out.println("=== REGISTERING MEMBERS ===");
        library.registerMember(m1);
        library.registerMember(m2);
        library.registerMember(m3);
        System.out.println("Registered 3 members\n");
        
        // Display initial state
        System.out.println("=== INITIAL LIBRARY STATE ===");
        System.out.println(library);
        System.out.println();
        
        // Perform lending operations
        System.out.println("=== LENDING OPERATIONS ===");
        
        // Successful lend
        System.out.println("\n1. Richard borrows '1984':");
        library.lendBook("978-0-452-28423-4", "M001");
        
        // Successful lend
        System.out.println("\n2. Brian borrows 'Harry Potter':");
        library.lendBook("978-0-7475-3269-6", "M002");
        
        // Rejected lend (book already on loan)
        System.out.println("\n3. Emily tries to borrow '1984' (should be rejected):");
        library.lendBook("978-0-452-28423-4", "M003");
        
        // Successful lend
        System.out.println("\n4. Emily borrows 'To Kill a Mockingbird':");
        library.lendBook("978-0-06-112008-4", "M003");
        
        // Display state after lending
        System.out.println("\n=== STATE AFTER LENDING ===");
        System.out.println(library);
        System.out.println();
        
        // Perform return operations
        System.out.println("=== RETURN OPERATIONS ===");
        
        // Successful return
        System.out.println("\n5. Richard returns '1984':");
        library.returnBook("978-0-452-28423-4");
        
        // Successful return
        System.out.println("\n6. Brian returns 'Harry Potter':");
        library.returnBook("978-0-7475-3269-6");
        
        // Attempt to return a book not on loan
        System.out.println("\n7. Attempt to return '1984' again (should be rejected):");
        library.returnBook("978-0-452-28423-4");
        
        // Display final state
        System.out.println("\n=== FINAL LIBRARY STATE ===");
        System.out.println(library);
        
        // Search demonstration
        System.out.println("=== SEARCH DEMONSTRATION ===");
        System.out.println("\nSearch for books containing 'Harry':");
        library.searchByTitle("Harry").forEach(book -> 
            System.out.println("  Found: " + book.getTitle()));
        
        System.out.println("\nSearch for books containing 'the':");
        library.searchByTitle("the").forEach(book -> 
            System.out.println("  Found: " + book.getTitle()));
        
        System.out.println("\n========================================");
        System.out.println("DEMO COMPLETE");
        System.out.println("========================================");
    }
}