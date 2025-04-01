package br.edu.iff.ccc.bsi.exception;

public class DeviceNotRespondException extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public DeviceNotRespondException(String device)
	{
		super("Dispositivo de rede "+device+" não responde");
	}
}
