package lv.javaguru.java2.services.checksServices;


import lv.javaguru.java2.database.ChecksDAO;
import lv.javaguru.java2.database.jdbc.ChecksDAOImpl;
import lv.javaguru.java2.domain.checks.Checks;

import java.sql.Date;
import java.sql.SQLException;

import static lv.javaguru.java2.domain.checks.ChecksBuilder.createCheck;

public class ChecksFactoryImpl implements ChecksFactory {
    private  ChecksValidator checksValidator = new CheckValidatorImpl();
    private ChecksDAO checksDAO = new ChecksDAOImpl();

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