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
      | Laboratory Developed Test (LDT)       | true                    |
      | FDA PMA Approved Kit                  | true                    |
      | IVD-CE                                | true                    |
      | RUO/IUO                               | true                    |
      | Turn around time (days)               | 55555                   |
      | Associated diseases                   | random                  |
      | Method                                | random                  |
      | Method description                    | Test Method description |
      | Commercial Assays                     | random                  |
      | Result Format                         | random                  |
      | Report sample URL                     | Test Report sample URL  |
      | Send-out or inhouse?                  | Inhouse                 |
      | Send-out Lab                          | random                  |
      | Panel name radio                      | Yes                     |
      | Panel name                            | Test Panel name         |
      | Accuracy                              | 55                      |
      | Precision                             | 55                      |
      | Sensitivity                           | 55                      |
      | Batch or Individual?                  | Batch                   |
      | Variants included?                    | Yes                     |

