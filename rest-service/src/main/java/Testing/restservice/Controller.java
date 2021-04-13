package Testing.restservice;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

@RestController
public class Controller {
    private static final Logger logger = LogManager.getLogger(Controller.class);

    @Autowired public HashMapa hashMapa;

    @GetMapping("/")
    public Search GetParams(@RequestParam(value = "num1", defaultValue = "0") Integer num1,
                            @RequestParam(value = "num2", defaultValue = "0") Integer num2,
                            @RequestParam(value = "num3", defaultValue = "0") Integer num3) {
        if (num1 < -999 || num1 > 999
            || num2 < -999 || num2 > 999
            || num3 < -999 || num3 > 999)
        {
            String message = "Incorrect input";
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, message);
        }
        try
        {
            logger.info("Input was complete!");
            return new Search(num1,num2,num3);
        }catch(NumberFormatException nfe)
        {
            logger.error("Error occured");
            String s = "error!";
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR,s);
        }


    }

}
