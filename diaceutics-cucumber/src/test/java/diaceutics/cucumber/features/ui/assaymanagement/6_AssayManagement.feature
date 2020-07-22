Feature: Assay Management

  Background:
    Given Marketplace Main page is opened
    When I click 'Login' on Marketplace Main page
      Then Login page is opened
    When I login as 'adminUser' user
      Then Home page is opened
      And User should be logged in
    When I open 'Assay Management' tools
    And I select last window
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
      | Assay name             | Test Assay              |
      | Assay description      | Test Assay description  |
      | Inhouse or send-out?   | Send-out                |
      | Send-out Lab           | random                  |
      | Detects                | random                  |
      | Specimens Tested       | random                  |
      | Method                 | random                  |
      | Method description     | Test Method description |
      | Turn around time (TaT) | 5                       |
      | Ontology               | random                  |
      | Sensitivity            | 55                      |
      | Scoring method         | random                  |
      | Result Format          | random                  |
      | Classification         | Commercial assay        |
      | FDA 510K APPROVED KIT  | true                    |
      | FDA PMA APPROVED KIT   | false                   |
      | IVD-CE                 | true                    |
      | RUO/IUO                | false                   |
    And I click 'Add Biomarker' on Add an Assay page
      Then Add Biomarker form is opened on Add an Assay page
    When I fill following fields on Add Biomarker form and save as 'biomarker':
      | Biomarker | random |
      | Variants  | random |
    And I click Save changes on Add Biomarker form
    And I click 'Done' on Add Biomarker form
      Then Biomarker 'biomarker' is added to Biomarker grid on Add an Assay page
    When I click 'Add Assay' on Add an Assay page
      Then Lab Profile page is opened
      And 'New lab assay added.' message is displayed on Lab Profile page
      And Assay 'assay' is displayed in Assays grid on Lab Profile page

  @AssayManagement @Assay
  Scenario: DIAFE:0022 Possibility to edit assays
    When I click on Assay 'assay' in Assays grid on Lab Profile Page
      Then Assay description page is opened
    When I click Edit Details on Assay description page
      Then Edit Assay page is opened
    When I fill following fields on Edit Assay page and save as 'assay':
      | Assay name             | New Assay               |
      | Assay description      | New Assay description   |
      | Specimens Tested       | random                  |
      | Method                 | random                  |
      | Method description     | Test Method description |
      | Turn around time (TaT) | 5                       |
      | Ontology               | random                  |
      | Sensitivity            | 55                      |
      | Scoring method         | random                  |
      | Result Format          | random                  |
      | Classification         | Commercial assay        |
      | FDA 510K APPROVED KIT  | true                    |
      | FDA PMA APPROVED KIT   | true                    |
      | IVD-CE                 | true                    |
      | RUO/IUO                | true                    |
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
      And Message 'Method is required' is displayed on required fields on Add an Assay page
      And Message 'Turn around time is required' is displayed on required fields on Add an Assay page
      And Message 'Classification is required' is displayed on required fields on Add an Assay page
      And Message 'At least one biomarker is required' is displayed on required fields on Add an Assay page
    When I fill following fields on Add an Assay page and save as 'assayOne':
      | Classification | Lab developed test (LDT) |
      Then Field 'FDA 510K APPROVED KIT' should be disabled on Add an Assay page
      And Field 'FDA PMA APPROVED KIT' should be disabled on Add an Assay page
      And Field 'IVD-CE' should be disabled on Add an Assay page
      And Field 'RUO/IUO' should be disabled on Add an Assay page
      And Field 'Commercial Assays' should be disabled on Add an Assay page
    When I fill following fields on Add an Assay page and save as 'assayOne':
      | Inhouse or send-out? | Not specified |
      Then Field 'Send-out Lab' should be disabled on Add an Assay page
    When I fill following fields on Add an Assay page and save as 'assayOne':
      | Inhouse or send-out? | Inhouse |
      Then Field 'Send-out Lab' should be disabled on Add an Assay page
    When I fill following fields on Add an Assay page and save as 'assayOne':
      | Inhouse or send-out? | Send-out |
      Then Field 'Send-out Lab' should be enabled on Add an Assay page
    When I fill following fields on Add an Assay page and save as 'assayOne':
      | Turn around time (TaT) | 0 |
      And Message 'Please enter a value greater than 0.' is displayed on required fields on Add an Assay page

  @AssayManagement @Assay
  Scenario: DIAFE:0024 Sensitivity field validation
    When I click on Assay 'assay' in Assays grid on Lab Profile Page
      Then Assay description page is opened
    When I click Edit Details on Assay description page
      Then Edit Assay page is opened
    When I fill following fields on Edit Assay page and save as 'assay':
      | Sensitivity | -55 |
    And I click 'Save' on Edit Assay page
      And Message 'Please enter a value between 0 and 100.' is displayed on required fields on Edit Assay page
    When I fill following fields on Edit Assay page and save as 'assay':
      | Sensitivity | 155 |
    And I click 'Save' on Edit Assay page
      And Message 'Please enter a value between 0 and 100.' is displayed on required fields on Edit Assay page

  @AssayManagement @Assay
  Scenario: DIAFE:0025 Filter an assay by keyword
    When I put a Assay 'assay' on search field 'Search assays' and press Search icon on Lab Profile page
      Then Assay 'assay' is displayed in Assays grid on Lab Profile page

  @AssayManagement @Assay
  Scenario: DIAFE:0026 Possibility to sort assays
    When I click on 'Add assay' on Lab Profile Page
      Then Add an Assay page is opened
    When I fill following fields on Add an Assay page and save as 'assayOne':
      | Assay name             | New Assay                |
      | Assay description      | New Assay description    |
      | Detects                | random                   |
      | Specimens Tested       | random                   |
      | Method                 | random                   |
      | Method description     | Test Method description  |
      | Turn around time (TaT) | 5                        |
      | Ontology               | random                   |
      | Sensitivity            | 55                       |
      | Scoring method         | random                   |
      | Result Format          | random                   |
      | Classification         | Lab developed test (LDT) |
    And I click 'Add Biomarker' on Add an Assay page
      Then Add Biomarker form is opened on Add an Assay page
    When I fill following fields on Add Biomarker form and save as 'biomarkerOne':
      | Biomarker | random |
      | Variants  | random |
    And I click Save changes on Add Biomarker form
    And I click 'Done' on Add Biomarker form
      Then Biomarker 'biomarkerOne' is added to Biomarker grid on Add an Assay page
    When I click 'Add Assay' on Add an Assay page
      Then Lab Profile page is opened
      And Assay 'assayOne' is displayed in Assays grid on Lab Profile page
    When I click on 'Add assay' on Lab Profile Page
      Then Add an Assay page is opened
    When I fill following fields on Add an Assay page and save as 'assayTwo':
      | Assay name             | Test Assay              |
      | Assay description      | Test Assay description  |
      | Inhouse or send-out?   | Send-out                |
      | Send-out Lab           | random                  |
      | Detects                | random                  |
      | Specimens Tested       | random                  |
      | Method                 | random                  |
      | Method description     | Test Method description |
      | Turn around time (TaT) | 5                       |
      | Ontology               | random                  |
      | Sensitivity            | 55                      |
      | Scoring method         | random                  |
      | Result Format          | random                  |
      | Classification         | Commercial assay        |
      | FDA 510K APPROVED KIT  | true                    |
      | FDA PMA APPROVED KIT   | false                   |
      | IVD-CE                 | false                   |
      | RUO/IUO                | false                   |
    And I click 'Add Biomarker' on Add an Assay page
      Then Add Biomarker form is opened on Add an Assay page
    When I fill following fields on Add Biomarker form and save as 'biomarkerTwo':
      | Biomarker | random |
      | Variants  | random |
    And I click Save changes on Add Biomarker form
    And I click 'Done' on Add Biomarker form
      Then Biomarker 'biomarkerTwo' is added to Biomarker grid on Add an Assay page
    When I click 'Add Assay' on Add an Assay page
      Then Lab Profile page is opened
      And Assay 'assayTwo' is displayed in Assays grid on Lab Profile page
    When I sort data by alphabet in 'Assay name' column on 'Assays' Grid
      Then Data in 'Assay name' column on 'Assays' Grid sorted according to alphabet
    When I sort data by alphabet in 'Classifications' column on 'Assays' Grid
      Then Data in 'Classifications' column on 'Assays' Grid sorted according to alphabet

  @AssayManagement @Assay
  Scenario: DIAFE:0027 Check number of assays
    When I count the number of platforms in the 'Assays' grid and save as 'numberOfAssays'
      Then 'numberOfAssays' must be the same as a number stated in the 'Assays' Grid title

  @AssayManagement @Assay
  Scenario: DIAFE:0028 Verification the classification 'Lab developed test (LDT)'
    When I click on Assay 'assay' in Assays grid on Lab Profile Page
      Then Assay description page is opened
    When I click Edit Details on Assay description page
      Then Edit Assay page is opened
    When I fill following fields on Edit Assay page and save as 'assay':
      | Assay name             | New Assay                |
      | Assay description      | New Assay description    |
      | Specimens Tested       | random                   |
      | Method                 | random                   |
      | Method description     | Test Method description  |
      | Turn around time (TaT) | 5                        |
      | Ontology               | random                   |
      | Sensitivity            | 55                       |
      | Scoring method         | random                   |
      | Result Format          | random                   |
      | Classification         | Lab developed test (LDT) |
      Then Biomarker 'biomarker' is not displayed in Biomarker grid on Edit Assay page
    When I click 'Add Biomarker' on Edit Assay page
      Then Add Biomarker form is opened on Edit Assay page
    When I fill following fields on Add Biomarker form and save as 'biomarker':
      | Biomarker | random |
      | Variants  | random |
    And I click Save changes on Add Biomarker form
    And I click 'Done' on Add Biomarker form
      Then Biomarker 'biomarker' is added to Biomarker grid on Edit Assay page
    When I click 'Save' on Edit Assay page
      Then Lab Profile page is opened
      And 'Lab assay updated.' message is displayed on Lab Profile page
      And Assay 'assay' is displayed in Assays grid on Lab Profile page

  @AssayManagement @Assay
  Scenario: DIAFE:0029 Verification the classification 'Commercial assay'
    When I click on Assay 'assay' in Assays grid on Lab Profile Page
      Then Assay description page is opened
    When I click Edit Details on Assay description page
      Then Edit Assay page is opened
    When I fill following fields on Edit Assay page and save as 'assay':
      | Assay name            | Test Assay       |
      | Method                | Real Time PCR    |
      | Classification        | Commercial assay |
      | FDA 510K APPROVED KIT | true             |
      | FDA PMA APPROVED KIT  | false            |
      | IVD-CE                | true             |
      | RUO/IUO               | false            |
      | Commercial Assays     | random           |
      Then The default biomarker input should not be visible on Edit Assay page
      And Message '1 Biomarkers with variants linked to this assay' is displayed on Edit Assay page
      And Commercial assay Biomarkers are added to this assay 'assay'
    When I click 'Save' on Edit Assay page
      Then Lab Profile page is opened
      And 'Lab assay updated.' message is displayed on Lab Profile page
      And Assay 'assay' is displayed in Assays grid on Lab Profile page
