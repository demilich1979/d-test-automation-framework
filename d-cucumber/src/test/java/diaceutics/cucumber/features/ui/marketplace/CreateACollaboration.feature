Feature: Create a Collaboration

  Background:
    Given Marketplace Main page is opened
    When I click 'Login' on Marketplace Main page
      Then Login page is opened
    When I login as 'User' user
      Then Home page is opened
      And User should be logged in
    When I click Start a collaboration on Home page
      Then Description collaboration page is opened

  @Marketplace @Collaboration
  Scenario: Possibility to successfully create a Collaboration with image
    When I fill following fields on Description of the collaboration page and save as 'collaboration':
      | TITLE              | Test title        |
      | Description        | Test description  |
      | Other requirements | Test requirements |
      | Type               | Laboratory        |
    And I upload file 'TestImage.png' on Description collaboration page
      Then File 'TestImage.png' is uploaded on Description collaboration page
    When I click 'Proceed to step 2 of 2' on Description collaboration page
      Then Location of the collaboration page is opened
    When I fill following fields on Location of the collaboration page and save as 'collaboration':
      | COUNTRY                           | Belarus          |
      | CITY                              | Minsk            |
      | ZIP                               | 1100             |
      | NUMBER                            | 76               |
      | ROUTE                             | Test route       |
      | Additional location information   | Test information |
      | I accept the Terms and Conditions | true             |
    And I click 'Publish a collaboration' on Location of the collaboration page
      Then Edit collaboration page is opened
      And Collaboration 'collaboration' with following fields is displayed on Presentation form on Edit collaboration page
        | TITLE              |
        | Description        |
        | Other requirements |
    When I click 'Categories' on Edit collaboration page
      Then Categories form on Edit collaboration page is opened
      And Categories are displayed for Collaboration 'collaboration' on Categories form on Edit collaboration page

  @Marketplace @Collaboration
  Scenario: Possibility to successfully create a Collaboration with pdf file
    When I fill following fields on Description of the collaboration page and save as 'collaboration':
      | TITLE              | Test title        |
      | Description        | Test description  |
      | Other requirements | Test requirements |
      | Type               | Laboratory        |
    And I upload file 'TestImage.png' on Description collaboration page
      Then File 'TestImage.png' is uploaded on Description collaboration page
    When I upload file 'TestPDF.pdf' on Description collaboration page
      Then File 'TestPDF.pdf' is uploaded on Description collaboration page
    When I click 'Proceed to step 2 of 2' on Description collaboration page
      Then Location of the collaboration page is opened
    When I fill following fields on Location of the collaboration page and save as 'collaboration':
      | COUNTRY                           | Belarus          |
      | CITY                              | Minsk            |
      | ZIP                               | 1100             |
      | NUMBER                            | 76               |
      | ROUTE                             | Test route       |
      | Additional location information   | Test information |
      | I accept the Terms and Conditions | true             |
    And I click 'Publish a collaboration' on Location of the collaboration page
      Then Edit collaboration page is opened
      And Collaboration 'collaboration' with following fields is displayed on Presentation form on Edit collaboration page
        | TITLE              |
        | Description        |
        | Other requirements |
    When I click 'Categories' on Edit collaboration page
      Then Categories form on Edit collaboration page is opened
      And Categories are displayed for Collaboration 'collaboration' on Categories form on Edit collaboration page

  @Marketplace @Collaboration
  Scenario: Possibility to successfully create a Collaboration with video
    When I fill following fields on Description of the collaboration page and save as 'collaboration':
      | TITLE              | Test title        |
      | Description        | Test description  |
      | Other requirements | Test requirements |
      | Type               | Laboratory        |
    And I upload file 'TestImage.png' on Description collaboration page
      Then File 'TestImage.png' is uploaded on Description collaboration page
    When I click by Videos on Description collaboration page
    And I fill following fields on Description of the collaboration page and save as 'collaboration':
      | Enter a Youtube URL | https://www.youtube.com/watch?v=AeTZuX9ZOj0&feature=emb_logo |
    And I click Add video on Description collaboration page
    And I click 'Proceed to step 2 of 2' on Description collaboration page
      Then Location of the collaboration page is opened
    When I fill following fields on Location of the collaboration page and save as 'collaboration':
      | COUNTRY                           | Belarus          |
      | CITY                              | Minsk            |
      | ZIP                               | 1100             |
      | NUMBER                            | 76               |
      | ROUTE                             | Test route       |
      | Additional location information   | Test information |
      | I accept the Terms and Conditions | true             |
    And I click 'Publish a collaboration' on Location of the collaboration page
    Then Edit collaboration page is opened
    And Collaboration 'collaboration' with following fields is displayed on Presentation form on Edit collaboration page
      | TITLE              |
      | Description        |
      | Other requirements |
    When I click 'Categories' on Edit collaboration page
      Then Categories form on Edit collaboration page is opened
      And Categories are displayed for Collaboration 'collaboration' on Categories form on Edit collaboration page

  @Marketplace @Collaboration
  Scenario: Create a Collaboration: Required fields validation
    When I click 'Proceed to step 2 of 2' on Description collaboration page
      Then Message 'Error creating your listing' is displayed on Description collaboration page
      And Error container is displayed for following fields on Description collaboration page:
        | TITLE              |
        | Description        |
        | Other requirements |
    When I fill following fields on Description of the collaboration page and save as 'collaboration':
      | TITLE              | Test title        |
      | Description        | Test description  |
      | Other requirements | Test requirements |
    And I click 'Proceed to step 2 of 2' on Description collaboration page
      Then Error container is not displayed for following fields on Description collaboration page:
        | TITLE              |
        | Description        |
        | Other requirements |
    When I click 'Proceed to step 2 of 2' on Description collaboration page
      Then Message 'Error creating your listing' is displayed on Description collaboration page
    When I upload file 'TestImage.png' on Description collaboration page
      Then File 'TestImage.png' is uploaded on Description collaboration page
    When I click 'Proceed to step 2 of 2' on Description collaboration page
      Then Location of the collaboration page is opened
