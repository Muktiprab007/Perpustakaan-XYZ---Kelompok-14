/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarySystem;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aladdin
 */
class Member {
    private int idMember;
    private String name;
    private String address;
    private String returnHistory;
    private int forfeit;
    private List<Book> books;
    private List<BorrowTransaction> borrowTransactions;


    // Constructor, getters, setters, and other methods as needed

    public Member(int idMember, String name, String address, String returnHistory, int forfeit) {
        this.idMember = idMember;
        this.name = name;
        this.address = address;
        this.returnHistory = returnHistory;
        this.forfeit = forfeit;
    }
    public Member() {
        this.idMember = 0;
        this.name = null;
        this.address = null;
        this.returnHistory = null;
        this.forfeit = 0;
    }

    public int getIdMember() {
        return idMember;
    }

    public void setIdMember(int idMember) {
        this.idMember = idMember;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getReturnHistory() {
        return returnHistory;
    }

    public void setReturnHistory(String returnHistory) {
        this.returnHistory = returnHistory;
    }

    public int getForfeit() {
        return forfeit;
    }

    public void setForfeit(int forfeit) {
        this.forfeit = forfeit;
    }
    
    public void searchBooks(String searchTerm) {
        // Implementation for searching books
        System.out.println("Searching for books containing: " + searchTerm);

        List<Book> availableBooks = new ArrayList<>();

        for (Book book : books) {
            if (book.isAvailability() && (book.getTitle().toLowerCase().contains(searchTerm.toLowerCase()) ||
                    book.getAuthor().toLowerCase().contains(searchTerm.toLowerCase()))) {
                availableBooks.add(book);
            }
        }

        if (availableBooks.isEmpty()) {
            System.out.println("No books found matching the search term.");
        } else {
            System.out.println("Available Books matching the search term:");
            for (Book book : availableBooks) {
                System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor());
            }
        }
    }
    public void borrowBook(Book book) {
        // Implementation for borrowing a book
        if (book.isAvailability()) {
            book.setAvailability(false);
            BorrowTransaction borrowTransaction = new BorrowTransaction(this.idMember, book.getISBN());
            this.books.add(book);
            this.borrowTransactions.add(borrowTransaction);
            System.out.println("Book borrowed: " + book.getTitle());
        } else {
            System.out.println("Book not available for borrowing.");
        }
    }
    
    public void returnBook(Book book) {
        // Implementation for returning a book
        if (books.contains(book)) {
            book.setAvailability(true);
            ReturnTransaction returnTransaction = new ReturnTransaction(this.idMember, book.getISBN());
            this.returnHistory += "Book returned: " + book.getTitle() + "\n";
            this.books.remove(book);
            System.out.println("Book returned: " + book.getTitle());
        } else {
            System.out.println("Book not borrowed by this member.");
        }
    }
    
    public void viewBooks() {
        // Implementation for viewing available books
        System.out.println("Available Books:");
        for (Book book : books) {
            if (book.isAvailability()) {
                System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor());
            }
        }
    }
    
    public void viewTransactions() {
        // Implementation for viewing borrow transactions
        System.out.println("Borrow Transactions:");
        for (BorrowTransaction transaction : borrowTransactions) {
            System.out.println("Book ISBN: " + transaction.getISBN() + ", Borrow Time: " + transaction.getReturnTime());
        }
    }
    
    public Book findBookByISBN(int isbn) {
        for (Book book : books) {
            if (book.getISBN() == isbn) {
                return book;
            }
        }
        return null;
    }



    
}