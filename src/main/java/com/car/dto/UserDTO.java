package com.car.dto;

public class UserDTO
{

    private String login;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String secretCode;

    public UserDTO()
    {

    }

    public UserDTO(String login, String password, String email, String firstName, String lastName, String secretCode)
    {
        this.login = login;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.secretCode = secretCode;
    }

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getSecretCode()
    {
        return secretCode;
    }

    public void setSecretCode(String secretCode)
    {
        this.secretCode = secretCode;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", secretCode='" + secretCode + '\'' +
                '}';
    }
}
