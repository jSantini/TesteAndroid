package com.jsantini.testandroidsantander.ui.util;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jsantini on 21/04/18.
 */

public class Utils {

    public static Boolean stringIsEmpty(final String string) {
        if (string == null || string.equalsIgnoreCase("")) {
            return true;
        }
        return false;
    }

    public static String formatDate(final Date date) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        return dateFormat.format(date);
    }

    public static Date converterStringToDate(final String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
        Date convertedDate = new Date();
        try {
            convertedDate = dateFormat.parse(dateString);
        } catch (ParseException e) {
            return null;
        }
        return convertedDate;
    }

    public static void hideKeyboard(Activity activity) {
        if (activity != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            View view = activity.getCurrentFocus();

            if (null != view && null != view.getWindowToken() && EditText.class.isAssignableFrom(view.getClass())) {
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            } else {
                activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
            }
        }
    }
}
