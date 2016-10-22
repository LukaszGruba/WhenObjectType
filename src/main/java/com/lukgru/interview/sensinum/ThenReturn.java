package com.lukgru.interview.sensinum;

import java.util.function.Function;

/**
 * Created by Łukasz on 2016-10-22.
 */
public interface ThenReturn<T> {

    Is thenReturn(Function<T, Object> function);

}
