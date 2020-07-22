Feature: Find a Lab

  Background:
    Given Marketplace Main page is opened
    When I click 'Login' on Marketplace Main page
      Then Login page is opened
    When I login as 'adminUser' user
      Then Home page is opened
      And User should be logged in
    When I open 'Assay Management' tools
    And I select last window
      Then Assay Management page is opened

  @AssayManagement @FindLab
  Scenario: DIAFE:0006 Filter a lab by country and type
    When I choose a 'Albania' and press Search icon on Assay Management page
      Then Labs page is opened
      And All of the following labs for the specific country are displayed on Labs page:
        | labOne   |
        | labTwo   |
        | labThree |
        | labFour  |
    When I Set 'Lab type' to 'Academic Lab' and press Search icon on Labs page
      Then 'Academic' labs are filtered on Labs page
    When I Set 'Lab type' to 'Commercial Lab' and press Search icon on Labs page
      Then 'Commercial' labs are filtered on Labs page
    When I Set 'Lab type' to 'Hospital Lab' and press Search icon on Labs page
      Then 'Hospital' labs are filtered on Labs page

  @AssayManagement @FindLab
  Scenario: DIAFE:0007 Filter a lab by keyword
    When I put a Lab 'labOne' on search field 'Enter keywords' and press Search icon on Assay Management page
      Then Labs page is opened
      And Lab 'labOne' is displayed in filter results on Labs page
