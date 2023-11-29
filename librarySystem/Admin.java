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
class Admin {
    private int idAdmin=1;
    private String nameAdmin="Alaa";
    private List<Member> members;
    private List<Book> books;

    public Admin(int idAdmin, String nameAdmin) {
        this.idAdmin = idAdmin;
        this.nameAdmin = nameAdmin;
        this.members = new ArrayList<>();
        this.books = new ArrayList<>();
    }

    public void addMember(Member member) {
        // Implementation for adding a member
        members.add(member);
        System.out.println("Member added: " + member.getName());
    }

    public void removeMember(Member member) {
        // Implementation for removing a member
        if (members.remove(member)) {
            System.out.println("Member removed: " + member.getName());
        } else {
            System.out.println("Member not found.");
        }
    }

    public void addBook(Book book) {
        // Implementation for adding a book
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void removeBook(Book book) {
        // Implementation for removing a book
        if (books.remove(book)) {
            System.out.println("Book removed: " + book.getTitle());
        } else {
            System.out.println("Book not found.");
        }
    }

    public void viewMembers() {
        // Implementation for viewing members
        System.out.println("Members:");
        for (Member member : members) {
            System.out.println("ID: " + member.getIdMember() + ", Name: " + member.getName());
        }
    }

    public void recapForfeit() {
        // Implementation for recapitulating forfeits
        System.out.println("Recapitulating forfeits...");
        for (Member member : members) {
            System.out.println("Member: " + member.getName() + ", Forfeit: " + member.getForfeit());
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
    
    public Member findMemberById(int memberId) {
        for (Member member : members) {
            if (member.getIdMember() == memberId) {
                return member;
            }
        }
        return null;
    }

}
