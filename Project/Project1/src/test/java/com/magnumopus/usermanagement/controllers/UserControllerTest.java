package com.magnumopus.usermanagement.controllers;

import com.magnumopus.usermanagement.models.User;
import com.magnumopus.usermanagement.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UserControllerTest {

    UserController userController = new UserController();

    @Mock
    UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        userController.setUserService(userService);
    }

    @Test
    void testURLWithMockMVC() throws Exception {

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        mockMvc.perform(get("/users/"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getAllUser() {

        User user = new User();
        List<User> createdList = new ArrayList<>();
        createdList.add(user);

        Mockito.when(userService.findAllUser()).thenReturn(createdList);

        List<User> userList = userController.getAllUser();

        Mockito.verify(userService, Mockito.times(1)).findAllUser();
        assertEquals(userList.size(), 1);
    }
}