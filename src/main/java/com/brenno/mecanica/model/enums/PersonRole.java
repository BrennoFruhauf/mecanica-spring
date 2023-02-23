package com.brenno.mecanica.model.enums;

public enum PersonRole {
  ADMIN("administrador"),
  MECHANIC("mecânico"),
  CLIENT("cliente");

  private final String name;

  PersonRole(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public static PersonRole toEnum(String n) {
    if (n == null)
      return null;

    for (PersonRole x : PersonRole.values()) {
      if (n.equals(x.getName()))
        return x;
    }

    throw new IllegalArgumentException("Perfil inválido");
  }

}
