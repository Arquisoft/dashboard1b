Feature: landing page 
Scenario: client makes call to GET /
When the client calls /
Then the client receives status code of 200



Scenario: LoginToWapo
Given un usuario que va a la aplicasao

When me logueo con usuario privilegiado
Then me muestra el html usuario privilegiado