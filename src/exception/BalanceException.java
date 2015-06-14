package exception;

import org.algo.exception.PortfolioException;

public class BalanceException extends PortfolioException
{
	public BalanceException(String msg)
	{
		super(msg);
	}
}