Feature: Assay Management

  Background:
    Given Labs page is opened
    When I select 'Albania' country on Labs page
      Then Filters page is opened
    When I select 'Test lab' lab on Filters Labs page
      Then Lab Profile page is opened

  @AssayManagement
  Scenario: DIAFE:0020 Possibility to add an assay
    When I click on 'Add assay' on Lab Profile Page
      Then Add an Assay page is opened
    When I fill following fields on Add an Assay page and save as 'assay':
      | Assay name                            | Test Assay name         |
      | Assay description                     | Test Assay description  |
      | Ontologies                            | random                  |
      | Specimens Tested                      | random                  |
      | Detects Germline/Somatic alterations  | random                  |
      | FDA 510K Approved Kit                 | true                    |
      | Laboratory Developed Test (LDT)       | true                   |
      | FDA PMA Approved Kit                  | true                   |
      | IVD-CE                                | true                   |
      | RUO/IUO                               | false                   |
      | Turn around time (days)               | 55555                   |
      | Associated diseases                   | random                  |
      | Method                                | random                  |
      | Method description                    | Test Method description |
#      | Commercial Assays                     | random                  |
      | Result Format                         | random                  |
      | Report sample URL                     | Test Report sample URL  |
      | Send-out or inhouse?                  | Inhouse                 |
#      | Send-out Lab                          | random                  |
      | Panel name radio                      | Yes                     |
      | Panel name                            | Test Panel name         |
      | Accuracy                              | 55                      |
      | Precision                             | 55                      |
      | Sensitivity                           | 55                      |
      | Batch or Individual?                  | Batch                   |
      | Variants included?                    | Yes                     |
#    And I click 'Add Biomarker' on Add an Assay page
      Then Add Biomarker form is opened
    When I fill following fields on Add Biomarker form and save as 'biomarker':
      | Biomarker | random |
    And I click Save changes on Add Biomarker form
      Then Biomarker 'biomarker' is added to Biomarker & disease grid on Add an Assay page
    When I click 'Add Assay' on Add an Assay page
      Then Lab Profile page is opened
      And 'New lab assay added.' message is displayed on Lab Profile page
      And Assay 'assay' is added to Assays grid on Lab Profile page

#  @AssayManagement
  Scenario: DIAFE:0021 Possibility to edit assays
    When I click on Assay 'assay' in Assays grid on Lab Profile Page
      Then Assay details page is opened
    When I click Edit Details on Assay details page
      Then Edit Assay page is opened
    When I fill following fields on Edit Assay page and save as 'assay':
      | Assay name                            | New Assay name |
      | FDA 510K Approved Kit                 | true           |
      | Laboratory Developed Test (LDT)       | true           |
      | FDA PMA Approved Kit                  | true           |
      | IVD-CE                                | true           |
      | RUO/IUO                               | true           |
      | Method                                | random         |
    And I click Save on Edit Assay page
      Then Lab Profile page is opened
      And 'Lab assay updated.' message is displayed on Lab Profile page
      And Assay 'assay' is added to Assays grid on Lab Profile page

