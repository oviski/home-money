package lv.javaguru.java2.services.checksServices;


import lv.javaguru.java2.database.ChecksDAO;
import lv.javaguru.java2.database.jdbc.ChecksDAOImpl;
import lv.javaguru.java2.domain.checks.Checks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import static lv.javaguru.java2.domain.checks.ChecksBuilder.createCheck;

@Component
public class ChecksFactoryImpl implements ChecksFactory {
    @Autowired
    private  ChecksValidator checksValidator; // = new CheckValidatorImpl();
    @Autowired
    private ChecksDAO checksDAO; // = new ChecksDAOImpl();

    @Override
    public Checks create(Date dataPourches, Long sumOfCheck, String shopName, Integer userID, Integer userMoneyAccountID, Boolean detailAllow, String comments) throws SQLException {
        checksValidator.validate(dataPourches, sumOfCheck, shopName, userID, userMoneyAccountID, detailAllow, comments);

        Checks checks = createCheck()
                .withDatePourches(dataPourches)
                .withSumOfCheck(sumOfCheck)
                .withShopName(shopName)
                .withWhoPayID(userID)
                .withUserMoneyAccountID(userMoneyAccountID)
                .withDetailAllow(detailAllow)
                .withComments(comments).build();

        return checksDAO.save(checks);
    }

    @Override
    public Checks createFromMap(Map<String, String[]> params) throws ParseException, SQLException {

        checksValidator.validateMaps(params);

        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        return create(
                format.parse(params.get("dataPourches")[0]),
                Long.parseLong(params.get("sumOfCheck")[0]),
                params.get("shopName")[0],
                Integer.parseInt(params.get("userID")[0]),
                Integer.parseInt(params.get("userMoneyAccountID")[0]),
                Boolean.parseBoolean(params.get("detailsAllow")[0]),
                params.get("comments")[0]
                );
    }
}

/*
private UserValidator userValidator = new UserValidatorImpl();
    private UserDAO userDAO = new UserDAOImpl();


    @Override
    public User create(String firstName, String lastName) {
        userValidator.validate(firstName, lastName);

        User user = createUser()
                .withFirstName(firstName)
                .withLastName(lastName).build();

        return userDAO.save(user);
    }

 */