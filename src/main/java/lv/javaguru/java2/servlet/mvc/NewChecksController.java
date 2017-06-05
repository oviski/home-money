package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.domain.users.Users;
import lv.javaguru.java2.domain.usersMoneyAccount.UsersMoneyAccount;
import lv.javaguru.java2.services.checksServices.ChecksFactory;
import lv.javaguru.java2.services.checksServices.ChecksFactoryImpl;
import lv.javaguru.java2.services.userServices.UsersSearch;
import lv.javaguru.java2.services.userServices.UsersSearchImpl;
import lv.javaguru.java2.services.usersMoneyAccountServices.UsersMoneyAccountSearch;
import lv.javaguru.java2.services.usersMoneyAccountServices.UsersMoneyAccountSearchImpl;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by admin on 05.06.2017.
 */
public class NewChecksController implements MVCController {
    @Override
    public MVCModel processRequestGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");

        Map<String, String> params = new HashMap<>();
        String varTextB = "";
        UsersSearch usersSearch = new UsersSearchImpl();
        Optional<List<Users>> usersOptional = usersSearch.getAllUsers();

        for (Users users:usersOptional.get()){
            varTextB += "<option value = " + users.getUserID() + ">" + users.getUserName() + "</option>";
        }
        params.put("jspUserList", varTextB);

        String varTextA = "";
        UsersMoneyAccountSearch usersMoneyAccountSearch = new UsersMoneyAccountSearchImpl();
        Optional<List<UsersMoneyAccount>> usersMoneyAccountsOptional = usersMoneyAccountSearch.getAllUsersMoneyAccounts();

        for (UsersMoneyAccount usersMoneyAccount:usersMoneyAccountsOptional.get()){
            varTextA += "<option value = " + usersMoneyAccount.getUserMoneyAccountID() + ">" + usersMoneyAccount.getMoneyAccountName() + "</option>";
        }
        params.put("jspUsersMoneyAccountList", varTextA);

        Map<String, String[]> requestMap = request.getParameterMap();
        for (String key: requestMap.keySet()) {
            params.put(key, requestMap.get(key)[0]);
        }

        MVCModel model = new MVCModel("/newCheck.jsp", params);
        return model;

    }

    @Override
    public MVCModel processRequestPost(HttpServletRequest request, HttpServletResponse response) {
        ChecksFactory checksFactory = new ChecksFactoryImpl();
        Map<String, String> params = new HashMap<>();

        try {

            checksFactory.createFromMap(request.getParameterMap());


        } catch (ParseException e) {
            e.printStackTrace();
            String error = "<textarea>"+ e.getMessage() +"</textarea>";
            request.setAttribute("javaError",error);
            return processRequestGet(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            String error = "<textarea>"+ e.getMessage() +"</textarea>";
            request.setAttribute("javaError",error);
            return processRequestGet(request, response);
        }

        // vse horosho
        return new MVCModel("/addCheckOk.jsp");

        }
}