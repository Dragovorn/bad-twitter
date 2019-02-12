package com.dragovorn.bt.util;

import co.melondev.Inquire.core.manager.IDatabaseManager;
import com.google.common.base.Preconditions;

import java.io.InputStream;
import java.util.Scanner;

public class DatabaseUtil {

    private static IDatabaseManager manager;

    public static void init(IDatabaseManager manager) {
        Preconditions.checkNotNull(manager);

        if (DatabaseUtil.manager != null) {
            return;
        }

        DatabaseUtil.manager = manager;
    }

    public static void execute(InputStream stream) {
        Scanner scanner = new Scanner(stream);
        scanner.useDelimiter("(;(\r)?\n)|(--\n)");

        while (scanner.hasNext()) {
            String line = scanner.next();
            if (line.startsWith("/*!") && line.endsWith("*/")) {
                int index = line.indexOf(' ');
                line = line.substring(index + 1, line.length() - " */".length());
            }

            if (line.trim().length() > 0) {
                manager.execute(line);
            }
        }
    }
}
