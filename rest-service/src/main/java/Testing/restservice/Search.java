package Testing.restservice;

import java.util.Objects;

public class Search {
    public Integer num1;
    public Integer num2;
    public Integer num3;
    public Integer num4;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Search search = (Search) o;
        return Objects.equals(num4, search.num4);
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
}
