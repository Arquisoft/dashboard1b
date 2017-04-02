Feature: Loguearse sin privilegios
Scenario: Login

    Given una lista de usuarios:
      | email    | password |
      | nakamura@gmail.com   | 123456   |
      | valduvieco@gmail.com    | 123456     |
      | paco   | 123456     |
    When logueo con el correo sin privilegios "nakamura@gmail.com" y la contraseña "123456"
    Then recibo el siguiente mensaje:
