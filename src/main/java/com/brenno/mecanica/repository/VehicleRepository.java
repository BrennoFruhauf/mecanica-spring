package com.brenno.mecanica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brenno.mecanica.model.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> {

}
