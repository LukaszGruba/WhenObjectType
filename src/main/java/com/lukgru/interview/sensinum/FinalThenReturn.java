package com.lukgru.interview.sensinum;

import java.util.function.Function;

/**
 * Created by Łukasz on 2016-10-22.
 */
public class FinalThenReturn<T> implements ThenReturn<T>, Is {

    private final T object;
    private Function<T, Object> function;

    public FinalThenReturn(T object) {
        this.object = object;
    }

    @Override
    public <T> ThenReturn is(Class<T> clazz) {
        return this;
    }

    @Override
    public Is thenReturn(Function<T, Object> function) {
        this.function = this.function == null ? function : this.function;
        return this;
    }

    @Override
    public <R> R execute() {
        return (R) function.apply(object);
    }
}
