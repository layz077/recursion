package com.annotation.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	 System.out.println(factorial(20));
     System.out.println(factorial(20,1));

     System.out.println(Arrays.toString(reverseArray(new int[]{1,2,3,4,2}, 0)));
     System.out.println(isPalindrome("mmbmm"));
        System.out.println(fibonacciValue(5));
        //System.out.println(powerSet(new String[]{"a","b","c"}).toString());
        subSequence("abc", "", 0);
    }

    static long factorial(int num){  //func
        if(num==1)
            return 1;
        return num * factorial(num-1);
    }

    static long factorial(int num,long value){  //param
        if(num==1)
            return value;
        return factorial(num-1,value*num);
    }

    static int[] reverseArray(int[] array,int pointer){
        if((array.length/2) -  pointer <= 0)
            return array;

        // do swap with pointer and length-1-pointer
        int temp = array[array.length-1-pointer];
        array[array.length-1-pointer] = array[pointer];
        array[pointer] = temp;

        return reverseArray(array,pointer+1);
    }

    static boolean isPalindrome(String s){
        if(s.length() <= 1)
            return true;
        if(s.charAt(0) != s.charAt(s.length()-1))
            return false;

        return isPalindrome(s.substring(1, s.length()-1));
    }

    static int fibonacciValue(int index){
        if(index <= 1)
            return index;

        return fibonacciValue(index-1) + fibonacciValue(index -2);
    }

    static void subSequence(String s, String res, int index){
        if(index >= s.length()){
            System.out.println(res);
            return;
        }
        subSequence(s, res + s.charAt(index),index +1); //take the current char
        subSequence(s, res, index + 1); //don't take the current char
    }

    /*static Object powerSet(String[] array){

        List<String> list = new ArrayList<>();
        for(int i=0 ; i < Math.pow(2, array.length) ;i++){
            StringBuilder s = new StringBuilder();
            for(int j = 0 ; j < array.length - 1 ;j++){
                int x = i;
                if((x & 1) == 0){
                    s.append(array[j]);
                }
                x = x >> 1;
            }
            list.add(s.toString());
        }
        return list;
    }*/
}
