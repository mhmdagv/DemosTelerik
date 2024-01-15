
Feature: Components
  @Components
  Background:
    When Click to login button
    And Clicks categories
    And Clicks components

@Chain
    Scenario: : Chain
      Given Click Chain
      When Refresh The Page
      Then The page must me Chain


