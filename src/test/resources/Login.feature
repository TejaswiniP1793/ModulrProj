Feature: Login page feature

Background:
Given user is on login page

		
Scenario Outline: Login with empty username or password
When user enters the "<username>" and "<password>"
And user clicks on login button
Then The "<message>" should be displayed

Examples:
		|username|password|message|
    ||DummyPass123| This field is required |
    |DummyUsername123|| This field is required |
    ||| This field is required |
    
 
Scenario Outline: Login with correct credentials
When user enters the "<username>" and "<password>"
And user clicks on login button
Then Signin button should be disabled
And user should be on the accounts overview page
Examples:
		|username|password|
		|Tejaswini.pulluri17|Mypassword123456|
@Run		
Scenario Outline: Login with incorrect credentials
When user enters the "<username>" and "<password>"
And user clicks on login button
Then The "<message>" and "Multiple incorrect sign-ins could result in your access being locked. If this does happen, you'll receive an email explaining how to reset your access." should be displayed

Examples:
		|username|password|message|
		|Tejaswini.pulluri17|DummyPass123|The username or password is incorrect.|
		
Scenario: Reset password 
When user clicks on forgot password link
Then user should be on the reset password page
    
