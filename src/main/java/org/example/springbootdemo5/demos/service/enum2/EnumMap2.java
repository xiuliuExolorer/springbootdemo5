package org.example.springbootdemo5.demos.service.enum2;

import java.util.AbstractMap;
import java.util.EnumMap;
import java.util.Set;

public class EnumMap2 <K extends Enum<K>, V> extends AbstractMap<K, V>
        implements java.io.Serializable, Cloneable{
    @Override
    public Set<Entry<K, V>> entrySet() {
        return Set.of();
    }

    public static void main(String[] args) {
        EnumMap<Enum1, String> map = new EnumMap<>(Enum1.class);
        map.put(Enum1.ONE,"1");

    }
}
