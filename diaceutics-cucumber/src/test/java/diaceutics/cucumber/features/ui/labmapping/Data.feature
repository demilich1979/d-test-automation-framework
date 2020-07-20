Feature: Data

  Background:
    Given Marketplace Main page is opened
    When I click 'Login' on Marketplace Main page
      Then Login page is opened
    When I login as 'adminUser' user
      Then Home page is opened
      And User should be logged in
    When I open 'Assay Management' tools
      Then Assay Management page is opened
    When I click 'Create a Lab' on Assay Management page
      Then Create a Lab page is opened
    When I fill following fields on Create a Lab page and save as 'lab':
      | Country  | Albania         |
      | Name     | TestLab         |
      | URL      | https://TestLab |
      | Lab type | Unspecified     |
    And I click 'Next' on Create a Lab page
      Then Lab Address page is opened
    When I fill following fields on Lab Address page and save as 'lab':
      | Location name | Test Location    |
      | Address 1     | Test Address 1   |
      | Address 2     | Test Address 2   |
      | City / Town   | Test City        |
      | Region        | Test Region      |
      | Country       | Albania          |
      | Postal code   | Test Postal code |
    And I click 'Finish' on Lab Address page
      Then Lab Profile page is opened
    And Lab 'lab' with following fields is displayed on Lab Profile page
      | Name     |
      | URL      |
      | Lab type |
    When I click on 'Add assay' on Lab Profile Page
      Then Add an Assay page is opened
    When I fill following fields on Add an Assay page and save as 'assay' for 'lab':
      | Assay name                            | Test Assay |
      | Ontologies                            | random     |
      | Detects Germline/Somatic alterations  | random     |
      | FDA 510K APPROVED KIT                 | true       |
      | Laboratory Developed Test (LDT)       | false      |
      | FDA PMA APPROVED KIT                  | false      |
      | IVD-CE                                | false      |
      | RUO/IUO                               | false      |
      | Turn around time (days)               | 55555      |
      | Associated diseases                   | random     |
      | Method                                | random     |
    And I click 'Add Biomarker' on Add an Assay page
      Then Add Biomarker form is opened
    When I fill following fields on Add Biomarker form and save as 'biomarker' for 'assay' for 'lab':
      | Biomarker | random |
      | Variants  | random |
    And I click Save changes on Add Biomarker form
      Then Biomarker 'biomarker' is added to Biomarker & disease grid on Add an Assay page
    When I click 'Add Assay' on Add an Assay page
      Then Lab Profile page is opened
      And 'New lab assay added.' message is displayed on Lab Profile page
      And Assay 'assay' is displayed in Assays grid on Lab Profile page
    When I click on 'Add volume' on Lab Profile Page
    Then Log patient volume form is opened
    When I fill following fields on Log patient volume form and save as 'volume':
      | Time period combobox | 2018 |
      | Time period radio    | q2   |
      | Volume               | 5    |
#    And I fill following fields on Log patient volume form and save as 'volume' using data from 'assay':
#      | Biomarker |
#      | Disease   |
    And I click 'Log volume' on Log patient volume form
      Then Message 'Your volume has been added for disease "%s" and biomarker "%s"' for 'volume' is displayed on Log patient volume form
    When I click 'Done' on Log patient volume form
      Then Lab Profile page is opened
      And Volume 'volume' is added to Volumes grid on Lab Profile page

  @LabMapping
  Scenario: DIAFE:0032 Lab Mapping Search
    When I click 'Lab Mapping' on Header form
      Then Lab Mapping Search page is opened
#    When I fill following fields on Lab Mapping Search page using data from 'lab':
#      | Country              |
#      | Disease              |
#      | Biomarker / Analogue |
    And I fill following fields on Lab Mapping Search page:
      | Year From  | 2017    |
      | Month From | January |
      | Year To    | 2020    |
      | Month To   | July    |
    And I click 'Start' on Lab Mapping Search page
      Then Lab Mapping Results page is opened
      And Lab 'lab' is displayed in Ag Grid on Lab Mapping Results page
