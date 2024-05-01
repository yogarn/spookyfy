import java.util.List;

public abstract class Pelanggan implements Mendengarkan {
    private final int kode;
    private String nama;

    private StatusKeanggotaan statusKeanggotaan;

    public Pelanggan(int kode, String nama, StatusKeanggotaan statusKeanggotaan) {
        this.kode = kode;
        this.nama = nama;
        this.statusKeanggotaan = statusKeanggotaan;
    }

    public StatusKeanggotaan getStatusKeanggotaan() {
        return statusKeanggotaan;
    }

    public void dengarkan(String judulLagu) {
        Lagu lagu = cekValiditasLagu(judulLagu);
        if (lagu != null) {
            System.out.println("Mendengarkan lagu...");
            System.out.printf("+%s+%s+%s+%s+%s+\n", "-".repeat(32), "-".repeat(17), "-".repeat(27), "-".repeat(22), "-".repeat(7));
            System.out.printf("| %-30s | %-15s | %-30s | %-20s | %5s |\n", "Judul Lagu", "Genre", "Artist", "Pencipta", "Tahun");
            System.out.printf("+%s+%s+%s+%s+%s+\n", "-".repeat(32), "-".repeat(17), "-".repeat(27), "-".repeat(22), "-".repeat(7));
            System.out.printf("| %-30s | %-15s | %-30s | %-20s | %5s |\n", lagu.getJudul(), lagu.getGenre(), lagu.getArtist(), lagu.getPencipta(), lagu.getTahun());
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

    public Pelanggan ubahStatusKeanggotaan(StatusKeanggotaan statusKeanggotaan) {
        if (this.statusKeanggotaan != statusKeanggotaan) {
            if (statusKeanggotaan == StatusKeanggotaan.PREMIUM) {
                return new PelangganPremium(kode, nama);
            } else {
                return new PelangganFree(kode, nama);
            }
        }
        return this;
    }

    public int getKode() {
        return kode;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String rowSeparator = String.format("+%s+%s+\n", "-".repeat(20), "-".repeat(77));
        String columnFormatter = "| %-18s | %-75s |\n";
        sb.append(rowSeparator);
        sb.append(String.format(columnFormatter, "Informasi Pengguna", "Keterangan"));
        sb.append(rowSeparator);
        sb.append(String.format(columnFormatter, "Kode", kode));
        sb.append(String.format(columnFormatter, "Nama", nama));
        sb.append(String.format(columnFormatter, "Status Keanggotaan", statusKeanggotaan));
        sb.append(rowSeparator);
        return sb.toString();
    }
}
