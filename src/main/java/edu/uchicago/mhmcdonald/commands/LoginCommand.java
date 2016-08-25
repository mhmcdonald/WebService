package edu.uchicago.mhmcdonald.commands;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by markmcdonald on 8/18/16.
 * This command is necessary for the login form authentication
 */
public class LoginCommand {
    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
