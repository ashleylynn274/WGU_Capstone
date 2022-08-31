package Model;

public class Videos {
    private String show_id;
    private String type;
    private String title;
    private String director;
    private String cast;
    private String country;
    private String date_added;
    private String release_year;
    private String rating;
    private String duration;
    private String listed_in;
    private String description;

    public Videos(
            String show_id,
            String type,
            String title,
            String director,
            String cast,
            String country,
            String date_added,
            String release_year,
            String rating,
            String duration,
            String listed_in,
            String description) {
        this.show_id = show_id;
        this.type = type;
        this.title = title;
        this.director = director;
        this.cast = cast;
        this.country = country;
        this.date_added = date_added;
        this.release_year = release_year;
        this.rating = rating;
        this.duration = duration;
        this.listed_in = listed_in;
        this.description = description;
    }

    public String getShow_id() {
        return show_id;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public String getCast() {
        return cast;
    }

    public String getCountry() {
        return country;
    }

    public String getDate_added() {
        return date_added;
    }

    public String getRelease_year() {
        return release_year;
    }

    public String getRating() {
        return rating;
    }

    public String getDuration() {
        return duration;
    }

    public String getListed_in() {
        return listed_in;
    }

    public String getDescription() {
        return description;
    }

    public boolean isInDecade(String release_decade_opt) {
        try {
            int rd = Integer.parseInt(release_decade_opt);
            int year = Integer.parseInt(release_year);
            if (year >= rd && year <= rd + 9) {
                return true;
            }
        }
        catch(Exception e) {
            // what the program is ignoring will be printed out in the terminal
            // System.out.println("Ignoring this: " + this.getTitle() + " rd: " + this.getRelease_year());
        }
        return false;
    }

    public boolean isInGenre(String genre_opt) {
        if (this.listed_in.contains(genre_opt))
        {
            return true;
        }
        return false;
    }
}
