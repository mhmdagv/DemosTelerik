Feature: Mountain bike
  Background:
    When Click to login button
    And Clicks bike category
    And Clicks mountain bike category

    @mountainbike
    Scenario Outline: Check model filter for "<Model>"
    Given User is in "e.shop" website
    When Clicks "<Model>" "model" filter checkbox
    Then User should see bikes according to "<Model>" filter
      Examples:
        | Model                     |  |
        | mountain-100              |  |
        | mountain-200              |  |
        | mountain-300              |  |
        | mountain-400-W            |  |
        | mountain-500              |  |
        | mountain-200&mountain-300 |  |

@sizeBike
  Scenario Outline: Check size filter ("<size>")
    Given User is in "e.shop" website
    When Clicks "<size>" "size" filter checkbox
    Then User should see bikes according to "<size>" filter
    Examples:
      | size |  |
      | 38   |  |
      | 40   |  |
      | 42   |  |
      | 44    |  |
@colorBike
  Scenario Outline: Check model filter for "<Color>"
    Given User is in "e.shop" website
    When Clicks "<Color>" "color" filter checkbox
    Then User should see bikes according to "<Color>" filter
    Examples:
      | Color  |
      | black  |
      | silver |
  Scenario Outline: Check model filter for "<Rating>"
    Given User is in "e.shop" website
    When Clicks "<Rating>" checkbox for rating
    Then User should see bikes according to "<Rating" filters
    Examples:
      | Rating |
      | 5      |
      | 4      |
      | 3      |
      | 2      |
      | 1      |

  @priceBike
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




