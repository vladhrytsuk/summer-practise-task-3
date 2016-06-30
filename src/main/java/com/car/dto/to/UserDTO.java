package com.car.dto.to;

public class UserDTO
{

    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String secretCode;

    public UserDTO()
    {

    }

    public UserDTO(String username, String password, String email, String firstName, String lastName, String secretCode)
    {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.secretCode = secretCode;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
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

}
