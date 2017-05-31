package lv.javaguru.java2.servlet;

import lv.javaguru.java2.domain.users.Users;
import lv.javaguru.java2.domain.usersMoneyAccount.UsersMoneyAccount;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 29.05.2017.
 */
public class CreateCheckServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {

        // Set response content type
        resp.setContentType("text/html");
        List<Users> usersList = new ArrayList();
        List<UsersMoneyAccount> usersMoneyAccountList = new ArrayList<>();

        System.out.println();



        // Prepare output html
        PrintWriter out = resp.getWriter();
        out.println("<h1>" + "Hello WWW world from Java!" + "</h1>");
        out.println("<h1>" + "Hello WWW world from Java!" + "</h1>");
        out.println("<select name=\"example\">");
        /*for (Users usr:${usersList}){
            out.println("<option value = " + usr.getUserName().toString() + ">" + usr.getUserID().toString() + "</option>");
        }
*/
        out.println("<select name=\"example\">");
    }



}
