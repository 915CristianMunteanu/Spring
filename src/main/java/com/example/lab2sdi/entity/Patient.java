package com.example.lab2sdi.entity;

import jakarta.persistence.*;
import net.minidev.json.annotate.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="patients")
public class Patient {
    @Id
    @GeneratedValue
    private long id;
    private String firstName;
    private String lastName;
    private String illness;
    private String phoneNumber;

    private int roomNumber;
    @JsonIgnore
    @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL)
    private List<DoctorPatient> doctorRelation;

    public List<DoctorPatient> getDoctorRelation() {
        return doctorRelation;
    }

    public void setDoctorRelation(List<DoctorPatient> doctorRelation) {
        this.doctorRelation = doctorRelation;
    }

    public Patient(String firstName, String lastName, String illness, String phoneNumber, int roomNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.illness = illness;
        this.phoneNumber = phoneNumber;
        this.roomNumber = roomNumber;
    }

    public Patient() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", illness='" + illness + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", roomNumber=" + roomNumber +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj)
            return true;
        if(!(obj instanceof Patient))
            return false;
        Patient p= (Patient) obj;
        return Objects.equals(this.id,p.id) && Objects.equals(this.firstName,p.firstName) && Objects.equals(this.lastName,p.lastName)&& Objects.equals(this.phoneNumber,p.phoneNumber) && Objects.equals(this.illness,p.illness) && Objects.equals(this.roomNumber,p.roomNumber);
    }
}
