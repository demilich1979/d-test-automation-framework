Feature: Marketplace smoke tests

  @Marketplace
  Scenario: User login verification
    Given Marketplace Main page is opened
    When I click 'Login' on Marketplace Main page
      Then Login page is opened
    When I login as 'testUser' user
      Then Home page is opened
      And User should be logged in

  @Marketplace @Smoke
  Scenario: User registration check
    Given Marketplace Main page is opened
    When I click 'Register' on Marketplace Main page
    Then Register page is opened
    When I fill following fields on Personal Details form on Register page and save as 'user':
      | Type                                   | Laboratory      |
      | COMPANY NAME                           | Test lab        |
      | FIRST NAME OF THE LEGAL REPRESENTATIVE | Test first name |
      | LAST NAME OF THE LEGAL REPRESENTATIVE  | Test last name  |
      | EMAIL                                  | @mailosaur.io   |
      | NEW PASSWORD                           | Testpassword    |
      | VERIFICATION                           | Testpassword    |
      | I accept the Terms and Conditions      | true            |
      | I accept the Privacy Policy            | true            |
    And I click Register on Personal Details form on Register page
      Then Marketplace Main page is opened
      And I get a mail for the 'user' with a subject 'Verify your email'
      And I get a mail for the 'user' with a subject 'Your account on DXRX is under moderation'
      And I open Verify Link from 'user' mail with subject 'Verify your email' and confirm registration
#      Then Register Confirmed page is opened
#      Then Company logo form on Register page is opened
