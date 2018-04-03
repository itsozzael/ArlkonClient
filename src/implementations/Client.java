package implementations;

import interfaces.ClientInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Client extends UnicastRemoteObject implements ClientInterface {

    int client_id;
    ClientInterface client;

    public Client() throws RemoteException {
        client_id = 0;
        client = null;
    }

    public Client(int id) throws RemoteException {
        client_id = id;
    }

    @Override
    public int getId() throws RemoteException {
        return client_id;
    }

    @Override
    public void send(String msg) throws RemoteException {
        System.out.println(msg);
    }

    @Override
    public void setClient(ClientInterface c) throws RemoteException {
        client = c;
    }

    @Override
    public ClientInterface getClient() throws RemoteException {
        return client;
    }
}
