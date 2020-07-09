Feature: MarketPlace smoke tests

  @MarketPlace @Smoke
  Scenario: User login verification
    Given Marketplace Main page is opened
    When I click 'Login' on Marketplace Main page
      Then Login page is opened
    When I login as 'testUser' user

