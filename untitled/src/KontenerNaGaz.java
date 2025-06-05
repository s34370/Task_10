public class KontenerNaGaz extends Kontener {
    private double Cisnienie;

    public KontenerNaGaz(double Cisnienie, int Wysokosc, int Glebokosc, int WagaWlasna, int MaksLadownosc) {
        super("G", Wysokosc, Glebokosc, WagaWlasna, MaksLadownosc);
        this.Cisnienie = Cisnienie;
    }

    @Override
    public void Zaladunek(int masa) throws Przeładunek {
        if (masa > MaksLadownosc) {
            notify("Przekroczono ładowność kontenera: " + KodSeryjny);
            throw new Przeładunek("Za dużo ładunku dla kontenera gazowego");
        }
        this.MasaLadunku = masa;
    }

    @Override
    public void Oproznienie() {
        this.MasaLadunku *= 0.05;
    }



    @Override
    public String toString() {
        return "Kontener na gaz:" + "Kod seryjny = " + KodSeryjny + ", masa ładunku = " + MasaLadunku + "kg, " + "ładunek pod ciśnieniem: " + Cisnienie + " atmosfer" ;
    }

    public void notify(String message) {
        System.out.println(message);
    }
}
