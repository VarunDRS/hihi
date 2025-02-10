package com.junits.junits;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class StringReverserTest {

    StringReverser stringReverse = new StringReverser();

    @Test
    public void testString1(){
        assertEquals("42SRAC" , stringReverse.reverse("CARS24"));
    }

    @Test
    public void testString2(){
        assertEquals("NIF 42SRAC" , stringReverse.reverse("CARS24 FIN"));
    }

    @Test
    public void testString3(){
        assertEquals("" , stringReverse.reverse(""));
    }

    @Test
    void testReverseNullString() {
        assertNull(stringReverse.reverse(null));
    }

}
