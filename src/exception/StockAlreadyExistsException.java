package exception;

import org.algo.exception.PortfolioException;

public class StockAlreadyExistsException extends PortfolioException
{
	public StockAlreadyExistsException(String msg)
	{
		super(msg);
	}
}
