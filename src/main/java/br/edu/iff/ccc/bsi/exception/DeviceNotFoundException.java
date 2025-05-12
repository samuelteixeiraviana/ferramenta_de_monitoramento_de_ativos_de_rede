package br.edu.iff.ccc.bsi.exception;

public class DeviceNotFoundException extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public DeviceNotFoundException(String device)
	{
		super("Dispositivo de rede "+device+" não encontrado");
	}
}
