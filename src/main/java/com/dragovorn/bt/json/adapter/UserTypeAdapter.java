package com.dragovorn.bt.json.adapter;

import com.dragovorn.bt.entity.user.User;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class UserTypeAdapter extends TypeAdapter<User> {

    private static final DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public void write(JsonWriter writer, User user) throws IOException {
        writer.beginObject();
        writer.name("uuid").value(user.getUID().toString());
        writer.name("email").value(user.getEmail());
        writer.name("username").value(user.getUsername());
        writer.name("display_name").value(user.getDisplayName());

        if (user.hasBirthDate()) {
            writer.name("birth_date").value(format.format(user.getBirthDate()));
        }

        if (user.hasLastName() || user.hasFirstName()) {
            writer.name("name").beginObject();

            if (user.hasFirstName()) {
                writer.name("first").value(user.getFirstName());
            }

            if (user.hasLastName()) {
                writer.name("last").value(user.getLastName());
            }

            writer.endObject();
        }

        writer.endObject();
    }

    @Override
    public User read(JsonReader jsonReader) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
