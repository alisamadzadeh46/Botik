package com.example.botik.utils;

public class Farsinumber {

    static  String[] farsinumber =new String[]{"۰","۱","۲","۳","۴","۵","۶","۷","۸","۹"};
    public static String farsinumber(String text)
    {
        if(text.length()==0){
            return "";
        }
        StringBuilder out= new StringBuilder();
        int length=text.length();
        for (int i = 0; i <length ; i++) {
            char c=text.charAt(i);
            if('0' <=c && c<='9'){
                int number = Integer.parseInt(String.valueOf(c));
                out.append(farsinumber[number]);
            }
            else out.append(c);
        }
        return out.toString();
    }
}
