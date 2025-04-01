package br.edu.iff.ccc.bsi.exception;

public class DeviceAlreadyExistsException extends RuntimeException
{
	private static final long serialVersionUID = 1L;
	
	public DeviceAlreadyExistsException(String device)
	{
		super("Dispositivo de rede "+device+" já existe");
	}
}
