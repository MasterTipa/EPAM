package com.web.restservice;

import java.util.List;
import java.util.OptionalDouble;

public class AverageValues {
    private Double num1;
    private Double num2;
    private Double num3;
    private Double num4;

    public Double getNum1() {
        return num1;
    }

    public void setNum1(Double num1) {
        this.num1 = num1;
    }

    public Double getNum2() {
        return num2;
    }

    public void setNum2(Double num2) {
        this.num2 = num2;
    }

    public Double getNum3() {
        return num3;
    }

    public void setNum3(Double num3) {
        this.num3 = num3;
    }

    public Double getNum4() {
        return num4;
    }

    public void setNum4(Double num4) {
        this.num4 = num4;
    }

    public AverageValues() {
    }
    public void countArrangeValues(List<Search> searchList) {
        this.num1 = this.calcAverageNum1(searchList);
        this.num2 = this.calcAverageNum2(searchList);
        this.num3 = this.calcAverageNum3(searchList);
        this.num4 = this.calcAverageNum4(searchList);
        }
    public Double calcAverageNum1(List<Search> searchList) {
        OptionalDouble oDouble=searchList.stream().
                mapToInt(Search::getNum1).average();
        return oDouble.isPresent() ? oDouble.getAsDouble(): null;
    }

    public Double calcAverageNum2(List<Search> searchList) {
        OptionalDouble oDouble=searchList.stream().
                mapToInt(Search::getNum2).average();
        return oDouble.isPresent() ? oDouble.getAsDouble(): null;
    }

    public Double calcAverageNum3(List<Search> searchList) {
        OptionalDouble oDouble=searchList.stream().
                mapToInt(Search::getNum3).average();
        return oDouble.isPresent() ? oDouble.getAsDouble(): null;
    }

    public Double calcAverageNum4(List<Search> searchList) {
        OptionalDouble oDouble=searchList.stream().
                mapToInt(Search::getNum4).average();
        return oDouble.isPresent() ? oDouble.getAsDouble(): null;
    }

}
