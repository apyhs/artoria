package artoria.convert;

/**
 * Type converter.
 * @author Kahle
 */
public interface TypeConverter extends Converter {

    /**
     * Converts the given value object to the specified destination type.
     * @param source Will converting object
     * @param target Target type
     * @return Converted object
     */
    Object convert(Object source, Class<?> target);

}
