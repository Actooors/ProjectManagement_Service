package com.management.security;

import com.management.model.entity.User;

/**
 * @program: management
 * @description:
 * @author: ggmr
 * @create: 2019-01-05 16:31
 */
public class UserContext implements AutoCloseable {

    public static final ThreadLocal<User> current = new ThreadLocal<>();

    public UserContext(User user) {
        current.set(user);
    }

    public static User getCurrentUser() {
        return current.get();
    }

    @Override
    public void close() {
        current.remove();
    }
}
