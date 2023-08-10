Feature:  API TESTS

  @TestRail(217770) @checkout
  Scenario: Verify  checkout requests endpoint is workuping
    Given I access the endpoint "https://run.mocky.io/v3/"
    When I send the request
    Then I should be able to get status code of 2001
    And my body should have the right response body
#    Examples:


  @TestRail(217770) @checkout
  Scenario: Verify checkout requests endpoint is workuping
    Given I access the endpoint "https://run.mocky.io/v3/"
    When I send the request
    Then I should be able to get status code of 2001
    And my body should have the right response body
#   Examples:


  @TestRail(217770) @checkout
  Scenario: Verify checkout requests endpoint is workuping
    Given I access the endpoint "https://run.mocky.io/v3/"
    When I send the request
    Then I should be able to get status code of 2001
    And my body should have the right response body
#   Examples:
