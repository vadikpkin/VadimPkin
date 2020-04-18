Feature: Different Elements page web elements page test

  Scenario: Entering Different Elements page a and interacting with elements
    Given I am on Index page
    And I login as username: 'Roman' pass: 'Jdi1234'
    And I go through the header menu Service -> Different Elements Page
    When I select checkboxes
      | Checkboxes |
      | Water      |
      | Wind       |
    And  I select radio 'Selen'
    And  I select dropdown 'Yellow'
    Then For each checkbox there is an individual log row and value is corresponded to the status of checkbox
      | Checkboxes |
      | Water      |
      | Wind       |
    And For radio button 'Selen' there is a log row and value is corresponded to the status of radio button
    And For dropdown value 'Yellow' there is a log row and value is corresponded to the selected value