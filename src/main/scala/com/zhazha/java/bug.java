package com.zhazha.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bug {
    public static void main(String[] args) {

        List<String> a = new ArrayList<>();
        a.add("F1");
        a.add("F2");
        a.add("F3");
//        for(String tmp:a){
//            System.out.println(tmp);
//            if("F1".equals(tmp)){
//                a.remove(tmp);
//                System.out.println(a.size());
//            }
//        }


//        Iterator<String> it = a.iterator();
//        while (it.hasNext()) {
//            String tmp = it.next();
//            if (tmp.equals("F1")) {
//                a.remove(tmp);
//            }
//        }


//        for(int i=0;i<=a.size()-1;i++){
////            if (a.get(i).equals("F3")) {
////                a.remove(i);
////            }
////        }

//        a.forEach(s-> System.out.println(s));
//        for(String s:a){
//            System.out.println(s);
//        }

        int i, sum = 0;
        for (i = 0; i < 10; i++, sum += i) {
        }
        System.out.println(i);
    }
}
