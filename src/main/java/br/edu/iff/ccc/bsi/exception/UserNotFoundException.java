package br.edu.iff.ccc.bsi.exception;

public class UserNotFoundException extends RuntimeException
{
	private static final long serialVersionUID = 1L;
	
	public UserNotFoundException(Long id)
	{
		super("User não encontrado");
	}
}
