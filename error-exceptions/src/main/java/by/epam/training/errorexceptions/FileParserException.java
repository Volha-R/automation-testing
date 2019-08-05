package by.epam.training.errorexceptions;

public class FileParserException extends RuntimeException{//потом сменить название
    public FileParserException(String message) {
        super(message);
    }

    public FileParserException(String message, Throwable cause) {
        super(message, cause);
    }
}
