package org.example.springbootdemo5.threadLocal;

import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicInteger;

public class EntryTest<T>  {

    static EntryTest.ThreadLocalMap map1 = new ThreadLocalMap();

    public T get() {
        EntryTest.ThreadLocalMap map = map1;
        if (map != null) {
            EntryTest.ThreadLocalMap.Entry e = map.getEntry(this);
            System.out.println("弱引用key值："+e.get());
            if (e != null) {
                @SuppressWarnings("unchecked")
                T result = (T)e.value;
                return result;
            }
        }
        return null;
    }

    private final int threadLocalHashCode = nextHashCode();



    private static AtomicInteger nextHashCode =
            new AtomicInteger();

    private static final int HASH_INCREMENT = 0x61c88647;

    private static int nextHashCode() {
        return nextHashCode.getAndAdd(HASH_INCREMENT);
    }



    static class ThreadLocalMap {

        private EntryTest.ThreadLocalMap.Entry[] table;

        private int size = 0;

        private int threshold;

        static class Entry extends WeakReference<EntryTest<?>> {
        /** The value associated with this ThreadLocal. */
        Object value;

        Entry(EntryTest<?> k, Object v) {
            super(k);
            value = v;
        }
    }
        private static int prevIndex(int i, int len) {
            return ((i - 1 >= 0) ? i - 1 : len - 1);
        }



        public static void main(String[] args) {
//        EntryTest<Object> objectEntryTest = new EntryTest<>();
//        EntryTest.map1.set(objectEntryTest,1);
            String a = "a";
            WeakReference<Integer> stringWeakReference = new WeakReference<>(1000);
//            String b = a;
//            Object c = object;
//            object = null;

            System.out.println(stringWeakReference.get());
            System.gc();
            System.out.println(stringWeakReference.get());
//        System.out.println(objectEntryTest.get());
    }

    static void method1(){
        System.out.println(1);

        java.lang.ThreadLocal<Object> objectThreadLocal = new java.lang.ThreadLocal<>();

        objectThreadLocal.set(1);
        objectThreadLocal.get();
    }
    
    private EntryTest.ThreadLocalMap.Entry getEntry(EntryTest<?> key) {
        int i = key.threadLocalHashCode & (table.length - 1);
        EntryTest.ThreadLocalMap.Entry e = table[i];
        if (e != null && e.get() == key)
            return e;
        else
            return getEntryAfterMiss(key, i, e);
    }


    private EntryTest.ThreadLocalMap.Entry getEntryAfterMiss(EntryTest<?> key, int i, EntryTest.ThreadLocalMap.Entry e) {
        EntryTest.ThreadLocalMap.Entry[] tab = table;
        int len = tab.length;

        while (e != null) {
            EntryTest<?> k = e.get();
            if (k == key)
                return e;
            if (k == null)
                expungeStaleEntry(i);
            else
                i = nextIndex(i, len);
            e = tab[i];
        }
        return null;
    }

    private int expungeStaleEntry(int staleSlot) {
        EntryTest.ThreadLocalMap.Entry[] tab = table;
        int len = tab.length;

        // expunge entry at staleSlot
        tab[staleSlot].value = null;
        tab[staleSlot] = null;
        size--;

        // Rehash until we encounter null
        EntryTest.ThreadLocalMap.Entry e;
        int i;
        for (i = nextIndex(staleSlot, len);
             (e = tab[i]) != null;
             i = nextIndex(i, len)) {
            EntryTest<?> k = e.get();
            if (k == null) {
                e.value = null;
                tab[i] = null;
                size--;
            } else {
                int h = k.threadLocalHashCode & (len - 1);
                if (h != i) {
                    tab[i] = null;

                    // Unlike Knuth 6.4 Algorithm R, we must scan until
                    // null because multiple entries could have been stale.
                    while (tab[h] != null)
                        h = nextIndex(h, len);
                    tab[h] = e;
                }
            }
        }
        return i;
    }

    private static int nextIndex(int i, int len) {
        return ((i + 1 < len) ? i + 1 : 0);
    }

        public void set(EntryTest<?> key, Object value) {

            // We don't use a fast path as with get() because it is at
            // least as common to use set() to create new entries as
            // it is to replace existing ones, in which case, a fast
            // path would fail more often than not.

            EntryTest.ThreadLocalMap.Entry[] tab = table;
            int len = tab.length;
            int i = key.threadLocalHashCode & (len-1);

            for (EntryTest.ThreadLocalMap.Entry e = tab[i];
                 e != null;
                 e = tab[i = nextIndex(i, len)]) {
                EntryTest<?> k = e.get();

                if (k == key) {
                    e.value = value;
                    return;
                }

                if (k == null) {
                    replaceStaleEntry(key, value, i);
                    return;
                }
            }

            tab[i] = new EntryTest.ThreadLocalMap.Entry(key, value);
            int sz = ++size;
            if (!cleanSomeSlots(i, sz) && sz >= threshold)
                rehash();
        }

        private boolean cleanSomeSlots(int i, int n) {
            boolean removed = false;
            EntryTest.ThreadLocalMap.Entry[] tab = table;
            int len = tab.length;
            do {
                i = nextIndex(i, len);
                EntryTest.ThreadLocalMap.Entry e = tab[i];
                if (e != null && e.get() == null) {
                    n = len;
                    removed = true;
                    i = expungeStaleEntry(i);
                }
            } while ( (n >>>= 1) != 0);
            return removed;
        }

        private void replaceStaleEntry(EntryTest<?> key, Object value,
                                       int staleSlot) {
            EntryTest.ThreadLocalMap.Entry[] tab = table;
            int len = tab.length;
            EntryTest.ThreadLocalMap.Entry e;

            // Back up to check for prior stale entry in current run.
            // We clean out whole runs at a time to avoid continual
            // incremental rehashing due to garbage collector freeing
            // up refs in bunches (i.e., whenever the collector runs).
            int slotToExpunge = staleSlot;
            for (int i = prevIndex(staleSlot, len);
                 (e = tab[i]) != null;
                 i = prevIndex(i, len))
                if (e.get() == null)
                    slotToExpunge = i;

            // Find either the key or trailing null slot of run, whichever
            // occurs first
            for (int i = nextIndex(staleSlot, len);
                 (e = tab[i]) != null;
                 i = nextIndex(i, len)) {
                EntryTest<?> k = e.get();

                // If we find key, then we need to swap it
                // with the stale entry to maintain hash table order.
                // The newly stale slot, or any other stale slot
                // encountered above it, can then be sent to expungeStaleEntry
                // to remove or rehash all of the other entries in run.
                if (k == key) {
                    e.value = value;

                    tab[i] = tab[staleSlot];
                    tab[staleSlot] = e;

                    // Start expunge at preceding stale entry if it exists
                    if (slotToExpunge == staleSlot)
                        slotToExpunge = i;
                    cleanSomeSlots(expungeStaleEntry(slotToExpunge), len);
                    return;
                }

                // If we didn't find stale entry on backward scan, the
                // first stale entry seen while scanning for key is the
                // first still present in the run.
                if (k == null && slotToExpunge == staleSlot)
                    slotToExpunge = i;
            }

            // If key not found, put new entry in stale slot
            tab[staleSlot].value = null;
            tab[staleSlot] = new EntryTest.ThreadLocalMap.Entry(key, value);

            // If there are any other stale entries in run, expunge them
            if (slotToExpunge != staleSlot)
                cleanSomeSlots(expungeStaleEntry(slotToExpunge), len);
        }

        private void rehash() {
            expungeStaleEntries();

            // Use lower threshold for doubling to avoid hysteresis
            if (size >= threshold - threshold / 4)
                resize();
        }

        private void expungeStaleEntries() {
            EntryTest.ThreadLocalMap.Entry[] tab = table;
            int len = tab.length;
            for (int j = 0; j < len; j++) {
                EntryTest.ThreadLocalMap.Entry e = tab[j];
                if (e != null && e.get() == null)
                    expungeStaleEntry(j);
            }
        }

        private void resize() {
            EntryTest.ThreadLocalMap.Entry[] oldTab = table;
            int oldLen = oldTab.length;
            int newLen = oldLen * 2;
            EntryTest.ThreadLocalMap.Entry[] newTab = new EntryTest.ThreadLocalMap.Entry[newLen];
            int count = 0;

            for (EntryTest.ThreadLocalMap.Entry e : oldTab) {
                if (e != null) {
                    EntryTest<?> k = e.get();
                    if (k == null) {
                        e.value = null; // Help the GC
                    } else {
                        int h = k.threadLocalHashCode & (newLen - 1);
                        while (newTab[h] != null)
                            h = nextIndex(h, newLen);
                        newTab[h] = e;
                        count++;
                    }
                }
            }

            setThreshold(newLen);
            size = count;
            table = newTab;
        }
        private void setThreshold(int len) {
            threshold = len * 2 / 3;
        }

    }


}
