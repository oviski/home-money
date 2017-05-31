package lv.javaguru.java2.servlet;


import lv.javaguru.java2.database.ChecksDAO;
import lv.javaguru.java2.database.UsersMoneyAccountDAO;
import lv.javaguru.java2.database.jdbc.ChecksDAOImpl;
import lv.javaguru.java2.database.jdbc.UsersDAOImpl;
import lv.javaguru.java2.database.jdbc.UsersMoneyAccountDAOImpl;
import lv.javaguru.java2.domain.checks.Checks;
import lv.javaguru.java2.domain.users.Users;
import lv.javaguru.java2.domain.usersMoneyAccount.UsersMoneyAccount;
import lv.javaguru.java2.services.checksServices.ChecksFactory;
import lv.javaguru.java2.services.checksServices.ChecksFactoryImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 28.05.2017.
 */
public class NewChecksServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        // Prepare output html
        response.setContentType("text/html");

        String varTextB = "";
        UsersDAOImpl usersDAO = new UsersDAOImpl();
        List<Users> usersList = usersDAO.getAll();
        for (Users users:usersList){
            varTextB += "<option value = " + users.getUserID() + ">" + users.getUserName() + "</option>";
        }
        request.setAttribute("jspUserList", varTextB);

        String varTextA = "";
        UsersMoneyAccountDAOImpl usersMoneyAccountDAO = new UsersMoneyAccountDAOImpl();
        List<UsersMoneyAccount> usersMoneyAccountList =usersMoneyAccountDAO.getAll();
        for (UsersMoneyAccount usersMoneyAccount:usersMoneyAccountList){
            varTextA += "<option value = " + usersMoneyAccount.getUserMoneyAccountID() + ">" + usersMoneyAccount.getMoneyAccountName() + "</option>";
        }
        request.setAttribute("jspUsersMoneyAccountList", varTextA);

        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/newCheck.jsp");

        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException{
        ChecksFactory checksFactory = new ChecksFactoryImpl();
        ChecksDAO checksDAO = new ChecksDAOImpl();
        try {

            checksFactory.createFromMap(req.getParameterMap());


        } catch (ParseException e) {
            e.printStackTrace();
            String error = "<textarea>"+ e.getMessage() +"</textarea>";
            req.setAttribute("javaError",error);
            doGet(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
            String error = "<textarea>"+ e.getMessage() +"</textarea>";
            req.setAttribute("javaError",error);
            doGet(req,resp);
        }

        // vse horosho
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/addCheckOk.jsp");

        requestDispatcher.forward(req, resp);

    }



}
