Feature: Find a Lab

  @CreateALab
  Scenario: DIAFE:0005 Filter a lab by country and type
    Given Labs page is opened
    When I choose a Country under Find Lab in which labs 'labOne' were created and press Search icon
      Then Filters Labs page is opened
      And All of the following labs for the specific country are displayed:
        | labOne   |
        | labTwo   |
        | labThree |
    When I Set radiobutton to 'Academic Lab' and press Search icon
      Then 'Academic' lab are filtered
    When I Set radiobutton to 'Private Lab' and press Search icon
      Then 'Private' lab are filtered

  @CreateALab
  Scenario: DIAFE:0006 Filter a lab by keyword
    When I put a Lab 'Test lab' an Search textBox and press Search icon
      Then Filters Labs page is opened
      And Lab 'Test lab' is displayed in filter results
