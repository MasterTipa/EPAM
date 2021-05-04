package com.web.restservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;
@Entity
public class Search {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Integer num1;
    private Integer num2;
    private Integer num3;
    private Integer num4;

    public Search() {
    }

    public void setNum1(Integer num1) {
        this.num1 = num1;
    }

    public void setNum2(Integer num2) {
        this.num2 = num2;
    }

    public void setNum3(Integer num3) {
        this.num3 = num3;
    }

    public Integer getNum4() {
        return num4;
    }

    public void setNum4(Integer num4) {
        this.num4 = num4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Search search = (Search) o;
        return Objects.equals(num4, search.num4);
    }
    Search(Integer num1, Integer num2, Integer num3, Integer num4){
        this.num1=num1;
        this.num2=num2;
        this.num3=num3;
        this.num4=num4;
    }
    Search(Integer num1, Integer num2, Integer num3){
        this.num1=num1;
        this.num2=num2;
        this.num3=num3;
        if (this.num1>this.num2){
            this.num4=this.num1;
        }else{
            this.num4=this.num2;
        }
        if (this.num4<this.num3)
            this.num4=this.num3;
    }
    public int getNum1(){
        return num1;
    }
    public int getNum2(){
        return num2;
    }
    public int getNum3(){
        return num3;
    }
}
