package com.lukgru.interview.sensinum;

import org.junit.Test;

import java.util.function.Function;

import static com.lukgru.interview.sensinum.WhenObjectType.whenObjectType;
import static org.junit.Assert.*;

/**
 * Created by Łukasz on 2016-10-22.
 */
public class WhenObjectTypeTest {

    public static final int CORRECT_MATCH = 1;
    public static final int WRONG_MATCH = 2;

    @Test
    public void shouldMatchFirstType() {
        //given
        String object = "test";

        //when
        int result = (int) whenObjectType(object)
                .is(String.class).thenReturn(d -> CORRECT_MATCH)
                .is(Integer.class).thenReturn(d -> WRONG_MATCH)
                .execute();

        //then
        assertEquals(CORRECT_MATCH, result);
    }

    @Test
    public void shouldMatchSecondType() {
        //given
        String object = "test";

        //when
        int result = (int) whenObjectType(object)
                .is(Integer.class).thenReturn(d -> WRONG_MATCH)
                .is(String.class).thenReturn(d -> CORRECT_MATCH)
                .execute();

        //then
        assertEquals(CORRECT_MATCH, result);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldNotMatchAnyType() {
        //given
        Object object = new Object();

        //when
        int result = (int) whenObjectType(object)
                .is(String.class).thenReturn(d -> CORRECT_MATCH)
                .is(Integer.class).thenReturn(d -> WRONG_MATCH)
                .execute();

        //then throw exception
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNPEForNullObject() {
        //given
        Object object = null;

        //when
        int result = (int) whenObjectType(object)
                .is(String.class).thenReturn(d -> 0)
                .is(Integer.class).thenReturn(d -> 0)
                .execute();

        //then throw exception
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNPEForNullType() {
        //given
        Object object = new Object();
        Class<?> type = null;

        //when
        int result = (int) whenObjectType(object)
                .is(String.class).thenReturn(d -> 0)
                .is(type).thenReturn(d -> 0)
                .execute();

        //then throw exception
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNPEForNullFunction() {
        //given
        String object = "test";
        Function<Object, Object> function = null;

        //when
        int result = (int) whenObjectType(object)
                .is(Integer.class).thenReturn(d -> 0)
                .is(String.class).thenReturn(d -> function)
                .is(Object.class).thenReturn(d -> 0)
                .execute();

        //then throw exception
    }

}