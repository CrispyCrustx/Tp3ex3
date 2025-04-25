import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServeurCalc extends UnicastRemoteObject implements Calculatrice {

    protected ServeurCalc() throws RemoteException {
        super();
    }
    @Override
    public double addition(double a, double b) { return a + b; }
    @Override
    public double soustraction(double a, double b) { return a - b; }
    @Override
    public double multiplication(double a, double b) { return a * b; }
    @Override
    public double division(double a, double b) {
        if (b == 0) throw new ArithmeticException("Division par zéro !");
        return a / b;
    }

    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099); // Start RMI registry
            ServeurCalc serveur = new ServeurCalc();
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("Calculatrice", serveur);
            System.out.println("Serveur RMI prêt !");
        } catch (RemoteException e) {
        }
    }
}
