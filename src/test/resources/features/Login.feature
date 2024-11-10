Feature: Swag lab login

  @Login
  Scenario Outline: Login to Swag lab
    Given User creates a Screenshot folder from "<SheetName>" with "<TestCaseId>"
    Given user launch the swag lab
    And user enter the credential details
    And user update the excel sheet
    Examples:
      | TestCaseId | SheetName |  |
      | Scenario1  | FIRST     |  |
#      | Scenario2  | FIRST     |  |