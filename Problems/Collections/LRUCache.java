package Collections;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K,V> extends LinkedHashMap<K,V> {
    private final int capacity;

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache);
        lruCache.get(1);
        System.out.println(lruCache); //output {2=2, 1=1}
        lruCache.put(3, 3); // Remove 2 and add 3
        System.out.println(lruCache); //output {1=1, 3=3}
        lruCache.get(2);    // return null
        lruCache.put(4, 4); // Remove 1 and add o 4
        System.out.println(lruCache); //output {3=3, 4=4}
        lruCache.get(3);    // return 3
        System.out.println(lruCache); //output {4=4, 3=3}
        lruCache.get(4);    // return 4
        System.out.println(lruCache); //output {3=3, 4=4}
    }

    public LRUCache(int capacity){
        super(capacity,0.75f,true);
        this.capacity=capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > this.capacity;
    }
}
