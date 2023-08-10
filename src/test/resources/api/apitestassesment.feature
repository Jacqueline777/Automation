Feature:  API TESTS

  @createnewemployee @runapi
  Scenario: Verify  post requests endpoint is workuping
    Given I access the endpoint
    When I send the request
    Then I should be able to get status code of 200 from create employee post request with 33234 "Jacqueldcdcine" "jsssscxddcdcdcda@c.m" "Engdcdcineer"


  @getemployees @runapi
  Scenario: Verify  get requests endpoint is working
    Given I access the endpoint
    When I send the request
    Then I should be able to get status code of 200 from get employee get request


  @getspecificemployee @runapi
  Scenario: Verify  get requests endpoint is working
    Given I access the endpoint
    When I send the request
    Then I should be able to get status code of 200 from get employee number 33234

#    add more