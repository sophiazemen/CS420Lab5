import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class TimeServerMain {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099); // Start RMI registry on port 1099
            TimeServerImpl timeServer = new TimeServerImpl();
            Naming.rebind("TimeServer", timeServer);

            System.out.println("TimeServer is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
