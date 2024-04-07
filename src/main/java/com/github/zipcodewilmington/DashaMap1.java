package com.github.zipcodewilmington;

/**
 * @author xtofer
 * @version 1.0.0
 * @date 10/21/19 9:05 AM
 */
public class DashaMap1 implements HashMapX {

    private SinglyLinkedList[] array = new SinglyLinkedList[26];
    private int index;

    public DashaMap1() {
        for (int i = 0; i < array.length; i++) {
            SinglyLinkedList listToAdd = new SinglyLinkedList<>();
            array[i] = listToAdd;
        }
    }

    private Character HashFunctionOne(String input) {
        String lower = input.toLowerCase();
        if (input.length() > 0) {
            return lower.charAt(0);
        }
        return null;
    }
    @Override
    public void set(String key, int value) {
        index = HashFunctionOne(key) - 'a';
        array[index].add(key, value);
    }

    @Override
    public String delete(String key) {
        index = HashFunctionOne(key) -'a';
        if (array[index].contains(key)) {
            array[index].remove(key);
        }
        return null;
    }

    @Override
    public String get(String key) {
        index = HashFunctionOne(key) - 'a';
        if (array[index].contains(key)) {
            return key;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < array.length; i++) {
            if (array[i].isEmpty()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public long size() {
        long size = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].isEmpty()) {
                continue;
            }
            else {
                size += array[i].size();
            }
        }
        return size;
    }

    @Override
    public boolean bucketSize(String key) {
        return false;
    }
}
