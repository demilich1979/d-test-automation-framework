Feature: Platform Management

  Background:
    Given Labs page is opened
    When I select 'Albania' country on Labs page
    Then Filters Labs page is opened
    When I select 'Test lab' lab on Filters Labs page
    Then LabProfile page is opened

  @PlatformManagement
  Scenario: DIAFE:0009 Possibility to add a platform to the existing lab
    When I click on Add Platform on Lab Profile Page
    Then Add Platform form is opened
    When I fill following fields on Add Platform Form and save as 'newPlatform':
      | Platform manufacturer | random |
      | Platform              | random |
    Then Platform 'newPlatform' added in Platforms table

  @PlatformManagement
  Scenario: DIAFE:0010 Platform duplication impossibility
    When I click on Add Platform on Lab Profile Page
    Then Add Platform form is opened
    And Field 'Platform' does not contains value from 'newPlatform'

  @PlatformManagement
  Scenario: DIAFE:0011 Possibility to sort platforms
    When I click on Add Platform on Lab Profile Page
    Then Add Platform form is opened
    And I fill following fields on Add Platform Form and save as 'newPlatformOne':
      | Platform manufacturer | random |
      | Platform              | random |
    And I click on Add Platform on Lab Profile Page
    Then Add Platform form is opened
    And I fill following fields on Add Platform Form and save as 'newPlatformTwo':
      | Platform manufacturer | random |
      | Platform              | random |
    When I sort data by alphabet in 'Platform manufacturer' column
    Then Data in 'Platform manufacturer' column sorted according to alphabet
    When I sort data by alphabet in 'Platform equipment' column
    Then Data in 'Platform equipment' column sorted according to alphabet

  @PlatformManagement
  Scenario: DIAFE:0012 Possibility to edit platforms
    When I click on Edit button for the 'newPlatform' platform on Lab Profile Page
    Then Edit platform form is opened
    When I set 'random' value for platform 'newPlatform' and save changes
    Then Platform 'newPlatform' added in Platforms table

  @PlatformManagement
  Scenario: DIAFE:0013 Check number of platforms
    Then On Lab Profile page check numbers of platforms in the grid

  @PlatformManagement
  Scenario: DIAFE:0014 Possibility to delete a platform
    When On the Lab Profile page click on Delete button for the 'newPlatform' platform
    Then Confirm form is opened
    When Click Confirm
    Then Platform 'newPlatform' is not present on the Lab Profile page
