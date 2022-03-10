package pe.softrami.app.exception;

public class BadRequestException extends RuntimeException {

	public BadRequestException(String message) {
		super(message);
	}

	public BadRequestException(String message, Throwable exception) {
		super(message, exception);
	}

}
