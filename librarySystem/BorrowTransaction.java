/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarySystem;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;


/**
 *
 * @author Aladdin
 */
class BorrowTransaction {
    private int idTransaction=1;
    private int idMember;
    private int ISBN;
    private String returnTime;

    // Constructor, getters, setters, and other methods as needed

    public BorrowTransaction( int idMember, int ISBN) {
        this.idTransaction = idTransaction++;
        this.idMember = idMember;
        this.ISBN = ISBN;
        //this.returnTime= returnTime;
        LocalDateTime myObj = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.returnTime = myObj.format(dateTimeFormatter);
        
    }
    public BorrowTransaction() {
        this.idTransaction = 0;
        this.idMember = 0;
        this.ISBN = 0;
        this.returnTime = null;
    }

    public int getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }

    public int getIdMember() {
        return idMember;
    }

    public void setIdMember(int idMember) {
        this.idMember = idMember;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }
    
    
}
