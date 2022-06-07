package exceptions;

public class EmptyQueueException extends Exception {
	public EmptyQueueException()
	{
		super();
	}

	/**
	 * @param message error message specific to cause of error.
	 */
	public EmptyQueueException(String message)
	{
		super(message);
	}
}
