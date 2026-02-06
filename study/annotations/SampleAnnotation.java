package study.annotations;


import java.lang.annotation.*;


@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface SampleAnnotation {
    String author();
    String version() default "1.0";
 }


