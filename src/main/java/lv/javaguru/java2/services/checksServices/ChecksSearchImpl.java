package lv.javaguru.java2.services.checksServices;

import lv.javaguru.java2.database.ChecksDAO;
import lv.javaguru.java2.database.jdbc.ChecksDAOImpl;
import lv.javaguru.java2.domain.checks.Checks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by admin on 03.06.2017.
 */
@Component
public class ChecksSearchImpl implements ChecksSearch {
    @Autowired
    private  ChecksDAO checksDAO;
    @Override
    public Optional<List<Checks>> getAllChecks() {
        //ChecksDAO checksDAO = new ChecksDAOImpl();
        List<Checks> allCheksInDB = checksDAO.getAll();
        return Optional.of(allCheksInDB);
    }

    @Override
    public Optional<List<Checks>> getChecksByUsers(Integer userID) {
        List<Checks> checksList = new ArrayList<>();
        //ChecksDAO checksDAO = new ChecksDAOImpl();
        List<Checks> allCheksInDB = checksDAO.getAll();
        for (Checks checks:allCheksInDB){
            if (checks.getUserID()==userID){
                checksList.add(checks);
            }
        }
        return Optional.of(checksList);
    }

    @Override
    public Optional<List<Checks>> getChecksByDate(Date dataOfPourches) {
        List<Checks> checksList = new ArrayList<>();
        //ChecksDAO checksDAO = new ChecksDAOImpl();
        List<Checks> allCheksInDB = checksDAO.getAll();
        for (Checks checks:allCheksInDB){
            if (checks.getDataPourches()==dataOfPourches){
                checksList.add(checks);
            }
        }
        return Optional.of(checksList);
    }

    @Override
    public Optional<List<Checks>> getChecksByUserMoneyAccount(Integer userMoneyAccountID) {
        List<Checks> checksList = new ArrayList<>();
        //ChecksDAO checksDAO = new ChecksDAOImpl();
        List<Checks> allCheksInDB = checksDAO.getAll();
        for (Checks checks:allCheksInDB){
            if (checks.getUserMoneyAccountID()==userMoneyAccountID){
                checksList.add(checks);
            }
        }
        return Optional.of(checksList);
    }

    @Override
    public Optional<Checks> getChecksByCheksID(Long checksID) {
        //ChecksDAO checksDAO = new ChecksDAOImpl();
        Optional<Checks> checks = checksDAO.getById(checksID);
        return checks;
    }
}
