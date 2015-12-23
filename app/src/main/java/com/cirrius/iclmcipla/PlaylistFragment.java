package com.cirrius.iclmcipla;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Vector;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.app.TimePickerDialog;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.text.Html;
import android.text.InputFilter;
import android.text.InputType;
import android.util.Base64;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.TimePicker;

import com.cirrius.events.Events;
import com.cirrius.graph.Graphs;
import com.cirrius.graph.MyValueFormatter;
import com.cirrius.iclmcipla.MultiSpinner.MultiSpinnerListener;
import com.cirrius.iclmcipla.R;
import com.cirrius.invitees.CustomListIndexE;
import com.cirrius.invitees.UserListAdapter;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.Legend.LegendForm;
import com.github.mikephil.charting.components.Legend.LegendPosition;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.XAxis.XAxisPosition;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.components.YAxis.YAxisLabelPosition;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.utils.ValueFormatter;
import com.index.table.service.UserService;
import com.index.table.to.Book;

public class PlaylistFragment extends Fragment {
    Typeface font;
    private LinearLayout relativeDATA;
    private String[] tabNames;
    private RelativeLayout toadd[];
    private LinearLayout linearSecond;
    ArrayList<String> items = new ArrayList<String>();
    private int count;
    ArrayList<String> name;
    private boolean[] thumbnailsselection;
    private ListView listview;
    private LinearLayout linearone, linearthree;
    ImageView gesture;
    private TextView overallheader;
    String url = "";
    String menutext = "";
    String[][] pageData;
    private TextView happy;
    private TextView avg;
    private TextView sad, add;
    private TextView pencil;
    Dialog dialog_box;
    ImageView iv;
    ScrollView fullscroll, fullscrollEdit;
    TextView pen1;
    ImageView done;
    WebView webView;
    ArrayList<Integer> dealList;
    int id = 0;
    View vForAP;
    EditText focusedView;
    EditText edittextDuedate;
    Calendar myCalendar = Calendar.getInstance();
    private Button btnSeven;
    private Button btnEight;
    private Button btnNine;
    private Button btnFour;
    private Button btnFive;
    private Button btnSix;
    private Button btnOne;
    private Button btnTwo;
    private Button btnThree, btadd2;
    TextView txt1, txt2, txt3, txt4;
    int countMe = 0;
    int countMeL = 0;
    TableRow table1, table2;
    ImageView rehearse_icon;
    TextView plus;
    ImageView historyIcon;

    boolean flag1 = false;
    boolean flag2 = false;

    ArrayList<RelativeLayout> arrList;
    GridView photos;

    private Button zero;
    private Button ente;
    String[] ast2 = {"Reported", "Call by Call"};
    String parameters[] = {"Price", "Digitally Inclined", "Side Effects",
            "Availability"};

    protected BarChart mChart;
    protected String[] mMonths = new String[]{"Content", "Abstract", "Query",
            "Fourm", "Detailing", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov",
            "Dec"};
    TextView vForindciator;

    TextView globaltextchk;

    int iconint[] = {0, 1, 2, 2, 1};

    int iconcolor[] = {1, 1, 2, 2, 1};

    ListView mListView;

    Integer[] imageDoctor = {R.drawable.doc1, R.drawable.doct_1,
            R.drawable.doct_2, R.drawable.doct_3, R.drawable.doct_4};

    final String[] Drname = {"Alan Spiegel", "Alexander Fleming",
            "Alexander M. Kirschenbaum", "Alexis E. Te", "Alice Rusk"};

    String strTime[] = {"10:30 am", "11:00 am", "12:00 am", "12:45 pm",
            "01:30 pm", "Class B", "Class B", "Class A", "Class B", "Class C",
            "Class A"};

    String[] Specialty = {"Nuclear cardiology", "Cardiac electrophysiology",
            "Urologic oncology", "Urologic oncology", "Neuromuscular Medicine"};
    String[] Class = {"Class B", "Class A", "Class C", "Class C", "Class B"};
    private LinearLayout mainlayout, mainlayoutdialog;

    String imageData = "iVBORw0KGgoAAAANSUhEUgAAAOsAAAC0CAYAAAB10tv3AAAABHNCSVQICAgIfAhkiAAAGrVJREFU"
            + "eJztnU1u48gVxx81HvegJxjRQNKYIANQOgHlXXaiN9lKBrIXdQLJFxjR+wCmTyD6BKY3AbISfQKx"
            + "cwGyF8FgMklIB+lGj6K4srCLU1UkJUqi+CG9HyC0vtwqUfzzfdSrVxJkxPM8+YsvvugSQvqEkBYA"
            + "yADQyfr3CIIAAIALAKEkSb4kSfb//ve/x3a7HWb5Q2ndGzzPazUajQkhRN91lAiCxJEkyXp+fr5u"
            + "t9v+yvelveB5nvwq0jF97s2bN+Tt27dwenoKJycncHJyslbsCIL8wnK5JMvlEhaLBXz69Al+/vnn"
            + "SEOSJBnPz8+3aZY2UWye58mSJM3g1c39+uuviSzLKE4EyZnlcknCMISPHz9SbbmEkIskwcbE53le"
            + "51Wo8pdffkl+/etfw+npKYoUQfbIYrEg//jHP+C///2vBADhq2Bd9j2cCF8tqgcA8ps3b8i7d++g"
            + "0WigUBGkAJ6fn8nf//536hqHhJA2a2Eb9A7j+spv3rwh3377rYRCRZDiaDQa0rfffiu9efOGAIAs"
            + "SdLM8zw5ep15rwEAnS+//JK8e/eu6HEiCPLKu3fv4IsvviDwkjOKErwSwMv0zKv7C7/97W8JxqgI"
            + "Ui6LxYL88MMPEgDAqzvsU8tqALxkfVGoCFI+p6en0tdff01eHxoAANJrrBoAAPzud78jOD2DINVg"
            + "uVySv/3tb9S6njUAQAN4KXhAoSJIdTg5OaHJJgAArQEAfQCAt2/fljcqBEESYXTZbwBACwDg9PS0"
            + "rPEgCJICo8tWQ5IkBQDg5OSkvBEhCJJIo/GSA5YkqRlZVoxXEaR6MLMzncbKdyIIUhlQrAhSE1Cs"
            + "CFITUKwIUhNQrAhSE1CsCFITjmZyNQxDeHh4AN/3YTAYQKvVKntICLIRB29ZHceBy8tLODs7A13X"
            + "wTAMaLfbYNt22UNDkI2QfN8nAACKopQ9llwJwxAuLy/BcZzE1zudDszn82IHhSBb8OHDBwA4UDc4"
            + "DEM4Pz8H3/e551VVhffv3wMAgOu6CX+JHAO+70cC2AZVVUGW5fVvzJmDFOt4POaEOhgMwDAMaLVa"
            + "IElYVVkHXNeFp6cn7nEYhqmPWdK8qX3TarViuZBOpxMJm3292WxCp7PZhhYH6Qazgry/v4d+v5/4"
            + "GiEEkP3DWjJWZOz9sgRWFTRNi+6zAu90OvD582cAOEDLylpURVE4obInhKqqBY7qMAnDMAor6LGl"
            + "/4ZhWNlQQ1GUnWYDdnWjk2DPzbQL10GLddUPUkbMUTeoK0otoO/73G2fiHEha20Akl1OCmuliiTp"
            + "uLDCYz0J9kKXlYMTKzslI8YEaTHOMfP4+AgALycVtYZ5i5GNz1iRie5e3S+gSReQrBeONMvqui78"
            + "+OOPAHCAYr27u4vuiweKdcvKuvqWwePjY0yIqxI0m9DtdgHgl+PJiu6YjvGusMdKPG4HOXVjWVZ0"
            + "AorxKgAv1kOsYHJdFz58+ACu60bC3CVupK4otRiyLEdi3DSTiezOQYmVdYHH43HsdTZGqPPJRhMc"
            + "juNElnLbbCoVpKZpkQhXxYNIeRzU1A07LeN5HnfC+b4P7XYbAF5iqLrEr77vw/v378F1XXAcZyv3"
            + "FQVZbw7ODWYtS7fbjZ2I7OtVtqqPj4+cMDdJ9NApCU3TIjFi3Hg4HIxY11HF5JLrujGrmQWaXaUW"
            + "kt6vezYVWQ2KtUB834fHx0dwHAds287szna7XdA0jRMocnwcjVjpfCJAcW5wGIbw+PgItm1HyaB1"
            + "qKoKnU6HEyeCAByJWFmRNJvNvbqLrDjXubXNZjMSJf0XXVkkjYMRK3uSs6s1AHgXOG9LRTtQ2Lad"
            + "aUF7r9cDTdMicSJIVg5GrOyJL1q0vONV3/cjga6b36TxJr0hyLYcjFhXkce0DRWoZVkr3VtVVTlx"
            + "oluL5MVRiHXbyiXf9+H29nZt/KmqKui6Dv1+HzO1yN44eLHS1SQA2dYxZrWgvV4P+v0+9Pt9tJ5I"
            + "IRy8WNmkj1jYz3J3d7c2SYQCRcrk4MX68PAQ3U9aMnd3d8et1hEZDAaRQBGkTA5arGxtbbPZjAR3"
            + "d3cHpmmmurndbjeKQdGCIlXhoMVqWVZ0v9PpwNXVVaoVVRQFdF0HXdcxSYRUkoNdIkcIgXa7vbbE"
            + "bzAYgK7rOAeKVJaDWyInYtt2qlAVRYHxeAy6rqObi9SGgxXr5eVl7Llutwvj8RiTRUgtORixrnJ3"
            + "2Y78CFJXar+LXBiGcHV1FbVsEVEUBSzLQqEitafWltVxHBgOhyutKrq8yKFQW8t6dXUFFxcXa7O9"
            + "uq4XMh4E2Te1Eyvdd9U0zei5ZrMJs9ksajhNURQF14wiB0OtxBqGIVxcXHD1u71eD3zfT1zMjS4w"
            + "ckjUSqzD4ZArEZxMJmDbNrdfCgu6wMVSl17MdaU2Yh0Oh5xFnU6nYBgG9x6xwAFd4P3y8PAAw+EQ"
            + "zs7OQJIkODs7g+FwWPawtqaI3fF2wvd94vs+qTI3NzcEAKLbZDJJfN9gMODeFwRBsQM9EubzOel0"
            + "OtyxZm/39/dlD3FjptMpAQAiyzKZz+dlD4eDarTyltV1Xbi6uooe0wKHJNh2o/RvkXy5urqC8/Pz"
            + "XI+t7/ulutCWZUUeQRiG1d2FveqWtdVqRVdsVVVT3zefz2NX+DQLjGyHruvc8W02m2Q0GkVWiT6X"
            + "1aOZzWachS7DIs/ncyLLMve9PM8rfByrqIVltSyLW4+6qotD0tWwslfIGjIcDrklh71eD1zXBdM0"
            + "uTgvyxpg3/fh8vISLi4uOAvNTscVQRiGMBwOOasuy3J1F3dU2bJ2u93MVpJ9L3tDdke0qIPBgHu9"
            + "1+tFr02n05X/l2EYMUtGb91ud2/fIQnxe9Fb1eJWqtFKi5X9UVe5JkEQcAdbUZTofpUOeh1ZJ1RC"
            + "COfKzmazxP9nNptxIQ29NZvN6P7Nzc1+vwyDmLQUk5NVEmwtxKqqaqZ4ho2ZVFXd6EqPJBMEQSah"
            + "zmazlZ5MEARkPB7HRKqqKrm/vy8lVhQ/dzQaRd+FvXjIslyJ+LUWYh2NRtGB6/f7qe9jxXlzc0Mm"
            + "k0nsh0A2Q5yaSRJqEASc9yO+J8maNpvNyIKy1m1V8jBPxISS+Lme53GCTfreRVMLsXqex/3QaVZS"
            + "dJfZq33RcdAhwHoqqy54rKDZLHCaNe31elymmP37Ijyg2WwWE2pS5pq1vFU4f2ohVkJ46woAxDRN"
            + "7nX2wCqKQgiJx7DIZrCeSZplYd9DcwNBECQmkJrNZiyMYafaNpnu2RbTNGNjSopJgyDgLiJoWTcg"
            + "CAIudgUA0ul0okQGmxhgLQD7fqxk2gwxpjMMgzuGovs7Go3IeDxOzPL2er3EuI+9CO9TEEEQkH6/"
            + "z41JUZRMQi0yjl5FbcRKSLJgAYC0Wi3uBGF/AHYqJy1DiaQjToXJskw0TSOGYcRO/qSboigrk4Ls"
            + "/7+PYog0K5/m+lqWFXtvVZKTtRIrZTKZcMG/eKMnlK7rXGLDMIxS0vCmaRLTNGtp2YMgSJ27XifS"
            + "LCf5vjyfIAiIZVmJ00RJsbdt24l1zlURKiG/iFXyfZ/8+9//hn/9618QhmHlF2z7vg+maYJt21E/"
            + "1W0QdxlvtVpcnyZZlmPHQVXVzNUttm1HHRZvbm5gPB5vPdZtoL2pWq0WTCaTrf8fy7LAsqxY3TUL"
            + "3e1gk21GxB7Pu+L7frTTglhnrKoqmKYJmqaB67rw+PgIjuNwm5ax38WyrEqthY7O8/F4TL755puY"
            + "eynGKVWDzfiusrb7vmmaFrsZhkE0TYve0+/3ieM43G3fx5b9/DysxHw+J7PZjAtHut3u1h4LW7iy"
            + "ixts2/ZKt7zVahFd14mmaamVU/Q2GAwqec5HlvV1oInIsgymacJgMNjwWrB/dF2Hu7s7AHhZiUPr"
            + "iOmNtQaKooAsy9w+rVUjyZKL1h8gfed2tqWN7/tct8fJZJK6UmkTHMeBi4uL6PF0Ot16gb9hGHB9"
            + "fQ0AL17NfD6PfdcwDGO/Ga339n0fbNveebUO9Qqq3KqWWtZIrKqqQqvVAsdx4OnpiXuzpmkwnU4r"
            + "82XCMISzs7Po8Xw+j53o7MmQdLK6rsv90OLjpIXIruvGjk0dEF38NJIuDiysiynLcibXPgzDxOV0"
            + "ac8XQbfbjdoAVcndTYPbPuMPf/gD/OUvf4letCwLDMOI3uQ4Dpyfn8NsNqtEPMuuzuh2u1uNSfyb"
            + "bfe6EVf20JPQsqzo+DWbzdjnFSn8rB0QNlmlFIZhLtZ6H9BNs6m3Qv/NetGqKicAAN9//z33JN3u"
            + "0DTNyDqFYQjn5+c7uT55Qd1fgPL7LCWJvN/vw+3tbfS40+msFUKSpcm67C/JXTxkVFWNluLRi2BS"
            + "GHFonPzxj3+E7777LvaCLMtgGAZomgb9fj+yAnRFfVkiYTecots0Vo1VmzOnIctyTPjbWHs2C80y"
            + "m83W/m3ShcC2be5CMBqNNl7vmeV70OysmHWmVpK6rZqmVXe96Z45WRd30HR3v9+PfrThcAidTqeU"
            + "Kxm7ALqKQgWA2CL5IreTTLPgWSyPOE7HcSLPCuBFqPtaII5bbq6nkWRVRWjiSVXV6Lks3fDzJgxD"
            + "eHh4iB5XVayidSjyosYen2azGd3fNJlDuyhQut1u4Z0cEJ7MbV1kWQbHcaITgHbGLxLWYtHsdRVh"
            + "XWBFUQrLODqOw7XBYb2mTcVqGEbmljpIMWzUg4kKluK6bqEZQTZpU3RFUFZEURQ5NcC6rP1+n3Mt"
            + "NxGr4zjcsbYs62jjxEqxTW2w2BKjiJUJ4rK3dZUm7BKuorscsuMsqiY5qevCNksFgyDg6mp7vd6e"
            + "R46sY6fuhuPxmKuYKaILu+gC1+VKX4Sr7vs+9xsMBoNonlFRlOj5LNaV3UKT1ski1WDrVqRssoGm"
            + "3fcJ+/9XNbEEEM/G7jvWo7kDGicrisL9NuzFYt10kmVZ3HjR/a0WW4u10+lwNcNsvLQP2CxnldP8"
            + "oiD2LdbLy0vOYrIbdW2C67qcdR6NRrUoxTsmdmryzSaXHMfZ24nJ1u1mXcLHWrgip05EV/Ph4WFv"
            + "U1zD4ZD7ntPpdKvv6vs+V6CvqmplSwmPmZ3EKq6VZPekyRM2bspqVdm5ziItcVJcmPeJT+dA2eOS"
            + "VgbKijetoJ51o+k0Dbq/1WPn7TPG43E090qXpuUNK7wsrlmZyaikGt27u7vcYnq6oTR7nAeDQWoc"
            + "z3530UWn/xcrYsdxKjt/fezsLFZxqVTesavv+9zJlEWsYhF9UYhFCWxMf3l5ubNg6eon9niMRqOt"
            + "LpBJQt3WjUYKIo8eTEEQcN0a8uxfw87pZpnzE3eTK7I7ndhpManRm6ZpxLbtjToSJHXHz3qck+ab"
            + "k7r4VannEMJDNXqSh+CpdaVW9erqKtNuYllgl8NlsaqsZafzjUUQhmFs6R6t+NI0LXKP2Wkuur6S"
            + "rrkU11u6rpvYK4jGldvE4mkWtcrTYcgreXY3ZPvq5FE1tGkj6LL2TiGEt2BiF/cgCGIbH217S+vD"
            + "m2Vco9EILWoN2UsrUnHbhV379bIn+LpG0EmNp4tC/Oy0BmCe55HJZLJVi89ut7vV8RQ756NQ6wfX"
            + "ihQAuLK0XdA0LcrepjXCykIYhtButyP3L6nPEsvFxUXkXiqKAq7rFpYFNk0zmrZSFCXzvCqdP6bj"
            + "FvtA0VYk/X5/a3ee7UXFgq5vfYhakebd5FvchUvX9a3+H9ZK0z1s0hAXFhTdgZ8tfK+atUqyrFUb"
            + "I7KavXbkF2PHbU4OVgCrNtkVs79Fb/HIXlSazWahn50FsacuCrV+7H37DDbe3HQXaVEAaYklz/NW"
            + "7rVZBGwz7aKX4q1DnO7BvWrrSSTWP/3pT3sRqzjH2Ol0Mv8ta1XTBCDOFRaxbaCIuOt3lbq5J83L"
            + "Vu1igmQjEut3331H/vrXv+7lQ7ZxUbNaVfFkLGPjKdaqVmEfT0qSUFGs9SUSKwCQ8Xi8tw8Skz+r"
            + "9jURuxSknVziyVhGHCZOU1VhH09C4seGTfahWOsJJ9Zvvvlmry5cr9fj4te0E5vNXCqKkjgmUSRl"
            + "xGFlzumuGpNY8DAYDEptb4PkAyfWfZ9wQRBw1U1J8avneWstsCjUMlxPURRpF5Uyx8QeGxRr/YmJ"
            + "dd9xnxi/iicOG/+J5Xr078XMb9EiSSqoL3tX9fl8Hts4mA0LUKz1JxLr73//+60yttuQVrywrqa3"
            + "KkKtWl3t/f19bM9RcUwo1voTifXPf/4zt5nyvn9Qti6Wzr+yJ5z4+UlTNEUnc+bzeaqbWRZiSNBs"
            + "NhOtPJsv2GXTYqQ8uKKI77//vjCLIa59ZW9J8Z8o1KKnaEzTXGu9ikZ0xRVFST0u7MWxbJcd2Y5Y"
            + "BZO4EqTI+DXtZCpzimY+n3NxNL1YlCnUIAhi5YPrQgIUa/2JiVWsONq0RHBTxPi11Wpx7q0o1FX1"
            + "wXkSBAEZj8exC4mqqqUUXlA8z0t0xdfF7qxXUJW5YGQzEmuDRRdVluW9WZLRaJRoXXVdj1m0IuLD"
            + "IAiIYRgxl7cKiZnZbBYbV9YxsX+D1JPUQv75fB6LKfOucBJralfdihCqZVmx6Q+Alymksq2RaZqx"
            + "cWW9gLLhxrplhkh1WbnqxvO8WKOvTqeTS8yTtPGRYRipYm21WsQwjL24oLPZLFGkiqKUHt8lzelu"
            + "mmBjQ42ys9fI9qxdIhcEAZf2Z93UXayNuBg6ye1Mu8myTPr9PjFNcyfx2rYdc7WpSMvO9BKSXOiw"
            + "zdwyu0yxqJgfyZ/MbV1M0wTDMODp6Yl7XtM00HUder1epvYpvu/D4+PjylYidANgTdOiTZLEzxUR"
            + "OwTSsYmfTfsPi50C2c8dj8eld6K/vb2N7T07GAy26g3cbrejFjPr2uIg1YW2dcnUg8n3fTAMg2u1"
            + "yaJpGmiaFmulSZtes82vk1AUBXRdTxSLbdtgWRY4jrNWuNswGAzANM3SRUq3sWAbgdMtF7fZIMr3"
            + "fWi329FjQkgew0RKYKseTJ7n5dZSU1EUMhqNNnJn5/M5mU6nZDAYxGLqTW6qqpKbm5vSk0eUpLJB"
            + "VVV3Gt+mzdGR6rJTd0Pf9yOLl7S3yzq2deuSEDsEAsT3SKUWX5blnToF5k0YhnB9fc3tpwoAMJlM"
            + "dt7Miu0yiZ0M681GbvAqqFBc101tpSnLMrf3p+d5lRFMWbiuC5eXl1x4oCgKWJa18653YRjC2dlZ"
            + "9DgIgtLdfGR79taKNAm2RA6nEEjiVFWv18ttJRFb5F9GEzkkX3Ld62YVtm1zWzAe8ya9aUkk0zRz"
            + "dVPZ443u7+GwV7H6vs+5v6PR6GjdX9u2YTgccmGCqqpg23auxyQMQ3h4eIgeb5NJRqrJzvuzroLd"
            + "UVtRlKO1qtfX19yxAHhJIrmum/vFS9xI+lgvjofI3izrcDjkthW0bfvokhxJbm9eSaQ02LlwsbgC"
            + "qTn7SDCJy9+OsdQtqWQwzyRSEmLTubIbuSH5QDWauxtsWVa0oxrAy5zqsV3hXdeFi4sLblpmMpns"
            + "3btgXeCsZaBIfcjVDXZdlxOqqqq5FT/UBSpUGp/uUjK4Kbe3t9F9TCwdHrlZVvEkVVU1Vkl06FiW"
            + "Befn55xQHccpRDiu60aWvNlsolgPkFzEGoYhNy1BrckxuWGWZXHTVFSoRa10YT2Yfr9/VMf+WNhZ"
            + "rGEYwsXFRZT5LfokrQKiUFVVBd/3Cz0GbBYYrephsrNYr66uuCka0zSPXqiO4xRq2Wzb5uazUayH"
            + "yU5itSyLc7+ObXVHFYQKwGeBUaiHS27Z4MFgcFRCHQ6H3IWqLKGK5YXH9BscGzuJlT0xjukkqYpQ"
            + "AeIu8DGFIMfGzpb1mEQKEBdqngvpt4GdWz224pNjY6+F/IeGaZqVEqplWVwW/tgunMcGijUjvu/H"
            + "yijLrs66vr6O7lehMyOyX1CsGWGX91WhjNIwDK5iCV3gwwfFmhE24yo2OCsa27Y5q2oYBlrVI2Dn"
            + "hmnHANuDt9lsxpqEFz0Wtv642+0eXQ32sUEbpqFlzQC71K3MqRG6mJ2dqmELIpDDBsVaE8QabIDj"
            + "7L5xzKBYM8C2YHl8fCzcDU4S6nQ6xQKIIwPFmhFVVaP7RbqedJ2wKFScUz0+UKwZYcVxdXVViHV1"
            + "HAeFikSgWDOi63qUMaeL7ffJ7e1trD3M/f09CvWIQbFmRJZlrhCCbsyVN77vw8XFBVfkoChKYe1h"
            + "kOqCYt0ATdNgNBpFj8WF97tyd3cH5+fn3Lypqqrgui4mkxAU66YYhhElm8R5z22h1lTX9cSu/Tg9"
            + "gwCgWDeGusPNZhMAfhHaNoKl+7O22+1Y1/75fH60240gyaBYt6DT6XDxqtiGdR2+70ciFQVJrSm6"
            + "vYgI1gbvgNiDSZZlGI/H0U7rLI7jcBtPi3S73aNrNodkI7edz48dUbCbQnfXwykZJA0s5M8JXddh"
            + "NptBt9vd6O96vR5Mp1PwfR+FimQCLWuO2LYNruuC67qx+LXT6YAsy6Bp2t62e0QOE3SDEaQmoBuM"
            + "IDUDxYogNQHFiiA1AcWKIDUBxYogNQHFiiA1AcWKIDUBxYogNaFBCPkAALBcLknZg0EQhGexWBAA"
            + "AELI+wYA+AAAy+WyzDEhCJLA8/MzvRtGYl0sFmWNB0GQFBhd+g0AsAEAPn36VNqAEARJ5uPHj/Su"
            + "3QAABwDg559/ljBuRZDqsFwuyWKxkAAA2u223Wi32yEh5A4ASt0dDUEQHqpHqk86dWMAAHz8+FGi"
            + "2ScEQcpjsViQjx8/Sq8PDYBXsbbbbZ8Qcg0A8M9//hOen59RsAhSEs/Pz+Snn34CAABCyHW73fYB"
            + "+KIIkxDyfrFYSPSNCIIUz08//QTL5VIihLwHAJM+L7Fv8jxPBgBfkqTmV199RX7zm99Ao9GQxP8M"
            + "QZD8oRb18+fPEiHkCQBa7XY7SiRx5YavL2iEkKfPnz9LP/74I2AMiyD7Z7FYkB9++IEVqsYKFUCw"
            + "rJRXC+tIkqQCAPzqV78izWYTTk5O0MoiSI4sl0vy9PQE//nPfySAl7JCSBAqQIpYASLBjiVJmtDn"
            + "vvrqK/L27Vs4PT0FSZLg9PQUxYsgG7BYLAghBBaLBXz69Ak+f/4caeg1yWsmCRVghVgpnue1AMCQ"
            + "JGmQ24gRBIl4nUc1aNY3jcyW8dXSagDQB4AWAMjUTUYQJBuvbm4ILzX5NgA4aZZU5P9q8+yQK4XT"
            + "ggAAAABJRU5ErkJggg==";
    private Typeface mTf;
    private TextView td1, td3, td2;
    private LinearLayout ly2;
    private LinearLayout ly3;

    int iconmode_gl = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        String index = getArguments().getString("index");
        font = Typeface.createFromAsset(getActivity().getAssets(),
                "fontawesome-webfont.ttf");

        mTf = Typeface.createFromAsset(getActivity().getAssets(),
                "OpenSans-Regular.ttf");
        View view = getView(index, inflater, container);
        return view;
    }

    public View getView(String index, LayoutInflater inflater,
                        ViewGroup container) {
        View v = null;
        if (index.equals("1")) {

            View v1 = getMyView(0);

            View v2 = inflater.inflate(R.layout.history, null);

            View vfeed = v2.findViewById(R.id.feed1);

            ImageView gestures = (ImageView) v2.findViewById(R.id.gestures);
            byte[] data = Base64.decode(imageData, 0);
            Bitmap bpp = BitmapFactory.decodeByteArray(data, 0, data.length);
            gestures.setImageBitmap(bpp);

            overallheader = (TextView) vfeed.findViewById(R.id.overallheader);
            happy = (TextView) vfeed.findViewById(R.id.happy);

            happy.setTypeface(font);
            // happy.setOnClickListener(feedListener);
            happy.setTextColor(Color.parseColor("#4fc3f7"));
            avg = (TextView) vfeed.findViewById(R.id.avg);
            avg.setTypeface(font);
            // avg.setOnClickListener(feedListener);

            sad = (TextView) vfeed.findViewById(R.id.sad);
            sad.setTypeface(font);
            // sad.setOnClickListener(feedListener);
            mainlayout = (LinearLayout) vfeed.findViewById(R.id.mainlayout);
            ly2 = (LinearLayout) vfeed.findViewById(R.id.brndAdd2);
            ly3 = (LinearLayout) vfeed.findViewById(R.id.mainlayout2);
            addbrandsForHistory(4);
            addbrandsForHistory(4, 1);

            TextView tp1 = (TextView) v2.findViewById(R.id.t1);

            TextView tp2 = (TextView) v2.findViewById(R.id.t2);
            TextView tp3 = (TextView) v2.findViewById(R.id.t3);
            TextView tp4 = (TextView) v2.findViewById(R.id.t4);

            TextView tp5 = (TextView) v2.findViewById(R.id.t5);
            TextView tp6 = (TextView) v2.findViewById(R.id.t6);

            TextView tp7 = (TextView) v2.findViewById(R.id.t7);

            TextView tp8 = (TextView) v2.findViewById(R.id.t8);
            TextView tp9 = (TextView) v2.findViewById(R.id.t9);
            TextView tp10 = (TextView) v2.findViewById(R.id.t10);

            TextView tp11 = (TextView) v2.findViewById(R.id.textcalender);

            TextView tp12 = (TextView) v2.findViewById(R.id.textclock);
            TextView tp13 = (TextView) v2.findViewById(R.id.textlocation);

            tp1.setTypeface(font);
            tp2.setTypeface(font);
            tp3.setTypeface(font);
            tp4.setTypeface(font);
            tp5.setTypeface(font);
            tp6.setTypeface(font);
            tp7.setTypeface(font);
            tp8.setTypeface(font);

            tp9.setTypeface(font);

            tp10.setTypeface(font);
            tp11.setTypeface(font);
            tp12.setTypeface(font);
            tp13.setTypeface(font);

            TextView tm1 = (TextView) v2.findViewById(R.id.tm1);

            TextView tm2 = (TextView) v2.findViewById(R.id.tm2);
            TextView tm3 = (TextView) v2.findViewById(R.id.tm3);
            TextView tm4 = (TextView) v2.findViewById(R.id.tm4);

            TextView tm5 = (TextView) v2.findViewById(R.id.tm5);

            tm1.setText(Html.fromHtml("BRAND" + "<br/><b>" + "Solsuna"
                    + "</b> "));
            tm2.setText(Html.fromHtml("BRAND" + "<br/><b>" + "Mezzo Drop"
                    + "</b> "));
            tm3.setText(Html.fromHtml("SERVICE" + "<br/><b>"
                    + "Inhalation/Nasal Product" + "</b> "));
            tm4.setText(Html.fromHtml("THERAPY" + "<br/><b>" + "Asthama"
                    + "</b> "));
            tm5.setText(Html
                    .fromHtml("THERAPY" + "<br/><b>" + "Skin" + "</b> "));

            td1 = (TextView) v2.findViewById(R.id.txtdate1);
            td2 = (TextView) v2.findViewById(R.id.txtdate2);
            td3 = (TextView) v2.findViewById(R.id.txtdate3);
            td1.setText(Html.fromHtml("<b>" + " 1 AUG" + "</b> "
                    + "12.30pm<br/>" + "Sat"));
            td2.setText(Html.fromHtml("<b>" + " 1 AUG" + "</b> "
                    + "12.30pm<br/>" + "Sat"));
            td3.setText(Html.fromHtml("<b>" + " 1 AUG" + "</b> "
                    + "12.30pm<br/>" + "Sat"));

            relativeDATA = (LinearLayout) v2.findViewById(R.id.relativeDATA);
            tabNames = new String[]{"q", "Additional Info", "Call History ",
                    "Call History ", "Call History ", "q", "Additional Info",
                    "Call History ", "Call History ", "Call History "};

            String day[] = {"20 JUN", "3 JUL", "15 JUL", "1 AUG", "31 AUG",
                    "01th OCT", "07th OCT", "15th OCT", "20th OCT", "27th OCT"};
            String weekday[] = {"Sat", "Fri", "Sat", "Sat", "Sat", "Fri",
                    "Sat", "Fri", "Sat", "Sat"};
            String time[] = {"12.30pm", "12.30pm", "12.30pm", "12.30pm",
                    "12.30pm", "12.30pm", "12.30pm", "12.30pm", "12.30pm",
                    "12.30pm"};

            String[][] clockkkdata = {
                    {"111", "101", "100", "100", "100", "100"},
                    {"211", "101", "300", "300", "300", "300"},
                    {"111", "101", "100", "100", "100", "100"},
                    {"111", "101", "100", "100", "100", "100"}};

            String[][] namedata = {
                    {"Introduction \nC-FIX", "Types of CVD\nC-FIX",
                            "Risk Factors of CVD\nC-FIX",
                            "Risk Factors of CVD\nMezzo Drop",
                            "Types of CVD\nMezzo Drop",
                            "Risk Factors of CVD\nC-FIX"},

                    {"Research\nMezzo Drop", "Types of CVD\nJade Dew Pill",
                            "Open Heart Surgery\nJade Dew Pill",
                            "Research Paper\nJade Dew Pill",
                            "Types of CVD\nSolsuna",
                            "Open Heart Surgery\nSolsuna"},
                    {"Introduction \nSolsuna", "Types of CVD\nSolsuna",
                            "Risk Factors of CVD\nZepin",
                            "Risk Factors of CVD\nZepin",
                            "Types of CVD\nZepin", "Risk Factors of CVD\nC-FIX"},
                    {"Risk Factors of CVD\nAcenomorol",
                            "Types of CVD\nAcenomorol",
                            "Open Heart Surgery\nAcenomorol",
                            "Research Paper\nDempi", "Types of CVD\nDempi",
                            "Open Heart Surgery\nDempi"}};

            Integer[][] imagedata = {
                    {R.drawable.screen2, R.drawable.newcfix1,
                            R.drawable.newcfix3, R.drawable.mezzodrop1,
                            R.drawable.mezzodrop2, R.drawable.newcfix3},

                    {R.drawable.mezzodrop3, R.drawable.dew1, R.drawable.dew2,
                            R.drawable.dew3, R.drawable.solsuna2,
                            R.drawable.solsuna},

                    {R.drawable.solsuna, R.drawable.solsuna3, R.drawable.zep1,
                            R.drawable.zep2, R.drawable.zep3,
                            R.drawable.newcfix3},
                    {R.drawable.ac1, R.drawable.ac2, R.drawable.ac3,
                            R.drawable.dem1, R.drawable.dem2, R.drawable.dem3}};

            toadd = new RelativeLayout[tabNames.length];

            // for (int i = 0; i < tabNames.length; i++) {
            for (int i = 0; i < 5; i++) {

                toadd[i] = new RelativeLayout(getActivity());
                toadd[i].setId(i);
                TextView tv = new TextView(getActivity());
                TextView tv1 = new TextView(getActivity());
                TextView tv2 = new TextView(getActivity());

                tv.setText(day[i]);
                tv1.setText(weekday[i]);
                tv2.setText(time[i]);

                tv.setTextColor(Color.parseColor("#BDBDBD"));
                tv.setTypeface(null, Typeface.BOLD);
                tv.setPadding(20, 10, 10, 0);
                tv.setTextSize(20);

                tv1.setTextColor(Color.parseColor("#BDBDBD"));
                tv1.setTypeface(null, Typeface.BOLD);
                tv1.setPadding(20, 35, 10, 0);
                tv1.setTextSize(17);

                tv2.setTextSize(17);
                tv2.setTextColor(Color.parseColor("#BDBDBD"));
                tv2.setX(95);
                tv2.setY(13);

                // ImageView joint = new ImageView(getActivity());
                // joint.setImageResource(R.drawable.jointworkingnew);
                // joint.setLayoutParams(new
                // android.widget.LinearLayout.LayoutParams(
                // 30, 30));
                // joint.setX(95);
                // joint.setY(32);

                if (i == 3) {
                    tv.setTextColor(Color.parseColor("#ffffff"));
                    tv1.setTextColor(Color.parseColor("#ffffff"));
                    tv2.setTextColor(Color.parseColor("#ffffff"));
                }

                LinearLayout.LayoutParams llps = new LinearLayout.LayoutParams(
                        250, LinearLayout.LayoutParams.WRAP_CONTENT);
                toadd[i].setLayoutParams(llps);

                toadd[i].addView(tv);
                toadd[i].addView(tv1);
                toadd[i].addView(tv2);
                // if (i == 3) {
                // toadd[i].addView(joint);
                // }
                relativeDATA.addView(toadd[i]);
                toadd[i].setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        for (int i = 0; i < 5; i++) {
                            TextView child = (TextView) toadd[i].getChildAt(0);
                            TextView child1 = (TextView) toadd[i].getChildAt(1);
                            TextView child2 = (TextView) toadd[i].getChildAt(2);
                            if (v.getId() == i) {
                                child.setTextColor(Color.WHITE);
                                child1.setTextColor(Color.WHITE);
                                child2.setTextColor(Color.WHITE);

                                td1.setText(Html.fromHtml("<b>"
                                        + child.getText() + "</b> "
                                        + child2.getText() + "<br/>"
                                        + child1.getText()));
                                td2.setText(Html.fromHtml("<b>"
                                        + child.getText() + "</b> "
                                        + child2.getText() + "<br/>"
                                        + child1.getText()));
                                td3.setText(Html.fromHtml("<b>"
                                        + child.getText() + "</b> "
                                        + child2.getText() + "<br/>"
                                        + child1.getText()));
                            } else {
                                child.setTextColor(Color.parseColor("#BDBDBD"));
                                child1.setTextColor(Color.parseColor("#BDBDBD"));
                                child2.setTextColor(Color.parseColor("#BDBDBD"));
                            }
                        }
                    }
                });

            }
            linearSecond = (LinearLayout) v2.findViewById(R.id.relativeSecond);

            for (int i = 0; i < 4; i++) {

                LinearLayout linearlayout = new LinearLayout(getActivity());
                LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
                linearlayout.setLayoutParams(param);
                linearlayout.setOrientation(LinearLayout.HORIZONTAL);

                for (int j = 0; j < 5; j++) {

                    String str = clockkkdata[i][j];

                    RelativeLayout convertView = Utility.getThumnailnik(
                            getActivity(), imagedata[i][j], namedata[i][j],
                            R.string.clock, R.string.thumb, R.string.mail);

                    RelativeLayout rl = (RelativeLayout) convertView
                            .getChildAt(3);
                    TextView tv1 = (TextView) rl.getChildAt(0);
                    TextView tv2 = (TextView) rl.getChildAt(1);
                    TextView tv3 = (TextView) rl.getChildAt(2);
                    TextView tv4 = (TextView) rl.getChildAt(3);
                    if (str.charAt(0) == '1' || str.charAt(0) == '2'
                            || str.charAt(0) == '3') {
                        if (str.charAt(0) == '1') {

                            tv1.setVisibility(View.VISIBLE);
                            tv4.setVisibility(View.VISIBLE);
                        } else if (str.charAt(0) == '2') {

                            tv1.setText(R.string.pencil);
                            tv4.setVisibility(View.INVISIBLE);
                        } else {
                            tv1.setText(R.string.pin);
                            tv4.setVisibility(View.INVISIBLE);
                        }

                    } else {
                        tv4.setVisibility(View.INVISIBLE);
                        tv1.setVisibility(View.INVISIBLE);
                    }
                    if (str.charAt(1) == '1') {
                        tv2.setVisibility(View.VISIBLE);
                    } else {
                        tv2.setVisibility(View.INVISIBLE);
                    }
                    if (str.charAt(2) == '1') {
                        tv3.setVisibility(View.VISIBLE);
                    } else {
                        tv3.setVisibility(View.INVISIBLE);
                    }

                    linearlayout.addView(convertView);

                }
                linearSecond.addView(linearlayout);
            }

            View v3 = actionPointView(getActivity(), "0");

            View v4 = inflater.inflate(R.layout.campaign, null);
            TextView pen = (TextView) v4.findViewById(R.id.pen);
            pen.setTypeface(font);
            v4.setVisibility(View.GONE);

            ListView list4 = (ListView) v4.findViewById(R.id.list);
            list4.setAdapter(new CampaignListAdapter(getActivity(), 1));

            ListView list5 = (ListView) v4.findViewById(R.id.list2);
            list5.setAdapter(new CampaignListAdapter(getActivity(), 2));

            View v5 = inflater.inflate(R.layout.profile, null);
            LinearLayout card1 = (LinearLayout) v5.findViewById(R.id.card1);
            LinearLayout card2 = (LinearLayout) v5.findViewById(R.id.card2);
            LinearLayout card3 = (LinearLayout) v5.findViewById(R.id.card3);
            LinearLayout card4 = (LinearLayout) v5.findViewById(R.id.card4);
            LinearLayout card5 = (LinearLayout) v5.findViewById(R.id.card5);
            LinearLayout card6 = (LinearLayout) v5.findViewById(R.id.card6);
            LinearLayout card7 = (LinearLayout) v5.findViewById(R.id.card7);
            LinearLayout card8 = (LinearLayout) v5.findViewById(R.id.card8);
            TextView pencil = (TextView) v5.findViewById(R.id.edit);
            pencil.setTypeface(font);
            EditText search = (EditText) v5.findViewById(R.id.searchtxt);
            search.setCompoundDrawablesWithIntrinsicBounds(R.drawable.search12,
                    0, R.drawable.cancel12, 0);

            TextView edit = (TextView) v5.findViewById(R.id.edit);
            edit.setOnClickListener(cardEditListener);

            card1.setId(1);
            card2.setId(2);
            card3.setId(3);
            card4.setId(4);
            card5.setId(5);
            card6.setId(6);
            card7.setId(7);
            card8.setId(8);

            card1.setOnClickListener(cardListener);
            card2.setOnClickListener(cardListener);
            card3.setOnClickListener(cardListener);
            card4.setOnClickListener(cardListener);
            card5.setOnClickListener(cardListener);
            card6.setOnClickListener(cardListener);
            card7.setOnClickListener(cardListener);
            card8.setOnClickListener(cardListener);

            View v6 = inflater.inflate(R.layout.physifragment, null);

            mChart = (BarChart) v6.findViewById(R.id.chart1);
            final WebView wv1 = (WebView) v6.findViewById(R.id.chart2);
            final WebView wv2 = (WebView) v6.findViewById(R.id.chart3);
            final TextView three = (TextView) v6.findViewById(R.id.three);
            final TextView three1 = (TextView) v6.findViewById(R.id.three1);
            final TextView three2 = (TextView) v6.findViewById(R.id.three2);
            three.setOnClickListener(touchListener);
            three1.setOnClickListener(touchListener);
            three2.setOnClickListener(touchListener);

            getsinglebarchart(v6);
            BarChart chart = multibarchart();

            for (DataSet<?> set : chart.getData().getDataSets())
                set.setDrawValues(!set.isDrawValuesEnabled());

            chart.invalidate();

            wv1.addView(chart, new LayoutParams(330,
                    android.view.ViewGroup.LayoutParams.MATCH_PARENT));
            BarChart chart1 = multibarchart();

            for (DataSet<?> set : chart1.getData().getDataSets())
                set.setDrawValues(!set.isDrawValuesEnabled());

            chart1.invalidate();
            wv2.addView(chart1, new LayoutParams(330,
                    android.view.ViewGroup.LayoutParams.MATCH_PARENT));

            // wv.setOnTouchListener(this);
            // View v7 = getMyView(1);
            View v7 = inflater.inflate(R.layout.focus_brands, null);
            final GridView ll = (GridView) v7.findViewById(R.id.focus);

            final RelativeLayout rl1 = Utility.getThumnailForPhysi(
                    getActivity(), R.drawable.stelpep, "", 0, 0, 1, "Stel Pep");
            rl1.setPadding(0, 0, 3, 0);
            final RelativeLayout rl2 = Utility.getThumnailForPhysi(
                    getActivity(), R.drawable.stillsep2, "", 0, 0, 1,
                    "Still Sep");
            rl2.setPadding(0, 0, 3, 0);
            final RelativeLayout rl3 = Utility.getThumnailForPhysi(
                    getActivity(), R.drawable.solsuna, "", 0, 0, 1, "Solsuna");
            rl3.setPadding(0, 0, 3, 0);
            RelativeLayout rl4 = Utility.getThumnailForPhysi(getActivity(),
                    R.drawable.dempi, "", 0, 0, 1, "Dempi");
            rl4.setPadding(0, 0, 3, 0);
            RelativeLayout rl5 = Utility.getThumnailForPhysi(getActivity(),
                    R.drawable.mezom1, "", 0, 0, 1, "Mezzo Drop");
            rl5.setPadding(0, 0, 3, 0);
            RelativeLayout rl6 = Utility.getThumnailForPhysi(getActivity(),
                    R.drawable.newcfix2, "", 0, 0, 1, "C-FIX");
            rl6.setPadding(0, 0, 3, 0);
            RelativeLayout rl7 = Utility.getThumnailForPhysi(getActivity(),
                    R.drawable.solsuna, "", 0, 0, 1, "Solsuna");
            rl7.setPadding(0, 0, 3, 0);

            RelativeLayout rl8 = Utility.getThumnailForPhysi(getActivity(),
                    R.drawable.solsuna2, "", 0, 0, 1, "Solsuna");
            rl8.setPadding(0, 0, 3, 0);
            RelativeLayout rl9 = Utility.getThumnailForPhysi(getActivity(),
                    R.drawable.zepine, "", 0, 0, 1, "Zepine");
            rl9.setPadding(0, 0, 3, 0);
            RelativeLayout rl10 = Utility.getThumnailForPhysi(getActivity(),
                    R.drawable.ratiozep, "", 0, 0, 1, "Ratio Zep");
            rl10.setPadding(0, 0, 3, 0);
            RelativeLayout rl11 = Utility.getThumnailForPhysi(getActivity(),
                    R.drawable.newace, "", 0, 0, 1, "Acenomorol");
            rl11.setPadding(0, 0, 3, 0);
            rl1.setTag("1");
            rl2.setTag("1");
            rl3.setTag("1");
            rl4.setTag("1");
            rl5.setTag("1");
            rl6.setTag("1");
            rl7.setTag("1");
            rl8.setTag("1");
            rl9.setTag("1");
            rl10.setTag("1");
            rl11.setTag("1");

            rl1.setOnClickListener(focusListener);
            rl2.setOnClickListener(focusListener);
            rl3.setOnClickListener(focusListener);
            rl4.setOnClickListener(focusListener);
            rl5.setOnClickListener(focusListener);
            rl6.setOnClickListener(focusListener);
            rl7.setOnClickListener(focusListener);
            rl8.setOnClickListener(focusListener);
            rl9.setOnClickListener(focusListener);
            rl10.setOnClickListener(focusListener);
            rl11.setOnClickListener(focusListener);

            final ArrayList<RelativeLayout> arrList = new ArrayList<RelativeLayout>();
            arrList.add(rl1);
            arrList.add(rl2);
            arrList.add(rl3);
            arrList.add(rl4);
            arrList.add(rl5);
            arrList.add(rl6);
            arrList.add(rl7);
            arrList.add(rl8);
            arrList.add(rl9);
            arrList.add(rl10);
            arrList.add(rl11);

            ll.setAdapter(new GridAdapter(getActivity(), arrList, 5));

            final EditText search2 = (EditText) v7.findViewById(R.id.searchtxt);
            search2.setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.search12, 0, R.drawable.cancel12, 0);
            done = (ImageView) v7.findViewById(R.id.done);
            final ImageView cancel = (ImageView) v7.findViewById(R.id.cancel);
            final ImageView undo = (ImageView) v7.findViewById(R.id.undo);
            undo.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    undo.setVisibility(View.INVISIBLE);
                }
            });

            pen1 = (TextView) v7.findViewById(R.id.pen);
            pen1.setTypeface(font);
            pen1.setTag("1");
            pen1.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    if (pen1.getTag().equals("1")) {
                        pen1.setText(getResources().getString(
                                R.string.icon_three_dot));
                        done.setVisibility(View.VISIBLE);
                        cancel.setVisibility(View.VISIBLE);

                        final int size = ll.getChildCount();
                        for (int i = 0; i < size; i++) {
                            ViewGroup gridChild = (ViewGroup) ll.getChildAt(i);
                            if (gridChild.getChildAt(2) instanceof ImageView) {
                                gridChild.getChildAt(2).setVisibility(
                                        View.INVISIBLE);
                            }
                        }
                        pen1.setTag("2");
                    } else {
                        pen1.setTag("1");
                    }
                    // else {
                    // final RelativeLayout rl2 = Utility.getThumnailForPhysi(
                    // getActivity(), R.drawable.stillsep2, "", 0, 0,
                    // 0, "Still Sep");
                    // rl2.setPadding(0, 0, 2, 0);
                    // final RelativeLayout rl1 = Utility.getThumnailForPhysi(
                    // getActivity(), R.drawable.stelpep, "", 0, 1, 1,
                    // "Stel Pep");
                    // rl1.setPadding(0, 0, 2, 0);
                    // final RelativeLayout rl3 = Utility.getThumnailForPhysi(
                    // getActivity(), R.drawable.solsuna, "", 0, 0, 1,
                    // "Solsuna");
                    //
                    // final ArrayList<RelativeLayout> arrList = new
                    // ArrayList<RelativeLayout>();
                    // arrList.add(rl1);
                    // arrList.add(rl2);
                    // arrList.add(rl3);
                    // ll.setAdapter(new GridAdapter(getActivity(), arrList,
                    // 0));
                    // pen1.setTag("1");
                    // }
                }
            });
            done.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    pen1.setText(getResources().getString(R.string.icon_pen));
                    done.setVisibility(View.INVISIBLE);
                    cancel.setVisibility(View.INVISIBLE);
                    undo.setVisibility(View.INVISIBLE);
                    pen1.setTag("1");
                    // final int size = ll.getChildCount();
                    // for (int i = 0; i < size; i++) {
                    // ViewGroup gridChild = (ViewGroup) ll.getChildAt(i);
                    // if (gridChild.getChildAt(2) instanceof ImageView) {
                    // gridChild.getChildAt(2).setVisibility(
                    // View.INVISIBLE);
                    // }
                    // }
                }
            });
            cancel.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    pen1.setText(getResources().getString(R.string.icon_pen));
                    done.setVisibility(View.INVISIBLE);
                    cancel.setVisibility(View.INVISIBLE);
                    undo.setVisibility(View.INVISIBLE);
                    pen1.setTag("1");
                    // final int size = ll.getChildCount();
                    // for (int i = 0; i < size; i++) {
                    // ViewGroup gridChild = (ViewGroup) ll.getChildAt(i);
                    // if (gridChild.getChildAt(2) instanceof ImageView) {
                    // gridChild.getChildAt(2).setVisibility(
                    // View.INVISIBLE);
                    // }
                    // }
                }
            });

            // LinearLayout ll1 = (LinearLayout)
            // v7.findViewById(R.id.focusesec1);
            // LinearLayout ll2 = (LinearLayout)
            // v7.findViewById(R.id.focusesec2);
            //
            // RelativeLayout rll1 = Utility.getThumnailForPhysi(getActivity(),
            // R.drawable.dempi, "", 0, 1, 1, "Dempi");
            // rll1.setPadding(0, 0, 2, 0);
            // RelativeLayout rll2 = Utility.getThumnailForPhysi(getActivity(),
            // R.drawable.mezom1, "", 0, 0, 0, "Mezzo Drop");
            // rll2.setPadding(0, 0, 2, 0);
            // RelativeLayout rll3 = Utility.getThumnailForPhysi(getActivity(),
            // R.drawable.newcfix2, "", 0, 0, 1, "C-FIX");
            // rll3.setPadding(0, 0, 2, 0);
            // RelativeLayout rll4 = Utility.getThumnailForPhysi(getActivity(),
            // R.drawable.solsuna, "", 0, 0, 1, "Solsuna");
            // rll4.setPadding(0, 0, 2, 0);
            //
            // RelativeLayout rll5 = Utility.getThumnailForPhysi(getActivity(),
            // R.drawable.solsuna2, "", 0, 1, 1, "Solsuna");
            // rll5.setPadding(0, 0, 2, 0);
            // RelativeLayout rll6 = Utility.getThumnailForPhysi(getActivity(),
            // R.drawable.zepine, "", 0, 0, 0, "Zepine");
            // rll6.setPadding(0, 0, 2, 0);
            // RelativeLayout rll7 = Utility.getThumnailForPhysi(getActivity(),
            // R.drawable.ratiozep, "", 0, 0, 1, "Ratio Zep");
            // rll7.setPadding(0, 0, 2, 0);
            // RelativeLayout rll8 = Utility.getThumnailForPhysi(getActivity(),
            // R.drawable.newace, "", 0, 0, 1, "Acenomorol");
            // rll8.setPadding(0, 0, 2, 0);
            //
            // ll1.addView(rll1);
            // ll1.addView(rll2);
            // ll1.addView(rll5);
            // ll1.addView(rll6);
            // ll2.addView(rll3);
            // ll2.addView(rll4);
            // ll2.addView(rll7);
            // ll2.addView(rll8);
            // RelativeLayout rl[] = { rll1, rll2, rll3, rll4, rll5, rll6, rll7,
            // rll8 };
            // for (int i = 0; i < rl.length; i++) {
            // ImageView play = (ImageView) rl[i].getChildAt(1);
            // ImageView delete = (ImageView) rl[i].getChildAt(2);
            // play.setVisibility(View.INVISIBLE);
            // delete.setVisibility(View.INVISIBLE);
            // }
            //
            // rll1.setOnLongClickListener(new mylongclick2());
            // rll1.setOnDragListener(new MyDragListener(getActivity(), arrList,
            // 1));
            // rll2.setOnLongClickListener(new mylongclick2());
            // rll2.setOnDragListener(new MyDragListener(getActivity(), arrList,
            // 1));
            // rll3.setOnLongClickListener(new mylongclick2());
            // rll3.setOnDragListener(new MyDragListener(getActivity(), arrList,
            // 1));
            // rll4.setOnLongClickListener(new mylongclick2());
            // rll4.setOnDragListener(new MyDragListener(getActivity(), arrList,
            // 1));
            // rll5.setOnLongClickListener(new mylongclick2());
            // rll5.setOnDragListener(new MyDragListener(getActivity(), arrList,
            // 1));
            // rll6.setOnLongClickListener(new mylongclick2());
            // rll6.setOnDragListener(new MyDragListener(getActivity(), arrList,
            // 1));
            // rll7.setOnLongClickListener(new mylongclick2());
            // rll7.setOnDragListener(new MyDragListener(getActivity(), arrList,
            // 1));
            // rll8.setOnLongClickListener(new mylongclick2());
            // rll8.setOnDragListener(new MyDragListener(getActivity(), arrList,
            // 1));

            View v8 = inflater.inflate(R.layout.gb_bussiness, null);

            RelativeLayout layout = (RelativeLayout) v8.findViewById(R.id.rel);
            Graphs graphs = new Graphs(getActivity());
            mChart = graphs.StackedBarChart();
            for (DataSet<?> set : mChart.getData().getDataSets())
                set.setDrawValues(!set.isDrawValuesEnabled());

            mChart.invalidate();

            layout.addView(mChart, new LayoutParams(300,
                    RelativeLayout.LayoutParams.MATCH_PARENT));

            RelativeLayout layout23 = (RelativeLayout) v8
                    .findViewById(R.id.rel2);

            graphs = new Graphs(getActivity());
            PieChart PChart = graphs.piechartPre(1);

            for (DataSet<?> set : PChart.getData().getDataSets())
                set.setDrawValues(!set.isDrawValuesEnabled());

            PChart.invalidate();

            layout23.addView(PChart, new LayoutParams(300,
                    RelativeLayout.LayoutParams.MATCH_PARENT));

            RelativeLayout layout21 = (RelativeLayout) v8
                    .findViewById(R.id.rel5);
            PieChart PChart1 = graphs.piechartPre(3);

            for (DataSet<?> set : PChart1.getData().getDataSets())
                set.setDrawValues(!set.isDrawValuesEnabled());

            PChart1.invalidate();
            layout21.addView(PChart1, new LayoutParams(300,
                    RelativeLayout.LayoutParams.MATCH_PARENT));

            RelativeLayout layout22 = (RelativeLayout) v8
                    .findViewById(R.id.rel4);

            PieChart PChart4 = graphs.piechartPre(4);

            for (DataSet<?> set : PChart4.getData().getDataSets())
                set.setDrawValues(!set.isDrawValuesEnabled());

            PChart4.invalidate();

            layout22.addView(PChart4, new LayoutParams(300,
                    RelativeLayout.LayoutParams.MATCH_PARENT));

            RelativeLayout layout25 = (RelativeLayout) v8
                    .findViewById(R.id.rel6);
            graphs = new Graphs(getActivity());

            PieChart PChart2 = graphs.piechartPre(2);

            for (DataSet<?> set : PChart2.getData().getDataSets())
                set.setDrawValues(!set.isDrawValuesEnabled());

            PChart2.invalidate();

            layout25.addView(PChart2, new LayoutParams(300,
                    RelativeLayout.LayoutParams.MATCH_PARENT));

            RelativeLayout layout26 = (RelativeLayout) v8
                    .findViewById(R.id.rel3);
            layout26.addView(graphs.lineChart(ast2, 19, 100, 50),
                    new LayoutParams(260, 200));

            LinearLayout linear = new LinearLayout(getActivity());
            linear.setOrientation(LinearLayout.VERTICAL);
            v1.setPadding(5, 10, 5, 40);
            v2.setPadding(5, 10, 5, 40);
            v3.setPadding(5, 10, 5, 40);
            v4.setPadding(5, 10, 5, 40);
            v5.setPadding(5, 10, 5, 40);
            v6.setPadding(5, 10, 5, 40);
            v7.setPadding(5, 10, 5, 40);
            v8.setPadding(5, 10, 5, 40);

            linear.addView(v1);
            linear.addView(v2);
            linear.addView(v3);
            linear.addView(v4);
            linear.addView(v5);
            linear.addView(v6);
            linear.addView(v7);
            linear.addView(v8);

            return linear;
        } else if (index.equals("2")) {
            View v1 = getMyViewForReporting();
            RelativeLayout relativefirst;
            View v2 = inflater.inflate(R.layout.sampling, container, false);
            View view = v2.findViewById(R.id.keyboard);
            findViews(view);
            relativefirst = (RelativeLayout) v2
                    .findViewById(R.id.relativefirst);
            for (int i = 0; i < relativefirst.getChildCount(); i++) {
                if (i == 1 || i == 2 || i == 4) {
                    relativefirst.getChildAt(i).setTag("1");
                } else if (i == 3 || i == 5) {
                    relativefirst.getChildAt(i).setTag("2");
                } else {
                    relativefirst.getChildAt(i).setTag("3");
                }
                if (i != 0 || i != 6)
                    relativefirst.getChildAt(i).setOnClickListener(listener);
            }
            linearone = (LinearLayout) v2.findViewById(R.id.linearone);
            linearthree = (LinearLayout) v2.findViewById(R.id.linearthree);
            gesture = (ImageView) v2.findViewById(R.id.gestures);
            table1 = (TableRow) v2.findViewById(R.id.table1);
            table2 = (TableRow) v2.findViewById(R.id.table2);
            table1.setVisibility(View.INVISIBLE);
            table2.setVisibility(View.INVISIBLE);
            addDataToSampling(0, "Mezzo Drop");
            addDataToSampling(0, "C-FIX");
            addDataToSampling(1, "Pen");
            addDataToSampling(1, "RX Pad");

            ImageView done = (ImageView) v2.findViewById(R.id.save);

            byte[] data = Base64.decode(imageData, 0);
            Bitmap bpp = BitmapFactory.decodeByteArray(data, 0, data.length);
            gesture.setImageBitmap(bpp);

            View v3 = inflater.inflate(R.layout.feeback, container, false);
            overallheader = (TextView) v3.findViewById(R.id.overallheader);
            happy = (TextView) v3.findViewById(R.id.happy);

            happy.setTypeface(font);
            happy.setOnClickListener(feedListener);

            avg = (TextView) v3.findViewById(R.id.avg);
            avg.setTypeface(font);
            avg.setOnClickListener(feedListener);

            sad = (TextView) v3.findViewById(R.id.sad);
            sad.setTypeface(font);
            sad.setOnClickListener(feedListener);

            add = (TextView) v3.findViewById(R.id.sad);
            add.setTypeface(font);
            add.setOnClickListener(feedListener);

            pencil = (TextView) v3.findViewById(R.id.pencil);
            pencil.setTypeface(font);
            pencil.setOnClickListener(feedListener);

            Button add = (Button) v3.findViewById(R.id.add);
            Button more = (Button) v3.findViewById(R.id.more);

            // txt = (TextView) v.findViewById(R.id.Brandwise2);
            txt1 = (TextView) v3.findViewById(R.id.text1);
            txt2 = (TextView) v3.findViewById(R.id.text2);
            txt3 = (TextView) v3.findViewById(R.id.text3);
            txt4 = (TextView) v3.findViewById(R.id.text4);
            btadd2 = (Button) v3.findViewById(R.id.add2);
            ly2 = (LinearLayout) v3.findViewById(R.id.brndAdd2);
            ly3 = (LinearLayout) v3.findViewById(R.id.mainlayout2);

            more.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub

                    dialog_box = new Dialog(getActivity());
                    dialog_box.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog_box.setContentView(R.layout.list_layout);
                    mainlayoutdialog = (LinearLayout) dialog_box
                            .findViewById(R.id.mainlayoutdialog);
                    addBrandDialog(4);
                    Window window = dialog_box.getWindow();
                    window.setBackgroundDrawable(new ColorDrawable(
                            Color.TRANSPARENT));
                    Display display = ((WindowManager) getActivity()
                            .getSystemService(getActivity().WINDOW_SERVICE))
                            .getDefaultDisplay();
                    int width = display.getWidth();
                    int height = display.getHeight();
                    dialog_box.getWindow().setLayout(width, 550);
                    dialog_box.getWindow().clearFlags(
                            WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                    dialog_box.show();
                    Button addparadialog = (Button) dialog_box
                            .findViewById(R.id.addparadialog);
                    addparadialog.setOnClickListener(new OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            // TODO Auto-generated method stub
                            addBrandDialog(1);
                        }
                    });
                    ImageView close = (ImageView) dialog_box
                            .findViewById(R.id.cross);
                    close.setOnClickListener(new OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            // TODO Auto-generated method stub
                            dialog_box.dismiss();
                        }
                    });

                }
            });
            mainlayout = (LinearLayout) v3.findViewById(R.id.mainlayout);

            add.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    addbrands(1);
                }
            });
            btadd2.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (countMeL == 0) {
                        addbrandsV(4, 1);
                    }

                    LinearLayout ch5 = (LinearLayout) ly3.getChildAt(5);
                    LinearLayout ch6 = (LinearLayout) ly3.getChildAt(6);
                    LinearLayout ch7 = (LinearLayout) ly3.getChildAt(7);

                    LinearLayout ch8 = (LinearLayout) ly3.getChildAt(8);

                    LinearLayout chh5 = (LinearLayout) ch5.getChildAt(1);
                    LinearLayout chh6 = (LinearLayout) ch6.getChildAt(1);
                    LinearLayout chh7 = (LinearLayout) ch7.getChildAt(1);
                    LinearLayout chh8 = (LinearLayout) ch8.getChildAt(1);
                    TextView chh51 = (TextView) ch5.getChildAt(0);
                    TextView chh61 = (TextView) ch6.getChildAt(0);
                    TextView chh71 = (TextView) ch7.getChildAt(0);
                    TextView chh81 = (TextView) ch8.getChildAt(0);

                    txt1.setVisibility(View.VISIBLE);

                    switch (countMeL) {
                        case 0:

                            chh5.getChildAt(0).setVisibility(View.VISIBLE);
                            chh6.getChildAt(0).setVisibility(View.INVISIBLE);
                            chh7.getChildAt(0).setVisibility(View.INVISIBLE);
                            chh8.getChildAt(0).setVisibility(View.INVISIBLE);
                            chh61.setVisibility(View.INVISIBLE);
                            chh71.setVisibility(View.INVISIBLE);
                            chh81.setVisibility(View.INVISIBLE);
                            if (txt2.getVisibility() == View.VISIBLE) {
                                chh5.getChildAt(1).setVisibility(View.VISIBLE);
                            } else if (txt3.getVisibility() == View.VISIBLE) {
                                chh5.getChildAt(2).setVisibility(View.VISIBLE);
                            } else if (txt4.getVisibility() == View.VISIBLE) {
                                chh5.getChildAt(3).setVisibility(View.VISIBLE);
                            }

                            countMeL++;
                            break;

                        case 1:
                            chh61.setVisibility(View.VISIBLE);
                            chh6.getChildAt(0).setVisibility(View.VISIBLE);
                            chh7.getChildAt(0).setVisibility(View.INVISIBLE);
                            chh8.getChildAt(0).setVisibility(View.INVISIBLE);
                            if (txt2.getVisibility() == View.VISIBLE) {
                                chh5.getChildAt(1).setVisibility(View.VISIBLE);
                                chh6.getChildAt(1).setVisibility(View.VISIBLE);
                            }
                            if (txt3.getVisibility() == View.VISIBLE) {
                                chh5.getChildAt(2).setVisibility(View.VISIBLE);
                                chh6.getChildAt(2).setVisibility(View.VISIBLE);
                            }
                            if (txt4.getVisibility() == View.VISIBLE) {
                                chh5.getChildAt(3).setVisibility(View.VISIBLE);
                                chh6.getChildAt(3).setVisibility(View.VISIBLE);
                            }

                            countMeL++;
                            break;
                        case 2:
                            chh71.setVisibility(View.VISIBLE);
                            chh7.getChildAt(0).setVisibility(View.VISIBLE);

                            chh8.getChildAt(0).setVisibility(View.INVISIBLE);
                            if (txt2.getVisibility() == View.VISIBLE) {
                                chh5.getChildAt(1).setVisibility(View.VISIBLE);
                                chh6.getChildAt(1).setVisibility(View.VISIBLE);
                                chh7.getChildAt(1).setVisibility(View.VISIBLE);
                            }
                            if (txt3.getVisibility() == View.VISIBLE) {
                                chh5.getChildAt(2).setVisibility(View.VISIBLE);
                                chh6.getChildAt(2).setVisibility(View.VISIBLE);
                                chh7.getChildAt(2).setVisibility(View.VISIBLE);
                            }
                            if (txt4.getVisibility() == View.VISIBLE) {
                                chh5.getChildAt(3).setVisibility(View.VISIBLE);
                                chh6.getChildAt(3).setVisibility(View.VISIBLE);
                                chh7.getChildAt(3).setVisibility(View.VISIBLE);
                            }

                            countMeL++;
                            break;
                        case 3:
                            chh81.setVisibility(View.VISIBLE);
                            chh8.getChildAt(0).setVisibility(View.VISIBLE);
                            if (txt2.getVisibility() == View.VISIBLE) {
                                chh5.getChildAt(1).setVisibility(View.VISIBLE);
                                chh6.getChildAt(1).setVisibility(View.VISIBLE);
                                chh7.getChildAt(1).setVisibility(View.VISIBLE);
                                chh8.getChildAt(1).setVisibility(View.VISIBLE);
                            }
                            if (txt3.getVisibility() == View.VISIBLE) {
                                chh5.getChildAt(2).setVisibility(View.VISIBLE);
                                chh6.getChildAt(2).setVisibility(View.VISIBLE);
                                chh7.getChildAt(2).setVisibility(View.VISIBLE);
                                chh8.getChildAt(2).setVisibility(View.VISIBLE);
                            }
                            if (txt4.getVisibility() == View.VISIBLE) {
                                chh5.getChildAt(3).setVisibility(View.VISIBLE);
                                chh6.getChildAt(3).setVisibility(View.VISIBLE);
                                chh7.getChildAt(3).setVisibility(View.VISIBLE);
                                chh8.getChildAt(3).setVisibility(View.VISIBLE);
                            }
                            countMeL++;
                            break;

                    }
                }
            });
            addbrands(4);
            addbrandsV(4, 1);

            View v4 = actionPointView(getActivity(), "0");

            View v5 = inflater.inflate(R.layout.end_layout, null);
            TextView prev = (TextView) v5.findViewById(R.id.prev);
            TextView next = (TextView) v5.findViewById(R.id.next);
            prev.setTypeface(font);
            next.setTypeface(font);
            TextView done1 = (TextView) v5.findViewById(R.id.done);
            done1.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    dialog_box = new Dialog(getActivity());
                    dialog_box.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog_box.setContentView(R.layout.secondwala);
                    TextView close = (TextView) dialog_box
                            .findViewById(R.id.close);
                    close.setTypeface(font);
                    close.setOnClickListener(new OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            dialog_box.dismiss();
                        }
                    });
                    Window window = dialog_box.getWindow();
                    window.setBackgroundDrawable(new ColorDrawable(
                            Color.TRANSPARENT));
                    dialog_box.getWindow().setLayout(400, 300);
                    dialog_box.show();
                    TextView yes = (TextView) dialog_box.findViewById(R.id.yes);
                    yes.setOnClickListener(new OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            // TODO Auto-generated method stub
                            Intent intent = new Intent(getActivity(),
                                    Reporting.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                        }
                    });
                    TextView cancel = (TextView) dialog_box
                            .findViewById(R.id.cancel);
                    cancel.setOnClickListener(new OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            // TODO Auto-generated method stub
                            dialog_box.dismiss();
                        }
                    });

                }
            });
            TextView sne = (TextView) v5.findViewById(R.id.sne);
            sne.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), Reporting.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
            });

            LinearLayout linear = new LinearLayout(getActivity());
            linear.setOrientation(LinearLayout.VERTICAL);
            v1.setPadding(5, 10, 5, 40);
            v2.setPadding(5, 10, 5, 40);
            v3.setPadding(5, 10, 5, 40);
            v4.setPadding(5, 10, 5, 40);
            v5.setPadding(5, 10, 5, 10);
            linear.addView(v1);
            linear.addView(v2);
            linear.addView(v3);
            linear.addView(v4);
            linear.addView(v5);

            return linear;
        } else if (index.equals("3")) {

            View v1 = getMyViewForReporting();
            RelativeLayout relativefirst;
            View v2 = inflater.inflate(R.layout.sampling, container, false);
            View view = v2.findViewById(R.id.keyboard);
            findViews(view);
            relativefirst = (RelativeLayout) v2
                    .findViewById(R.id.relativefirst);
            for (int i = 0; i < relativefirst.getChildCount(); i++) {
                if (i == 1 || i == 2 || i == 4) {
                    relativefirst.getChildAt(i).setTag("1");
                } else if (i == 3 || i == 5) {
                    relativefirst.getChildAt(i).setTag("2");
                } else {
                    relativefirst.getChildAt(i).setTag("3");
                }
                if (i != 0 || i != 6)
                    relativefirst.getChildAt(i).setOnClickListener(listener);
            }
            linearone = (LinearLayout) v2.findViewById(R.id.linearone);
            linearthree = (LinearLayout) v2.findViewById(R.id.linearthree);
            gesture = (ImageView) v2.findViewById(R.id.gestures);
            table1 = (TableRow) v2.findViewById(R.id.table1);
            table2 = (TableRow) v2.findViewById(R.id.table2);
            table1.setVisibility(View.INVISIBLE);
            table2.setVisibility(View.INVISIBLE);
            addDataToSampling(0, "Mezzo Drop");
            addDataToSampling(0, "C-FIX");
            addDataToSampling(1, "Pen");
            addDataToSampling(1, "RX Pad");

            ImageView done = (ImageView) v2.findViewById(R.id.save);

            byte[] data = Base64.decode(imageData, 0);
            Bitmap bpp = BitmapFactory.decodeByteArray(data, 0, data.length);
            gesture.setImageBitmap(bpp);

            View v3 = inflater.inflate(R.layout.feeback, container, false);
            overallheader = (TextView) v3.findViewById(R.id.overallheader);
            happy = (TextView) v3.findViewById(R.id.happy);

            happy.setTypeface(font);
            happy.setOnClickListener(feedListener);

            avg = (TextView) v3.findViewById(R.id.avg);
            avg.setTypeface(font);
            avg.setOnClickListener(feedListener);

            sad = (TextView) v3.findViewById(R.id.sad);
            sad.setTypeface(font);
            sad.setOnClickListener(feedListener);

            add = (TextView) v3.findViewById(R.id.sad);
            add.setTypeface(font);
            add.setOnClickListener(feedListener);

            pencil = (TextView) v3.findViewById(R.id.pencil);
            pencil.setTypeface(font);
            pencil.setOnClickListener(feedListener);

            Button add = (Button) v3.findViewById(R.id.add);
            Button more = (Button) v3.findViewById(R.id.more);

            // txt = (TextView) v.findViewById(R.id.Brandwise2);
            txt1 = (TextView) v3.findViewById(R.id.text1);
            txt2 = (TextView) v3.findViewById(R.id.text2);
            txt3 = (TextView) v3.findViewById(R.id.text3);
            txt4 = (TextView) v3.findViewById(R.id.text4);
            btadd2 = (Button) v3.findViewById(R.id.add2);
            ly2 = (LinearLayout) v3.findViewById(R.id.brndAdd2);
            ly3 = (LinearLayout) v3.findViewById(R.id.mainlayout2);

            more.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub

                    dialog_box = new Dialog(getActivity());
                    dialog_box.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog_box.setContentView(R.layout.list_layout);
                    mainlayoutdialog = (LinearLayout) dialog_box
                            .findViewById(R.id.mainlayoutdialog);
                    addBrandDialog(4);
                    Window window = dialog_box.getWindow();
                    window.setBackgroundDrawable(new ColorDrawable(
                            Color.TRANSPARENT));
                    Display display = ((WindowManager) getActivity()
                            .getSystemService(getActivity().WINDOW_SERVICE))
                            .getDefaultDisplay();
                    int width = display.getWidth();
                    int height = display.getHeight();
                    dialog_box.getWindow().setLayout(width, 550);
                    dialog_box.getWindow().clearFlags(
                            WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                    dialog_box.show();
                    Button addparadialog = (Button) dialog_box
                            .findViewById(R.id.addparadialog);
                    addparadialog.setOnClickListener(new OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            // TODO Auto-generated method stub
                            addBrandDialog(1);
                        }
                    });
                    ImageView close = (ImageView) dialog_box
                            .findViewById(R.id.cross);
                    close.setOnClickListener(new OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            // TODO Auto-generated method stub
                            dialog_box.dismiss();
                        }
                    });

                }
            });
            mainlayout = (LinearLayout) v3.findViewById(R.id.mainlayout);

            add.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    addbrands(1);
                }
            });
            btadd2.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (countMeL == 0) {
                        addbrandsV(4, 1);
                    }

                    LinearLayout ch5 = (LinearLayout) ly3.getChildAt(5);
                    LinearLayout ch6 = (LinearLayout) ly3.getChildAt(6);
                    LinearLayout ch7 = (LinearLayout) ly3.getChildAt(7);

                    LinearLayout ch8 = (LinearLayout) ly3.getChildAt(8);

                    LinearLayout chh5 = (LinearLayout) ch5.getChildAt(1);
                    LinearLayout chh6 = (LinearLayout) ch6.getChildAt(1);
                    LinearLayout chh7 = (LinearLayout) ch7.getChildAt(1);
                    LinearLayout chh8 = (LinearLayout) ch8.getChildAt(1);
                    TextView chh51 = (TextView) ch5.getChildAt(0);
                    TextView chh61 = (TextView) ch6.getChildAt(0);
                    TextView chh71 = (TextView) ch7.getChildAt(0);
                    TextView chh81 = (TextView) ch8.getChildAt(0);

                    txt1.setVisibility(View.VISIBLE);

                    switch (countMeL) {
                        case 0:

                            chh5.getChildAt(0).setVisibility(View.VISIBLE);
                            chh6.getChildAt(0).setVisibility(View.INVISIBLE);
                            chh7.getChildAt(0).setVisibility(View.INVISIBLE);
                            chh8.getChildAt(0).setVisibility(View.INVISIBLE);
                            chh61.setVisibility(View.INVISIBLE);
                            chh71.setVisibility(View.INVISIBLE);
                            chh81.setVisibility(View.INVISIBLE);
                            if (txt2.getVisibility() == View.VISIBLE) {
                                chh5.getChildAt(1).setVisibility(View.VISIBLE);
                            } else if (txt3.getVisibility() == View.VISIBLE) {
                                chh5.getChildAt(2).setVisibility(View.VISIBLE);
                            } else if (txt4.getVisibility() == View.VISIBLE) {
                                chh5.getChildAt(3).setVisibility(View.VISIBLE);
                            }

                            countMeL++;
                            break;

                        case 1:
                            chh61.setVisibility(View.VISIBLE);
                            chh6.getChildAt(0).setVisibility(View.VISIBLE);
                            chh7.getChildAt(0).setVisibility(View.INVISIBLE);
                            chh8.getChildAt(0).setVisibility(View.INVISIBLE);
                            if (txt2.getVisibility() == View.VISIBLE) {
                                chh5.getChildAt(1).setVisibility(View.VISIBLE);
                                chh6.getChildAt(1).setVisibility(View.VISIBLE);
                            }
                            if (txt3.getVisibility() == View.VISIBLE) {
                                chh5.getChildAt(2).setVisibility(View.VISIBLE);
                                chh6.getChildAt(2).setVisibility(View.VISIBLE);
                            }
                            if (txt4.getVisibility() == View.VISIBLE) {
                                chh5.getChildAt(3).setVisibility(View.VISIBLE);
                                chh6.getChildAt(3).setVisibility(View.VISIBLE);
                            }

                            countMeL++;
                            break;
                        case 2:
                            chh71.setVisibility(View.VISIBLE);
                            chh7.getChildAt(0).setVisibility(View.VISIBLE);

                            chh8.getChildAt(0).setVisibility(View.INVISIBLE);
                            if (txt2.getVisibility() == View.VISIBLE) {
                                chh5.getChildAt(1).setVisibility(View.VISIBLE);
                                chh6.getChildAt(1).setVisibility(View.VISIBLE);
                                chh7.getChildAt(1).setVisibility(View.VISIBLE);
                            }
                            if (txt3.getVisibility() == View.VISIBLE) {
                                chh5.getChildAt(2).setVisibility(View.VISIBLE);
                                chh6.getChildAt(2).setVisibility(View.VISIBLE);
                                chh7.getChildAt(2).setVisibility(View.VISIBLE);
                            }
                            if (txt4.getVisibility() == View.VISIBLE) {
                                chh5.getChildAt(3).setVisibility(View.VISIBLE);
                                chh6.getChildAt(3).setVisibility(View.VISIBLE);
                                chh7.getChildAt(3).setVisibility(View.VISIBLE);
                            }

                            countMeL++;
                            break;
                        case 3:
                            chh81.setVisibility(View.VISIBLE);
                            chh8.getChildAt(0).setVisibility(View.VISIBLE);
                            if (txt2.getVisibility() == View.VISIBLE) {
                                chh5.getChildAt(1).setVisibility(View.VISIBLE);
                                chh6.getChildAt(1).setVisibility(View.VISIBLE);
                                chh7.getChildAt(1).setVisibility(View.VISIBLE);
                                chh8.getChildAt(1).setVisibility(View.VISIBLE);
                            }
                            if (txt3.getVisibility() == View.VISIBLE) {
                                chh5.getChildAt(2).setVisibility(View.VISIBLE);
                                chh6.getChildAt(2).setVisibility(View.VISIBLE);
                                chh7.getChildAt(2).setVisibility(View.VISIBLE);
                                chh8.getChildAt(2).setVisibility(View.VISIBLE);
                            }
                            if (txt4.getVisibility() == View.VISIBLE) {
                                chh5.getChildAt(3).setVisibility(View.VISIBLE);
                                chh6.getChildAt(3).setVisibility(View.VISIBLE);
                                chh7.getChildAt(3).setVisibility(View.VISIBLE);
                                chh8.getChildAt(3).setVisibility(View.VISIBLE);
                            }
                            countMeL++;
                            break;

                    }
                }
            });
            addbrands(4);
            addbrandsV(4, 1);

            View v4 = actionPointView(getActivity(), "0");

            View v5 = inflater.inflate(R.layout.end_layout, null);
            TextView prev = (TextView) v5.findViewById(R.id.prev);
            TextView next = (TextView) v5.findViewById(R.id.next);
            prev.setTypeface(font);
            next.setTypeface(font);
            TextView done1 = (TextView) v5.findViewById(R.id.done);
            done1.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    dialog_box = new Dialog(getActivity());
                    dialog_box.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog_box.setContentView(R.layout.secondwala);
                    TextView close = (TextView) dialog_box
                            .findViewById(R.id.close);
                    close.setTypeface(font);
                    close.setOnClickListener(new OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            dialog_box.dismiss();
                        }
                    });
                    Window window = dialog_box.getWindow();
                    window.setBackgroundDrawable(new ColorDrawable(
                            Color.TRANSPARENT));
                    dialog_box.getWindow().setLayout(400, 300);
                    dialog_box.show();
                    TextView yes = (TextView) dialog_box.findViewById(R.id.yes);
                    yes.setOnClickListener(new OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            // TODO Auto-generated method stub
                            Intent intent = new Intent(getActivity(),
                                    Reporting.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                        }
                    });
                    TextView cancel = (TextView) dialog_box
                            .findViewById(R.id.cancel);
                    cancel.setOnClickListener(new OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            // TODO Auto-generated method stub
                            dialog_box.dismiss();
                        }
                    });

                }
            });
            TextView sne = (TextView) v5.findViewById(R.id.sne);
            sne.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), Reporting.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
            });

            LinearLayout linear = new LinearLayout(getActivity());
            linear.setOrientation(LinearLayout.VERTICAL);
            v1.setPadding(5, 10, 5, 40);
            v2.setPadding(5, 10, 5, 40);
            v3.setPadding(5, 10, 5, 40);
            v4.setPadding(5, 10, 5, 40);
            v5.setPadding(5, 10, 5, 10);
            linear.addView(v1);
            linear.addView(v2);
            linear.addView(v3);
            linear.addView(v4);
            linear.addView(v5);

            return linear;

        } else if (index.equals("4")) {

            View v1 = inflater.inflate(R.layout.info, container, false);
            TextView edit = (TextView) v1.findViewById(R.id.edit);
            edit.setTypeface(font);
            TextView edit2 = (TextView) v1.findViewById(R.id.edit2);
            edit2.setTypeface(font);
            photos = (GridView) v1.findViewById(R.id.photos);

            arrList = new ArrayList<>();
            int[] images = {R.drawable.exb1, R.drawable.exb2, R.drawable.exb3,
                    R.drawable.exb4, R.drawable.exb5, R.drawable.exb1};

            for (int i = 0; i < images.length; i++) {
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                        LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
                params.leftMargin = 140;
                params.topMargin = 70;

                RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(
                        LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

                RelativeLayout rl = new RelativeLayout(getActivity());
                ImageView img1 = new ImageView(getActivity());
                img1.setImageResource(images[i]);
                img1.setLayoutParams(params2);
                ImageView img2 = new ImageView(getActivity());
                img2.setLayoutParams(params);
                img2.setImageResource(R.drawable.delete_icon);
                rl.addView(img1);
                rl.addView(img2);
                arrList.add(rl);
            }

            photos.setAdapter(new PhotosAdapter(getActivity(), arrList));
            TextView add = (TextView) v1.findViewById(R.id.add);
            add.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent takePictureIntent = new Intent(
                            MediaStore.ACTION_IMAGE_CAPTURE);
                    if (takePictureIntent.resolveActivity(getActivity()
                            .getPackageManager()) != null)
                        startActivityForResult(takePictureIntent, 9322);

                    // RelativeLayout.LayoutParams gridParam = new
                    // RelativeLayout.LayoutParams(
                    // RelativeLayout.LayoutParams.WRAP_CONTENT,
                    // RelativeLayout.LayoutParams.WRAP_CONTENT);
                    //
                    // gridParam.addRule(RelativeLayout.BELOW, R.id.txt11);
                    // gridParam.topMargin = 10;
                    //
                    // photos.setLayoutParams(gridParam);
                    // photos.setGravity(Gravity.LEFT);
                    // photos.setHorizontalSpacing(2);
                    // photos.setVerticalSpacing(2);
                    // photos.setNumColumns(3);
                    // RelativeLayout.LayoutParams params = new
                    // RelativeLayout.LayoutParams(
                    // LayoutParams.WRAP_CONTENT,
                    // LayoutParams.WRAP_CONTENT);
                    // params.leftMargin = 140;
                    // params.topMargin = 70;
                    //
                    // RelativeLayout.LayoutParams params2 = new
                    // RelativeLayout.LayoutParams(
                    // LayoutParams.MATCH_PARENT,
                    // LayoutParams.WRAP_CONTENT);
                    //
                    // RelativeLayout rl = new RelativeLayout(getActivity());
                    // ImageView img1 = new ImageView(getActivity());
                    // img1.setImageResource(R.drawable.exb2);
                    // img1.setLayoutParams(params2);
                    // ImageView img2 = new ImageView(getActivity());
                    // img2.setLayoutParams(params);
                    // img2.setImageResource(R.drawable.delete_icon);
                    // rl.addView(img1);
                    // rl.addView(img2);
                    // arrList.add(rl);
                    // PhotosAdapter adapter = new PhotosAdapter(getActivity(),
                    // arrList);
                    // photos.setAdapter(adapter);
                    // adapter.notifyDataSetChanged();

                }
            });
            View v2 = inflater.inflate(R.layout.business_events, container,
                    false);
            TextView edit3 = (TextView) v2.findViewById(R.id.edit3);
            edit3.setTypeface(font);
            TextView edit4 = (TextView) v2.findViewById(R.id.edit4);
            edit4.setTypeface(font);

            View v3 = inflater.inflate(R.layout.eventbar, container, false);
            dealList = new ArrayList<Integer>();
            View viewinclude = v3.findViewById(R.id.viewlist);
            ListView booksLV = (ListView) viewinclude
                    .findViewById(R.id.booksLV);
            TextView selectedIndex = (TextView) viewinclude
                    .findViewById(R.id.selectedIndex);
            LinearLayout sideIndex = (LinearLayout) viewinclude
                    .findViewById(R.id.sideIndex);

            Vector<Book> userVector = UserService.getUserList(getActivity());
            Vector<Book> subsidiesList = getIndexedBooks(userVector);
            int totalListSize = subsidiesList.size();

            UserListAdapter userListAdapter = new UserListAdapter(
                    getActivity(), subsidiesList, getActivity());
            booksLV.setAdapter(userListAdapter);
            CustomListIndexE er = new CustomListIndexE();
            er.sideIndexHeight = sideIndex.getHeight();
            er.userVector = userVector;
            er.conte = getActivity();
            er.dealList = dealList;
            er.totalListSize = totalListSize;

            er.getDisplayListOnChange(sideIndex, booksLV, selectedIndex);

            View v4 = inflater.inflate(R.layout.expenditure, container, false);
            TextView red1 = (TextView) v4.findViewById(R.id.txtgreen);
            red1.setTypeface(font);
            TextView red2 = (TextView) v4.findViewById(R.id.txtred);
            red2.setTypeface(font);
            TextView green = (TextView) v4.findViewById(R.id.txtred1);
            green.setTypeface(font);
            TextView edit11 = (TextView) v4.findViewById(R.id.edit3);
            edit11.setTypeface(font);
            TextView edit21 = (TextView) v4.findViewById(R.id.edit4);
            edit21.setTypeface(font);

            View v5 = inflater.inflate(R.layout.action, container, false);
            TextView ic1 = (TextView) v5.findViewById(R.id.ic1);
            ic1.setTypeface(font);
            TextView ic2 = (TextView) v5.findViewById(R.id.ic2);
            ic2.setTypeface(font);
            TextView ic3 = (TextView) v5.findViewById(R.id.ic3);
            ic3.setTypeface(font);
            TextView ic4 = (TextView) v5.findViewById(R.id.ic4);
            ic4.setTypeface(font);
            TextView ic5 = (TextView) v5.findViewById(R.id.ic5);
            ic5.setTypeface(font);
            TextView ic6 = (TextView) v5.findViewById(R.id.ic6);
            ic6.setTypeface(font);

            TextView approval = (TextView) v5.findViewById(R.id.approval);
            TextView execute = (TextView) v5.findViewById(R.id.execute);

            approval.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog_box = new Dialog(getActivity());
                    dialog_box.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog_box.setContentView(R.layout.approval);
                    TextView close = (TextView) dialog_box
                            .findViewById(R.id.close);
                    close.setTypeface(font);
                    close.setOnClickListener(new OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            dialog_box.dismiss();
                        }
                    });
                    Window window = dialog_box.getWindow();
                    window.setBackgroundDrawable(new ColorDrawable(
                            Color.TRANSPARENT));
                    dialog_box.getWindow().setLayout(400, 300);
                    dialog_box.show();
                    TextView yes = (TextView) dialog_box.findViewById(R.id.yes);
                    yes.setOnClickListener(new OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            // TODO Auto-generated method stub
                            Intent intent = new Intent(getActivity(),
                                    Events.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                        }
                    });
                    TextView cancel = (TextView) dialog_box
                            .findViewById(R.id.cancel);
                    cancel.setOnClickListener(new OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            // TODO Auto-generated method stub
                            dialog_box.dismiss();
                        }
                    });

                }
            });
            execute.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog_box = new Dialog(getActivity());
                    dialog_box.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog_box.setContentView(R.layout.execute);
                    TextView close = (TextView) dialog_box
                            .findViewById(R.id.close);
                    close.setTypeface(font);
                    close.setOnClickListener(new OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            dialog_box.dismiss();
                        }
                    });
                    Window window = dialog_box.getWindow();
                    window.setBackgroundDrawable(new ColorDrawable(
                            Color.TRANSPARENT));
                    dialog_box.getWindow().setLayout(400, 300);
                    dialog_box.show();
                    TextView yes = (TextView) dialog_box.findViewById(R.id.yes);
                    yes.setOnClickListener(new OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            // TODO Auto-generated method stub
                            Intent intent = new Intent(getActivity(),
                                    Events.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                        }
                    });
                    TextView cancel = (TextView) dialog_box
                            .findViewById(R.id.cancel);
                    cancel.setOnClickListener(new OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            // TODO Auto-generated method stub
                            dialog_box.dismiss();
                        }
                    });

                }
            });

            LinearLayout linear = new LinearLayout(getActivity());
            linear.setOrientation(LinearLayout.VERTICAL);
            v1.setPadding(5, 0, 5, 40);
            v2.setPadding(5, 10, 5, 40);
            v3.setPadding(5, 10, 5, 40);
            v4.setPadding(5, 10, 5, 40);
            v5.setPadding(5, 10, 5, 10);
            linear.addView(v1);
            linear.addView(v2);
            linear.addView(v3);
            linear.addView(v4);
            linear.addView(v5);

            return linear;
        }

        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 9322 && resultCode == Activity.RESULT_OK) {
            Bundle extras = data.getExtras();
            // get the cropped bitmap
            Bitmap thePic = extras.getParcelable("data");
            thePic = Bitmap.createScaledBitmap(thePic, 180, 113, true);

            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                    LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            params.leftMargin = 140;
            params.topMargin = 70;

            RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(
                    LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

            RelativeLayout rl = new RelativeLayout(getActivity());
            ImageView img1 = new ImageView(getActivity());
            img1.setImageBitmap(thePic);
            img1.setLayoutParams(params2);
            ImageView img2 = new ImageView(getActivity());
            img2.setLayoutParams(params);
            img2.setImageResource(R.drawable.delete_icon);
            rl.addView(img1);
            rl.addView(img2);
            arrList.add(rl);
            PhotosAdapter adapter = new PhotosAdapter(getActivity(), arrList);
            photos.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
    }

    void addbrands(int len) {
        for (int i = 0; i < len; i++) {
            LayoutInflater mInflater = (LayoutInflater) getActivity()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            LinearLayout view = (LinearLayout) mInflater.inflate(
                    R.layout.ratingbar, null);
            TextView parameter = (TextView) view.findViewById(R.id.parameter);
            parameter.setText(parameters[i]);
            mainlayout.addView(view);
        }
    }

    void addbrandsV(int len, int mode) {

        for (int i = 0; i < len; i++) {
            LayoutInflater mInflater = (LayoutInflater) getActivity()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            LinearLayout view = (LinearLayout) mInflater.inflate(
                    R.layout.ratingbar4, null);
            final RatingBar r1 = (RatingBar) view.findViewById(R.id.rb1);
            r1.setVisibility(View.VISIBLE);
            TextView parameter = (TextView) view.findViewById(R.id.parameter);
            parameter.setText(parameters[i]);
            ly3.addView(view);
        }

    }

    void addbrandsForHistory(int len, int mode) {

        for (int i = 0; i < len; i++) {

            LayoutInflater mInflater = (LayoutInflater) getActivity()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            LinearLayout view = (LinearLayout) mInflater.inflate(
                    R.layout.ratingbar2, null);
            TextView parameter = (TextView) view.findViewById(R.id.parameter);
            parameter.setText(parameters[i]);
            final RatingBar r1 = (RatingBar) view.findViewById(R.id.rb1);
            r1.setVisibility(View.VISIBLE);
            r1.setEnabled(false);

            final RatingBar r2 = (RatingBar) view.findViewById(R.id.rb2);
            r2.setVisibility(View.VISIBLE);
            r2.setEnabled(false);
            final RatingBar r3 = (RatingBar) view.findViewById(R.id.rb3);
            r3.setVisibility(View.VISIBLE);
            r3.setEnabled(false);
            if (i == 0) {
                r1.setRating(1);
                r2.setRating(1);
                r3.setRating(1);
            } else if (i == 1) {
                r1.setRating(2);
                r2.setRating(2);
                r3.setRating(2);
            } else if (i == 2) {
                r1.setRating(3);
                r2.setRating(3);
                r3.setRating(3);
            }
            ly3.addView(view);
        }

    }

    void addBrandDialog(int len) {
        for (int i = 0; i < len; i++) {
            LayoutInflater mInflater = (LayoutInflater) getActivity()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            LinearLayout view = (LinearLayout) mInflater.inflate(
                    R.layout.ratingbarfordialog, null);
            mainlayoutdialog.addView(view);
            TextView parameter = (TextView) view.findViewById(R.id.parameter);
            parameter.setText(parameters[i]);
        }
    }

    public GraphicalView getbarchard(int mode) {

        XYSeries incomeSeries = null;
        // Creating an XYSeries for Expense
        XYSeries expenseSeries = null;
        XYSeries videosSeries = null;
        XYSeries productinfoSeries = null;
        String[] mMonth = new String[]{"Feb", "Mar", "Apr"};

        int[] x = {0, 1, 2, 3};
        int[] income = {0, 710, 720, 750};
        int[] expense = {0, 510, 520, 550};
        int[] videos = {6, 8, 4};
        int[] productinfo = {6, 7, 2};
        int[] incomet = {0, 13, 9, 6, 2, 14, 8};

        if (mode == 1) {
            // Creating an XYSeries for Income
            incomeSeries = new XYSeries("News");
            // Creating an XYSeries for Expense
            expenseSeries = new XYSeries("Abstracts");
            videosSeries = new XYSeries("Videos");
            productinfoSeries = new XYSeries("Productinfo");
        } else if (mode == 2) {
            // Creating an XYSeries for Income
            incomeSeries = new XYSeries("Sample request");
            // Creating an XYSeries for Expense
            expenseSeries = new XYSeries("Objection");
            videosSeries = new XYSeries("Literature Request");
            productinfoSeries = new XYSeries("Medical Query");
        } else if (mode == 3) {

            incomeSeries = new XYSeries(" ");

            expenseSeries = new XYSeries(" ");
            //
        } else if (mode == 4) {

            incomeSeries = new XYSeries(" ");

            // expenseSeries = new XYSeries(" ");
            //
        }
        // Adding data to Income and Expense Series

        if (mode == 4) {
            for (int i = 0; i < incomet.length; i++) {

                incomeSeries.add(i, incomet[i]);

            }
        } else {
            for (int i = 0; i < x.length; i++) {

                incomeSeries.add(i, income[i]);
                if (mode != 4) {
                    expenseSeries.add(i, expense[i]);
                }

            }
        }

        // Creating a dataset to hold each series
        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
        // Adding Income Series to the dataset
        dataset.addSeries(incomeSeries);
        // Adding Expense Series to dataset

        if (mode != 4) {
            dataset.addSeries(expenseSeries);
        }
        // Creating XYSeriesRenderer to customize incomeSeries
        XYSeriesRenderer incomeRenderer = new XYSeriesRenderer();
        incomeRenderer.setColor(getResources().getColor(R.color.dpink));
        incomeRenderer.setFillPoints(true);
        incomeRenderer.setLineWidth(1);
        incomeRenderer.setDisplayChartValues(true);
        incomeRenderer.setShowLegendItem(false);

        // Creating XYSeriesRenderer to customize expenseSeries
        XYSeriesRenderer expenseRenderer = new XYSeriesRenderer();
        expenseRenderer.setColor(getResources().getColor(R.color.dblue));
        expenseRenderer.setFillPoints(true);
        expenseRenderer.setLineWidth(1);
        expenseRenderer.setDisplayChartValues(true);
        expenseRenderer.setShowLegendItem(false);

        // Creating XYSeriesRenderer to customize expenseSeries
        XYSeriesRenderer vedioRenderer = new XYSeriesRenderer();

        vedioRenderer.setColor(Color.LTGRAY);
        vedioRenderer.setFillPoints(true);
        vedioRenderer.setLineWidth(2);
        vedioRenderer.setDisplayChartValues(true);

        // Creating XYSeriesRenderer to customize expenseSeries
        XYSeriesRenderer productinfoRenderer = new XYSeriesRenderer();
        productinfoRenderer.setColor(Color.MAGENTA);
        productinfoRenderer.setFillPoints(true);
        productinfoRenderer.setLineWidth(2);
        productinfoRenderer.setDisplayChartValues(true);

        // Creating a XYMultipleSeriesRenderer to customize the whole chart
        XYMultipleSeriesRenderer multiRenderer = new XYMultipleSeriesRenderer();
        multiRenderer.setXLabels(0);
        multiRenderer.setChartTitle("Engagement Wise");
        multiRenderer.setXTitle("");
        multiRenderer.setYTitle("");
        if (mode == 4) {
            multiRenderer.setXAxisMax(7);
            multiRenderer.setYAxisMax(15);

        } else {
            multiRenderer.setYAxisMax(830);
            multiRenderer.setXAxisMax(4);

        }

        multiRenderer.setBarSpacing(0.4);
        multiRenderer.setXAxisMin(0.5);
        multiRenderer.setYAxisMin(0);
        multiRenderer.setZoomButtonsVisible(true);
        multiRenderer.setApplyBackgroundColor(true);
        multiRenderer.setBackgroundColor(Color.WHITE);
        multiRenderer.setMarginsColor(Color.WHITE);
        multiRenderer.setZoomEnabled(false, false);
        multiRenderer.setPanEnabled(false, false);

        for (int i = 0; i < x.length; i++) {
            multiRenderer.addXTextLabel(i, "");
        }

        multiRenderer.addSeriesRenderer(incomeRenderer);
        if (mode != 4) {
            multiRenderer.addSeriesRenderer(expenseRenderer);
        }
        multiRenderer.setZoomEnabled(false, false);
        multiRenderer.setPanEnabled(false, false);
        multiRenderer.setZoomButtonsVisible(false);

        GraphicalView mChartView = ChartFactory.getBarChartView(getActivity(),
                dataset, multiRenderer,
                org.achartengine.chart.BarChart.Type.DEFAULT);

        return mChartView;
    }

    OnClickListener touchListener = new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub

            final Dialog dialog = new Dialog(getActivity());
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            Window window = dialog.getWindow();
            window.setBackgroundDrawableResource(R.drawable.bg_roundedwhite);
            LinearLayout parent = new LinearLayout(getActivity());
            parent.setOrientation(LinearLayout.VERTICAL);

            LinearLayout parent1 = new LinearLayout(getActivity());
            parent1.setOrientation(LinearLayout.HORIZONTAL);

            LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(0,
                    LinearLayout.LayoutParams.WRAP_CONTENT, 1);
            param.bottomMargin = 10;

            TextView tv = new TextView(getActivity());
            tv.setText("");
            tv.setTextSize(18);
            tv.setLayoutParams(param);
            parent1.addView(tv);

            TextView tv1 = new TextView(getActivity());
            tv1.setText("Activity Done");
            tv1.setTextSize(18);
            tv1.setPadding(15, 0, 0, 0);
            tv1.setGravity(Gravity.LEFT);
            tv1.setLayoutParams(param);
            parent1.addView(tv1);

            TextView tv2 = new TextView(getActivity());
            tv2.setText("Engagement");
            tv2.setPadding(20, 0, 0, 0);
            tv2.setTextSize(18);
            tv2.setGravity(Gravity.CENTER_HORIZONTAL);
            tv2.setLayoutParams(param);
            parent1.addView(tv2);

            LinearLayout.LayoutParams param2 = new LinearLayout.LayoutParams(0,
                    LinearLayout.LayoutParams.WRAP_CONTENT, 1);
            param2.topMargin = 10;
            param2.rightMargin = 10;
            param2.leftMargin = 10;

            TextView cross = new TextView(getActivity());
            cross.setText(getResources().getString(R.string.icon_cross));
            cross.setTextSize(28);
            cross.setGravity(Gravity.RIGHT);
            cross.setLayoutParams(param2);
            cross.setTypeface(font);

            TextView main = new TextView(getActivity());
            main.setText("Brand Wise");
            main.setTextSize(22);
            main.setGravity(Gravity.LEFT);
            main.setLayoutParams(param2);

            LinearLayout parent2 = new LinearLayout(getActivity());
            parent2.setOrientation(LinearLayout.HORIZONTAL);

            parent2.addView(main);
            parent2.addView(cross);

            cross.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    dialog.dismiss();
                }
            });

            ListView lv = new ListView(getActivity());
            lv.setAdapter(new DialogAdapter(getActivity()));
            lv.setBackgroundColor(Color.WHITE);
            parent.addView(parent2);
            parent.addView(parent1);
            parent.addView(lv);
            dialog.setContentView(parent);
            dialog.getWindow().setLayout(800, 600);
            dialog.show();
        }
    };

    OnClickListener playListen = new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            int imageId = (int) v.getTag();
            final Dialog dialog = new Dialog(getActivity());
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            // ImageView imageView = new ImageView(getActivity());
            // imageView.setLayoutParams(new LayoutParams(
            // LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
            // imageView.setImageResource(imageId);
            dialog.setContentView(R.layout.container_dialog);
            dialog.getWindow().setLayout(1024, 800);
            dialog.getWindow().setBackgroundDrawable(
                    new ColorDrawable(android.graphics.Color.TRANSPARENT));
            dialog.show();
        }
    };

    public final class mylongclick implements OnLongClickListener

    {
        @SuppressLint("NewApi")
        @Override
        public boolean onLongClick(View v) {
            ClipData data = ClipData.newPlainText("", "");
            DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(data, shadowBuilder, v, 0);
            return true;

        }
    }

    public final class mylongclick2 implements OnLongClickListener

    {
        @SuppressLint("NewApi")
        @Override
        public boolean onLongClick(View v) {
            if (done.getVisibility() == View.VISIBLE) {
                ClipData data = ClipData.newPlainText("", "");
                DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
                v.startDrag(data, shadowBuilder, v, 0);
            }
            return true;

        }
    }

    android.view.View.OnClickListener feedListener = new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            switch (v.getId()) {
                case R.id.happy:

                    happy.setTextColor(Color.parseColor("#4fc3f7"));
                    avg.setTextColor(Color.parseColor("#212121"));
                    sad.setTextColor(Color.parseColor("#212121"));

                    break;
                case R.id.avg:
                    happy.setTextColor(Color.parseColor("#212121"));
                    avg.setTextColor(Color.parseColor("#4fc3f7"));
                    sad.setTextColor(Color.parseColor("#212121"));

                    break;
                case R.id.sad:
                    happy.setTextColor(Color.parseColor("#212121"));
                    avg.setTextColor(Color.parseColor("#212121"));
                    sad.setTextColor(Color.parseColor("#4fc3f7"));

                    break;
                case R.id.pencil:
                    dialog_box = new Dialog(getActivity());
                    dialog_box.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog_box.setContentView(R.layout.addbrandfeedback);
                    dialog_box.setCancelable(false);
                    Button addb = (Button) dialog_box.findViewById(R.id.butonadfb);
                    final Spinner sp = (Spinner) dialog_box
                            .findViewById(R.id.spineerrrrr);
                    Window window = dialog_box.getWindow();
                    window.setBackgroundDrawableResource(R.drawable.bg_roundedwhite);
                    Display display = ((WindowManager) getActivity()
                            .getSystemService(getActivity().WINDOW_SERVICE))
                            .getDefaultDisplay();
                    int width = display.getWidth();
                    int height = display.getHeight();
                    dialog_box.getWindow().setLayout(450, 250);
                    TextView txtc = (TextView) dialog_box.findViewById(R.id.cross);
                    txtc.setTypeface(font);
                    txtc.setOnClickListener(new OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            // TODO Auto-generated method stub
                            dialog_box.dismiss();
                        }
                    });
                    dialog_box.getWindow().clearFlags(
                            WindowManager.LayoutParams.FLAG_DIM_BEHIND);

                    dialog_box.show();

                    addb.setOnClickListener(new OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            // TODO Auto-generated method stub
                            dialog_box.dismiss();
                            // txt.setVisibility(View.VISIBLE);
                            ly3.setVisibility(View.VISIBLE);
                            btadd2.setVisibility(View.INVISIBLE);
                            LinearLayout ch1 = (LinearLayout) ly3.getChildAt(1);
                            LinearLayout ch2 = (LinearLayout) ly3.getChildAt(2);
                            LinearLayout ch3 = (LinearLayout) ly3.getChildAt(3);
                            LinearLayout ch4 = (LinearLayout) ly3.getChildAt(4);

                            LinearLayout chh1 = (LinearLayout) ch1.getChildAt(1);
                            LinearLayout chh2 = (LinearLayout) ch2.getChildAt(1);
                            LinearLayout chh3 = (LinearLayout) ch3.getChildAt(1);
                            LinearLayout chh4 = (LinearLayout) ch4.getChildAt(1);
                            int myc = ch1.getChildCount();
                            txt1.setVisibility(View.VISIBLE);
                            if (countMe == 1) {
                                chh1.getChildAt(1).setVisibility(View.VISIBLE);
                                chh2.getChildAt(1).setVisibility(View.VISIBLE);
                                chh3.getChildAt(1).setVisibility(View.VISIBLE);
                                chh4.getChildAt(1).setVisibility(View.VISIBLE);
                                txt2.setVisibility(View.VISIBLE);
                                countMe++;
                            } else if (countMe == 2) {
                                chh1.getChildAt(2).setVisibility(View.VISIBLE);
                                chh2.getChildAt(2).setVisibility(View.VISIBLE);
                                chh3.getChildAt(2).setVisibility(View.VISIBLE);
                                chh4.getChildAt(2).setVisibility(View.VISIBLE);
                                txt3.setVisibility(View.VISIBLE);
                                countMe++;
                            } else if (countMe == 3) {
                                chh1.getChildAt(3).setVisibility(View.VISIBLE);
                                chh2.getChildAt(3).setVisibility(View.VISIBLE);
                                chh3.getChildAt(3).setVisibility(View.VISIBLE);
                                chh4.getChildAt(3).setVisibility(View.VISIBLE);
                                txt4.setVisibility(View.VISIBLE);
                                countMe++;
                            } else {
                                countMe++;
                            }
                        }
                    });

                    break;

                default:
                    break;
            }
        }
    };

    OnClickListener listener = new OnClickListener() {

        @Override
        public void onClick(final View viewme) {
            // TODO Auto-generated method stub
            if (viewme.getTag().equals("1"))
                openDialog1(viewme);
            else {
                TextView tvdata = (TextView) viewme;
                String s = tvdata.getText().toString();

                final LinearLayout linear = new LinearLayout(getActivity());
                linear.setBackgroundResource(R.drawable.roundforlayout);
                linear.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        if (viewme.getTag().equals("2")) {
                            for (int i = 0; i < linearone.getChildCount(); i++) {
                                View view = linearone.getChildAt(i);
                                if (view == v) {
                                    linearone
                                            .getChildAt(i)
                                            .setBackgroundResource(
                                                    R.drawable.roundforsampling);
                                    linear.getChildAt(1).requestFocus();
                                } else {
                                    linearone.getChildAt(i)
                                            .setBackgroundResource(
                                                    R.drawable.roundforlayout);
                                }
                            }
                        } else if (viewme.getTag().equals("3")) {

                            for (int i = 0; i < linearthree.getChildCount(); i++) {
                                View view = linearthree.getChildAt(i);
                                if (view == v) {
                                    linearthree
                                            .getChildAt(i)
                                            .setBackgroundResource(
                                                    R.drawable.roundforsampling);
                                    linear.getChildAt(1).requestFocus();
                                } else {
                                    linearthree.getChildAt(i)
                                            .setBackgroundResource(
                                                    R.drawable.roundforlayout);
                                }
                            }

                        }
                    }
                });

                LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                        325, LayoutParams.WRAP_CONTENT);
                param.setMargins(0, 5, 0, 5);
                linear.setOrientation(LinearLayout.HORIZONTAL);
                linear.setLayoutParams(param);

                TextView tv = new TextView(getActivity());
                tv.setText(s);
                tv.setBackgroundResource(R.drawable.round_white);
                tv.setTextSize(18);
                LinearLayout.LayoutParams textparam = new LinearLayout.LayoutParams(
                        190, LinearLayout.LayoutParams.WRAP_CONTENT);
                textparam.setMargins(0, 0, 4, 0);
                tv.setLayoutParams(textparam);

                tv.setGravity(Gravity.CENTER_HORIZONTAL);
                // ---------------------------------------------------------------------------------------
                LinearLayout.LayoutParams paramedit = new LinearLayout.LayoutParams(
                        90, LinearLayout.LayoutParams.WRAP_CONTENT);
                paramedit.setMargins(0, 0, 4, 0);
                EditText ed1 = new EditText(getActivity());
                ed1.setBackgroundResource(R.drawable.round_white);
                ed1.setEms(3);
                ed1.setTextSize(18);
                ed1.setLayoutParams(paramedit);
                ed1.setText("1");
                InputFilter[] filter = new InputFilter[1];
                filter[0] = new InputFilter.LengthFilter(2);
                ed1.setFilters(filter);
                ed1.setGravity(Gravity.CENTER_HORIZONTAL);

                LinearLayout.LayoutParams parambutton = new LinearLayout.LayoutParams(
                        22, 22);
                parambutton.setMargins(2, 0, 0, 2);
                TextView bv = new TextView(getActivity());
                bv.setGravity(Gravity.RIGHT);
                bv.setBackgroundResource(R.drawable.closenew);
                bv.setLayoutParams(parambutton);
                bv.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View arg0) {
                        // TODO Auto-generated method stub
                        if (viewme.getTag().equals("2")) {
                            linearone.removeView(linear);
                            if (linearone.getChildCount() == 0)
                                table1.setVisibility(View.INVISIBLE);
                        } else if (viewme.getTag().equals("3")) {
                            linearthree.removeView(linear);
                            if (linearthree.getChildCount() == 0)
                                table2.setVisibility(View.INVISIBLE);
                        }
                    }
                });
                ed1.setInputType(InputType.TYPE_NULL);
                if (android.os.Build.VERSION.SDK_INT >= 11) {
                    ed1.setRawInputType(InputType.TYPE_CLASS_NUMBER);
                    ed1.setTextIsSelectable(true);
                }
                ed1.setOnFocusChangeListener(new OnFocusChangeListener() {

                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        // TODO Auto-generated method stub
                        if (hasFocus) {
                            focusedView = (EditText) v;
                        } else {
                            focusedView = null;
                        }
                        View parentView = (View) v.getParent();
                        if (viewme.getTag().equals("2")) {
                            for (int i = 0; i < linearone.getChildCount(); i++) {
                                View view = linearone.getChildAt(i);
                                if (view == parentView) {
                                    linearone
                                            .getChildAt(i)
                                            .setBackgroundResource(
                                                    R.drawable.roundforsampling);
                                } else {
                                    linearone.getChildAt(i)
                                            .setBackgroundResource(
                                                    R.drawable.roundforlayout);
                                }
                            }
                        } else if (viewme.getTag().equals("3")) {
                            for (int i = 0; i < linearthree.getChildCount(); i++) {
                                View view = linearthree.getChildAt(i);
                                if (view == parentView) {
                                    linearthree
                                            .getChildAt(i)
                                            .setBackgroundResource(
                                                    R.drawable.roundforsampling);
                                } else {
                                    linearthree.getChildAt(i)
                                            .setBackgroundResource(
                                                    R.drawable.roundforlayout);
                                }
                            }

                        }

                    }
                });

                linear.addView(tv);
                linear.addView(ed1);
                linear.addView(bv);
                if (viewme.getTag().equals("2")) {
                    if (linearone.getChildCount() > 0) {
                        boolean flag = false;
                        for (int i = 0; i < linearone.getChildCount(); i++) {
                            LinearLayout ll = (LinearLayout) linearone
                                    .getChildAt(i);
                            TextView text = (TextView) ll.getChildAt(0);
                            if (text.getText().toString().equals(s)) {
                                EditText edit = (EditText) ll.getChildAt(1);
                                int count = Integer.parseInt(edit.getText()
                                        .toString());
                                count = count + 1;
                                edit.setText("" + count);
                                flag = true;
                                break;
                            }
                        }
                        if (flag == false) {
                            linearone.addView(linear);
                            table1.setVisibility(View.VISIBLE);
                        }
                    } else {
                        linearone.addView(linear);
                        table1.setVisibility(View.VISIBLE);
                    }
                } else if (viewme.getTag().equals("3")) {
                    if (linearthree.getChildCount() > 0) {
                        boolean flag = false;
                        for (int i = 0; i < linearthree.getChildCount(); i++) {
                            LinearLayout ll = (LinearLayout) linearthree
                                    .getChildAt(i);
                            TextView text = (TextView) ll.getChildAt(0);
                            if (text.getText().toString().equals(s)) {
                                EditText edit = (EditText) ll.getChildAt(1);
                                int count = Integer.parseInt(edit.getText()
                                        .toString());
                                count = count + 1;
                                edit.setText("" + count);
                                flag = true;
                                break;
                            }
                        }
                        if (flag == false) {
                            linearthree.addView(linear);
                            table2.setVisibility(View.VISIBLE);
                        }
                    } else {
                        linearthree.addView(linear);
                        table2.setVisibility(View.VISIBLE);
                    }
                }
            }
        }
    };

    void addDataToSampling(final int index, String s) {

        final LinearLayout linear = new LinearLayout(getActivity());
        linear.setBackgroundResource(R.drawable.roundforlayout);
        linear.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (index == 0) {
                    for (int i = 0; i < linearone.getChildCount(); i++) {
                        View view = linearone.getChildAt(i);
                        if (view == v) {
                            linearone.getChildAt(i).setBackgroundResource(
                                    R.drawable.roundforsampling);
                            linear.getChildAt(1).requestFocus();
                        } else {
                            linearone.getChildAt(i).setBackgroundResource(
                                    R.drawable.roundforlayout);
                        }
                    }
                } else if (index == 1) {

                    for (int i = 0; i < linearthree.getChildCount(); i++) {
                        View view = linearthree.getChildAt(i);
                        if (view == v) {
                            linearthree.getChildAt(i).setBackgroundResource(
                                    R.drawable.roundforsampling);
                            linear.getChildAt(1).requestFocus();
                        } else {
                            linearthree.getChildAt(i).setBackgroundResource(
                                    R.drawable.roundforlayout);
                        }
                    }

                }
            }
        });

        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(325,
                LayoutParams.WRAP_CONTENT);
        param.setMargins(0, 5, 0, 5);
        linear.setOrientation(LinearLayout.HORIZONTAL);
        linear.setLayoutParams(param);

        TextView tv = new TextView(getActivity());
        tv.setText(s);
        tv.setBackgroundResource(R.drawable.round_white);
        tv.setTextSize(18);
        LinearLayout.LayoutParams textparam = new LinearLayout.LayoutParams(
                190, LinearLayout.LayoutParams.WRAP_CONTENT);
        textparam.setMargins(0, 0, 4, 0);
        tv.setLayoutParams(textparam);

        tv.setGravity(Gravity.CENTER_HORIZONTAL);
        // ---------------------------------------------------------------------------------------
        LinearLayout.LayoutParams paramedit = new LinearLayout.LayoutParams(90,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        paramedit.setMargins(0, 0, 4, 0);
        EditText ed1 = new EditText(getActivity());
        ed1.setBackgroundResource(R.drawable.round_white);
        ed1.setEms(3);
        ed1.setTextSize(18);
        ed1.setLayoutParams(paramedit);
        ed1.setText("1");
        InputFilter[] filter = new InputFilter[1];
        filter[0] = new InputFilter.LengthFilter(2);
        ed1.setFilters(filter);
        ed1.setGravity(Gravity.CENTER_HORIZONTAL);

        LinearLayout.LayoutParams parambutton = new LinearLayout.LayoutParams(
                22, 22);
        parambutton.setMargins(2, 0, 0, 2);
        TextView bv = new TextView(getActivity());
        bv.setGravity(Gravity.RIGHT);
        bv.setBackgroundResource(R.drawable.closenew);
        bv.setLayoutParams(parambutton);
        bv.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                if (index == 0) {
                    linearone.removeView(linear);
                    if (linearone.getChildCount() == 0)
                        table1.setVisibility(View.INVISIBLE);
                } else if (index == 1) {
                    linearthree.removeView(linear);
                    if (linearthree.getChildCount() == 0)
                        table2.setVisibility(View.INVISIBLE);
                }
            }
        });
        ed1.setInputType(InputType.TYPE_NULL);
        if (android.os.Build.VERSION.SDK_INT >= 11) {
            ed1.setRawInputType(InputType.TYPE_CLASS_NUMBER);
            ed1.setTextIsSelectable(true);
        }
        ed1.setOnFocusChangeListener(new OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                // TODO Auto-generated method stub
                if (hasFocus) {
                    focusedView = (EditText) v;
                } else {
                    focusedView = null;
                }
                View parentView = (View) v.getParent();
                if (index == 0) {
                    for (int i = 0; i < linearone.getChildCount(); i++) {
                        View view = linearone.getChildAt(i);
                        if (view == parentView) {
                            linearone.getChildAt(i).setBackgroundResource(
                                    R.drawable.roundforsampling);
                        } else {
                            linearone.getChildAt(i).setBackgroundResource(
                                    R.drawable.roundforlayout);
                        }
                    }
                } else if (index == 1) {
                    for (int i = 0; i < linearthree.getChildCount(); i++) {
                        View view = linearthree.getChildAt(i);
                        if (view == parentView) {
                            linearthree.getChildAt(i).setBackgroundResource(
                                    R.drawable.roundforsampling);
                        } else {
                            linearthree.getChildAt(i).setBackgroundResource(
                                    R.drawable.roundforlayout);
                        }
                    }

                }

            }
        });

        linear.addView(tv);
        linear.addView(ed1);
        linear.addView(bv);
        if (index == 0) {
            if (linearone.getChildCount() > 0) {
                boolean flag = false;
                for (int i = 0; i < linearone.getChildCount(); i++) {
                    LinearLayout ll = (LinearLayout) linearone.getChildAt(i);
                    TextView text = (TextView) ll.getChildAt(0);
                    if (text.getText().toString().equals(s)) {
                        EditText edit = (EditText) ll.getChildAt(1);
                        int count = Integer.parseInt(edit.getText().toString());
                        count = count + 1;
                        edit.setText("" + count);
                        flag = true;
                        break;
                    }
                }
                if (flag == false) {
                    linearone.addView(linear);
                    table1.setVisibility(View.VISIBLE);
                }
            } else {
                linearone.addView(linear);
                table1.setVisibility(View.VISIBLE);
            }
        } else if (index == 1) {
            if (linearthree.getChildCount() > 0) {
                boolean flag = false;
                for (int i = 0; i < linearthree.getChildCount(); i++) {
                    LinearLayout ll = (LinearLayout) linearthree.getChildAt(i);
                    TextView text = (TextView) ll.getChildAt(0);
                    if (text.getText().toString().equals(s)) {
                        EditText edit = (EditText) ll.getChildAt(1);
                        int count = Integer.parseInt(edit.getText().toString());
                        count = count + 1;
                        edit.setText("" + count);
                        flag = true;
                        break;
                    }
                }
                if (flag == false) {
                    linearthree.addView(linear);
                    table2.setVisibility(View.VISIBLE);
                }
            } else {
                linearthree.addView(linear);
                table2.setVisibility(View.VISIBLE);
            }
        }

    }

    OnClickListener cardListener = new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub

            String[][] personaldata = {{"Photo of Doctor", "", "b"},
                    {"Mobile No", "99898978934", "b"},
                    {"Email ID", "neel@kglfh.com", "b"},
                    {"Pan  No", "PAN123456", "b"},
                    {"Legacy code", "67589445", "b"},
                    {"Martial status", "Married", "b"}};

            String[][] personaldata1 = {
                    {
                            "Clinic address",
                            "Lorem ipsum dolor sit amet,consectetur adipiscing elit.Nullam viverra justo at orci ultrices,quis sagittis turpis pretium.Lorem ipsum dolo",
                            "b"}, {"Consultation Fees", "$10", "b"},
                    {"Category", "private", "b"},
                    {"BlogAddress", "http://johnblogspot.com", "b"},
                    {"Teaching Awards", "Medium", "b"},
                    {"Medical Literature", "High", "b"},
                    {"Medical Service", "High", "b"}};

            String[][] personaldata2 = {{"Photo of Rx Pad", "", "b"},
                    {"Photo of vCARD", "99898978934", "b"},
                    {"photos of clinic", "neel@kglfh.com", "b"}};
            final String[] cameradialog = {"Camera", "Gallery", "Delete"};
            Integer[] intimg1 = {R.drawable.rx_pad, R.drawable.pix_crd,
                    R.drawable.pix_clinic_pic};
            final Dialog dialog = new Dialog(getActivity());
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.profileidentity);
            fullscroll = (ScrollView) dialog.findViewById(R.id.fullscroll);
            TextView view1 = (TextView) dialog
                    .findViewById(R.id.personal_label);
            View view2 = (View) dialog.findViewById(R.id.include1);
            View view3 = (View) dialog.findViewById(R.id.include2);
            View view4 = (View) dialog.findViewById(R.id.include3);
            View view5 = (View) dialog.findViewById(R.id.include4);
            View view6 = (View) dialog.findViewById(R.id.include5);
            View view7 = (View) dialog.findViewById(R.id.include6);
            View view8 = (View) dialog.findViewById(R.id.include7);

            id = v.getId();
            switch (v.getId()) {
                case 1:
                    ScrollTo(view6);
                    break;
                case 2:
                    ScrollTo(view1);
                    break;
                case 3:
                    ScrollTo(view7);
                    break;
                case 4:
                    ScrollTo(view4);
                    break;
                case 5:
                    ScrollTo(view5);
                    break;
                case 6:
                    ScrollTo(view8);
                    break;
                case 7:
                    ScrollTo(view3);
                    break;
                case 8:
                    ScrollTo(view2);
                    break;

                default:
                    break;
            }
            dialog.getWindow().getAttributes().gravity = Gravity.CENTER_HORIZONTAL;
            TextView tvv = (TextView) dialog.findViewById(R.id.textpro31);
            TextView tvv1 = (TextView) dialog.findViewById(R.id.textpro33);
            tvv.setTypeface(font);
            tvv1.setTypeface(font);
            tvv1.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    openEditProfile(1, id);
                }
            });
            tvv.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    dialog.dismiss();
                }
            });

            LinearLayout tblPersonalInfo = (LinearLayout) dialog
                    .findViewById(R.id.tbl_personal_info);
            tblPersonalInfo.setPadding(0, 5, 5, 5);

            // Populate personal table
            for (int i = 0; i < personaldata.length; i++) {

                LinearLayout tableRow = new LinearLayout(getActivity());
                tableRow.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
                tableRow.setOrientation(LinearLayout.VERTICAL);

                tableRow.setPadding(0, 5, 5, 25);

                TextView labelView = new TextView(getActivity());
                labelView.setTextColor(Color.BLACK);
                labelView.setTextSize(17);
                labelView.setId(1);

                TextView labelView1 = new TextView(getActivity());
                labelView1.setTextColor(Color.BLACK);
                labelView1.setTextSize(17);

                TextView labelView2 = new TextView(getActivity());
                labelView2.setTextColor(Color.BLACK);
                labelView2.setTextSize(30);
                labelView2.setText(R.string.icon_camera);
                labelView2.setTypeface(font);

                LinearLayout.LayoutParams tableRowLayoutParams1 = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
                LinearLayout.LayoutParams tableRowLayoutParams2 = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
                RelativeLayout.LayoutParams tableRowLayoutParams3 = new RelativeLayout.LayoutParams(
                        100, 100);
                tableRowLayoutParams3
                        .addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);

                tableRowLayoutParams1.setMargins(0, 0, 10, 0);
                labelView.setLayoutParams(tableRowLayoutParams1);
                labelView1.setLayoutParams(tableRowLayoutParams2);

                if (i == 0) {
                    LayoutInflater mInflater = (LayoutInflater) getActivity()
                            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    final RelativeLayout Rlinear = (RelativeLayout) mInflater
                            .inflate(R.layout.row2, null);
                    iv = (ImageView) Rlinear.findViewById(R.id.myimage);
                    iv.setLayoutParams(tableRowLayoutParams3);
                    iv.setBackgroundResource(R.drawable.ic_account_box_black_48dp);
                    TextView tv = (TextView) Rlinear.findViewById(R.id.textmy);
                    tv.setTextSize(30);
                    tv.setText(R.string.icon_camera);
                    tv.setTypeface(font);
                    tv.setOnClickListener(new OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            // TODO Auto-generated method stub
                            final Dialog selectDialog = new Dialog(
                                    getActivity());

                            selectDialog
                                    .requestWindowFeature(Window.FEATURE_NO_TITLE);
                            selectDialog.getWindow().setBackgroundDrawable(
                                    new ColorDrawable(
                                            android.R.color.transparent));
                            selectDialog.setContentView(R.layout.dialog);

                            final ListView lvUnplanned = (ListView) selectDialog
                                    .findViewById(R.id.listview1);
                            lvUnplanned.setAdapter(new ArrayAdapter<String>(
                                    getActivity(), R.layout.simple_list_item,
                                    cameradialog));
                            lvUnplanned
                                    .setOnItemClickListener(new OnItemClickListener() {

                                        @Override
                                        public void onItemClick(
                                                AdapterView<?> arg0, View arg1,
                                                int arg2, long arg3) {

                                            if (arg2 == 0) {
                                                Intent takePictureIntent = new Intent(
                                                        MediaStore.ACTION_IMAGE_CAPTURE);
                                                startActivityForResult(
                                                        takePictureIntent, 1);
                                                selectDialog.dismiss();
                                            } else if (arg2 == 2) {
                                                iv.setImageResource(R.drawable.ic_account_box_black_48dp);
                                                selectDialog.dismiss();
                                            } else {
                                                Intent photoPickerIntent = new Intent(
                                                        Intent.ACTION_PICK);
                                                photoPickerIntent
                                                        .setType("image/*");
                                                startActivityForResult(
                                                        photoPickerIntent, 2);
                                                selectDialog.dismiss();

                                            }
                                        }
                                    });

                            selectDialog.show();

                        }
                    });
                    labelView.setText(personaldata[i][0]);

                    tableRow.addView(labelView);

                    tableRow.addView(Rlinear);
                } else {
                    labelView.setText(personaldata[i][0]);
                    labelView.setTextColor(Color.GRAY);
                    labelView.setTypeface(null, Typeface.ITALIC);
                    labelView1.setText(personaldata[i][1]);
                    tableRow.addView(labelView);

                    tableRow.addView(labelView1);
                }
                tblPersonalInfo.addView(tableRow);
            }
            LinearLayout tblPersonalInfo1 = (LinearLayout) dialog
                    .findViewById(R.id.tbl_personal_info1);
            tblPersonalInfo1.setPadding(0, 5, 5, 5);

            // Populate personal table
            for (int i = 0; i < personaldata1.length; i++) {

                LinearLayout tableRow = new LinearLayout(getActivity());
                tableRow.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
                tableRow.setOrientation(LinearLayout.VERTICAL);

                tableRow.setPadding(5, 5, 5, 25);

                TextView labelView = new TextView(getActivity());
                // labelView.setTextColor(Color.BLACK);
                labelView.setTextSize(17);

                TextView labelView1 = new TextView(getActivity());
                labelView1.setTextColor(Color.BLACK);
                labelView1.setTextSize(17);

                LinearLayout.LayoutParams tableRowLayoutParams1 = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
                LinearLayout.LayoutParams tableRowLayoutParams2 = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);

                tableRowLayoutParams1.setMargins(0, 0, 10, 0);
                labelView.setLayoutParams(tableRowLayoutParams1);
                labelView1.setLayoutParams(tableRowLayoutParams2);

                labelView.setTextColor(Color.GRAY);
                labelView.setTypeface(null, Typeface.ITALIC);
                labelView.setText(personaldata1[i][0]);
                labelView1.setText(personaldata1[i][1]);
                // }

                tableRow.addView(labelView);
                tableRow.addView(labelView1);

                tblPersonalInfo1.addView(tableRow);

            }

            LinearLayout tblPersonalInfo2 = (LinearLayout) dialog
                    .findViewById(R.id.tbl_personal_info2);
            tblPersonalInfo2.setPadding(5, 5, 5, 5);

            // Populate personal table
            for (int i = 0; i < personaldata2.length; i++) {
                LinearLayout tableRow = new LinearLayout(getActivity());
                tableRow.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
                tableRow.setOrientation(LinearLayout.VERTICAL);

                tableRow.setPadding(5, 5, 5, 25);

                TextView labelView = new TextView(getActivity());
                labelView.setTextColor(Color.BLACK);
                labelView.setTextSize(17);
                labelView.setTypeface(null, Typeface.ITALIC);
                TextView labelView1 = new TextView(getActivity());
                labelView1.setTextColor(Color.BLACK);
                labelView1.setTextSize(17);

                LinearLayout.LayoutParams tableRowLayoutParams1 = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
                LinearLayout.LayoutParams tableRowLayoutParams2 = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);

                tableRowLayoutParams1.setMargins(0, 0, 10, 0);
                labelView.setLayoutParams(tableRowLayoutParams1);
                labelView1.setLayoutParams(tableRowLayoutParams2);

                labelView.setText(personaldata2[i][0]);

                LayoutInflater mInflater = (LayoutInflater) getActivity()
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final RelativeLayout Rlinear = (RelativeLayout) mInflater
                        .inflate(R.layout.row2, null);
                iv = (ImageView) Rlinear.findViewById(R.id.myimage);

                iv.setBackgroundResource(intimg1[i]);

                TextView tv = (TextView) Rlinear.findViewById(R.id.textmy);
                tv.setTextSize(30);
                tv.setText(R.string.icon_camera);
                tv.setTypeface(font);

                tableRow.addView(labelView);
                tableRow.addView(Rlinear);

                tblPersonalInfo2.addView(tableRow);
            }
            dialog.getWindow().setLayout(1000, 600);
            dialog.getWindow().setBackgroundDrawableResource(
                    R.drawable.circularcornerlist);

            dialog.show();

        }
    };

    OnClickListener cardEditListener = new OnClickListener() {

        @Override
        public void onClick(View v) {
            openEditProfile(0, 0);
        }
    };

    public void openEditProfile(int index, int id) {

        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.profile_edit);
        TextView cam1 = (TextView) dialog.findViewById(R.id.cam1);
        cam1.setTypeface(font);
        TextView cam2 = (TextView) dialog.findViewById(R.id.cam2);
        cam2.setTypeface(font);
        TextView cam3 = (TextView) dialog.findViewById(R.id.cam3);
        cam3.setTypeface(font);
        TextView tvv = (TextView) dialog.findViewById(R.id.textpro31);
        tvv.setTypeface(font);
        tvv.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                dialog.dismiss();
            }
        });
        if (index == 1) {
            fullscrollEdit = (ScrollView) dialog
                    .findViewById(R.id.fullscroll_edit);
            TextView view1 = (TextView) dialog.findViewById(R.id.identity);
            View view2 = (View) dialog.findViewById(R.id.include1);
            View view3 = (View) dialog.findViewById(R.id.include2);
            View view4 = (View) dialog.findViewById(R.id.include3);
            View view5 = (View) dialog.findViewById(R.id.include4);
            View view6 = (View) dialog.findViewById(R.id.include5);
            View view7 = (View) dialog.findViewById(R.id.include6);
            View view8 = (View) dialog.findViewById(R.id.include7);
            switch (id) {
                case 1:
                    ScrollToEdit(view4);
                    break;
                case 2:
                    ScrollToEdit(view1);
                    break;
                case 3:
                    ScrollToEdit(view5);
                    break;
                case 4:
                    ScrollToEdit(view2);
                    break;
                case 5:
                    ScrollToEdit(view3);
                    break;
                case 6:
                    ScrollToEdit(view7);
                    break;
                case 7:
                    ScrollToEdit(view6);
                    break;
                case 8:
                    ScrollToEdit(view8);
                    break;

                default:
                    break;
            }
        }
        dialog.getWindow().getAttributes().gravity = Gravity.CENTER_HORIZONTAL;
        dialog.getWindow().setLayout(1000, 600);
        dialog.getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        dialog.getWindow().setBackgroundDrawableResource(
                R.drawable.circularcornerlist);
        dialog.show();
    }

    void openDialog1(final View viewme) {
        final TextView textView = (TextView) viewme;
        // TODO Auto-generated method stub
        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.main);
        Button b1 = (Button) dialog.findViewById(R.id.button1);

        b1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                final ArrayList<Integer> posSel = new ArrayList<Integer>();
                name = new ArrayList<String>();
                posSel.clear();
                boolean noSelect = false;
                for (int i = 0; i < thumbnailsselection.length; i++) {
                    if (thumbnailsselection[i] == true) {
                        noSelect = true;
                        Log.e("sel pos thu-->", "" + i);
                        posSel.add(i);
                        name.add(items.get(i));

                        // break;
                    }
                }
                dialog.dismiss();
                for (int j = 0; j < name.size(); j++) {
                    String s = textView.getText().toString();

                    final LinearLayout linear = new LinearLayout(getActivity());
                    linear.setBackgroundResource(R.drawable.roundforlayout);
                    linear.setOnClickListener(new OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            // TODO Auto-generated method stub
                            for (int i = 0; i < linearone.getChildCount(); i++) {
                                View view = linearone.getChildAt(i);
                                if (view == v) {
                                    linearone
                                            .getChildAt(i)
                                            .setBackgroundResource(
                                                    R.drawable.roundforsampling);
                                    linear.getChildAt(1).requestFocus();
                                } else {
                                    linearone.getChildAt(i)
                                            .setBackgroundResource(
                                                    R.drawable.roundforlayout);
                                }
                            }
                        }
                    });

                    LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                            325, LayoutParams.WRAP_CONTENT);
                    param.setMargins(0, 5, 0, 5);
                    linear.setOrientation(LinearLayout.HORIZONTAL);
                    linear.setLayoutParams(param);

                    TextView tv = new TextView(getActivity());
                    tv.setText(s + " " + name.get(j));
                    tv.setBackgroundResource(R.drawable.round_white);

                    tv.setTextSize(18);
                    LinearLayout.LayoutParams textparam = new LinearLayout.LayoutParams(
                            190, LinearLayout.LayoutParams.WRAP_CONTENT);
                    tv.setLayoutParams(textparam);
                    textparam.setMargins(0, 0, 4, 0);
                    tv.setGravity(Gravity.CENTER_HORIZONTAL);
                    // ---------------------------------------------------------------------------------------
                    LinearLayout.LayoutParams paramedit = new LinearLayout.LayoutParams(
                            90, LinearLayout.LayoutParams.WRAP_CONTENT);
                    EditText ed1 = new EditText(getActivity());
                    ed1.setBackgroundResource(R.drawable.round_white);
                    ed1.setEms(3);
                    ed1.setTextSize(18);
                    ed1.setText("1");
                    paramedit.setMargins(0, 0, 4, 0);
                    ed1.setLayoutParams(paramedit);
                    InputFilter[] filter = new InputFilter[1];
                    filter[0] = new InputFilter.LengthFilter(2);
                    ed1.setFilters(filter);
                    ed1.setGravity(Gravity.CENTER_HORIZONTAL);

                    LinearLayout.LayoutParams parambutton = new LinearLayout.LayoutParams(
                            22, 22);
                    TextView bv = new TextView(getActivity());
                    bv.setGravity(Gravity.RIGHT);
                    parambutton.setMargins(2, 0, 0, 2);
                    bv.setBackgroundResource(R.drawable.closenew);
                    bv.setLayoutParams(parambutton);
                    bv.setOnClickListener(new OnClickListener() {

                        @Override
                        public void onClick(View arg0) {
                            // TODO Auto-generated method stub
                            linearone.removeView(linear);
                            if (linearone.getChildCount() == 0)
                                table1.setVisibility(View.INVISIBLE);
                        }
                    });
                    ed1.setInputType(InputType.TYPE_NULL);
                    if (android.os.Build.VERSION.SDK_INT >= 11) {
                        ed1.setRawInputType(InputType.TYPE_CLASS_NUMBER);
                        ed1.setTextIsSelectable(true);
                    }
                    ed1.setOnFocusChangeListener(new OnFocusChangeListener() {

                        @Override
                        public void onFocusChange(View v, boolean hasFocus) {
                            // TODO Auto-generated method stub
                            if (hasFocus) {
                                focusedView = (EditText) v;
                            } else {
                                focusedView = null;
                            }
                            View parentView = (View) v.getParent();
                            for (int i = 0; i < linearone.getChildCount(); i++) {
                                View view = linearone.getChildAt(i);
                                if (view == parentView) {
                                    linearone
                                            .getChildAt(i)
                                            .setBackgroundResource(
                                                    R.drawable.roundforsampling);
                                } else {
                                    linearone.getChildAt(i)
                                            .setBackgroundResource(
                                                    R.drawable.roundforlayout);
                                }
                            }

                        }
                    });

                    linear.addView(tv);
                    linear.addView(ed1);
                    linear.addView(bv);

                    linearone.addView(linear);
                    table1.setVisibility(View.VISIBLE);

                }
            }
        });

        dialog.getWindow().setLayout(300, 200);
        int[] viewLocation = new int[2];
        viewme.getLocationOnScreen(viewLocation);
        WindowManager.LayoutParams wmlp = dialog.getWindow().getAttributes();
        wmlp.gravity = Gravity.TOP | Gravity.LEFT;
        wmlp.x = viewLocation[0];
        wmlp.y = viewLocation[1];
        dialog.getWindow().setBackgroundDrawableResource(
                R.drawable.circularcornerlist);
        fillarray();
        count = items.size();
        thumbnailsselection = new boolean[count];
        listview = (ListView) dialog.findViewById(R.id.mainListView);
        listview.setAdapter(new ImageAdapter(getActivity()));

        dialog.show();

    }

    private void fillarray() {
        // TODO Auto-generated method stub
        items.clear();
        items.add("50 DT");
        items.add("100 DT");
        items.add("200 DT");
        items.add("250 DT");
        items.add("Dry syrup");
    }

    public class ImageAdapter extends BaseAdapter {
        private LayoutInflater mInflater;
        private Context mContext;

        public ImageAdapter(Context context) {
            mContext = context;
        }

        public int getCount() {
            return count;
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = LayoutInflater.from(mContext).inflate(
                        R.layout.row_photo, null);
                holder.textview = (TextView) convertView
                        .findViewById(R.id.thumbImage);
                holder.textview.setTextColor(Color.WHITE);
                holder.checkbox = (CheckBox) convertView
                        .findViewById(R.id.itemCheckBox);

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.checkbox.setId(position);
            holder.textview.setId(position);
            holder.checkbox.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    CheckBox cb = (CheckBox) v;
                    int id = cb.getId();
                    if (thumbnailsselection[id]) {
                        cb.setChecked(false);
                        thumbnailsselection[id] = false;
                    } else {
                        cb.setChecked(true);
                        thumbnailsselection[id] = true;

                        System.out.println("cmncm" + items.get(id));

                    }
                }
            });
            holder.textview.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    int id = v.getId();
                }
            });
            holder.textview.setText(items.get(position));
            holder.checkbox.setChecked(thumbnailsselection[position]);
            holder.id = position;
            return convertView;
        }
    }

    class ViewHolder {
        TextView textview;
        CheckBox checkbox;
        int id;
    }

    public void saveSig() {
        try {
            gesture.setDrawingCacheEnabled(true);
            Bitmap bm = Bitmap.createBitmap(gesture.getDrawingCache());
            ByteArrayOutputStream bytearraydata = new ByteArrayOutputStream();
            bm.compress(Bitmap.CompressFormat.PNG, 100, bytearraydata);
            String imagedata = Base64.encodeToString(
                    bytearraydata.toByteArray(), Base64.DEFAULT);
            System.out.println(imagedata);

        } catch (Exception e) {
            Log.v("Gestures", e.getMessage());
            e.printStackTrace();

        }

    }

    public void getsinglebarchart(View v) {

        mChart = (BarChart) v.findViewById(R.id.chart1);
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

        setData(5, 50);

        for (DataSet<?> set : mChart.getData().getDataSets())
            set.setDrawValues(!set.isDrawValuesEnabled());
        mChart.invalidate();

        // setting data

    }

    private void setData(int count, float range) {

        ArrayList<String> xVals = new ArrayList<String>();
        for (int i = 0; i < count; i++) {
            xVals.add(mMonths[i % 12]);
        }

        ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();

        for (int i = 0; i < count; i++) {
            float mult = (range + 1);
            float val = (float) (Math.random() * mult);
            yVals1.add(new BarEntry(val, i));
        }

        BarDataSet set1 = new BarDataSet(yVals1, "");
        set1.setBarSpacePercent(35f);

        ArrayList<BarDataSet> dataSets = new ArrayList<BarDataSet>();
        dataSets.add(set1);

        BarData data = new BarData(xVals, dataSets);
        // data.setValueFormatter(new MyValueFormatter());
        data.setValueTextSize(10f);
        data.setValueTypeface(mTf);
        mChart.setPinchZoom(false);
        // mChart.setDrawValueAboveBar(false);
        mChart.setData(data);
    }

    private BarChart multibarchart() {
        BarChart chart = new BarChart(getActivity());
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

        // chart.animateY(3000);

        return chart;

    }

    public View getMyViewForReporting() {
        LayoutInflater inflater = (LayoutInflater) getActivity()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.detailing_fragment, null);

        final TextView preview = (TextView) v.findViewById(R.id.preview);
        preview.setTypeface(font);

        List<String> list1 = new ArrayList<String>();
        list1.add("Specialty");
        list1.add("Brands");
        list1.add("Therapy");
        list1.add("Services");
        list1.add("Corporate");

        List<String> list2 = new ArrayList<String>();
        list2.add("C-fix");
        list2.add("Fade Pill");
        list2.add("Mezzo Drop");
        list2.add("Still Sep");
        list2.add("Acenomorol");
        list2.add("Solsuna");

        MultiSpinner multiSpinner = (MultiSpinner) v
                .findViewById(R.id.spinner1);
        multiSpinner.setItems(list1, "Category", new MultiSpinnerListener() {

            @Override
            public void onItemsSelected(boolean[] selected) {
                // TODO Auto-generated method stub

            }
        });
        MultiSpinner multiSpinner2 = (MultiSpinner) v
                .findViewById(R.id.spinner2);
        multiSpinner2.setItems(list2, "Sub-Category",
                new MultiSpinnerListener() {

                    @Override
                    public void onItemsSelected(boolean[] selected) {
                        // TODO Auto-generated method stub

                    }
                });
        final RelativeLayout manual_layout = (RelativeLayout) v
                .findViewById(R.id.manual_layout);
        final RelativeLayout main_layout = (RelativeLayout) v
                .findViewById(R.id.main_relative);
        CheckBox check_me = (CheckBox) v.findViewById(R.id.check_me);
        check_me.setChecked(true);
        check_me.setVisibility(View.GONE);
        manual_layout.setVisibility(View.VISIBLE);
        main_layout.setMinimumHeight(870);
        check_me.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                // TODO Auto-generated method stub
                if (isChecked) {
                    manual_layout.setVisibility(View.VISIBLE);
                    main_layout.setMinimumHeight(870);
                } else {
                    manual_layout.setVisibility(View.GONE);
                    main_layout.setMinimumHeight(770);
                }
            }
        });

        RelativeLayout del1 = (RelativeLayout) v.findViewById(R.id.first);
        RelativeLayout del2 = (RelativeLayout) v.findViewById(R.id.second);
        RelativeLayout del3 = (RelativeLayout) v.findViewById(R.id.third);
        RelativeLayout del4 = (RelativeLayout) v.findViewById(R.id.forth);
        RelativeLayout del5 = (RelativeLayout) v.findViewById(R.id.fifth);

        del1.setTag("1");
        del2.setTag("1");
        del3.setTag("1");
        del4.setTag("1");
        del5.setTag("1");

        del1.setOnClickListener(deleteListener);
        del2.setOnClickListener(deleteListener);
        del3.setOnClickListener(deleteListener);
        del4.setOnClickListener(deleteListener);
        del5.setOnClickListener(deleteListener);

        preview.setOnClickListener(new OnClickListener() {

            @SuppressLint("JavascriptInterface")
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(getActivity());
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                Display display = ((WindowManager) getActivity()
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
                Typeface font = Typeface.createFromAsset(getActivity()
                        .getAssets(), "fontawesome-webfont.ttf");
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
            }
        });
        final ImageView undo = (ImageView) v.findViewById(R.id.undo);
        undo.setVisibility(View.INVISIBLE);
        final GridView addScoll = (GridView) v.findViewById(R.id.addscroll);
        undo.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                addDataList(addScoll);
                undo.setVisibility(View.INVISIBLE);
            }
        });

        addDataList(addScoll);
        return v;

    }

    OnClickListener deleteListener = new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            if (v.getTag().equals("1")) {
                v.setBackground(new ColorDrawable(Color.parseColor("#00FFFF")));
                v.setTag("2");
            } else if (v.getTag().equals("2")) {
                v.setBackground(new ColorDrawable(Color.parseColor("#D1D1D1")));
                v.setTag("1");
            }
            // ((RelativeLayout) v.getParent()).setVisibility(View.GONE);
        }
    };

    void addDataList(GridView addScoll) {
        final ArrayList<RelativeLayout> arrList;
        arrList = new ArrayList<RelativeLayout>();
        arrList.add(Utility.getThumnailReporting(getActivity(),
                R.drawable.screen2, "Introduction \nC-FIX", R.string.clock,
                R.string.thumb, R.string.mail));
        arrList.add(Utility.getThumnailReporting(getActivity(),
                R.drawable.newcfix1, "Risk Factors of CVD\nC-FIX",
                R.string.clock, R.string.thumb, R.string.mail));
        arrList.add(Utility.getThumnailReporting(getActivity(),
                R.drawable.newcfix3, "Side Effects \nC-FIX", R.string.clock,
                R.string.thumb, R.string.mail));

        arrList.add(Utility.getThumnailReporting(getActivity(),
                R.drawable.dem1, "Types of CVD\nDempi", R.string.clock,
                R.string.thumb, R.string.mail));
        arrList.add(Utility.getThumnailReporting(getActivity(),
                R.drawable.dem2, "Risk Factors of CVD\nDempi", R.string.clock,
                R.string.thumb, R.string.mail));
        arrList.add(Utility.getThumnailReporting(getActivity(),
                R.drawable.dem3, "Research Paper\ndempi", R.string.clock,
                R.string.thumb, R.string.mail));

        arrList.add(Utility.getThumnailReporting(getActivity(),
                R.drawable.solsuna, "Introduction \nSolsuna", R.string.clock,
                R.string.thumb, R.string.mail));
        arrList.add(Utility.getThumnailReporting(getActivity(),
                R.drawable.solsuna2, "Description\nSolsuna", R.string.clock,
                R.string.thumb, R.string.mail));
        arrList.add(Utility.getThumnailReporting(getActivity(),
                R.drawable.solsuna3, "Research Paper\nSolsuna", R.string.clock,
                R.string.thumb, R.string.mail));

        arrList.add(Utility.getThumnailReporting(getActivity(),
                R.drawable.dew1, "Types of CVD\nJade dew pill", R.string.clock,
                R.string.thumb, R.string.mail));
        arrList.add(Utility.getThumnailReporting(getActivity(),
                R.drawable.dew2, "Efficacy\nJade dew pill", R.string.clock,
                R.string.thumb, R.string.mail));
        arrList.add(Utility.getThumnailReporting(getActivity(),
                R.drawable.dew3, "Research Paper\nJade dew pill",
                R.string.clock, R.string.thumb, R.string.mail));

        addScoll.setAdapter(new GridAdapterReporting(getActivity(), arrList));
    }

    public View getMyView(int index) {
        LayoutInflater inflater = (LayoutInflater) getActivity()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.playlist_fragment, null);

        final EditText search = (EditText) v.findViewById(R.id.searchtxt);
        search.setCompoundDrawablesWithIntrinsicBounds(R.drawable.search12, 0,
                R.drawable.cancel12, 0);
        final LinearLayout main = (LinearLayout) v.findViewById(R.id.main);
        TextView cardio = (TextView) v.findViewById(R.id.cardio);
        rehearse_icon = (ImageView) v.findViewById(R.id.rehearse);

        rehearse_icon.setOnClickListener(rehearse);

        ImageView searchicon = (ImageView) v.findViewById(R.id.search);
        searchicon.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (!search.getText().toString().equals(""))
                    main.setVisibility(View.VISIBLE);
            }
        });

        final RelativeLayout right1 = (RelativeLayout) v
                .findViewById(R.id.right1);
        final RelativeLayout right2 = (RelativeLayout) v
                .findViewById(R.id.right2);

        final TextView pen = (TextView) v.findViewById(R.id.pen);
        final ImageView done = (ImageView) v.findViewById(R.id.done);
        final ImageView cancel = (ImageView) v.findViewById(R.id.cancel);
        final ImageView undo = (ImageView) v.findViewById(R.id.undo);

        final LinearLayout play_layout = (LinearLayout) v
                .findViewById(R.id.play_layout);

        undo.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                undo.setVisibility(View.INVISIBLE);
            }
        });

        final GridView addScoll = (GridView) v.findViewById(R.id.addscroll);
        addScoll.setNumColumns(5);
        addScoll.setVerticalSpacing(1);
        addScoll.setHorizontalSpacing(1);
        RelativeLayout.LayoutParams param = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        param.addRule(RelativeLayout.BELOW, R.id.cardio);
        param.setMargins(25, 15, 160, 2);
        addScoll.setLayoutParams(param);
        final ArrayList<RelativeLayout> arrList;
        arrList = new ArrayList<RelativeLayout>();
        if (index == 0) {
            arrList.add(Utility.getThumnailForPhysi(getActivity(),
                    R.drawable.newcfix2, "Introduction", 0, 0, 0, "C-FIX"));
            arrList.add(Utility.getThumnailForPhysi(getActivity(),
                    R.drawable.newcfix1, "Types of CVD", 0, 1, 0, "C-FIX"));
            arrList.add(Utility
                    .getThumnailForPhysi(getActivity(), R.drawable.newcfix3,
                            "Risk Factor of CVD", 1, 0, 0, "C-FIX"));
            arrList.add(Utility.getThumnailForPhysi(getActivity(),
                    R.drawable.dew1, "Introduction", 0, 1, 1, "Jade dew pill"));
            arrList.add(Utility.getThumnailForPhysi(getActivity(),
                    R.drawable.dew2, "Efficacy", 0, 1, 1, "Jade dew pill"));
            arrList.add(Utility.getThumnailForPhysi(getActivity(),
                    R.drawable.dew3, "Description", 0, 1, 1, "Jade dew pill"));
            arrList.add(Utility.getThumnailForPhysi(getActivity(),
                    R.drawable.mezzodrop1, "Introduction", 0, 1, 1,
                    "Mezzo Drop"));
            arrList.add(Utility
                    .getThumnailForPhysi(getActivity(), R.drawable.mezzodrop2,
                            "Plus Points", 0, 1, 1, "Mezzo Drop"));
            arrList.add(Utility.getThumnailForPhysi(getActivity(),
                    R.drawable.mezzodrop, "Precautions", 1, 0, 0, "Mezzo Drop"));
            arrList.add(Utility.getThumnailForPhysi(getActivity(),
                    R.drawable.solsuna, "Introduction", 0, 1, 1, "Solsuna"));
            arrList.add(Utility.getThumnailForPhysi(getActivity(),
                    R.drawable.solsuna2, "Design", 1, 0, 0, "Solsuna"));
            arrList.add(Utility.getThumnailForPhysi(getActivity(),
                    R.drawable.solsuna3, "Dosage", 1, 0, 0, "Solsuna"));
            arrList.add(Utility.getThumnailForPhysi(getActivity(),
                    R.drawable.zep1, "Introduction", 0, 1, 0, "Zepine"));
            arrList.add(Utility.getThumnailForPhysi(getActivity(),
                    R.drawable.zep2, "Side Effects", 0, 0, 1, "Zepine"));
            arrList.add(Utility.getThumnailForPhysi(getActivity(),
                    R.drawable.zep3, "Maintanance", 0, 1, 0, "Zepine"));
        } else {
            arrList.add(Utility.getThumnailForPhysi(getActivity(),
                    R.drawable.zep1, "Introduction", 0, 1, 0, "Zepine"));
            arrList.add(Utility.getThumnailForPhysi(getActivity(),
                    R.drawable.zep2, "Side Effects", 0, 0, 1, "Zepine"));
            arrList.add(Utility.getThumnailForPhysi(getActivity(),
                    R.drawable.zep3, "Maintanance", 0, 1, 0, "Zepine"));
            arrList.add(Utility.getThumnailForPhysi(getActivity(),
                    R.drawable.dew1, "Introduction", 0, 1, 1, "Jade dew pill"));
            arrList.add(Utility.getThumnailForPhysi(getActivity(),
                    R.drawable.dew2, "Efficacy", 0, 1, 1, "Jade dew pill"));
            arrList.add(Utility.getThumnailForPhysi(getActivity(),
                    R.drawable.dew3, "Description", 0, 1, 1, "Jade dew pill"));
            arrList.add(Utility.getThumnailForPhysi(getActivity(),
                    R.drawable.newcfix2, "Introduction", 0, 0, 0, "C-FIX"));
            arrList.add(Utility.getThumnailForPhysi(getActivity(),
                    R.drawable.newcfix1, "Types of CVD", 0, 1, 0, "C-FIX"));
            arrList.add(Utility.getThumnailForPhysi(getActivity(),
                    R.drawable.solsuna, "Introduction", 0, 1, 1, "Solsuna"));
            arrList.add(Utility.getThumnailForPhysi(getActivity(),
                    R.drawable.solsuna2, "Design", 1, 0, 0, "Solsuna"));
            arrList.add(Utility.getThumnailForPhysi(getActivity(),
                    R.drawable.solsuna3, "Dosage", 1, 0, 0, "Solsuna"));
            arrList.add(Utility
                    .getThumnailForPhysi(getActivity(), R.drawable.newcfix3,
                            "Risk Factor of CVD", 1, 0, 0, "C-FIX"));
            arrList.add(Utility.getThumnailForPhysi(getActivity(),
                    R.drawable.mezzodrop1, "Introduction", 0, 1, 1,
                    "Mezzo Drop"));
            arrList.add(Utility
                    .getThumnailForPhysi(getActivity(), R.drawable.mezzodrop2,
                            "Plus Points", 0, 1, 1, "Mezzo Drop"));
            arrList.add(Utility.getThumnailForPhysi(getActivity(),
                    R.drawable.mezzodrop, "Precautions", 1, 0, 0, "Mezzo Drop"));
        }
        ImageView left = (ImageView) v.findViewById(R.id.left);
        ImageView right = (ImageView) v.findViewById(R.id.right);

        final ImageView main_image = (ImageView) v
                .findViewById(R.id.main_image);
        main_image.setTag("1");

        TextView playall = (TextView) v.findViewById(R.id.playall);
        playall.setId(105);
        ImageView threedot = (ImageView) v.findViewById(R.id.threedot);
        playall.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Thread t = new Thread() {
                    @Override
                    public void run() {
                        int i = 0;
                        try {
                            for (i = 0; i < 6; i++) {

                                if (i == 0 || i == 3) {
                                    getActivity().runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            main_image
                                                    .setImageResource(R.drawable.newcfix3);
                                            main_image.setTag("2");
                                        }
                                    });
                                } else if (i == 1 || i == 4) {
                                    getActivity().runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            main_image
                                                    .setImageResource(R.drawable.mezom1);
                                            main_image.setTag("3");
                                        }
                                    });
                                } else if (i == 2 || i == 5) {
                                    getActivity().runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            main_image
                                                    .setImageResource(R.drawable.newcfix2);
                                            main_image.setTag("1");
                                        }
                                    });
                                }
                                sleep(800);
                            }

                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                };
                t.start();

            }
        });
        threedot.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Thread t = new Thread() {
                    @Override
                    public void run() {
                        int i = 0;
                        try {
                            for (i = 0; i < 6; i++) {

                                if (i == 0 || i == 3) {
                                    getActivity().runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            main_image
                                                    .setImageResource(R.drawable.newcfix3);
                                            main_image.setTag("2");
                                        }
                                    });
                                } else if (i == 1 || i == 4) {
                                    getActivity().runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            main_image
                                                    .setImageResource(R.drawable.mezom1);
                                            main_image.setTag("3");
                                        }
                                    });
                                } else if (i == 2 || i == 5) {
                                    getActivity().runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            main_image
                                                    .setImageResource(R.drawable.newcfix2);
                                            main_image.setTag("1");
                                        }
                                    });
                                }
                                sleep(800);
                            }

                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                };
                t.start();

            }
        });

        left.setId(103);
        right.setId(104);

        left.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                if (main_image.getTag().equals("1")) {
                    main_image.setImageResource(R.drawable.newcfix3);
                    main_image.setTag("2");
                } else if (main_image.getTag().equals("2")) {
                    main_image.setImageResource(R.drawable.mezom1);
                    main_image.setTag("3");
                } else if (main_image.getTag().equals("3")) {
                    main_image.setImageResource(R.drawable.newcfix2);
                    main_image.setTag("1");
                }
            }
        });
        right.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (main_image.getTag().equals("1")) {
                    main_image.setImageResource(R.drawable.newcfix3);
                    main_image.setTag("2");
                } else if (main_image.getTag().equals("2")) {
                    main_image.setImageResource(R.drawable.mezom1);
                    main_image.setTag("3");
                } else if (main_image.getTag().equals("3")) {
                    main_image.setImageResource(R.drawable.newcfix2);
                    main_image.setTag("1");
                }
            }
        });
        done.setId(101);
        cancel.setId(102);
        done.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                addScoll.setNumColumns(5);
                addScoll.setVerticalSpacing(1);
                addScoll.setHorizontalSpacing(1);
                play_layout.setMinimumHeight(667);
                RelativeLayout.LayoutParams param = new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
                param.addRule(RelativeLayout.BELOW, R.id.cardio);
                param.setMargins(25, 15, 160, 2);
                addScoll.setLayoutParams(param);
                addScoll.setAdapter(new GridAdapter(getActivity(), arrList, 0));
                pen.setText(getResources().getString(R.string.icon_pen));
                pen.setTag("1");
                rehearse_icon.setVisibility(View.VISIBLE);
                // previewtxt.setVisibility(View.VISIBLE);
                done.setVisibility(View.INVISIBLE);
                cancel.setVisibility(View.INVISIBLE);
                undo.setVisibility(View.INVISIBLE);
                // right1.setVisibility(View.VISIBLE);
                right2.setVisibility(View.GONE);
                main.setVisibility(View.INVISIBLE);
            }
        });

        cancel.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                addScoll.setNumColumns(5);
                addScoll.setVerticalSpacing(1);
                addScoll.setHorizontalSpacing(1);
                play_layout.setMinimumHeight(667);
                RelativeLayout.LayoutParams param = new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
                param.addRule(RelativeLayout.BELOW, R.id.cardio);
                param.setMargins(25, 15, 160, 2);
                addScoll.setLayoutParams(param);
                addScoll.setAdapter(new GridAdapter(getActivity(), arrList, 0));
                pen.setText(getResources().getString(R.string.icon_pen));
                pen.setTag("1");
                done.setVisibility(View.INVISIBLE);
                cancel.setVisibility(View.INVISIBLE);
                rehearse_icon.setVisibility(View.VISIBLE);
                // previewtxt.setVisibility(View.VISIBLE);
                undo.setVisibility(View.INVISIBLE);
                // right1.setVisibility(View.VISIBLE);
                right2.setVisibility(View.GONE);
                main.setVisibility(View.INVISIBLE);
            }
        });

        pen.setTypeface(font);
        pen.setId(100);
        pen.setTag("1");
        pen.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (pen.getTag().equals("1")) {
                    addScoll.setNumColumns(3);
                    addScoll.setVerticalSpacing(2);
                    addScoll.setHorizontalSpacing(6);
                    play_layout.setMinimumHeight(867);
                    RelativeLayout.LayoutParams param = new RelativeLayout.LayoutParams(
                            RelativeLayout.LayoutParams.WRAP_CONTENT,
                            RelativeLayout.LayoutParams.WRAP_CONTENT);
                    param.addRule(RelativeLayout.BELOW, R.id.cardio);
                    param.setMargins(25, 15, 20, 2);
                    addScoll.setLayoutParams(param);
                    addScoll.setAdapter(new GridAdapter(getActivity(), arrList,
                            0));
                    pen.setText(getResources().getString(
                            R.string.icon_three_dot));

                    done.setVisibility(View.VISIBLE);
                    cancel.setVisibility(View.VISIBLE);
                    right1.setVisibility(View.GONE);
                    right2.setVisibility(View.VISIBLE);
                    rehearse_icon.setVisibility(View.GONE);
                    // previewtxt.setVisibility(View.GONE);
                    RelativeLayout parent = (RelativeLayout) v.getParent();
                    GridView mGridView = (GridView) parent.getChildAt(5);

                    final int size = mGridView.getChildCount();
                    for (int i = 0; i < size; i++) {
                        ViewGroup gridChild = (ViewGroup) mGridView
                                .getChildAt(i);
                        if (gridChild.getChildAt(2) instanceof ImageView) {
                            gridChild.getChildAt(2).setVisibility(View.VISIBLE);
                        }
                    }
                    pen.setTag("2");
                } else {

                    final Dialog dialog = new Dialog(getActivity());
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    TextView tv = new TextView(getActivity());
                    tv.setText("Default Playlist");
                    tv.setTextSize(20);
                    tv.setTextColor(Color.WHITE);
                    tv.setBackgroundColor(Color.parseColor("#464646"));
                    tv.setPadding(10, 10, 10, 10);
                    tv.setOnClickListener(new OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            // TODO Auto-generated method stub
                            ArrayList<RelativeLayout> arrList = new ArrayList<RelativeLayout>();
                            arrList.add(Utility.getThumnailForPhysi(
                                    getActivity(), R.drawable.newace,
                                    "Introduction", 0, 1, 1, "Acenomorol"));
                            arrList.add(Utility.getThumnailForPhysi(
                                    getActivity(), R.drawable.newjade,
                                    "Types of CVD", 0, 1, 1, "Jade dew pill"));
                            arrList.add(Utility.getThumnailForPhysi(
                                    getActivity(), R.drawable.newcfix2,
                                    "Introduction", 0, 0, 0, "C-FIX"));
                            arrList.add(Utility
                                    .getThumnailForPhysi(getActivity(),
                                            R.drawable.mezom1,
                                            "Risk Factor of CVD", 1, 0, 0,
                                            "Mezzo Drop"));
                            arrList.add(Utility.getThumnailForPhysi(
                                    getActivity(), R.drawable.solsuna2,
                                    "Risk Factor of CVD", 0, 1, 1, "Solsuna"));
                            arrList.add(Utility.getThumnailForPhysi(
                                    getActivity(), R.drawable.ratiozep,
                                    "Types of CVD", 0, 1, 0, "Ratio Zep"));
                            arrList.add(Utility.getThumnailForPhysi(
                                    getActivity(), R.drawable.newmezzo,
                                    "Introduction", 0, 1, 1, "Mezzo"));
                            arrList.add(Utility.getThumnailForPhysi(
                                    getActivity(), R.drawable.newstillsep,
                                    "Types of CVD", 0, 1, 1, "Still Sep"));
                            arrList.add(Utility
                                    .getThumnailForPhysi(getActivity(),
                                            R.drawable.mezzodrop,
                                            "Risk Factor of CVD", 1, 0, 0,
                                            "Mezzo Drop"));
                            arrList.add(Utility.getThumnailForPhysi(
                                    getActivity(), R.drawable.zepine,
                                    "Risk Factor of CVD", 1, 0, 0, "Zepine"));
                            arrList.add(Utility.getThumnailForPhysi(
                                    getActivity(), R.drawable.ratio1,
                                    "Introduction", 0, 1, 0, "Ratio Zep"));
                            arrList.add(Utility.getThumnailForPhysi(
                                    getActivity(), R.drawable.dempi,
                                    "Introduction", 0, 1, 1, "Dempi"));
                            arrList.add(Utility.getThumnailForPhysi(
                                    getActivity(), R.drawable.newace,
                                    "Types of CVD", 1, 0, 0, "Acenomorol"));
                            arrList.add(Utility.getThumnailForPhysi(
                                    getActivity(), R.drawable.stelpep,
                                    "Types of CVD", 0, 0, 1, "Step Pep"));
                            arrList.add(Utility.getThumnailForPhysi(
                                    getActivity(), R.drawable.newstillsep,
                                    "Risk Factor of CVD", 0, 1, 0, "Still Sep"));

                            addScoll.setAdapter(new GridAdapter(getActivity(),
                                    arrList, 0));
                            dialog.dismiss();
                        }
                    });
                    dialog.setContentView(tv);
                    dialog.getWindow().setLayout(160, 50);
                    WindowManager.LayoutParams wmlp = dialog.getWindow()
                            .getAttributes();

                    int[] viewLocation = new int[2];
                    v.getLocationOnScreen(viewLocation);

                    wmlp.gravity = Gravity.TOP | Gravity.LEFT;
                    wmlp.x = viewLocation[0];
                    wmlp.y = viewLocation[1];
                    dialog.getWindow().clearFlags(
                            WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                    dialog.getWindow().setBackgroundDrawable(
                            new ColorDrawable(
                                    android.graphics.Color.TRANSPARENT));
                    dialog.show();

                }
            }
        });

        for (int i = 0; i < 5; i += 2) {
            LinearLayout child = new LinearLayout(getActivity());
            child.setOrientation(LinearLayout.HORIZONTAL);
            RelativeLayout rl1 = null;
            RelativeLayout rl2 = null;
            RelativeLayout rl3 = null;
            RelativeLayout rl4 = null;

            if (i == 0) {
                rl1 = Utility.getThumnailForPhysi(getActivity(),
                        R.drawable.newcfix2, "Introduction", 0, 0, 0, "C-FIX");
                rl2 = Utility.getThumnailForPhysi(getActivity(),
                        R.drawable.newmezzo, "Types of CVD", 0, 1, 1,
                        "Mezzo Drop");
                rl3 = Utility.getThumnailForPhysi(getActivity(),
                        R.drawable.newjade, "Introduction", 0, 0, 0,
                        "Jade Dew Pill");
                rl4 = Utility.getThumnailForPhysi(getActivity(),
                        R.drawable.newace, "Types of CVD", 0, 1, 1,
                        "Acenomorol");
            } else if (i == 2) {
                rl1 = Utility.getThumnailForPhysi(getActivity(),
                        R.drawable.solsuna2, "Risk Factor of CVD", 0, 1, 1,
                        "Solsuna");
                rl2 = Utility.getThumnailForPhysi(getActivity(),
                        R.drawable.ratiozep, "Types of CVD", 0, 1, 0,
                        "Ratio Zep");
                rl3 = Utility.getThumnailForPhysi(getActivity(),
                        R.drawable.newmezzo, "Introduction", 0, 1, 1, "Mezzo");
                rl4 = Utility.getThumnailForPhysi(getActivity(),
                        R.drawable.newstillsep, "Types of CVD", 0, 1, 1,
                        "Still Sep");
            } else {
                rl1 = Utility.getThumnailForPhysi(getActivity(),
                        R.drawable.dempi, "Introduction", 0, 1, 1, "Dempi");
                rl2 = Utility.getThumnailForPhysi(getActivity(),
                        R.drawable.newace, "Types of CVD", 1, 0, 0,
                        "Acenomorol");
                rl3 = Utility
                        .getThumnailForPhysi(getActivity(), R.drawable.stelpep,
                                "Types of CVD", 0, 0, 1, "Step Pep");
                rl4 = Utility.getThumnailForPhysi(getActivity(),
                        R.drawable.newjade, "Risk Factor of CVD", 0, 1, 0,
                        "Jade dew pill");
            }
            rl1.setPadding(0, 0, 2, 2);
            rl2.setPadding(0, 0, 2, 2);
            rl3.setPadding(0, 0, 2, 2);
            rl4.setPadding(0, 0, 2, 2);

            rl1.setOnLongClickListener(new mylongclick());
            rl1.setOnDragListener(new MyDragListener(getActivity(), arrList, 0));
            rl2.setOnLongClickListener(new mylongclick());
            rl2.setOnDragListener(new MyDragListener(getActivity(), arrList, 0));
            rl3.setOnLongClickListener(new mylongclick());
            rl3.setOnDragListener(new MyDragListener(getActivity(), arrList, 0));
            rl4.setOnLongClickListener(new mylongclick());
            rl4.setOnDragListener(new MyDragListener(getActivity(), arrList, 0));
            ImageView play1 = (ImageView) rl1.getChildAt(1);
            ImageView delete1 = (ImageView) rl1.getChildAt(2);
            ImageView play2 = (ImageView) rl2.getChildAt(1);
            ImageView delete2 = (ImageView) rl2.getChildAt(2);
            ImageView play3 = (ImageView) rl3.getChildAt(1);
            ImageView delete3 = (ImageView) rl3.getChildAt(2);
            ImageView play4 = (ImageView) rl4.getChildAt(1);
            ImageView delete4 = (ImageView) rl4.getChildAt(2);
            delete1.setVisibility(View.INVISIBLE);
            delete2.setVisibility(View.INVISIBLE);
            delete3.setVisibility(View.INVISIBLE);
            delete4.setVisibility(View.INVISIBLE);
            play1.setOnClickListener(playListen);
            play2.setOnClickListener(playListen);
            play3.setOnClickListener(playListen);
            play4.setOnClickListener(playListen);
            child.addView(rl1);
            child.addView(rl2);
            child.addView(rl3);
            child.addView(rl4);

            main.addView(child);
        }

        List<String> list1 = new ArrayList<String>();
        list1.add("Specialty");
        list1.add("Brands");
        list1.add("Therapy");
        list1.add("Services");
        list1.add("Corporate");

        List<String> list2 = new ArrayList<String>();
        list2.add("C-fix");
        list2.add("Fade Pill");
        list2.add("Mezzo Drop");
        list2.add("Still Sep");
        list2.add("Acenomorol");
        list2.add("Solsuna");

        MultiSpinner multiSpinner = (MultiSpinner) v
                .findViewById(R.id.spinner1);
        multiSpinner.setItems(list1, "Category", new MultiSpinnerListener() {

            @Override
            public void onItemsSelected(boolean[] selected) {
                // TODO Auto-generated method stub
                flag1 = true;
                if (flag1 == true && flag2 == true)
                    main.setVisibility(View.VISIBLE);
            }
        });
        MultiSpinner multiSpinner2 = (MultiSpinner) v
                .findViewById(R.id.spinner2);
        multiSpinner2.setItems(list2, "Brand", new MultiSpinnerListener() {

            @Override
            public void onItemsSelected(boolean[] selected) {
                // TODO Auto-generated method stub
                flag2 = true;
                if (flag1 == true && flag2 == true)
                    main.setVisibility(View.VISIBLE);
            }
        });

        addScoll.setAdapter(new GridAdapter(getActivity(), arrList, 0));
        return v;

    }

    public class MyAdapter extends BaseAdapter {
        Context context;
        String history;
        Typeface font;
        ViewHolderItem viewHolder = null;

        int iconmode;
        String[] activedata2 = {"Need more samples", "Need more samples",
                "Need more samples",
                "Need more clinical trails over competitor ones",
                "Need more clinical trails over competitor ones"};

        String[] activedata3 = {"",
                "Assigned to : Reasearch | Research Manager , C-Fix",
                "Assigned to : Finance | Finance Manager , C-Fix",
                "Assigned to : Reasearch | Research Manager , C-Fix",
                "Assigned to : Reasearch | Research Manager , C-Fix"};

        String[] timeactive = {"23 July 15", "25 July 15", "26 July 15",
                "28 July 15", "29 July 15"};
        ArrayList<String> mArrayList = new ArrayList<String>();

        public MyAdapter(ArrayList<String> mArrayList, Context context,
                         String history, int iconmode) {
            this.mArrayList = mArrayList;
            this.context = context;
            this.history = history;
            this.iconmode = iconmode;
            font = Typeface.createFromAsset(context.getAssets(),
                    "fontawesome-webfont.ttf");
        }

        public int getCount() {
            return mArrayList.size();
        }

        public Object getItem(int position) {
            return mArrayList.get(position);
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(final int position, View convertView,
                            ViewGroup parent) {

            viewHolder = new ViewHolderItem();

            if (convertView == null) {

                LayoutInflater inflater = (LayoutInflater) context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.section_item, null);

                viewHolder.childiewoflist = (LinearLayout) convertView
                        .findViewById(R.id.childiewoflist);

                viewHolder.chkbox = (TextView) convertView
                        .findViewById(R.id.chkbox);
                viewHolder.chkbox.setTypeface(font);

                viewHolder.threedot = (TextView) convertView
                        .findViewById(R.id.drmenu);
                viewHolder.time = (TextView) convertView
                        .findViewById(R.id.time);

                viewHolder.attach = (TextView) convertView
                        .findViewById(R.id.attach);
                viewHolder.attach.setTypeface(font);

                viewHolder.comment = (TextView) convertView
                        .findViewById(R.id.comment);
                viewHolder.comment.setTypeface(font);

                viewHolder.addfrnd = (TextView) convertView
                        .findViewById(R.id.addfrnd);
                viewHolder.addfrnd.setTypeface(font);

                viewHolder.indicator = (TextView) convertView
                        .findViewById(R.id.indicatyor);
                viewHolder.indicator.setTypeface(font);

                final LinearLayout childiewoflist = (LinearLayout) convertView
                        .findViewById(R.id.childiewoflist);

                final TextView chkbox = (TextView) convertView
                        .findViewById(R.id.chkbox);

                final TextView indicatyor = (TextView) convertView
                        .findViewById(R.id.indicatyor);
                if (iconint[position] == 0) {
                    viewHolder.attach.setVisibility(View.INVISIBLE);
                    viewHolder.comment.setVisibility(View.INVISIBLE);
                    viewHolder.addfrnd.setVisibility(View.INVISIBLE);

                } else if (iconint[position] == 2) {
                    // viewHolder.addfrnd.setVisibility(View.GONE);
                } else if (iconint[position] == 1) {
                    viewHolder.comment.setVisibility(View.INVISIBLE);
                    // viewHolder.addfrnd.setVisibility(View.GONE);

                }
                if (iconmode == 99) {
                    viewHolder.attach.setVisibility(View.INVISIBLE);
                    viewHolder.comment.setVisibility(View.INVISIBLE);
                    viewHolder.addfrnd.setVisibility(View.INVISIBLE);
                }

                viewHolder.chkbox.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        if (((TextView) v).getCurrentTextColor() == Color
                                .parseColor("#333333")) {
                            ((TextView) v).setTextColor(Color
                                    .parseColor("#9e9e9e"));

                            globaltextchk = ((TextView) v);

                        } else {
                            ((TextView) v).setTextColor(Color
                                    .parseColor("#333333"));
                            // Dialog 1

                            globaltextchk = ((TextView) v);
                            final Dialog d = new Dialog(context);

                            d.requestWindowFeature(Window.FEATURE_NO_TITLE);
                            d.getWindow().setBackgroundDrawable(
                                    new ColorDrawable(
                                            android.R.color.transparent));
                            d.setContentView(R.layout.traingel);

                            TextView chk = (TextView) d.findViewById(R.id.tri);
                            chk.setTypeface(font);

                            Window window = d.getWindow();

                            WindowManager.LayoutParams wmlp = d.getWindow()
                                    .getAttributes();

                            int[] viewLocation = new int[2];
                            v.getLocationOnScreen(viewLocation);

                            wmlp.gravity = Gravity.TOP | Gravity.LEFT;
                            wmlp.x = viewLocation[0] + 13;
                            wmlp.y = viewLocation[1] - 32;
                            window.setBackgroundDrawable(new ColorDrawable(
                                    Color.TRANSPARENT));
                            // Dialog two
                            final Dialog d1 = new Dialog(context);

                            d1.requestWindowFeature(Window.FEATURE_NO_TITLE);
                            d1.getWindow().setBackgroundDrawable(
                                    new ColorDrawable(
                                            android.R.color.transparent));
                            d1.setContentView(R.layout.actionpoint_colouser_ap);

                            TextView chk1 = (TextView) d1
                                    .findViewById(R.id.chkboxd);
                            chk1.setTypeface(font);

                            Window window1 = d1.getWindow();

                            WindowManager.LayoutParams wmlp1 = d1.getWindow()
                                    .getAttributes();

                            int[] viewLocation1 = new int[2];
                            v.getLocationOnScreen(viewLocation1);

                            wmlp1.gravity = Gravity.TOP | Gravity.LEFT;
                            wmlp1.x = viewLocation1[0] + 26;
                            wmlp1.y = viewLocation1[1] - 64;
                            window1.setBackgroundDrawable(new ColorDrawable(
                                    Color.TRANSPARENT));
                            d1.getWindow().setLayout(350, 300);

                            d.show();
                            d1.show();

                            TextView doneap = (TextView) d1
                                    .findViewById(R.id.doneap);
                            doneap.setOnClickListener(new OnClickListener() {

                                @Override
                                public void onClick(View v) {

                                    chkbox.setVisibility(View.GONE);
                                    indicatyor.setVisibility(View.GONE);
                                    childiewoflist.setVisibility(View.GONE);
                                    d1.dismiss(); // TODO Auto-generated
                                    // method stub

                                    d1.dismiss();
                                    d1.dismiss();
                                }
                            });

                            d1.setOnDismissListener(new OnDismissListener() {

                                @Override
                                public void onDismiss(DialogInterface dialog) {
                                    globaltextchk.setTextColor(Color
                                            .parseColor("#9e9e9e"));
                                    d.dismiss();

                                }
                            });
                        }

                    }
                });
                if (iconmode != 99) {
                    viewHolder.childiewoflist
                            .setOnClickListener(new OnClickListener() {

                                @Override
                                public void onClick(View v1) {

                                    vForAP.setBackgroundColor(Color
                                            .parseColor("#e0e0e0"));
                                    v1.setBackgroundColor(Color
                                            .parseColor("#9e9e9e"));

                                    vForAP = v1;

                                    TextView tv = (TextView) ((RelativeLayout) ((LinearLayout) v1)
                                            .getParent()).getChildAt(2);

                                    vForindciator
                                            .setTextColor(Color.TRANSPARENT);
                                    tv.setTextColor(Color.parseColor("#9e9e9e"));

                                    vForindciator = tv;

                                }
                            });
                }
                viewHolder.textViewItem = (TextView) convertView
                        .findViewById(R.id.item);
                viewHolder.textdata2 = (TextView) convertView
                        .findViewById(R.id.textViewItemPrice);

                viewHolder.textdata3 = (TextView) convertView
                        .findViewById(R.id.childtextview3);

                convertView.setTag(viewHolder);

            } else {
                viewHolder = (ViewHolderItem) convertView.getTag();
            }

            if (position == 2) {
                if (iconmode != 99) {
                    viewHolder.childiewoflist.setBackgroundColor(Color
                            .parseColor("#9e9e9e"));
                    viewHolder.indicator.setTextColor(Color
                            .parseColor("#9e9e9e"));

                    vForAP = viewHolder.childiewoflist;
                    vForindciator = viewHolder.indicator;
                }

            }

            if (history.equals("1")) {
                viewHolder.chkbox.setVisibility(View.GONE);
            }

            viewHolder.textViewItem.setText(mArrayList.get(position));
            viewHolder.textdata2.setText(activedata2[position]);
            viewHolder.textdata3.setText(activedata3[position]);
            viewHolder.time.setText(timeactive[position]);

            final LinearLayout childiewoflist = (LinearLayout) convertView
                    .findViewById(R.id.childiewoflist);

            final TextView chkbox = (TextView) convertView
                    .findViewById(R.id.chkbox);

            final TextView indicatyor = (TextView) convertView
                    .findViewById(R.id.indicatyor);

            viewHolder.threedot.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {

                    if (!history.equals("1")) {

                        final Dialog d = new Dialog(context);

                        d.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        d.getWindow().setBackgroundDrawable(
                                new ColorDrawable(android.R.color.transparent));
                        d.setContentView(R.layout.deletedialog);

                        TextView bin = (TextView) d.findViewById(R.id.bin);
                        bin.setTypeface(font);

                        Window window = d.getWindow();

                        WindowManager.LayoutParams wmlp = d.getWindow()
                                .getAttributes();

                        int[] viewLocation = new int[2];
                        v.getLocationOnScreen(viewLocation);

                        wmlp.gravity = Gravity.TOP | Gravity.LEFT;
                        wmlp.x = viewLocation[0] + 13;
                        wmlp.y = viewLocation[1] + 4;
                        window.setBackgroundDrawable(new ColorDrawable(
                                Color.TRANSPARENT));
                        d.show();

                        bin.setOnClickListener(new OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                d.dismiss();
                                final Dialog d1 = new Dialog(context);
                                d1.requestWindowFeature(Window.FEATURE_NO_TITLE);
                                d1.getWindow().setBackgroundDrawable(
                                        new ColorDrawable(
                                                android.R.color.transparent));
                                d1.setContentView(R.layout.actionpoint_delete_ap);

                                TextView bin = (TextView) d1
                                        .findViewById(R.id.deleted);
                                bin.setTypeface(font);

                                TextView doneap = (TextView) d1
                                        .findViewById(R.id.doneap);
                                doneap.setOnClickListener(new OnClickListener() {

                                    @Override
                                    public void onClick(View v) {
                                        chkbox.setVisibility(View.GONE);
                                        indicatyor.setVisibility(View.GONE);
                                        childiewoflist.setVisibility(View.GONE);
                                        d1.dismiss(); // TODO Auto-generated
                                        // method stub

                                    }
                                });

                                Window window = d1.getWindow();

                                WindowManager.LayoutParams wmlp = d1
                                        .getWindow().getAttributes();

                                int[] viewLocation = new int[2];
                                v.getLocationOnScreen(viewLocation);

                                // wmlp.gravity = Gravity.TOP | Gravity.LEFT;
                                // wmlp.x = viewLocation[0];
                                // wmlp.y = viewLocation[1];
                                // window.setBackgroundDrawable(new
                                // ColorDrawable(
                                // Color.TRANSPARENT));
                                d1.getWindow().setLayout(350, 300);

                                d1.show();

                            }
                        });

                    }
                }
            });
            viewHolder.textViewItem.setText(mArrayList.get(position));
            viewHolder.textdata2.setText(activedata2[position]);
            viewHolder.textdata3.setText(activedata3[position]);
            viewHolder.time.setText(timeactive[position]);

            return convertView;
        }
    }

    public class ViewHolderItem {

        TextView textViewItem;
        TextView textdata2;
        TextView textdata3;
        TextView attach;
        TextView addfrnd;
        TextView comment;
        TextView chkbox;
        TextView threedot;

        TextView indicator;

        LinearLayout childiewoflist;

        TextView time;

    }

    public void ScrollTo(final View view) {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int x = view.getLeft();
                int y = view.getTop();
                fullscroll.scrollTo(x, y);
            }
        }, 600);

    }

    public void ScrollToEdit(final View view) {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int x = view.getLeft();
                int y = view.getTop();
                fullscrollEdit.scrollTo(x, y);
            }
        }, 600);

    }

    void addbrandsForHistory(int len) {
        for (int i = 0; i < len; i++) {
            LayoutInflater mInflater = (LayoutInflater) getActivity()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            LinearLayout view = (LinearLayout) mInflater.inflate(
                    R.layout.ratingbar1, null);
            TextView parameter = (TextView) view.findViewById(R.id.parameter);
            parameter.setText(parameters[i]);
            final RatingBar r1 = (RatingBar) view.findViewById(R.id.rt1);
            r1.setVisibility(View.VISIBLE);
            r1.setEnabled(false);

            final RatingBar r2 = (RatingBar) view.findViewById(R.id.rt2);
            r2.setVisibility(View.VISIBLE);
            r2.setEnabled(false);

            final RatingBar r3 = (RatingBar) view.findViewById(R.id.rt3);
            r3.setVisibility(View.VISIBLE);
            r3.setEnabled(false);

            final RatingBar r4 = (RatingBar) view.findViewById(R.id.rt4);
            r4.setVisibility(View.VISIBLE);
            r4.setEnabled(false);
            if (i == 0) {
                r1.setRating(1);
                r2.setRating(1);
                r3.setRating(1);
                r4.setRating(1);
            } else if (i == 1) {
                r1.setRating(2);
                r2.setRating(2);
                r3.setRating(2);
                r4.setRating(2);
            } else if (i == 2) {
                r1.setRating(3);
                r2.setRating(3);
                r3.setRating(3);
                r4.setRating(3);
            }

            mainlayout.addView(view);
        }
    }

    public View actionPointView(final Context context, final String history) {
        final Typeface font = Typeface.createFromAsset(context.getAssets(),
                "fontawesome-webfont.ttf");
        String headename[] = {"Active", "Overdues"};
        String count[] = {"05", "01"};

        String[] maindata1foractive = {"Samples | C-Fix",
                "Samples | C-Fix ,Mezzo drop,Solsuna +2",
                "Samples | Mezzo drop,Solsuna +2", "C-Fix", "Mezzo drops"};
        String[] maindata1foraoverdue = {"Solsuna", "Mezo Drop"};
        ArrayList<String> mArrayListg = new ArrayList<String>();
        ArrayList<String> mArrayListgover = new ArrayList<String>();

        TextView editpencil;

        final LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v3 = inflater.inflate(R.layout.secactivity_main, null);
        vForAP = new View(context);
        vForindciator = new TextView(context);
        // /CHANGES FOR CALNDER
        RelativeLayout rel2 = (RelativeLayout) v3.findViewById(R.id.rel2);

        mListView = (ListView) v3.findViewById(R.id.listview);

        TextView attach = (TextView) v3.findViewById(R.id.attach);
        attach.setTypeface(font);

        editpencil = (TextView) v3.findViewById(R.id.editpencil);
        editpencil.setTypeface(font);
        TextView addfrnd18 = (TextView) v3.findViewById(R.id.addfrnd18);
        addfrnd18.setTypeface(font);

        TextView addfrnd = (TextView) v3.findViewById(R.id.addfrnd);
        addfrnd.setTypeface(font);

        if (history.equals("92")) {
            rel2.setVisibility(View.GONE);
            iconmode_gl = 99;

        } else {
            iconmode_gl = 77;
        }

        RelativeLayout fwdmsg = (RelativeLayout) v3.findViewById(R.id.fwdmsg);

        fwdmsg.setOnLongClickListener(new OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                // Dialog 1
                final Dialog d = new Dialog(context);

                d.requestWindowFeature(Window.FEATURE_NO_TITLE);
                d.getWindow().setBackgroundDrawable(
                        new ColorDrawable(android.R.color.transparent));
                d.setContentView(R.layout.ap_fedmsg);

                TextView chk = (TextView) d.findViewById(R.id.close);
                chk.setTypeface(font);

                TextView attach = (TextView) d.findViewById(R.id.attach);
                attach.setTypeface(font);

                TextView addfrnd = (TextView) d.findViewById(R.id.addfrnd);
                addfrnd.setTypeface(font);

                TextView doneap = (TextView) d.findViewById(R.id.doneap);

                doneap.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        d.dismiss();
                    }
                });

                chk.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        d.dismiss();
                    }
                });

                doneap.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        d.dismiss();
                    }
                });

                Window window = d.getWindow();

                WindowManager.LayoutParams wmlp = d.getWindow().getAttributes();

                int[] viewLocation = new int[2];
                v.getLocationOnScreen(viewLocation);
                d.getWindow().setLayout(500, 600);

                // wmlp.grav92ity = Gravity.TOP | Gravity.LEFT;
                // wmlp.x = viewLocation[0];
                // wmlp.y = viewLocation[1];
                window.setBackgroundDrawable(new ColorDrawable(
                        Color.TRANSPARENT));
                if (!history.equals("1")) {
                    d.show();
                }

                return true;
            }
        });
        plus = (TextView) v3.findViewById(R.id.plus);
        plus.setTypeface(font);

        historyIcon = (ImageView) v3.findViewById(R.id.history);
        if (history.equals("1")) {
            plus.setVisibility(View.INVISIBLE);
            historyIcon.setVisibility(View.INVISIBLE);
        }
        historyIcon.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                final Dialog dialog_box = new Dialog(context);
                PlaylistFragment fragment = new PlaylistFragment();
                View view = fragment.actionPointView(context, "1");
                LinearLayout parent = new LinearLayout(context);
                parent.setOrientation(LinearLayout.VERTICAL);
                dialog_box.requestWindowFeature(Window.FEATURE_NO_TITLE);
                LinearLayout.LayoutParams param2 = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
                param2.topMargin = 10;
                param2.rightMargin = 10;
                param2.leftMargin = 10;
                param2.bottomMargin = -2;

                TextView cross = new TextView(context);
                cross.setText(context.getResources().getString(
                        R.string.icon_cross));
                cross.setTextSize(28);
                cross.setGravity(Gravity.RIGHT);
                cross.setLayoutParams(param2);
                cross.setTypeface(font);
                cross.setTextColor(Color.BLACK);

                parent.addView(cross);
                parent.addView(view);

                cross.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        dialog_box.dismiss();
                    }
                });
                dialog_box.setContentView(parent);
                dialog_box.getWindow().setBackgroundDrawableResource(
                        R.drawable.bg_roundedwhite);

                Display display = ((WindowManager) context
                        .getSystemService(Context.WINDOW_SERVICE))
                        .getDefaultDisplay();
                // dialog.setCancelable(false);
                int width = display.getWidth();
                int height = display.getHeight();
                dialog_box.getWindow().setLayout((29 * width) / 30,
                        (height * 29) / 30);
                dialog_box.show();
            }
        });

        plus.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                final Dialog d = new Dialog(context);
                d.requestWindowFeature(Window.FEATURE_NO_TITLE);
                d.getWindow().setBackgroundDrawable(
                        new ColorDrawable(android.R.color.transparent));
                d.setContentView(R.layout.add_action_points);

                AutoCompleteTextView mySpinner = (AutoCompleteTextView) d
                        .findViewById(R.id.typeofphydr);
                mySpinner.setAdapter(new MyAdapterforspinner(context,
                        R.layout.exrow_second, Drname));

                mySpinner.setThreshold(1);

                mySpinner.setVisibility(View.GONE);

                TextView selectnsrch = (TextView) d
                        .findViewById(R.id.selectnsrch);
                selectnsrch.setVisibility(View.GONE);

                TableRow row1 = (TableRow) d.findViewById(R.id.tablerow99);
                row1.setVisibility(View.GONE);
                TableRow row2 = (TableRow) d.findViewById(R.id.tablerow999);
                row2.setVisibility(View.GONE);

                TextView close = (TextView) d.findViewById(R.id.close);
                EditText ButtonSet = (EditText) d.findViewById(R.id.ButtonSet);
                ButtonSet.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        d.dismiss();
                    }
                });
                close.setTypeface(font);
                close.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        d.dismiss();
                    }
                });
                EditText description = (EditText) d
                        .findViewById(R.id.EdittextDescription);
                Utility.hideKeyboard(description);
                edittextDuedate = (EditText) d
                        .findViewById(R.id.edittextDuedate);
                edittextDuedate.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View arg0) {
                        // TODO Auto-generated method stub

                        new DatePickerDialog(context, date, myCalendar
                                .get(Calendar.YEAR), myCalendar
                                .get(Calendar.MONTH), myCalendar
                                .get(Calendar.DAY_OF_MONTH)).show();

                    }
                });

                final EditText edittime = (EditText) d
                        .findViewById(R.id.edittime);
                edittime.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub

                        Calendar mcurrentTime = Calendar.getInstance();
                        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                        int minute = mcurrentTime.get(Calendar.MINUTE);
                        TimePickerDialog mTimePicker;
                        mTimePicker = new TimePickerDialog(context,
                                new TimePickerDialog.OnTimeSetListener() {
                                    @Override
                                    public void onTimeSet(
                                            TimePicker timePicker,
                                            int selectedHour, int selectedMinute) {
                                        edittime.setText(selectedHour + ":"
                                                + selectedMinute);
                                    }
                                }, hour, minute, true);// Yes 24 hour time
                        mTimePicker.setTitle("Select Time");
                        mTimePicker.show();

                    }
                });

                d.show();
            }
        });

        SectionedAdapter adapter = new SectionedAdapter() {
            @Override
            protected View getHeaderView(String caption, String count,
                                         int index, View convertView, ViewGroup parent) {

                convertView = inflater.inflate(R.layout.section_header, null);
                TextView header = (TextView) convertView
                        .findViewById(R.id.header);

                TextView redo = (TextView) convertView
                        .findViewById(R.id.textViewtime);
                redo.setText(count);
                header.setText(caption);
                return convertView;
            }
        };
        if (history.equals("1")) {
            headename[0] = "History";
        }
        for (int j = 0; j < maindata1foractive.length; j++) {
            mArrayListg.add(maindata1foractive[j]);
        }
        for (int j = 0; j < maindata1foraoverdue.length; j++) {
            mArrayListgover.add(maindata1foraoverdue[j]);
        }

        MyAdapter myAdapter = new MyAdapter(mArrayListg, context, history,
                iconmode_gl);
        adapter.addSection(headename[0], count[0], myAdapter);

        if (!history.equals("1")) {
            MyAdapter myAdapter2 = new MyAdapter(mArrayListgover, context,
                    history, iconmode_gl);
            adapter.addSection(headename[1], count[1], myAdapter2);
        }
        if (history.equals("1")) {
            editpencil.setVisibility(View.GONE);
        }
        mListView.setAdapter(adapter);

        editpencil.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                // TODO Auto-generated method stub
                final Dialog d = new Dialog(context);
                d.requestWindowFeature(Window.FEATURE_NO_TITLE);
                d.getWindow().setBackgroundDrawable(
                        new ColorDrawable(android.R.color.transparent));
                d.setContentView(R.layout.add_action_points);

                TextView close = (TextView) d.findViewById(R.id.close);
                EditText ButtonSet = (EditText) d.findViewById(R.id.ButtonSet);

                TextView title = (TextView) d
                        .findViewById(R.id.TextViewActionPoint);
                title.setText("EDIT ACTION POINT");

                TableRow row1 = (TableRow) d.findViewById(R.id.tablerow99);
                row1.setVisibility(View.GONE);
                TableRow row2 = (TableRow) d.findViewById(R.id.tablerow999);
                row2.setVisibility(View.GONE);

                Spinner typSpinner = (Spinner) d.findViewById(R.id.typeofphy);
                typSpinner.setSelection(1);
                typSpinner.setEnabled(false);

                AutoCompleteTextView mySpinner = (AutoCompleteTextView) d
                        .findViewById(R.id.typeofphydr);

                mySpinner.setAdapter(new MyAdapterforspinner(context,
                        R.layout.exrow_second, Drname));

                mySpinner.setText("Dr Jonh Cussak");
                mySpinner.setEnabled(false);

                mySpinner.setThreshold(1);

                ButtonSet.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        d.dismiss();
                    }
                });
                close.setTypeface(font);
                close.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        d.dismiss();
                    }
                });
                EditText description = (EditText) d
                        .findViewById(R.id.EdittextDescription);
                Utility.hideKeyboard(description);
                edittextDuedate = (EditText) d
                        .findViewById(R.id.edittextDuedate);
                edittextDuedate.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View arg0) {
                        // TODO Auto-generated method stub

                        new DatePickerDialog(context, date, myCalendar
                                .get(Calendar.YEAR), myCalendar
                                .get(Calendar.MONTH), myCalendar
                                .get(Calendar.DAY_OF_MONTH)).show();

                    }
                });

                final EditText edittime = (EditText) d
                        .findViewById(R.id.edittime);
                edittime.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub

                        Calendar mcurrentTime = Calendar.getInstance();
                        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                        int minute = mcurrentTime.get(Calendar.MINUTE);
                        TimePickerDialog mTimePicker;
                        mTimePicker = new TimePickerDialog(context,
                                new TimePickerDialog.OnTimeSetListener() {
                                    @Override
                                    public void onTimeSet(
                                            TimePicker timePicker,
                                            int selectedHour, int selectedMinute) {
                                        edittime.setText(selectedHour + ":"
                                                + selectedMinute);
                                    }
                                }, hour, minute, true);// Yes 24 hour time
                        mTimePicker.setTitle("Select Time");

                        mTimePicker.show();

                    }
                });

                d.show();
            }
        });
        return v3;
    }

    final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }

        private void updateLabel() {
            // TODO Auto-generated method stub
            String myFormat = "dd/MM/yy";
            SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

            edittextDuedate.setText(sdf.format(myCalendar.getTime()));
        }

    };

    public class MyAdapterforspinner extends ArrayAdapter<String> {

        Context context;

        public MyAdapterforspinner(Context ctx, int txtViewResourceId,
                                   String[] objects) {
            super(ctx, txtViewResourceId, objects);
            this.context = ctx;
        }

        @Override
        public View getDropDownView(int position, View cnvtView, ViewGroup prnt) {
            return getCustomView(position, cnvtView, prnt);
        }

        @Override
        public View getView(int pos, View cnvtView, ViewGroup prnt) {
            return getCustomView(pos, cnvtView, prnt);
        }

        public View getCustomView(int position, View convertView,
                                  ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.exrow_third, null);

            TextView mItemName = (TextView) convertView
                    .findViewById(R.id.eventsListEventRowText);

            TextView mItemTime = (TextView) convertView.findViewById(R.id.time);

            ImageView drImageView = (ImageView) convertView
                    .findViewById(R.id.dr_image);
            TextView mItemPrice = (TextView) convertView
                    .findViewById(R.id.textViewItemPrice);

            TextView childtextview3 = (TextView) convertView
                    .findViewById(R.id.childtextview3);

            TextView menufordr = (TextView) convertView
                    .findViewById(R.id.menufordr);
            menufordr.setVisibility(View.GONE);

            drImageView.setImageResource(imageDoctor[position]);
            mItemTime.setText(strTime[position]);
            mItemName.setText(Drname[position]);
            mItemPrice.setText(Specialty[position]);
            childtextview3.setText(Class[position]);

            return convertView;
        }
    }

    private void findViews(View v) {
        btnSeven = (Button) v.findViewById(R.id.btnSeven);
        btnEight = (Button) v.findViewById(R.id.btnEight);
        btnNine = (Button) v.findViewById(R.id.btnNine);
        btnFour = (Button) v.findViewById(R.id.btnFour);
        btnFive = (Button) v.findViewById(R.id.btnFive);
        btnSix = (Button) v.findViewById(R.id.btnSix);
        btnOne = (Button) v.findViewById(R.id.btnOne);
        btnTwo = (Button) v.findViewById(R.id.btnTwo);
        btnThree = (Button) v.findViewById(R.id.btnThree);

        zero = (Button) v.findViewById(R.id.zero);
        ente = (Button) v.findViewById(R.id.ente);

        btnSeven.setOnClickListener(keyListener);
        btnEight.setOnClickListener(keyListener);
        btnNine.setOnClickListener(keyListener);
        btnFour.setOnClickListener(keyListener);
        btnFive.setOnClickListener(keyListener);
        btnSix.setOnClickListener(keyListener);
        btnOne.setOnClickListener(keyListener);
        btnTwo.setOnClickListener(keyListener);
        btnThree.setOnClickListener(keyListener);

        zero.setOnClickListener(keyListener);
        ente.setOnClickListener(keyListener);
    }

    OnClickListener keyListener = new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            if (v == btnSeven || v == btnEight || v == btnNine || v == btnFour
                    || v == btnSix || v == zero || v == btnFive || v == btnOne
                    || v == btnTwo || v == btnThree) {
                if (focusedView != null) {
                    Button edit = (Button) v;
                    String str = edit.getText().toString();
                    if (!focusedView.getText().toString().equals(""))
                        str = focusedView.getText().toString() + str;
                    focusedView.setText(str);
                }
            } else if (v == ente) {
                if (focusedView != null) {
                    if (!focusedView.getText().toString().equals("")) {
                        focusedView.setText(focusedView
                                .getText()
                                .toString()
                                .substring(
                                        0,
                                        focusedView.getText().toString()
                                                .length() - 1));
                    }
                }
            }
        }
    };

    public void displayFocussedBrands(int id) {
        String fd = "";
        ReadWriteData rw = new ReadWriteData(getActivity(), "MPOWERDB", null, 1);
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

    private Vector<Book> getIndexedBooks(Vector<Book> booksVector) {

        // Retrieve it from DB in shorting order

        Vector<Book> v = new Vector<Book>();
        // Add default item

        String idx1 = null;
        String idx2 = null;
        for (int i = 0; i < booksVector.size(); i++) {
            Book temp = booksVector.elementAt(i);
            // Insert the alphabets
            idx1 = (temp.getTitle().substring(0, 1)).toLowerCase();
            if (!idx1.equalsIgnoreCase(idx2)) {
                v.add(new Book(idx1.toUpperCase(), "", "", "", ""));
                idx2 = idx1;
                dealList.add(i);
            }
            v.add(temp);
        }

        return v;
    }

    OnClickListener rehearse = new OnClickListener() {
        @SuppressLint("JavascriptInterface")
        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub

            final Dialog dialog = new Dialog(getActivity());
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            Display display = ((WindowManager) getActivity().getSystemService(
                    Context.WINDOW_SERVICE)).getDefaultDisplay();
            int width = display.getWidth();
            int height = display.getHeight();
            dialog.setContentView(R.layout.container_dialog);
            RelativeLayout rl = (RelativeLayout) dialog
                    .findViewById(R.id.bottom);
            LinearLayout ll = (LinearLayout) dialog.findViewById(R.id.top);
            View view = (View) dialog.findViewById(R.id.view);
            // rl.setVisibility(View.GONE);
            // ll.setVisibility(View.GONE);
            // view.setVisibility(View.GONE);

            TextView cross = (TextView) dialog.findViewById(R.id.cross);
            Typeface font = Typeface.createFromAsset(getActivity().getAssets(),
                    "fontawesome-webfont.ttf");
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
                    // displayNextPage(id);
                }
            });
            webView.addJavascriptInterface(this, "javaObj");
            webView.addJavascriptInterface(this, "cpjs");
            displayFocussedBrands(1);

            dialog.getWindow().setLayout(width - 80, height - 50);
            dialog.getWindow().setBackgroundDrawable(
                    new ColorDrawable(android.graphics.Color.TRANSPARENT));
            dialog.show();

        }
    };

    OnClickListener focusListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            if (pen1.getTag().equals("2")) {
                ImageView im = (ImageView) ((RelativeLayout) v).getChildAt(4);
                if (v.getTag().equals("1")) {
                    im.setImageResource(R.drawable.extratag1);
                    v.setTag("2");
                } else if (v.getTag().equals("2")) {
                    im.setImageResource(R.drawable.extratag);
                    v.setTag("1");
                }
            }
        }
    };

    class PhotosAdapter extends BaseAdapter {

        Context context;
        ArrayList<RelativeLayout> arrList;

        public PhotosAdapter(Context context, ArrayList<RelativeLayout> arrList) {
            this.context = context;
            this.arrList = arrList;
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return arrList.size();
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            if (convertView == null) {
                convertView = arrList.get(position);
            }
            convertView.setLayoutParams(new GridView.LayoutParams(
                    GridView.LayoutParams.WRAP_CONTENT,
                    GridView.LayoutParams.WRAP_CONTENT));

            final GridView grid = (GridView) parent;

            RelativeLayout view = (RelativeLayout) convertView;
            ImageView delete = (ImageView) view.getChildAt(1);
            delete.setId(position);
            delete.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    int pos = v.getId();
                    arrList.remove(pos);
                    PhotosAdapter adapter = new PhotosAdapter(context, arrList);
                    grid.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            });
            return convertView;
        }

    }

}
