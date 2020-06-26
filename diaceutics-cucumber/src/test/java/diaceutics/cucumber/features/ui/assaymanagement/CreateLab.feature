Feature: Create a Lab

  @CreateALab
  Scenario Outline: DIAFE:<test count> Possibility to successfully create an <Lab type>
    Given Labs page is opened
    When I open Create a Lab page
      Then Create a Lab page is opened
    When I fill following fields on Create a Lab page and save as 'lab':
      | Country  | Albania    |
      | Name     | TestLab    |
#      | URL      | TestLab    |
      | Lab type | <Lab type> |
    And I click Next on Create a Lab page
      Then Lab Address page is opened
    When I fill following fields on Lab Address page and save as 'lab':
      | Location name | Test Location name |
      | Address 1     | Test Address 1     |
      | Address 2     | Test Address 2     |
      | City / Town   | Test City          |
      | Region        | Test Region        |
      | Country       | Albania            |
      | Postal code   | Test Postal code   |
    And I click Finish on Lab Address page
      Then Lab Profile page is opened
      And Lab 'lab' is displayed on Lab Profile page

    Examples:
      | Lab type       | test count |
      | Unspecified    | 0001       |
      | Academic Lab   | 0002       |
      | Commercial Lab | 0003       |
      | Hospital Lab   | 0004       |

  @CreateALab
  Scenario: DIAFE:0004 Create a Lab: Required fields validation
    Given Labs page is opened
    When I open Create a Lab page
      Then Create a Lab page is opened
    When I click Next on Create a Lab page
      Then Message 'Some items below need your attention.' is displayed on Create a Lab page
      And Message 'Please input a country' is displayed on required fields on Create a Lab page
      And Message 'Please input a name for the lab' is displayed on required fields on Create a Lab page
    When I fill following fields on Create a Lab page and save as 'lab':
      | Country  | Albania     |
      | Name     | TestLab     |
#      | URL      | TestLab     |
      | Lab type | Unspecified |
    And I click Next on Create a Lab page
      Then Lab Address page is opened
    When I click Finish on Lab Address page
      Then Message 'Some items below need your attention.' is displayed on Lab Address page
      And Message 'Please enter a value' is displayed on required fields on Lab Address page
      And Message 'Please input a city or town name' is displayed on required fields on Lab Address page
      And Message 'Please input a country' is displayed on required fields on Lab Address page
    When I fill following fields on Lab Address page and save as 'lab':
      | Location name | Test Location name |
      | Address 1     | Test Address 1     |
      | Address 2     | Test Address 2     |
      | City / Town   | Test City          |
      | Region        | Test Region        |
      | Country       | Albania            |
      | Postal code   | Test Postal code   |
    And I click Finish on Lab Address page
      Then Lab Profile page is opened
      And Lab 'lab' is displayed on Lab Profile page
