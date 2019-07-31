Feature: Telecom Feature
  I want to use this template for my feature file

  Scenario: add customer flow
    Given User is in telecom home page
    And User click on add customer
    When User filling all the field
    |fname|trinath|
    |laname|k|
    |mail|ktk@gmail.com|
    |address|hyd|
    |phno|7981971323|
    And User click on submit buttom
    Then User should get customer unique Id
