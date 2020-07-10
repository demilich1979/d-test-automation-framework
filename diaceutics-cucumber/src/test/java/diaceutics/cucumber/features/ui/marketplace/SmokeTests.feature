Feature: Marketplace smoke tests

  @Marketplace @Smoke
  Scenario: User login verification
    Given Marketplace Main page is opened
    When I click 'Login' on Marketplace Main page
      Then Login page is opened
    When I login as 'testUser' user
#      Then User 'testUser' should be logged in

  @Marketplace @Smoke
  Scenario: User registration check
    Given Marketplace Main page is opened
    When I click 'Register' on Marketplace Main page
      Then Register page is opened
    When I fill following fields on Register page and save as 'account':
      | Type                                   | Laboratory        |
      | COMPANY NAME                           | Test company name |
      | FIRST NAME OF THE LEGAL REPRESENTATIVE | Test first name   |
      | LAST NAME OF THE LEGAL REPRESENTATIVE  | Test last name    |
      | EMAIL                                  | Test email        |
      | NEW PASSWORD                           | Test password     |
      | VERIFICATION                           | Test verification |
      | I accept the Terms and Conditions      | true              |
      | I accept the Privacy Policy            | true              |
    And I click Register on Register page
#    Then User 'testUser' should be registered