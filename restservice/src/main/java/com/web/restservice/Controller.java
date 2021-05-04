package com.web.restservice;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class Controller {
    private static final Logger logger = LogManager.getLogger(Controller.class);

    @Autowired
    Cache cache;
    @Autowired
    Counter counter;
    @Autowired
    CounterRepository counterRepository;

    @GetMapping("/counter")
    public Integer outCounter() {
        return counter.getCount();
    }

    @PostMapping(value = "/")
    public ResponseEntity<?> bulkParams(@RequestBody List<SearchingNumbers> bodyList) {
        List<Search> testing = new LinkedList<>();
        testing = bodyList.stream()
                .map((body) -> {
                    Search search;
                    if (cache.isContains(body)) {
                        search = cache.get(body);
                    } else {
                        search = counterRepository.findSearchByNum1AndNum2AndNum3(body.getNum1(),body.getNum2(),body.getNum3());
                        if (search==null) {
                            search = counterRepository.save(new Search(body.getNum1(), body.getNum2(), body.getNum3()));
                        }
                        cache.put(body, search);
                    }
                    return search;
                })
                .collect(Collectors.toList());
        AverageValues values = new AverageValues();
        try {
            values.countArrangeValues(testing);
        } catch (Exception e) {
            return new ResponseEntity<>("500 error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        counter.inc();
        return new ResponseEntity<>(values, HttpStatus.OK);
    }

    @GetMapping("/add")
    public ResponseEntity<?> GetParams(@RequestParam(value = "num1", defaultValue = "0") Integer num1,
                                       @RequestParam(value = "num2", defaultValue = "0") Integer num2,
                                       @RequestParam(value = "num3", defaultValue = "0") Integer num3) {
        SearchingNumbers searchingNumbers;
        try {
            searchingNumbers = new SearchingNumbers(num1, num2, num3);
        } catch (Exception e) {
            return new ResponseEntity<>("500 error", HttpStatus.BAD_REQUEST);
        }
        Search search;

        if (cache.isContains(searchingNumbers)) {
            search = cache.get(searchingNumbers);
            logger.info("Im here");
        } else {
            search = counterRepository.findSearchByNum1AndNum2AndNum3(num1,num2,num3);
            if (search==null) {
                search = counterRepository.save(new Search(num1, num2, num3));
            }
            cache.put(searchingNumbers, search);
        }
        counter.inc();
        return new ResponseEntity<>(search, HttpStatus.OK);
    }
}
