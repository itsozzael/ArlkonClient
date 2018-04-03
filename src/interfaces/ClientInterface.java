package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientInterface extends Remote {
    public int getId() throws RemoteException;
    public void send(String msg) throws RemoteException;
    public void setClient(ClientInterface c) throws RemoteException;
    public ClientInterface getClient() throws RemoteException;
}
