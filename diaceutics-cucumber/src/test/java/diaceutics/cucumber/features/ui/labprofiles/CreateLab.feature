Feature: Create a Lab

  @CreateALab
  Scenario: DIAFE:0001 Possibility to successfully create an unspecified lab
    Given Labs page is opened
    When I open Create a Lab page
      Then Create a Lab page is opened
    When I fill first Create a Lab form using following data and sava as 'lab':
      | Country  | Albania      |
      | Name     | TestLab      |
      | URL      | TestLab      |
      | Lab type | Academic Lab |
      And I click Next on Create a Lab page




