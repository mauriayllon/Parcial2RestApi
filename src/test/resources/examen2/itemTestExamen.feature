Feature: Item

  @Item
  Scenario: As admin user I want to create, update and delete a item
  So that i am able to answer the test exercise.

    #POST
    Given I have access to Todo.ly
    When I send a request POST to url https://todo.ly/api/items.json with json
    """
    {
      "Content":"EXTERNAL FILE"
    }
    """
    Then I expected response code 200
    And I get the property Id save on ID_ITEM
    And I expected the response body
    """
   {
   "Id":ID_ITEM,"Content":"EXTERNAL FILE","ItemType":1,"Checked":false,
   "ProjectId":null,"ParentId":null,"Path":"",
   "Collapsed":false,"DateString":null,"DateStringPriority":0,"DueDate":"","Recurrence":null,"ItemOrder":null,
   "Priority":4,"LastSyncedDateTime":"IGNORE","Children":[],"DueDateTime":null,"CreatedDate":"IGNORE",
   "LastCheckedDate":null,"LastUpdatedDate":"IGNORE","Deleted":false,"Notes":"","InHistory":false,
   "SyncClientCreationId":null,"DueTimeSpecified":true,"OwnerId":676933}
    """

    #PUT
    When I send a request PUT to url https://todo.ly/api/items/ID_ITEM.json with json
    """
    {
      "Content":"NOMBRE_ITEM"
    }
    """
    Then I expected response code 200
    And I expected the response body

    """
    {"Id":ID_ITEM,"Content":"NOMBRE_ITEM","ItemType":1,"Checked":false,"ProjectId":null,"ParentId":null,"Path":"",
    "Collapsed":false,"DateString":null,"DateStringPriority":0,"DueDate":"","Recurrence":null,"ItemOrder":null,
    "Priority":4,"LastSyncedDateTime":"IGNORE","Children":[],"DueDateTime":null,"CreatedDate":"IGNORE",
    "LastCheckedDate":null,"LastUpdatedDate":"IGNORE","Deleted":false,"Notes":"","InHistory":false,
    "SyncClientCreationId":null,"DueTimeSpecified":true,"OwnerId":676933}
    """

    #DELETE
    When I send a request DELETE to url https://todo.ly/api/items/ID_ITEM.json with json
    """
    """
    Then I expected response code 200
    And I expected the response body
    """
     {"Id":ID_ITEM,"Content":"NOMBRE_ITEM","ItemType":1,"Checked":false,"ProjectId":null,"ParentId":null,
     "Path":"","Collapsed":false,"DateString":null,"DateStringPriority":0,"DueDate":"","Recurrence":null,
     "ItemOrder":null,"Priority":4,"LastSyncedDateTime":"IGNORE","Children":[],"DueDateTime":null,
     "CreatedDate":"IGNORE","LastCheckedDate":null,"LastUpdatedDate":"IGNORE","Deleted":true,"Notes":"",
     "InHistory":false,"SyncClientCreationId":null,"DueTimeSpecified":true,"OwnerId":676933}
    """
