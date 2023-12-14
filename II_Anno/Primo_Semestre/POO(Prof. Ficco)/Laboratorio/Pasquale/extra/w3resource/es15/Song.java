import java.time.LocalDate;

public class Song {
    public String title;
    public String author;
    public LocalDate release;

    public Song(String title, String author, LocalDate release) {
        this.title = title;
        this.author = author;
        this.release = release;
    }

    // string formatted as "DD/MM/YYYY"
    public Song(String title, String author, String release) {
        this.title = title;
        this.author = author;
        this.release = stringToDate(release);
    }

    private LocalDate stringToDate(String s) {
        String sDay, sMonth, sYear;
        int day, month, year;

        sDay = String.valueOf(s.charAt(0));
        sDay += String.valueOf(s.charAt(1));

        sMonth = String.valueOf(s.charAt(3));
        sMonth += String.valueOf(s.charAt(4));

        sYear = String.valueOf(s.charAt(6));
        sYear += String.valueOf(s.charAt(7));

        day = Integer.parseInt(sDay);
        month = Integer.parseInt(sMonth);
        year = Integer.parseInt(sYear);

        return LocalDate.of(year, month, day);
    }

}
