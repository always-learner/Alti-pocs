package com.servicedemo.services;

import com.servicedemo.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Component
public class UserService {

    private static final List<User> USER_LIST = new ArrayList<>();
    private static Long userCount = 3L;

    public void addNewUser(final User user) {
        if (Objects.isNull(user.getUserId())) {
            user.setUserId(++userCount);
        }
        USER_LIST.add(user);
    }

    public boolean updateUser(final User user) {
        final User user1 = USER_LIST.stream().filter(listUser -> listUser.getUserId().equals(user.getUserId())).findFirst().orElse(null);
        if (Objects.isNull(user1)) {
            return false;
        } else {
            int i = USER_LIST.indexOf(user1);
            USER_LIST.remove(i);
            USER_LIST.add(i, user);
            return true;
        }
    }

    public List<User> getAllUsers(){
        return new ArrayList<>(USER_LIST);
    }

    public User getUserById(final Long userId){
        return USER_LIST.stream().filter(user -> user.getUserId().equals(userId)).findFirst().orElse(null);
    }

    public boolean removeUserById(final Long userId){
        return USER_LIST.removeIf(user -> user.getUserId().equals(userId));
    }

    public boolean removeByUser(final User user){
        return USER_LIST.removeIf(user1 -> user1.equals(user));
    }

    static {
        USER_LIST.add(new User(1l, "test user1", new Date()));
        USER_LIST.add(new User(2l, "test user2", new Date()));
        USER_LIST.add(new User(3l, "test user3", new Date()));
    }
}
