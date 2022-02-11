package amith.auction.players.exception;

public class LimitExceededException extends RuntimeException {
	
	public LimitExceededException(String message) {
		super(message);
	}
	
}
