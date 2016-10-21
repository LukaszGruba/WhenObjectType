package com.lukgru.interview.sensinum;

/**
 * Created by Łukasz on 2016-10-22.
 */
public class WhenObjectType {

    public static Is whenObjectType(Object object) {
        return new RegularIs(object);
    }

}
