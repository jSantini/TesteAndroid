package com.jsantini.testandroidsantander.ui;

/**
 * Created by jsantini on 21/04/18.
 */

public interface BaseView<T> {

    void showOrHideLoading(boolean isShowLoading, String msg);

    boolean isActive();

    void showGenericError();

    void showConnectionError();
}
