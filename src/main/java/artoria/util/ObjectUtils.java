package artoria.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

import static artoria.common.Constants.ZERO;

/**
 * Object tools.
 * @author Kahle
 */
public class ObjectUtils {

    public static boolean isNull(Object obj) {

        return obj == null;
    }

    public static <T> T ifNull(T value, T defaultValue) {

        return value != null ? value : defaultValue;
    }

    public static boolean isArray(Object obj) {

        return obj != null && obj.getClass().isArray();
    }

    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj.getClass().isArray()) {
            return Array.getLength(obj) == ZERO;
        }
        if (obj instanceof CharSequence) {
            return ((CharSequence) obj).length() == ZERO;
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).isEmpty();
        }
        if (obj instanceof Map) {
            return ((Map) obj).isEmpty();
        }
        return false;
    }

    public static boolean equals(Object o1, Object o2) {

        return o1 == null ? o2 == null : o1.equals(o2);
    }

    @SuppressWarnings("unchecked")
    public static <T> T cast(Object object) {

        return (T) object;
    }

    @SuppressWarnings("unchecked")
    public static <T> T cast(Object object, Class<T> clazz) {

        return (T) object;
    }

}
