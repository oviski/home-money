package lv.javaguru.java2.servlet;

import lv.javaguru.java2.database.UsersMoneyAccountDAO;
import lv.javaguru.java2.database.jdbc.ChecksDAOImpl;
import lv.javaguru.java2.database.jdbc.UsersDAOImpl;
import lv.javaguru.java2.database.jdbc.UsersMoneyAccountDAOImpl;
import lv.javaguru.java2.domain.checks.Checks;
import lv.javaguru.java2.domain.users.Users;
import lv.javaguru.java2.domain.usersMoneyAccount.UsersMoneyAccount;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * Created by admin on 31.05.2017.
 */
public class AllChecksListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String varTextC= "";
        ChecksDAOImpl checksDAO = new ChecksDAOImpl();
        UsersDAOImpl usersDAO = new UsersDAOImpl();
        UsersMoneyAccountDAO usersMoneyAccountDAO = new UsersMoneyAccountDAOImpl();
        List<Checks> checksList = checksDAO.getAll();
        for (Checks checks:checksList){
            Optional<Users> users = usersDAO.getById(checks.getUserID());
            Optional<UsersMoneyAccount> usersMoneyAccount = usersMoneyAccountDAO.getById(checks.getUserMoneyAccountID());
            varTextC += "<tr><td>"
                    + checks.getCheckID() + "</td><td>"
                    + checks.getDataPourches() + "</td><td>"
                    + checks.getSumOfCheck() + "</td><td>"
                    + checks.getShopName() + "</td><td>"
                    + (users.isPresent() ? users.get().getUserName(): "User not present") + "</td><td>"
                    + (usersMoneyAccount.isPresent()? usersMoneyAccount.get().getMoneyAccountName() : "User Money Account not present") + "</td><td>"
                    + (checks.getDetailAllow()? "Detail is present" : "detail is empty")   + "</td><td>"
                    + checks.getComments() + "</td></tr>";
        }
        req.setAttribute("jspChecksList", varTextC);

        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/allCheckList.jsp");

        requestDispatcher.forward(req, resp);

    }
}
