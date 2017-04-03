Feature: landing page 
Scenario: client makes call to GET /
When the client calls /
Then the client receives status code of 200



Scenario: LoginConPrivilegios
Given un usuario que va a la aplicacion

When me logueo con usuario privilegiado
Then me muestra el html usuario privilegiado


Scenario: LoginSinPrivilegios
Given un usuario que va a la aplicacion
When me logueo con usuario sin privilegios 
Then me muestra el html usuario sin privilegios