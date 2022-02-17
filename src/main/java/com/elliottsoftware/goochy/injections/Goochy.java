package com.elliottsoftware.goochy.injections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Goochy {

    public static Goochy with(Class module) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {


        return new Goochy(module);
    }

    private Goochy(Class module) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        for(Method method: module.getMethods()){
            if(method.isAnnotationPresent(InjectGoochy.class)){
                method.invoke(null);
            }
        }
    }

}
