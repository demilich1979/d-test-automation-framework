Feature: Create a Lab

  @CreateALab
  Scenario: DIAFE:0005 Filter a lab by country and type
    Given Labs page is opened
    When I choose a 'CountryName' under Find Lab for labs 'LabName' and press Search icon
    Then All of the labs for the country 'CountryName' are displayed

    When I Set radiobutton to 'Academic Lab' and press Search icon
      Then 'Academic' lab are filtered
    When I Set radiobutton to 'Private Lab' and press Search icon
      Then 'Private' lab are filtered

  Scenario: DIAFE:0006 Filter a lab by keyword
    When I put a Lab 'labName' an Search textbox and press Search icon
    Then  Lab with 'labName' is displayed in filter results
