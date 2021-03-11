Feature: Token

  @Token
  Scenario: As admin user I want to get and delete the token
  So that i am able to answer the test exercise.

    #POST
    Given I have access to Todo.ly
    When I send a request GET to url https://todo.ly/api/authentication/token.json with json
    """
    """
    Then I expected response code 200
    And I get the property TokenString save on ID_TOKEN
    And I expected the response body
    """
    {"TokenString":ID_TOKEN,"UserEmail":"mauri@mauri.com","ExpirationTime":"IGNORE"}
    """
    #DELETE
    When I send a request DELETE to url https://todo.ly/api/authentication/token.json with json
    """
    """
    Then I expected response code 200