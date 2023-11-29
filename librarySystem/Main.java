/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarySystem;
import java.util.Scanner;
/**
 *
 * @author Aladdin
 */




public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Library System!");

        System.out.print("Are you an Admin or Member? (A/M): ");
        String userType = scanner.nextLine().toUpperCase();

        if (userType.equals("A")) {
            Admin admin = loginAsAdmin(scanner);
            adminMenu(admin, scanner);
        } else if (userType.equals("M")) {
            Member member = loginAsMember(scanner);
            memberMenu(member, scanner);
        } else {
            System.out.println("Invalid user type. Exiting.");
        }

        scanner.close();
    }

     private static Admin loginAsAdmin(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Admin Login:");
                System.out.print("Enter Admin ID: ");
                int adminId = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                System.out.print("Enter Admin Name: ");
                String adminName = scanner.nextLine();

                return new Admin(adminId, adminName);
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine(); // Consume the newline character
            }
        }
    }

    private static Member loginAsMember(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Member Login:");
                System.out.print("Enter Member ID: ");
                int memberId = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                System.out.print("Enter Member Name: ");
                String memberName = scanner.nextLine();

                System.out.print("Enter Member Address: ");
                String memberAddress = scanner.nextLine();

                return new Member(memberId, memberName, memberAddress, "", 0);
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine(); // Consume the newline character
            }
        }
    }


    private static void adminMenu(Admin admin, Scanner scanner) {
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add Member");
            System.out.println("2. Remove Member");
            System.out.println("3. Add Book");
            System.out.println("4. Remove Book");
            System.out.println("5. View Members");
            System.out.println("6. Recap Forfeits");
            System.out.println("0. Exit");

            int choice = getIntInput("Enter your choice: ", scanner);

            switch (choice) {
                case 1:
                    // Add Member
                    Member newMember = addMember(scanner);
                    admin.addMember(newMember);
                    break;
                case 2:
                    // Remove Member
                    admin.viewMembers();
                    int memberIdToRemove = getIntInput("Enter the ID of the member to remove: ", scanner);
                    Member memberToRemove = admin.findMemberById(memberIdToRemove);
                    if (memberToRemove != null) {
                        admin.removeMember(memberToRemove);
                    } else {
                        System.out.println("Member not found.");
                    }
                    break;
                case 3:
                    // Add Book
                    Book newBook = addBook(scanner);
                    admin.addBook(newBook);
                    break;
                case 4:
                    // Remove Book
                    //admin.viewBooks();
                    int isbnToRemove = getIntInput("Enter the ISBN of the book to remove: ", scanner);
                    Book bookToRemove = admin.findBookByISBN(isbnToRemove);
                    if (bookToRemove != null) {
                        admin.removeBook(bookToRemove);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 5:
                    // View Members
                    admin.viewMembers();
                    break;
                case 6:
                    // Recap Forfeits
                    admin.recapForfeit();
                    break;
                case 0:
                    System.out.println("Exiting Admin Menu.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static Member addMember(Scanner scanner) {
        System.out.println("\nAdding Member:");
        int memberId = getIntInput("Enter Member ID: ", scanner);
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter Member Name: ");
        String memberName = scanner.nextLine();

        System.out.print("Enter Member Address: ");
        String memberAddress = scanner.nextLine();

        return new Member(memberId, memberName, memberAddress, "", 0);
    }

    private static Book addBook(Scanner scanner) {
        System.out.println("\nAdding Book:");
        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();

        System.out.print("Enter Book Author: ");
        String author = scanner.nextLine();

        int isbn = getIntInput("Enter Book ISBN: ", scanner);

        return new Book(title, author, isbn);
    }

    private static void memberMenu(Member member, Scanner scanner) {
        while (true) {
            System.out.println("\nMember Menu:");
            System.out.println("1. Search Books");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. View Available Books");
            System.out.println("5. View Borrow Transactions");
            System.out.println("0. Exit");

            int choice = getIntInput("Enter your choice: ", scanner);

            switch (choice) {
                case 1:
                    // Search Books
                    member.searchBooks(getStringInput("Enter search term: ", scanner));
                    break;
                case 2:
                    // Borrow Book
                    member.viewBooks();
                    int isbnToBorrow = getIntInput("Enter the ISBN of the book to borrow: ", scanner);
                    Book bookToBorrow = member.findBookByISBN(isbnToBorrow);
                    if (bookToBorrow != null) {
                        member.borrowBook(bookToBorrow);
                    } else {
                        System.out.println("Book not found or not available.");
                    }
                    break;
                case 3:
                    // Return Book
                    member.viewBooks();
                    int isbnToReturn = getIntInput("Enter the ISBN of the book to return: ", scanner);
                    Book bookToReturn = member.findBookByISBN(isbnToReturn);
                    if (bookToReturn != null) {
                        member.returnBook(bookToReturn);
                    } else {
                        System.out.println("Book not found or not borrowed by this member.");
                    }
                    break;
                case 4:
                    // View Available Books
                    member.viewBooks();
                    break;
                case 5:
                    // View Borrow Transactions
                    member.viewTransactions();
                    break;
                case 0:
                    System.out.println("Exiting Member Menu.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static int getIntInput(String prompt, Scanner scanner) {
        while (true) {
            try {
                System.out.print(prompt);
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the newline character
            }
        }
    }

    private static String getStringInput(String prompt, Scanner scanner) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
