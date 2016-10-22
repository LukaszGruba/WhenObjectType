package com.lukgru.interview.sensinum;

/**
 * Created by Łukasz on 2016-10-22.
 */
public interface Is {

    <T> ThenReturn is(Class<T> clazz);

    <R> R execute();

}
