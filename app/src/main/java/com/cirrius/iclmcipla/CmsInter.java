package com.cirrius.iclmcipla;

import android.graphics.Typeface;

public interface CmsInter {

    String COMMA = ",";
    String UNCOMMA = "`";
    String CAP = "^";
    String DOLLAR = "$";
    String PERCENT = "%";
    String PIPELINE = "|";
    String TILD = "~";
    String AT = "@";
    String START_BRACE = "[";
    String END_BRACE = "]";
    String STAR = "*";
    String EXLAMETORY = "!";
    String HYPHEN = "-";

    String UNDERSCORE = "_";
    String FSLASH = "/";
    String COLAN = ":";
    String SPACE = " ";

    String LESS_THAN = "<";
    String GREATER_THAN = ">";
    String QUESTION_MARK = "?";
    String DOT = ".";

    /**
     * ****************************** Ascii for parsing characters ********************************************
     */
    int ASCI_DOLLAR = 36; // $
    int ASCI_PERCENT = 37; // %
    int ASCI_TILD = 126; // ~
    int ASCI_COLON = 58; // :
    int ASCI_CAP = 94; // ^
    int ASCI_OPEN_SQUARE = 91; // [
    int ASCI_CLOSE_SQUARE = 93; // ]
    int ASCI_EXCLAMATION = 33; // !
    int ASCI_PIPE = 124; // |
    int ASCI_UNCOMMA = 96; // `
    int ASCI_COMMA = 44; // ,
    int ASCI_SEMICOLON = 59; // ;
    int ASCI_LESS_THAN = 60; // <
    int ASCI_GRATR_THAN = 62; // >
    int ASCI_QMARK = 63; // ?
    int ASCI_FSLASH = 47; // /

    final byte ZONE = 1;
    final byte REGION = 2;
    final byte AREA = 3;
    final byte TERRITORY = 4;
    final byte TOWN = 5;
    final byte PATCH = 6;
    int PATCHLIST = 352;
    int DVM = 353;
    int Chemist_addmore_RCPA = 785;
    int Ch_RCPA_Twice = 786;
    int Sync_data = 3;
    int MSG_LEN = 100;
    String timeZone = "GMT+5:30";

    String AL_SPACE = "Space not allowed.";
    String AL_Setup = "Setup password";
    String AL_Data = "No data";
    String AL_InvalidVersion = "Invalid Version";
    String AL_Blank = "Enter mandatory field";
    String AL_Len = "Length should be min 4";
    String AL_Spe_Char = "Special char not allowed";
    String AL_Old_New_Pwd = "New/Old password  should be different";
    String AL_Inv_Pwd = "Invalid usercode/password";
    String AL_Invalid_Pwd = "Enter valid password";
    String AL_Exit = "You want to exit?";
    String Al_Cnf_Suc = "System configured";
    String Al_Cnf_Fail = "Partial data downloaded !\n You want to try again?";
    String AL_No_Per = "No permission";
    String AL_Download = "Please download data";
    String AL_Welcome = "Welcome to mPower!";
    String AL_SEL_BRAND = "Please Select Brand.";
    String AL_Pwd_Conf = "It will take 30-45 mins to configure";
    String AL_Pwd_Chng = "Password changed";
    String AL_INV_CLNT = "Invalid Client ID!!";
    String AL_Save_Cnf = "You want to save?";
    String NO_PLAN_MNTH_YEAR = "No year and Month Information is available";
    // String AL_Pwd_Conf_wait =
    // "It will take 3NumberPicker0-45 mins to configure";
    String AL_Save = "Record saved";
    String AL_Save_Error = "Error in saving";
    String AL_Delete = "Do you want to delete ?";
    String AL_Delete_Succ = "Deleted";
    String AL_Delete_Fail = "Error in deleting";
    String AL_Rec = "No Data";// ;"No records";
    String Al_Error = "Error in transaction";
    String AL_Blank_Space = "Space not allowed";
    String AL_Inv_Version = "Invalid version,Perform Sync...";
    String AL_Rec_Full = "Memory full";
    String AL_InvalidInstanceID = "User already configured";
    String AL_IvalidStatus = "Invalid status.Plz contact administrator";
    String AL_UserDeleted = "User deleted.";
    String AL_None_sel = "None cannot be selected";
    String AL_MisMatch = "Server & mobile date mismatch!!";
    String AL_UPW_Fail = "Unable to change password.";
    String AL_Blank_Data = "Blank entry not allowed";
    String AL_PV_PD = "Select either PD/PR field";
    String AL_Zero = "Zero entry not allowed";
    String Al_Valid_Entry = "Values permitted only between 0-5";
    // String Al_Neg_Entry = " Score Cannot be a negative Value";
    String AL_No_Allow_Date = "No allow date available";
    String Al_No_Stk = "Stockist not available.";
    String AL_BU_Change = "Territory/BU Changed,Perform Sync...";
    String AL_BU_Conf = "BU Changed...update..??";
    String AL_TE_Conf = "TE Changed...update..??";
    String AL_Inv_old = "Invalid old password";
    String AL_InvalidRole = "Role Changed:Plz contact Adminstrator";
    String AL_Confirm_Pwd = "New password and Confirm password mismatch!";// Akbar--Confirm
    // New
    // Password
    String Al_Fail = "Failed to configure.Please try again"; // Akbar--Confirm
    // New Password
    String AL_Inv_new_pwd = "Please enter some other new password";
    String AL_chgPwd = "Password has expired. Please change password.";
    String AL_NO_Menu = "Cannot Configure!\nPlease contact your administrator";
    String AL_NUM = "Numbers not allowed";
    String AL_Mid_Space = "Space in between not allowed";
    String AL_Date_Not_Avl = "Date Not AvailableNumberPicker";
    String AL_INV_ST = "Please enter a valid RxLvl";
    String AL_STATUS_BLNK = "RxLvl is mandatory if PD/PR/DD is entered";
    String AL_PD_PR_MNDTRY = "RxLvl cannot be entered if PD/PR is blank";
    String AL_MSG_SEL_NONE = "Please select atleast one";
    String AL_CHECK_UR_MSG_BOARD = "Check your Message Board..!!!!";
    String AL_SYNC_SUC = "Sync Successful";
    String AL_Data_Full = "Memory full";
    String SYNCHRONIZE_DATA = "Are you sure you want to synchronize...";
    String AL_NO_NCA_TYPE = "No NCA Type";
    String AL_NO_NCA_DAY = "No NCA Day";
    String AL_CONCENT_EXIST = "Consent already filled for Pharmacist, Kindly update Handset";
    String Al_Download_Content = "New content have been uploaded! \n Do you want to download new content?";
    String AL_Update_FAIL = "Error in downloading content !";
    // Server Response Alert Messages
    String AL_SRESP_NOK = "Server response not ok";
    String AL_TRAN_FAIL = "Transaction fail";
    String AL_CON_ESTB_FAIL = "Could not establish connection ";
    String AL_SNOT_REAC = "Server not reachable: ";
    String AL_INITIAL_SPC = "Initial Space not allowed";
    String AL_VAL_RATING = "Please Enter Valid Rating";

    // MSD Messages
    String AL_CONCENT_GRID_VAL1 = "Cons should be equal or Greater than the Min";
    String AL_CONCENT_GRID_VAL2 = "Cons should not be less than classification value";
    String AL_CONCENT_GRID_VAL3 = "End Date should not be a past date";
    String AL_CONCENT_GRID_VAL4 = "To Date should not be a past date";
    String AL_CONCENT_GRID_VAL5 = "From Date should not be greater than To Date";
    String AL_CONCENT_GRID_VAL6 = "All SKU entries are mandatory";
    String AL_CONCENT_NO_SEL_STKST = "Minimum one stockiest needs to be selected";
    String AL_MERCHANTDISING_CATEGORY_NO_SEL_STKST = "Minimum one Category needs to be selected";
    String AL_MSD_MAND = "Please enter some text";
    String Spec_Parse_char_Not_allw = "Special char ( $   %   ^   ;   , )  not allowed";
    String AL_MSG_MAX_LEN = "Message max length exceeded";

    String AL_ORDER_AVL_QTY_BLANK = "Avail not entered for Cons SKUs";
    String AL_ORDER_GRID_VAL1 = "Sum of Avail, Ord and Bon should not be less than Cons";

    String AL_INV_PHO_BLANK = "Please select a Photo for the entered Remarks";
    String AL_INV_RMK_BLANK = "Please enter Remarks for the selected Photo";

    String AL_INV_VAL_DOT = "Please enter a valid value";
    String AL_DEC_VAL_DOT = "Only 2 values allowed after decimal";
    String AL_SPL_NT_ALLOWED = "Special characters not allowed";
    String AL_UNLSTED_NM = "Unlisted name not allowed";

    String AL_FUTURE_DATE = "Date should not be a future date";

    String AL_TERMS_CONDITIONS = "I have read & accepted the terms & conditions";

    String AL_LOGOUT_CONFIRM = "Are you sure you want to logout?";
    String AL_EXIT_CONFIRM = "Are you sure you want to exit?";
    String AL_SYNC_COUNT = "Kindly synchronize saved data first";
    String AL_INV_NUM_SPL_ALLOWED = "Special Chars except   -   /   \\   are not allowed";

    String AL_MERCH_ORDER_GRID_VAL = "Order value less than consent value";
    String AL_MERCH_ORDER_GRID_VAL1 = "Value less than agreed consent value";
    String AL_MERCH_INVOICE_VAL = "Invoice value less than the order value";

    String AL_RR_RED_REQ_NOT_ALL = "Previous Request Approval Pending...";
    String AL_RR_RED_REQ_VAL = "Total RR value is greater than the total credit left";

    String AL_CONCENT_NO_SEL_ACTIVITY = "Minimum one activity needs to be selected";
    String AL_NO_CNT_EML = "No Content available for email";
    String cancelCall = "Do you want to delete data?";
    String AL_INV_EMAIL = "Invalid format for email id.";
    String AL_INV_MOBILE = "Enter valid mobile number";
    String AL_INV_MOBILE_ZERO = "Mobile number should not start with zero";

    int STATUS_BLANK = -1;
    int INVALID_STATUS = -2;
    int PD_PR_MNDTRY = -3;
    byte None = 1;
    byte Unlisted = 1;
    byte NULL = 0;
    byte nfd_RMS_COLS = 15;
    byte cheRem_RMS_COLS = 14;
    byte sys00_RMS_COLS = 5;
    byte sys01_RMS_COLS = 21;// 2 extra cols for password alert//Akbar +
    // 4 extra cols for digital detailing
    byte patchData_RMS_COLS = 3;
    byte brandData_RMS_COLS = 3;
    byte chemData_RMS_COLS = 7;
    byte terrdata_RMS_COLS = 2;
    byte cmpBrData_RMS_COLS = 4;
    byte ww_RMS_COLS = 24; // 2 extra cols for latitude and longitude
    // byte salesData_RMS_COLS = 28;
    byte salesData_RMS_COLS = 30; // 2 extra cols for latitude and longitude
    byte vdata_RMS_COLS = 6;
    int Add_Dr = 21;
    int Add_Ch = 16;
    int Del_Dr_Ch = 13;
    int Feed_Dr = 26;
    int Feed_Ch = 18;
    int Remark_Stk = 17;
    int Remark_RCPA = 25;
    int Remark_NCA = 16; // 2 extra cols for latitude and longitude
    int Remark_Day = 6;
    int Remark_Leave = 12; // 2 extra cols for latitude and longitude
    int Rep_Ass = 13;
    int Obj_Entry = 27;
    int Issue_Entry_Dr = 29;
    int Issue_Entry_Ch = 29;
    int close_issue = 25;

    // Detailing Menus
    int MY_TEAM = 1;
    int TEAM_GRP_STS = 108;
    int TEAM_INDV_STS = 109;
    int PHARMACIST = 162;
    int PHARMACIST_CTC = 172;
    int NCA = 163;
    int LEAVE = 5;
    int PLAN = 9;
    int MGR_MY_TEAM_PLAN = 110;
    int MGR_MY_TEAM_MISSED_CALLS = 111;
    int MGR_MY_TEAM_PAST_REPORT = 115;
    int TOOLS = 135;
    int LOGOUT = 171;
    int DATA_SYNC = 4;
    int PHARMACIST_CONCENT = 165;
    int PHARMACIST_ORDER = 166;
    int PHARMACIST_INVOICE = 167;
    int PHARMACIST_GEOTAG = 168;
    int PHARMACIST_INPUT = 169;
    int PHARMACIST_JW = 170;
    int TOOLS_PAST_REPORT = 10;
    int TOOLS_MISSED_CALLS = 151;
    int TOOLS_MESSAGE_BOARD = 7;
    int TOOLS_CHANGE_PWD = 142;
    int PHARMACIST_MERCH = 173;
    int PHARMACIST_REWARD_REQ = 174;
    int PHARMACIST_MERCH_CONCENT = 175;
    int PHARMACIST_MERCH_ORDER = 176;
    int PHARMACIST_MERCH_INVOICE = 177;
    int PHARMACIST_REDEMPTION_REQ = 178;
    int PHARMACIST_REDEMPTION_INVOICE = 179;
    int PHARMACIST_CTC_ACTIVITY = 180;

    int DOCTOR_DETAILING = 181;

    int CONF_FST_TIM = 701;
    int CPW_FST_TIM = 702;
    int CPW_FRM_LST = 703;
    // int CPW_PWD_EXP = 704;
    // int SYNCHRONIZE = 800;
    int CONSENT = 1001;
    int CALLS = 1002;
    int PHARMACIST_CONCENT_STOKIEST_LST = 1003;
    int PHARMACIST_ORDER_STK = 1004;
    int SYNC_REPORT = 1005;
    int TOOLS_MISSED_CALLS_CUST = 1006;
    int TOOLS_PAST_REPORT_DETAILS = 1007;
    int TOOLS_PAST_REPORT_DETAILS_CALL = 1008;
    int COMPOSE_MSG = 1009;
    int GET_MSGS = 1010;
    int GET_MSGS1 = 1011;
    int FORWARD_MSG = 1012;
    int MGR_MY_TEAM_MISSED_CALLS_CUST = 1013;
    int MGR_MY_TEAM_PAST_REPORT_DETAILS = 1014;
    int MGR_MY_TEAM_PAST_REPORT_DETAILS_CALL = 1015;
    int CHANGE_PWD = 1016;
    int PHARMACIST_IROCH = 1017;
    int PHARMACIST_CTC_IRCH = 1018;
    int PHARMACIST_CTC_IROCH = 1019;
    int PHARMACIST_MERCH_CATEGORY_LST = 1020;
    int PHARMACIST_MERCH_STOCKIEST_LST = 1021;
    int PHARMACIST_MERCH_IRCH = 1022;
    int PHARMACIST_MERCH_IROMR = 1023;
    int PHARMACIST_MERCH_IRBRAND = 1024;
    int PHARMACIST_RWD_IRCH = 1025;
    int PHARMACIST_RWD_IRRDI = 1026;
    int PHARMACIST_RWD_INV_FORM = 1027;
    int RESULT_CODE_EXIT = 1028;
    int REPORTING = 1029;
    int UPDATE = 1030;
    int CANCELCALL = 1031;

    String TXNDETAILINGDATA = "TXN101";
    String TXNINVREQDATA = "TXN102";
    String TXNDETDATA = "UDDET";
    String TBMTP = "TBMTP";

    String ENABLED = "0";
    String DISABLED = "1";

    /* ................................................................... */
    int PHARMACIST_JW_RPT_CODE = 7;
    int LEAVE_RPT_CODE = 12;
    int PHARMACIST_INPUT_RPT_CODE = 15;
    int SYNC_DETAIL_RPT_CODE = 100;
    int PHARMACIST_CONCENT_RPT_CODE = 101;
    int PHARMACIST_ORDER_RPT_CODE = 102;
    int PHARMACIST_INVOICE_RPT_CODE = 103;
    int PHARMACIST_GEOTAG_RPT_CODE = 104;
    int PHARMACIST_MERCH_CONSENT_RPT_CODE = 105;
    int PHARMACIST_MERCH_ORDER_RPT_CODE = 106;
    int PHARMACIST_MERCH_INVOICE_RPT_CODE = 107;
    int PHARMACIST_RWD_REQ_RPT_CODE = 108;
    int PHARMACIST_RWD_INVOICE_RPT_CODE = 109;
    int PHARMACIST_CTC_ACTIVITY_RPT_CODE = 110;

    String COMING_SOON = "Coming Soon...";

    /* ........MenuCodes For Mesages.............. */
    int MSG = 7;// 23;
    int INBOX = 152;
    int COMP_MSG = 150;
    int COMP_MSG_WW = 999;
    int NEW_MESSAGE = 117;
    int ALL_MESSAGE = 118;

    /* ........Message Types.............. */
    int COMPOSE = 1;
    int REPLY = 2;
    int FORWARD = 3;

	/* ..........................Compose Form.................... */

	/* ................................................................... */

    int DOCTOR = 31;
    int DR_VISIT_DTL = 18;
    int DR_PRDUCT_ACTI = 20;
    int DR_GPI_DIST = 21;
    int DR_FEDBCK = 22;
    int DR_ADDISSUE = 23;
    int DR_CLOSE_ISUE = 24;
    int DR_JW = 25;
    int DR_PODUCT_FEADBACK = 92;
    int DR_PCP = 19;
    int DR_OBJ_ENTRY = 26;
    int DR_LAST_VISIT_DTL = 27;
    int DR_NEX_VISIT_PLN = 28;
    int DR_PENDING_ISUE = 29;
    int DR_RCPA_INFO = 30;
    int DR_INFO = 40;
    int DR_SYNC_DATA = 122;
    int DR_ORDER = 183;

    int CHEMIST = 32;
    int CH_VISIT_DTL = 35;
    int CH_ODER = 93;
    int CH_GPI = 94;
    int CH_FEDBCK = 95;
    int CH_JW = 98;
    int CH_RCPA = 99;
    int CH_PCP = 36;
    int CH_LAST_VISIT_DTL = 37;
    int CH_NEX_VISIT_PLN = 38;
    int CH_PENDING_ISUE = 39;
    int CH_INFO = 41;

    // Report Codes for RBXY Digital Detailing
    int DR_PP_RPTCODE = 1;
    int DR_JW_RPTCODE = 2;
    int DR_GPI_RPTCODE = 3;
    int DR_FEEDBACK_RPTCODE = 4;
    int CH_RCPA_RPTCODE = 6;
    int CH_JW_RPTCODE = 7;
    int CH_FEEDBACK_RPTCODE = 8;
    int STK_FEEDBACK_RPTCODE = 9;
    int NCA_REMARK_RPTCODE = 11;
    int LEAVE_RPTCODE = 12;
    int DAY_REMARKS_RPTCODE = 13;
    int CH_RCPA_REMARKS_RPTCODE = 14;
    int CH_GPI_RPTCODE = 15;
    int STK_INVENTORY_RPTCODE = 16;
    int DR_ISSUE_RPTCODE = 17;
    int DR_OBJ_RPTCODE = 18;
    int CH_ISSUE_RPTCODE = 19;
    int CH_OBJ_RPTCODE = 20;
    int STK_OBJ_RPTCODE = 21;
    int NCA_JW_RPTCODE = 22;

    int DR_DETAILING_RPTCODE = 101;
    int GEOTAG_RPTCODE = 104;
    int DR_ORDER_RPTCODE = 105;
    int CH_ORDER_RPTCODE = 5;

    int MGR_DR_JW_RPTCODE = 2;
    int MGR_DR_FEEDBCK_RPTCODE = 4;
    int MGR_DR_REPASSMENT_RPTCODE = 24;
    int MGR_DR_RATING_RPTCODE = 106;
    int INVESTMENT_REQUEST_RPTCODE = 110;
    int INVESTMENT_CLOSE_RPTCODE = 111;

    int MENU_DASHBOARD = 184;
    int DASHBOARD = 185;
    int MISSED_CALLS = 186;
    int TOUR_PLAN = 187;
    int PAST_RPT = 188;

    int DOC_DETAILING = 4000;
    int QUICK_DETAILING = 4001;
    int PAST_RPT_DTL = 4002;
    int DOC_DETAILING_PRACTICE = 4003;

    int PICKFILE_RESULT_CODE = 1;
    String attach = "Attach";
    String send = "Send";
    String next = "Next";
    String cancel = "Cancel";
    String AL_MSG_LST_CHK = "Select atleast one recipent";
    String AL_DOC_LST_CHK = "Select atleast one Doctor";
    String AL_LST_CHK = "Select atleast one ";
    String AL_ATTACH = "Only one attachment allowed";
    String HappyBday = "HAPPY BIRTHDAY";
    String Wedding = "HAPPY ANNIVERSERY";
    String bdaySubject = "Happy Birthday Greetings";
    String wedSubject = "Wedding Anniversery Greetings";
    String AL_App_not_found = "No Application Found";
    String Al_NoAttach = "Sorry this file cannot be attached";
    String AL_CNT_DWLD_FAIL = "Unable to download content \n Please try again later.";
    int MSG_ATTACH = 1030;
    int BDAY_REMINDER = 1031;
    int BDAY_REMINDER_LIST = 1032;
    int REPLY_MSG = 1033;
    int ISSUE_CLOSE = 2001;
    int ISSUE_CLOSE_LIST = 2002;

    int form_screen = 0;
    int grid_screen = 1;
    int cmsFormNull = 0;
    int cmsformNotNull = 1;

    int Pie_chart = 1;
    int Line_chart = 2;

    String todaysAppointment = "Today's Appointment: ";

    int PARTY_TYPE_PLANNED = 0;
    int PARTY_TYPE_UNPLANNED = 1;
    int PARTY_TYPE_UNLISTED = 2;
    int PARTY_TYPE_NCA = 3;
    int PARTY_TYPE_LEAVE = 4;

    int PARTY_PHOTO_TAGGED = 1;

    String PARTY_TYPE_DOCTOR = "D";
    String PARTY_TYPE_CHEMIST = "C";

    int NCA_JW = 81;
    int NCA_REM = 82;
    int NCA_PCP = 51;

    int skipped_Party = 222;
    int update_info = 223;

    String DR_PARTY = "D";
    String CH_PARTY = "C";

    String AL_ERROR_IN_UPDATING = "Error in updating.";

    int DD_HIST = 1235;
    int DR_PAST_REPORT = 1236;
    int CH_PAST_REPORT = 1237;
    int NCA_PAST_REPORT = 1238;
    int LEAVE_PAST_REPORT = 1239;
    int DR_PCP_FIRST = 1240;
    int CH_PCP_FIRST = 1241;
    int NCA_PCP_FIRST = 1242;
    int NCA_LEAVE_SKIP_PARTY = 1243;
    int MAINC = 1244;
    int EXPENSE = 1245;
    int PLANC = 1246;
    int CALENDAR = 1247;
    int inventory = 1248;
    int CONTENTS = 1249;
    int NBM = 1250;
    int ST_VISIT_DTL = 1251;
    int STK_PCP_REPORT = 1252;
    int STK_PAST_REPORT = 1253;
    int INV_REQ = 1254;
    int DATE_WISE = 1255;
    int PARTY_WISE = 1256;
    int DASHBOARD_MENU = 1257;

    int GOOGLEMAP = 1257;
    int SOCIAL_MEADIA = 1258;

    String PlanQuery = "";

    int DR_CLOSE_ISSUE_RPTCODE = 95;

    int DETAILING = 1240;

    int NCA_PLANNED = 2;
    int NCA_UNPLANNED = 1;

    int LEAVE_PLANNED = 2;
    int LEAVE_UNPLANNED = 1;
    int LEAVE_REPORTED = 0;

    // Calender Screen variables

    int grey_color = 1;
    int white_color = 2;

    int MGR_REPORTINGTYPE_JOINTWORK = 191;
    int MGR_REPORTINGTYPE_INDIVIDUAL = 18;

    int MGR_REPORTING_JOINTWORK = 192;
    int MGR_REPORTING_FEDDBACK = 193;
    int MGR_REPORTING_REPASSESMENT = 194;
    int MGR_REPORTING_DRATING = 195;

}
