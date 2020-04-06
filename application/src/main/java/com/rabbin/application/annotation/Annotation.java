package com.rabbin.application.annotation;

import java.lang.reflect.Method;

@ClassAnnotation("annotation")
public class Annotation {
    @MethodAnnotation(name = "rabbin", id = 0)
    public void hello() {
    }

    public static void main(String[] args) {
        ClassAnnotation classAnnotation = Annotation.class.getAnnotation(ClassAnnotation.class);
        System.out.println(classAnnotation.value());

        Method[] declaredMethods = Annotation.class.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.isAnnotationPresent(MethodAnnotation.class)) {
                MethodAnnotation methodAnnotation = declaredMethod.getAnnotation(MethodAnnotation.class);
                System.out.println(methodAnnotation.name());
                System.out.println(methodAnnotation.id());
            }
        }
    }
}
