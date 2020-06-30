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
      | Laboratory Developed Test (LDT)       | false                   |
      | FDA PMA Approved Kit                  | true                    |
      | IVD-CE                                | true                    |
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
    And I click 'Add Biomarker' on Add an Assay page
      Then Add Biomarker form is opened
    When I fill following fields on Add Biomarker form and save as 'assay':
      | Biomarker | random |
    And I click Save changes on Add Biomarker form
    And I click 'Add Assay' on Add an Assay page
      Then Lab Profile page is opened
      And 'New lab assay added.' message is displayed on Lab Profile page
      And Assay 'assay' is added to Assays grid on Lab Profile page

