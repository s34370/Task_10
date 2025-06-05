public class KontenerNaPlyny extends Kontener implements HazardNotifier {
    protected boolean Niebezpieczny;

    public KontenerNaPlyny(boolean Niebezpieczny, int Wysokosc, int Glebokosc, int WagaWlasna, int MaksLadownosc) {
        super("L", Wysokosc, Glebokosc, WagaWlasna, MaksLadownosc);
        this.Niebezpieczny = Niebezpieczny;
    }

    @Override
    public void Zaladunek(int masa) throws Przeładunek {
        if(Niebezpieczny) {
            MaksLadownosc*=0.5;
        } else {
            MaksLadownosc*=0.9;
        }
        if (masa > MaksLadownosc) {
            notify("Przekroczono dozwoloną masę dla kontenera: " + KodSeryjny);
            throw new Przeładunek("Załadunek przekracza dopuszczalny limit");
        } else {
            this.MasaLadunku = masa;
        }
    }

    @Override
    public void Oproznienie() {
        MasaLadunku = 0;
        System.out.println("Kontener " + KodSeryjny + " został opróżniony ");
    }

    @Override
    public String toString() {
       if(Niebezpieczny) {
         return "Kontener na płyny:" + "Kod seryjny = " + KodSeryjny + ", masa ładunku = " + MasaLadunku + "kg, " + "ładunek jest niebezpieczny";
       }
       else
           return "Kontener na płyny:" + "Kod seryjny = " + KodSeryjny + ", masa ładunku = " + MasaLadunku + "kg, " + "ładunek jest bezpieczny";
    }

    public void notify(String message) {
        System.out.println(message);
    }
}
