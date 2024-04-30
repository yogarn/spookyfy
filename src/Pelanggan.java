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
}
