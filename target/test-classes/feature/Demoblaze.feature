#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

@DemoBlaze
Feature: Testing Demoblaze web application

  Background: Openening web application of Demoblaze
    Given User should be on url "https://www.demoblaze.com/"

  @Signup
  Scenario: Checking functionality of Singup
    When User click on signup button
    And Enter username as "himanshulunagariya"
    And Enter password as "ubfsiuzlasubv"
    And Cick on Sign up button
    Then Alert should display as "signup is successfully."
    And Click on Ok button on alert

  @ProductPage
  Scenario: Checking functionality of ADD TO CART
    When User click on Login button
    And Enter Login username as "himanshulunagariya"
    And Enter Login password as "ubfsiuzlasubv"
    And Click on Login button
    And Click on Laptops option
    And Click on any Laptop name
    Then It should open new page with image of laptop and ADD TO CART button

  @Cart
  Scenario: Checking functionality of cart
    When User clicks on Laptops option
    And Click on any Laptop name from options
    And Clicks ADD TO CART
    And Click on OK in alert
    And Go to cart page
    Then Cart should have that products added in it
