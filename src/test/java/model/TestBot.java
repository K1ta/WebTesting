package model;

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
}
