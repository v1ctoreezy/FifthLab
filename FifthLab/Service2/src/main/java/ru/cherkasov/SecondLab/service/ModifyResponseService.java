package ru.cherkasov.SecondLab.service;

import org.springframework.stereotype.Service;
import ru.cherkasov.SecondLab.model.Response;

@Service
public interface ModifyResponseService {

    Response modify(Response response);
}
