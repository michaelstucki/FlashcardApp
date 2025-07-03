This OOP Lab D program implements a simple flashcard application.
User can:
1. View all cards on record
2. Add a new card
3. View a card
4. Delete a card
5. Quit

It is designed as an Model-View-Controller (MVC).
It codes to interfaces to provide loose coupling between each layer.
The View layer interacts with the user through the console.
The Model layer interacts with the data (cards).
The Controller orchestrates the actions of the View and Model layers.

TODO:
1. Add persistence so that the cards edited during runtime are retained after running the app.
2. Add flashcard drills that keeps track of cards missed and re-drills them until all cards are correct.
3. Add ability to create and delete different card decks each persisted in a distinct file.
4. Add spaced repetition.
