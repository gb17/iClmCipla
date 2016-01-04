package com.cirrius.iclmcipla;


import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.InputFilter;
import android.text.InputType;
import android.util.Base64;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.TimePicker;

import com.cirrius.newsinglelist.SingleListview;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/**
 * Created by admin on 12/24/15.
 */
public class ReportingFragment extends Fragment {
    private LinearLayout linearone, linearthree;
    ImageView gesture;
    ListView mListView;
    TableRow table1, table2;
    TextView globaltextchk;
    Typeface font;
    Dialog dialog_box;
    EditText edittextDuedate;
    WebView webView;
    ArrayList<String> name;
    private boolean[] thumbnailsselection;
    int iconint[] = {0, 1, 2, 2, 1};
    int id = 0;
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
    TextView vForindciator;
    String menutext = "";
    String[][] pageData;
    private Button zero;
    private Button ente;
    private ListView listview;
    View vForAP;
    TextView plus;
    ImageView historyIcon;
    EditText focusedView;
    ArrayList<String> items = new ArrayList<String>();
    private int count;
    String url = "";
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
    int iconmode_gl = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        font = Typeface.createFromAsset(getActivity().getAssets(),
                "fontawesome-webfont.ttf");
        int index = getArguments().getInt("index");
        if (index == 0) {
            View v3 = getMyViewForReporting();
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


            byte[] data = Base64.decode(imageData, 0);
            Bitmap bpp = BitmapFactory.decodeByteArray(data, 0, data.length);
            gesture.setImageBitmap(bpp);

            View v1 = inflater.inflate(R.layout.visitdetails, container, false);
            EditText new_feed = (EditText) v1.findViewById(R.id.new_feed);
            com.iclm.util.Utility.hideKeyboard(new_feed);
            final TextView doc1 = (TextView) v1.findViewById(R.id.doc1);
            doc1.setText("John Patrick[ASM] + 1");
            doc1.setTag("1");
            doc1.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    if (doc1.getTag().equals("2")) {
                        doc1.setBackgroundResource(R.drawable.roundforlayoutcyan);
                        doc1.setText("John Patrick[ASM] + 1");
                        doc1.setTag("1");
                    } else {
                        doc1.setBackgroundResource(R.drawable.roundforlayout);
                        doc1.setTag("2");
                    }
                }
            });
            final TextView doc2 = (TextView) v1.findViewById(R.id.doc2);
            doc2.setTag("2");
            doc2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    if (doc2.getTag().equals("1")) {
                        doc2.setBackgroundResource(R.drawable.roundforlayout);
                        doc2.setTag("2");
                    } else {
                        doc2.setBackgroundResource(R.drawable.roundforlayoutcyan);
                        doc2.setText("Alan Brown[RSM] + 1");
                        doc2.setTag("1");
                    }
                }
            });

            EditText add = (EditText) v1.findViewById(R.id.add);
            final LinearLayout ll1 = (LinearLayout) v1
                    .findViewById(R.id.layout1);
            final LinearLayout ll2 = (LinearLayout) v1
                    .findViewById(R.id.layout2);
            final LinearLayout ll3 = (LinearLayout) v1
                    .findViewById(R.id.layout3);
            TextView text1 = (TextView) v1.findViewById(R.id.closetxt1);
            TextView text2 = (TextView) v1.findViewById(R.id.closetxt2);
            TextView text3 = (TextView) v1.findViewById(R.id.closetxt3);
            text1.setOnClickListener(removeListener);
            text2.setOnClickListener(removeListener);
            text3.setOnClickListener(removeListener);

            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    if (count < 3)
                        count++;
                    if (count == 1) {
                        ll1.setVisibility(View.VISIBLE);
                    } else if (count == 2) {
                        ll2.setVisibility(View.VISIBLE);
                    } else if (count == 3) {
                        ll3.setVisibility(View.VISIBLE);
                    }
                }
            });

            View v4 = actionPointView(getActivity(), "0");

            LinearLayout linear = new LinearLayout(getActivity());
            linear.setOrientation(LinearLayout.VERTICAL);
            v1.setPadding(5, 10, 5, 40);
            v2.setPadding(5, 10, 5, 40);
            v3.setPadding(5, 10, 5, 40);
            v4.setPadding(5, 10, 5, 40);
            linear.addView(v1);
            linear.addView(v2);
            linear.addView(v3);
            linear.addView(v4);

            return linear;
        } else if (index == 2) {
            View v3 = getMyViewForReporting();
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


            byte[] data = Base64.decode(imageData, 0);
            Bitmap bpp = BitmapFactory.decodeByteArray(data, 0, data.length);
            gesture.setImageBitmap(bpp);

            View v1 = inflater.inflate(R.layout.visitdetails, container, false);
            EditText new_feed = (EditText) v1.findViewById(R.id.new_feed);
            com.iclm.util.Utility.hideKeyboard(new_feed);
            final TextView doc1 = (TextView) v1.findViewById(R.id.doc1);
            doc1.setText("John Patrick[ASM] + 1");
            doc1.setTag("1");
            doc1.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    if (doc1.getTag().equals("2")) {
                        doc1.setBackgroundResource(R.drawable.roundforlayoutcyan);
                        doc1.setText("John Patrick[ASM] + 1");
                        doc1.setTag("1");
                    } else {
                        doc1.setBackgroundResource(R.drawable.roundforlayout);
                        doc1.setTag("2");
                    }
                }
            });
            final TextView doc2 = (TextView) v1.findViewById(R.id.doc2);
            doc2.setTag("2");
            doc2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    if (doc2.getTag().equals("1")) {
                        doc2.setBackgroundResource(R.drawable.roundforlayout);
                        doc2.setTag("2");
                    } else {
                        doc2.setBackgroundResource(R.drawable.roundforlayoutcyan);
                        doc2.setText("Alan Brown[RSM] + 1");
                        doc2.setTag("1");
                    }
                }
            });

            final TextView doc3 = (TextView) v1.findViewById(R.id.doc3);
            doc3.setTag("2");
            doc3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    if (doc3.getTag().equals("1")) {
                        doc3.setBackgroundResource(R.drawable.roundforlayout);
                        doc3.setTag("2");
                    } else {
                        doc3.setBackgroundResource(R.drawable.roundforlayoutcyan);
                        doc3.setText("Alex Ferguson[RSM] + 1");
                        doc3.setTag("1");
                    }
                }
            });

            final TextView doc4 = (TextView) v1.findViewById(R.id.doc4);
            doc4.setTag("2");
            doc4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    if (doc4.getTag().equals("1")) {
                        doc4.setBackgroundResource(R.drawable.roundforlayout);
                        doc4.setTag("2");
                    } else {
                        doc4.setBackgroundResource(R.drawable.roundforlayoutcyan);
                        doc4.setText("Xavier Antonio[RSM] + 1");
                        doc4.setTag("1");
                    }
                }
            });

            EditText add = (EditText) v1.findViewById(R.id.add);
            final LinearLayout ll1 = (LinearLayout) v1
                    .findViewById(R.id.layout1);
            final LinearLayout ll2 = (LinearLayout) v1
                    .findViewById(R.id.layout2);
            final LinearLayout ll3 = (LinearLayout) v1
                    .findViewById(R.id.layout3);
            TextView text1 = (TextView) v1.findViewById(R.id.closetxt1);
            TextView text2 = (TextView) v1.findViewById(R.id.closetxt2);
            TextView text3 = (TextView) v1.findViewById(R.id.closetxt3);
            text1.setOnClickListener(removeListener);
            text2.setOnClickListener(removeListener);
            text3.setOnClickListener(removeListener);

            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    if (count < 3)
                        count++;
                    if (count == 1) {
                        ll1.setVisibility(View.VISIBLE);
                    } else if (count == 2) {
                        ll2.setVisibility(View.VISIBLE);
                    } else if (count == 3) {
                        ll3.setVisibility(View.VISIBLE);
                    }
                }
            });

            //View v4 = actionPointView(getActivity(), "0");
            View v4 = inflater.inflate(R.layout.activity_prescription, null);
            SingleListview singleListview = new SingleListview(getActivity());

            final RelativeLayout rel = (RelativeLayout) v4.findViewById(R.id.rel);
            rel.addView(singleListview.getviewsSigleExpandalelistview(1));

            TextView addTextView = (TextView) v4.findViewById(R.id.adddoc);

            addTextView.setText(getResources().getString(R.string.icon_add) + " Doctor ");
            addTextView.setTypeface(font);

            TextView addTextViewBrand = (TextView) v4.findViewById(R.id.adddoc2);

            addTextViewBrand.setText(getResources().getString(R.string.icon_add) + " Competitor ");
            addTextViewBrand.setTypeface(font);


            addTextViewBrand.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Dialog dialog = new Dialog(getActivity());
                    dialog.getWindow();
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.add_comp_brand);
                    dialog.getWindow().setBackgroundDrawable(
                            new ColorDrawable(android.graphics.Color.TRANSPARENT));
                    dialog.findViewById(R.id.addcomp).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            SingleListview singleListview = new SingleListview(getActivity());
                            rel.removeAllViews();
                            rel.addView(singleListview.getviewsSigleExpandalelistview(22));
                            dialog.dismiss();
                        }
                    });
                    dialog.getWindow().setLayout(600, 600);
                    dialog.show();
                }
            });

            addTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Dialog dialog = new Dialog(getActivity());
                    dialog.getWindow();
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.adddoctor);
                    dialog.getWindow().setBackgroundDrawable(
                            new ColorDrawable(android.graphics.Color.TRANSPARENT));
                    ListView listView = (ListView) dialog.findViewById(R.id.list);
                    NewCustomAdapter newCustomAdapter = new NewCustomAdapter(getActivity());
                    listView.setAdapter(newCustomAdapter);

                    EditText editText = (EditText) dialog.findViewById(R.id.ButtonSet);
                    editText.setOnClickListener(new
                                                        View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                dialog.dismiss();
                                                            }
                                                        });


                    dialog.getWindow().setLayout(600, 600);
                    dialog.show();
                }
            });

            LinearLayout linear = new LinearLayout(getActivity());
            linear.setOrientation(LinearLayout.VERTICAL);
            v1.setPadding(5, 10, 5, 40);
            v2.setPadding(5, 10, 5, 40);
            v3.setPadding(5, 10, 5, 40);
            v4.setPadding(5, 10, 5, 40);
            linear.addView(v1);
            linear.addView(v2);
            linear.addView(v3);
            linear.addView(v4);

            return linear;
        }
        return null;
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

        fwdmsg.setOnLongClickListener(new View.OnLongClickListener() {

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

                doneap.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        d.dismiss();
                    }
                });

                chk.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        d.dismiss();
                    }
                });

                doneap.setOnClickListener(new View.OnClickListener() {

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
        historyIcon.setOnClickListener(new View.OnClickListener() {

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

                cross.setOnClickListener(new View.OnClickListener() {

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

        plus.setOnClickListener(new View.OnClickListener() {
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
                ButtonSet.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        d.dismiss();
                    }
                });
                close.setTypeface(font);
                close.setOnClickListener(new View.OnClickListener() {

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
                edittextDuedate.setOnClickListener(new View.OnClickListener() {

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
                edittime.setOnClickListener(new View.OnClickListener() {
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

        editpencil.setOnClickListener(new View.OnClickListener() {

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

                ButtonSet.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        d.dismiss();
                    }
                });
                close.setTypeface(font);
                close.setOnClickListener(new View.OnClickListener() {

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
                edittextDuedate.setOnClickListener(new View.OnClickListener() {

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
                edittime.setOnClickListener(new View.OnClickListener() {
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
        multiSpinner.setItems(list1, "Category", new MultiSpinner.MultiSpinnerListener() {

            @Override
            public void onItemsSelected(boolean[] selected) {
                // TODO Auto-generated method stub

            }
        });
        MultiSpinner multiSpinner2 = (MultiSpinner) v
                .findViewById(R.id.spinner2);
        multiSpinner2.setItems(list2, "Sub-Category",
                new MultiSpinner.MultiSpinnerListener() {

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
        check_me.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

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

        preview.setOnClickListener(new View.OnClickListener() {

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
                cross.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        dialog.dismiss();
                    }
                });
                webView = (WebView) dialog.findViewById(R.id.webview);
                ImageView next = (ImageView) dialog.findViewById(R.id.next);
                next.setOnClickListener(new View.OnClickListener() {

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
        undo.setOnClickListener(new View.OnClickListener() {

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

    View.OnClickListener keyListener = new View.OnClickListener() {

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

    void addDataToSampling(final int index, String s) {

        final LinearLayout linear = new LinearLayout(getActivity());
        linear.setBackgroundResource(R.drawable.roundforlayout);
        linear.setOnClickListener(new View.OnClickListener() {
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
                ViewGroup.LayoutParams.WRAP_CONTENT);
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
        bv.setOnClickListener(new View.OnClickListener() {

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
        ed1.setOnFocusChangeListener(new View.OnFocusChangeListener() {

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

    View.OnClickListener listener = new View.OnClickListener() {

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
                linear.setOnClickListener(new View.OnClickListener() {
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
                        325, ViewGroup.LayoutParams.WRAP_CONTENT);
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
                bv.setOnClickListener(new View.OnClickListener() {

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
                ed1.setOnFocusChangeListener(new View.OnFocusChangeListener() {

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
    View.OnClickListener deleteListener = new View.OnClickListener() {

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

    public void displayFocussedBrands(int id) {
        String fd = "";
        ReadWriteData rw = new ReadWriteData(getActivity(), "MPOWERDB", null, 1);
        pageData = rw.getTableData("DVC", 9, " WHERE COL8 = 'F' ",
                "Order by CAST(COL9 as integer)");
        fd = Utility.split(pageData[id][1], ".")[0].toUpperCase();
        webView.getSettings().setPluginState(WebSettings.PluginState.ON);
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

    void openDialog1(final View viewme) {
        final TextView textView = (TextView) viewme;
        // TODO Auto-generated method stub
        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.main);
        Button b1 = (Button) dialog.findViewById(R.id.button1);

        b1.setOnClickListener(new View.OnClickListener() {

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
                    linear.setOnClickListener(new View.OnClickListener() {

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
                            325, ViewGroup.LayoutParams.WRAP_CONTENT);
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
                    bv.setOnClickListener(new View.OnClickListener() {

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
                    ed1.setOnFocusChangeListener(new View.OnFocusChangeListener() {

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
            holder.checkbox.setOnClickListener(new View.OnClickListener() {
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
            holder.textview.setOnClickListener(new View.OnClickListener() {
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

                viewHolder.chkbox.setOnClickListener(new View.OnClickListener() {

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
                            doneap.setOnClickListener(new View.OnClickListener() {

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

                            d1.setOnDismissListener(new DialogInterface.OnDismissListener() {

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
                            .setOnClickListener(new View.OnClickListener() {

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

            viewHolder.threedot.setOnClickListener(new View.OnClickListener() {

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

                        bin.setOnClickListener(new View.OnClickListener() {

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
                                doneap.setOnClickListener(new View.OnClickListener() {

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

    android.view.View.OnClickListener removeListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            LinearLayout ll = (LinearLayout) v.getParent();
            ll.setVisibility(View.GONE);
            count--;
        }
    };
}
