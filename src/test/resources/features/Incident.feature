# Incident feature review the behavior in this feature
Feature: Incident

  Scenario: IN-02 Verify that an incident is removed
    Given 'SSI Application' page is loaded
    And set Admin credentials on 'Login' page
    When click on 'incident' menu on 'navigationBar' page
    And delete incident from position 1
    And click on 'incident' menu on 'navigationBar' page
    Then verify that one incident was removed 1 in the list
