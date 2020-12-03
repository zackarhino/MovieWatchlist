package Tables;

import DAO.MovieDAO;
import Database.Database;
import Movie.Movie;
import Util.Constants;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MovieTable implements MovieDAO {

    Database db = Database.getInstance();
    ArrayList<Movie> movies;

    @Override
    public ArrayList<Movie> getAllMovies() {
        String query = "SELECT * FROM " + Constants.TABLE_WATCHLIST;
        movies = new ArrayList<>();
        try{
            Statement getGenres = db.getConnection().createStatement();
            ResultSet data = getGenres.executeQuery(query);

            while(data.next()){
                movies.add(
                        new Movie(data.getInt(Constants.WATCHLIST_COLUMN_ID),
                                data.getString(Constants.WATCHLIST_COLUMN_TITLE),
                                data.getInt(Constants.WATCHLIST_COLUMN_YEAR),
                                data.getInt(Constants.WATCHLIST_COLUMN_GENRE),
                                data.getInt(Constants.WATCHLIST_COLUMN_PRODUCTION_COMPANY),
                                data.getString(Constants.WATCHLIST_COLUMN_GENRE),
                                data.getString(Constants.WATCHLIST_COLUMN_PRODUCTION_COMPANY)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movies;
    }

    @Override
    public Movie getMovie(int id) {
        String query = "SELECT * FROM " + Constants.TABLE_WATCHLIST+
                " WHERE " + Constants.WATCHLIST_COLUMN_ID + " = " + id;
        try{
            Statement getMovies =
                    db.getConnection().createStatement();
            ResultSet data = getMovies.executeQuery(query);
            if(data.next()){
                Movie movie =
                        new Movie(data.getInt(Constants.WATCHLIST_COLUMN_ID),
                                data.getString(Constants.WATCHLIST_COLUMN_TITLE),
                                data.getInt(Constants.WATCHLIST_COLUMN_YEAR),
                                data.getInt(Constants.WATCHLIST_COLUMN_GENRE),
                                data.getInt(Constants.WATCHLIST_COLUMN_PRODUCTION_COMPANY),
                                data.getString(Constants.WATCHLIST_COLUMN_GENRE),
                                data.getString(Constants.WATCHLIST_COLUMN_PRODUCTION_COMPANY));
                return movie;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getMovieCount(int movie) {
        int count = -1;
        try {
            PreparedStatement getCount = db.getConnection()
                    .prepareStatement("SELECT * FROM " + Constants.TABLE_WATCHLIST + " WHERE "
                                    + Constants.WATCHLIST_COLUMN_TITLE + " = '" + movie + "'", ResultSet.TYPE_SCROLL_SENSITIVE,
                            ResultSet.CONCUR_UPDATABLE);
            ResultSet data = getCount.executeQuery();
            data.last();
            count = data.getRow();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
