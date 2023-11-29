/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarySystem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Aladdin
 */
public class ReturnTransaction {
    private int idMember;
    private int idBorrowTransaction;
    private String returnTime;
    // Constructor, getters, setters

    public ReturnTransaction(int idMember, int idBorrowTransaction) {
        this.idMember = idMember;
        this.idBorrowTransaction = idBorrowTransaction;
        LocalDateTime myObj = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.returnTime = myObj.format(dateTimeFormatter);
    }
    public ReturnTransaction() {
        this.idMember = 0;
        this.idBorrowTransaction = 0;
        this.returnTime = null;
    }

    public int getIdMember() {
        return idMember;
    }

    public void setIdMember(int idMember) {
        this.idMember = idMember;
    }

    public int getIdBorrowTransaction() {
        return idBorrowTransaction;
    }

    public void setIdBorrowTransaction(int idBorrowTransaction) {
        this.idBorrowTransaction = idBorrowTransaction;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }
    

    public void countForfeit(Member member) {
        // Implementation for counting forfeit
        // You may want to add more sophisticated logic based on your requirements
        if (member.getForfeit() > 0) {
            System.out.println("Forfeit counted for Member " + member.getName() + ": " + member.getForfeit());
        } else {
            System.out.println("No forfeit for Member " + member.getName());
        }
    }

}
