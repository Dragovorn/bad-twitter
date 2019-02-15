package com.dragovorn.bt;

import co.melondev.Inquire.core.manager.DatabaseManager;
import co.melondev.Inquire.core.manager.IDatabaseManager;
import co.melondev.Inquire.info.DatabaseInfo;
import co.melondev.Inquire.info.IDatabaseInfo;
import com.dragovorn.bt.manager.IUserManager;
import com.dragovorn.bt.manager.UserManager;
import com.dragovorn.bt.util.DatabaseUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {JacksonAutoConfiguration.class})
public class BadTwitter {

    private static IDatabaseManager manager;

    private static IUserManager userManager;

    public static void main(String... args) {
        SpringApplication.run(BadTwitter.class, args);

        IDatabaseInfo info = DatabaseInfo.newBuilder()
                .setDatabase("bad-twitter")
                .setUsername("bad-twitter")
                .setPassword("password")
                .setHostname("localhost")
                .build();

        manager = new DatabaseManager(info);
        DatabaseUtil.init(manager);

        userManager = new UserManager();
    }

    public static IUserManager getUserManager() {
        return userManager;
    }

    public static IDatabaseManager getManager() {
        return manager;
    }
}