Feature: Marketplace smoke tests

  @Marketplace
  Scenario: User login verification
    Given Marketplace Main page is opened
    When I click 'Login' on Marketplace Main page
      Then Login page is opened
    When I login as 'User' user
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
      | POSITION WITHIN THE ORGANIZATION       | Test position   |
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
      And Message 'Your email address was successfully verified.' is displayed on Registration Confirmed page
#    When I click Back to dxrx-marketplace on Registration Confirmed page
#      Then Login page is opened
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

  @Marketplace
  Scenario: Checking the user data
    Given Marketplace Main page is opened
    When I click 'Login' on Marketplace Main page
      Then Login page is opened
    When I login as 'User' user
      Then Home page is opened
      And User should be logged in
    When I click 'My profile' on user menu on Marketplace header
      Then MyProfile page is opened
      And Data for user 'User' is displayed on the following fields on User Edit Identity Form on MyProfile page:
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
      And Data for user 'User' is displayed on the following fields on Organization Edit Identity Form:
        | TYPE                           |
        | COMPANY NAME                   |
        | COUNTRY                        |
        | CITY                           |
        | ZIP                            |
        | STATE                          |
        | ADDRESS STREET NUMBER AND NAME |

  @Marketplace
  Scenario: Search form validation
    Given Marketplace Main page is opened
    When I fill following fields on Search form on Marketplace Main page and save as 'search template':
      | Enter a location | Albania |
      | Type             | random |
#      | Keywords         | Test   |
      | Laboratory       | true   |
      | Pharmaceutical   | true   |
      | Diagnostic       | false  |
    And I click Search on Search form on Marketplace Main page
      Then SearchResults page is opened

  @Marketplace @Smoke
  Scenario: Validation required fields for the login page
    Given Marketplace Main page is opened
    When I click 'Login' on Marketplace Main page
      Then Login page is opened
    When I click continue on Login page
      Then Alert message 'Please fill out this field.' is displayed on Login page
    When I login as 'nonexistentUser' user
      Then Message 'Wrong email or password' is displayed on Login page


  @Marketplace1
  Scenario: Validation required fields for the registration page
    Given Marketplace Main page is opened
    When I click 'Register' on Marketplace Main page
      Then Registration page is opened
    When I click Register on Personal Details form on Registration page
      Then Error container is displayed for following fields:
        | COMPANY NAME |
    When I fill following fields on Personal Details form on Registration page and save as 'user':
      | COMPANY NAME | Test lab |
    And I click Register on Personal Details form on Registration page
      Then Error container is not displayed for following fields:
        | COMPANY NAME |
      And Error container is displayed for following fields:
        | POSITION WITHIN THE ORGANIZATION       |
        | FIRST NAME OF THE LEGAL REPRESENTATIVE |
        | LAST NAME OF THE LEGAL REPRESENTATIVE  |
        | EMAIL                                  |
        | NEW PASSWORD                           |
        | VERIFICATION                           |
    When I fill following fields on Personal Details form on Registration page and save as 'user':
      | POSITION WITHIN THE ORGANIZATION       | Test position   |
      | FIRST NAME OF THE LEGAL REPRESENTATIVE | Test first name |
      | LAST NAME OF THE LEGAL REPRESENTATIVE  | Test last name  |
      | EMAIL                                  | @mailosaur.io   |
      | NEW PASSWORD                           | Testpassword    |
      | VERIFICATION                           | Testpassword    |
    And I click Register on Personal Details form on Registration page
      Then Error container is not displayed for following fields:
        | POSITION WITHIN THE ORGANIZATION       |
        | FIRST NAME OF THE LEGAL REPRESENTATIVE |
        | LAST NAME OF THE LEGAL REPRESENTATIVE  |
        | EMAIL                                  |
        | NEW PASSWORD                           |
        | VERIFICATION                           |

  @Marketplace
  Scenario: Possibility to successfully create a Collaboration
    Given Marketplace Main page is opened
    When I click 'Login' on Marketplace Main page
      Then Login page is opened
    When I login as 'adminUser' user
      Then Home page is opened
      And User should be logged in
    When I click Start a collaboration on Home page
      Then Description collaboration page is opened
    When I fill following fields on Description of the collaboration page and save as 'collaboration':
      | TITLE              | Test title        |
      | Description        | Test description  |
      | Other requirements | Test requirements |
      | Type               | Laboratory        |
    And I add image 'TestImage.png' on Description collaboration page
      Then Image 'TestImage.png' is added on Description collaboration page
    When I click 'Proceed to step 2 of 2' on Description collaboration page
      Then Location of the collaboration page is opened
    When I fill following fields on Location of the collaboration page and save as 'collaboration':
      | COUNTRY                           | Austria          |
      | CITY                              | Test city        |
      | ZIP                               | Test zip         |
      | NUMBER                            | Test number      |
      | ROUTE                             | Test route       |
      | Additional location information   | Test information |
      | I accept the Terms and Conditions | true             |
    And I click 'Publish a collaboration' on Location of the collaboration page

    When I click 'Collaborations' on user menu on Marketplace header
    Then Collaborations page is opened
