# Incident feature review the behavior in this feature
Feature: Incident

  Scenario: IN-02 Verify that an incident is removed
    Given 'SSI Application' page is loaded
    And set Admin credentials on 'Login' page
    When click on 'Accidente e Incidente' menu on 'navigationBar' page
    And click on 'Incident' submenu on 'Accidente e Incidente' menu
    And delete incident from position 1
    And click on 'Accidente e Incidente' menu on 'navigationBar' page
    And click on 'Incident' submenu on 'Accidente e Incidente' menu
    Then verify that one incident was removed in the list