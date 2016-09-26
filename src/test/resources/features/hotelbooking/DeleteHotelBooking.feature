Feature: Delete hotel booking
  In order to improve customer experience
  As a CRM
  I want to allow bookings to be deleted

  Scenario: Delete a Hotel booking
    Given I am on the hotel booking page
    And I enter the following details
      |firstname    |surname     |price    |deposit    |checkin          |checkout          |
      | paul        |oconnor       |  300   |  true     |  2016-12-18     |2016-12-25        |
    And would like to make the hotel booking
    When I delete that booking
    Then the booking should be deleted from the list