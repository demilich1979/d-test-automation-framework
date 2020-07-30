Feature: Volume Management

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

  @AssayManagement @VolumeManagement
  Scenario: DIAFE:0032 Possibility to add a volume to the existing lab
    When I click on 'Add volume' on Lab Profile Page
      Then Log patient volume form is opened
    When I fill following fields on Log patient volume form and save as 'volume':
      | Time period combobox | random |
      | Time period radio    | q2     |
      | Disease              | random |
      | Biomarker            | random |
      | Volume               | 5      |
    And I click 'Log volume' on Log patient volume form
      Then Message 'Your volume has been added for disease "%s" and biomarker "%s"' for 'volume' is displayed on Log patient volume form
    When I click 'Done' on Log patient volume form
      Then Lab Profile page is opened
      And Volume 'volume' is added to Volumes grid on Lab Profile page

  @AssayManagement @VolumeManagement
  Scenario: DIAFE:0033 Volume duplication impossibility
    When I click on 'Add volume' on Lab Profile Page
      Then Log patient volume form is opened
    When I fill following fields on Log patient volume form using data from 'volume':
      | Time period combobox |
      | Time period radio    |
      | Disease              |
      | Biomarker            |
      | Volume               |
    And I click 'Log volume' on Log patient volume form
      Then Message 'A volume already exists for this criteria and time period.' is displayed on Log patient volume form

  @AssayManagement @VolumeManagement
  Scenario: DIAFE:0034 Possibility to edit volumes
    When I click on Edit button for the 'volume' volume on Lab Profile Page
      Then Edit patient volume form is opened
    When I fill following fields on Edit patient volume form and save as 'volume':
      | Disease              | random |
      | Biomarker            | random |
      | Volume               | 51     |
    And I click 'Update volume' on Edit patient volume form
      Then Message 'Your volume has been added for disease "%s" and biomarker "%s"' for 'volume' is displayed on Edit patient volume form
    When I click 'Done' on Edit patient volume form
      Then Lab Profile page is opened
      And Volume 'volume' is added to Volumes grid on Lab Profile page

  @AssayManagement @VolumeManagement
  Scenario: DIAFE:0035 Possibility to sort volumes
    When I click on 'Add volume' on Lab Profile Page
      Then Log patient volume form is opened
    When I fill following fields on Log patient volume form and save as 'volumeOne':
      | Time period combobox | random |
      | Time period radio    | q4     |
      | Disease              | random |
      | Biomarker            | random |
      | Volume               | 50     |
    And I click 'Log volume' on Log patient volume form
      Then Message 'Your volume has been added for disease "%s" and biomarker "%s"' for 'volumeOne' is displayed on Log patient volume form
    When I click 'Done' on Log patient volume form
      Then Lab Profile page is opened
      And Volume 'volumeOne' is added to Volumes grid on Lab Profile page
    When I click on 'Add volume' on Lab Profile Page
      Then Log patient volume form is opened
    When I fill following fields on Log patient volume form and save as 'volumeTwo':
      | Time period combobox | random |
      | Time period radio    | q3     |
      | Disease              | random |
      | Biomarker            | random |
      | Volume               | 49     |
    And I click 'Log volume' on Log patient volume form
      Then Message 'Your volume has been added for disease "%s" and biomarker "%s"' for 'volumeTwo' is displayed on Log patient volume form
    When I click 'Done' on Log patient volume form
      Then Lab Profile page is opened
      And Volume 'volumeTwo' is added to Volumes grid on Lab Profile page
    When I sort data by alphabet in 'Time period' column on 'Volumes' Grid
      Then Data in 'Time period' column on 'Volumes' Grid sorted according to alphabet
    When I sort data by alphabet in 'Disease' column on 'Volumes' Grid
      Then Data in 'Disease' column on 'Volumes' Grid sorted according to alphabet
    When I sort data by alphabet in 'Biomarker' column on 'Volumes' Grid
      Then Data in 'Biomarker' column on 'Volumes' Grid sorted according to alphabet
    When I sort data by alphabet in 'Volume' column on 'Volumes' Grid
      Then Data in 'Volume' column on 'Volumes' Grid sorted according to alphabet

  @AssayManagement @VolumeManagement
  Scenario: DIAFE:0036 Data validation in Volume field with values <50
    When I click on 'Add volume' on Lab Profile Page
    Then Log patient volume form is opened
    When I fill following fields on Log patient volume form and save as 'volume':
      | Time period combobox | random |
      | Time period radio    | q4     |
      | Disease              | random |
      | Biomarker            | random |
    And I set random value from 1 to 49 for field 'Volume' on Log patient volume form and save for 'volume'
    And I click 'Log volume' on Log patient volume form
      Then Message 'Your volume has been added for disease "%s" and biomarker "%s"' for 'volume' is displayed on Log patient volume form
    When I click 'Done' on Log patient volume form
      Then Lab Profile page is opened
      And Volume 'volume' is added to Volumes grid on Lab Profile page
      And Value '<50' for Volume 'volume' is displayed in 'Volume' column in 'Volumes' Grid on Lab Profile page

  @AssayManagement @VolumeManagement
  Scenario: DIAFE:0037 Data validation in Volume field with values >50
    When I click on 'Add volume' on Lab Profile Page
      Then Log patient volume form is opened
    When I fill following fields on Log patient volume form and save as 'volume':
      | Time period combobox | random |
      | Time period radio    | q4     |
      | Disease              | random |
      | Biomarker            | random |
    And I set random value from 50 to 100 for field 'Volume' on Log patient volume form and save for 'volume'
    And I click 'Log volume' on Log patient volume form
      Then Message 'Your volume has been added for disease "%s" and biomarker "%s"' for 'volume' is displayed on Log patient volume form
    When I click 'Done' on Log patient volume form
      Then Lab Profile page is opened
      And Volume 'volume' is added to Volumes grid on Lab Profile page
      And Value from Volume 'volume' is displayed in 'Volume' column in 'Volumes' Grid on Lab Profile page