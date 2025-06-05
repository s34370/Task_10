public abstract class Kontener {
    protected static int NrSeryjny=1;
    protected int MasaLadunku;
    protected int Wysokosc;
    protected int WagaWlasna;
    protected int Glebokosc;
    protected int MaksLadownosc;
    protected String KodSeryjny;

    public Kontener(String typ, int Wysokosc, int Glebokosc, int WagaWlasna, int MaksLadownosc) {
        this.Wysokosc = Wysokosc;
        this.Glebokosc = Glebokosc;
        this.WagaWlasna = WagaWlasna;
        this.MaksLadownosc = MaksLadownosc;
        this.KodSeryjny = "KON-" + typ + "-" + NrSeryjny;
        NrSeryjny++;
    }

    public abstract void Zaladunek(int masa) throws Przeładunek;

    public abstract void Oproznienie();

    public String getKodSeryjny() {
        return KodSeryjny;
    }
}