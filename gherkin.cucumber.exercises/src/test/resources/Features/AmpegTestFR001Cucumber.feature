Feature: Feature to test artist endorsements on products

  Scenario Outline: Clicking products shows all the artists who endorse it
    Given user is on home page
    When user clicks products Tab
    And clicks on particular product
    Then user sees products from different brands and artists who endorse it
