package com.dragovorn.bt.manager;

import com.dragovorn.bt.entity.user.User;

import java.util.UUID;

public interface IUserManager {

    User getFromUUID(UUID uuid);
    User getFromUsername(String username);
    User getFromEmail(String email);

    boolean isUsernameTaken(String username);
    boolean isEmailTaken(String email);

    void registerUser(User user);
}
