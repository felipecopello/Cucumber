
Feature: Ebay Homepage Scenarios
As a customer i should be able to interact with the home page elements and obtain desired result,
login, logout, search, etc..

@P1
Scenario: As a customer i can click the advanced search button and navigate to advanced 
search page
Given I am on the Ebay Homepage
When I click the advanced search button
Then I should be taken to advanced search page

@P3
Scenario: As a customer i can input a search and find at least 1000 results
Given I am on the Ebay Homepage
#uso de parametros
When I input the search parameters 'Iphone 11'
And I click the search button
Then I should see at least 1000 results

@P4
Scenario: As a customer i can search an item specifying a particular category
Given I am on the Ebay Homepage
When I input the search parameters 'Iphone 11'
And I select 'Celulares y accesorios' category
And I click the search button
Then I should see at least 1000 results
 