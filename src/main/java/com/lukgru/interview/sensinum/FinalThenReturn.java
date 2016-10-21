package com.lukgru.interview.sensinum;

import java.util.function.Function;

/**
 * Created by Łukasz on 2016-10-22.
 */
public class FinalThenReturn implements ThenReturn {

    private final Object object;
    private Function<Object, Object> function;

    public FinalThenReturn(Object object) {
        this.object = object;
    }

    public FinalThenReturn(Object object, Function<Object, Object> function) {
        this.object = object;
        this.function = function;
    }

    @Override
    public Is thenReturn(Function<Object, Object> function) {
        return new FinalIs(object, this.function != null ? this.function : function);
    }
}
