package com.brenno.mecanica.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
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

  @Column(name = "year_model", length = 4, nullable = false)
  private Integer year;

  @Column(name = "color", length = 15, nullable = false)
  private String color;

  @PrePersist
  public void prePersist() {
    this.board = this.board.toUpperCase();
    this.brand = this.brand.toUpperCase();
    this.model = this.model.toUpperCase();
    this.color = this.color.toUpperCase();
  }
}
