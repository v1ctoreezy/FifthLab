package ru.cherkasov.SecondLab.service.ModifyServices;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.cherkasov.SecondLab.model.Request;
import ru.cherkasov.SecondLab.model.Systems;

@Service
public class ModifySystemNameRequestService implements ModifyRequestService {

    @Override
    public void modify(Request request) {
        request.setSystemName(Systems.SER);
        request.setSource("Service 1");

        HttpEntity<Request> httpEntity = new HttpEntity<>(request);

        new RestTemplate().exchange("http://localhost:8084/feedback",
                HttpMethod.POST,
                httpEntity,
                new ParameterizedTypeReference<>() {
                }
        );
    }
}
