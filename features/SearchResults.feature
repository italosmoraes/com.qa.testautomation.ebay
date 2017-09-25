Feature: Search Results. Where one can sort, filter and see details of resulting products.

@001
Scenario: Search and Sort results
#Given I am a non-registered customer
And I navigate to 'http://www.ebay.co.uk'
When I search for an item
Then I get a list of matching results 
And I can sort the item by Best Match, Lowest Price + P&P, Highest Price, Newly listed, etc

@002
Scenario: Search and Filter results
Given I am a non-registered customer 
And I navigate to www.ebay.co.uk
When I search for an item
Then I get a list of matching results
And I can filter the results by All Items, Auction, By it now
And the resulting items cards have: postage price, No of bids, price or show BuyItNow tag

@003
Scenario: Search a specific category
Given A non-registered user searches for an item 
And selects a specific category on which to search
Then the search results combination match the item+category correctly

@004
Scenario: Verify navigation through search results pages
Given A non-registered user searches for an item
And the results show more than one page
Then the user can navigate through the pages to continue looking at the items
