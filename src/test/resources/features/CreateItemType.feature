Feature: CreateItemType

  Scenario: AA-01 Verify that an item type can be created with required fields
    Given 'SSI' page is loaded
    And User is authenticated
    And I click on "Activos" menu button
    And I click on "Aniadir tipo de Item" Button
    And I type an item name in "Item Type Name" field
    When I click on "Save" button to save the Item type
    Then The Item should be added