package com.mengo.api.video;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VideoApplicationTests {

    @Test
    public void contextLoads() {
    }



    @Test
    public void testUUID(){
        UUID str = UUID.randomUUID();
        String[] s = str.toString().split("-");

        System.out.println(s[0]);

    }

}
