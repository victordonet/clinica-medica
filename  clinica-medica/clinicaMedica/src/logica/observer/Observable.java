package logica.observer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;

public class Observable extends UnicastRemoteObject implements IObservable
{

	private static final long serialVersionUID = 1L;
	private LinkedList colMenuGA, colReservaTurno, colDispoMed;

    public Observable() throws RemoteException
    {
        colMenuGA = new LinkedList();
        colReservaTurno = new LinkedList();
        colDispoMed = new LinkedList();
        
    }

    public void addObsMenuGA (IObserver obs) throws RemoteException
    {
        colMenuGA.add(obs);
    }
    
    public void remObsMenuGA (IObserver obs) throws RemoteException
    {
    	colMenuGA.remove(obs);
    }

    public void notificarMenuGA() throws RemoteException
    {
    	if(colMenuGA.size()>0){
    		for (int i=0; i<colMenuGA.size(); i++)
    		{
    			IObserver obs = (IObserver) colMenuGA.get(i);
    			obs.update();
    		}
    	}
    }
    public void addObsReservaTurno (IObserver obs) throws RemoteException
    {
        colReservaTurno.add(obs);
    }
    
    public void remObsRservaTurno (IObserver obs) throws RemoteException
    {
    	colReservaTurno.remove(obs);
    }

    public void notificarReservaTurno() throws RemoteException
    {
    	if(colReservaTurno.size()>0){
    		for (int i=0; i<colReservaTurno.size(); i++)
    		{
    			IObserver obs = (IObserver) colReservaTurno.get(i);
    			obs.update();
    		}
    	}
    }

	public void addObsDispMed(IObserver obs) throws RemoteException {
		colDispoMed.add(obs);
	}

	public void remObsDispMed(IObserver obs) throws RemoteException {
		colDispoMed.remove(obs);
	}

	public void notificarDispMed() throws RemoteException {
		if(colDispoMed.size()>0){ 
			for (int i=0; i<colDispoMed.size(); i++)
			{
				IObserver obs = (IObserver) colDispoMed.get(i);
				obs.update();
			}
		}
	}
}