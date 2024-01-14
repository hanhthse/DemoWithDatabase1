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
public class delete extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        //get ve maid
        String accoutnID= request.getParameter("txtid");
        int id = Integer.parseInt(accoutnID.trim());
        //su dung accoutDao de xoa data
        out.print(id);
        AccountDao dao = new AccountDao();
        int success = dao.deleteById(accoutnID);
        
        out.print(success);
        if(success > 0){  
            response.sendRedirect("manageAccountController");
        }else{
            System.err.println("Error delete method() ");
        }
    }

    
}
