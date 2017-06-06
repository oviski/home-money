package lv.javaguru.java2.services.checksServices;

import lv.javaguru.java2.domain.checks.Checks;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by admin on 03.06.2017.
 */

public interface ChecksSearch {
    Optional<List<Checks>> getAllChecks();
    Optional<List<Checks>> getChecksByUsers(Integer userID);
    Optional<List<Checks>> getChecksByDate(Date dataOfPourches);
    Optional<List<Checks>> getChecksByUserMoneyAccount(Integer userMoneyAccountID);
    Optional<Checks> getChecksByCheksID(Long checksID);

}
