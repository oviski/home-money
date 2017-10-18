package lv.javaguru.java2.smvc;

import lv.javaguru.java2.domain.users.Users;
import lv.javaguru.java2.domain.usersMoneyAccount.UsersMoneyAccount;
import lv.javaguru.java2.services.checksServices.ChecksFactory;
import lv.javaguru.java2.services.usersServices.UsersSearch;
import lv.javaguru.java2.services.usersMoneyAccountServices.UsersMoneyAccountSearch;
//import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by admin on 15.06.2017.
 */
@Controller
@RequestMapping("/smvcNewCheck")
public class SpringNewCheckController {
    @Autowired
    private UsersSearch usersSearch;
    @Autowired
    private UsersMoneyAccountSearch usersMoneyAccountSearch;//
    @Autowired
    private ChecksFactory checksFactory;

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(HttpServletRequest req, HttpServletResponse resp, Model model) {
        //model.addAllAttributes("text/html");

        //Map<String, String> params = new HashMap<>();
        String varTextB = "";
        //UsersSearch usersSearch = new UsersSearchImpl();
        Optional<List<Users>> usersOptional = usersSearch.getAllUsers();

        for (Users users : usersOptional.get()) {
            varTextB += "<option value = " + users.getUserID() + ">" + users.getUserName() + "</option>";
        }
        model.addAttribute("jspUserList", varTextB);

        String varTextA = "";
        // UsersMoneyAccountSearch usersMoneyAccountSearch = new UsersMoneyAccountSearchImpl();
        Optional<List<UsersMoneyAccount>> usersMoneyAccountsOptional = usersMoneyAccountSearch.getAllUsersMoneyAccounts();

        for (UsersMoneyAccount usersMoneyAccount : usersMoneyAccountsOptional.get()) {
            varTextA += "<option value = " + usersMoneyAccount.getUserMoneyAccountID() + ">" + usersMoneyAccount.getMoneyAccountName() + "</option>";
        }
        model.addAttribute("jspUsersMoneyAccountList", varTextA);

        Map<String, String[]> requestMap = req.getParameterMap();
        for (String key : requestMap.keySet()) {
            model.addAttribute(key, requestMap.get(key)[0]);
        }

        //model.addAttribute("newCheck.jsp", params);
        return "smvcNewCheck";

    }

    @RequestMapping(method = RequestMethod.POST)
     public String doPost(HttpServletRequest req, HttpServletResponse resp, Model model) {
        //ChecksFactory checksFactory = new ChecksFactoryImpl();
//        Map<String, String> params = new HashMap<>();

        try {

            checksFactory.createFromMap(req.getParameterMap());
            model.addAttribute("urlAddCheck", "smvcNewCheck" );
            model.addAttribute("urlAllChecks", "smvcAllChecksList");


        } catch (ParseException e) {
            e.printStackTrace();
            String error = "<textarea>" + e.getMessage() + "</textarea>";
            model.addAttribute("javaError", error);
            return doGet(req, resp, model);
        } catch (SQLException e) {
            e.printStackTrace();
            String error = "<textarea>" + e.getMessage() + "</textarea>";
            model.addAttribute("javaError", error);
            return doGet(req, resp, model);
        }

        // vse horosho
        return "smvcAddCheckOK";

    }

}

