Feature: Location management

  Background:
    Given Marketplace Main page is opened
    When I click 'Login' on Marketplace Main page
      Then Login page is opened
    When I login as 'adminUser' user
      Then Home page is opened
      And User should be logged in
    When I open 'Assay Management' tools
      Then Assay Management page is opened
    When I put a Lab 'labOne' on search field 'Enter keywords' and press Search icon on Assay Management page
      Then Labs page is opened
      And Lab 'labOne' is displayed in filter results on Labs page
    When I select 'labOne' lab on Labs page
      Then Lab Profile page is opened

  @AssayManagement @LocationManagement
  Scenario: DIAFE:0016 Possibility of adding a location from Lab Profile page
    When I click on 'Add a location' on Lab Profile Page
      Then Add a location page is opened
    When I fill following fields on Add a location page and save as 'location':
      | Location name | Test Location    |
      | Address 1     | Test Address 1   |
      | Address 2     | Test Address 2   |
      | City / Town   | Test City        |
      | Region        | Test Region      |
      | Country       | random           |
      | Postal code   | Test Postal code |
    And I click 'Add Location' on Add a location page
      Then Lab Profile page is opened
      And 'New location added.' message is displayed on Lab Profile page
      And Location 'location' is displayed on Locations form on on Lab Profile page

  @AssayManagement @LocationManagement
  Scenario: DIAFE:0017 Possibility of adding a location from Edit Profile page
    When I click Edit Details on Lab Profile Page
      Then Edit Profile Lab Details page is opened
    When I click Add new location on Edit Profile page
      Then Add a location page is opened
    When I fill following fields on Add a location page and save as 'locationTwo':
      | Location name | Test Location    |
      | Address 1     | Test Address 1   |
      | Address 2     | Test Address 2   |
      | City / Town   | Test City        |
      | Region        | Test Region      |
      | Country       | random           |
      | Postal code   | Test Postal code |
    And I click 'Add Location' on Add a location page
      Then Lab Profile page is opened
      And 'New location added.' message is displayed on Lab Profile page
      And Location 'locationTwo' is displayed on Locations form on on Lab Profile page

  @AssayManagement @LocationManagement
  Scenario: DIAFE:0018 Required fields validation
    When I click on 'Add a location' on Lab Profile Page
      Then Add a location page is opened
    When I click 'Add Location' on Add a location page
      Then Message 'Some items below need your attention.' is displayed on Add a location page
      And Message 'Please enter a value' is displayed on required fields on Add a location page
      And Message 'Please input a city or town name' is displayed on required fields on Add a location page
      And Message 'Please input a country' is displayed on required fields on Add a location page

  @AssayManagement @LocationManagement
  Scenario: DIAFE:0019 Possibility to edit a location (positive test)
    When I click Edit location 'location' on Lab Profile Page
      Then Edit Profile Location page is opened
    When I fill following fields on Edit Profile Location page and save as 'location':
      | Location name | new Location    |
      | Address 1     | new Address 1   |
      | Address 2     | new Address 2   |
      | City / Town   | new City        |
      | Region        | new Region      |
      | Country       | random          |
      | Postal code   | new Postal code |
    And I click Save on Edit Profile Location page
      Then Message 'Location updated!' is displayed on Edit Profile Location page
    When I click Return to profile on Edit Profile Location page
      Then Lab Profile page is opened
      And Location 'location' is displayed on Locations form on on Lab Profile page

  @AssayManagement @LocationManagement
  Scenario: DIAFE:0020 Possibility to edit a location (negative test)
    When I click Edit location 'location' on Lab Profile Page
      Then Edit Profile Location page is opened
    When I clear following fields on Edit Profile Location page:
      | Location name |
      | Address 1     |
      | Address 2     |
      | City / Town   |
      | Region        |
      | Postal code   |
    And I click Save on Edit Profile Location page
    Then Message 'Some items below need your attention.' is displayed on Edit Profile Location page
      And Message 'Please enter a value' is displayed on required fields on Edit Profile Location page
      And Message 'Please input a city or town name' is displayed on required fields on Edit Profile Location page
