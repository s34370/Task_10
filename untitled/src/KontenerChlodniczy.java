public class KontenerChlodniczy extends Kontener {
    private String Produkt;
    private double TemperaturaKontenera;
    private double WymaganaTemperatura;

    public KontenerChlodniczy(String Produkt, double TemperaturaKontenera, double WymaganaTemperatura, int Wysokosc, int Glebokosc, int WagaWlasna, int MaksLadownosc) {
        super("C", Wysokosc, Glebokosc, WagaWlasna, MaksLadownosc);
        this.Produkt = Produkt;
        this.TemperaturaKontenera = TemperaturaKontenera;
        this.WymaganaTemperatura = WymaganaTemperatura;
    }


    @Override
    public void Zaladunek(int masa) throws Przeładunek {
        if (TemperaturaKontenera < WymaganaTemperatura) {
            throw new Przeładunek("Temperatura zbyt niska dla: " + Produkt);
        }
        if (masa > MaksLadownosc) {
            throw new Przeładunek("Przekroczono ładowność kontenera");
        }
        else {
            this.MasaLadunku = masa;
        }
    }

    @Override
    public void Oproznienie() {
        this.MasaLadunku = 0;
    }

    @Override
    public String toString() {
        return "Kontener chłodniczy:" + "Kod seryjny = " + KodSeryjny + ", masa ładunku = " + MasaLadunku + "kg" ;
    }

}


