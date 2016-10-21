package com.lukgru.interview.sensinum;

import org.junit.Test;

import static com.lukgru.interview.sensinum.WhenObjectType.whenObjectType;
import static org.junit.Assert.*;

/**
 * Created by Łukasz on 2016-10-22.
 */
public class WhenObjectTypeTest {

    @Test
    public void shouldMatchCorrectly() {
        //given
        String object = "test";

        //when
        int result = whenObjectType(object)
                .is(String.class).thenReturn(1)
                .is(Integer.class).thenRetrun(2)
                .execute();

        //then
        assertEquals(1, result);
    }

}