package amith.auction.players.exception;

public class ExceptionEntity 
{
	private int statuscode;
	private String message;
	private Long timestamp;
	
	public ExceptionEntity() {
		super();
	}

	public ExceptionEntity(int statuscode, String message, Long timestamp) {
		super();
		this.statuscode = statuscode;
		this.message = message;
		this.timestamp = timestamp;
	}

	public int getStatuscode() {
		return statuscode;
	}

	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "ExceptionEntity [statuscode=" + statuscode + ", message=" + message + ", timestamp=" + timestamp + "]";
	}
	
}
