Feature: Find a Lab

  @FindLab
  Scenario: DIAFE:0005 Filter a lab by country and type
    Given Labs page is opened
    When I choose a 'Albania' and press Search icon
      Then Filters page is opened
      And All of the following labs for the specific country are displayed:
        | Test lab    |
        | test lab 25 |
        | MT046       |
    When I Set 'Lab type' to 'Academic Lab' and press Search icon
      Then 'Academic' labs are filtered
    When I Set 'Lab type' to 'Commercial Lab' and press Search icon
      Then 'Commercial' labs are filtered
    When I Set 'Lab type' to 'Hospital Lab' and press Search icon
      Then 'Hospital' labs are filtered

  @FindLab
  Scenario: DIAFE:0006 Filter a lab by keyword
    When I put a Lab 'Test lab' an Search textBox and press Search icon
      Then Filters page is opened
      And Lab 'Test lab' is displayed in filter results
