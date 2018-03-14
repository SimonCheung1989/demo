package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class LunchAndDinner {

    public static List<String> restaurant_list = new ArrayList();

    static {
        restaurant_list.add("大食代");
        restaurant_list.add("饭堂3楼");
        restaurant_list.add("饭堂4楼");
        restaurant_list.add("华辉拉肠");
        restaurant_list.add("赛百味");
        restaurant_list.add("麦当劳");
        restaurant_list.add("石锅饭");
        restaurant_list.add("三下江");
        restaurant_list.add("萨利亚");

    }


    public static void main(String[] args) {
        System.out.println(getRestaurant());
    }

    public static String getRestaurant() {
        int randomNum = (int) Math.floor(Math.random()*restaurant_list.size());
        return restaurant_list.get(randomNum);
    }


}
