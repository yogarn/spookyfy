public class Lagu {
    private final String judul;
    private final String genre;
    private final int tahun;
    private final String artist;
    private final String pencipta;

    public Lagu(String judul, String genre, int tahun, String artist, String pencipta) {
        this.judul = judul;
        this.genre = genre;
        this.tahun = tahun;
        this.artist = artist;
        this.pencipta = pencipta;
    }

    public String getJudul() {
        return judul;
    }

    public String getGenre() {
        return genre;
    }

    public int getTahun() {
        return tahun;
    }

    public String getArtist() {
        return artist;
    }

    public String getPencipta() {
        return pencipta;
    }

}
