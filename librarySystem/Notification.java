/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarySystem;

/**
 *
 * @author Aladdin
 */
class Notification {
    private int idMember;
    private ReturnTransaction returnTransaction;
    private BorrowTransaction borrowTransaction;
    private String name;
    private int idNumber;
    // Constructor, getters, setters

    public Notification(int idMember, ReturnTransaction returnTransaction, BorrowTransaction borrowTransaction, String name, int idNumber) {
        this.idMember = idMember;
        this.returnTransaction = returnTransaction;
        this.borrowTransaction = borrowTransaction;
        this.name = name;
        this.idNumber = idNumber;
    }
    public Notification() {
        this.idMember = 0;
        this.returnTransaction = new ReturnTransaction();
        this.borrowTransaction = new BorrowTransaction();
        this.name = null;
        this.idNumber = 0;
    }

    public int getIdMember() {
        return idMember;
    }

    public void setIdMember(int idMember) {
        this.idMember = idMember;
    }

    public ReturnTransaction getReturnTransaction() {
        return returnTransaction;
    }

    public void setReturnTransaction(ReturnTransaction returnTransaction) {
        this.returnTransaction = returnTransaction;
    }

    public BorrowTransaction getBorrowTransaction() {
        return borrowTransaction;
    }

    public void setBorrowTransaction(BorrowTransaction borrowTransaction) {
        this.borrowTransaction = borrowTransaction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }
    
    
    
    
    public void sendNotification() {
        // Implementation for sending a notification
        System.out.println("Sending notification to Member " + idMember + ":");
        System.out.println("Name: " + name);
        System.out.println("Return Time: " + returnTransaction.getReturnTime());
        System.out.println("Borrow Transaction Time: " + borrowTransaction.getReturnTime());
    }
}

