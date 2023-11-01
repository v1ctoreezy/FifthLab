package ru.cherkasov.SecondLab.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.cherkasov.SecondLab.model.Response;
import ru.cherkasov.SecondLab.util.DateTimeUtil;

import java.util.Date;

@Service
@Qualifier("ModifySystemTimeResponseService")
@Slf4j
public class ModifySystemTimeResponseService
        implements ModifyResponseService {

    @Override
    public Response modify(Response response) {
        response.setSystemTime(DateTimeUtil.getCustomFormat().format(new Date()));
        log.info("Modified response: {}", response);

        return response;
    }
}
