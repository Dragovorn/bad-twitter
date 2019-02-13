package com.dragovorn.bt.entity.user;

import com.dragovorn.bt.json.adapter.UserTypeAdapter;
import com.dragovorn.bt.util.Hashing;
import com.google.gson.annotations.JsonAdapter;

import java.util.Date;
import java.util.UUID;

@JsonAdapter(UserTypeAdapter.class)
public class User {

    private final UUID uid;

    private String email;
    private String username;
    private String firstName;
    private String lastName;
    private String displayName;
    private String passwordHash;

    private Date birthDate;

    public static Builder builder() {
        return new Builder();
    }

    private User(Builder builder) {
        this.uid = UUID.randomUUID();
        this.email = builder.email;
        this.username = builder.username;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.passwordHash = builder.passwordHash;
        this.birthDate = builder.birthDate;

        if (this.firstName == null && this.lastName == null) {
            this.displayName = this.username;
        } else if (this.lastName == null) {
            this.displayName = this.firstName;
        } else if (this.firstName == null) {
            this.displayName = this.lastName;
        } else {
            this.displayName = this.firstName + " " + this.lastName;
        }
    }

    public UUID getUID() {
        return this.uid;
    }

    public String getEmail() {
        return this.email;
    }

    public String getUsername() {
        return this.username;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getPasswordHash() {
        return this.passwordHash;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public boolean hasBirthDate() {
        return this.birthDate != null;
    }

    public boolean hasFirstName() {
        return this.firstName != null;
    }

    public boolean hasLastName() {
        return this.lastName != null;
    }

    public static class Builder {

        private String email;
        private String username;
        private String firstName;
        private String lastName;
        private String passwordHash;

        private Date birthDate;

        private Builder() {

        }

        public Builder setEmail(String email) {
            this.email = email;

            return this;
        }

        public Builder setUsername(String username) {
            this.username = username;

            return this;
        }

        public Builder setName(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;

            return this;
        }

        public Builder setPassword(String password) {
            this.passwordHash = Hashing.hash(password);

            return this;
        }

        public Builder setBirthDate(Date birthDate) {
            this.birthDate = birthDate;

            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
