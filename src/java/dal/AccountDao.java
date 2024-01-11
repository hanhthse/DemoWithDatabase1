/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Account;
import mylib.DBUtils;

/**
 *
 * @author Acer
 */
public class AccountDao {

    //ham nay de check email, pass word co trong bang account hay khong
    public Account getAccount(String email, String password) {
        Account result = null;
        Connection cn = null;
        try {
            //make connection
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "SELECT [AccId]\n"
                        + "      ,[Email]\n"
                        + "      ,[FullName]\n"
                        + "      ,[Password]\n"
                        + "  FROM [dbo].[Accounts] where Email=? and Password=? COLLATE SQL_Latin1_General_CP1_CI_AS";
                PreparedStatement pst = cn.prepareStatement(sql);
                // lay email, password gan vao 2 cho ?
                pst.setString(1, email);
                pst.setString(2, password);
                //run sql
                ResultSet table=pst.executeQuery();
                //doc data trong table
                if(table!=null && table.next()){
                    int m_accid= table.getInt("AccId");
                    String m_email = table.getString("Email");
                    String m_fullname = table.getString("FullName");
                    String m_password = table.getString("Password");
                    result= new Account(m_accid, m_email, m_fullname, m_password);
                }
            }
        } catch (Exception e) {

        } finally {

        }
        return result;

    }
}
