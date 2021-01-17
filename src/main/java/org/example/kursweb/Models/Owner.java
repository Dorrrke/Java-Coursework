package org.example.kursweb.Models;



public class Owner
{
    private int id;
    private String login;
    private String name;
    private String company_name;
    private String pass;

    public Owner(int id, String login, String name, String company_name, String pass) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.company_name = company_name;
        this.pass = pass;
    }

    public Owner() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
