package net.jonathanwerner.leadsheets.base;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.jonathanwerner.leadsheets.di.App;
import net.jonathanwerner.leadsheets.di.AppComponent;

/**
 * Created by jwerner on 2/20/15.
 */
public abstract class BaseFragment extends Fragment {

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Perform injection so that when this call returns all dependencies will be available for use.
//        App.get(getActivity()).component().inject(this);
        App app = App.get(getActivity());
        onCreateComponent(app.component());

        // this has to happen after the fragment injection
        setController();
    }

    public void setController() {

    }


    @Nullable @Override public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        final Controller controller = getController();
        if (controller != null) {
            controller.register();
        }
    }

    public Controller getController() {
        return null;
    }

    @Override public void onDestroy() {
        super.onDestroy();
        final Controller controller = getController();
        if (controller != null) {
            controller.unregister();
        }

    }

    protected abstract void onCreateComponent(AppComponent appComponent);
}
