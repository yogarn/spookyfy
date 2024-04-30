import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Playlist {
    private List<Lagu> laguList = new ArrayList<>();

    public Playlist(Lagu[] laguList) {
        Collections.addAll(this.laguList, laguList);
    }

    public Playlist(List<Lagu> laguList) {
        this.laguList = laguList;
    }

    public Playlist(){}

    public void addLagu(Lagu lagu) {
        laguList.add(lagu);
    }

    public void removeLagu(Lagu lagu) {
        laguList.remove(lagu);
    }

    public List<Lagu> getLaguList() {
        return laguList;
    }

    public Lagu getLagu(int index) {
        return laguList.get(index);
    }
}
