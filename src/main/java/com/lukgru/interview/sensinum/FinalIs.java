package com.lukgru.interview.sensinum;

import java.util.function.Function;

/**
 * Created by Łukasz on 2016-10-22.
 */
class FinalIs implements Is {

    private final Object object;
    private final Function<Object, Object> function;

    public FinalIs(Object object, Function<Object, Object> function) {
        this.object = object;
        this.function = function;
    }

    @Override
    public ThenReturn is(Class<?> clazz) {
        return new FinalThenReturn(object, function);
    }

    @Override
    public Object execute() {
        return function.apply(object);
    }
}
