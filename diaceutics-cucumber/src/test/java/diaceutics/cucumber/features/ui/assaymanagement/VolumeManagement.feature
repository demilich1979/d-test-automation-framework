Feature: Volume Management

  Background:
    Given Labs page is opened
    When I select 'Albania' country on Labs page
      Then Filters page is opened
    When I select 'Test lab' lab on Filters Labs page
      Then Lab Profile page is opened

  @VolumeManagement
  Scenario: DIAFE:0026 Possibility to add a volume to the existing lab
    When I click on 'Add volume' on Lab Profile Page
      Then Log patient volume form is opened
    When I fill following fields on Log patient volume form and save as 'volume':
      | Time period combobox | random |
      | Time period radio    | q2     |
      | Disease              | random |
      | Biomarker            | random |
      | Volume               | 5      |
    And I click Log volume on Log patient volume form
      Then Message 'Your volume has been added for disease "%s" and biomarker "%s"' for 'volume' is displayed on Log patient volume form
    When I click Done on Log patient volume form
      Then Lab Profile page is opened
      And Volume 'volume' is added to Volumes grid on Lab Profile page

  @VolumeManagement
  Scenario: DIAFE:0027 Platform duplication impossibility
    When I click on 'Add volume' on Lab Profile Page
      Then Log patient volume form is opened
    When I fill following fields on Log patient volume form using data from 'volume':
      | Time period combobox |
      | Time period radio    |
      | Disease              |
      | Biomarker            |
      | Volume               |
    And I click Log volume on Log patient volume form
      Then Message 'A volume already exists for this criteria and time period.' is displayed on Log patient volume form