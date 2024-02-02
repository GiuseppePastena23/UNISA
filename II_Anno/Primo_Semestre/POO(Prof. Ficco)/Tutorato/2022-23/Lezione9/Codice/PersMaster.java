package interfacce;

import eccezioni.PositionException;

public interface PersMaster 
{
	void Ruota(int g);
	void Avanti(int s) throws PositionException;
	void Indietro(int s) throws PositionException;
}
