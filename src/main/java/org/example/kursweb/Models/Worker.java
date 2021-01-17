package org.example.kursweb.Models;

public class Worker {
    private int id;
    private String login;
    private String name;
    private String phone_number;
    private String employer;
    private String pass;

    public Worker() {
    }

    public Worker(int id, String name, String phone_number, String employer, String pass, String login) {
        this.id = id;
        this.name = name;
        this.phone_number = phone_number;
        this.employer = employer;
        this.pass = pass;
        this.login = login;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
