public class Lagu {
    private String judul;
    private String genre;
    private int tahun;
    private String artist;
    private String pencipta;

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

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getTahun() {
        return tahun;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getPencipta() {
        return pencipta;
    }

    public void setPencipta(String pencipta) {
        this.pencipta = pencipta;
    }
}
