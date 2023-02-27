package com.brenno.mecanica.model;

import java.util.HashSet;
import java.util.Set;
import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.brenno.mecanica.model.enums.PersonRole;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "persons")
public class Person implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue
  @Column(name = "person_id", nullable = false, unique = true)
  private UUID personId;

  @Column(name = "person_role", nullable = false)
  @Enumerated(EnumType.STRING)
  private PersonRole personRole;

  @Column(name = "name", nullable = false, length = 50)
  private String name;

  @Column(name = "register_number", nullable = false, unique = true, length = 14)
  private String registerNumber;

  @Column(name = "email", unique = true, length = 40)
  private String email;

  @Column(name = "phone", nullable = false, length = 11)
  private String phone;

  @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
  @JoinColumn(name = "address_id")
  private Address address;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "person_id")
  private Set<Vehicle> vehicles = new HashSet<>();

  @PrePersist
  public void prePersist() {
    this.name = this.name.toUpperCase();
    this.email = (this.email == null) ? null : this.email.toUpperCase();
  }

  public String getPersonRole() {
    return personRole.getName();
  }
}
