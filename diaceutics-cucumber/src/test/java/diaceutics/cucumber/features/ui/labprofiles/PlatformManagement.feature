Feature: Platform Management

  Background:
    Given Labs page is opened
    When I select 'Albania' country on Labs page
      Then Filters Labs page is opened
    When I select 'Test lab' lab on Filters Labs page
      Then Lab Profile page is opened

  @PlatformManagement
  Scenario: DIAFE:0009 Possibility to add a platform to the existing lab
    When I click on Add Platform on Lab Profile Page
      Then Add Platform form is opened
    When I fill following fields on Add Platform form and save as 'newPlatformOne':
      | Platform manufacturer | random |
      | Platform              | random |
      Then Lab Profile page is opened
      And Platform 'newPlatformOne' added to Platforms grid

  @PlatformManagement
  Scenario: DIAFE:0010 Platform duplication impossibility
    When I click on Add Platform on Lab Profile Page
      Then Add Platform form is opened
      And Field 'Platform' does not contains value from 'newPlatformOne'

  @PlatformManagement
  Scenario: DIAFE:0011 Possibility to sort platforms
    When I click on Add Platform on Lab Profile Page
      Then Add Platform form is opened
    When I fill following fields on Add Platform form and save as 'newPlatformTwo':
      | Platform manufacturer | random |
      | Platform              | random |
      Then Lab Profile page is opened
    When I click on Add Platform on Lab Profile Page
      Then Add Platform form is opened
    When I fill following fields on Add Platform form and save as 'newPlatformThree':
      | Platform manufacturer | random |
      | Platform              | random |
      Then Lab Profile page is opened
    When I sort data by alphabet in 'Platform manufacturer' column
      Then Data in 'Platform manufacturer' column sorted according to alphabet
    When I sort data by alphabet in 'Platform equipment' column
      Then Data in 'Platform equipment' column sorted according to alphabet

  @PlatformManagement
  Scenario: DIAFE:0012 Possibility to edit platforms
    When I click on Edit button for the 'newPlatformOne' platform on Lab Profile Page
      Then Edit platform form is opened
    When I set 'random' value for platform 'newPlatformOne' and save changes
      Then Lab Profile page is opened
      And Platform 'newPlatformOne' added to Platforms grid

  @PlatformManagement
  Scenario: DIAFE:0013 Check number of platforms
    When I count the number of platforms in the Platforms grid and save as 'numberOfPlatforms'
      Then 'numberOfPlatforms' in Platform grid must be the same as a number stated in the Platforms grid title

  @PlatformManagement
  Scenario Outline: DIAFE:0014 Possibility to delete a platform
    When On the Lab Profile page I click on Delete button for the '<Platform>' platform
      Then Confirm form is opened
    When I click Confirm
      Then Lab Profile page is opened
      And Platform '<Platform>' is not present on the Lab Profile page

    Examples:
      | Platform         |
      | newPlatformOne   |
      | newPlatformTwo   |
      | newPlatformThree |
