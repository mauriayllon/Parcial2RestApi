Feature: User

  @User
  Scenario: As admin
  I want to create and update an user
  So that I use the API

    Given I have access to Todo.ly with email mauri2@mauri.com and password 123456
    When I send a request POST to url http://todo.ly/api/user.json with json
    """
    {
      "Email": "mauri2@mauri.com",
      "FullName": "Mauricio",
      "Password": "123456"
    }
    """
    Then I expected response code 200
    And I expected the response body
    """
    {
    "Id": "IGNORE",
    "Email": "mauri2@mauri.com",
    "Password": null,
    "FullName": "Mauricio",
    "TimeZone": 0,
    "IsProUser": false,
    "DefaultProjectId": "IGNORE",
    "AddItemMoreExpanded": false,
    "EditDueDateMoreExpanded": false,
    "ListSortType": 0,
    "FirstDayOfWeek": 0,
    "NewTaskDueDate": "IGNORE",
    "TimeZoneId": "IGNORE"
    }
    """
    And I get the property Id save on ID_USER
