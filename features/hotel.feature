Feature: Offers

  Scenario: Logged in users should see special offers
  	Given I am logged in as Amy
	When I look at the offers
	Then I should see these