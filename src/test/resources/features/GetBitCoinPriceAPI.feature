@API @BitcoinPriceAPI
Feature:Validate Bitcoin price API

  Scenario:Check Bitcoin price Index details
    Given Given The Bitcoin price API is configured and ready for requests
    When  GET request is sent to the Bitcoin price endpoint
    Then The response should have the BPI
      |USD|
      |GBP|
      |EUR|
    And The "GBP" description equals "British Pound Sterling"
