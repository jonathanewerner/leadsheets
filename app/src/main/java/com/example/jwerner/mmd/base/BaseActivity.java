package com.example.jwerner.mmd.base;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.example.jwerner.mmd.di.App;

/**
 * Created by jwerner on 2/17/15.
 */
public abstract class BaseActivity extends ActionBarActivity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setController();

        // Perform injection so that when this call returns all dependencies will be available for use.
        ((App) getApplication()).inject(this);
    }

    public void setController() {

    }

    @Override public void onDestroy() {
        super.onDestroy();
        final Controller controller = getController();
        if (controller != null) {
            controller.unregister();
        }
    }

    public Controller getController() {
        return null;
    }

    @Override
    public void onStart() {
        super.onStart();
        final Controller controller = getController();
        if (controller != null) {
            controller.register();
        }
    }

}
