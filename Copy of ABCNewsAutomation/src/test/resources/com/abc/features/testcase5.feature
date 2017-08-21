Feature: Opening weather and changing location

Scenario: Opening weather and changing location

Given I have opened the app
When I am in weather
When I tap on the change link
Then I will be presented with a search box to enter the location syd
And A list of suggested locations should appear after I type three characters
Then select a location sydney
Then I should be shown a screen with today and tomorrows weather
And It should be for the new location
 
