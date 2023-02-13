package com.brenno.mecanica.model;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import com.brenno.mecanica.model.enums.States;

@Data
@Entity
@ToString
@EqualsAndHashCode
public class Address implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @OneToOne(fetch = FetchType.LAZY)
  @MapsId
  @JoinColumn(name = "person_id")
  private Person personId;

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

}
