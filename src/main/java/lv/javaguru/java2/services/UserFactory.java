package lv.javaguru.java2.services;

import lv.javaguru.java2.domain.User;
import org.springframework.stereotype.Component;

@Component
public interface UserFactory {

    User create(String firstName, String lastName);

}
