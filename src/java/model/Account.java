/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Acer
 */
public class Account {
    private int accid;
    private String fullname;
    private String email;
    private String password;

    public Account() {
        this.accid = 0;
      
    }

    public Account(int accid, String fullname, String email, String password) {
        this.accid = accid;
        this.fullname = fullname;
        this.email = email;
        this.password = password;
    }

    public int getAccid() {
        return accid;
    }

    public void setAccid(int accid) {
        this.accid = accid;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account{" + "accid=" + accid + ", fullname=" + fullname + ", email=" + email + ", password=" + password + '}';
    }
    
}
