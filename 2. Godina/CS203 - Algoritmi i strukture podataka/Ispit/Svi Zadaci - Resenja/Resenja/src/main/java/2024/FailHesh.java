import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class FailHesh {
    private class Entry {
        public String word;
        public Integer occ;

        public Entry(String w, Integer occ) {
            this.word = w;
            this.occ = occ;
        }
    }

    public Integer cap;
    public LinkedList<Entry>[] list;

    public FailHesh(int cap) {
        this.cap = cap;
        this.list = new LinkedList[cap];
    }

    public void load() throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("ret.txt"));

        String line;
        while ((line = r.readLine()) != null) {
            put(line, line.hashCode() % this.cap);
        }
    }

    public void put(String w, Integer hash) {
        if (list[hash] == null) {
            list[hash] = new LinkedList<>();
        }

        for (Entry e : list[hash]) {
            if (e.word.equals(w)) {
                e.occ++;
                return;
            }
        }

        this.list[hash].add(new Entry(w, 1));
    }

    public void printHM() {
        for (LinkedList<Entry> e : this.list) {
            if (e == null) continue;
            for (Entry k : e) {
                System.out.println(k.word + " " + k.occ);
            }
        }
    }
}
