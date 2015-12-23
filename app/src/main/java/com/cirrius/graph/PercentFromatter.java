package com.cirrius.graph;

import java.text.DecimalFormat;

import com.github.mikephil.charting.utils.ValueFormatter;

public class PercentFromatter {
	public class PercentFormatter implements ValueFormatter {

		protected DecimalFormat mFormat;

		public PercentFormatter() {
			mFormat = new DecimalFormat("###,###,##0");
		}

		@Override
		public String getFormattedValue(float value) {
			return mFormat.format(value) + "";
		}
	}

}
