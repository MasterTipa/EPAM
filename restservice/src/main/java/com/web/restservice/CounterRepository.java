package com.web.restservice;


import org.springframework.data.repository.CrudRepository;

public interface CounterRepository extends CrudRepository<Search,Long> {
    Search findSearchByNum1AndNum2AndNum3(Integer a, Integer b, Integer c);
}
