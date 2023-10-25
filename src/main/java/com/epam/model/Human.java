package com.epam.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.StringJoiner;

public abstract class Human {
    private String surname;
    private String name;
    private String patronymic;
    private LocalDateTime birthDate;
    private String address;
    private String phone;

    protected Human() {
    }

    protected Human(String surname, String name, String patronymic, LocalDateTime birthDate, String address, String phone) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (!(o instanceof Human)) {return false;}
        Human human = (Human) o;
        return Objects.equals(surname, human.surname) && Objects.equals(name, human.name)
                && Objects.equals(patronymic, human.patronymic) && Objects.equals(birthDate, human.birthDate)
                && Objects.equals(address, human.address) && Objects.equals(phone, human.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, patronymic, birthDate, address, phone);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Human.class.getSimpleName() + "[", "]")
                .add("surname='" + surname + "'")
                .add("name='" + name + "'")
                .add("patronymic='" + patronymic + "'")
                .add("birthDate=" + birthDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm")))
                .add("address='" + address + "'")
                .add("phone='" + phone + "'")
                .toString();
    }
}