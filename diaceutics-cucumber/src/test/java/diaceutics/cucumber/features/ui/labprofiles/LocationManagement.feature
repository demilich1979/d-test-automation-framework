Feature: Location management

  Background:
    Given Labs page is opened
    When I select 'Albania' country on Labs page
      Then Filters page is opened
    When I select 'Test lab' lab on Filters Labs page
      Then Lab Profile page is opened

  @LocationManagement
  Scenario: DIAFE:0015 Possibility of adding a location from Lab Profile page
    When I click Add a location On Lab Profile page
      Then Add a location page is opened
    When I fill Lab Address form on Add a location page using following data and save as 'location':
      | Location name | Test Location name |
      | Address 1     | Test Address 1     |
      | Address 2     | Test Address 2     |
      | City / Town   | Test City          |
      | Region        | Test Region        |
      | Country       | Albania            |
      | Postal code   | Test Postal code   |
    And I click Add a location on Add a location page
      Then Lab Profile page is opened
      And 'New location added.' message is displayed on Lab Profile page
      And Location 'location' is displayed on Locations form on on Lab Profile page

  @LocationManagement
  Scenario: DIAFE:0016 Possibility of adding a location from Edit Profile page
    When I click on Edit Details on Lab Profile Page
      Then Edit Profile page is opened
    When I click Add new location on Edit Profile page
      Then Add a location page is opened
    When I fill Lab Address form on Add a location page using following data and save as 'location':
      | Location name | Test Location name |
      | Address 1     | Test Address 1     |
      | Address 2     | Test Address 2     |
      | City / Town   | Test City          |
      | Region        | Test Region        |
      | Country       | Albania            |
      | Postal code   | Test Postal code   |
    And I click Add a location on Add a location page
      Then Lab Profile page is opened
      And 'New location added.' message is displayed on Lab Profile page
      And Location 'location' is displayed on Locations form on on Lab Profile page

  @LocationManagement
  Scenario: DIAFE:0017 Required fields validation
    When I click Add a location On Lab Profile page
      Then Add a location page is opened
    When I click Add a location on Add a location page
      Then Message 'Some items below need your attention.' displayed on Add a location page
      And Message 'Please enter a value' displayed on required fields on Add a location page
      And Message 'Please input a city or town name' displayed on required fields on Add a location page
      And Message 'Please input a country' displayed on required fields on Add a location page

  @LocationManagement
  Scenario: DIAFE:0018 Possibility to edit a location (positive test)
