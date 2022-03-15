@web
Feature: Google LogIn
  Background:
    Given open Browser
    And User navigate to the Google page
    Then Accept the cookies

  Scenario: Login by G-mail Account
      Given I click the Accedi button in Google page
      Then I should see the Google Accedi page
      When I enter the vaild Mail Id
      And I enter the vaild password
      Then I should see the mail Avatar in google page

  Scenario: print links by search bar
        Given I type in searchbar
        Then I have to print all the links

