package com.magnumopus.usermanagement.services;

import com.magnumopus.usermanagement.models.User;

import java.util.List;

public interface UserService {

    /**
     * @param user
     * @return
     */
    public User persistUser(User user);

    /**
     * @param userId
     * @return
     */
    public User fetchUser(int userId);

    /***
     * @param user
     * */
    public void updateParticularUser(User user);

    /**
     * @param start
     * @param end
     * @param totalUserCount
     * @return
     */
    public List<User> getUserList(int start, int end, int totalUserCount);

    /**
     * @return
     */
    public List<User> findAllUser();

    /***
     * @param userName
     * @return
     * */
    public User getUserByUserName(String userName);

    /**
     * @param userId
     */
    public void deleteUser(int userId);
}

