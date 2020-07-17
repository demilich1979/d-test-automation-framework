Feature: Create a Lab

  Background:
    Given Marketplace Main page is opened
    When I click 'Login' on Marketplace Main page
      Then Login page is opened
    When I login as 'adminUser' user
      Then Home page is opened
      And User should be logged in
    When I open 'Assay Management' tools
      Then Assay Management page is opened

  @AssayManagement @CreateALab
  Scenario Outline: DIAFE:<test count> Possibility to successfully create an <Lab type>
    When I click 'Create a Lab' on Assay Management page
      Then Create a Lab page is opened
    When I fill following fields on Create a Lab page and save as '<Lab key>':
      | Country  | Albania         |
      | Name     | TestLab         |
      | URL      | https://TestLab |
      | Lab type | <Lab type>      |
    And I click 'Next' on Create a Lab page
      Then Lab Address page is opened
    When I fill following fields on Lab Address page and save as '<Lab key>':
      | Location name | Test Location    |
      | Address 1     | Test Address 1   |
      | Address 2     | Test Address 2   |
      | City / Town   | Test City        |
      | Region        | Test Region      |
      | Country       | Albania          |
      | Postal code   | Test Postal code |
    And I click 'Finish' on Lab Address page
      Then Lab Profile page is opened
      And Lab '<Lab key>' with following fields is displayed on Lab Profile page
        | Name     |
        | URL      |
        | Lab type |

    Examples:
      | Lab type       | test count | Lab key  |
      | Unspecified    | 0001       | labOne   |
      | Academic Lab   | 0002       | labTwo   |
      | Commercial Lab | 0003       | labThree |
      | Hospital Lab   | 0004       | labFour  |

  @AssayManagement @CreateALab
  Scenario: DIAFE:0005 Create a Lab: Required fields validation
    When I click 'Create a Lab' on Assay Management page
      Then Create a Lab page is opened
    When I click 'Next' on Create a Lab page
      Then Message 'Some items below need your attention.' is displayed on Create a Lab page
      And Message 'Please input a country' is displayed on required fields on Create a Lab page
      And Message 'Please input a name for the lab' is displayed on required fields on Create a Lab page
    When I fill following fields on Create a Lab page and save as 'labFive':
      | Country  | Albania         |
      | Name     | TestLab         |
      | URL      | https://TestLab |
      | Lab type | Unspecified     |
    And I click 'Next' on Create a Lab page
      Then Lab Address page is opened
    When I click 'Finish' on Lab Address page
      Then Message 'Some items below need your attention.' is displayed on Lab Address page
      And Message 'Please enter a value' is displayed on required fields on Lab Address page
      And Message 'Please input a city or town name' is displayed on required fields on Lab Address page
      And Message 'Please input a country' is displayed on required fields on Lab Address page
    When I fill following fields on Lab Address page and save as 'labFive':
      | Location name | Test Location    |
      | Address 1     | Test Address 1   |
      | Address 2     | Test Address 2   |
      | City / Town   | Test City        |
      | Region        | Test Region      |
      | Country       | Albania          |
      | Postal code   | Test Postal code |
    And I click 'Finish' on Lab Address page
      Then Lab Profile page is opened
      And Lab 'labFive' with following fields is displayed on Lab Profile page
        | Name     |
        | URL      |
        | Lab type |
