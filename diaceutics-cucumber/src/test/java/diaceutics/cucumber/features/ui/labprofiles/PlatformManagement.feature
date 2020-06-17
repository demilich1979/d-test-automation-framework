Feature: Platform Management

  Background:
    Given Labs page is opened
    When I select 'Albania' country on Labs page
    Then Filters Labs page is opened

    When I select 'Test lab' lab on Filters Labs page
    Then LabProfile page is opened

  @lab
  Scenario: DIAFE:0009 Possibility to add a platform to the existing lab
    When I click on Add Platform on Lab Profile Page
    Then Add Platform form is opened

    When I fill following fields on Add Platform Form and save as 'newPlatform':
      | Platform manufacturer | random |
      | Platform              | random |

  @NotAutomated
  Scenario: DIAFE:0010 Platform duplication impossibility
    When I click on Add Platform on Lab Profile Page
    Then Add Platform form is opened
    And Field 'Platform' does not contains value from 'newPlatform'

  @NotAutomated
  Scenario: DIAFE:0011 Possibility to sort platforms
    When I click on Add Platform on Lab Profile Page
    Then Add Platform form is opened
    And I fill following fields on Add Platform Form and save as 'newPlatformOne':
      | Platform manufacturer | random |
      | Platform              | random |

    When I click on Add Platform on Lab Profile Page
    Then Add Platform form is opened
    And I fill following fields on Add Platform Form and save as 'newPlatformTwo':
      | Platform manufacturer | random |
      | Platform              | random |

    When I sort data by alphabet in Platform manufactured column in Platforms table on Lab Profile Page
    Then Data in Platform manufactured column on Platforms table on Lab Profile Page sorted according to alphabet

  @NotAutomated
  Scenario: DIAFE:0012 Possibility to edit platforms