@clothes
Feature: Jerseys Clothes
  Background:
    When Click to login button
    And Clicks clothes category
    And Clicks jerseys clothes category

@modelclothes
  Scenario Outline: Check model filter for -"<Model>"
    When Clicks "<Model>" "model" filter checkbox
    Then User should see clothes according to "<Model>" filter
    Examples:
      | Model                       |
      | Long-Sleeve Logo Jersey     |
      | Short-Sleeve Classic Jersey |
@sizeClothes
  Scenario Outline: Check size filter ("<size>")
    Given User is in "e.shop" website
    When Clicks "<size>" "size" filter checkbox
    Then User should see clothes according to "<size>" filter
    Examples:
      | size |
      | s    |
      | m    |
      | l    |
      | xl   |
      | s&m  |
      | l&xl |
    @colorClothes
  Scenario Outline: Check color filter "<color>"
    Given User is in "e.shop" website
    When Clicks "<Color>" "color" filter checkbox
    Then User should see clothes according to "<Color>" "<Text>" filters
    Examples:
      | Color  | Text                        |
      | Multi  | Long-Sleeve Logo Jersey     |
      | Yellow | Short-Sleeve Classic Jersey |

  @ratingClothes
  Scenario Outline: Check rating stars radio button
    Given  User is in "e.shop" website
    And  User Clicks "<Rating>" radio button
    Then user should see "<Rating>" stars clothes on the page
    Examples:
      | Rating |
      | 5      |
      | 4      |
      | 3      |
      | 2      |
      | 1      |


  @priceClothes
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

