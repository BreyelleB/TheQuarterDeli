The QuarterDeli Sandwich shop is a JAVA application for a custom sandwich shop. 
This project allows users to build custom sandwiches, add drinks and chips, review their order and generate a receipt. 
The name is inspired by my home town New orleans, Louisiana's popular tourist attraction "The French Quarter".

Features include
- Interactiver menu-driven CLI interface
- Custom sandwich buider with multiple options
- Drink and chips conformations
- Order summary and confirmation
- Receipt generation with timestamped or cumulative file storage

 Interesting Piece of code: Enums for Clean, Safe Option management
 It has extensive use of JAVA enums to model fixed sets of options for sandwich combos, and ordering which includes
  - SandwichSize - Defines sandwich sizes (FOUR, EIGHT, TWELVE inches)
  - BreadType - Predefined bread options (WHITE, WHEAT,RYE,WRAP,FRENCH)
  - DrinkSize - Drink sizes (SMALL, MEDIUM, LARGE)

  - Using the enums helps improve my code readability, it enforces valid choices at compile time, and simplifies input validatiion
  - when users build their sandwich or select drink sizes.

Project Structure
- com.pluralsight.models - these are data classes for sandwich, order, drink, chips, ennums, etc.
- com.pluralsight.ui - user interface and menu handling
- com.pluralsight.util - utilities such as receipt saving

Future improvements 
- Adding more customization options, code currently in the app follows the basic instructions structure
- improve input validation and error handling
- Work on inhanced user experience
- Better receipt print out system
- more git branching 
