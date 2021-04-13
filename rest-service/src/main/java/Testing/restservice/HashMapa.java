package Testing.restservice;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class HashMapa {
    public Map<String,Search> greetingHashMap=new HashMap<>(); //making a map where the String is a key
                                                                //and Greeting - value
}
