Feature: Edit a Lab

  Background:
    Given Assay Management page is opened
    When I select 'Albania' country on Assay Management page
      Then Labs page is opened
    When I select 'Test lab' lab on Labs page
      Then Lab Profile page is opened
    When I click Edit Details on Lab Profile Page
      Then Edit Profile Lab Details page is opened

  @EditALab
  Scenario: DIAFE:0007 Possibility to edit a lab and validate an edited data
    When I fill following fields on Edit Profile Lab Details page and save as 'lab':
      | Country  | Albania         |
      | Name     | TestLab         |
      | URL      | https://TestLab |
      | Lab type | Academic Lab    |
    And I click Save on Edit Profile Lab Details page
      Then  Message 'Lab updated!' is displayed on Edit Profile Lab Details page
    When I click Return to profile on Edit Profile Lab Details page
      Then Lab Profile page is opened
      And Lab 'lab' with following fields is displayed on Lab Profile page
        | Name     |
        | URL      |
        | Lab type |
    When I click Edit Details on Lab Profile Page
      Then Edit Profile Lab Details page is opened
    When I fill following fields on Edit Profile Lab Details page and save as 'lab':
      | Country  | Albania         |
      | Name     | TestLab         |
      | URL      | https://TestLab |
      | Lab type | Commercial Lab  |
    And I click Save on Edit Profile Lab Details page
      Then Message 'Lab updated!' is displayed on Edit Profile Lab Details page
    When I click Return to profile on Edit Profile Lab Details page
      Then Lab Profile page is opened
      And Lab 'lab' with following fields is displayed on Lab Profile page
        | Name     |
        | URL      |
        | Lab type |
    When I click Edit Details on Lab Profile Page
      Then Edit Profile Lab Details page is opened
    When I fill following fields on Edit Profile Lab Details page and save as 'lab':
      | Country  | Albania            |
      | Name     | TestLab            |
      | URL      | https://NewTestLab |
      | Lab type | Hospital Lab       |
    And I click Save on Edit Profile Lab Details page
      Then Message 'Lab updated!' is displayed on Edit Profile Lab Details page
    When I click Return to profile on Edit Profile Lab Details page
      Then Lab Profile page is opened
      And Lab 'lab' with following fields is displayed on Lab Profile page
        | Name     |
        | URL      |
        | Lab type |
    When I click Edit Details on Lab Profile Page
      Then Edit Profile Lab Details page is opened
    When I change Edit Profile Lab Details page using following data:
      | Lab type | Unspecified |
      | Name     | Test lab    |
    And I click Save on Edit Profile Lab Details page
      Then Message 'Lab updated!' is displayed on Edit Profile Lab Details page
      And I click Return to profile on Edit Profile Lab Details page

  @EditALab
  Scenario: DIAFE:0008 Required fields validation
    When I clear 'Name' field on Edit Profile Lab Details page
    And I click Save on Edit Profile Lab Details page
      Then Message 'Some items below need your attention.' is displayed on Edit Profile Lab Details page
      And Message 'Please input a name for the lab' is displayed on required fields on Edit Profile Lab Details page
