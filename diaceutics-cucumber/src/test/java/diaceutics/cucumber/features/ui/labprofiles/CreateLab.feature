Feature: Create a Lab

  @CreateALab
  Scenario Outline: DIAFE:<test count> Possibility to successfully create an <Lab type>
    Given Labs page is opened
    When I open Create a Lab page
      Then Create a Lab page is opened
    When I fill first Create a Lab form using following data and sava as 'lab':
      | Country  | Albania    |
      | Name     | TestLab    |
#      | URL      | TestLab    |
      | Lab type | <Lab type> |
    And I click Next on Create a Lab page
      Then Lab Address page is opened
    When I fill Lab Address form on Lab Address page using following data and save as 'lab':
      | Location name | Test data |
      | Address 1     | Test data |
      | Address 2     | Test data |
      | City / Town   | Test data |
      | Region        | Test data |
      | Country       | Albania   |
      | Postal code   | Test data |
    And I click Finish on Lab Address page
      Then Lab Profile page is opened
      And Lab 'lab' is displayed on Lab Profile page

    Examples:
      | Lab type     | test count |
      | Unspecified  | 0001       |
      | Academic Lab | 0002       |
      | Private Lab  | 0003       |

  @CreateALab
  Scenario: DIAFE:0004 Create a Lab: Required fields validation
    Given Labs page is opened
    When I open Create a Lab page
      Then Create a Lab page is opened
    When I click Next on Create a Lab page
      Then Message 'Some items below need your attention.' displayed on Create a Lab page
      And Message 'Please input a country' displayed on required fields on Create a Lab page
      And Message 'Please input a name for the lab' displayed on required fields on Create a Lab page
    When I fill first Create a Lab form using following data and sava as 'lab':
      | Country  | Albania     |
      | Name     | TestLab     |
#      | URL      | TestLab     |
      | Lab type | Unspecified |
    And I click Next on Create a Lab page
      Then Lab Address page is opened
    When I click Finish on Lab Address page
      Then Message 'Some items below need your attention.' displayed on Lab Address page
      And Message 'Please enter a value' displayed on required fields on Lab Address page
      And Message 'Please input a city or town name' displayed on required fields on Lab Address page
      And Message 'Please input a country' displayed on required fields on Lab Address page
    When I fill Lab Address form on Lab Address page using following data and save as 'lab':
      | Location name | Test data |
      | Address 1     | Test data |
      | Address 2     | Test data |
      | City / Town   | Test data |
      | Region        | Test data |
      | Country       | Albania   |
      | Postal code   | Test data |
    And I click Finish on Lab Address page
      Then Lab Profile page is opened
      And Lab 'lab' is displayed on Lab Profile page
