package com.test.microservice.springcloudconfigserver;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Test2 {
    public static void main(String args[])throws Exception{

        Test2 t = new Test2();
       boolean valid = t.check2(new int[]{5,1,22,25,6,-1,8,10},new int[]{1,25,5});
        System.out.println("valid"+valid);


    }

    public boolean checkSubSequence(int[]array1,int[]array2){

        for(int i=0;i<array2.length;i++){

            int firstNum = array2[i];
            boolean valid = false;

            for(int j=0;j<array1.length;j++){
                int k=0;
                if(firstNum == array1[j]){
                k =k+1;
                }
                if(k == array2.length){
                    return true;
                }
            }
        }
        return false;

    }

    public boolean check2(int[]array1,int[]array2){

        // int[]{5,1,22,25,6,-1,8,10},new int[]{1,25,10}
        List firstList = Arrays.asList(array1);
        int position = 0;
        int count = 0;

        for(int i=0;i<array2.length;i++){
            int element = array2[i];


            boolean found = Arrays.stream(array1).anyMatch(n -> n == element);


            int indexOfElement = IntStream.range(0, array1.length).
                    filter(k -> element == array1[k]).
                    findFirst().orElse(-1);


            if(indexOfElement >= position){
                position=indexOfElement;
                count = count+1;
            }

            //int index = IntStream.range(0,array1.length).filter(i -> element == array1[i]).findFirst().orElse(-1);

            if(count == array2.length){
                return true;
            }
        }
        return false;

    }
}
