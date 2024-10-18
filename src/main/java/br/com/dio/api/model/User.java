package br.com.dio.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    private Long id;
    private String login;
    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String toString() {
        return new StringBuilder().append("{")
                .append("id:")
                .append(id)
                .append(",")
                .append("login:")
                .append(login)
                .append(",")
                .append("password:")
                .append("}").toString();
    }

}
