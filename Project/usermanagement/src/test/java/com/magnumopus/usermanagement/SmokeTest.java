package com.magnumopus.usermanagement;

import com.magnumopus.usermanagement.controllers.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This test will serve as an end-to-end integration test, as spring will need the whole thing
 * running even if we want to run a simple not null on user controller
 * */

@SpringBootTest
@ActiveProfiles("test")
public class SmokeTest {

    @Autowired
    private UserController userController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(userController).isNotNull();
    }
}