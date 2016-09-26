Feature: Add hotel booking
  In order to improve customer experience
  As a CRM
  I want to allow bookings to be made online

  Scenario Outline: Add a hotel booking
    Given I am on the hotel booking page
    When I enter the following details
    |firstname    |surname     |price    |deposit                 |checkin        |checkout           |
    | <first-name>|<sur-name>  |  <cost> |  <upfront-payment>     |  <check-in>   |<check-out>        |
    And would like to make the hotel booking
    Then the booking should be added to the list

    Examples:
      | first-name  |sur-name    |  cost   |  upfront-payment   |  check-in       | check-out         |
      | john        | smith      |  2300   |  true              |  2016-11-18     | 2016-11-25        |
      | kieran      | west       |  1299   |  false             |  2016-10-27     | 2016-10-28        |