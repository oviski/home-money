package lv.javaguru.java2.smvc;

import lv.javaguru.java2.domain.checks.Checks;
import lv.javaguru.java2.domain.users.Users;
import lv.javaguru.java2.domain.usersMoneyAccount.UsersMoneyAccount;
import lv.javaguru.java2.services.checksServices.ChecksSearch;
//import lv.javaguru.java2.services.checksServices.ChecksSearchImpl;
import lv.javaguru.java2.services.usersServices.UsersSearch;
//import lv.javaguru.java2.services.usersServices.UsersSearchImpl;
import lv.javaguru.java2.services.usersMoneyAccountServices.UsersMoneyAccountSearch;
//import lv.javaguru.java2.services.usersMoneyAccountServices.UsersMoneyAccountSearchImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by admin on 09.06.2017.
 */

@Controller
@RequestMapping("/smvcAllChecksList")
public class SpringAllChecksListController {
    @Autowired
    private ChecksSearch checksSearch;
    @Autowired
    private UsersSearch usersSearch;
    @Autowired
    private UsersMoneyAccountSearch usersMoneyAccountSearch;


    @RequestMapping(method = RequestMethod.GET)
    public String doGet(HttpServletRequest req, HttpServletResponse resp, Model model){
        String varTextC= "";
//        ChecksSearch checksSearch = new ChecksSearchImpl();
//        UsersSearch usersSearch = new UsersSearchImpl();
//        UsersMoneyAccountSearch usersMoneyAccountSearch = new UsersMoneyAccountSearchImpl();
        Optional<List<Checks>> checksOptional = checksSearch.getAllChecks();
        List<Checks> checksList = new ArrayList<>();
        if (checksOptional == null){
            varTextC = "<tr><td>" + "Checks not found" + "</td></tr>";
        } else { checksList = checksOptional.get();

            for (Checks checks:checksList){
                Optional<Users> usersOptional = usersSearch.getUsersByUserID(checks.getUserID());
                Optional<UsersMoneyAccount> usersMoneyAccountOptional = usersMoneyAccountSearch.getByUsersMoneyAccountID(checks.getUserMoneyAccountID());
                varTextC += "<tr><td>"
                        + checks.getCheckID() + "</td><td>"
                        + checks.getDataPourches() + "</td><td>"
                        + checks.getSumOfCheck() + "</td><td>"
                        + checks.getShopName() + "</td><td>"
                        + (usersOptional.isPresent() ? usersOptional.get().getUserName(): "User not present") + "</td><td>"
                        + (usersMoneyAccountOptional.isPresent()? usersMoneyAccountOptional.get().getMoneyAccountName() : "Unknown account") + "</td><td>"

                        + (checks.getDetailAllow()? "Detail is present" : "detail is empty")   + "</td><td>"
                        + checks.getComments() + "</td></tr>";
            }
        }
        model.addAttribute("jspChecksList", varTextC);
        return "smvcAllChecksList";
        //return "smvcAllChecksList";

    }

}
