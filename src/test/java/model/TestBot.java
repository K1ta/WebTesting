package model;

import java.io.IOException;
import java.util.Properties;

public class TestBot {
    private final String mail;
    private final String password;

    public TestBot(String login, String password) {
        this.mail = login;
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public static TestBot getDefault() {
        Properties properties = new Properties();
        try {
            properties.load(TestBot.class.getClassLoader().getResourceAsStream("login.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String login = properties.getProperty("login");
        String password = properties.getProperty("password");
        return new TestBot(login, password);
    }
}
