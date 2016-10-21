package com.lukgru.interview.sensinum;

/**
 * Created by Łukasz on 2016-10-22.
 */
class RegularIs implements Is {

    private Object object;

    public RegularIs(Object object) {
        this.object = object;
    }

    @Override
    public ThenReturn is(Class<?> clazz) {
        if (clazz.isAssignableFrom(object.getClass())) {
            return new FinalThenReturn(object);
        }
        else {
            return new RegularThenReturn(object);
        }
    }

    @Override
    public Object execute() {
        throw new UnsupportedOperationException("Object's type not matched.");
    }
}
