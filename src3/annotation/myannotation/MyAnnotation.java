package annotation.myannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.LOCAL_VARIABLE,ElementType.FIELD,ElementType.PARAMETER,ElementType.METHOD,ElementType.TYPE})
public @interface MyAnnotation {

}
