package ru.cherkasov.SecondLab.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import ru.cherkasov.SecondLab.exception.UnsupportedCodeException;
import ru.cherkasov.SecondLab.exception.ValidationFailedException;
import ru.cherkasov.SecondLab.service.ValidationService;

import java.util.List;

@Service
@Slf4j
public class RequestValidationService implements ValidationService {
    @Override
    public void isValid(BindingResult bindingResult) throws ValidationFailedException, UnsupportedCodeException {
        if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError error : fieldErrors) {
                log.error("Error in field {}: {}", error.getField(), error.getDefaultMessage());
            }
                throw new
                    ValidationFailedException(bindingResult.getFieldError().toString());
        }

        String uid = (String) bindingResult.getFieldValue("uid");
        if ("123".equals(uid)) {
            log.error("Error in isValid, error 123");
            throw new UnsupportedCodeException(123);
        }
    }
}
