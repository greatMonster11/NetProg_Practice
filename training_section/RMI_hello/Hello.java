import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Hello extends UnicastRemoteObject implements HelloItf {
  public Hello() throws RemoteException {
    super();
  }

  // Cai dat ham cho phep goi tu xa
  public String sayHello() {
    return "Hello RMI";
  }
}