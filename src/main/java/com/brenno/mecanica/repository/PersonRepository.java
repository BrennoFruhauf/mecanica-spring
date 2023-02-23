package com.brenno.mecanica.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.brenno.mecanica.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, UUID> {
  @Query(value = "SELECT COUNT(*) FROM persons WHERE person_role = 'CLIENT'", nativeQuery = true)
  Long countClients();
}
