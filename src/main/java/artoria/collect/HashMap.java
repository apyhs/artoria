package artoria.collect;

import java.util.Map;

/**
 * HashMap who can chained set.
 * @author Kahle
 */
public class HashMap<K,V> extends java.util.HashMap<K,V> {

    public HashMap(K key, V value) {
        super();
        this.set(key, value);
    }

    public HashMap(Map<? extends K, ? extends V> m) {
        super();
        this.set(m);
    }

    public HashMap set(K key, V value) {
        super.put(key, value);
        return this;
    }

    public HashMap set(Map<? extends K, ? extends V> m) {
        super.putAll(m);
        return this;
    }

}
