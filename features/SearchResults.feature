Feature: Search Results. Where one can sort, filter and see details of resulting products.

@001
Scenario: Search and Sort results
Given I am a non-registered customer
And I navigate to 'http://www.ebay.co.uk'
When I search for an item: 'iphone'
Then I get a list of matching results 
And I can sort the results by 'Lowest price' 
#And I can sort the item by Lowest Price + P&P
#And I can sort the item by Lowest Price + P&P
#And I can sort the item by Highest Price 
#And I can sort the item by Lowest Price
#And I can sort the item by Newly Listed
#And I can sort the item by Ending Soonest
#And I can sort the item by Nearest First

@002
Scenario: Search and Filter results
Given I am a non-registered customer 
And I navigate to www.ebay.co.uk
When I search for an item
Then I get a list of matching results
And I can filter the results by All Items, Auction, By it now

@003
Scenario: Search and Verify Results Item Cards details shown
Given I am a non-registered customer 
And I navigate to 'http://www.ebay.co.uk'
When I search for an item: 'xbox'
Then I get a list of matching results
And the resulting items cards have: postage price, No of bids, price or show BuyItNow tag

@004
Scenario: Search a specific category
Given I am a non-registered customer
And I navigate to 'http://www.ebay.co.uk'
When I search for an item: 'iphone'
And I select a specific category on which to search
Then the search results combination match the item+category correctly

@005
Scenario: Verify navigation through search results pages
Given A non-registered user searches for an item
And the results show more than one page
Then the user can navigate through the pages to continue looking at the items
