package logica.observer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;



public class Observable extends UnicastRemoteObject implements IObservable
{
    private LinkedList observersEspecialidades;

    public Observable() throws RemoteException
    {
        observersEspecialidades = new LinkedList();
    }

    public void addObserver (IObserver obs) throws RemoteException
    {
        observersEspecialidades.add(obs);
    }
    
    public void remObserver (IObserver obs) throws RemoteException
    {
    	observersEspecialidades.remove(obs);
    }

    public void notificar() throws RemoteException
    {
        for (int i=0; i<observersEspecialidades.size(); i++)
        {
            IObserver obs = (IObserver) observersEspecialidades.get(i);
            obs.update();
        }
    }
}