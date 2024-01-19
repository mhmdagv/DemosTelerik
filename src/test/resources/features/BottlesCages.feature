#Feature: BottlesCages
#  Background:
#    When Click to login button
#    And Move to Categories button
#    And Click to Accessories button
#    When Click to BottlesCages button
#
#
#Scenario: Check Discounted items only radio button
#  Given User is in "BottlesCages" page
#  And Click to Discounted items only radio button
#  Then User should see discounted items on the page
#
#
#
#Scenario Outline: Check ("<Model>") filter
#  Given User is in "BottlesCages" page
#  When Click to "<Model>" button
#  Then User should see "<Model>" on the page
#  Examples:
#    | Model                                             |
#    | Mountain Bottle Cage                              |
#    | Road Bottle Cage                                  |
#    | Water Bottle                                      |
#    | Mountain Bottle Cage&Road Bottle Cag              |
#    | Mountain Bottle Cage&Road Bottle Cag&Water Bottle |
#    | Water Bottle&Road Bottle Cage                     |
#
#
#
#  Scenario Outline: Check ("<Rating>") star filter
#    Given User is in "BottlesCages" page
#    When Click "<Rating>" button
#    Then Users should see "<RatingText>" on the page
#    Examples:
#      | Rating    | RatingText |
#      | 5         |            |
#      | 4         |            |
#      | 3         | 3/5        |
#      | 2         |            |
#      | 1         |            |
#      | 5&4&3&2&1 | 3/5        |
#
#
#
#
#Scenario: Click to Mountain Bottle Cage and 3 star checkbox
#  Given User is in "BottlesCages" page
#  When Click Mountain Bottle Cage checkbox
#  And Click three star checkbox
#  Then User should see Mountain Bottle Cage item on the page
#
#
#
#Scenario Outline: Check price filter ("<from>") ("<to>")
#  Given User is in "BottlesCages" page
#  When User choose price interval "<from>" "<to>"
#  Then Items should be list according to "<from>" "<to>"
#  Examples:
#    | from  | to    |
#    | 0     | 500   |
#    | 500   | 1,000 |
#    | 1,000 | 1,500 |
#    | 1,500 | 2,000 |
#    | 2,000 | 2,500 |
#    | 2,500 | 3,000 |
#    | 3,000 | 3,500 |
#    | 3,500 | 4,000 |
#


