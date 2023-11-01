package ru.cherkasov.SecondLab.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.cherkasov.SecondLab.exception.UnsupportedCodeException;
import ru.cherkasov.SecondLab.exception.ValidationFailedException;
import ru.cherkasov.SecondLab.model.*;
import ru.cherkasov.SecondLab.service.ModifyServices.ModifyRequestService;
import ru.cherkasov.SecondLab.service.ModifyServices.ModifyResponseService;
import ru.cherkasov.SecondLab.service.ValidationService;
import ru.cherkasov.SecondLab.util.DateTimeUtil;

import javax.validation.Valid;
import java.util.Date;

@Slf4j
@RestController
public class MyController {

    private final ValidationService validationService;
    private final ModifyResponseService modifyResponseService;
    private final ModifyRequestService modifyRequestService;

    @Autowired
    public MyController(ValidationService validationService,
                        @Qualifier("ModifySystemTimeResponseService") ModifyResponseService modifyResponseService,
                        ModifyRequestService modifyRequestService) {
        this.validationService = validationService;
        this.modifyResponseService = modifyResponseService;
        this.modifyRequestService = modifyRequestService;
    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@Valid @RequestBody Request request, BindingResult bindingResult) {

        log.info("request: {}", request);

        Response response = createDefaultResponse(request);
        try {
            validationService.isValid(bindingResult);
        } catch (ValidationFailedException e) {
            handleError(response, Codes.FAILED, ErrorCodes.VALIDATION_EXCEPTION, ErrorMessages.VALIDATION, e);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (UnsupportedCodeException exception) {
            handleError(response, Codes.FAILED, ErrorCodes.VALIDATION_EXCEPTION, ErrorMessages.VALIDATION, exception);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            handleError(response, Codes.FAILED, ErrorCodes.UNKNOWN_EXCEPTION, ErrorMessages.UNKNOWN, e);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        modifyResponseService.modify(response);
        modifyRequestService.modify(request);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private Response createDefaultResponse(Request request) {
        return Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(DateTimeUtil.getCustomFormat().format(new Date()))
                .code(Codes.SUCCESS)
                .errorCode(ErrorCodes.EMPTY)
                .errorMessage(ErrorMessages.EMPTY)
                .build();
    }

    private void handleError(Response response, Codes code, ErrorCodes errorCode, ErrorMessages errorMessage, Exception exception) {
        response.setCode(code);
        response.setErrorCode(errorCode);
        response.setErrorMessage(errorMessage);
        log.error("{}: {}", exception.getClass().getSimpleName(), exception.getMessage());
    }

}
