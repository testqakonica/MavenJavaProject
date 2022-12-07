@Gmail 
Feature: Gmail Login funtionality 

@G001 @Regression 
Scenario Outline: Login with valid username and password 
	Given User is on "GmailLogin" screen 
	When User enters "<Username>" in "EmailID" field in "SignIn" screen 
	Then User clicks on "Next" button in "SignIn" screen 
	When User enters "<Password>" in "Password" field in "Welcome" screen 
	Then User clicks on "Next" button in "Welcome" screen 
	And User verifies "UserProfileIcon" is displayed 
	
	Examples: 
		| Username              | Password    | 
		| testqakonica@gmail.com| 9095758930  |
		
		@G002 @Regression 
		Scenario Outline: Login with invalid username and password 
			Given User is on "GmailLogin" screen 
			When User enters "<Username>" in "EmailID" field in "SignIn" screen 
			Then User clicks on "Next" button in "SignIn" screen 
			And User verifies "<msg>" is displayed 
			
			Examples: 
				| Username               | Password    | msg 							   |
				| testqakonica1@gmail.com| 9095758930  | Couldn’t find your Google Account |
				
				@G003 @Regression 
				Scenario Outline: Login with valid username and invalid password 
					Given User is on "GmailLogin" screen 
					When User enters "<Username>" in "EmailID" field in "SignIn" screen 
					Then User clicks on "Next" button in "SignIn" screen 
					When User enters "<Password>" in "Password" field in "Welcome" screen 
					Then User clicks on "Next" button in "Welcome" screen 
					And User verifies "<msg>" is displayed 
					
					Examples: 
						| Username              | Password    | msg                  											| 
						| testqakonica@gmail.com| 909575      | Wrong password. Try again or click Forgot password to reset it. |