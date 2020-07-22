Feature: Platform Management

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
    When I put a Lab 'labOne' on search field 'Enter keywords' and press Search icon on Assay Management page
      Then Labs page is opened
      And Lab 'labOne' is displayed in filter results on Labs page
    When I select 'labOne' lab on Labs page
      Then Lab Profile page is opened

  @AssayManagement @PlatformManagement
  Scenario: DIAFE:0010 Possibility to add a platform to the existing lab
    When I click on 'Add platform' on Lab Profile Page
      Then Add Platform form is opened
    When I fill following fields on Add Platform form and save as 'newPlatformOne':
      | Platform manufacturer | random |
      | Platform              | random |
    And I click Add platform on Add Platform
      Then Lab Profile page is opened
      And Platform 'newPlatformOne' added to Platforms grid

  @AssayManagement @PlatformManagement
  Scenario: DIAFE:0011 Platform duplication impossibility
    When I click on 'Add platform' on Lab Profile Page
      Then Add Platform form is opened
      And Field 'Platform' does not contains value from 'newPlatformOne'

  @AssayManagement @PlatformManagement
  Scenario: DIAFE:0012 Possibility to sort platforms
    When I click on 'Add platform' on Lab Profile Page
      Then Add Platform form is opened
    When I fill following fields on Add Platform form and save as 'newPlatformTwo':
      | Platform manufacturer | random |
      | Platform              | random |
    And I click Add platform on Add Platform
      Then Lab Profile page is opened
    When I click on 'Add platform' on Lab Profile Page
      Then Add Platform form is opened
    When I fill following fields on Add Platform form and save as 'newPlatformThree':
      | Platform manufacturer | random |
      | Platform              | random |
    And I click Add platform on Add Platform
      Then Lab Profile page is opened
    When I sort data by alphabet in 'Platform manufacturer' column on 'Platforms' Grid
      Then Data in 'Platform manufacturer' column on 'Platforms' Grid sorted according to alphabet
    When I sort data by alphabet in 'Platform equipment' column on 'Platforms' Grid
      Then Data in 'Platform equipment' column on 'Platforms' Grid sorted according to alphabet

  @AssayManagement @PlatformManagement
  Scenario: DIAFE:0013 Possibility to edit platforms
    When I click on Edit button for the 'newPlatformOne' platform on Lab Profile Page
      Then Edit platform form is opened
    When I fill following fields on Edit Platform form and save as 'newPlatformOne':
      | Platform | random |
    And I click 'Save changes' on Edit Platform
      Then Lab Profile page is opened
      And Platform 'newPlatformOne' added to Platforms grid

  @AssayManagement @PlatformManagement
  Scenario: DIAFE:0014 Check number of platforms
    When I count the number of platforms in the 'Platforms' grid and save as 'numberOfPlatforms'
      Then 'numberOfPlatforms' must be the same as a number stated in the 'Platforms' Grid title

  @AssayManagement @PlatformManagement
  Scenario Outline: DIAFE:0015 Possibility to delete a platform
    When On the Lab Profile page I click on Delete button for the '<Platform>' platform
      Then Confirm form is opened
    When I click 'Confirm' on Confirm form
      Then Lab Profile page is opened
      And Platform '<Platform>' is not present on the Lab Profile page

    Examples:
      | Platform         |
      | newPlatformOne   |
      | newPlatformTwo   |
      | newPlatformThree |
