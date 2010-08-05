package com.xtremelabs.droidsugar.fakes;

import android.os.Looper;
import com.xtremelabs.droidsugar.util.Scheduler;

import static com.xtremelabs.droidsugar.fakes.FakeHelper.newInstanceOf;

@SuppressWarnings({"UnusedDeclaration"})
public class FakeLooper {
    private static final ThreadLocal<Looper> sThreadLocal = new ThreadLocal<Looper>() {
        @Override
        protected Looper initialValue() {
            return newInstanceOf(Looper.class);
        }
    };
    private static final Looper MAIN_LOOPER = FakeHelper.newInstanceOf(Looper.class);

    public static Looper getMainLooper() {
        return MAIN_LOOPER;
    }

    public static Looper myLooper() {
        return sThreadLocal.get();
    }

    public Scheduler scheduler = new Scheduler();

    public void idle() {
        scheduler.tick(0);
    }

    public void post(Runnable r) {
        scheduler.post(r);
    }
}