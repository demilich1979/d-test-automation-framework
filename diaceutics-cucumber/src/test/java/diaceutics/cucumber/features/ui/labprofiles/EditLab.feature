Feature: Edit a Lab

  Background:
    Given Labs page is opened
    When I select 'Albania' country on Labs page
    Then Filters page is opened
    When I select 'Test lab' lab on Filters Labs page
    Then Lab Profile page is opened

  @EditALab
  Scenario: DIAFE:0007 Possibility to edit a lab and validate an edited data
    When I click on Edit Details on Lab Profile Page
    Then Edit Profile page is opened
    When I change Lab Details form using following data and sava as 'lab':
      | Country  | Albania      |
      | Name     | TestLab      |
      | URL      | TestLab      |
      | Lab type | Academic Lab |
  And I click Save on Edit Profile page


#  2. Change Contry, Name and Lab Type - to Academic
#  3. Click Save
#  4. Click "Return to profile"
#  5. On Lab Profile Page click on Edit Details
#  6. Change Contry, Name and Lab Type - to Private
#  7. Click Save
#  8. Click "Return to profile"
#
#  1. Edit Profile page opened
#  2. Data set
#  3. "Lab updated" message displayed
#  4. Validate lab name and lab type
#  5. Edit Profile page opened
#  6. Data set
#  7. "Lab updated" message displayed
#  8. Validate lab name and lab type