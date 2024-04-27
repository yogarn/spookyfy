public abstract class Pelanggan implements Mendengarkan {
    private int kodePelanggan;
    private String nama;

    // currently using String, use Enum if possible
    private String statusKeanggotaan;
    private Lagu[] playlist;

    public Pelanggan(int kodePelanggan, String nama, String statusKeanggotaan) {
        this.kodePelanggan = kodePelanggan;
        this.nama = nama;
        this.statusKeanggotaan = statusKeanggotaan;
    }

    public int getKodePelanggan() {
        return kodePelanggan;
    }

    public void setKodePelanggan(int kodePelanggan) {
        this.kodePelanggan = kodePelanggan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getStatusKeanggotaan() {
        return statusKeanggotaan;
    }

    public void setStatusKeanggotaan(String statusKeanggotaan) {
        this.statusKeanggotaan = statusKeanggotaan;
    }

    public Lagu[] getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Lagu[] playlist) {
        this.playlist = playlist;
    }
}
