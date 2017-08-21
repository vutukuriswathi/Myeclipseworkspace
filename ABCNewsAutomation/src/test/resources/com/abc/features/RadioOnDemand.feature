Feature: Playing audio from Radio on Demand

Scenario:Playing audio from radio on demand

Given I have opened the app
And click on radio on demand menu item
When I tap the first item
Then I should be presented with a ondemand summary page
Then when I tap on listen to program
Then a player should appear on the page and an audio stream should start for radi on demand
 
