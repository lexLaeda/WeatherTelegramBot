package exception.download;

import exception.IllegalInputException;

public class DownloadException extends IllegalInputException {
    public DownloadException(String userRequest) {
        super(userRequest);
    }
}
