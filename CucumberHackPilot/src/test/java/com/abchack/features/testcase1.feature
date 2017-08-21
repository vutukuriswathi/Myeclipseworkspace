Feature:w3cLinkCheker validation for channel page

Scenario Outline:Testcase1
Given Launch the w3cLinkChecker
When entered "<corresponding>" page url
Then validator validates "<corresponding>" page errors

Examples:
|corresponding|
|channel|

