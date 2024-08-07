/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package org.example.springbootdemo5.threadLocal;

import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;

/**
 * A thread-local variable that is notified when a thread terminates and
 * it has been initialized in the terminating thread (even if it was
 * initialized with a null value).
 */
public class TerminatingThreadLocal<T> extends java.lang.ThreadLocal<T> {

    @Override
    public void set(T value) {
        super.set(value);
        register(this);
    }

    @Override
    public void remove() {
        super.remove();
        unregister(this);
    }

    /**
     * Invoked by a thread when terminating and this thread-local has an associated
     * value for the terminating thread (even if that value is null), so that any
     * native resources maintained by the value can be released.
     *
     * @param value current thread's value of this thread-local variable
     *              (may be null but only if null value was explicitly initialized)
     */
    protected void threadTerminated(T value) {
    }

    // following methods and field are implementation details and should only be
    // called from the corresponding code int Thread/ThreadLocal class.

    /**
     * Invokes the TerminatingThreadLocal's {@link #threadTerminated()} method
     * on all instances registered in current thread.
     */
    public static void threadTerminated() {
        for (TerminatingThreadLocal<?> ttl : REGISTRY.get()) {
            ttl._threadTerminated();
        }
    }

    private void _threadTerminated() { threadTerminated(get()); }

    /**
     * Register given TerminatingThreadLocal
     *
     * @param tl the ThreadLocal to register
     */
    public static void register(TerminatingThreadLocal<?> tl) {
        REGISTRY.get().add(tl);
    }

    /**
     * Unregister given TerminatingThreadLocal
     *
     * @param tl the ThreadLocal to unregister
     */
    private static void unregister(TerminatingThreadLocal<?> tl) {
        REGISTRY.get().remove(tl);
    }

    /**
     * a per-thread registry of TerminatingThreadLocal(s) that have been registered
     * but later not unregistered in a particular thread.
     */
    public static final java.lang.ThreadLocal<Collection<TerminatingThreadLocal<?>>> REGISTRY =
        new java.lang.ThreadLocal<>() {
            @Override
            protected Collection<TerminatingThreadLocal<?>> initialValue() {
                return Collections.newSetFromMap(new IdentityHashMap<>(4));
            }
        };
}
