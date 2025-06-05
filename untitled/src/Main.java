public class Main {
    public static void main(String[] args) {
        try {
            KontenerNaPlyny Mleko = new KontenerNaPlyny(false, 260, 120, 600, 3000);
            Mleko.Zaladunek(2500);

            KontenerNaPlyny Paliwo = new KontenerNaPlyny(true, 260, 120, 800, 4000);
            Paliwo.Zaladunek(1800);

            KontenerNaGaz Argon = new KontenerNaGaz(147.0, 260, 120, 1000, 2000);
            Argon.Zaladunek(1500);

            KontenerChlodniczy Maslo = new KontenerChlodniczy("Masło", 20.5, 20.5, 260, 120, 1200, 3000);
            Maslo.Zaladunek(2000);

            Kontenerowiec kontenerowiec = new Kontenerowiec(10, 20000, 25.5);

            kontenerowiec.ZaladunekKontenera(Mleko);

            kontenerowiec.ZaladunekKontenera(Paliwo);

            kontenerowiec.ZaladunekKontenera(Argon);

            kontenerowiec.ZaladunekKontenera(Maslo);

            kontenerowiec.Info();

            Kontenerowiec drugiStatek = new Kontenerowiec(5, 15000, 22.0);

            kontenerowiec.PrzeniesKontener(drugiStatek, Mleko.getKodSeryjny());

            System.out.println("Przenoszenie kontenera z mlekiem na drugi kontenerowiec.");

            System.out.println("Pierwszy kontenerowiec:");

            kontenerowiec.Info();

            System.out.println("Drugi kontenerowiec:");

            drugiStatek.Info();
        }

        catch (Przeładunek e) {
            System.out.println(e.getMessage());
        }
    }
}