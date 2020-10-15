package com.magnumopus.usermanagement.repositories;

import com.magnumopus.usermanagement.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase
@ActiveProfiles("test")
class UserRepositoryIT {

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findByUserNameNamedNativeOrmXml() {
        String userName = "istiyaksiddiquee";
        List<User> userByUserName = userRepository.findByUserNameNamedNativeOrmXml(userName);

        User user = userByUserName.get(0);
        assertEquals(user.getFirstName(), "Istiyak");

    }
}