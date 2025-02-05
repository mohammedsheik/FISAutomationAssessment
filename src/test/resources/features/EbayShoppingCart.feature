@eBayShoppingCart
Feature:Validate eBay Checkout process

  Background:
    Given The user navigates to "eBay" Home Page

  Scenario:Check Cart is updated when Items are added
    When The user searches for a Book
    And The user adds the first book to the cart
    Then The cart should reflect the updated number of items