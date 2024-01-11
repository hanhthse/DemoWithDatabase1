/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.AccountDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;

/**
 *
 * @author Acer
 */
public class LoginController extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            //lay email pass word
            String email = request.getParameter("txtemail");
            String password = request.getParameter("txtpassword");
            //check trong db cos email.pass nafy khong
            AccountDao dao = new AccountDao();
            Account acc = dao.getAccount(email, password);
            if(acc!=null){
                response.sendRedirect("adminHome.html");
            }else{
                response.sendRedirect("error.html");
            }
            
    }


}
