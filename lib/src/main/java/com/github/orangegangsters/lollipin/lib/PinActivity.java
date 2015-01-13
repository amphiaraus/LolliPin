package com.github.orangegangsters.lollipin.lib;

import android.app.Activity;
import android.os.Bundle;

import com.github.orangegangsters.lollipin.lib.interfaces.LifeCycleInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stoyan and olivier on 1/12/15.
 */
public class PinActivity extends Activity {
    private static List<LifeCycleInterface> mLifeCycleListeners;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mLifeCycleListeners != null) {
            for (LifeCycleInterface listener : mLifeCycleListeners) {
                listener.onActivityCreated(this, savedInstanceState);
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mLifeCycleListeners != null) {
            for (LifeCycleInterface listener : mLifeCycleListeners) {
                listener.onActivityStarted(this);
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mLifeCycleListeners != null) {
            for (LifeCycleInterface listener : mLifeCycleListeners) {
                listener.onActivityResumed(this);
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mLifeCycleListeners != null) {
            for (LifeCycleInterface listener : mLifeCycleListeners) {
                listener.onActivityPaused(this);
            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mLifeCycleListeners != null) {
            for (LifeCycleInterface listener : mLifeCycleListeners) {
                listener.onActivityStopped(this);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mLifeCycleListeners != null) {
            for (LifeCycleInterface listener : mLifeCycleListeners) {
                listener.onActivityDestroyed(this);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mLifeCycleListeners != null) {
            for (LifeCycleInterface listener : mLifeCycleListeners) {
                listener.onActivitySaveInstanceState(this, outState);
            }
        }
    }

    public static void addListener(LifeCycleInterface listener) {
        if(mLifeCycleListeners == null) {
            mLifeCycleListeners = new ArrayList<>();
        }
        mLifeCycleListeners.add(listener);
    }

    public static boolean removeListener(LifeCycleInterface listener) {
        if(mLifeCycleListeners == null) {
            return false;
        }
        return mLifeCycleListeners.remove(listener);
    }

    public static void addListeners(List<LifeCycleInterface> listeners) {
        if(mLifeCycleListeners == null) {
            mLifeCycleListeners = new ArrayList<>();
        }
        mLifeCycleListeners.addAll(listeners);
    }

    public static boolean removeListeners(List<LifeCycleInterface> listeners) {
        if(mLifeCycleListeners == null) {
            return false;
        }
        return mLifeCycleListeners.removeAll(listeners);
    }

    public static void clearListeners() {
        if(mLifeCycleListeners == null) {
            return;
        }
        mLifeCycleListeners.clear();
    }
}