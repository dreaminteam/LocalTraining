package by.training.java.grodno.az.data.dao.impl;

import java.lang.reflect.ParameterizedType;

public class Main extends Test<String> {



    public static void main(String[] args) {

        System.out.println(new Main().test());;
    }
}

class Test<T> {
    public Class test() {
        Class<T> classOfObjectClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return classOfObjectClass;
    }
}
