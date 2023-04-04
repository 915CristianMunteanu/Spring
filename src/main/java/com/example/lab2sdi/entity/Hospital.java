package com.example.lab2sdi.entity;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import net.minidev.json.annotate.JsonIgnore;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "hospitals")
public class Hospital {
    private @Id
    @GeneratedValue Long id;
    private String name;
    @NonNull
    @Column(nullable = false)
    private String address;
    @NonNull
    @Column(nullable = false)
    private String phoneNumber;
    @NonNull
    @Min(100)
    @Max(2000)
    @Column(nullable = false)
    private int numberOfBeds;

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "hospital",cascade = CascadeType.ALL)
    private List<Doctor> doctors;
    public Hospital(){};
    public Hospital(String name, String address, String phoneNumber, int numberOfBeds) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.numberOfBeds = numberOfBeds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    @Override
    public boolean equals(Object o){
        if(this==o)
            return true;
        if(!(o instanceof Hospital))
            return false;
        Hospital h= (Hospital) o;
        return Objects.equals(this.id,h.id) && Objects.equals(this.name,h.name) && Objects.equals(this.address,h.address)&& Objects.equals(this.phoneNumber,h.phoneNumber)&& Objects.equals(this.numberOfBeds,h.numberOfBeds);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id,this.name,this.address,this.phoneNumber,this.numberOfBeds);
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", numberOfBeds=" + numberOfBeds +
                '}';
    }
}
