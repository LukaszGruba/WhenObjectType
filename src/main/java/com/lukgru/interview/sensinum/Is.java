package com.lukgru.interview.sensinum;

/**
 * Created by Łukasz on 2016-10-22.
 */
public interface Is<O, R> {

    ThenReturn is(Class<?> clazz);

    R execute();

}
