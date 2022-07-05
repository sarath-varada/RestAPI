Feature: Validating Syncplicity APIs

@Usercreation @Regression
Scenario Outline: Create a User in syncplicity
Given user details payload with username "<username>"
When "CreateUserAPI" call we use "POST" http method to create a syncpoints
Then extract the username and validate the same
Then validate the status code as "200"

Examples:
|username                   |
|totalnewcompany237@dispostable.com|
#|newsarath1345@dispostable.com|





@createSyncpoint @Regression
Scenario Outline: Add a syncpoint into OFB
Given Add syncpoint payload with basic authentication with different syncpoint names "<Name>" "<Type>"
When "CreateSyncpointAPI" call we use "POST" http method to create a syncpoints
Then validate the status code as "200"
And validate the response body for the syncpointId


Examples:
|Name              |Type|
|MySyncpoint       | 8  |
#|RESTAPIREST      | 8  | 