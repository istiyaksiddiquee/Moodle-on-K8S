package com.magnumopus.usermanagement.services;

import com.magnumopus.usermanagement.models.User;
import com.magnumopus.usermanagement.repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    /***
     * @see com.magnumopus.usermanagement.services.UserService#persistUser(User)
     * */
    @Override
    public User persistUser(User user) {
        userRepository.save(user);
        return user;
    }

    /***
     * @see com.magnumopus.usermanagement.services.UserService#fetchUser(int)
     * */
    @Override
    public User fetchUser(int userId) {
        return userRepository.findById(userId).get();
    }

    /***
     * @see com.magnumopus.usermanagement.services.UserService#updateParticularUser(User)
     * */
    @Override
    public void updateParticularUser(User user) {
        userRepository.save(user);
    }

    /***
     * @see com.magnumopus.usermanagement.services.UserService#getUserList(int, int, int)
     * */
    @Override
    public List<User> getUserList(int start, int end, int totalUserCount) {
        return this.findAllUser();
    }

    /***
     * @see UserService#findAllUser()
     * */
    @Override
    public List<User> findAllUser() {
        List<User> returnList = new ArrayList<>();

        if(userRepository.findAll() != null) {
            for (User user: userRepository.findAll()) {
                returnList.add(user);
            }
        }

        return returnList;
    }

    @Override
    public User getUserByUserName(String userName) {
        List<User> userList = userRepository.findByUserNameNamedNativeOrmXml(userName);
        User user = null;
        if (userList != null && !userList.isEmpty()) {
            user = userList.get(0);
        }
        return user;
    }

    /***
     * @see com.magnumopus.usermanagement.services.UserService#deleteUser(int)
     * */
    @Override
    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }
}
