package com.web.restservice;

import org.springframework.stereotype.Component;

import java.util.concurrent.Semaphore;

@Component
public class Counter {
    Semaphore semaphore = new Semaphore(1);
    public Integer count = 0;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Counter() {
    }
    
    public void inc(){
        try {
            semaphore.acquire();
            ++count;
        } catch (InterruptedException e) {
            System.out.println("Semaphore error corrupted");
        }
        finally {
            semaphore.release();
        }
    }

}
