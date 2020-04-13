Feature: User page web elements test

  Scenario: User Table Page logs test
    Given I am on Index page
    And  I login as username: 'Roman' pass: 'Jdi1234'
    And I go through the header menu Service -> User Table
    When I select 'vip' checkbox for 'Sergey Ivan'
    Then 1 log row has 'Vip: condition changed to true' text in log section