# Movie Watchlist
### Created by the Watchlist Warriors
#### Trevor Slobodnick, Zachary Allard, Jenny Hoang
## Overview
This program is a watchlist that you can use to keep track of all your favorite movies.

![Watchlist logo](/images/watchlist.png)

## Usage

### Prerequisites
This project requires OpenJDK 15 with libraries containing JavaFX SDK version 15 and JDBC version 8.0.22

### Using the software

To start, clone the repo and run the Main method. A JavaFX window for the application will pop up. If it is your first time using the program, you will be greeted by the following login screen:

![Login image](/images/wl_login.png)

Enter the login details for your database. Upon sucessfully connecting to the database, you will be directed to the menu. From there, you can go back to the login screen and click the "Create Tables" button to set up the tables in the database you specified.

![Menu image](/images/wl_menu.png)

The stucture for the database is as follows:

#### watchlist Table
##### Contains the info about the movies you are tracking
* id - The ID of a movie
* title - The title of a movie
* year - The year the movie was release
* genre - A foreign key linking to the genre ID
* production_company - A foreign key linking to the production company ID

#### genres Table
##### Defines the genres that you can select when adding a movie
* id - The ID of the genre
* name - The name of the genre

#### production_companies Table
##### Defines the production companies you can select when adding a movie
* id - The ID of the production company
* name - The name of the production company

Now that you have the tables set up correctly, you will be able to start using the watchlist. To begin, click the "VIEW YOUR WATCHLIST >" button. From there, you can add a new movie by clicking the "+ New Movie" button. Enter the movie details, and then add the movie.

![Form image](/images/wl_form.png)

After adding a few movies, your watchlist should look something like this:

![Watchlist image](/images/wl_watchlist.png)

You can click the movie to see details about it or delete it from your watchlist. Any changes will be updated automatically.

From the menu, you will also be able to access the stats and credits. The credits will show you info about us, the Watchlist Warriors. The stats page, on the other hand will take info from your list of movies and determine which genre is most common. Using this, you can more concretely define what your favorite genres are.

![Stats image](/images/wl_stats.png)
