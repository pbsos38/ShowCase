package exceptions;
public class TreeException extends Exception {

	/**
	 * @param message error message specific to cause of error.
	 */
	public TreeException(String message)
	{
		super(message);
	}
}
