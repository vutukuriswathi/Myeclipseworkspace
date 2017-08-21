Feature: Playing video from now on tv

Scenario: Playing video from Now on TV

Given I have opened the app
And click on now on tv menu item
When I tap watch now
Then I should be presented with a tv summary page
And when I tap watch program
Then a video stream should start
