package com.work_Home_new.new_Stream_API_Optional.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeStorageIsFullException extends RuntimeException {
    public EmployeeStorageIsFullException() {
        super("Слишком много людей в базе, увольте кого-нибудь");
    }

        public EmployeeStorageIsFullException(String message) {
        super(message);
    }
}


