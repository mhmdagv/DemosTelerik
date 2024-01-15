Feature: Mountain bike
  Background:
    When Click to login button
    And Clicks bike category
    And Clicks mountain bike category

    @mountainbike
  Scenario Outline: Check model filter for "<Model>"
    Given User want to "see mountain 100 bikes"
    When Clicks "model" filter checkbox
    Then User should see bikes according to "<Model>" filter
      Examples:
        | Model                                  |  |
        | mountain-100                           |  |
        | mountain-100&mountain&300              |  |
        | mountain-100&mountain-200&mountain-300 |  |
        |                                        |  |
        |                                        |  |


  Scenario Outline: Check size filter ("<size>")
    Given User want to "see mountain 100 bikes"
    When Clicks "size" filter checkbox
    Then User should see bikes according to "<size>" filter
    Examples:
      | size |  |
      | 38   |  |
      | 40   |  |
      | 42   |  |
      |      |  |

  @salam
  Scenario Outline: Filter items by price ("<from>" - "<to>" interval)
    Given User want to "filter items by price"
    When User choose price interval from "<from>" "<to>"
    Then Items should be list according to "<from>" "<to>"
    Examples:
      | from  | to    |  |
      | 0     | 500   |  |
      | 500   | 1,000 |  |
      | 1,000 | 1,500 |  |
      | 1,500 | 2,000 |  |
      | 2,000 | 2,500 |  |
      | 2,500 | 3,000 |  |
      | 3,500 | 4,000 |  |
      | 0     | 1     |  |


    @fastfingers
    Scenario: Automate the 10 fast fingers
      Given User is in fast fingers page
      When Clicks allow all button
      And Fill the input field with highlited texts



Scenario: Mountain Bikes
