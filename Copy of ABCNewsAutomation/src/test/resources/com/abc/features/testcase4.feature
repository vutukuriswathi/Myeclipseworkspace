Feature: Opening weather and seeing weather for today and tomorrow

Scenario: Opening weather and seeing weather for today and tomorrow
 
Given I have opened the app
When I tap on the weather icon in the top right
Then I should see weather for a location for today and tomorrow

