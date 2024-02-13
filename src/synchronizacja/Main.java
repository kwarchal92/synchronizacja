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

}

public class Main {
}
