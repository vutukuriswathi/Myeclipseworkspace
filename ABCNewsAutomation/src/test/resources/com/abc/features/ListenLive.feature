Feature: Playing audio from Listen Live

Scenario: Playing audio from listen live menu

Given I have opened the app
When I tap on listen live menu item
When I tap on the first item
Then I should be presented with a summary page
Then when I tap on Listen to station
Then a player should appear on the page and an audio stream should start
 

 