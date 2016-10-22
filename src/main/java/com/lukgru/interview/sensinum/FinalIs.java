package com.lukgru.interview.sensinum;

import java.util.function.Function;

/**
 * Created by Łukasz on 2016-10-22.
 */
class FinalIs<O, R> implements Is<O, R> {

    private final O object;
    private final Function<O, R> function;

    public FinalIs(O object, Function<O, R> function) {
        this.object = object;
        this.function = function;
    }

    @Override
    public ThenReturn is(Class<?> clazz) {
        return new FinalThenReturn(object, function);
    }

    @Override
    public R execute() {
        return function.apply(object);
    }
}
