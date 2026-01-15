@api @colombia
Feature: Consultar información de Colombia
  Como usuario de la API
  Quiero consultar información de Colombia
  Para obtener datos del país

  @smoke
  Scenario: Consultar información básica de Colombia
    When consulto la información del país "Colombia"
    Then el código de respuesta debe ser 200
    And el nombre del país debe ser "Colombia"
    And la capital debe ser "Bogotá"
    And el código ISO debe ser "CO"