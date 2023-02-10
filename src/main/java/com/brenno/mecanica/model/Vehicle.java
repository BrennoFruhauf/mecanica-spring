package com.brenno.mecanica.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vehicles")
public class Vehicle implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "board", length = 7, nullable = false, unique = true)
  private String board;

  @Column(name = "brand", length = 15, nullable = false)
  private String brand;

  @Column(name = "model", length = 30, nullable = false)
  private String model;

  @Column(name = "color", length = 15, nullable = false)
  private String color;
}
