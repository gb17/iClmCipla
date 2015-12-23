package com.cirrius.canvas;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Display;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.cirrius.iclmcipla.R;
import com.cirrius.iclmcipla.ReadWriteData;
import com.cirrius.iclmcipla.Utility;
import com.idunnololz.widgets.ColorPickerDialog;
import com.idunnololz.widgets.ColorPickerDialog.OnColorSelectedListener;

public class Canvas extends Activity {
	private TextView add, edit, backgrnd, photo, text, music, video, play,
			floppy, close, shut;
	RelativeLayout main;
	TextView latestT, txtm, txtV, text5;
	Spinner anim;
	View latestI;
	ImageView play1, stop;
	Typeface font;
	Dialog dialog_box;
	Window window;
	int[] viewLocation = new int[2];
	SeekBar seek1, seek2, seek3, seek4, seek5, seek6, seek7;
	ScrollView right1, right2;
	RelativeLayout right3;
	MediaPlayer mPlayer = null;
	int id = 0;
	String[][] pageData;
	WebView webView;
	String url = "";
	String menutext = "";
	TextView[] menu;
	EditText existing_text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.canvas);
		getActionBar().hide();
		font = Typeface.createFromAsset(this.getAssets(),
				"fontawesome-webfont.ttf");

		add = (TextView) findViewById(R.id.add);
		edit = (TextView) findViewById(R.id.edit);
		backgrnd = (TextView) findViewById(R.id.backgrnd);
		photo = (TextView) findViewById(R.id.photo);
		text = (TextView) findViewById(R.id.text);
		music = (TextView) findViewById(R.id.music);
		video = (TextView) findViewById(R.id.video);
		play = (TextView) findViewById(R.id.play);
		floppy = (TextView) findViewById(R.id.floppy);
		close = (TextView) findViewById(R.id.close);
		existing_text = (EditText) findViewById(R.id.existing_text);
		txtm = (TextView) findViewById(R.id.txtm);
		txtV = (TextView) findViewById(R.id.txtv);
		text5 = (TextView) findViewById(R.id.text5);
		anim = (Spinner) findViewById(R.id.anim);
		existing_text.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				if (latestT != null) {
					latestT.setText(s);
				}
			}
		});
		menu = new TextView[] { add, edit, backgrnd, photo, text, music, video,
				play, floppy, close };

		enableMenus(menu, 0);

		shut = (TextView) findViewById(R.id.shut);
		right1 = (ScrollView) findViewById(R.id.right1);
		right2 = (ScrollView) findViewById(R.id.right2);
		right3 = (RelativeLayout) findViewById(R.id.right3);
		play1 = (ImageView) findViewById(R.id.play1);
		stop = (ImageView) findViewById(R.id.stop);
		play1.setOnClickListener(playListener1);
		stop.setOnClickListener(playListener2);

		main = (RelativeLayout) findViewById(R.id.main);
		main.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				right1.setVisibility(View.INVISIBLE);
				right2.setVisibility(View.INVISIBLE);
				right3.setVisibility(View.INVISIBLE);
			}
		});
		TextView text_color = (TextView) findViewById(R.id.text_color);
		text_color.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ColorPickerDialog colorPickerDialog = new ColorPickerDialog(
						Canvas.this, Color.parseColor("#ffffff"),
						new OnColorSelectedListener() {
							@Override
							public void onColorSelected(int color) {
								latestT.setTextColor(color);
							}

						});
				colorPickerDialog.show();
			}
		});
		seek1 = (SeekBar) findViewById(R.id.seek1);
		seek2 = (SeekBar) findViewById(R.id.seek2);
		seek3 = (SeekBar) findViewById(R.id.seek3);
		seek4 = (SeekBar) findViewById(R.id.seek4);
		seek5 = (SeekBar) findViewById(R.id.seek11);
		seek6 = (SeekBar) findViewById(R.id.seek21);
		seek7 = (SeekBar) findViewById(R.id.seek41);
		seek1.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				if (latestI != null) {
					int widthP = latestI.getWidth();
					int heightP = latestI.getHeight();
					int marginLeft = progress;
					RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) latestI
							.getLayoutParams();
					int i = lp.leftMargin;
					int j = lp.topMargin;
					RelativeLayout.LayoutParams parms = new RelativeLayout.LayoutParams(
							widthP, heightP);
					parms.leftMargin = marginLeft;
					parms.topMargin = j;
					latestI.setLayoutParams(parms);
				}
			}
		});
		seek2.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				if (latestI != null) {
					int widthP = latestI.getWidth();
					int heightP = latestI.getHeight();
					int marginTop = progress;
					RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) latestI
							.getLayoutParams();
					int i = lp.leftMargin;
					int j = lp.topMargin;
					RelativeLayout.LayoutParams parms = new RelativeLayout.LayoutParams(
							widthP, heightP);
					parms.topMargin = marginTop;
					parms.leftMargin = i;
					latestI.setLayoutParams(parms);
				}
			}
		});
		seek5.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				if (latestT != null) {
					int widthP = latestT.getWidth();
					int heightP = latestT.getHeight();
					int marginLeft = progress;
					RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) latestT
							.getLayoutParams();
					int i = lp.leftMargin;
					int j = lp.topMargin;
					RelativeLayout.LayoutParams parms = new RelativeLayout.LayoutParams(
							widthP, heightP);
					parms.leftMargin = marginLeft;
					parms.topMargin = j;
					latestT.setGravity(Gravity.FILL);
					latestT.setLayoutParams(parms);
				}
			}
		});
		seek6.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				if (latestT != null) {
					int widthP = latestT.getWidth();
					int heightP = latestT.getHeight();
					int marginTop = progress;
					RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) latestT
							.getLayoutParams();
					int i = lp.leftMargin;
					int j = lp.topMargin;
					RelativeLayout.LayoutParams parms = new RelativeLayout.LayoutParams(
							widthP, heightP);
					parms.topMargin = marginTop;
					parms.leftMargin = i;
					latestT.setGravity(Gravity.FILL);
					latestT.setLayoutParams(parms);
				}
			}
		});
		seek7.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				if (latestT != null) {
					latestT.setTextSize(progress);
					RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) latestT
							.getLayoutParams();
					int i = lp.leftMargin;
					int j = lp.topMargin;
					RelativeLayout.LayoutParams parms = new RelativeLayout.LayoutParams(
							RelativeLayout.LayoutParams.WRAP_CONTENT,
							RelativeLayout.LayoutParams.WRAP_CONTENT);
					parms.topMargin = j;
					parms.leftMargin = i;
					latestT.setGravity(Gravity.FILL);
					latestT.setLayoutParams(parms);
				}
			}
		});

		seek4.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				int heightP = latestI.getHeight();
				RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) latestI
						.getLayoutParams();
				int i = lp.leftMargin;
				int j = lp.topMargin;
				RelativeLayout.LayoutParams parms = new RelativeLayout.LayoutParams(
						progress, heightP);
				parms.setMargins(i, j, 0, 0);
				latestI.setLayoutParams(parms);
			}
		});
		seek3.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				int widthP = latestI.getWidth();
				RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) latestI
						.getLayoutParams();
				int i = lp.leftMargin;
				int j = lp.topMargin;
				RelativeLayout.LayoutParams parms = new RelativeLayout.LayoutParams(
						widthP, progress);
				parms.setMargins(i, j, 0, 0);
				latestI.setLayoutParams(parms);
			}
		});

		add.setTypeface(font);
		edit.setTypeface(font);
		backgrnd.setTypeface(font);
		photo.setTypeface(font);
		text.setTypeface(font);
		music.setTypeface(font);
		video.setTypeface(font);
		play.setTypeface(font);
		floppy.setTypeface(font);
		close.setTypeface(font);
		shut.setTypeface(font);

		shut.setOnClickListener(menuListener);
		add.setOnClickListener(menuListener);
		edit.setOnClickListener(menuListener);
		backgrnd.setOnClickListener(menuListener);
		photo.setOnClickListener(menuListener);
		text.setOnClickListener(menuListener);
		close.setOnClickListener(menuListener);
		music.setOnClickListener(menuListener);
		video.setOnClickListener(menuListener);
		play.setOnClickListener(menuListener);
		floppy.setOnClickListener(menuListener);
	}

	private OnClickListener menuListener = new OnClickListener() {

		@SuppressLint("JavascriptInterface")
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			right1.setVisibility(View.INVISIBLE);
			right2.setVisibility(View.INVISIBLE);
			right3.setVisibility(View.INVISIBLE);
			switch (v.getId()) {
			case R.id.add:
				dialog_box = new Dialog(Canvas.this);
				dialog_box.requestWindowFeature(Window.FEATURE_NO_TITLE);
				RelativeLayout linear = new RelativeLayout(Canvas.this);

				RelativeLayout.LayoutParams param = new RelativeLayout.LayoutParams(
						RelativeLayout.LayoutParams.WRAP_CONTENT,
						RelativeLayout.LayoutParams.WRAP_CONTENT);
				param.addRule(RelativeLayout.CENTER_HORIZONTAL,
						RelativeLayout.TRUE);
				param.setMargins(10, 10, 10, 15);

				EditText content_name = new EditText(Canvas.this);
				content_name.setEms(8);
				content_name.setId(1234);
				content_name.setBackgroundResource(R.drawable.edit_text_bg);
				TextView tick = new TextView(Canvas.this);
				tick.setText(R.string.icon_check_round);
				tick.setTypeface(font);
				tick.setTextSize(38);
				content_name.setLayoutParams(param);
				RelativeLayout.LayoutParams param2 = new RelativeLayout.LayoutParams(
						RelativeLayout.LayoutParams.WRAP_CONTENT,
						RelativeLayout.LayoutParams.WRAP_CONTENT);
				param2.addRule(RelativeLayout.CENTER_HORIZONTAL,
						RelativeLayout.TRUE);
				param2.addRule(RelativeLayout.BELOW, 1234);

				tick.setLayoutParams(param2);
				tick.setTextColor(Color.WHITE);
				linear.addView(content_name);
				linear.addView(tick);
				tick.setOnClickListener(new OnClickListener() {

					@SuppressWarnings("deprecation")
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						main.setBackgroundDrawable(new ColorDrawable(Color
								.parseColor("#FFFFFF")));
						enableMenus(menu, 1);
						dialog_box.dismiss();
					}
				});

				dialog_box.setContentView(linear);
				window = dialog_box.getWindow();
				window.setBackgroundDrawable(new ColorDrawable(Color
						.parseColor("#191919")));
				dialog_box.getWindow().setLayout(250, 120);
				WindowManager.LayoutParams wmlp = dialog_box.getWindow()
						.getAttributes();
				v.getLocationOnScreen(viewLocation);
				wmlp.gravity = Gravity.TOP | Gravity.LEFT;
				wmlp.x = viewLocation[0];
				wmlp.y = viewLocation[1];
				dialog_box.getWindow().clearFlags(
						WindowManager.LayoutParams.FLAG_DIM_BEHIND);
				dialog_box.show();
				break;
			case R.id.edit:
				Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
				intent.setType("file/*");
				startActivityForResult(intent, 1111);
				enableMenus(menu, 1);
				break;
			case R.id.photo:
				Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
				photoPickerIntent.setType("image/*");
				startActivityForResult(photoPickerIntent, 1001);
				break;
			case R.id.backgrnd:
				dialog_box = new Dialog(Canvas.this);
				dialog_box.requestWindowFeature(Window.FEATURE_NO_TITLE);
				LinearLayout parent = new LinearLayout(Canvas.this);
				parent.setOrientation(LinearLayout.VERTICAL);
				LinearLayout.LayoutParams parentParam = new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.WRAP_CONTENT,
						LinearLayout.LayoutParams.WRAP_CONTENT);
				parentParam.setMargins(10, 10, 10, 05);
				parent.setLayoutParams(parentParam);

				TextView child1 = new TextView(Canvas.this);
				child1.setEms(8);
				child1.setBackgroundResource(R.drawable.edit_text_bg);
				child1.setText("Browse");
				child1.setTextSize(20);

				TextView child2 = new TextView(Canvas.this);
				child2.setEms(8);
				child2.setBackgroundResource(R.drawable.edit_text_bg);
				child2.setText("Colour");
				child2.setTextSize(20);

				LinearLayout.LayoutParams textParam = new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.WRAP_CONTENT,
						LinearLayout.LayoutParams.WRAP_CONTENT);
				textParam.gravity = Gravity.CENTER_HORIZONTAL;

				child1.setLayoutParams(textParam);
				child2.setLayoutParams(textParam);
				child1.setOnClickListener(BgListener);
				child2.setOnClickListener(BgListener2);
				parent.addView(child1);
				parent.addView(child2);

				dialog_box.setContentView(parent);
				window = dialog_box.getWindow();
				window.setBackgroundDrawable(new ColorDrawable(Color
						.parseColor("#191919")));
				WindowManager.LayoutParams wmlp2 = dialog_box.getWindow()
						.getAttributes();
				v.getLocationOnScreen(viewLocation);
				wmlp2.gravity = Gravity.TOP | Gravity.LEFT;
				wmlp2.x = viewLocation[0];
				wmlp2.y = viewLocation[1];
				dialog_box.getWindow().clearFlags(
						WindowManager.LayoutParams.FLAG_DIM_BEHIND);
				dialog_box.show();
				break;
			case R.id.shut:
				finish();
				break;
			case R.id.text:
				dialog_box = new Dialog(Canvas.this);
				dialog_box.requestWindowFeature(Window.FEATURE_NO_TITLE);
				RelativeLayout linear2 = new RelativeLayout(Canvas.this);

				RelativeLayout.LayoutParams parm2 = new RelativeLayout.LayoutParams(
						RelativeLayout.LayoutParams.WRAP_CONTENT,
						RelativeLayout.LayoutParams.WRAP_CONTENT);
				parm2.addRule(RelativeLayout.CENTER_HORIZONTAL,
						RelativeLayout.TRUE);
				parm2.setMargins(10, 10, 10, 15);

				final EditText content_name1 = new EditText(Canvas.this);
				content_name1.setEms(8);
				content_name1.setId(1234);
				content_name1.setBackgroundResource(R.drawable.edit_text_bg);
				TextView tick1 = new TextView(Canvas.this);
				tick1.setText(R.string.icon_check_round);
				tick1.setTypeface(font);
				tick1.setTextSize(38);
				content_name1.setLayoutParams(parm2);
				RelativeLayout.LayoutParams param3 = new RelativeLayout.LayoutParams(
						RelativeLayout.LayoutParams.WRAP_CONTENT,
						RelativeLayout.LayoutParams.WRAP_CONTENT);
				param3.addRule(RelativeLayout.CENTER_HORIZONTAL,
						RelativeLayout.TRUE);
				param3.addRule(RelativeLayout.BELOW, 1234);

				tick1.setLayoutParams(param3);
				tick1.setTextColor(Color.WHITE);
				linear2.addView(content_name1);
				linear2.addView(tick1);
				tick1.setOnClickListener(new OnClickListener() {

					@SuppressWarnings("deprecation")
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						TextView my_text = new TextView(Canvas.this);
						my_text.setText(content_name1.getText().toString());
						my_text.setPadding(0, 0, 0, 0);
						my_text.bringToFront();
						my_text.setTextSize(18);
						my_text.setOnClickListener(textListener);
						main.addView(my_text);
						dialog_box.dismiss();
					}
				});

				dialog_box.setContentView(linear2);
				window = dialog_box.getWindow();
				window.setBackgroundDrawable(new ColorDrawable(Color
						.parseColor("#191919")));
				dialog_box.getWindow().setLayout(250, 120);
				WindowManager.LayoutParams wmlp1 = dialog_box.getWindow()
						.getAttributes();
				v.getLocationOnScreen(viewLocation);
				wmlp1.gravity = Gravity.TOP | Gravity.LEFT;
				wmlp1.x = viewLocation[0];
				wmlp1.y = viewLocation[1];
				dialog_box.getWindow().clearFlags(
						WindowManager.LayoutParams.FLAG_DIM_BEHIND);
				dialog_box.show();
				break;
			case R.id.music:
				Intent meIntent = new Intent(
						Intent.ACTION_PICK,
						android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
				startActivityForResult(meIntent, 10);
				break;
			case R.id.video:
				Intent intent_upload = new Intent();
				intent_upload.setType("video/*");
				intent_upload.setAction(Intent.ACTION_GET_CONTENT);
				startActivityForResult(intent_upload, 20);
				break;
			case R.id.floppy:
				Toast.makeText(Canvas.this, "Page Saved Successfully",
						Toast.LENGTH_SHORT).show();
				break;
			case R.id.close:
				main.setBackgroundResource(R.drawable.canvas_bg);
				main.removeAllViews();
				enableMenus(menu, 0);
				seek1.setProgress(0);
				seek2.setProgress(0);
				seek3.setProgress(0);
				seek4.setProgress(0);
				seek5.setProgress(0);
				seek6.setProgress(0);
				seek7.setProgress(0);
				break;
			case R.id.play:
				final Dialog dialog = new Dialog(Canvas.this);
				dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
				Display display = ((WindowManager) Canvas.this
						.getSystemService(Context.WINDOW_SERVICE))
						.getDefaultDisplay();
				int width = display.getWidth();
				int height = display.getHeight();
				dialog.setContentView(R.layout.container_dialog);
				RelativeLayout rl = (RelativeLayout) dialog
						.findViewById(R.id.bottom);
				LinearLayout ll = (LinearLayout) dialog.findViewById(R.id.top);
				View view = (View) dialog.findViewById(R.id.view);
				rl.setVisibility(View.GONE);
				ll.setVisibility(View.GONE);
				view.setVisibility(View.GONE);

				TextView cross = (TextView) dialog.findViewById(R.id.cross);
				Typeface font = Typeface.createFromAsset(
						Canvas.this.getAssets(), "fontawesome-webfont.ttf");
				cross.setTypeface(font);
				cross.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						dialog.dismiss();
					}
				});
				webView = (WebView) dialog.findViewById(R.id.webview);
				ImageView next = (ImageView) dialog.findViewById(R.id.next);
				next.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						displayNextPage(id);
					}
				});
				webView.addJavascriptInterface(this, "javaObj");
				webView.addJavascriptInterface(this, "cpjs");
				displayFocussedBrands(1);
				dialog.getWindow().setLayout(width - 80, height - 50);
				dialog.getWindow().setBackgroundDrawable(
						new ColorDrawable(android.graphics.Color.TRANSPARENT));
				dialog.show();

				break;
			default:
				break;
			}
		}
	};

	private void displayNextPage(int page) {
		// TODO Auto-generated method stub
		if (page != 1) {
			if (id + 1 == pageData.length) {
			} else {
				id++;
			}
		}
		String fd = "";

		webView.cancelLongPress();

		webView.setVisibility(View.VISIBLE);
		try {
			if (page == 1) {
				fd = menutext.toUpperCase();
			} else {
				fd = Utility.split(pageData[id][1], ".")[0].toUpperCase();
			}
			if (page == 1) {
				url = "file:///android_asset/" + fd + "/" + menutext + ".htm";
			} else {
				url = "file:///android_asset/" + fd + "/" + pageData[id][1];
			}
			webView.post(new Runnable() {
				@Override
				public void run() {
					webView.loadUrl(url);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void displayFocussedBrands(int id) {
		String fd = "";
		ReadWriteData rw = new ReadWriteData(Canvas.this, "MPOWERDB", null, 1);
		pageData = rw.getTableData("DVC", 9, " WHERE COL8 = 'F' ",
				"Order by CAST(COL9 as integer)");
		fd = Utility.split(pageData[id][1], ".")[0].toUpperCase();
		webView.getSettings().setPluginState(PluginState.ON);
		webView.getSettings().setJavaScriptEnabled(true);

		webView.getSettings().setAllowFileAccess(true);
		webView.setWebViewClient(new WebViewClient());

		final String url = "file:///android_asset/" + fd + "/"
				+ pageData[id][1];
		webView.post(new Runnable() {
			@Override
			public void run() {
				webView.loadUrl(url);
			}
		});
	}

	@android.webkit.JavascriptInterface
	public void sendToAndroid(String text) {
		String menutext = text;
		for (int i = 0; i < pageData.length; i++) {
			if (pageData[i][1].equalsIgnoreCase(menutext + ".htm")) {
				id = i;
				break;
			}
		}
		displayNextPage(1);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode,
			Intent imageReturnedIntent) {
		super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

		switch (requestCode) {
		case 1001:
			if (resultCode == RESULT_OK) {
				try {
					final Uri imageUri = imageReturnedIntent.getData();
					final InputStream imageStream = getContentResolver()
							.openInputStream(imageUri);
					final Bitmap selectedImage = BitmapFactory
							.decodeStream(imageStream);
					ImageView my_image = new ImageView(Canvas.this);
					my_image.setBackground(new BitmapDrawable(getResources(),
							selectedImage));
					my_image.setOnClickListener(imageListener);
					RelativeLayout.LayoutParams parms = new RelativeLayout.LayoutParams(
							200, 150);
					my_image.setLayoutParams(parms);
					main.addView(my_image);

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}

			}
			break;
		case 1002:
			if (resultCode == RESULT_OK) {
				try {
					final Uri imageUri = imageReturnedIntent.getData();
					final InputStream imageStream = getContentResolver()
							.openInputStream(imageUri);
					final Bitmap selectedImage = BitmapFactory
							.decodeStream(imageStream);
					main.setBackground(new BitmapDrawable(getResources(),
							selectedImage));

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}

			}
			break;
		case 10:
			if (resultCode == RESULT_OK) {
				Uri uriSound = imageReturnedIntent.getData();
				play(Canvas.this, uriSound);
				right3.setVisibility(View.VISIBLE);
				right2.setVisibility(View.INVISIBLE);
				right1.setVisibility(View.INVISIBLE);
			}
			break;
		case 20:
			if (resultCode == RESULT_OK) {
				Uri uri = imageReturnedIntent.getData();
				// String file = getRealPathFromURIForVideo(Canvas.this, uri);
				// String filename = file.substring(file.lastIndexOf("/") + 1);
				txtV.setText("Canvas_Video.mp4");
				VideoView view = new VideoView(Canvas.this);
				view.setLayoutParams(new LayoutParams(200, 150));
				main.addView(view);
				view.setOnTouchListener(videoListener);
				view.setVideoURI(uri);
				view.requestFocus();
				view.start();
			}
			break;
		}
	}

	private void play(Context context, Uri uri) {
		if (mPlayer == null)
			mPlayer = new MediaPlayer();
		else
			mPlayer.reset();
		String file = getRealPathFromURI(Canvas.this, uri);
		String filename = file.substring(file.lastIndexOf("/") + 1);
		txtm.setText(filename);
		try {
			mPlayer.setDataSource(context, uri);
		} catch (IllegalArgumentException | SecurityException
				| IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
		try {
			mPlayer.prepare();
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mPlayer.setLooping(true); // for repeat song
		mPlayer.start();
	}

	OnClickListener textListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			latestT = (TextView) v;
			existing_text.setText(latestT.getText());
			right2.setVisibility(View.VISIBLE);
			right1.setVisibility(View.INVISIBLE);
			right3.setVisibility(View.INVISIBLE);
		}
	};
	OnTouchListener videoListener = new OnTouchListener() {
		@Override
		public boolean onTouch(View v, MotionEvent event) {
			// TODO Auto-generated method stub
			latestI = (VideoView) v;
			txtV.setVisibility(View.VISIBLE);
			text5.setVisibility(View.GONE);
			anim.setVisibility(View.GONE);
			right2.setVisibility(View.INVISIBLE);
			right1.setVisibility(View.VISIBLE);
			right3.setVisibility(View.INVISIBLE);
			return true;
		}
	};
	OnClickListener imageListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			latestI = (ImageView) v;
			txtV.setVisibility(View.GONE);
			text5.setVisibility(View.VISIBLE);
			anim.setVisibility(View.VISIBLE);
			right1.setVisibility(View.VISIBLE);
			right2.setVisibility(View.INVISIBLE);
			right3.setVisibility(View.INVISIBLE);
		}
	};
	OnClickListener playListener1 = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if (mPlayer != null) {
				mPlayer.start();
			}
		}
	};
	OnClickListener playListener2 = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if (mPlayer != null) {
				if (mPlayer.isPlaying()) {
					mPlayer.pause();
				}
			}
		}
	};

	void enableMenus(TextView[] menus, int index) {
		for (int i = 0; i < menus.length; i++) {
			if (index == 0) {
				if (i == 0 || i == 1) {
					menus[i].setTextColor(Color.WHITE);
					menus[i].setEnabled(true);
					menus[i].setOnClickListener(menuListener);
				} else {
					menus[i].setTextColor(Color.parseColor("#7E7E7E"));
					menus[i].setEnabled(false);
					menus[i].setOnClickListener(null);
				}
			} else if (index == 1) {
				if (i == 0 || i == 1) {
					menus[i].setTextColor(Color.parseColor("#7E7E7E"));
					menus[i].setEnabled(false);
					menus[i].setOnClickListener(null);
				} else {
					menus[i].setEnabled(true);
					menus[i].setTextColor(Color.WHITE);
					menus[i].setOnClickListener(menuListener);
				}
			}
		}
	}

	void setBackground(View v) {
		ColorPickerDialog colorPickerDialog = new ColorPickerDialog(
				Canvas.this, Color.parseColor("#ffffff"),
				new OnColorSelectedListener() {
					@SuppressWarnings("deprecation")
					@Override
					public void onColorSelected(int color) {
						main.setBackgroundDrawable(new ColorDrawable(color));
					}

				});
		colorPickerDialog.getWindow().setLayout(250, 120);
		WindowManager.LayoutParams wmlp1 = dialog_box.getWindow()
				.getAttributes();
		v.getLocationOnScreen(viewLocation);
		wmlp1.gravity = Gravity.TOP | Gravity.LEFT;
		wmlp1.x = viewLocation[0];
		wmlp1.y = viewLocation[1];
		colorPickerDialog.getWindow().clearFlags(
				WindowManager.LayoutParams.FLAG_DIM_BEHIND);
		colorPickerDialog.show();
	}

	OnClickListener BgListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			dialog_box.dismiss();
			Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
			photoPickerIntent.setType("image/*");
			startActivityForResult(photoPickerIntent, 1002);
		}
	};
	OnClickListener BgListener2 = new OnClickListener() {
		@Override
		public void onClick(View v) {
			dialog_box.dismiss();
			setBackground(v);
		}
	};

	public String getRealPathFromURI(Context context, Uri contentUri) {
		Cursor cursor = null;
		try {
			String[] proj = { MediaStore.Images.Media.DATA };
			cursor = context.getContentResolver().query(contentUri, proj, null,
					null, null);
			int column_index = cursor
					.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
			cursor.moveToFirst();
			return cursor.getString(column_index);
		} finally {
			if (cursor != null) {
				cursor.close();
			}
		}
	}

	public String getRealPathFromURIForVideo(Context context, Uri contentUri) {
		Cursor cursor = null;
		try {
			String[] proj = { MediaStore.Video.Media.DATA };
			cursor = context.getContentResolver().query(contentUri, proj, null,
					null, null);
			int column_index = cursor
					.getColumnIndexOrThrow(MediaStore.Video.Media.DATA);
			cursor.moveToFirst();
			return cursor.getString(column_index);
		} finally {
			if (cursor != null) {
				cursor.close();
			}
		}
	}

}
