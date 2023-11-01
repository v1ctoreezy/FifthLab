package ru.cherkasov.SecondLab.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.cherkasov.SecondLab.exception.UnsupportedCodeException;
import ru.cherkasov.SecondLab.exception.ValidationFailedException;

@Service
public interface ValidationService {
    void isValid(BindingResult bindingResult) throws ValidationFailedException, UnsupportedCodeException;
}
