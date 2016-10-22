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
    public <T> ThenReturn is(Class<T> clazz) {
        if (clazz.isAssignableFrom(object.getClass())) {
            return new FinalThenReturn<T>((T) object);
        }
        else {
            return new RegularThenReturn<T>(object);
        }
    }

    @Override
    public <R> R execute() {
        throw new UnsupportedOperationException("Object's type not matched.");
    }
}
