package com.work_Home_new.new_Stream_API_Optional.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeValidNameException extends RuntimeException{
public EmployeeValidNameException() {
}
    public EmployeeValidNameException(String massage) {
    super(massage);
    }
    public EmployeeValidNameException(String massage, Throwable cause) {
        super(massage, cause);
    }
    public EmployeeValidNameException(Throwable cause) {
        super(cause);
    }
    public EmployeeValidNameException(String massage, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(massage, cause, enableSuppression, writableStackTrace);
    }

}
