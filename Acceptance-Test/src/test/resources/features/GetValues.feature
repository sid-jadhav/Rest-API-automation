Feature: Get values Happy path Scenario

Scenario: A successful Get value request
Given A request for "Getvalue" 
When "GetValue" is called
Then response feild "id" is "2"
And response feild "title" is "King of King"
And response feild "author" is "Siddhesh"