import java.util.Map;

public class HashMap<K, V> implements Map61BL<K, V> {

    /* TODO: Instance variables here */

    Entry<K, V>[] arr;
    int size;

    /* TODO: Constructors here */
    HashMap() {
        arr = new Entry[26];
        size = 0;
    }

    /* TODO: Interface methods here */

    private static class Entry<K, V> {

        private K key;
        private V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /* Returns true if this key matches with the OTHER's key. */
        public boolean keyEquals(Entry<K, V> other) {
            return key.equals(other.key);
        }

        /* Returns true if both the KEY and the VALUE match. */
        @Override
        public boolean equals(Object other) {
            return (other instanceof Entry
                    && key.equals(((Entry<K, V>) other).key)
                    && value.equals(((Entry<K, V>) other).value));
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }
    }
    @Override
    public boolean containsKey(K key) {

    }
}
