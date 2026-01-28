package restapipractice.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import restapipractice.Request;
import restapipractice.RestResponse;
import restapipractice.Service.RestapiPracticeService;

@RestController // for building restful web services
@Tag(name = "RestapiPracticeController") // define tags for all operation of a class
public class RestapiPracticeController {
    @Autowired
    RestapiPracticeService restapiPracticeService;
private static final Logger logger = LoggerFactory.getLogger(RestapiPracticeController.class);

@RequestMapping(value = "/productMac", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//map the request to controller methods
@Operation(tags= "RestApi", operationId="RestApi", description = "to get products info", method= "POST") //provides detailed info about the endpoint in a controller
@ApiResponses(value =
        {@ApiResponse(responseCode = "200", description = "Success"),
                @ApiResponse(responseCode = "400", description = "Invalid Request"),
                @ApiResponse(responseCode = "540", description = "Unknown Error"),
                @ApiResponse(responseCode = "541", description = "Internal Error"),
                @ApiResponse(responseCode = "542", description = "External system Error")
        }) //describe posible responses of an operation
public RestResponse getproductMac(@RequestBody Request request) {
//convert Json body into java object
logger.debug("getproductMac method Started");
RestResponse response = new RestResponse();
try{
    response = restapiPracticeService.getproducts(request);
    } catch(Exception e){
     logger.error("RestapipracticeController Exception" +e);
    }
    return response;
}
}
