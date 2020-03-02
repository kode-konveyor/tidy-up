package com.kodekonveyor.authentication;

import lombok.Data;

@Data
public class UserDTO {

  private long id;
  private String login;
  private String auth0id;

}
