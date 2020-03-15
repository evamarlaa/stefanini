package com.example.stefanini.resourcemodel;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.Date;

public class PersonResource {

    private String name;
    private String cpf;
    @JsonProperty("created_at")
    private Date createdAt;
    @JsonProperty("updated_at")
    private LocalDate updatedAt;
    private Character gender;
    private String email;
    private String nationality;
    @JsonProperty("place_of_birth")
    private String placeOfBirth;
    private String birthday;

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    @Override
    public String toString() {
        return "PersonResource{" +
                "name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", birthday=" + birthday +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", nationality='" + nationality + '\'' +
                ", placeOfBirth='" + placeOfBirth + '\'' +
                '}';
    }
}
