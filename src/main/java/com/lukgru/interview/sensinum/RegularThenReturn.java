package com.lukgru.interview.sensinum;

import java.util.function.Function;

/**
 * Created by Łukasz on 2016-10-22.
 */
class RegularThenReturn implements ThenReturn {

    private Object object;

    public RegularThenReturn(Object object) {
        this.object = object;
    }

    @Override
    public Is thenReturn(Function<Object, Object> function) {
        return new RegularIs(object);
    }
}
