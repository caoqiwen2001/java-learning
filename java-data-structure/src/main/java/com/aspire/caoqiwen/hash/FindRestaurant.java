package com.aspire.caoqiwen.hash;

import java.util.*;

public class FindRestaurant {
    public static void main(String[] args) {
        System.out.println("hello wolrd");
        String[] arr = {"KFC", "Shogun", "Burger King"};
        String[] arr1 = {"KFC", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        String[] result = findRestaurant(arr, arr1);
        System.out.println("hello");

    }

    public static String[] findRestaurant(String[] list1, String[] list2) {
        int min = Integer.MAX_VALUE;
        List<String> list = new ArrayList<>();
        Map<String, Integer> maps = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            maps.put(list1[i], i);
        }

        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < list2.length; i++) {
            if (maps.containsKey(list2[i])) {
                int key = i + maps.get(list2[i]);
                if (key < min) {
                    list.clear();
                    min = key;
                    list.add(list2[i]);
                } else if (key == min) {
                    list.add(list2[i]);
                }
            }
        }
        return list.toArray(new String[list.size()]);
    }
}
