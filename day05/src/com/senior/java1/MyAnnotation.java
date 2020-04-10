package com.senior.java1;


import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * @author JUNSHI 405773808@qq.com
 * @create 2020-03-12 16:42
 */
@Inherited
@Repeatable(MyAnnotations.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, TYPE_PARAMETER, TYPE_USE})
public @interface MyAnnotation {

    String value() default "hello";

}
