package net.jonathanwerner.leadsheets.base;

/**
 * Created by jwerner on 2/25/15.
 */
public interface Controlled {
    Controller getController();

    default void onStart() {

    }

}
