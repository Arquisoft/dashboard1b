Feature: Being able to login
Scenario: Login
  Login with some username

    Dada una lista de usuarios:
      | email    | password |
      | nakamura@gmail.com   | 123456   |
      | valduvieco@gmail.com    | 123456     |
      | paco   | 123456     |
    Cuando me logueo con el correo sin privilegios "valduvieco@gmail.com" y la contraseña "123456"
    Entonces recibo el siguiente mensaje:

    
    
    