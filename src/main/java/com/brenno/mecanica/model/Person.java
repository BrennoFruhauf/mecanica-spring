package com.brenno.mecanica.model;

import java.util.HashSet;
import java.util.Set;
import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Entity
@Table(name = "persons")
public class Person implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue
  @Column(name = "person_id", nullable = false, unique = true)
  private UUID personId;

  @Column(name = "name", nullable = false, length = 50)
  private String name;

  @Column(name = "cpf", nullable = false, unique = true, length = 11)
  private String cpf;

  @Column(name = "email", unique = true, length = 40)
  private String email;

  @Column(name = "phone", nullable = false, length = 11)
  private String phone;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "address_id")
  private Address address;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "person_id")
  private Set<Vehicle> vehicles = new HashSet<>();

  public Person() {

  }

  public Person(String name, String cpf, String email, String phone, Address address, Set<Vehicle> vehicles) {
    this.name = name;
    this.cpf = cpf;
    this.email = email;
    this.phone = phone;
    this.address = address;
    this.vehicles = vehicles;
  }

  public UUID getPersonId() {
    return personId;
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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public Set<Vehicle> getVehicles() {
    return vehicles;
  }

  public void setVehicles(Set<Vehicle> vehicles) {
    this.vehicles = vehicles;
  }

}
