import java.util.ArrayList;
import java.util.List;

public class Kontenerowiec {
    private List<Kontener> Kontenery = new ArrayList<>();
    private int MaxIlosc;
    private int MaxWaga;
    private double MaxPredkosc;

    public Kontenerowiec(int MaxIlosc, int MaxWaga, double MaxPredkosc) {
        this.MaxIlosc = MaxIlosc;
        this.MaxWaga = MaxWaga;
        this.MaxPredkosc = MaxPredkosc;
    }

    private int getWagaLaczna() {
        int wynik = 0;
        for (Kontener k : Kontenery) {
            wynik+= k.MasaLadunku + k.WagaWlasna;
        }
        return wynik;
    }

    public void ZaladunekKontenera(Kontener k) {
        if (Kontenery.size() >= MaxIlosc || getWagaLaczna() + k.MasaLadunku > MaxWaga) {
            System.out.println("Nie można załadować kontenera: " + k.getKodSeryjny());
        } else {
            Kontenery.add(k);
        }
    }

    public void UsunKontener(String numer) {
        for (Kontener k : Kontenery) {
            if (k.getKodSeryjny().equals(numer)) {
                Kontenery.remove(k);
            }
        }
    }

    public void WymienKontener(String numer, Kontener nowy) {
        for (int i = 0; i < Kontenery.size(); i++) {
            if (Kontenery.get(i).getKodSeryjny().equals(numer)) {
                Kontenery.set(i, nowy);
            }
        }
    }

    public void PrzeniesKontener(Kontenerowiec inny, String numer) {
        Kontener DoPrzeniesienia = null;

        for (Kontener k : Kontenery) {
            if (k.getKodSeryjny().equals(numer)) {
                inny.ZaladunekKontenera(k);
                DoPrzeniesienia = k;
                break;
            }
        }

        if (DoPrzeniesienia != null) {
            Kontenery.remove(DoPrzeniesienia);
        }

    }
    public void Info() {
        System.out.println("Kontenerowiec: " + "(" + Kontenery.size() + "/" + MaxIlosc + ")" + " kontenerów, maksymalna prędkość: " + MaxPredkosc + " węzłów");
        for (Kontener k : Kontenery) {
            System.out.println(k);
        }
    }
}
