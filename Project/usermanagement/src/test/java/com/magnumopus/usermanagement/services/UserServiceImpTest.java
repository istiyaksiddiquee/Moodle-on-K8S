package com.magnumopus.usermanagement.services;

import com.magnumopus.usermanagement.models.User;
import com.magnumopus.usermanagement.repositories.AuditRepository;
import com.magnumopus.usermanagement.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@ExtendWith(MockitoExtension.class)
class UserServiceImpTest {

    @Mock
    UserRepository userRepository;

    @Mock
    AuditRepository auditRepository;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    void findAllUser() {

        User user = new User();
        List<User> createdList = new ArrayList<>();
        createdList.add(user);

        Mockito.when(userRepository.findAll()).thenReturn(createdList);

        List<User> userList = userService.findAllUser();
        assertEquals(userList.size(), 1);

        Mockito.verify(userRepository, Mockito.times(1)).findAll();
    }
}