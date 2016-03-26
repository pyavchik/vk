package main;

import com.vk.Vk;

/**
 * Created by sh on 3/19/2016.
 */
public class MainVk {
    public static void main(String[] args) {

        vk.load();
        vk.openGroup();
        vk.becomeUserOfGroup();
        vk.lastPostLike();
        try {
            Thread.sleep(7);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        vk.lastPostRepost();
        try {
            Thread.sleep(7);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        vk.tearDown();
    }
}
