package com.iclm.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;

public class Utility {
	public static void showTempAlert(Context context, String message) {

		AlertDialog.Builder alertbox = new AlertDialog.Builder(context);
		alertbox.setCancelable(false);
		alertbox.setMessage(message).setPositiveButton("OK",
				new OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
					}
				});
		alertbox.create();
		alertbox.show();
	}
	
	
	
	public static String getDateString() {
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+5:30"));
		cal.setTime(new Date(System.currentTimeMillis()));
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int date = cal.get(Calendar.DATE);
		Calendar calt = Calendar.getInstance(TimeZone.getTimeZone("GMT+5:30"));
		calt.setTime(new Date());
		int hh = calt.get(Calendar.HOUR_OF_DAY);
		int mm = calt.get(Calendar.MINUTE);
		int ss = calt.get(Calendar.SECOND);
		String dt = (date < 10 ? "0" + date : "" + date) + "/"
				+ (month < 10 ? "0" + month : "" + month) + "/" + year + " "
				+ (hh < 10 ? "0" + hh : "" + hh) + ":"
				+ (mm < 10 ? "0" + mm : "" + mm) + ":"
				+ (ss < 10 ? "0" + ss : "" + ss);
		return dt;
	}

	

	public static final String getDate(Date date) {

		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd ");
		//
		// Calendar calendar = new GregorianCalendar(2013,1,28);
		// System.out.println("#1. " + sdf.format(calendar.getTime()));
		//
		// //update a date
		// calendar.set(Calendar.YEAR, calendar.YEAR);
		// calendar.set(Calendar.MONTH, Calendar.MONTH);
		// calendar.set(Calendar.DATE, Calendar.DATE);
		//
		// System.out.println( sdf.format(calendar.getTime()));
		//

		DateFormat dateFormat = new SimpleDateFormat("  dd MMM yyyy");
		Date date11 = new Date();
		String uniqueid = dateFormat.format(date11);

		// Calendar cal =
		// Calendar.getInstance(TimeZone.getTimeZone("GMT+5:30"));
		// cal.setTime(date);
		// int int_year = cal.get(Calendar.YEAR);
		// int int_month = cal.get(Calendar.MONTH) + 1;
		// int int_date = cal.get(Calendar.DATE);
		// Calendar calt =
		// Calendar.getInstance(TimeZone.getTimeZone("GMT+5:30"));
		// calt.setTime(new Date());
		// int int_hh = calt.get(Calendar.HOUR_OF_DAY);
		// int int_mm = calt.get(Calendar.MINUTE);
		// String str_dt = (int_date < 10 ? "0" + int_date : "" + int_date) +
		// "/"
		// + (int_month < 10 ? "0" + int_month : "" + int_month) + "/"
		// + int_year ;
		return uniqueid;
	}

	public static String[] swapelement(String[] data, int dataa, int datab) {
		String[] fdata = data;

		String firststring = data[dataa];
		String secondstring = data[datab];
		fdata[dataa] = secondstring;
		fdata[datab] = firststring;

		return fdata;

	}

	public static Integer[] swapelementimage(Integer[] data, int dataa,
			int datab) {
		Integer[] fdata = data;

		Integer firststring = data[dataa];
		Integer secondstring = data[datab];
		fdata[dataa] = secondstring;
		fdata[datab] = firststring;

		return fdata;

	}

	public static String[] split(String strData, String strExp) {
		String str_arrTemp[] = null;
		int int_k = 0;
		int int_sInd = 0;
		int int_eInd = strData.indexOf(strExp);

		while (int_eInd != -1) {
			int_sInd = int_eInd + 1;
			int_eInd = strData.indexOf(strExp, int_sInd);
			int_k++;
		}
		if (!strExp.equals("$")) {
			int_k += 1;
		}
		int_sInd = 0;
		int_eInd = strData.indexOf(strExp);
		str_arrTemp = new String[int_k];

		int_k = 0;
		while (int_eInd != -1) {
			str_arrTemp[int_k++] = strData.substring(int_sInd, int_eInd);
			int_sInd = int_eInd + 1;
			int_eInd = strData.indexOf(strExp, int_sInd);
		}
		if (!strExp.equals("$")) {
			str_arrTemp[int_k] = strData.substring(int_sInd, strData.length());
		}

		return str_arrTemp;
	}
	public static void showTempAlertActivityFinish(final Context context,
			String message) {
		AlertDialog.Builder alertbox = new AlertDialog.Builder(context);
		alertbox.setCancelable(false);
		alertbox.setMessage(message).setPositiveButton("OK",
				new OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
						((Activity) context).finish();
					}
				});
		alertbox.create();
		alertbox.show();
	}
	public static ProgressDialog progressDialog1(Context context) {
		// setup dialog here
		ProgressDialog dialog = new ProgressDialog(context);
		dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		dialog.setMessage("Please wait...");
		dialog.setCancelable(false);
		dialog.show();
		return dialog;
	}
	public static void hideKeyboard(EditText et) {
		et.setFocusable(false);
		et.setFocusableInTouchMode(false);
		et.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				v.setFocusable(true);
				v.setFocusableInTouchMode(true);
				return false;
			}
		});
	}
}
