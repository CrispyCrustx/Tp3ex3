import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientCalc {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            Calculatrice calc = (Calculatrice) registry.lookup("Calculatrice");

            double a = 10, b = 5;
            System.out.println("Addition: " + calc.addition(a, b));
            System.out.println("Soustraction: " + calc.soustraction(a, b));
            System.out.println("Multiplication: " + calc.multiplication(a, b));
            System.out.println("Division: " + calc.division(a, b));
        } catch (NotBoundException | RemoteException e) {
        }
    }
}
