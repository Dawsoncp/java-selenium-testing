Feature: Ensure I can search for train tickets correctly


  Scenario: Ensure different train routes can be searched for successfully
    Given I navigate to the Trainline home page
    And I enter the from station 'Brighton' and to station 'London Victoria'
    When I click the 'Get Times & Tickets' button
    Then the From 'Brigton' and To 'London Victoria' stations are shown in the results

