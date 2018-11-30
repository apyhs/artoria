package artoria.common;

import java.util.List;

/**
 * Can convert to or convert back from bean list.
 * @author Kahle
 */
public interface Beanable {

    /**
     * Convert to bean list.
     * @param clazz Bean class
     * @param <T> Bean type
     * @return Converted bean list
     */
    <T> List<T> toBeanList(Class<T> clazz);

    /**
     * Convert back from bean list.
     * @param beanList Input bean list
     * @param <T> Bean type
     */
    <T> void fromBeanList(List<T> beanList);

}
