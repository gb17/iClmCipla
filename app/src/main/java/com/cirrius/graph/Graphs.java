package com.cirrius.graph;

import java.text.NumberFormat;
import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.Legend.LegendForm;
import com.github.mikephil.charting.components.Legend.LegendPosition;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.XAxis.XAxisPosition;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.components.YAxis.AxisDependency;
import com.github.mikephil.charting.components.YAxis.YAxisLabelPosition;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.PercentFormatter;
import com.github.mikephil.charting.utils.ValueFormatter;

public class Graphs {
	protected String[] mMonths = new String[] { "C-FIX", "DEW PILL",
			"Acenomoral", "DEMPHY", "May", "Jun", "Jul", "Aug", "Sep", "Okt",
			"Nov", "Dec" };

	protected String[] mParties = new String[] { "Leaves", "TOT Days",
			"JW days", "Individual days", "Party E", "Party F", "Party G",
			"Party H", "Party I", "Party J", "Party K", "Party L", "Party M",
			"Party N", "Party O", "Party P", "Party Q", "Party R", "Party S",
			"Party T", "Party U", "Party V", "Party W", "Party X", "Party Y",
			"Party Z" };
	protected String[] mPartiesPre3 = new String[] { "Acenomorol",
			"Competitor1", "Competitor2" };
	protected String[] mPartiesPre1 = new String[] { "C-FIX", "Competitor1",
			"Competitor2" };
	protected String[] mPartiesPre2 = new String[] { "Demphi", "Competitor1",
			"Competitor2", "Competitor3" };
	protected String[] mPartiesPre4 = new String[] { "Dew Pill", "Competitor1",
			"Competitor2" };

	Context context;

	public Graphs(Context context) {
		this.context = context;
	}

	public BarChart StackedBarChart(int mode) {

		BarChart mChart = new BarChart(context);
		// mChart.setOnChartValueSelectedListener(context);

		mChart.setDescription("");
		mChart.setY(30);

		// if more than 60 entries are displayed in the chart, no values will be
		// drawn
		mChart.setMaxVisibleValueCount(60);

		mChart.setDrawGridBackground(false);

		// scaling can now only be done on x- and y-axis separately
		mChart.setPinchZoom(false);

		mChart.setDrawGridBackground(false);
		mChart.setDrawBarShadow(false);

		mChart.setDrawValueAboveBar(false);

		// change the position of the y-labels
		YAxis yLabels = mChart.getAxisLeft();
		yLabels.setValueFormatter(new MyValueFormatter());
		mChart.getAxisRight().setEnabled(false);

		XAxis xLabels = mChart.getXAxis();
		xLabels.setPosition(XAxisPosition.TOP);

		XAxis xAxis = mChart.getXAxis();
		xAxis.setPosition(XAxisPosition.BOTTOM);
		xAxis.setLabelsToSkip(0);

		xAxis.setDrawGridLines(false);
		xAxis.setSpaceBetweenLabels(10);

		ValueFormatter custom = new MyValueFormatter();

		YAxis leftAxis = mChart.getAxisLeft();

		leftAxis.setDrawGridLines(false);

		leftAxis.setLabelCount(8, false);
		leftAxis.setValueFormatter(new ValueFormatter() {

			@Override
			public String getFormattedValue(float value) {
				// TODO Auto-generated method stub
				NumberFormat nf = NumberFormat.getInstance();
				nf.setMinimumFractionDigits(0);

				String sd = nf.format(value);
				return sd.substring(0, sd.length());
			}
		});

		leftAxis.setSpaceTop(15f);

		// mChart.setDrawXLabels(false);
		// mChart.setDrawYLabels(false);

		// setting data

		setdattostacked(4, 100, mChart, mode);

		Legend l = mChart.getLegend();
		l.setPosition(LegendPosition.BELOW_CHART_CENTER);
		l.setFormSize(15f);
		l.setFormToTextSpace(4f);
		l.setYEntrySpace(10f);
		l.setTextSize(15f);
		return mChart;
	}

	float[][] seekdata = { { 100, 80, 20 }, { 50, 90, 10 }, { 30, 45, 15 },
			{ 67, 80, 10 } };
	String[] sekSdata = { "Abstact", "News", "Video", "Feeds" };

	float[][] seekdata1 = { { 100, 200 }, { 350, 400 }, { 50, 200 }, { 67, 80 } };
	String[] sekSdata1 = { "Aceno", "Mezzo", "Solsuna", "C-FIX" };

	public void setdattostacked(long mSeekBarX, long mSeekBarY,
			BarChart mChart, int mode) {

		ArrayList<String> xVals = new ArrayList<String>();
		for (int i = 0; i < mSeekBarX; i++) {
			// xVals.add(mMonths[i % mMonths.length]);
			if (mode == 2) {
				xVals.add(sekSdata1[i]);
			} else {
				xVals.add(sekSdata[i]);
			}
		}

		ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();

		for (int i = 0; i < mSeekBarX; i++) {
			// float mult = (mSeekBarY + 1);
			// float val1 = (float) (Math.random() * mult) + mult / 3;
			// float val2 = (float) (Math.random() * mult) + mult / 3;
			// float val3 = (float) (Math.random() * mult) + mult / 3;

			// yVals1.add(new BarEntry(new float[] { val1, val2 }, i));
			if (mode == 2) {
				yVals1.add(new BarEntry(seekdata1[i], i));
			} else {
				yVals1.add(new BarEntry(seekdata[i], i));
			}
		}

		BarDataSet set1 = new BarDataSet(yVals1, " ");

		if (mode == 1) {
			set1.setColors(getColors(3));
			// set1.setStackLabels(null);
			set1.setStackLabels(new String[] { "Cardio", "Gynaec", "Derma" });
		} else {
			set1.setColors(getColors(2));
			set1.setStackLabels(new String[] { "Own", "Competitor" });
		}
		ArrayList<BarDataSet> dataSets = new ArrayList<BarDataSet>();
		dataSets.add(set1);

		BarData data = new BarData(xVals, dataSets);
		data.setValueTextSize(10f);
		data.setValueFormatter(new MyValueFormatter());

		mChart.setData(data);
		for (DataSet<?> set : mChart.getData().getDataSets())
			set.setDrawValues(!set.isDrawValuesEnabled());

		mChart.invalidate();

	}

	public BarChart multibarchart(String title, String title2, String title3,
			String title4, String L_title, String L_title2, String L_title3,
			String L_title4, int mode) {
		BarChart chart = new BarChart(context);
		chart.setDrawGridBackground(false);

		chart.setBackgroundColor(Color.WHITE);
		chart.setPinchZoom(false);
		chart.setDescription("");
		chart.setOnTouchListener(null);
		chart.setY(40f);
		chart.setX(20f);

		ArrayList<String> xVals = new ArrayList<String>();
		if (title.equals("")) {
			if (mode == 3 || mode == 5) {
				xVals.add("Content");
				xVals.add("Abstract");
				xVals.add("Reference");
				xVals.add("Video ");
			} else if (mode == 4) {
				xVals.add("Content");
				xVals.add("Video");
				xVals.add("Events");
				xVals.add("Feed ");
			}

			else {
				xVals.add("Cardio");
				xVals.add("Derma");
				xVals.add("Gp");
				xVals.add(" ");
			}

		} else {
			xVals.add(title);
			xVals.add(title2);
			xVals.add(title3);
			xVals.add(title4);

		}

		ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();
		ArrayList<BarEntry> yVals2 = new ArrayList<BarEntry>();
		ArrayList<BarEntry> yVals3 = new ArrayList<BarEntry>();
		ArrayList<BarEntry> yVals4 = new ArrayList<BarEntry>();
		if (mode == 2) {
			yVals1.add(new BarEntry(10, 0));
			yVals1.add(new BarEntry(5, 1));
			yVals1.add(new BarEntry(0, 2));
			yVals1.add(new BarEntry(0, 3));

			yVals2.add(new BarEntry(5, 0));
			yVals2.add(new BarEntry(2, 1));
			yVals2.add(new BarEntry(0, 2));
			yVals2.add(new BarEntry(0, 3));

			yVals3.add(new BarEntry(2, 0));
			yVals3.add(new BarEntry(0, 1));
			yVals3.add(new BarEntry(3, 2));
			yVals3.add(new BarEntry(0, 3));

			yVals4.add(new BarEntry(5, 0));
			yVals4.add(new BarEntry(6, 1));
			yVals4.add(new BarEntry(8, 2));
			yVals4.add(new BarEntry(0, 3));
		} else if (mode == 3) {
			yVals1.add(new BarEntry(4, 0));
			yVals1.add(new BarEntry(6, 1));
			yVals1.add(new BarEntry(1, 2));
			yVals1.add(new BarEntry(7, 3));

			yVals2.add(new BarEntry(5, 0));
			yVals2.add(new BarEntry(10, 1));
			yVals2.add(new BarEntry(5, 2));
			yVals2.add(new BarEntry(4, 3));

			yVals3.add(new BarEntry(3, 0));
			yVals3.add(new BarEntry(5, 1));
			yVals3.add(new BarEntry(6, 2));
			yVals3.add(new BarEntry(10, 3));

			yVals4.add(new BarEntry(0, 0));
			yVals4.add(new BarEntry(0, 1));
			yVals4.add(new BarEntry(0, 2));
			yVals4.add(new BarEntry(0, 3));
		} else if (mode == 4) {
			yVals1.add(new BarEntry(5, 0));
			yVals1.add(new BarEntry(10, 1));
			yVals1.add(new BarEntry(5, 2));
			yVals1.add(new BarEntry(15, 3));

			yVals2.add(new BarEntry(20, 0));
			yVals2.add(new BarEntry(50, 1));
			yVals2.add(new BarEntry(30, 2));
			yVals2.add(new BarEntry(40, 3));

			yVals3.add(new BarEntry(2, 0));
			yVals3.add(new BarEntry(0, 1));
			yVals3.add(new BarEntry(1, 2));
			yVals3.add(new BarEntry(20, 3));

			yVals4.add(new BarEntry(3, 0));
			yVals4.add(new BarEntry(3, 1));
			yVals4.add(new BarEntry(2, 2));
			yVals4.add(new BarEntry(2, 3));
		} else if (mode == 5) {
			yVals1.add(new BarEntry(92, 0));
			yVals1.add(new BarEntry(36, 1));
			yVals1.add(new BarEntry(43, 2));
			yVals1.add(new BarEntry(15, 3));

			yVals2.add(new BarEntry(68, 0));
			yVals2.add(new BarEntry(60, 1));
			yVals2.add(new BarEntry(92, 2));
			yVals2.add(new BarEntry(40, 3));

			yVals3.add(new BarEntry(96, 0));
			yVals3.add(new BarEntry(87, 1));
			yVals3.add(new BarEntry(51, 2));
			yVals3.add(new BarEntry(20, 3));

			yVals4.add(new BarEntry(98, 0));
			yVals4.add(new BarEntry(99, 1));
			yVals4.add(new BarEntry(32, 2));
			yVals4.add(new BarEntry(2, 3));
		} else if (mode == 6) {
			yVals1.add(new BarEntry(5, 0));
			yVals1.add(new BarEntry(20, 1));
			yVals1.add(new BarEntry(2, 2));
			yVals1.add(new BarEntry(15, 3));

			yVals2.add(new BarEntry(10, 0));
			yVals2.add(new BarEntry(50, 1));
			yVals2.add(new BarEntry(0, 2));
			yVals2.add(new BarEntry(40, 3));

			yVals3.add(new BarEntry(5, 0));
			yVals3.add(new BarEntry(30, 1));
			yVals3.add(new BarEntry(1, 2));
			yVals3.add(new BarEntry(30, 3));

			yVals4.add(new BarEntry(0, 0));
			yVals4.add(new BarEntry(0, 1));
			yVals4.add(new BarEntry(0, 2));
			yVals4.add(new BarEntry(0, 3));
		} else {
			yVals1.add(new BarEntry(95, 0));
			yVals1.add(new BarEntry(60, 1));
			yVals1.add(new BarEntry(30, 2));
			yVals1.add(new BarEntry(0, 3));

			yVals2.add(new BarEntry(50, 0));
			yVals2.add(new BarEntry(65, 1));
			yVals2.add(new BarEntry(50, 2));
			yVals2.add(new BarEntry(0, 3));

			yVals3.add(new BarEntry(70, 0));
			yVals3.add(new BarEntry(80, 1));
			yVals3.add(new BarEntry(70, 2));
			yVals3.add(new BarEntry(null, 3));

			yVals4.add(new BarEntry(40, 0));
			yVals4.add(new BarEntry(63, 1));
			yVals4.add(new BarEntry(55, 2));
			yVals4.add(new BarEntry(null, 3));
		}

		XAxis xAxis = chart.getXAxis();
		xAxis.setPosition(XAxisPosition.BOTTOM);
		xAxis.setTextSize(13f);
		xAxis.setTextColor(Color.parseColor("#949494"));

		xAxis.setDrawGridLines(false);

		YAxis leftAxis = chart.getAxisLeft();
		chart.getAxisRight().setDrawGridLines(false);
		// leftAxis.setPosition(YAxisLabelPosition.OUTSIDE_CHART);
		leftAxis.setDrawGridLines(false);
		chart.getAxisRight().setEnabled(false);

		leftAxis.setEnabled(false);
		// create 3 datasets with different types
		BarDataSet set1 = null;
		BarDataSet set2 = null;

		BarDataSet set3 = null;

		BarDataSet set4 = null;

		if (L_title.equals("")) {

			if (mode == 2) {
				set1 = new BarDataSet(yVals1, "Likes");
				set1.setColor(Color.parseColor("#ffc107"));
				set2 = new BarDataSet(yVals2, "Dis likes");
				set2.setColor(Color.parseColor("#039be5"));
				set3 = new BarDataSet(yVals3, "Annotations");
				set3.setColor(Color.parseColor("#00e676"));

				set4 = new BarDataSet(yVals4, "Emails");
				set4.setColor(Color.parseColor("#283593"));
			} else {
				set1 = new BarDataSet(yVals1, "Acenomorol");
				set1.setColor(Color.parseColor("#ffc107"));
				set2 = new BarDataSet(yVals2, "Mezzo Drop");
				set2.setColor(Color.parseColor("#039be5"));
				set3 = new BarDataSet(yVals3, "Solsuna");
				set3.setColor(Color.parseColor("#00e676"));

				set4 = new BarDataSet(yVals4, "Fade Pill");
				set4.setColor(Color.parseColor("#283593"));
			}
		} else {
			set1 = new BarDataSet(yVals1, L_title);
			set1.setColor(Color.parseColor("#ffc107"));
			set2 = new BarDataSet(yVals2, L_title2);
			set2.setColor(Color.parseColor("#039be5"));
			set3 = new BarDataSet(yVals3, L_title3);
			set3.setColor(Color.parseColor("#00e676"));

			set4 = new BarDataSet(yVals4, L_title3);
			set4.setColor(Color.parseColor("#283593"));
		}
		// set1.setColors(ColorTemplate.createColors(getApplicationContext(),
		// ColorTemplate.FRESH_COLORS));

		ArrayList<BarDataSet> dataSets = new ArrayList<BarDataSet>();
		dataSets.add(set1);
		dataSets.add(set2);
		dataSets.add(set3);
		dataSets.add(set4);

		BarData data = new BarData(xVals, dataSets);
		data.setValueTextSize(10f);

		// define an offset to change the original position of the marker
		// (optional)
		// mv.setOffsets(-mv.getMeasuredWidth() / 2, -mv.getMeasuredHeight());

		// set the maker to the chart

		// data.setValueFormatter(new LargeValueFormatter());

		// add space between the dataset groups in percent of bar-width
		data.setGroupSpace(80f);
		chart.setPinchZoom(false);

		// data.setValueTypeface(mTf);

		chart.setData(data);
		chart.invalidate();

		chart.animateY(6000);

		Legend l = chart.getLegend();
		l.setPosition(LegendPosition.BELOW_CHART_LEFT);

		// l.setYOffset(0f);
		// l.setFormSize(20f);
		// l.setFormToTextSpace(2f);
		// l.setYEntrySpace(10f);
		// l.setXEntrySpace(15f);
		l.setTextSize(10f);

		return chart;
	}

	private int[] getColors() {

		int stacksize = 2;

		// have as many colors as stack-values per entry
		int[] colors = new int[stacksize];

		int[] VORDIPLOM_COLORS = { Color.parseColor("#f4511e"),
				Color.parseColor("#039be5") };

		for (int i = 0; i < stacksize; i++) {
			colors[i] = VORDIPLOM_COLORS[i];
		}

		return colors;
	}

	private int[] getColors(int nomber) {

		// have as many colors as stack-values per entry
		int[] colors = new int[nomber];

		int[] VORDIPLOM_COLORS = { Color.parseColor("#e88472"),
				Color.parseColor("#b0e0e6"), Color.parseColor("#cccccc") };

		for (int i = 0; i < nomber; i++) {
			colors[i] = VORDIPLOM_COLORS[i];
		}

		return colors;
	}

	public PieChart piechart() {
		PieChart mChart = new PieChart(context);
		mChart.setUsePercentValues(false);
		mChart.setDescription("");

		mChart.setDragDecelerationFrictionCoef(0.95f);

		Typeface tf = Typeface.createFromAsset(context.getAssets(),
				"OpenSans-Regular.ttf");

		mChart.setCenterTextTypeface(Typeface.createFromAsset(
				context.getAssets(), "OpenSans-Light.ttf"));

		mChart.setDrawHoleEnabled(true);
		mChart.setHoleColorTransparent(true);

		mChart.setTransparentCircleColor(Color.WHITE);
		mChart.setTransparentCircleAlpha(110);

		mChart.setHoleRadius(58f);
		mChart.setTransparentCircleRadius(61f);

		mChart.setDrawCenterText(true);

		mChart.setRotationAngle(0);
		// enable rotation of the chart by touch
		mChart.setRotationEnabled(true);

		// mChart.setUnit(" €");
		// mChart.setDrawUnitsInChart(true);

		// add a selection listener
		// mChart.setOnChartValueSelectedListener(l)

		// mChart.setCenterText("MPAndroidChart\nby Philipp Jahoda");

		setData(3, 100, mChart);

		mChart.animateY(1500, Easing.EasingOption.EaseInOutQuad);
		// mChart.spin(2000, 0, 360);

		Legend l = mChart.getLegend();
		l.setPosition(LegendPosition.BELOW_CHART_CENTER);

		l.setYOffset(0f);
		l.setFormSize(12f);
		l.setFormToTextSpace(2f);
		l.setYEntrySpace(10f);

		return mChart;

	}

	public PieChart piechartPre(int index) {
		PieChart mChart = new PieChart(context);
		mChart.setUsePercentValues(false);
		mChart.setDescription("");

		mChart.setDragDecelerationFrictionCoef(0.95f);

		Typeface tf = Typeface.createFromAsset(context.getAssets(),
				"OpenSans-Regular.ttf");

		mChart.setCenterTextTypeface(Typeface.createFromAsset(
				context.getAssets(), "OpenSans-Light.ttf"));

		mChart.setDrawHoleEnabled(true);
		mChart.setHoleColorTransparent(true);

		mChart.setTransparentCircleColor(Color.WHITE);
		mChart.setTransparentCircleAlpha(110);

		mChart.setHoleRadius(58f);
		mChart.setTransparentCircleRadius(61f);

		mChart.setDrawCenterText(true);

		mChart.setRotationAngle(0);
		// enable rotation of the chart by touch
		mChart.setRotationEnabled(true);

		setDataPre(index, 2, 100, mChart);

		mChart.animateY(1500, Easing.EasingOption.EaseInOutQuad);
		// mChart.spin(2000, 0, 360);

		Legend l = mChart.getLegend();
		l.setPosition(LegendPosition.BELOW_CHART_CENTER);

		l.setYOffset(0f);
		l.setFormSize(12f);
		l.setFormToTextSpace(2f);
		l.setYEntrySpace(10f);

		return mChart;

	}

	private void setData(int count, float range, PieChart mChart) {

		float mult = range;

		Typeface tf = Typeface.createFromAsset(context.getAssets(),
				"OpenSans-Regular.ttf");

		ArrayList<Entry> yVals1 = new ArrayList<Entry>();

		// IMPORTANT: In a PieChart, no values (Entry) should have the same
		// xIndex (even if from different DataSets), since no values can be
		// drawn above each other.
		for (int i = 0; i < count + 1; i++) {
			yVals1.add(new Entry((float) (Math.random() * mult) + mult / 5, i));
		}

		ArrayList<String> xVals = new ArrayList<String>();

		for (int i = 0; i < count + 1; i++)
			xVals.add(mParties[i % mParties.length]);

		PieDataSet dataSet = new PieDataSet(yVals1, "");
		dataSet.setSliceSpace(3f);
		dataSet.setSelectionShift(5f);

		// add a lot of colors

		ArrayList<Integer> colors = new ArrayList<Integer>();

		for (int c : ColorTemplate.VORDIPLOM_COLORS)
			colors.add(c);

		for (int c : ColorTemplate.JOYFUL_COLORS)
			colors.add(c);

		for (int c : ColorTemplate.COLORFUL_COLORS)
			colors.add(c);

		for (int c : ColorTemplate.LIBERTY_COLORS)
			colors.add(c);

		for (int c : ColorTemplate.PASTEL_COLORS)
			colors.add(c);

		colors.add(ColorTemplate.getHoloBlue());

		dataSet.setColors(colors);

		PieData data = new PieData(xVals, dataSet);
		data.setValueFormatter(new PercentFormatter());
		data.setValueTextSize(11f);
		data.setValueTextColor(Color.WHITE);
		data.setValueTypeface(tf);
		mChart.setData(data);

		// undo all highlights
		mChart.highlightValues(null);
		mChart.setDrawHoleEnabled(false);

		mChart.invalidate();
	}

	private void setDataPre(int index, int count, float range, PieChart mChart) {

		float mult = range;

		Typeface tf = Typeface.createFromAsset(context.getAssets(),
				"OpenSans-Regular.ttf");

		ArrayList<Entry> yVals1 = new ArrayList<Entry>();

		// IMPORTANT: In a PieChart, no values (Entry) should have the same
		// xIndex (even if from different DataSets), since no values can be
		// drawn above each other.
		for (int i = 0; i < count + 1; i++) {
			yVals1.add(new Entry((float) (Math.random() * mult) + mult / 5, i));
		}

		ArrayList<String> xVals = new ArrayList<String>();
		if (index == 1)
			for (int i = 0; i < count + 1; i++)
				xVals.add(mPartiesPre1[i % mPartiesPre1.length]);

		if (index == 2)
			for (int i = 0; i < count + 1; i++)
				xVals.add(mPartiesPre2[i % mPartiesPre2.length]);

		if (index == 3)
			for (int i = 0; i < count + 1; i++)
				xVals.add(mPartiesPre3[i % mPartiesPre3.length]);

		if (index == 4)
			for (int i = 0; i < count + 1; i++)
				xVals.add(mPartiesPre4[i % mPartiesPre4.length]);

		PieDataSet dataSet = new PieDataSet(yVals1, "");
		dataSet.setSliceSpace(3f);
		dataSet.setSelectionShift(5f);

		// add a lot of colors

		ArrayList<Integer> colors = new ArrayList<Integer>();

		for (int c : ColorTemplate.VORDIPLOM_COLORS)
			colors.add(c);

		for (int c : ColorTemplate.JOYFUL_COLORS)
			colors.add(c);

		for (int c : ColorTemplate.COLORFUL_COLORS)
			colors.add(c);

		for (int c : ColorTemplate.LIBERTY_COLORS)
			colors.add(c);

		for (int c : ColorTemplate.PASTEL_COLORS)
			colors.add(c);

		colors.add(ColorTemplate.getHoloBlue());

		dataSet.setColors(colors);

		PieData data = new PieData(xVals, dataSet);
		data.setValueFormatter(new PercentFormatter());
		data.setValueTextSize(11f);
		data.setValueTextColor(Color.WHITE);
		data.setValueTypeface(tf);
		mChart.setData(data);

		// undo all highlights
		mChart.highlightValues(null);
		mChart.setDrawHoleEnabled(false);

		mChart.invalidate();
	}

	public LineChart lineChart() {

		LineChart mChart = new LineChart(context);

		// no description text
		mChart.setDescription("");
		mChart.setNoDataTextDescription("You need to provide data for the chart.");

		// enable value highlighting
		mChart.setHighlightEnabled(true);

		// enable touch gestures
		mChart.setTouchEnabled(true);

		mChart.setDragDecelerationFrictionCoef(0.9f);

		// enable scaling and dragging
		mChart.setDragEnabled(true);
		mChart.setScaleEnabled(true);
		mChart.setDrawGridBackground(false);
		mChart.setHighlightPerDragEnabled(true);

		// if disabled, scaling can be done on x- and y-axis separately
		mChart.setPinchZoom(true);

		// set an alternative background color
		mChart.setBackgroundColor(Color.WHITE);

		// add data
		setDataline(20, 30, mChart);

		mChart.animateX(2500);

		Typeface tf = Typeface.createFromAsset(context.getAssets(),
				"OpenSans-Regular.ttf");

		// get the legend (only possible after setting data)
		Legend l = mChart.getLegend();

		// modify the legend ...
		// l.setPosition(LegendPosition.LEFT_OF_CHART);
		l.setForm(LegendForm.LINE);
		l.setTypeface(tf);
		l.setTextSize(11f);
		l.setTextColor(Color.BLACK);
		l.setPosition(LegendPosition.BELOW_CHART_LEFT);
		// l.setYOffset(11f);

		XAxis xAxis = mChart.getXAxis();
		xAxis.setTypeface(tf);
		xAxis.setTextSize(12f);
		xAxis.setTextColor(Color.WHITE);
		xAxis.setDrawGridLines(false);
		xAxis.setDrawAxisLine(false);
		xAxis.setSpaceBetweenLabels(1);

		YAxis leftAxis = mChart.getAxisLeft();
		leftAxis.setTypeface(tf);
		leftAxis.setTextColor(ColorTemplate.getHoloBlue());
		leftAxis.setAxisMaxValue(200f);
		leftAxis.setDrawGridLines(true);

		YAxis rightAxis = mChart.getAxisRight();
		rightAxis.setTypeface(tf);
		rightAxis.setTextColor(Color.RED);
		rightAxis.setAxisMaxValue(900);
		rightAxis.setStartAtZero(false);
		rightAxis.setAxisMinValue(-200);
		rightAxis.setDrawGridLines(false);
		return mChart;
	}

	void setdatforline(LineChart mChart) {
		int[] mColors = new int[] { ColorTemplate.VORDIPLOM_COLORS[0],
				ColorTemplate.VORDIPLOM_COLORS[1],
				ColorTemplate.VORDIPLOM_COLORS[2] };
		mChart.resetTracking();

		ArrayList<String> xVals = new ArrayList<String>();
		for (int i = 0; i < 20; i++) {
			xVals.add((i) + "");
		}

		ArrayList<LineDataSet> dataSets = new ArrayList<LineDataSet>();

		for (int z = 0; z < 3; z++) {

			ArrayList<Entry> values = new ArrayList<Entry>();

			for (int i = 0; i < 20; i++) {
				double val = (Math.random() * 100) + 3;
				values.add(new Entry((float) val, i));
			}

			LineDataSet d = new LineDataSet(values, "DataSet " + (z + 1));
			d.setLineWidth(2.5f);
			d.setCircleSize(4f);

			int color = mColors[z % mColors.length];
			d.setColor(color);
			d.setCircleColor(color);
			dataSets.add(d);
		}

		// make the first DataSet dashed
		dataSets.get(0).enableDashedLine(10, 10, 0);
		dataSets.get(0).setColors(ColorTemplate.VORDIPLOM_COLORS);
		dataSets.get(0).setCircleColors(ColorTemplate.VORDIPLOM_COLORS);

		LineData data = new LineData(xVals, dataSets);
		mChart.setData(data);
		mChart.animateX(2500);
		mChart.invalidate();

	}

	private void setDataline(int count, float range, LineChart mChart) {

		ArrayList<String> xVals = new ArrayList<String>();
		for (int i = 0; i < count; i++) {
			xVals.add((i) + "");
		}

		ArrayList<Entry> yVals1 = new ArrayList<Entry>();

		for (int i = 0; i < count; i++) {
			float mult = range / 2f;
			float val = (float) (Math.random() * mult) + 50;// + (float)
															// ((mult *
															// 0.1) / 10);
			yVals1.add(new Entry(val, i));
		}

		// create a dataset and give it a type
		LineDataSet set1 = new LineDataSet(yVals1, "DataSet 1");
		set1.setAxisDependency(AxisDependency.LEFT);
		set1.setColor(ColorTemplate.getHoloBlue());
		set1.setCircleColor(Color.WHITE);
		set1.setLineWidth(2f);
		set1.setCircleSize(3f);
		set1.setFillAlpha(65);
		set1.setFillColor(ColorTemplate.getHoloBlue());
		set1.setHighLightColor(Color.rgb(244, 117, 117));
		set1.setDrawCircleHole(false);
		// set1.setDrawHorizontalHighlightIndicator(false);
		// set1.setVisible(false);
		// set1.setCircleHoleColor(Color.WHITE);

		ArrayList<Entry> yVals2 = new ArrayList<Entry>();

		for (int i = 0; i < count; i++) {
			float mult = range;
			float val = (float) (Math.random() * mult) + 450;// + (float)
																// ((mult *
																// 0.1) / 10);
			yVals2.add(new Entry(val, i));
		}

		// create a dataset and give it a type
		LineDataSet set2 = new LineDataSet(yVals2, "DataSet 2");
		set2.setAxisDependency(AxisDependency.RIGHT);
		set2.setColor(Color.RED);
		set2.setCircleColor(Color.WHITE);
		set2.setLineWidth(2f);
		set2.setCircleSize(3f);
		set2.setFillAlpha(65);
		set2.setFillColor(Color.RED);
		set2.setDrawCircleHole(false);
		set2.setHighLightColor(Color.rgb(244, 117, 117));

		ArrayList<LineDataSet> dataSets = new ArrayList<LineDataSet>();
		dataSets.add(set2);
		dataSets.add(set1); // add the datasets

		// create a data object with the datasets
		LineData data = new LineData(xVals, dataSets);
		data.setValueTextColor(Color.WHITE);
		data.setValueTextSize(9f);

		// set data
		mChart.setData(data);
	}

	public BarChart multibarchart23() {

		Typeface mTf;
		mTf = Typeface.createFromAsset(context.getAssets(),
				"OpenSans-Regular.ttf");
		BarChart chart = new BarChart(context);
		chart.setDrawGridBackground(false);
		chart.setBackgroundColor(Color.WHITE);
		chart.setPinchZoom(false);
		chart.setDescription("");

		chart.setOnTouchListener(null);
		ArrayList<String> xVals = new ArrayList<String>();

		xVals.add("C-FIX");
		xVals.add("Mezzo Drop");
		xVals.add("10 Dew Jade");

		ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();
		ArrayList<BarEntry> yVals2 = new ArrayList<BarEntry>();
		ArrayList<BarEntry> yVals3 = new ArrayList<BarEntry>();

		float val = 10f;
		yVals1.add(new BarEntry(5, 0));
		yVals1.add(new BarEntry(7, 1));
		yVals1.add(new BarEntry(3, 2));

		float val1 = 5f;
		yVals2.add(new BarEntry(0, 2));
		yVals2.add(new BarEntry(7, 1));
		yVals2.add(new BarEntry(4, 0));

		float val2 = 9;
		yVals3.add(new BarEntry(3, 1));
		yVals3.add(new BarEntry(8, 0));
		yVals3.add(new BarEntry(1, 2));

		XAxis xAxis = chart.getXAxis();
		xAxis.setPosition(XAxisPosition.BOTTOM);
		xAxis.setTypeface(mTf);
		xAxis.setDrawGridLines(false);

		YAxis leftAxis = chart.getAxisLeft();
		chart.getAxisRight().setDrawGridLines(false);
		leftAxis.setPosition(YAxisLabelPosition.OUTSIDE_CHART);
		leftAxis.setDrawGridLines(false);

		// create 3 datasets with different types
		BarDataSet set1 = new BarDataSet(yVals1, "Downloaded Content");
		// set1.setColors(ColorTemplate.createColors(getApplicationContext(),
		// ColorTemplate.FRESH_COLORS));
		set1.setColor(Color.parseColor("#ffc107"));
		BarDataSet set2 = new BarDataSet(yVals2, "Query Raised");
		set2.setColor(Color.parseColor("#039be5"));
		BarDataSet set3 = new BarDataSet(yVals3, "Download Abstract");
		set3.setColor(Color.parseColor("#00e676"));

		ArrayList<BarDataSet> dataSets = new ArrayList<BarDataSet>();
		dataSets.add(set1);
		dataSets.add(set2);
		dataSets.add(set3);

		BarData data = new BarData(xVals, dataSets);
		data.setValueTextSize(10f);

		// define an offset to change the original position of the marker
		// (optional)
		// mv.setOffsets(-mv.getMeasuredWidth() / 2, -mv.getMeasuredHeight());

		// set the marker to the chart

		// data.setValueFormatter(new LargeValueFormatter());

		// add space between the dataset groups in percent of bar-width
		data.setGroupSpace(80f);
		chart.setPinchZoom(false);

		// data.setValueTypeface(mTf);

		chart.setData(data);
		chart.invalidate();

		chart.animateY(3000);

		return chart;

	}

	public BarChart getsinglebarchart(int mode) {

		Typeface mTf;
		mTf = Typeface.createFromAsset(context.getAssets(),
				"OpenSans-Regular.ttf");
		BarChart mChart = new BarChart(context);
		// mChart.setOnChartValueSelectedListener(this);

		mChart.setDrawBarShadow(false);
		mChart.setDrawValueAboveBar(true);

		mChart.setDescription("");

		mChart.invalidate();

		// if more than 60 entries are displayed in the chart, no values will be
		// drawn
		mChart.setMaxVisibleValueCount(60);

		// scaling can now only be done on x- and y-axis separately
		mChart.setPinchZoom(false);
		// mChart.animateX(10000);

		// draw shadows for each bar that show the maximum value
		// mChart.setDrawBarShadow(true);

		// mChart.setDrawXLabels(false);

		mChart.setDrawGridBackground(false);
		mChart.animateY(3000);
		// mChart.setDrawYLabels(false);

		XAxis xAxis = mChart.getXAxis();
		xAxis.setPosition(XAxisPosition.BOTTOM);
		xAxis.setTypeface(mTf);
		xAxis.setDrawGridLines(false);
		xAxis.setSpaceBetweenLabels(2);

		ValueFormatter custom = new MyValueFormatter();

		YAxis leftAxis = mChart.getAxisLeft();
		leftAxis.setTypeface(mTf);
		leftAxis.setLabelCount(8, false);
		leftAxis.setValueFormatter(custom);
		leftAxis.setPosition(YAxisLabelPosition.OUTSIDE_CHART);
		leftAxis.setSpaceTop(15f);
		leftAxis.setDrawGridLines(false);

		YAxis rightAxis = mChart.getAxisRight();
		rightAxis.setDrawGridLines(false);
		rightAxis.setTypeface(mTf);
		rightAxis.setLabelCount(8, false);
		rightAxis.setValueFormatter(custom);
		rightAxis.setSpaceTop(15f);

		Legend l = mChart.getLegend();
		l.setTextColor(Color.WHITE);
		l.setEnabled(false);
		l.setPosition(LegendPosition.BELOW_CHART_LEFT);
		l.setForm(LegendForm.SQUARE);
		l.setFormSize(9f);
		l.setTextSize(11f);
		l.setXEntrySpace(4f);

		// l.setExtra(ColorTemplate.VORDIPLOM_COLORS, new String[] { "abc",
		// "def", "ghj", "ikl", "mno" });
		// l.setCustom(ColorTemplate.VORDIPLOM_COLORS, new String[] { "abc",
		// "def", "ghj", "ikl", "mno" });

		setData99(3, 50, mChart);

		for (DataSet<?> set : mChart.getData().getDataSets())
			set.setDrawValues(!set.isDrawValuesEnabled());
		mChart.invalidate();
		return mChart;

		// setting data

	}

	public BarChart getsingleHorizontalbarchart(int mode) {

		Typeface mTf;
		mTf = Typeface.createFromAsset(context.getAssets(),
				"OpenSans-Regular.ttf");
		HorizontalBarChart mChart = new HorizontalBarChart(context);
		// mChart.setOnChartValueSelectedListener(this);

		mChart.setDrawBarShadow(false);
		mChart.setDrawValueAboveBar(true);

		mChart.setDescription("");
		mChart.setY(50f);
		mChart.invalidate();

		// if more than 60 entries are displayed in the chart, no values will be
		// drawn
		mChart.setMaxVisibleValueCount(60);

		// scaling can now only be done on x- and y-axis separately
		mChart.setPinchZoom(false);
		// mChart.animateX(10000);

		// draw shadows for each bar that show the maximum value
		// mChart.setDrawBarShadow(true);

		// mChart.setDrawXLabels(false);

		mChart.setDrawGridBackground(false);
		mChart.animateY(3000);
		// mChart.setDrawYLabels(false);

		XAxis xAxis = mChart.getXAxis();
		xAxis.setPosition(XAxisPosition.BOTTOM);
		xAxis.setTypeface(mTf);
		xAxis.setDrawGridLines(false);
		xAxis.setSpaceBetweenLabels(2);

		ValueFormatter custom = new MyValueFormatter();

		YAxis leftAxis = mChart.getAxisLeft();
		leftAxis.setTypeface(mTf);
		leftAxis.setLabelCount(6, false);
		leftAxis.setValueFormatter(custom);
		leftAxis.setPosition(YAxisLabelPosition.OUTSIDE_CHART);
		leftAxis.setSpaceTop(15f);
		leftAxis.setDrawGridLines(false);
		leftAxis.setEnabled(false);

		YAxis rightAxis = mChart.getAxisRight();
		rightAxis.setDrawGridLines(false);
		rightAxis.setTypeface(mTf);
		rightAxis.setLabelCount(6, false);
		rightAxis.setValueFormatter(custom);
		rightAxis.setSpaceTop(15f);
		rightAxis.setValueFormatter(new ValueFormatter() {

			@Override
			public String getFormattedValue(float value) {
				NumberFormat nf = NumberFormat.getInstance();
				nf.setMinimumFractionDigits(0);

				String sd = nf.format(value);
				return sd.substring(0, sd.length());
			}
		});

		Legend l = mChart.getLegend();
		l.setTextColor(Color.WHITE);
		l.setEnabled(false);
		l.setPosition(LegendPosition.BELOW_CHART_LEFT);
		l.setForm(LegendForm.SQUARE);
		l.setFormSize(9f);
		l.setTextSize(11f);
		l.setXEntrySpace(4f);

		// l.setExtra(ColorTemplate.VORDIPLOM_COLORS, new String[] { "abc",
		// "def", "ghj", "ikl", "mno" });
		// l.setCustom(ColorTemplate.VORDIPLOM_COLORS, new String[] { "abc",
		// "def", "ghj", "ikl", "mno" });

		setData99Hor(5, 50, mChart);

		for (DataSet<?> set : mChart.getData().getDataSets())
			set.setDrawValues(!set.isDrawValuesEnabled());
		mChart.invalidate();
		return mChart;

		// setting data

	}

	int[] singlebardata = { 10, 10, 80 };

	private void setData99(int count, float range, BarChart mChart) {

		ArrayList<String> xVals = new ArrayList<String>();
		for (int i = 0; i < count; i++) {
			xVals.add(xpie4[i]);
		}

		ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();

		for (int i = 0; i < count; i++) {
			// float mult = (range + 1);
			// float val = (float) (Math.random() * mult);
			yVals1.add(new BarEntry(singlebardata[i], i));
		}

		BarDataSet set1 = new BarDataSet(yVals1, "");
		set1.setBarSpacePercent(35f);

		ArrayList<BarDataSet> dataSets = new ArrayList<BarDataSet>();
		dataSets.add(set1);

		BarData data = new BarData(xVals, dataSets);
		// data.setValueFormatter(new MyValueFormatter());
		data.setValueTextSize(10f);

		mChart.setPinchZoom(false);
		// mChart.setDrawValueAboveBar(false);
		mChart.setData(data);
	}

	String[] xpieH4 = { "Radiation Therapy", "Stem Cell Therapy",
			"Immunotherapy", "Intravenous Therapy", "Chemotherapy" };

	int[] singlechartdataH4 = { 10, 20, 45, 60, 90 };

	private void setData99Hor(int count, float range, BarChart mChart) {

		ArrayList<String> xVals = new ArrayList<String>();
		for (int i = 0; i < count; i++) {
			xVals.add(xpieH4[i]);
		}

		ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();

		for (int i = 0; i < count; i++) {
			// float mult = (range + 1);
			// float val = (float) (Math.random() * mult);
			yVals1.add(new BarEntry(singlechartdataH4[i], i));
		}

		BarDataSet set1 = new BarDataSet(yVals1, "");
		set1.setBarSpacePercent(15f);

		ArrayList<BarDataSet> dataSets = new ArrayList<BarDataSet>();
		dataSets.add(set1);

		BarData data = new BarData(xVals, dataSets);
		// data.setValueFormatter(new MyValueFormatter());
		data.setValueTextSize(10f);

		mChart.setPinchZoom(false);
		// mChart.setDrawValueAboveBar(false);
		mChart.setData(data);
	}

	public BarChart multibarchart7888() {
		BarChart chart = new BarChart(context);
		chart.setDrawGridBackground(false);
		chart.setBackgroundColor(Color.WHITE);
		chart.setPinchZoom(false);
		chart.setDescription("");
		chart.setOnTouchListener(null);
		ArrayList<String> xVals = new ArrayList<String>();

		xVals.add("C-FIX");
		xVals.add("Mezzo Drop");
		xVals.add("10 Dew Jade");

		ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();
		ArrayList<BarEntry> yVals2 = new ArrayList<BarEntry>();
		ArrayList<BarEntry> yVals3 = new ArrayList<BarEntry>();

		float val = 10f;
		yVals1.add(new BarEntry(5, 0));
		yVals1.add(new BarEntry(7, 1));
		yVals1.add(new BarEntry(3, 2));

		float val1 = 5f;
		yVals2.add(new BarEntry(0, 2));
		yVals2.add(new BarEntry(7, 1));
		yVals2.add(new BarEntry(4, 0));

		float val2 = 9;
		yVals3.add(new BarEntry(3, 1));
		yVals3.add(new BarEntry(8, 0));
		yVals3.add(new BarEntry(1, 2));

		XAxis xAxis = chart.getXAxis();
		xAxis.setPosition(XAxisPosition.BOTTOM);

		xAxis.setDrawGridLines(false);

		YAxis leftAxis = chart.getAxisLeft();
		chart.getAxisRight().setDrawGridLines(false);
		leftAxis.setPosition(YAxisLabelPosition.OUTSIDE_CHART);
		leftAxis.setDrawGridLines(false);

		// create 3 datasets with different types
		BarDataSet set1 = new BarDataSet(yVals1, "Downloaded Content");
		// set1.setColors(ColorTemplate.createColors(getApplicationContext(),
		// ColorTemplate.FRESH_COLORS));
		set1.setColor(Color.parseColor("#ffc107"));
		BarDataSet set2 = new BarDataSet(yVals2, "Query Raised");
		set2.setColor(Color.parseColor("#039be5"));
		BarDataSet set3 = new BarDataSet(yVals3, "Download Abstract");
		set3.setColor(Color.parseColor("#00e676"));

		ArrayList<BarDataSet> dataSets = new ArrayList<BarDataSet>();
		dataSets.add(set1);
		dataSets.add(set2);
		dataSets.add(set3);

		BarData data = new BarData(xVals, dataSets);
		data.setValueTextSize(10f);

		// define an offset to change the original position of the marker
		// (optional)
		// mv.setOffsets(-mv.getMeasuredWidth() / 2, -mv.getMeasuredHeight());

		// set the marker to the chart

		// data.setValueFormatter(new LargeValueFormatter());

		// add space between the dataset groups in percent of bar-width
		data.setGroupSpace(80f);
		chart.setPinchZoom(false);

		// data.setValueTypeface(mTf);

		chart.setData(data);
		chart.invalidate();

		// chart.animateY(3000);

		return chart;

	}

	int[][] bardata = { { 82, 83, 75 }, { 70, 80, 90 }, { 60, 70, 80 } };
	float[][] bardata1 = { { 9, 9, 8.5f }, { 8.5f, 8, 6.7f },
			{ 9.3f, 7.4f, 8.5f } };
	int[][] bardata2 = { { 10, 5, 20 }, { 5, 10, 30 } };
	int[][] bardata3 = { { 24, 20, 22 }, { 15, 18, 10 } };
	int[][] bardata4 = { { 90, 90, 90 }, { 80, 75, 60 }, { 80, 90, 70 } };
	int[][] bardata5 = { { 1250, 1000, 1300 }, { 1000, 800, 1000 },
			{ 600, 900, 1500 } };
	int[][] bardata6 = { { 150, 130, 130 }, { 100, 120, 110 }, { 10, 15, 5 },
			{ 5, 3, 0 } };
	int[][] bardata7 = { { 5, 2, 3 }, { 2, -3, 5 } };
	int[][] bardata8 = { { 80, 70, 60 }, { 70, 60, 80 } };
	int[][] bardata9 = { { 100, 90, 130 }, { 150, 85, 112 }, { 200, 73, 78 } };

	int[][] bardata10 = { { 200, 350, 50 }, { 100, 400, 200 } };
	int[][] bardata17 = { { 100, 90, 80 }, { 50, 10, 20 } };
	int[][] bardata18 = { { 90, 60, 30 }, { 50, 65, 50 }, { 70, 80, 70 } };
	int[][] bardata20 = { { 90, 90, 10 }, { 80, 60, 20 }, { 50, 40, 50 } };
	int[][] bardata21 = { { 20, 50, 30 }, { 2, 0, 1 }, { 15, 40, 50 } };

	String[] xbardata = { "JAN", "FEB", "MAR", "APR" };
	String[] xbardata1 = { "Cardio", "Derma", "GP" };

	int[][] bardata22 = { { 5000, 10000 }, { 7000, 15000 } };
	int[][] bardata23 = { { 2000, 15000 }, { 5000, 12000 } };
	String[] xbardata2 = { "Expenses", "Business", };

	public BarChart drawNbarchart(int countmaxthree, String[] ast, int mode,
			int barnumbers) {
		ArrayList<BarDataSet> dataSets = null;
		Typeface mTf;
		mTf = Typeface.createFromAsset(context.getAssets(),
				"OpenSans-Regular.ttf");
		BarChart mChart = new BarChart(context);

		// mChart.getAxisLeft().setDrawLabels(false);
		// mChart.getAxisRight().setDrawLabels(false);
		// mChart.getXAxis().setDrawLabels(false);
		mChart.setBackgroundColor(Color.TRANSPARENT);
		mChart.setDrawBarShadow(false);
		mChart.setDrawValueAboveBar(true);
		mChart.getAxisRight().setDrawGridLines(false);

		mChart.setDescription("");

		mChart.invalidate();
		mChart.setX(20f);
		mChart.setY(45f);

		mChart.setMaxVisibleValueCount(60);

		mChart.setTouchEnabled(false);
		mChart.setPinchZoom(false);
		mChart.setGridBackgroundColor(Color.TRANSPARENT);

		mChart.setDrawGridBackground(false);
		mChart.animateY(1000);

		ArrayList<BarEntry> valueSet1 = new ArrayList<>();
		ArrayList<BarEntry> valueSet2 = new ArrayList<>();
		ArrayList<BarEntry> valueSet3 = new ArrayList<>();
		ArrayList<String> xAxis = new ArrayList<>();

		for (int i = 0; i < barnumbers; i++) {
			if (mode == 18 || mode == 20) {
				xAxis.add(i, xbardata1[i]);
			} else if (mode == 22 || mode == 23) {
				xAxis.add(i, xbardata2[i]);
			}

			else {
				xAxis.add(i, xbardata[i]);
			}
		}

		for (int i = 0; i < barnumbers; i++) {
			if (mode == 1) {
				valueSet1.add(new BarEntry(bardata1[0][i], i));
				valueSet2.add(new BarEntry(bardata1[1][i], i));
				if (countmaxthree > 2)
					valueSet3.add(new BarEntry(bardata1[2][i], i));
			} else if (mode == 2) {
				valueSet1.add(new BarEntry(bardata2[0][i], i));
				valueSet2.add(new BarEntry(bardata2[1][i], i));
				if (countmaxthree > 2)
					valueSet3.add(new BarEntry(bardata2[2][i], i));
			} else if (mode == 3) {
				valueSet1.add(new BarEntry(bardata3[0][i], i));
				valueSet2.add(new BarEntry(bardata3[1][i], i));
				if (countmaxthree > 2)
					valueSet3.add(new BarEntry(bardata3[2][i], i));
			} else if (mode == 4) {
				valueSet1.add(new BarEntry(bardata4[0][i], i));
				valueSet2.add(new BarEntry(bardata4[1][i], i));
				if (countmaxthree > 2)
					valueSet3.add(new BarEntry(bardata4[2][i], i));
			} else if (mode == 5) {
				valueSet1.add(new BarEntry(bardata5[0][i], i));
				valueSet2.add(new BarEntry(bardata5[1][i], i));
				if (countmaxthree > 2)
					valueSet3.add(new BarEntry(bardata5[2][i], i));
			} else if (mode == 6) {
				valueSet1.add(new BarEntry(bardata6[0][i], i));
				valueSet2.add(new BarEntry(bardata6[1][i], i));
				if (countmaxthree > 2)
					valueSet3.add(new BarEntry(bardata6[2][i], i));
			} else if (mode == 7) {
				valueSet1.add(new BarEntry(bardata7[0][i], i));
				valueSet2.add(new BarEntry(bardata7[1][i], i));
				if (countmaxthree > 2)
					valueSet3.add(new BarEntry(bardata7[2][i], i));
			} else if (mode == 8) {
				valueSet1.add(new BarEntry(bardata8[0][i], i));
				valueSet2.add(new BarEntry(bardata8[1][i], i));
				if (countmaxthree > 2)
					valueSet3.add(new BarEntry(bardata8[2][i], i));
			} else if (mode == 9) {
				valueSet1.add(new BarEntry(bardata9[0][i], i));
				valueSet2.add(new BarEntry(bardata9[1][i], i));

				valueSet3.add(new BarEntry(bardata9[2][i], i));
			}

			else if (mode == 10) {
				valueSet1.add(new BarEntry(bardata10[0][i], i));
				valueSet2.add(new BarEntry(bardata10[1][i], i));

			} else if (mode == 17) {
				valueSet1.add(new BarEntry(bardata17[0][i], i));
				valueSet2.add(new BarEntry(bardata17[1][i], i));

			} else if (mode == 18) {
				valueSet1.add(new BarEntry(bardata18[0][i], i));
				valueSet2.add(new BarEntry(bardata18[1][i], i));
				valueSet3.add(new BarEntry(bardata18[2][i], i));

			} else if (mode == 20) {
				valueSet1.add(new BarEntry(bardata20[0][i], i));
				valueSet2.add(new BarEntry(bardata20[1][i], i));
				valueSet3.add(new BarEntry(bardata20[2][i], i));

			} else if (mode == 21) {
				valueSet1.add(new BarEntry(bardata21[0][i], i));
				valueSet2.add(new BarEntry(bardata21[1][i], i));
				valueSet3.add(new BarEntry(bardata21[2][i], i));

			} else if (mode == 22) {
				valueSet1.add(new BarEntry(bardata22[0][i], i));
				valueSet2.add(new BarEntry(bardata22[1][i], i));

			} else if (mode == 23) {
				valueSet1.add(new BarEntry(bardata23[0][i], i));
				valueSet2.add(new BarEntry(bardata23[1][i], i));

			}

			else {
				valueSet1.add(new BarEntry(bardata[0][i], i));
				valueSet2.add(new BarEntry(bardata[1][i], i));
				if (countmaxthree > 2)
					valueSet3.add(new BarEntry(bardata[2][i], i));
			}

		}
		XAxis xAxis1 = mChart.getXAxis();
		xAxis1.setPosition(XAxisPosition.BOTTOM);
		xAxis1.setTextSize(13f);
		xAxis1.setDrawGridLines(false);
		xAxis1.setTextColor(Color.parseColor("#949494"));
		//
		// XAxis xAxis = chart.getXAxis();
		// xAxis.setPosition(XAxisPosition.BOTTOM);
		// xAxis.setTextSize(13f);
		// xAxis.setTextColor(Color.parseColor("#949494"));

		YAxis leftAxis = mChart.getAxisLeft();
		mChart.getAxisRight().setDrawGridLines(false);
		mChart.getAxisRight().setEnabled(false);

		leftAxis.setEnabled(false);
		// leftAxis.setPosition(YAxisLabelPosition.OUTSIDE_CHART);
		leftAxis.setDrawGridLines(false);

		BarDataSet barDataSet1 = new BarDataSet(valueSet1, ast[0]);
		barDataSet1.setColor(Color.parseColor("#80deea"));

		barDataSet1.setValueTextSize(14f);
		BarDataSet barDataSet2 = new BarDataSet(valueSet2, ast[1]);
		barDataSet2.setColor(Color.parseColor("#ED7D31"));
		barDataSet1.setValueTextSize(14f);
		BarDataSet barDataSet3 = null;
		if (countmaxthree > 2) {
			barDataSet3 = new BarDataSet(valueSet3, ast[2]);
			barDataSet3.setColor(Color.parseColor("#A5A5A5"));
			barDataSet1.setValueTextSize(14f);
		}
		// else if(barnumbers ==2)
		// {
		// barDataSet3 = new BarDataSet(valueSet3, "");
		// barDataSet3.setColor(Color.GREEN);
		// barDataSet1.setValueTextSize(14f);
		// }

		// barDataSet2.setColors(ColorTemplate.COLORFUL_COLORS);
		Legend l = mChart.getLegend();

		// l.setForm(LegendForm.LINE);

		// l.setFormToTextSpace(20f);
		// l.setYOffset(10f);
		l.setTextSize(15f);
		l.setTextColor(Color.BLACK);

		if (mode == 22 || mode == 23) {
			l.setPosition(LegendPosition.BELOW_CHART_CENTER);

		} else {
			l.setPosition(LegendPosition.BELOW_CHART_LEFT);
		}
		dataSets = new ArrayList<>();

		dataSets.add(barDataSet1);
		dataSets.add(barDataSet2);
		if (countmaxthree > 2)
			dataSets.add(barDataSet3);

		BarData data = new BarData(xAxis, dataSets);
		data.setValueTextSize(10f);
		data.setHighlightEnabled(false);
		data.setValueFormatter(new MyValueFormatter());
		mChart.setData(data);
		for (DataSet<?> set : mChart.getData().getDataSets())
			set.setDrawValues(!set.isDrawValuesEnabled());

		mChart.invalidate();

		// mChart.invalidate();
		return mChart;
	}

	public BarChart drawNbarchart92(int countmaxthree, String[] ast, int mode,
			int barnumbers) {
		ArrayList<BarDataSet> dataSets = null;
		Typeface mTf;
		mTf = Typeface.createFromAsset(context.getAssets(),
				"OpenSans-Regular.ttf");
		BarChart mChart = new BarChart(context);

		// mChart.getAxisLeft().setDrawLabels(false);
		// mChart.getAxisRight().setDrawLabels(false);
		// mChart.getXAxis().setDrawLabels(false);
		mChart.setBackgroundColor(Color.TRANSPARENT);
		mChart.setDrawBarShadow(false);
		mChart.setDrawValueAboveBar(true);
		mChart.getAxisRight().setDrawGridLines(false);

		mChart.setDescription("");

		mChart.invalidate();
		mChart.setX(20f);
		mChart.setY(45f);

		mChart.setMaxVisibleValueCount(60);

		mChart.setTouchEnabled(false);
		mChart.setPinchZoom(false);
		mChart.setGridBackgroundColor(Color.TRANSPARENT);

		mChart.setDrawGridBackground(false);
		mChart.animateY(1000);

		ArrayList<BarEntry> valueSet1 = new ArrayList<>();
		ArrayList<BarEntry> valueSet2 = new ArrayList<>();
		ArrayList<BarEntry> valueSet3 = new ArrayList<>();
		ArrayList<String> xAxis = new ArrayList<>();

		for (int i = 0; i < barnumbers; i++) {
			if (mode == 18 || mode == 20) {
				xAxis.add(i, xbardata1[i]);
			} else {
				xAxis.add(i, xbardata[i]);
			}
		}

		for (int i = 0; i < barnumbers; i++) {
			if (mode == 1) {
				valueSet1.add(new BarEntry(bardata1[0][i], i));
				valueSet2.add(new BarEntry(bardata1[1][i], i));
				if (countmaxthree > 2)
					valueSet3.add(new BarEntry(bardata1[2][i], i));
			} else if (mode == 2) {
				valueSet1.add(new BarEntry(bardata2[0][i], i));
				valueSet2.add(new BarEntry(bardata2[1][i], i));
				if (countmaxthree > 2)
					valueSet3.add(new BarEntry(bardata2[2][i], i));
			} else if (mode == 3) {
				valueSet1.add(new BarEntry(bardata3[0][i], i));
				valueSet2.add(new BarEntry(bardata3[1][i], i));
				if (countmaxthree > 2)
					valueSet3.add(new BarEntry(bardata3[2][i], i));
			} else if (mode == 4) {
				valueSet1.add(new BarEntry(bardata4[0][i], i));
				valueSet2.add(new BarEntry(bardata4[1][i], i));
				if (countmaxthree > 2)
					valueSet3.add(new BarEntry(bardata4[2][i], i));
			} else if (mode == 5) {
				valueSet1.add(new BarEntry(bardata5[0][i], i));
				valueSet2.add(new BarEntry(bardata5[1][i], i));
				if (countmaxthree > 2)
					valueSet3.add(new BarEntry(bardata5[2][i], i));
			} else if (mode == 6) {
				valueSet1.add(new BarEntry(bardata6[0][i], i));
				valueSet2.add(new BarEntry(bardata6[1][i], i));
				if (countmaxthree > 2)
					valueSet3.add(new BarEntry(bardata6[2][i], i));
			} else if (mode == 7) {
				valueSet1.add(new BarEntry(bardata7[0][i], i));
				valueSet2.add(new BarEntry(bardata7[1][i], i));
				if (countmaxthree > 2)
					valueSet3.add(new BarEntry(bardata7[2][i], i));
			} else if (mode == 8) {
				valueSet1.add(new BarEntry(bardata8[0][i], i));
				valueSet2.add(new BarEntry(bardata8[1][i], i));
				if (countmaxthree > 2)
					valueSet3.add(new BarEntry(bardata8[2][i], i));
			} else if (mode == 9) {
				valueSet1.add(new BarEntry(bardata9[0][i], i));
				valueSet2.add(new BarEntry(bardata9[1][i], i));

				valueSet3.add(new BarEntry(bardata9[2][i], i));
			}

			else if (mode == 10) {
				valueSet1.add(new BarEntry(bardata10[0][i], i));
				valueSet2.add(new BarEntry(bardata10[1][i], i));

			} else if (mode == 17) {
				valueSet1.add(new BarEntry(bardata17[0][i], i));
				valueSet2.add(new BarEntry(bardata17[1][i], i));

			} else if (mode == 18) {
				valueSet1.add(new BarEntry(bardata18[0][i], i));
				valueSet2.add(new BarEntry(bardata18[1][i], i));
				valueSet3.add(new BarEntry(bardata18[2][i], i));

			} else if (mode == 20) {
				valueSet1.add(new BarEntry(bardata20[0][i], i));
				valueSet2.add(new BarEntry(bardata20[1][i], i));
				valueSet3.add(new BarEntry(bardata20[2][i], i));

			} else if (mode == 21) {
				valueSet1.add(new BarEntry(bardata21[0][i], i));
				valueSet2.add(new BarEntry(bardata21[1][i], i));
				valueSet3.add(new BarEntry(bardata21[2][i], i));

			}

			else {
				valueSet1.add(new BarEntry(bardata[0][i], i));
				valueSet2.add(new BarEntry(bardata[1][i], i));
				if (countmaxthree > 2)
					valueSet3.add(new BarEntry(bardata[2][i], i));
			}

		}
		XAxis xAxis1 = mChart.getXAxis();
		xAxis1.setPosition(XAxisPosition.BOTTOM);
		xAxis1.setTextSize(13f);
		xAxis1.setDrawGridLines(false);
		xAxis1.setTextColor(Color.parseColor("#949494"));
		//
		// XAxis xAxis = chart.getXAxis();
		// xAxis.setPosition(XAxisPosition.BOTTOM);
		// xAxis.setTextSize(13f);
		// xAxis.setTextColor(Color.parseColor("#949494"));

		YAxis leftAxis = mChart.getAxisLeft();
		mChart.getAxisRight().setDrawGridLines(false);
		mChart.getAxisRight().setEnabled(false);

		leftAxis.setEnabled(false);
		// leftAxis.setPosition(YAxisLabelPosition.OUTSIDE_CHART);
		leftAxis.setDrawGridLines(false);

		BarDataSet barDataSet1 = new BarDataSet(valueSet1, ast[0]);
		barDataSet1.setColor(Color.parseColor("#80deea"));

		barDataSet1.setValueTextSize(14f);
		BarDataSet barDataSet2 = new BarDataSet(valueSet2, ast[1]);
		barDataSet2.setColor(Color.parseColor("#ED7D31"));
		barDataSet1.setValueTextSize(14f);
		BarDataSet barDataSet3 = null;
		if (countmaxthree > 2) {
			barDataSet3 = new BarDataSet(valueSet3, ast[2]);
			barDataSet3.setColor(Color.parseColor("#A5A5A5"));
			barDataSet1.setValueTextSize(14f);
		}
		// else if(barnumbers ==2)
		// {
		// barDataSet3 = new BarDataSet(valueSet3, "");
		// barDataSet3.setColor(Color.GREEN);
		// barDataSet1.setValueTextSize(14f);
		// }

		// barDataSet2.setColors(ColorTemplate.COLORFUL_COLORS);
		Legend l = mChart.getLegend();

		// l.setForm(LegendForm.LINE);

		// l.setFormToTextSpace(20f);
		// l.setYOffset(10f);
		l.setTextSize(15f);
		l.setTextColor(Color.BLACK);
		l.setPosition(LegendPosition.BELOW_CHART_LEFT);
		dataSets = new ArrayList<>();

		dataSets.add(barDataSet1);
		dataSets.add(barDataSet2);
		if (countmaxthree > 2)
			dataSets.add(barDataSet3);

		BarData data = new BarData(xAxis, dataSets);
		data.setValueTextSize(10f);
		data.setHighlightEnabled(false);
		data.setValueFormatter(new MyValueFormatter());
		mChart.setData(data);
		for (DataSet<?> set : mChart.getData().getDataSets())
			set.setDrawValues(!set.isDrawValuesEnabled());

		mChart.invalidate();

		// mChart.invalidate();
		return mChart;
	}

	public LineChart lineChart(String[] aster, int mode, float max, float min) {

		LineChart mChart = new LineChart(context);

		// no description text
		mChart.setDescription("");
		mChart.setNoDataTextDescription("You need to provide data for the chart.");

		// enable value highlighting
		mChart.setHighlightEnabled(true);

		// enable touch gestures
		mChart.setTouchEnabled(false);

		// mChart.setDragDecelerationFrictionCoef(0.9f);

		// enable scaling and dragging
		mChart.setDragEnabled(true);
		mChart.setScaleEnabled(true);
		mChart.setDrawGridBackground(false);
		mChart.setHighlightPerDragEnabled(true);
		mChart.setY(40f);
		mChart.setX(20f);
		mChart.getAxisRight().setDrawGridLines(false);

		// if disabled, scaling can be done on x- and y-axis separately
		// mChart.setPinchZoom(true);

		// set an alternative background color
		mChart.setBackgroundColor(Color.TRANSPARENT);
		mChart.setGridBackgroundColor(Color.TRANSPARENT);

		// mChart.setPadding(10, 0, 10, 0);

		// add data
		setDataline(3, 30, mChart, aster, mode);

		mChart.animateX(2500);

		Typeface tf = Typeface.createFromAsset(context.getAssets(),
				"OpenSans-Regular.ttf");

		// get the legend (only possible after setting data)
		Legend l = mChart.getLegend();

		// modify the legend ...
		// l.setPosition(LegendPosition.LEFT_OF_CHART);

		// l.setTypeface(tf);
		// l.setFormToTextSpace(20f);
		// l.setYOffset(10f);
		l.setTextSize(15f);
		l.setTextColor(Color.BLACK);
		l.setPosition(LegendPosition.BELOW_CHART_CENTER);
		// l.setFormSize(15f);
		// l.setFormToTextSpace(4f);

		// l.setYEntrySpace(4f);

		// l.setYOffset(0f);

		// l.setYOffset(11f);

		XAxis xAxis = mChart.getXAxis();
		xAxis.setTypeface(tf);
		xAxis.setLabelsToSkip(0);
		xAxis.setPosition(XAxisPosition.BOTTOM);
		xAxis.setTextSize(14f);
		xAxis.setTextColor(Color.parseColor("#949494"));
		xAxis.setDrawGridLines(false);
		// xAxis.setDrawAxisLine(false);
		// xAxis.setSpaceBetweenLabels(1);

		YAxis leftAxis = mChart.getAxisLeft();
		// leftAxis.setTypeface(tf);
		leftAxis.setDrawGridLines(false);
		leftAxis.setTextColor(ColorTemplate.getHoloBlue());
		leftAxis.setValueFormatter(new ValueFormatter() {

			@Override
			public String getFormattedValue(float value) {
				// TODO Auto-generated method stub
				NumberFormat nf = NumberFormat.getInstance();
				nf.setMinimumFractionDigits(0);

				String sd = nf.format(value);
				return sd.substring(0, sd.length());
			}
		});
		// leftAxis.setAxisMaxValue(100f);
		leftAxis.setAxisMaxValue(max);
		leftAxis.setAxisMinValue(min);
		leftAxis.setTextSize(14f);
		leftAxis.setDrawGridLines(false);

		YAxis rightAxis = mChart.getAxisRight();
		rightAxis.setTypeface(tf);
		rightAxis.setTextColor(Color.RED);
		rightAxis.setDrawGridLines(false);
		// rightAxis.setAxisMaxValue(100);
		rightAxis.setAxisMaxValue(max);
		rightAxis.setStartAtZero(false);
		// rightAxis.setAxisMinValue(0);
		rightAxis.setAxisMinValue(min);
		rightAxis.setValueFormatter(new ValueFormatter() {

			@Override
			public String getFormattedValue(float value) {
				// TODO Auto-generated method stub
				NumberFormat nf = NumberFormat.getInstance();
				nf.setMinimumFractionDigits(0);

				String sd = nf.format(value);
				return sd.substring(0, sd.length());
			}
		});
		rightAxis.setTextSize(14f);
		rightAxis.setDrawGridLines(false);
		return mChart;
	}

	int[][] linedata = { { 82, 83, 75 }, { 70, 80, 90 }, { 60, 70, 80 } };
	float[][] linedata1 = { { 9, 9, 8.5f }, { 8.5f, 8, 6.7f },
			{ 9.3f, 7.4f, 8.5f } };
	int[][] linedata2 = { { 10, 5, 20 }, { 5, 10, 30 } };
	int[][] linedata3 = { { 24, 20, 22 }, { 15, 18, 10 } };
	int[][] linedata4 = { { 90, 90, 90 }, { 80, 75, 60 }, { 80, 90, 70 } };
	int[][] linedata5 = { { 1250, 1000, 1300 }, { 1000, 800, 1000 },
			{ 600, 900, 1500 } };
	int[][] linedata6 = { { 150, 130, 130 }, { 100, 120, 110 }, { 10, 15, 5 },
			{ 5, 3, 0 } };
	int[][] linedata7 = { { 5, 2, 3 }, { 2, -3, 5 } };
	int[][] linedata8 = { { 80, 70, 60 }, { 70, 60, 80 } };
	int[][] linedata9 = { { 200, 350, 50 }, { 100, 400, 200 } };
	int[][] linedata10 = { { 95, 60, 30 }, { 50, 65, 50 }, { 70, 80, 70 } };
	int[][] linedata11 = { { 100, 90, 130 }, { 150, 85, 112 }, { 200, 73, 78 } };
	int[][] linedata12 = { { 10, 5, 0 }, { 5, 2, 0 }, { 5, 6, 8 } };
	int[][] linedata13 = { { 4, 6, 1 }, { 5, 10, 5 }, { 3, 5, 6 } };
	int[][] linedata14 = { { 5, 10, 15 }, { 20, 50, 40 }, { 2, 0, 20 } };
	int[][] linedata15 = { { 192, 43, 98 }, { 68, 80, 99 }, { 96, 67, 32 } };
	int[][] linedata16 = { { 50, 40, 60 }, { 40, 60, 50 } };
	int[][] linedata17 = { { 100, 90, 80 }, { 50, 10, 20 } };
	int[][] linedata18 = { { 100, 90, 130 }, { 150, 85, 112 }, { 200, 73, 78 } };
	int[][] linedata19 = { { 90, 100, 80 }, { 60, 90, 80 } };
	int[][] linedata22 = { { 5, 2, 3 }, { 2, 1, 5 }, { 5, 1, 2 } };

	private void setDataline(int count, float range, LineChart mChart,
			String[] ast, int mode) {

		ArrayList<String> xVals = new ArrayList<String>();
		for (int i = 0; i < count; i++) {
			xVals.add(xbardata[i]);
		}

		ArrayList<Entry> yVals1 = new ArrayList<Entry>();
		ArrayList<Entry> yVals2 = new ArrayList<Entry>();
		ArrayList<Entry> yVals3 = new ArrayList<Entry>();
		ArrayList<Entry> yVals4 = new ArrayList<Entry>();

		for (int i = 0; i < count; i++) {
			if (mode == 1) {
				yVals1.add(new Entry(linedata1[0][i], i));
				yVals2.add(new Entry(linedata1[1][i], i));
				yVals3.add(new Entry(linedata1[2][i], i));
			} else if (mode == 2) {
				yVals1.add(new Entry(linedata2[0][i], i));
				yVals2.add(new Entry(linedata2[1][i], i));
				// yVals3.add(new Entry(linedata2[2][i], i));
			} else if (mode == 3) {
				yVals1.add(new Entry(linedata3[0][i], i));
				yVals2.add(new Entry(linedata3[1][i], i));
				// yVals3.add(new Entry(linedata2[2][i], i));
			} else if (mode == 4) {
				yVals1.add(new Entry(linedata4[0][i], i));
				yVals2.add(new Entry(linedata4[1][i], i));
				yVals3.add(new Entry(linedata4[2][i], i));
			}

			else if (mode == 5) {
				yVals1.add(new Entry(linedata5[0][i], i));
				yVals2.add(new Entry(linedata5[1][i], i));
				yVals3.add(new Entry(linedata5[2][i], i));
			} else if (mode == 6) {
				yVals1.add(new Entry(linedata6[0][i], i));
				yVals2.add(new Entry(linedata6[1][i], i));
				yVals3.add(new Entry(linedata6[2][i], i));
				// yVals4.add(new Entry(linedata6[3][i], i));
			} else if (mode == 7) {
				yVals1.add(new Entry(linedata7[0][i], i));
				yVals2.add(new Entry(linedata7[1][i], i));
				// yVals3.add(new Entry(linedata7[2][i], i));
			} else if (mode == 8) {
				yVals1.add(new Entry(linedata8[0][i], i));
				yVals2.add(new Entry(linedata8[1][i], i));
				// yVals3.add(new Entry(linedata7[2][i], i));
			} else if (mode == 9) {
				yVals1.add(new Entry(linedata9[0][i], i));
				yVals2.add(new Entry(linedata9[1][i], i));
				// yVals3.add(new Entry(linedata7[2][i], i));
			} else if (mode == 10) {
				yVals1.add(new Entry(linedata10[0][i], i));
				yVals2.add(new Entry(linedata10[1][i], i));
				yVals3.add(new Entry(linedata10[2][i], i));
			} else if (mode == 11) {
				yVals1.add(new Entry(linedata11[0][i], i));
				yVals2.add(new Entry(linedata11[1][i], i));
				yVals3.add(new Entry(linedata11[2][i], i));
			} else if (mode == 12) {
				yVals1.add(new Entry(linedata12[0][i], i));
				yVals2.add(new Entry(linedata12[1][i], i));
				yVals3.add(new Entry(linedata12[2][i], i));
			} else if (mode == 13) {
				yVals1.add(new Entry(linedata13[0][i], i));
				yVals2.add(new Entry(linedata13[1][i], i));
				yVals3.add(new Entry(linedata13[2][i], i));
			} else if (mode == 14) {
				yVals1.add(new Entry(linedata14[0][i], i));
				yVals2.add(new Entry(linedata14[1][i], i));
				yVals3.add(new Entry(linedata14[2][i], i));
			} else if (mode == 15) {
				yVals1.add(new Entry(linedata15[0][i], i));
				yVals2.add(new Entry(linedata15[1][i], i));
				yVals3.add(new Entry(linedata15[2][i], i));
			} else if (mode == 16) {
				yVals1.add(new Entry(linedata16[0][i], i));
				yVals2.add(new Entry(linedata16[1][i], i));

			} else if (mode == 17) {
				yVals1.add(new Entry(linedata17[0][i], i));
				yVals2.add(new Entry(linedata17[1][i], i));

			} else if (mode == 18) {
				yVals1.add(new Entry(linedata18[0][i], i));
				yVals2.add(new Entry(linedata18[1][i], i));
				yVals3.add(new Entry(linedata18[2][i], i));

			} else if (mode == 19) {
				yVals1.add(new Entry(linedata19[0][i], i));
				yVals2.add(new Entry(linedata19[1][i], i));
				// yVals3.add(new Entry(linedata19[2][i], i));

			} else if (mode == 22) {
				yVals1.add(new Entry(linedata22[0][i], i));
				yVals2.add(new Entry(linedata22[1][i], i));
				yVals3.add(new Entry(linedata22[2][i], i));

			}

			else {
				yVals1.add(new Entry(linedata[0][i], i));
				yVals2.add(new Entry(linedata[1][i], i));
				yVals3.add(new Entry(linedata[2][i], i));
			}

		}

		// create a dataset and give it a type
		LineDataSet set1 = new LineDataSet(yVals1, ast[0]);
		set1.setAxisDependency(AxisDependency.LEFT);
		set1.setColor(Color.BLUE);
		// set1.setCircleColor(Color.WHITE);
		set1.setLineWidth(2f);
		set1.setDrawCubic(true);
		// set1.setCircleSize(3f);
		set1.setFillAlpha(65);
		set1.setFillColor(ColorTemplate.getHoloBlue());
		set1.setHighLightColor(Color.rgb(244, 117, 117));
		// set1.setDrawCircleHole(false);
		// set1.setDrawHorizontalHighlightIndicator(false);
		// set1.setVisible(false);
		// set1.setCircleHoleColor(Color.WHITE);

		//
		// for (int i = 0; i < count; i++) {
		// float mult = range;
		// float val = (float) (Math.random() * mult) + 450;// + (float)
		// // ((mult *
		// // 0.1) / 10);
		// yVals2.add(new Entry(val, i));
		// }

		// create a dataset and give it a type
		LineDataSet set2 = new LineDataSet(yVals2, ast[1]);
		set2.setAxisDependency(AxisDependency.RIGHT);
		set2.setColor(Color.RED);
		set2.setDrawCubic(true);

		set2.setDrawCircles(false);
		// set2.setDrawFilled(true);
		// set2.setCircleColor(Color.WHITE);
		set2.setLineWidth(2f);
		// set2.setCircleSize(3f);
		set2.setFillAlpha(65);
		set2.setFillColor(Color.RED);
		// set2.setDrawCircleHole(false);
		set2.setHighLightColor(Color.rgb(244, 117, 117));
		LineDataSet set3 = null;
		LineDataSet set4 = null;
		if (mode != 2 && mode != 3 && mode != 7 && mode != 8 && mode != 9
				&& mode != 19 && mode != 16) {
			set3 = new LineDataSet(yVals3, ast[2]);
			set3.setAxisDependency(AxisDependency.RIGHT);
			set3.setColor(Color.GREEN);

			set3.setDrawCubic(true);
			set3.setLineWidth(2f);
			// set3.setCircleSize(3f);
			set3.setFillAlpha(65);
			set3.setFillColor(Color.GREEN);
			// set3.setDrawCircleHole(false);
			set3.setHighLightColor(Color.rgb(244, 117, 117));
		}
		// if (mode == 6) {
		// set4 = new LineDataSet(yVals4, ast[3]);
		// set4.setAxisDependency(AxisDependency.RIGHT);
		// set4.setColor(Color.GREEN);
		//
		// set4.setDrawCubic(true);
		// set4.setLineWidth(2f);
		// // set3.setCircleSize(3f);
		// set4.setFillAlpha(65);
		// set4.setFillColor(Color.GREEN);
		// // set3.setDrawCircleHole(false);
		// set4.setHighLightColor(Color.rgb(244, 117, 117));
		// }
		ArrayList<LineDataSet> dataSets = new ArrayList<LineDataSet>();
		dataSets.add(set1);
		dataSets.add(set2);
		if (mode != 2 && mode != 3 && mode != 7 && mode != 8 && mode != 9
				&& mode != 19 && mode != 16) {
			dataSets.add(set3);
		}
		// if (mode == 6) {
		// dataSets.add(set4);
		// }

		// add the datasets

		// create a data object with the datasets
		LineData data = new LineData(xVals, dataSets);
		data.setValueTextColor(Color.WHITE);

		data.setValueTextSize(9f);

		// set data
		mChart.setData(data);
	}

	public PieChart piechartM(int mode) {
		PieChart mChart = new PieChart(context);
		mChart.setUsePercentValues(false);
		mChart.setDescription("");

		mChart.setDragDecelerationFrictionCoef(0.95f);

		Typeface tf = Typeface.createFromAsset(context.getAssets(),
				"OpenSans-Regular.ttf");

		mChart.setCenterTextTypeface(Typeface.createFromAsset(
				context.getAssets(), "OpenSans-Light.ttf"));

		// mChart.setHoleColorTransparent(true);
		mChart.setDrawHoleEnabled(false);

		// mChart.setTransparentCircleColor(Color.WHITE);
		mChart.setTransparentCircleAlpha(110);

		mChart.setHoleRadius(58f);

		if (mode == 7) {
			mChart.setTransparentCircleRadius(25f);

		} else {

			mChart.setTransparentCircleRadius(61f);
		}
		mChart.setDrawCenterText(true);

		mChart.setRotationAngle(0);
		// enable rotation of the chart by touch
		mChart.setRotationEnabled(true);
		mChart.setY(33f);
		mChart.setX(20f);

		// mChart.setUnit(" €");
		// mChart.setDrawUnitsInChart(true);

		// add a selection listener
		// mChart.setOnChartValueSelectedListener(l)

		// mChart.setCenterText("MPAndroidChart\nby Philipp Jahoda");

		setDataM(4, 100, mChart, mode);

		mChart.animateY(1500, Easing.EasingOption.EaseInOutQuad);
		// mChart.spin(2000, 0, 360);

		Legend l = mChart.getLegend();
		l.setPosition(LegendPosition.BELOW_CHART_CENTER);
		l.setTextSize(15f);

		// l.setYOffset(0f);
		// l.setFormSize(15f);
		// l.setFormToTextSpace(10f);
		//
		// l.setYEntrySpace(10f);

		return mChart;

	}

	String[] piechartdata = { "30.72", "33.7", "35.5" };
	String[] piechartdata1 = { "50", "25", "8.3", "16.6" };
	String[] piechartdata2 = { "2", "9.0", "22.7", "66.1" };
	String[] xpie1 = { "TOT ", "JW ", "Individual " };
	String[] xpie = { "Drs Tagged", "Drs Met", "Samples Dist." };
	String[] xpie3 = { "Acenomorol", "mezzo Drop", "Solsuna" };
	String[] piechartdata3 = { "16", "31", "53" };
	String[] xpie4 = { "Default ", " Custom", " Broken" };
	String[] piechartdata4 = { "80", "10", "10" };
	String[] xpie6 = { "Cardio", "Gynaec", "Derma" };
	String[] piechartdata6 = { "10", "5", "20" };
	String[] xpie7 = { "Cardio", "Gynaec" };
	String[] piechartdata7 = { "90", "10" };
	String[] piechartdata8 = { "30", "15", "5" };
	String[] xpie123 = { "Aceno", "Comp1", "Comp2" };

	private void setDataM(int count, float range, PieChart mChart, int mode) {

		float mult = range;

		Typeface tf = Typeface.createFromAsset(context.getAssets(),
				"OpenSans-Regular.ttf");

		ArrayList<Entry> yVals1 = new ArrayList<Entry>();

		// IMPORTANT: In a PieChart, no values (Entry) should have the same
		// xIndex (even if from different DataSets), since no values can be
		// drawn above each other.
		for (int i = 0; i < count; i++) {
			// yVals1.add(new Entry((float) (Math.random() * mult) + mult / 5,
			// i));
			if (mode == 2) {
				yVals1.add(new Entry(Float.valueOf(piechartdata1[i]), i));

			} else if (mode == 3) {
				if (i < 3)
					yVals1.add(new Entry(Float.valueOf(piechartdata[i]), i));

			} else if (mode == 4) {
				if (i < 3)
					yVals1.add(new Entry(Float.valueOf(piechartdata[i]), i));

			} else if (mode == 5) {
				if (i < 3)
					yVals1.add(new Entry(Float.valueOf(piechartdata4[i]), i));

			}

			else if (mode == 6) {
				if (i < 3)
					yVals1.add(new Entry(Float.valueOf(piechartdata6[i]), i));

			} else if (mode == 7) {
				if (i < 2)
					yVals1.add(new Entry(Float.valueOf(piechartdata7[i]), i));

			} else if (mode == 8) {
				if (i < 3)
					yVals1.add(new Entry(Float.valueOf(piechartdata8[i]), i));

			}

			else {
				yVals1.add(new Entry(Float.valueOf(piechartdata[i]), i));
			}
		}

		ArrayList<String> xVals = new ArrayList<String>();

		for (int i = 0; i < count; i++) {
			if (mode == 2) {
				xVals.add(xpie[i]);

			} else if (mode == 3) {
				if (i < 3)
					xVals.add(xpie1[i]);

			} else if (mode == 4) {
				if (i < 3)
					xVals.add(xpie123[i]);

			} else if (mode == 5) {
				if (i < 3)
					xVals.add(xpie4[i]);

			} else if (mode == 6) {
				if (i < 3)
					xVals.add(xpie6[i]);

			} else if (mode == 7) {
				if (i < 2)
					xVals.add("");

			} else if (mode == 8) {
				if (i < 3)
					xVals.add(xpie[i]);

			} else {
				xVals.add(mParties[i % mParties.length]);
			}
		}
		// xVals.add(mParties[i % mParties.length]);

		PieDataSet dataSet = new PieDataSet(yVals1, "");
		dataSet.setSliceSpace(3f);
		dataSet.setSelectionShift(5f);
		dataSet.setValueTextSize(15f);

		// add a lot of colors

		ArrayList<Integer> colors = new ArrayList<Integer>();

		for (int c : ColorTemplate.VORDIPLOM_COLORS)
			colors.add(c);

		for (int c : ColorTemplate.JOYFUL_COLORS)
			colors.add(c);

		for (int c : ColorTemplate.COLORFUL_COLORS)
			colors.add(c);

		for (int c : ColorTemplate.LIBERTY_COLORS)
			colors.add(c);

		for (int c : ColorTemplate.PASTEL_COLORS)
			colors.add(c);

		colors.add(ColorTemplate.getHoloBlue());

		dataSet.setColors(colors);
		if (mode == 7) {
			mChart.setDrawHoleEnabled(true);
			mChart.setCenterText("9");
			mChart.setCenterTextSize(40f);
			// xVals=null;
		}

		PieData data = new PieData(xVals, dataSet);
		data.setValueFormatter(new PercentFormatter());
		data.setValueTextSize(10f);
		data.setValueTextColor(Color.WHITE);
		data.setValueTypeface(tf);
		mChart.setData(data);
		// mChart.setUsePercentValues(true);
		mChart.setDrawSliceText(!mChart.isDrawSliceTextEnabled());
		// undo all highlights
		mChart.highlightValues(null);

		if (mode == 4 || mode == 6) {

			//
			mChart.setDrawHoleEnabled(true);
			// mChart.setCenterText("9");
			// mChart.setCenterTextSize(40f);
		}

		for (DataSet<?> set : mChart.getData().getDataSets())
			set.setDrawValues(!set.isDrawValuesEnabled());

		mChart.invalidate();

	}

	public BarChart getsinglebarchartP(int mode) {

		Typeface mTf;
		mTf = Typeface.createFromAsset(context.getAssets(),
				"OpenSans-Regular.ttf");
		BarChart mChart = new BarChart(context);
		// mChart.setOnChartValueSelectedListener(this);

		mChart.setDrawBarShadow(false);
		mChart.setDrawValueAboveBar(true);

		mChart.setDescription("");

		mChart.invalidate();

		// if more than 60 entries are displayed in the chart, no values will be
		// drawn
		mChart.setMaxVisibleValueCount(60);

		// scaling can now only be done on x- and y-axis separately
		mChart.setPinchZoom(false);
		mChart.setY(20f);
		// mChart.animateX(10000);

		// draw shadows for each bar that show the maximum value
		// mChart.setDrawBarShadow(true);

		// mChart.setDrawXLabels(false);

		mChart.setDrawGridBackground(false);
		mChart.animateY(3000);
		// mChart.setDrawYLabels(false);

		XAxis xAxis = mChart.getXAxis();
		xAxis.setPosition(XAxisPosition.BOTTOM);
		xAxis.setTypeface(mTf);
		xAxis.setDrawGridLines(false);
		xAxis.setSpaceBetweenLabels(2);

		ValueFormatter custom = new MyValueFormatter();

		YAxis leftAxis = mChart.getAxisLeft();
		leftAxis.setTypeface(mTf);
		leftAxis.setLabelCount(8, false);
		leftAxis.setValueFormatter(custom);
		leftAxis.setPosition(YAxisLabelPosition.OUTSIDE_CHART);
		leftAxis.setSpaceTop(15f);
		leftAxis.setDrawGridLines(false);

		YAxis rightAxis = mChart.getAxisRight();
		rightAxis.setDrawGridLines(false);
		rightAxis.setTypeface(mTf);
		rightAxis.setLabelCount(8, false);
		rightAxis.setValueFormatter(custom);
		rightAxis.setSpaceTop(15f);

		Legend l = mChart.getLegend();
		l.setTextColor(Color.WHITE);
		l.setEnabled(false);
		l.setPosition(LegendPosition.BELOW_CHART_LEFT);
		l.setForm(LegendForm.SQUARE);
		l.setFormSize(9f);
		l.setTextSize(15f);
		l.setXEntrySpace(4f);

		// l.setExtra(ColorTemplate.VORDIPLOM_COLORS, new String[] { "abc",
		// "def", "ghj", "ikl", "mno" });
		// l.setCustom(ColorTemplate.VORDIPLOM_COLORS, new String[] { "abc",
		// "def", "ghj", "ikl", "mno" });

		setData99(4, 50, mChart, mode);

		for (DataSet<?> set : mChart.getData().getDataSets())
			set.setDrawValues(!set.isDrawValuesEnabled());
		mChart.invalidate();
		return mChart;
	}

	int[] singlebar = { 0, 2, 5, 15 };
	String[] xbar = { "Leave", "TOT Days", "JW Days", "Individual Days" };
	int[] singlebar2 = { 30, 15, 5, 10 };
	String[] xbar2 = { "Drs Tagged", "Drs Met", "Samples Distributed",
			"Inputs Distributed" };

	private void setData99(int count, float range, BarChart mChart, int mode) {

		ArrayList<String> xVals = new ArrayList<String>();
		for (int i = 0; i < count; i++) {
			if (mode == 2) {
				xVals.add(xbar2[i]);
			} else {
				xVals.add(xbar[i]);
			}
		}

		ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();

		for (int i = 0; i < count; i++) {
			if (mode == 2) {
				yVals1.add(new BarEntry(singlebar2[i], i));
			} else {
				yVals1.add(new BarEntry(singlebar[i], i));
			}
		}

		BarDataSet set1 = new BarDataSet(yVals1, "");
		set1.setBarSpacePercent(35f);

		ArrayList<BarDataSet> dataSets = new ArrayList<BarDataSet>();
		dataSets.add(set1);

		BarData data = new BarData(xVals, dataSets);
		// data.setValueFormatter(new MyValueFormatter());
		data.setValueTextSize(10f);

		mChart.setPinchZoom(false);
		// mChart.setDrawValueAboveBar(false);
		mChart.setData(data);
	}

	public BarChart StackedBarChart() {

		BarChart mChart = new BarChart(context);
		// mChart.setOnChartValueSelectedListener(context);

		mChart.setDescription("");

		// if more than 60 entries are displayed in the chart, no values will be
		// drawn
		mChart.setMaxVisibleValueCount(60);

		mChart.setDrawGridBackground(false);

		// scaling can now only be done on x- and y-axis separately
		mChart.setPinchZoom(false);
		mChart.setEnabled(false);

		mChart.setDrawGridBackground(false);
		mChart.setDrawBarShadow(false);

		mChart.setDrawValueAboveBar(false);

		// change the position of the y-labels
		YAxis yLabels = mChart.getAxisLeft();
		yLabels.setValueFormatter(new MyValueFormatter());
		mChart.getAxisRight().setEnabled(false);

		XAxis xLabels = mChart.getXAxis();
		xLabels.setPosition(XAxisPosition.TOP);

		XAxis xAxis = mChart.getXAxis();
		xAxis.setPosition(XAxisPosition.BOTTOM);

		xAxis.setDrawGridLines(false);
		xAxis.setSpaceBetweenLabels(1);

		ValueFormatter custom = new MyValueFormatter();

		YAxis leftAxis = mChart.getAxisLeft();

		leftAxis.setDrawGridLines(false);

		leftAxis.setLabelCount(4, false);
		leftAxis.setValueFormatter(custom);

		leftAxis.setSpaceTop(15f);

		// mChart.setDrawXLabels(false);
		// mChart.setDrawYLabels(false);

		// setting data

		setdattostacked(3, 100, mChart);

		Legend l = mChart.getLegend();
		l.setPosition(LegendPosition.BELOW_CHART_CENTER);
		l.setFormSize(15f);
		l.setFormToTextSpace(4f);
		l.setYEntrySpace(10f);
		return mChart;
	}

	public void setdattostacked(long mSeekBarX, long mSeekBarY, BarChart mChart) {

		ArrayList<String> xVals = new ArrayList<String>();
		for (int i = 0; i < mSeekBarX + 1; i++) {
			xVals.add(mMonths[i % mMonths.length]);
		}

		ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();

		for (int i = 0; i < mSeekBarX + 1; i++) {
			float mult = (mSeekBarY + 1);
			float val1 = (float) (Math.random() * mult) + mult / 3;
			float val2 = (float) (Math.random() * mult) + mult / 3;
			// float val3 = (float) (Math.random() * mult) + mult / 3;

			yVals1.add(new BarEntry(new float[] { val1, val2 }, i));
		}

		BarDataSet set1 = new BarDataSet(yVals1, " ");
		set1.setColors(getColors());
		set1.setStackLabels(new String[] { "OUR BRAND", "COMPETITOR BRAND" });

		ArrayList<BarDataSet> dataSets = new ArrayList<BarDataSet>();
		dataSets.add(set1);

		BarData data = new BarData(xVals, dataSets);
		data.setValueTextSize(10f);
		data.setValueFormatter(new MyValueFormatter());

		mChart.setData(data);
		mChart.invalidate();
	}
}
