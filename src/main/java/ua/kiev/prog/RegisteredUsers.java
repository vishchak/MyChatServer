package ua.kiev.prog;

import java.util.HashMap;
import java.util.Map;

public class RegisteredUsers {
    private static final Map<String, String> regUsers = new HashMap<>();

    static {
        regUsers.put("admin", "admin");
    }

    public synchronized static Map<String, String> usersGetInstance() {
        return regUsers;
    }

}

