package restapipractice.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import restapipractice.CustomerServices;
import restapipractice.Data;
import restapipractice.Request;
import restapipractice.RestResponse;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
public class RestapiPracticeImpl implements RestapiPracticeService{
    private static final Logger logger = LoggerFactory.getLogger(RestapiPracticeImpl.class);

    @Autowired
    protected RestTemplate restTemplate;
    @Bean // Registers the returned object as a bean in the Spring context
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    @Override
    public RestResponse getproducts(Request request) {

        RestResponse entity = null;
        try {
            String url = "https://api.restful-api.dev/objects";
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<Request> requestEntity = new HttpEntity<>(request, headers);
            entity = restTemplate.postForObject(url, requestEntity, RestResponse.class);
//            customerServices.updateClass();
            //encode the response
            byte[] idBytes = entity.getId().getBytes(StandardCharsets.UTF_8);
            String encodedId = Base64.getEncoder().encodeToString(idBytes);
            entity.setId(encodedId);
            logger.info("Response from objects service " + entity);
        } catch (Exception e) {
            logger.error("Exception" + e);
        }
        return entity;
    }
}
