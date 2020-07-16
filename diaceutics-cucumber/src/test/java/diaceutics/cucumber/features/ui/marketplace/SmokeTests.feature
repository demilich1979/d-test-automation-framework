Feature: Marketplace smoke tests

  @Marketplace
  Scenario: User login verification
    Given Marketplace Main page is opened
    When I click 'Login' on Marketplace Main page
      Then Login page is opened
    When I login as 'adminUser' user
      Then Home page is opened
      And User should be logged in

  @Marketplace
  Scenario: User registration check
    Given Marketplace Main page is opened
    When I click 'Register' on Marketplace Main page
      Then Registration page is opened
    When I fill following fields on Personal Details form on Registration page and save as 'user':
      | Type                                   | Laboratory      |
      | COMPANY NAME                           | Test lab        |
      | FIRST NAME OF THE LEGAL REPRESENTATIVE | Test first name |
      | LAST NAME OF THE LEGAL REPRESENTATIVE  | Test last name  |
      | EMAIL                                  | @mailosaur.io   |
      | NEW PASSWORD                           | Testpassword    |
      | VERIFICATION                           | Testpassword    |
      | I accept the Terms and Conditions      | true            |
      | I accept the Privacy Policy            | true            |
    And I click Register on Personal Details form on Registration page
      Then Marketplace Main page is opened
      And I get a mail for the 'user' with a subject 'Verify your email'
      And I get a mail for the 'user' with a subject 'Your account on DXRX is under moderation'
    When I open Verify Link from 'user' mail with subject 'Verify your email' and confirm registration
      Then Registration Confirmed page is opened
      And Message 'Your email address was successfully verified.' is displayed Registration Confirmed page
    When I click Back to dxrx-marketplace on Registration Confirmed page
      Then Login page is opened
#    When I login as 'user' user
#      Then Home page is opened
#      And User should be logged in

  @Marketplace
  Scenario: User Logout Confirmation
    Given Marketplace Main page is opened
    When I click 'Login' on Marketplace Main page
      Then Login page is opened
    When I login as 'adminUser' user
      Then Home page is opened
      And User should be logged in
    When I click 'Logout' on user menu on Marketplace header
      Then Marketplace Main page is opened
      And User should be logout

  @Marketplace
  Scenario: Checking the links (login, register) on the Marketplace header
    Given Marketplace Main page is opened
    When I click 'Login' on Marketplace header
      Then Login page is opened
    When I click back on browser
      Then Marketplace Main page is opened
    When I click 'Register' on Marketplace header
      Then Registration page is opened

  @Marketplace
  Scenario: Checking the links (login, register) on the bottom of the Marketplace page
    Given Marketplace Main page is opened
    When I click link 'Login' on the bottom of the Marketplace Main page
      Then Login page is opened
    When I click back on browser
      Then Marketplace Main page is opened
    When I click link 'Register' on the bottom of the Marketplace Main page
      Then Registration page is opened

  @Marketplace @Smoke
  Scenario: Checking the user data
    Given Marketplace Main page is opened
    When I click 'Login' on Marketplace Main page
      Then Login page is opened
    When I login as 'adminUser' user
      Then Home page is opened
      And User should be logged in
    When I click 'My profile' on user menu on Marketplace header
      Then MyProfile page is opened
      And Data for user 'adminUser' is displayed on the following fields on User Edit Identity Form on MyProfile page:
        | FIRST NAME                     |
        | LAST NAME                      |
        | WEBSITE                        |
        | Email                          |
        | Phone                          |
        | Country                        |
        | CITY                           |
        | ZIP                            |
        | STATE                          |
        | ADDRESS STREET NUMBER AND NAME |
    When I click 'Organization' on user menu on Marketplace header
      Then Organization page is opened
    When I click 'General details' on Organization page
      Then Organization Edit Identity Form on Organization page is opened
      And Data for user 'adminUser' is displayed on the following fields on Organization Edit Identity Form:
        | TYPE                           |
        | COMPANY NAME                   |
        | COUNTRY                        |
        | CITY                           |
        | ZIP                            |
        | STATE                          |
        | ADDRESS STREET NUMBER AND NAME |
