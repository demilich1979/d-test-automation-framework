Feature: Assay Management

  Background:
    Given Marketplace Main page is opened
    When I click 'Login' on Marketplace Main page
      Then Login page is opened
    When I login as 'adminUser' user
      Then Home page is opened
      And User should be logged in
    When I open 'Assay Management' tools
      Then Assay Management page is opened
    When I put a Lab 'labOne' on search field 'Enter keywords' and press Search icon on Assay Management page
      Then Labs page is opened
      And Lab 'labOne' is displayed in filter results on Labs page
    When I select 'labOne' lab on Labs page
      Then Lab Profile page is opened

  @AssayManagement @Assay
  Scenario: DIAFE:0021 Possibility to add an assay
    When I click on 'Add assay' on Lab Profile Page
      Then Add an Assay page is opened
    When I fill following fields on Add an Assay page and save as 'assay':
      | Assay name                            | Test Assay              |
      | Assay description                     | Test Assay description  |
      | Ontologies                            | random                  |
      | Scoring method                        | random                  |
      | Specimens Tested                      | random                  |
      | Detects Germline/Somatic alterations  | random                  |
      | FDA 510K APPROVED KIT                 | true                    |
      | Laboratory Developed Test (LDT)       | false                   |
      | FDA PMA APPROVED KIT                  | false                   |
      | IVD-CE                                | false                   |
      | RUO/IUO                               | false                   |
      | Turn around time (days)               | 55                      |
      | Associated diseases                   | random                  |
      | Method                                | random                  |
      | Method description                    | Test Method description |
      | Result Format                         | random                  |
      | Report sample URL                     | Test Report sample URL  |
#      | Send-out or inhouse?                  | Send-out                |
#      | Send-out Lab                          | random                  |
      | Panel name radio                      | Yes                     |
      | Panel name                            | Test Panel              |
      | Accuracy                              | 55                      |
      | Precision                             | 55                      |
      | Sensitivity                           | 55                      |
      | Batch or Individual?                  | Batch                   |
      | Variants included?                    | Yes                     |
    And I click 'Add Biomarker' on Add an Assay page
      Then Add Biomarker form is opened
    When I fill following fields on Add Biomarker form and save as 'biomarker':
      | Biomarker | random |
      | Variants  | random |
    And I click Save changes on Add Biomarker form
      Then Biomarker 'biomarker' is added to Biomarker & disease grid on Add an Assay page
    When I click 'Add Assay' on Add an Assay page
      Then Lab Profile page is opened
      And 'New lab assay added.' message is displayed on Lab Profile page
      And Assay 'assay' is displayed in Assays grid on Lab Profile page

  @AssayManagement @Assay
  Scenario: DIAFE:0022 Possibility to edit assays
    When I click on Assay 'assay' in Assays grid on Lab Profile Page
      Then Assay details page is opened
    When I click Edit Details on Assay details page
      Then Edit Assay page is opened
    When I fill following fields on Edit Assay page and save as 'assay':
      | Assay name                      | New Assay |
      | FDA 510K APPROVED KIT           | false     |
      | Laboratory Developed Test (LDT) | false     |
      | FDA PMA APPROVED KIT            | false     |
      | IVD-CE                          | false     |
      | RUO/IUO                         | true      |
      | Method                          | random    |
    And I click 'Save' on Edit Assay page
      Then Lab Profile page is opened
      And 'Lab assay updated.' message is displayed on Lab Profile page
      And Assay 'assay' is displayed in Assays grid on Lab Profile page

  @AssayManagement @Assay
  Scenario: DIAFE:0023 Required fields validation
    When I click on 'Add assay' on Lab Profile Page
      Then Add an Assay page is opened
    When I click 'Add Assay' on Add an Assay page
      Then Message 'Some items below need your attention.' is displayed on Add an Assay page
      And Message 'Please enter an assay name' is displayed on required fields on Add an Assay page
      And Message 'Please provide at least one value' is displayed on required fields on Add an Assay page
      And Message 'At least one classification is required' is displayed on required fields on Add an Assay page
      And Message 'Turn around time is required' is displayed on required fields on Add an Assay page
      And Message 'At least one biomarker is required' is displayed on required fields on Add an Assay page
      And Message 'Method is required' is displayed on required fields on Add an Assay page
    When I fill following fields on Add an Assay page and save as 'assayOne':
      | Panel name radio | No |
      Then Field 'Panel name' should be disabled on Add an Assay page
    When I fill following fields on Add an Assay page and save as 'assayOne':
      | Panel name radio | Yes |
      Then Field 'Panel name' should be enabled on Add an Assay page
    When I fill following fields on Add an Assay page and save as 'assayOne':
      | Send-out or inhouse? | Unspecified |
      Then Field 'Send-out Lab' should be disabled on Add an Assay page
    When I fill following fields on Add an Assay page and save as 'assayOne':
      | Send-out or inhouse? | Inhouse |
      Then Field 'Send-out Lab' should be disabled on Add an Assay page
    When I fill following fields on Add an Assay page and save as 'assayOne':
      | Send-out or inhouse? | Send-out |
      Then Field 'Send-out Lab' should be enabled on Add an Assay page
    When I fill following fields on Add an Assay page and save as 'assayOne':
      | Turn around time (days) | 0 |
      And Message 'Please enter a value greater than 0.' is displayed on required fields on Add an Assay page

  @AssayManagement @Assay
  Scenario: DIAFE:0024 "Accuracy, precision, sensitivity and specificity" field validation
    When I click on Assay 'assay' in Assays grid on Lab Profile Page
      Then Assay details page is opened
    When I click Edit Details on Assay details page
      Then Edit Assay page is opened
    When I fill following fields on Edit Assay page and save as 'assay':
      | Accuracy    | -55 |
      | Precision   | -55 |
      | Sensitivity | -55 |
    And I click 'Save' on Edit Assay page
      Then Message 'Accuracy: Please enter a value between 0 and 100.' is displayed on required fields on Edit Assay page
      And Message 'Precision: Please enter a value between 0 and 100.' is displayed on required fields on Edit Assay page
      And Message 'Sensitivity: Please enter a value between 0 and 100.' is displayed on required fields on Edit Assay page
    When I fill following fields on Edit Assay page and save as 'assay':
      | Accuracy    | 155 |
      | Precision   | 155 |
      | Sensitivity | 155 |
    And I click 'Save' on Edit Assay page
      Then Message 'Accuracy: Please enter a value between 0 and 100.' is displayed on required fields on Edit Assay page
      And Message 'Precision: Please enter a value between 0 and 100.' is displayed on required fields on Edit Assay page
      And Message 'Sensitivity: Please enter a value between 0 and 100.' is displayed on required fields on Edit Assay page

  @AssayManagement @Assay
  Scenario: DIAFE:0025 Filter an assay by keyword
    When I put a Assay 'assay' on search field 'Search assays' and press Search icon on Lab Profile page
      Then Assay 'assay' is displayed in Assays grid on Lab Profile page

  @AssayManagement @Assay
  Scenario: DIAFE:0026 Possibility to sort assays
    When I click on 'Add assay' on Lab Profile Page
      Then Add an Assay page is opened
    When I fill following fields on Add an Assay page and save as 'assayOne':
      | Assay name                            | Test Assay |
      | Ontologies                            | random     |
      | Detects Germline/Somatic alterations  | random     |
      | FDA 510K APPROVED KIT                 | false      |
      | Laboratory Developed Test (LDT)       | false      |
      | FDA PMA APPROVED KIT                  | false      |
      | IVD-CE                                | true       |
      | RUO/IUO                               | false      |
      | Turn around time (days)               | 555        |
      | Method                                | random     |
    And I click 'Add Biomarker' on Add an Assay page
      Then Add Biomarker form is opened
    When I fill following fields on Add Biomarker form and save as 'biomarkerOne':
      | Biomarker | random |
      | Variants  | random |
    And I click Save changes on Add Biomarker form
      Then Biomarker 'biomarkerOne' is added to Biomarker & disease grid on Add an Assay page
    When I click 'Add Assay' on Add an Assay page
      Then Lab Profile page is opened
    When I click on 'Add assay' on Lab Profile Page
      Then Add an Assay page is opened
    When I fill following fields on Add an Assay page and save as 'assayTwo':
      | Assay name                            | Test Assay |
      | Ontologies                            | random     |
      | Detects Germline/Somatic alterations  | random     |
      | FDA 510K APPROVED KIT                 | false      |
      | Laboratory Developed Test (LDT)       | false      |
      | FDA PMA APPROVED KIT                  | false      |
      | IVD-CE                                | true       |
      | RUO/IUO                               | false      |
      | Turn around time (days)               | 555        |
      | Method                                | random     |
    And I click 'Add Biomarker' on Add an Assay page
      Then Add Biomarker form is opened
    When I fill following fields on Add Biomarker form and save as 'biomarkerTwo':
      | Biomarker | random |
      | Variants  | random |
    And I click Save changes on Add Biomarker form
      Then Biomarker 'biomarkerTwo' is added to Biomarker & disease grid on Add an Assay page
    When I click 'Add Assay' on Add an Assay page
      Then Lab Profile page is opened
      And Assay 'assayOne' is displayed in Assays grid on Lab Profile page
      And Assay 'assayTwo' is displayed in Assays grid on Lab Profile page
    When I sort data by alphabet in 'Assay name' column on 'Assays' Grid
      Then Data in 'Assay name' column on 'Assays' Grid sorted according to alphabet
    When I sort data by alphabet in 'Classifications' column on 'Assays' Grid
      Then Data in 'Classifications' column on 'Assays' Grid sorted according to alphabet

  @AssayManagement @Assay
  Scenario: DIAFE:0027 Check number of assays
    When I count the number of platforms in the 'Assays' grid and save as 'numberOfAssays'
      Then 'numberOfAssays' must be the same as a number stated in the 'Assays' Grid title
