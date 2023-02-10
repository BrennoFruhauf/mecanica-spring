package com.brenno.mecanica.model;

import java.util.HashSet;
import java.util.Set;
import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.brenno.mecanica.model.enums.States;

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

  @Column(name = "name", nullable = false, length = 50)
  private String name;

  @Column(name = "cpf", nullable = false, unique = true, length = 11)
  private String cpf;

  @Column(name = "email", unique = true, length = 40)
  private String email;

  @Column(name = "phone", nullable = false, length = 11)
  private String phone;

  @Column(name = "cep", length = 8)
  private String cep;

  @Column(name = "street", length = 50)
  private String street;

  @Column(name = "address_number", length = 6)
  private String addressNumber;

  @Column(name = "complement", length = 50)
  private String complement;

  @Column(name = "district", length = 40)
  private String district;

  @Column(name = "city", length = 40)
  private String city;

  @Enumerated(EnumType.STRING)
  @Column(name = "state", length = 2)
  private States state;

  // mappedBy = "person"
  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "vehicle_id")
  private Set<Vehicle> vehicles = new HashSet<>();
}
