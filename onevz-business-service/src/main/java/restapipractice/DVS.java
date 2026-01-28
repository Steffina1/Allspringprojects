package restapipractice;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //specifies how long the annotation shd be retained
@Target(ElementType.METHOD) //can only be applied to methods and prevents compilation if used in class, fields etc
public @interface DVS {
    ServiceName serviceName();
    boolean validateWarning () default false;
}
