import java.util.List;

public abstract class Pelanggan implements Mendengarkan {
    private int kode;
    private String nama;

    private JenisPelanggan statusKeanggotaan;
    private Playlist playlist;

    public Pelanggan(int kode, String nama, JenisPelanggan statusKeanggotaan) {
        this.kode = kode;
        this.nama = nama;
        this.statusKeanggotaan = statusKeanggotaan;
    }

    public int getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public JenisPelanggan getStatusKeanggotaan() {
        return statusKeanggotaan;
    }

    public void setStatusKeanggotaan(JenisPelanggan statusKeanggotaan) {
        this.statusKeanggotaan = statusKeanggotaan;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public void dengarkan(String judulLagu) {
        Lagu lagu = cekValiditasLagu(judulLagu);
        if (lagu != null) {
            System.out.println("Mendengarkan lagu...");
            System.out.printf("+%s+%s+%s+%s+%s+\n", "-".repeat(32), "-".repeat(17), "-".repeat(27), "-".repeat(22), "-".repeat(7));
            System.out.printf("| %-30s | %-15s | %-25s | %-20s | %5s |\n", "Judul Lagu", "Genre", "Artist", "Pencipta", "Tahun");
            System.out.printf("+%s+%s+%s+%s+%s+\n", "-".repeat(32), "-".repeat(17), "-".repeat(27), "-".repeat(22), "-".repeat(7));
            System.out.printf("| %-30s | %-15s | %-25s | %-20s | %5s |\n", lagu.getJudul(), lagu.getGenre(), lagu.getArtist(), lagu.getPencipta(), lagu.getTahun());
            System.out.printf("+%s+%s+%s+%s+%s+\n", "-".repeat(32), "-".repeat(17), "-".repeat(27), "-".repeat(22), "-".repeat(7));
            System.out.println();
        } else {
            System.out.println("Lagu tidak valid, periksa kembali input atau coba upgrade status keanggotaan!");
            System.out.println();
        }
    }

    public Lagu cekValiditasLagu(String judulLagu) {
        List<Lagu> laguList = ambilListLagu();
        for (Lagu lagu : laguList) {
            if (lagu.getJudul().equalsIgnoreCase(judulLagu)) {
                return lagu;
            }
        }
        return null;
    }
}
