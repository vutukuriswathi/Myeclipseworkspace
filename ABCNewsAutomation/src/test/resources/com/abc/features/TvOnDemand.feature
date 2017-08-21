Feature: Playing vide from tv on demand

Scenario: playing video from tv on demand

Given I have opened the app
When I click on tv on demand menu item
When I tap the first video on tv on demand
Then I should be presented with a summary page related to tv on demand category
Then tap watch program
Then the video stream should start related to tv on demand category

