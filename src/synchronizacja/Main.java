package synchronizacja;

class SumArray
{
    private int suma;
    synchronized int sumArray(int liczby [])
    {
        suma = 0;

        for (int i = 0; i < liczby.length; i++)
        {
            suma += liczby[i];
            System.out.println("Biezaca wartosc sumy dla " + Thread.currentThread().getName() + " wynosi " + suma + ".");
            try
            {
                Thread.sleep(10); //przelaczenie zadan
            }
            catch(InterruptedException exc)
            {
                System.out.println("Glowny watek zostal przerwany.");
            }
        }
        return suma;
    }
}

class mojWatek implements Runnable
{
    Thread wtk;
    static SumArray sa = new SumArray();
    int a[];
    int odp;

    //tworzenie nowego watku
    mojWatek(String nazwa, int liczby[])
    {
        wtk = new Thread(this, nazwa);
        wtk.start(); //uruchomienie watku
        a = liczby;
    }

    //poczatek wykonywania nowego watku
    @Override
    public void run()
    {
        System.out.println(wtk.getName() + " startuje.");
        odp = sa.sumArray(a);

        System.out.println("Suma koncowa dla " + wtk.getName() + " wynosi " + odp + ".");
        System.out.println(wtk.getName() + " zostal zakonczony.");
    }
}


public class Main {
    public static void main(String[] args)
    {
        int a[] = {1,2,3,4,5};

        mojWatek mw1 = new mojWatek("Watek 1", a);
        mojWatek mw2 = new mojWatek("Watek 2", a);
    }
}
