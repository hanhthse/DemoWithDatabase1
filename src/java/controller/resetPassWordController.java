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

/**
 *
 * @author Acer
 */
public class resetPassWordController extends HttpServlet {

    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //lay ve
        PrintWriter out = response.getWriter();
        String accid= request.getParameter("accid");
        
        int id = Integer.parseInt(accid.substring(0, accid.length()-1));
        
        AccountDao dao = new AccountDao();
        int result = 0;
        result = dao.resetPass(id);
        
        if(result > 0){  
            response.sendRedirect("manageAccountController");
        }else{
            System.err.println("Error delete method() ");
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
