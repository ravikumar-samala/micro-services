package com.test.microservice.springcloudconfigserver;

public class Test1 {

    public static void main(String args[]) throws Exception{
        Test1 t = new Test1();
        int a[] = t.sumofIntegrs(new int[]{3,5,-8,7}, 11);
        System.out.println(a[0]);
        System.out.println(a[1]);

    }

    public int[] sumofIntegrs(int[] array, int sum){

        for(int i=0;i<array.length;i++) {
            int firstnum = array[i];
            for(int j=i+1;j<array.length;j++) {
                if(firstnum+array[j] == sum){
                    return new int[]{firstnum,array[j]};
                }
            }
        }
        return new int[]{0,0};
    }
}

