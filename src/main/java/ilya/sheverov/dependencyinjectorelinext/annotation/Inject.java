package ilya.sheverov.dependencyinjectorelinext.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Требовалось реализовать в тестовом задании. Аннотация, поставленная над конструктором класса, говорит о том, что
 * аргументы конструктора должны быть инжектированы.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.CONSTRUCTOR)
public @interface Inject {
}
