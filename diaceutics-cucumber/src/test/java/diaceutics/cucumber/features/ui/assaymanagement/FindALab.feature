Feature: Find a Lab

  @FindLab
  Scenario: DIAFE:0005 Filter a lab by country and type
    Given Assay Management page is opened
    When I choose a 'Albania' and press Search icon on Assay Management page
      Then Labs page is opened
      And All of the following labs for the specific country are displayed on Labs page:
        | Test lab    |
        | test lab 25 |
        | MT046       |
    When I Set 'Lab type' to 'Academic Lab' and press Search icon on Labs page
      Then 'Academic' labs are filtered on Labs page
    When I Set 'Lab type' to 'Commercial Lab' and press Search icon on Labs page
      Then 'Commercial' labs are filtered on Labs page
    When I Set 'Lab type' to 'Hospital Lab' and press Search icon on Labs page
      Then 'Hospital' labs are filtered on Labs page

  @FindLab
  Scenario: DIAFE:0006 Filter a lab by keyword
    When I put a Lab 'Test lab' on search field 'Enter keywords' and press Search icon on Assay Management page
      Then Labs page is opened
      And Lab 'Test lab' is displayed in filter results on Labs page
