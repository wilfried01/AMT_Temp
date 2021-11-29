package ch.heig.amt2021.model;

import java.io.Serializable;


public class Utilisateur implements Serializable{

    private int id;
    private String login;
    private String password;
    private boolean admin = false;

    public Utilisateur(String login, String password) {
        this.password = password;
        this.login = login;
    }

    public Utilisateur(int id, String login, String password) {
        this.id = id;
        this.password = password;
        this.login = login;
    }

    public void setId(int id){this.id = id;}

    public int getId() { return id;  }

    public void setLogin(String login) { this.login = login;  }

    public String getLogin() { return login; }

    public String getPassword() { return password;    }

    public void setPassword(String password) { this.password = password; }

    public boolean isAdmin() { return admin;    }

    public void setAdmin(boolean admin) {  this.admin = admin; }

}
