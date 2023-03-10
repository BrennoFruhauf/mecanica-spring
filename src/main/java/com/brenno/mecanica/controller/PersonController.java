package com.brenno.mecanica.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.brenno.mecanica.model.Person;
import com.brenno.mecanica.repository.PersonRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/pessoas")
@AllArgsConstructor
public class PersonController {

  private final PersonRepository personRepository;

  @GetMapping
  public List<Person> list() {
    return personRepository.findAll();
  }

  @GetMapping("/clientes")
  public Long countClients() {
    return personRepository.countClients();
  }

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  public Person create(@RequestBody Person person) {
    return personRepository.save(person);
  }
}
