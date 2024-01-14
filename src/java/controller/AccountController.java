/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.AccountDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;

/**
 *
 * @author Acer
 */
public class AccountController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Account> list = new ArrayList<>();
        // lay tat ca database 
        AccountDao dao = new AccountDao();
        list = dao.getAccounts();
        // xuat form nhap
       PrintWriter out = response.getWriter();
        //xuat form search
            out.print("<form action='' method='post'>");
            out.print("<input type='text' name ='txtsearch' placeholder='enter name' >");
            out.print("<input type='subbmit' value='GO' >");
            out.print("</form>");
            
            //xuat danh sach account ra man hinh
            out.print("<table>");
                out.print("<tr>");
                    out.print("<th>acc id</th>");
                    out.print("<th> name</th>");
                    out.print("<th> email</th>");
                    out.print("<th>action</th>");
                out.print("</tr>");
            if(list!=null && list.size()>0){
                for(Account acc: list){
                    out.print("<form action='delete' method='post'>");
                    out.print("<input type='hidden' name = 'txtid' value='"+acc.getAccid()+"'>");
                    
                    out.print("<tr>");
                    out.print("<td>" + acc.getAccid() +"</td>");
                    out.print("<td>" + acc.getFullname() +"</td>");
                    out.print("<td>" + acc.getEmail() +"</td>");
                    out.print("<td><input type='submit' value='remove'></td>");
                    out.print("<td><a href='resetPassWordController?accid="+acc.getAccid()+"'>reset password</td>");
                    out.print("</tr>");
                    out.print("</form>");
                }
            }
            out.print("</table>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
