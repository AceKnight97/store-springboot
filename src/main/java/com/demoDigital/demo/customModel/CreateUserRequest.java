package com.demoDigital.demo.customModel;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
// import java.util.Set;

@Data
public class CreateUserRequest {

    @NotBlank
    private String username;
    @NotBlank
    private String phone;
    @NotBlank
    private String address;
    @NotBlank
    private String notes;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String password;

    // private Set<String> authorities;
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}
