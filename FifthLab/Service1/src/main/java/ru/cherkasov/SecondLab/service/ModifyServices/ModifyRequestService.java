package ru.cherkasov.SecondLab.service.ModifyServices;

import org.springframework.stereotype.Service;
import ru.cherkasov.SecondLab.model.Request;

@Service
public interface ModifyRequestService {
    void modify(Request request);
}
