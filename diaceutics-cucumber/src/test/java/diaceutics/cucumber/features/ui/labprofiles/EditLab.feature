Feature: Edit a Lab

  Background:
    Given Labs page is opened
    When I select 'Albania' country on Labs page
      Then Filters page is opened
    When I select 'Test lab' lab on Filters Labs page
      Then Lab Profile page is opened
    When I click on Edit Details on Lab Profile Page
      Then Edit Profile page is opened

  @EditALab
  Scenario: DIAFE:0007 Possibility to edit a lab and validate an edited data
    When I change Edit Profile form using following data and sava as 'lab':
      | Country  | Albania      |
      | Name     | TestLab      |
#      | URL      | Test lab     |
      | Lab type | Academic Lab |
    And I click Save on Edit Profile page
      Then 'Lab updated!' message is displayed on Edit Profile page
    When I click Return to profile on Edit Profile page
      Then Lab Profile page is opened
      And Lab 'lab' is displayed on Lab Profile page
    When I click on Edit Details on Lab Profile Page
      Then Edit Profile page is opened
    When I change Edit Profile form using following data and sava as 'lab':
      | Country  | Albania     |
      | Name     | TestLab     |
#      | URL      | TestLab     |
      | Lab type | Private Lab |
    And I click Save on Edit Profile page
      Then 'Lab updated!' message is displayed on Edit Profile page
    When I click Return to profile on Edit Profile page
      Then Lab Profile page is opened
      And Lab 'lab' is displayed on Lab Profile page
    When I click on Edit Details on Lab Profile Page
      Then Edit Profile page is opened
    When I change Edit Profile form using following data:
      | Lab type | Unspecified |
      | Name     | Test lab    |
    And I click Save on Edit Profile page
      Then 'Lab updated!' message is displayed on Edit Profile page
      And I click Return to profile on Edit Profile page

  @EditALab
  Scenario: DIAFE:0008 Required fields validation
    When I clear 'Name' field on Lab Profile Page
    And I click Save on Edit Profile page
      Then 'Some items below need your attention.' message is displayed on Edit Profile page
      And Message 'Please input a country' displayed on required fields on Edit Profile page
