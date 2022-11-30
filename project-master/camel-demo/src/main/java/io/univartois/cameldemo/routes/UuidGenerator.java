package io.univartois.cameldemo.routes;

import java.util.List;

public class UuidGenerator {
    //public String getUuid(){
     //   int min=10;
      //  int max=199;
     //   return String.valueOf((Math.random()* ((max - min) + 1)) + min);
        //return UUID.randomUUID().toString();
    //}
    public List<String> getUuid(int min1,int max1,int min2,int max2,int min3,int max3){

        List<String> c;
        c=List.of(String.valueOf((Math.random()* ((max1 - min1) + 1)) + min1),String.valueOf((Math.random()* ((max2 - min2) + 1)) + min2),String.valueOf((Math.random()* ((max3 - min3) + 1)) + min3));
        return c;
        // return String.valueOf((Math.random()* ((max - min) + 1)) + min);
        //return UUID.randomUUID().toString();
    }
}
