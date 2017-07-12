Feature: Verify Card Happy Path Scenarios

Scenario: A successful verify card request with dummy fields
Given a maximal json for "VerifyCardRequest"
And request field "requestId" is "2"
And request field "walletProviderId" is "King of King"
And request field "sessionId" is "Siddhesh"
When post "VerifyCard" is called 
Then response feild "requestId" is "2"
And response feild "walletProviderId" is "King of King"
And response feild "sessionId" is "Siddhesh"

 