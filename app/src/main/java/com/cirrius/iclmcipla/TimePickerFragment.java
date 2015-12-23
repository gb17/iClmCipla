package com.cirrius.iclmcipla;

import java.util.Calendar;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class TimePickerFragment extends DialogFragment implements
        TimePickerDialog.OnTimeSetListener {
    public TextView textview;
    public EditText editText;
    int mode = 0;

    int TEXTVIEW = 11;
    int EDITTEXT = 22;

    DateInterface dInterface;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // use the current time as the default values for the picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        dInterface = (DateInterface) getActivity();
        // create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        // when the time is selected, send it to the activity via its callback
        // interface method
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, hourOfDay);
        c.set(Calendar.MINUTE, minute);
        dInterface.setTimeToView(c);

//        if (mode == TEXTVIEW) {
//            textview.setText(DateFormat.format("h:mm a", c));
//        } else if (mode == EDITTEXT) {
//            editText.setText(DateFormat.format("h:mm a", c));
//        }
    }

}
