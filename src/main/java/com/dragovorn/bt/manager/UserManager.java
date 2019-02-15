package com.dragovorn.bt.manager;

import com.dragovorn.bt.entity.user.User;
import com.github.benmanes.caffeine.cache.AsyncLoadingCache;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.CacheWriter;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.RemovalCause;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class UserManager implements IUserManager {

    private AsyncLoadingCache<UUID, User> users = Caffeine.newBuilder()
            .expireAfterAccess(10, TimeUnit.HOURS)
            .writer(new CacheWriter<UUID, User>() {
                @Override
                public void write(@Nonnull UUID uuid, @Nonnull User user) {
                    usersByEmail.put(user.getEmail(), user);
                }

                @Override
                public void delete(@Nonnull UUID uuid, @Nullable User user, @Nonnull RemovalCause removalCause) {

                }
            })
            .buildAsync((UUID uuid) -> {

                // TODO: fetch user data from the database

                return User.builder().build(); // TODO: Stubbed
            });

    private Cache<String, User> usersByEmail = Caffeine.newBuilder()
            .expireAfterAccess(10, TimeUnit.HOURS)
            .build();

    @Override
    public User getFromUUID(UUID uuid) {
        return null;
    }

    @Override
    public User getFromUsername(String username) {
        return null;
    }

    @Override
    public User getFromEmail(String email) {
        return null;
    }

    @Override
    public boolean isUsernameTaken(String username) {
        return false;
    }

    @Override
    public boolean isEmailTaken(String email) {
        return false;
    }

    @Override
    public void registerUser(User user) {

    }
}
