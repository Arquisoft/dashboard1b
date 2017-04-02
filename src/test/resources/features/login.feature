Feature: Being able to login
Scenario: Login
  Login with some username

    Dada una lista de usuariosToWapos:
      | email    | password |
      | nakamura@gmail.com   | 123456   |
      | valuvieco@gmail.com    | 123456     |
      | paco   | 123456     |
    Cuando logueo con el correo sin privilegios "nakamura@gmail.com" y la contraseña "123456"
    Entonces recibo el siguiente mensaje to flama:
