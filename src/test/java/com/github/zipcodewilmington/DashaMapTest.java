package com.github.zipcodewilmington;
import org.junit.Test;
import org.junit.Assert;

/**
 * @author xtofer
 * @version 1.0.0
 * @date 10/21/19 9:05 AM
 */
public class DashaMapTest {

    @Test
    public void setTest1() {
        DashaMap1 dashaMap1 = new DashaMap1();
        dashaMap1.set("abc", 1);

        Assert.assertEquals(1, dashaMap1.size());
    }

    @Test
    public void setGetTest() {
        DashaMap1 dashaMap1 = new DashaMap1();
        dashaMap1.set("abc", 1);
        dashaMap1.set("def", 2);

        int actual = dashaMap1.get("def");
        Assert.assertEquals(2, actual);
    }

    @Test
    public void findIndexTest() {
        DashaMap1 dashaMap1 = new DashaMap1();
        String key = "ghi";
        dashaMap1.set(key, 2);

        int actual = dashaMap1.HashFunctionOne(key) - 'a';

        Assert.assertEquals(6, actual);
    }

    @Test
    public void deleteKVPairTest() {
        DashaMap1 dashaMap1 = new DashaMap1();
        String key = "label";
        String key2 = "maker";
        String key3 = "this";
        dashaMap1.set(key, 1);
        dashaMap1.set(key2, 2);
        dashaMap1.set(key3, 3);

        System.out.println("Size prior to delete: " + dashaMap1.size());

        dashaMap1.delete(key2);

        System.out.println("Size after deleting key2: " + dashaMap1.size());

        Assert.assertEquals(2, dashaMap1.size());
    }

    @Test
    public void bucketSizeTest() {
        DashaMap1 dashaMap1 = new DashaMap1();
        String key = "label";
        String key2 = "maker";
        String key3 = "this";
        dashaMap1.set(key, 1);
        dashaMap1.set(key2, 2);
        dashaMap1.set(key3, 3);

        boolean actual = dashaMap1.bucketSize(key);
        Assert.assertTrue(actual);
    }
}
