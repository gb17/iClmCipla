package com.cirrius.iclmcipla;

import java.io.File;
import java.util.ArrayList;
import java.util.Vector;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class ReadWriteData extends SQLiteOpenHelper {
    // table name
    String tbUPW = "TBUPW"; // for UPW
    String tbCVR = "TBCVR"; // for CVR
    String tbDMS = "TBDMS";
    String tbISSUE = "TBISSUE";
    String tbDAB = "TBDAB";
    String tbDSH = "TBDSH";
    String tbMSGDATA = "TBMSGDATA";
    String tbMenu = "TBDML"; // for Menu
    String tbDPL = "TBPATCHLIST"; // for patch list call activities
    String tbDAV = "TBDAV";
    String tbCN = "TBCNTRLNO"; // for Control Number
    // String tbTxn01 = "TBTXN01";
    String tbSYNC = "TXNSYNFLG";
    String tbDTags = "TBDTAGS"; // for other download tags
    String dynTbName = "";
    String tbDashData = "TBGRAPH";

    // msgName
    String colMsgID = "COL0";
    String colMsgFlag = "COL1";
    String colMsgData = "COL2";

    // columns names
    // tbCfg
    String colCfgID = "CFGID";
    String colCfgName = "CFGNAME";
    String colCfgData = "CFGDATA";

    // tbCN
    String colCNID = "CNID";
    String colCNRptCode = "CNRPTCODE";
    String colCNCntrlNo = "CNCNTRLNO";

    // tbMenu
    String colMenuID = "MENUID";
    String colMenuCode = "MENUCODE";
    String colMenuName = "MENUNAME";
    String colMenuPrntCode = "MENUPARENTCODE";
    String colMenuSeq = "MENUSEQ";

    // // tbPatchList
    // String colPatchCode = "PATCHCODE";
    // String colPatchName = "PATCHNAME";
    // String colTerratoryCode = "TERRATORYCODE";
    // String colPatchCheck = "PATCHCHECK";

    // dynTbName
    String colDataID = "_id";
    String colDataCode = "CODE";
    String colDataName = "NAME";
    String colParentCode = "PARENTCODE";// Only for sub source

    //
    String colTxnDataID = "_id";
    String colTxnRptCode = "TXNCOL0";
    String colTxnCntrlNo = "TXNCOL1";
    String colTxnData = "TXNCOL2";
    String Filter = "";

    // tbmsgdata
    String colmsgID = "COL0";
    String colmsgName = "COL1";
    String colmsgData = "COL2";

    String Calender = "TBCAL";

    boolean blTableExists = false;

    public ReadWriteData(Context context, String dbName, CursorFactory factory,
                         int version) {
        super(context, dbName, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void createTables() {
        SQLiteDatabase db = this.getWritableDatabase();
        try {

            // table for transaction
            db.execSQL("CREATE TABLE " + Calender// DATE+LEADNO,LEADNO,MODULEID,INPUT1,INPUT2,SYNCFLAG,auto
                    // increment no for unique identify
                    + "( COL0 TEXT,COL1 TEXT,COL2 TEXT,COL3 TEXT,COL4 TEXT,COL5 TEXT,COL6 INTEGER PRIMARY KEY AUTOINCREMENT ,COL7 TEXT,COL8 TEXT,COL9 TEXT,COL10 TEXT,COL11 TEXT,COL12 TEXT)");

            System.out.println("table created");

            ContentValues cv = new ContentValues();
            db.execSQL("CREATE TABLE TBDED"
                    + "(COL0 TEXT, COL1 TEXT, COL2 TEXT, COL3 TEXT, COL4 TEXT, COL5 TEXT, COL6 TEXT, COL7 TEXT)");
            db.execSQL("CREATE TABLE TBDVC"
                    + "(COL0 TEXT, COL1 TEXT, COL2 TEXT, COL3 TEXT, COL4 TEXT, COL5 TEXT, COL6 TEXT, COL7 TEXT, COL8 TEXT, COL9 TEXT , COL10 TEXT)");

            // String reponceDVC =
            // "%406@Ketproxer.htm@Ketproxer@htm@@0@113@124193@F@1@N$401@Ketproxer1.htm@Ketproxer1@htm@@0@113@124193@F@2@N$403@Ketproxerpage1.htm@Ketproxerpage1@htm@@0@113@124193@F@3@N$402@Ketproxerpage2.htm@Ketproxerpage2@htm@@0@113@124193@F@4@N$404@Ketproxerpage3.htm@Ketproxerpage3@htm@@0@113@124193@F@5@N$405@Ketproxerpage4.htm@Ketproxerpage4@htm@@0@113@124193@F@6@N$407@Liopril.htm@Liopril@htm@@0@108@124193@F@7@N$410@Liopril1.htm@Liopril1@htm@@0@108@124193@F@8@N$409@Lioprilpage1.htm@Lioprilpage1@htm@@0@108@124193@F@9@N$408@Lioprilpage2.htm@Lioprilpage2@htm@@0@108@124193@F@10@N$411@Liopril.htm@Liopril@htm@@0@108@124200@F@1@N$418@Liopril1.htm@Liopril1@htm@@0@108@124200@F@2@N$417@Lioprilpage1.htm@Lioprilpage1@htm@@0@108@124200@F@3@N$413@Lioprilpage2.htm@Lioprilpage2@htm@@0@108@124200@F@4@N$414@Ketproxer.htm@Ketproxer@htm@@0@113@124200@F@5@N$419@Ketproxer1.htm@Ketproxer1@htm@@0@113@124200@F@6@N$415@Ketproxerpage1.htm@Ketproxerpage1@htm@@0@113@124200@F@7@N$412@Ketproxerpage2.htm@Ketproxerpage2@htm@@0@113@124200@F@8@N$420@Ketproxerpage3.htm@Ketproxerpage3@htm@@0@113@124200@F@9@N$416@Ketproxerpage4.htm@Ketproxerpage4@htm@@0@113@124200@F@10@N$416@PainTab.mp4@@mp4@@0@108@124193@R@5@N$%";
            // String reponceDVC =
            // "%406@VISNA.htm@VISNA@htm@@0@113@124193@F@1@N$401@VIS.htm@VIS@htm@@0@113@124193@F@1@N$402@VIS1.htm@VIS1@htm@@0@113@124193@F@1@N$403@VIS2.htm@VIS2@htm@@0@113@124193@F@1@N$404@VIS3.htm@VIS3@htm@@0@113@124193@F@1@N$405@VIS4.htm@VIS4@htm@@0@113@124193@F@1@N$406@VIS4POP1.htm@VIS4POP1@htm@@0@113@124193@F@1@N$407@VIS4POP2.htm@VIS4POP2@htm@@0@113@124193@F@1@N$408@VIS5.htm@VIS5@htm@@0@113@124193@F@1@N$409@MYPROG.htm@MYPROG@htm@@0@114@124193@F@1@N$410@MPROG.htm@MPROG@htm@@0@114@124193@F@1@N$411@MPROG1.htm@MPROG1@htm@@0@114@124193@F@1@N$412@MPROG2.htm@MPROG2@htm@@0@114@124193@F@1@N$413@MPROG3.htm@MPROG3@htm@@0@114@124193@F@1@N$414@MPROG4.htm@MPROG4@htm@@0@114@124193@F@1@N$%";

            String reponceDVC = "%405@welcome.htm@welcome@htm@@0@113@124193@F@1@N$406@cefixime.htm@cefixime@htm@@0@113@124193@F@1@N$401@cefixime1.htm@cefixime1@htm@@0@113@124193@F@1@N$402@cefixime2.htm@cefixime2@htm@@0@113@124193@F@1@N$403@cefixime3.htm@cefixime3@htm@@0@113@124193@F@1@N$404@cefixime4.htm@cefixime.4@htm@@0@113@124193@F@1@N$405@cefixime5.htm@cefixime5@htm@@0@113@124193@F@1@N$406@cefiximeqn.htm@cefiximeqn@htm@@0@113@124193@F@1@N$407@cefiximeqn1.htm@cefiximeqn1@htm@@0@113@124193@F@1@N$408@cefiximeqn2.htm@cefiximeqn2@htm@@0@113@124193@F@1@N$409@cefiximeqn3.htm@cefiximeqn3@htm@@0@113@124193@F@1@N$410@liopril.htm@liopril@htm@@0@113@124193@F@1@N$411@liopril1.htm@liopril1@htm@@0@113@124193@F@1@N$412@lioprilpage1.htm@lioprilpage1@htm@@0@113@124193@F@1@N$413@lioprilpage2.htm@lioprilpage2@htm@@0@113@124193@F@1@N$414@tropin.htm@tropin@htm@@0@113@124193@F@1@N$415@tropin1.htm@tropin1@htm@@0@113@124193@F@1@N$416@tropinpage1.htm@tropinpage1@htm@@0@113@124193@F@1@N$420@tropinpage2.htm@tropinpage2@htm@@0@113@124193@F@1@N$%";

            // String reponceDVC =
            // "%406@MyFrog.htm@MyFrog@htm@@0@113@124193@F@1@N$401@MFROG.htm@MFROG@htm@@0@113@124193@F@1@N$402@MFROG1.htm@MFROG1@htm@@0@113@124193@F@1@N$403@MFROG2.htm@MFROG2@htm@@0@113@124193@F@1@N$404@MFROG3.htm@MFROG3@htm@@0@113@124193@F@1@N$405@MFROG4.htm@MFROG4@htm@@0@113@124193@F@1@N$%";
            if (reponceDVC.startsWith(CmsInter.PERCENT)
                    && reponceDVC.endsWith(CmsInter.PERCENT)) {
                reponceDVC = reponceDVC.substring(1, reponceDVC.length() - 1);
            }
            String[] str_dataDVC = Utility.split(reponceDVC, CmsInter.DOLLAR);
            cv = new ContentValues();
            for (int i = 0; i < str_dataDVC.length; i++) {
                String str_check = "";
                String strDVC[] = Utility.split(str_dataDVC[i], "@");

                cv.put("COL0", strDVC[0].trim());
                cv.put("COL1", strDVC[1].trim());
                cv.put("COL2", strDVC[2].trim());
                cv.put("COL3", strDVC[3].trim());
                cv.put("COL4", strDVC[4].trim());
                cv.put("COL5", strDVC[5].trim());
                cv.put("COL6", strDVC[6].trim());
                cv.put("COL7", strDVC[7].trim());
                cv.put("COL8", strDVC[8].trim());
                cv.put("COL9", strDVC[9].trim());
                cv.put("COL10", strDVC[10].trim());

                db.insert("TBDVC", "", cv);

            }

            insertPatchData("");

            createTxn();
        } catch (Exception e) {
            String str = "";
        } finally {
            db.close();
        }
    }

    public void createTxn() {
        SQLiteDatabase db = this.getWritableDatabase();
        String tblName = "";
        int noOfCols = 0;
        String strColNames = "";
        String strQuery;
        try {
            tblName = CmsInter.TXNDETAILINGDATA;
            noOfCols = 8;

            for (int j = 0; j < noOfCols; j++) {
                strColNames = strColNames + "TXNCOL" + j + " TEXT,";
            }
            strColNames = strColNames.substring(0, strColNames.length() - 1);
            strQuery = "CREATE TABLE " + tblName + "(" + colDataID
                    + " INTEGER PRIMARY KEY AUTOINCREMENT, " + strColNames
                    + ")";
            try {
                db.execSQL(strQuery);
            } catch (Exception e) {
                db.execSQL("DROP TABLE " + tblName);
                db.execSQL(strQuery);
            }

            tblName = CmsInter.TXNDETDATA;
            noOfCols = 15;
            strColNames = "";
            for (int j = 0; j < noOfCols; j++) {
                strColNames = strColNames + "COL" + j + " TEXT,";
            }
            strColNames = strColNames.substring(0, strColNames.length() - 1);
            strQuery = "CREATE TABLE TB" + tblName + "(" + colDataID
                    + " INTEGER PRIMARY KEY AUTOINCREMENT, " + strColNames
                    + ")";
            try {
                db.execSQL(strQuery);
            } catch (Exception e) {
                db.execSQL("DROP TABLE " + tblName);
                db.execSQL(strQuery);
            }
        } catch (Exception e) {
            System.out.println("Exp while creating TXN---" + e);
        } finally {
            db.close();

        }
    }

    // public void createTxns() {
    // SQLiteDatabase db = this.getWritableDatabase();
    // try {
    // for (int i = 0; i < 5; i++) {
    // String tblName = "";
    // if (i == 0) {
    // tblName = "TXN009";
    // } else if (i == 1) {
    // tblName = "TXN013";
    // } else if (i == 2) {
    // tblName = "TXN042";
    // } else if (i == 3) {
    // tblName = "TXN044";
    // } else if (i == 4) {
    // tblName = "TXN101";
    // }
    // int noOfCols = Utility.getNoOfCols(tblName);
    // String strColNames = "";
    // for (int j = 0; j < noOfCols; j++) {
    // if (i == 4 && j == 2) {
    // strColNames = strColNames + "TXNCOL" + j + " CLOB,";
    // } else {
    // strColNames = strColNames + "TXNCOL" + j + " TEXT,";
    // }
    // }
    // strColNames = strColNames
    // .substring(0, strColNames.length() - 1);
    // String strQuery = "CREATE TABLE " + tblName + "(" + colDataID
    // + " INTEGER PRIMARY KEY AUTOINCREMENT, " + strColNames
    // + ")";
    // try {
    // db.execSQL(strQuery);
    // } catch (Exception e) {
    // db.execSQL("DROP TABLE " + tblName);
    // db.execSQL(strQuery);
    // }
    // }
    // } catch (Exception e) {
    // System.out.println("Exp while creating TXNs---" + e);
    // } finally {
    // db.close();
    // }
    // }

    // public String insertConfigData(String tag, String data) {
    // String strReturn = "success";
    // String configTable = "TB" + tag;
    // SQLiteDatabase db = this.getWritableDatabase();
    // ContentValues cv = new ContentValues();
    // try {
    // int count = db.delete(configTable, "1", new String[] {});
    // cv.put(colCfgName, tag);
    // cv.put(colCfgData, data);
    // long rowId = db.insert(configTable, null, cv);
    // if (rowId == -1) {
    // strReturn = "error";
    // }
    //
    // } catch (Exception e) {
    // strReturn = "error";
    // } finally {
    // db.close();
    // }
    // return strReturn;
    // }

    public String insertMenuData(String response, String tag) {
        String strReturn = "success";
        String tableName = "TB" + tag;
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            db = this.getWritableDatabase();
            if (tag.equals("DGD")) {
                try {
                    db.execSQL("CREATE TABLE " + tableName
                            + "(COL0 TEXT, COL1 TEXT, COL2 TEXT)");
                } catch (Exception e) {
                    db.execSQL("DROP TABLE " + tableName);
                    db.execSQL("CREATE TABLE " + tableName
                            + "(COL0 TEXT, COL1 TEXT, COL2 TEXT)");
                }
            }
            // response = Utility.getresponse(1);
            ContentValues cv = new ContentValues();

            if (response.equals(CmsInter.PERCENT + CmsInter.PERCENT)) {
                strReturn = "error";
                return strReturn;
            }
            response = response.substring(1, response.length() - 1);
            String[] strData = Utility.split(response, CmsInter.DOLLAR);
            if (tag.equals("DML")) {
                db.delete(tbMenu, null, new String[]{});
            }
            for (int i = 0; i < strData.length; i++) {
                String str[] = Utility.split(strData[i], CmsInter.CAP);
                if (!tag.equals("DGD")) {
                    int mnuCode = Integer.parseInt(str[0]);
                    int mnuPrntCode = Integer.parseInt(str[2]);
                    int mnuSeq = Integer.parseInt(str[3]);

                    cv.put(colMenuCode, mnuCode);
                    cv.put(colMenuName, str[1]);
                    cv.put(colMenuPrntCode, mnuPrntCode);
                    cv.put(colMenuSeq, mnuSeq);
                } else {
                    cv.put("COL0", str[0]);
                    cv.put("COL1", str[1]);
                    cv.put("COL2", str[2]);
                }
                long rowId = db.insert(tableName, null, cv);
                if (rowId == -1) {
                    strReturn = "error";
                }
            }

        } catch (Exception e) {
            strReturn = "error" + e.toString();
            System.out.println("error in DMENU--" + e);
        } finally {
            db.close();
        }
        return strReturn;
    }

    public String getColData(String rms_Name, String COl, String whereClause) {
        // TODO Auto-generated method stub
        String strReturn = "";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cur = null;
        try {
            String query = "SELECT " + COl + " FROM " + rms_Name + " "
                    + whereClause;
            cur = db.rawQuery(query, new String[]{});
            int noOfRows = 0;
            if (cur != null) {
                noOfRows = cur.getCount();
            }
            if (noOfRows > 0) {
                while (cur.moveToNext()) {
                    strReturn = cur.getString(0);

                }
            }
        } catch (Exception e) {
            // LOG("Utility-deleteRec",e.toString());
            System.out.println("Error in  getColdata---->" + e.toString());
            return strReturn;
        } finally {
            if (cur != null) {
                cur.close();
            }
            db.close();
        }
        return strReturn;
    }

    /*
     * Tushar :Insert into table for patch "DPL" tag
     */
    public String insertPatchData(String str_response) {
        String str_return = "SUCCESS";
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues cv = new ContentValues();
            if (str_response.equals(CmsInter.PERCENT + CmsInter.PERCENT)) {
                str_return = "error";
                return str_return;
            }
            str_response = "%13^01^N^124233^124151^Mumbai Sou T1 02^^0$14^02^N^124240^124151^Mumbai Sou T1 02^^0$15^03^N^124247^124151^Mumbai Sou T1 02^^0$16^04^N^124254^124151^Mumbai Sou T1 02^^0$17^05^N^124261^124151^Mumbai Sou T1 02^^0$18^06^N^124266^124151^Mumbai Sou T1 02^^0$19^07^N^124271^124151^Mumbai Sou T1 02^^0$20^08^N^124276^124151^Mumbai Sou T1 02^^0$21^09^N^124280^124151^Mumbai Sou T1 02^^0$22^10^N^124284^124151^Mumbai Sou T1 02^^0$23^11^N^124288^124151^Mumbai Sou T1 02^^0$24^44^N^124302^124151^Mumbai Sou T1 02^^0$%";
            str_response = str_response.substring(1, str_response.length() - 1);
            String[] str_data = Utility.split(str_response, CmsInter.DOLLAR);
            for (int i = 0; i < str_data.length; i++) {
                String str[] = Utility.split(str_data[i], CmsInter.CAP);
                String str_check = "";
                str_check = str[2].trim();
                if (str_check.equals("N") || str_check.equals("U")) {
                    cv.put("COL0", str[0]);
                    cv.put("COL1", str[1]);
                    cv.put("COL2", str[3]);
                    cv.put("COL3", str[4]);
                    cv.put("COL4", str[5]);
                    cv.put("COL5", str[6]);
                    cv.put("COL6", str[7]);
                }
                String[] whereArgs = new String[2];
                whereArgs[0] = str[0].trim().toString();
                whereArgs[1] = str[5].trim().toString();
                long rowId = -1;
                if (str_check.equalsIgnoreCase("N")) {
                    boolean check_data = SelectNew(tbDPL, "COL0", str[0].trim()
                            .toString(), "COL4", str[5].trim().toString());
                    if (!check_data) {
                        rowId = db.insert(tbDPL, null, cv);
                    } else {
                        rowId = db.update(tbDPL, cv, "COL0=? AND COL5 =?",
                                whereArgs);
                    }

                } else if (str_check.equalsIgnoreCase("U")) {
                    rowId = db.update(tbDPL, cv, "COL0=? AND COL5 =?",
                            whereArgs);
                } else if (str_check.equalsIgnoreCase("D")) {
                    rowId = db.delete(tbDPL, "COL0=? AND COL5 =?", whereArgs);
                }
                if (rowId == -1) {
                    str_return = "error";
                }
            }

        } catch (Exception e) {
            // Utility.LOG("SetData-setPatchData", e.toString());
            str_return = "ERROR" + e.toString();
        } finally {
            db.close();
        }
        return str_return;
    }

    public String[][] getTXNTableData(String tb_name, int no_of_Colums,
                                      String whreclause, String orderBy) {
        SQLiteDatabase db = this.getWritableDatabase();
        String[][] strdata = null;
        // String whreclause = "";
        Cursor cur = null;
        try {
            String query = "SELECT * FROM " + tb_name + " " + whreclause + " "
                    + orderBy;
            cur = db.rawQuery(query, new String[]{});
            int noOfRows = cur.getCount();
            if (noOfRows > 0) {
                strdata = new String[noOfRows][no_of_Colums];
                int i = 0;
                while (cur.moveToNext()) {
                    for (int j = 0; j < no_of_Colums; j++) {
                        strdata[i][j] = cur.getString(j);
                    }
                    i++;
                }
            }

        } catch (Exception e) {
            System.out.println("in getTabledata Exp---" + e);
        } finally {
            if (cur != null) {
                cur.close();
            }
            db.close();
        }
        return strdata;
    }

    private boolean SelectNew(String tblName, String srchCol1,
                              String srchData1, String srchCol2, String srchData2) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cur = null;
        try {
            if (!(srchCol2.trim().equalsIgnoreCase("") && srchData2.trim()
                    .equalsIgnoreCase(""))) {
                cur = db.rawQuery("SELECT * FROM " + tblName + " WHERE("
                        + srchCol1 + "= '" + srchData1 + "' AND " + srchCol2
                        + "= '" + srchData2 + "')", new String[]{});
            } else {
                cur = db.rawQuery("SELECT * FROM " + tblName + " WHERE("
                        + srchCol1 + "= '" + srchData1 + "')", new String[]{});
            }
            int noOfRows = 0;
            if (cur != null) {
                noOfRows = cur.getCount();
            }
            if (noOfRows > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        } finally {
            if (cur != null) {
                cur.close();
            }

        }

    }

    public String insertRegAreaTowTriData(String str_response,
                                          String str_TableName) {
        String str_return = "SUCCESS";
        SQLiteDatabase db = this.getWritableDatabase();

        try {

            ContentValues cv = new ContentValues();
            dynTbName = "TB" + str_TableName;
            if (str_response.equals(CmsInter.PERCENT + CmsInter.PERCENT)) {
                str_return = "error";
                return str_return;
            }
            str_response = str_response.substring(1, str_response.length() - 1);
            if (str_TableName.trim().equals("DWW")) {
                try {
                    db.execSQL("CREATE TABLE "
                            + dynTbName
                            + "(COL0 TEXT, COL1 TEXT, COL2 TEXT, COL3 TEXT, COL4 TEXT, COL5 TEXT)");

                } catch (Exception e) {
                    // System.out.println("insertAllData 1111---Exp--" + e);
                    db.execSQL("DROP TABLE " + dynTbName);
                    System.out.println("insertAllData 2222---Dropped--");
                    db.execSQL("CREATE TABLE "
                            + dynTbName
                            + "(COL0 TEXT, COL1 TEXT, COL2 TEXT, COL3 TEXT, COL4 TEXT, COL5 TEXT)");
                }
            } else if (str_TableName.trim().equals("DVL")) {
                try {
                    db.execSQL("CREATE TABLE " + dynTbName + "(COL0 TEXT)");
                } catch (Exception e) {
                    // System.out.println("insertAllData 1111---Exp--" + e);
                    db.execSQL("DROP TABLE " + dynTbName);
                    System.out.println("insertAllData 2222---Dropped--");
                    db.execSQL("CREATE TABLE " + dynTbName + "(COL0 TEXT)");
                }
            } else {
                try {
                    db.execSQL("CREATE TABLE " + dynTbName
                            + "(COL0 TEXT, COL1 TEXT, COL2 TEXT)");
                } catch (Exception e) {
                    // System.out.println("insertAllData 1111---Exp--" + e);
                    db.execSQL("DROP TABLE " + dynTbName);
                    System.out.println("insertAllData 2222---Dropped--");
                    db.execSQL("CREATE TABLE " + dynTbName
                            + "(COL0 TEXT, COL1 TEXT, COL2 TEXT)");
                }
            }
            String[] str_data = Utility.split(str_response, CmsInter.DOLLAR);
            for (int i = 0; i < str_data.length; i++) {
                if (str_TableName.trim().equals("DWW")) {
                    String str[] = Utility.split(str_data[i], CmsInter.AT);
                    cv.put("COL0", str[0]);
                    cv.put("COL1", str[1]);
                    cv.put("COL2", str[2]);
                    cv.put("COL3", str[3]);
                    cv.put("COL4", str[4]);
                    cv.put("COL5", str[5]);
                } else if (str_TableName.trim().equals("DVL")) {
                    cv.put("COL0", str_data[i].trim());
                } else {
                    String str[] = Utility.split(str_data[i], CmsInter.CAP);
                    cv.put("COL0", str[0]);
                    cv.put("COL1", str[1]);
                    cv.put("COL2", str[2]);
                }
                long rowId = db.insert(dynTbName, null, cv);
                if (rowId == -1) {
                    str_return = "error";
                }
            }
            db.close();
        } catch (Exception e) {
            // Utility.LOG("SetData-setPatchData", e.toString());
            str_return = "ERROR" + e.toString();
        } finally {
            db.close();
        }
        return str_return;
    }

    public String insertAttributeData(String str_response) {
        String str_return = "SUCCESS";
        SQLiteDatabase db = this.getWritableDatabase();
        try {

            ContentValues cv = new ContentValues();
            dynTbName = "TBDAT";
            if (str_response.equals(CmsInter.PERCENT + CmsInter.PERCENT)) {
                str_return = "error";
                return str_return;
            }
            str_response = str_response.substring(1, str_response.length() - 1);
            try {
                db.execSQL("CREATE TABLE "
                        + dynTbName
                        + "(COL0 TEXT, COL1 TEXT, COL2 TEXT, COL3 TEXT, COL4 TEXT, COL5 TEXT)");
            } catch (Exception e) {
                // System.out.println("insertAllData 1111---Exp--" + e);
                db.execSQL("DROP TABLE " + dynTbName);
                System.out.println("insertAllData 2222---Dropped--");
                db.execSQL("CREATE TABLE "
                        + dynTbName
                        + "(COL0 TEXT, COL1 TEXT, COL2 TEXT, COL3 TEXT, COL4 TEXT, COL5 TEXT)");
            }
            String[] str_data = Utility.split(str_response, CmsInter.DOLLAR);
            for (int i = 0; i < str_data.length; i++) {
                cv.put("COL0",
                        str_data[i].substring(0,
                                str_data[i].indexOf(CmsInter.CAP))); // rpt code
                cv.put("COL1", str_data[i].substring(
                        str_data[i].indexOf(CmsInter.CAP) + 1,
                        str_data[i].indexOf(CmsInter.AT)));
                String[] str_valTypeSize = Utility.split(str_data[i]
                                .substring(str_data[i].indexOf(CmsInter.AT) + 1),
                        CmsInter.COMMA);
                cv.put("COL2", str_valTypeSize[0]);
                cv.put("COL3", str_valTypeSize[1]);
                if (str_valTypeSize[2].equals("1")) {
                    str_valTypeSize[2] = "2";
                }
                cv.put("COL4", str_valTypeSize[2]);
                cv.put("COL5", str_valTypeSize[3]);
                long rowId = db.insert(dynTbName, null, cv);
                if (rowId == -1) {
                    str_return = "error";
                }
            }

        } catch (Exception e) {
            // Utility.LOG("SetData-setPatchData", e.toString());
            str_return = "ERROR" + e.toString();
        } finally {
            db.close();
        }
        return str_return;
    }

    public String insertCityData(String str_response) {
        String str_return = "SUCCESS";
        SQLiteDatabase db = this.getWritableDatabase();
        try {

            ContentValues cv = new ContentValues();
            dynTbName = "TBDDD";
            if (str_response.equals(CmsInter.PERCENT + CmsInter.PERCENT)) {
                str_return = "error";
                return str_return;
            }
            str_response = str_response.substring(1, str_response.length() - 1);
            try {
                db.execSQL("CREATE TABLE " + dynTbName
                        + "(COL0 TEXT, COL1 TEXT)");
            } catch (Exception e) {
                // System.out.println("insertAllData 1111---Exp--" + e);
                db.execSQL("DROP TABLE " + dynTbName);
                System.out.println("insertAllData 2222---Dropped--");
                db.execSQL("CREATE TABLE " + dynTbName
                        + "(COL0 TEXT, COL1 TEXT)");
            }
            String[] str_data = Utility.split(str_response, CmsInter.DOLLAR);
            for (int i = 0; i < str_data.length; i++) {
                cv.put("COL0", str_data[0]);
                cv.put("COL1", str_data[1]);
                long rowId = db.insert(dynTbName, null, cv);
                if (rowId == -1) {
                    str_return = "error";
                }
            }

        } catch (Exception e) {
            // Utility.LOG("SetData-setPatchData", e.toString());
            str_return = "ERROR" + e.toString();
        } finally {
            db.close();
        }
        return str_return;
    }

    public String insertCMREditData(String str_response, String str_TableName) {
        String str_return = "SUCCESS";
        SQLiteDatabase db = this.getWritableDatabase();
        try {

            ContentValues cv = new ContentValues();
            dynTbName = "TBDCE";
            if (str_response.equals(CmsInter.PERCENT + CmsInter.PERCENT)) {
                str_return = "error";
                return str_return;
            }

            str_response = str_response.substring(1, str_response.length() - 1);
            String[] splitHash = Utility.split(str_response, "#");
            for (int j = 0; j < splitHash.length; j++) {
                String[] splitAtTheRate = Utility.split(splitHash[j],
                        CmsInter.AT);

                try {
                    db.execSQL("CREATE TABLE "
                            + "DG"
                            + splitAtTheRate[0]
                            + "(COL0 TEXT, COL1 TEXT, COL2 TEXT, COL3 TEXT, COL4 TEXT, COL5 TEXT, COL6 TEXT, COL7 TEXT)");
                } catch (Exception e) {
                    // System.out.println("insertAllData 1111---Exp--" + e);
                    db.execSQL("DROP TABLE " + "DG" + splitAtTheRate[0]);
                    System.out.println("insertAllData 2222---Dropped--");
                    db.execSQL("CREATE TABLE "
                            + "DG"
                            + splitAtTheRate[0]
                            + "(COL0 TEXT, COL1 TEXT, COL2 TEXT, COL3 TEXT, COL4 TEXT, COL5 TEXT, COL6 TEXT, COL7 TEXT)");
                }
                String[] splitDollar = Utility.split(splitAtTheRate[1],
                        CmsInter.DOLLAR);
                for (int i = 0; i < splitDollar.length; i++) {
                    String str[] = Utility.split(splitDollar[i], CmsInter.CAP);
                    cv.put("COL0", str[0]);
                    cv.put("COL1", str[1]);
                    cv.put("COL2", str[2]);
                    cv.put("COL3", str[3]);
                    cv.put("COL4", str[4]);
                    cv.put("COL5", str[5]);
                    cv.put("COL6", str[6]);
                    cv.put("COL7", str[7]);
                    long rowId = db.insert("DG" + splitAtTheRate[0], null, cv);
                    if (rowId == -1) {
                        str_return = "error";
                    }
                }
            }
        } catch (Exception e) {
            // Utility.LOG("SetData-setPatchData", e.toString());
            str_return = "ERROR" + e.toString();
        } finally {
            db.close();
        }
        return str_return;
    }

    public String insertControlNo(String rptCode, String controlNo) {
        String strReturn = "success";
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            db.delete(tbCN, colCNRptCode + "=?", new String[]{rptCode});
            ContentValues cv = new ContentValues();
            cv.put(colCNRptCode, rptCode);
            cv.put(colCNCntrlNo, controlNo);
            long rowId = db.insert(tbCN, null, cv);
            if (rowId == -1) {
                strReturn = "error";
            }
        } catch (Exception e) {
            strReturn = "error";
        } finally {
            db.close();
        }
        return strReturn;
    }

    public String[] getConfigData(String tag) {
        String strTempData = "";
        String strData[] = null;
        String configTable = "TB" + tag;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur = null;
        int noOfRows = 0;
        try {
            cur = db.rawQuery("SELECT " + colCfgID + " as _id, " + colCfgData
                    + " FROM " + configTable + " WHERE(" + colCfgName + " = '"
                    + tag + "')", new String[]{});
            noOfRows = cur.getCount();
            if (tag.equalsIgnoreCase("dms") || tag.equalsIgnoreCase("issue")) {
                if (noOfRows > 0) {
                    cur.moveToFirst();
                    strTempData = cur.getString(1);
                    strData = new String[1];
                    if (tag.equalsIgnoreCase("dms")) {
                        String temp = strTempData.substring(1,
                                strTempData.length() - 1);
                        strData[0] = temp;
                    } else
                        strData[0] = strTempData;
                }
            } else {
                if (noOfRows > 0) {
                    cur.moveToFirst();
                    strTempData = cur.getString(1);
                    strData = Utility.split(strTempData, CmsInter.CAP);
                } else {
                    strData = new String[1];
                    strData[0] = "nodata";
                }
            }

        } catch (Exception e) {
            strData = new String[1];
            strData[0] = "nodata";
        } finally {
            if (cur != null) {
                cur.close();
            }
            db.close();
        }
        return strData;
    }

    public String retriveControlNo(int rptCode) {
        SQLiteDatabase db = this.getWritableDatabase();
        String controlNo = "";
        Cursor cur = null;
        try {
            String query = "SELECT * FROM " + tbCN + " WHERE(" + colCNRptCode
                    + " = " + rptCode + ")";
            cur = db.rawQuery(query, new String[]{});
            int noOfRows = cur.getCount();
            if (noOfRows > 0) {
                cur.moveToFirst();
                controlNo = cur.getString(2);
            }
        } catch (Exception e) {

        } finally {
            if (cur != null) {
                cur.close();
            }
            db.close();
        }
        return controlNo;
    }

    public String[][] getMenuData(int parentCode) {
        SQLiteDatabase db = this.getWritableDatabase();
        String[][] strMenu = null;
        Cursor cur = null;
        try {
            String query = "SELECT " + colMenuID + " as _id, " + colMenuCode
                    + ", " + colMenuName + " FROM " + tbMenu + " WHERE("
                    + colMenuPrntCode + " = " + parentCode + ")" + " ORDER BY "
                    + colMenuSeq;
            System.out.println("in getMenu QUERY---" + query);
            cur = db.rawQuery(query, new String[]{});
            int noOfRows = cur.getCount();
            System.out.println("in getMenu Count---" + noOfRows);
            if (noOfRows > 0) {
                strMenu = new String[noOfRows][2];
                int i = 0;
                while (cur.moveToNext()) {
                    strMenu[i][0] = Integer.toString(cur.getInt(1));
                    strMenu[i][1] = cur.getString(2);
                    i++;
                }
            }
        } catch (Exception e) {
            System.out.println("in getMenu Exp---" + e);
        } finally {
            if (cur != null) {

                cur.close();
            }
            db.close();
        }
        return strMenu;
    }

    public String[][] getTableData(String tb_name, int no_of_Colums,
                                   String whreclause, String orderBy) {
        SQLiteDatabase db = this.getWritableDatabase();
        String[][] strdata = null;
        // String whreclause = "";
        Cursor cur = null;
        try {
            String query = "SELECT * FROM " + "\"TB" + tb_name + "\"" + " "
                    + whreclause + " " + orderBy;
            // System.out.println("in getPatch QUERY---" + query);
            cur = db.rawQuery(query, new String[]{});
            int noOfRows = cur.getCount();
            // System.out.println("in getParty Count---" + noOfRows);
            if (noOfRows > 0) {
                strdata = new String[noOfRows][no_of_Colums];
                int i = 0;
                while (cur.moveToNext()) {
                    for (int j = 0; j < no_of_Colums; j++) {
                        strdata[i][j] = cur.getString(j);
                    }
                    i++;
                }
            }

        } catch (Exception e) {
            System.out.println("in getTabledata Exp---" + e);
        } finally {
            if (cur != null) {
                cur.close();
            }
            db.close();
        }
        return strdata;
    }

    public String[][] getJoinTableData(String tb_name1, String tb_name2) {
        SQLiteDatabase db = this.getWritableDatabase();
        String[][] strRec = null;
        Cursor cur = null;
        int noOfRows = 0;
        String query = "";
        Boolean btntable1 = TableExist(tb_name1);
        Boolean btntable2 = TableExist(tb_name2);
        try {
            if (btntable2) {
                query = "SELECT p, q, CQTY FROM"
                        + "(select x.COL0 p , x.COL1 q,y.COL2 CQTY, 0 ORD_SEQ from "
                        + tb_name1 + "  x left outer join  " + tb_name2
                        + " y on  x.COL0 = y.COL0 ORDER BY 3 DESC)";
                // System.out.println("in skudata QUERY---" + query);
                cur = db.rawQuery(query, new String[]{});
                if (cur != null) {
                    noOfRows = cur.getCount();
                    if (noOfRows > 0) {
                        strRec = new String[noOfRows][3];
                        int i = 0;
                        while (cur.moveToNext()) {
                            strRec[i][0] = cur.getString(0);
                            strRec[i][1] = cur.getString(1);
                            if (cur.getString(2) != null) {
                                strRec[i][2] = cur.getString(2);
                            } else {
                                strRec[i][2] = "";
                            }
                            i++;
                        }
                    } else {
                        query = "SELECT * FROM " + tb_name1;
                        cur = db.rawQuery(query, new String[]{});
                        noOfRows = cur.getCount();
                        if (noOfRows > 0) {
                            strRec = new String[noOfRows][3];
                            int i = 0;
                            while (cur.moveToNext()) {
                                strRec[i][0] = cur.getString(0);
                                strRec[i][1] = cur.getString(1);
                                strRec[i][2] = "";
                                i++;
                            }
                        }
                    }
                }
            } else {
                query = "SELECT * FROM " + tb_name1;
                cur = db.rawQuery(query, new String[]{});
                noOfRows = cur.getCount();
                if (noOfRows > 0) {
                    strRec = new String[noOfRows][3];
                    int i = 0;
                    while (cur.moveToNext()) {
                        strRec[i][0] = cur.getString(0);
                        strRec[i][1] = cur.getString(1);
                        strRec[i][2] = "";
                        i++;
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("in getParty Exp---" + e);
        } finally {
            if (cur != null) {
                cur.close();
            }
            db.close();
        }
        return strRec;
    }

    public String[][] getJoinTableBrandData(String tb_name1, String tb_name2,
                                            String tb_name3, String PCode) {
        SQLiteDatabase db = this.getWritableDatabase();
        String[][] strRec = null;
        Cursor cur = null;
        int noOfRows = 0;
        String query = "";
        String query1 = "";
        ArrayList strVerticalHeader = null;
        ArrayList strCodeVerticalHeader = null;
        Boolean btntable2 = TableExist(tb_name2);
        try {
            if (btntable2) {
                // query = "SELECT brandCode, brandName FROM"
                // +
                // "(select x.COL0 brandCode,x.COL1 brandName,y.COL0 pcode from "
                // + tb_name1 + " x left outer join  " + tb_name2
                // + " y  on  x.COL0 = y.COL1  AND y.COL0 ='" + PCode
                // + "' " + " ORDER BY y.COL0 desc)";
                strVerticalHeader = new ArrayList<String[]>();

                query = "select col0,col1,1 a from "
                        + tb_name1
                        + "  x where exists (select 1 from  "
                        + tb_name3
                        + "  y where y.col4 = '"
                        + PCode
                        + "'  and y.col6=x.col0)"
                        + " union "
                        + "select col0,col1,2 a from  "
                        + tb_name1
                        + "   x where exists (select 1 from  "
                        + tb_name2
                        + "  y where y.col0 ='"
                        + PCode
                        + "'  and y.col1 =x.col0) AND not exists  (select 1 from  "
                        + tb_name3
                        + "  z where z.col4 == '"
                        + PCode
                        + "'  and z.col6=x.col0)"
                        + " UNION "
                        + "select col0,col1,3 a from "
                        + tb_name1
                        + "  x where not exists (select 1 from  "
                        + tb_name2
                        + "  y where y.col0 ='"
                        + PCode
                        + "'  and y.col1 =x.col0) AND not exists  (select 1 from "
                        + tb_name3 + "  z where z.col4 = '" + PCode
                        + "'  and z.col6=x.col0) order by 3";

                // query = "select col0, col1 from " + tb_name1
                // + " x where exists (select 1 from " + tb_name2
                // + " y where y.col0 = '" + PCode
                // + "' AND y.col1 = x.col0)";
                // query1 = "select col0, col1 from " + tb_name1
                // + " x where not exists (select 1 from " + tb_name2
                // + " y where y.col0 = '" + PCode
                // + "' AND y.col1 = x.col0)";

                // query =
                // "select col0, col1 from( select 1 seq ,col0, col1 from "
                // + tb_name1
                // + " x where exists (select 1 from "
                // + tb_name2
                // + " y where y.col0 = '"
                // + PCode
                // +
                // "' AND y.col1 = x.col0) union all select 2 seq,col0, col1 from "
                // + tb_name1 + " x where not exists (select 1 from "
                // + tb_name2 + " y where y.col0 = '" + PCode
                // + "' AND y.col1 = x.col0)) order by seq";
                System.out.println("in joinTable QUERY---" + query);
                cur = db.rawQuery(query, new String[]{});
                if (cur != null) {
                    noOfRows = cur.getCount();
                    if (noOfRows > 0) {
                        while (cur.moveToNext()) {
                            String val1 = cur.getString(0);
                            String val2 = cur.getString(1);
                            strVerticalHeader.add(new String[]{val1, val2});
                            // strVerticalHeader.add(cur.getString(1));

                        }
                    }
                }
                // cur = db.rawQuery(query1, new String[] {});
                // if (cur != null) {
                // noOfRows = cur.getCount();
                // if (noOfRows > 0) {
                // strRec = new String[noOfRows][2];
                // while (cur.moveToNext()) {
                // String val1 = cur.getString(0);
                // String val2 = cur.getString(1);
                // strVerticalHeader.add(new String[] { val1, val2 });
                // }
                // }
                // }
                strRec = new String[strVerticalHeader.size()][2];
                for (int i = 0; i < strVerticalHeader.size(); i++) {
                    String str[] = (String[]) strVerticalHeader.get(i);
                    strRec[i][0] = str[0];
                    strRec[i][1] = str[1];
                }
            } else {
                query = "SELECT * FROM " + tb_name1;
                cur = db.rawQuery(query, new String[]{});
                noOfRows = cur.getCount();
                if (noOfRows > 0) {
                    strRec = new String[noOfRows][2];
                    int i = 0;
                    while (cur.moveToNext()) {
                        strRec[i][0] = cur.getString(0);
                        strRec[i][1] = cur.getString(1);
                        i++;
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("in getjointableBrandData Exp---" + e);
        } finally {
            if (cur != null) {
                cur.close();
            }
            db.close();
        }
        return strRec;
    }

    public boolean TableExist(String tb_name) {
        boolean bln_return = false;
        Cursor cur = null;
        SQLiteDatabase db = ReadWriteData.this.getWritableDatabase();
        try {
            String query = "select name from sqlite_master where type = 'table'";
            cur = db.rawQuery(query, new String[]{});
            if (cur.getCount() > 0) {
                while (cur.moveToNext()) {
                    if (cur.getString(0).equals(tb_name)) {
                        // System.out.println("cur.getString(0)  "
                        // + cur.getString(0) + "  filter    "
                        // + Filter);
                        bln_return = true;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("exception in TableExist------->" + e);
        } finally {
            if (cur != null) {
                cur.close();
            }
            return bln_return;
        }
    }

    // public String getPatchName(String Patchcode) {
    // SQLiteDatabase db = ReadWriteData.this.getWritableDatabase();
    // String str_return = "";
    // Cursor cur = null;
    // try {
    // Patchcode = Patchcode.substring(2, Patchcode.length());
    // String query = "SELECT * FROM " + tbDPL;
    // System.out.println("in getPatchName QUERY---" + query);
    // cur = db.rawQuery(query, new String[] {});
    // int noOfRows = cur.getCount();
    // System.out.println("in getParty Count---" + noOfRows);
    // if (noOfRows > 0) {
    // int i = 0;
    // while (cur.moveToNext()) {
    // if (Patchcode.trim().equals(cur.getString(0))) {
    // str_return = cur.getString(1);
    // break;
    // }
    // }
    // }
    // } catch (Exception e) {
    // System.out.println("in getPatchName Exp---" + e);
    // } finally {
    // if (cur != null) {
    // cur.close();
    // }
    // db.close();
    // return str_return;
    // }
    // }

    public String[][] getpartyData(String tb_name) {
        SQLiteDatabase db = this.getWritableDatabase();
        String[][] strParty = null;
        String whreclause = "";
        Cursor cur = null;
        try {
            String query = "SELECT COL0, COL1, COL2,COL3,COL4,COL5 FROM "
                    + "TB" + tb_name + whreclause + " ORDER BY COL1";
            System.out.println("in getPatch QUERY---" + query);
            cur = db.rawQuery(query, new String[]{});
            int noOfRows = cur.getCount();
            System.out.println("in getParty Count---" + noOfRows);
            if (noOfRows > 0) {
                strParty = new String[noOfRows][6];
                int i = 0;
                while (cur.moveToNext()) {
                    strParty[i][0] = cur.getString(0);
                    strParty[i][1] = cur.getString(1);
                    strParty[i][2] = cur.getString(2);
                    strParty[i][3] = cur.getString(3);
                    strParty[i][4] = cur.getString(4);
                    strParty[i][5] = cur.getString(5);
                    i++;
                }
            }

        } catch (Exception e) {
            System.out.println("in getParty Exp---" + e);
        } finally {
            if (cur != null) {
                cur.close();
            }
            db.close();
        }
        return strParty;
    }

    public String[][] getAllData(String tagName, String code, int col0, int col1) {
        String strData[][] = null;
        SQLiteDatabase db = this.getWritableDatabase();
        String tableName = "TB" + tagName;
        String query = "SELECT * FROM " + tableName;
        Cursor cur = null;
        try {
            cur = db.rawQuery(query, new String[]{});
            int noOfRows = cur.getCount();
            if (noOfRows > 0) {
                if (code.trim().equalsIgnoreCase("none")) {
                    strData = new String[noOfRows + 1][2];
                } else {
                    strData = new String[noOfRows][2];
                }
                int count = 0;
                if (code.trim().equalsIgnoreCase("none")) {
                    strData[count][0] = "0";
                    strData[count][1] = "None";
                    count++;
                }
                while (cur.moveToNext()) {
                    strData[count][0] = cur.getString(col0);
                    strData[count][1] = cur.getString(col1);
                    count++;
                }
            }
        } catch (Exception e) {
            System.out.println("In getallData block------->" + e);
        } finally {
            if (cur != null) {
                cur.close();
            }
            db.close();
        }
        return strData;
    }

    public String deleteTable(int deleteType) {
        String str_res = "SUCCESS";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cur = null;
        try {
            String query = "select name from sqlite_master where type = 'table'";
            cur = db.rawQuery(query, new String[]{});
            while (cur.moveToNext()) {
                try {
                    switch (deleteType) {
                        case 1:
                            if (!(cur.getString(0).equals("TBUPW")
                                    || cur.getString(0).equals("TBCVR") || cur
                                    .getString(0).equals("TBCNTRLNO"))) {
                                db.execSQL("DROP TABLE " + cur.getString(0));
                            }
                            break;
                        case 2:
                            if (cur.getString(0).toLowerCase().startsWith("txn")) {
                                // db.execSQL("DROP TABLE " + cur.getString(0));
                                db.delete(cur.getString(0), null, new String[]{});
                            }
                            break;
                        case 3:
                            if (cur.getString(0).startsWith("T")
                                    || cur.getString(0).startsWith("OP")
                                    || cur.getString(0).startsWith("FB")
                                    || cur.getString(0).startsWith("CP")) {
                                db.execSQL("DROP TABLE " + cur.getString(0));
                            }
                            break;
                        case 4:
                            if (cur.getString(0).startsWith("TBPLAN")) {
                                db.execSQL("DROP TABLE " + cur.getString(0));
                            }
                            break;

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    str_res = "ERROR  " + cur.getString(0) + "--ex--" + e;
                }

            }
        } catch (Exception e) {
            str_res = "ERROR " + e;
        } finally {
            if (cur != null) {
                cur.close();
            }
            db.close();
            System.gc();
        }

        return str_res;

    }

    public boolean isRecords(String tb_name, String colName) {
        boolean isrecord = false;
        SQLiteDatabase db = ReadWriteData.this.getWritableDatabase();
        Cursor cur = null;
        try {
            String query = "SELECT " + colName + " FROM " + "TB" + tb_name;
            cur = db.rawQuery(query, new String[]{});
            int noOfRows = cur.getCount();
            if (noOfRows > 0) {
                isrecord = true;
            }
        } catch (Exception e) {
            System.out.println("in isrecord---" + e);
        } finally {
            if (cur != null) {
                cur.close();
            }
            db.close();
            System.gc();
        }
        return isrecord;
    }

    // public String[][] getTownData(String tagName, String code) {
    // String strData[][] = null;
    // SQLiteDatabase db = this.getWritableDatabase();
    // Cursor cur = null;
    // try {
    // String tableName = "TB" + tagName;
    // String query = "SELECT * FROM " + tableName;
    // cur = db.rawQuery(query, new String[] {});
    // int noOfRows = cur.getCount();
    // if (noOfRows > 0) {
    // strData = new String[noOfRows][3];
    // int count = 0;
    // while (cur.moveToNext()) {
    // strData[count][0] = cur.getString(0);
    // strData[count][1] = cur.getString(1);
    // strData[count][2] = cur.getString(2);
    // count++;
    // }
    //
    // }
    //
    // } catch (Exception e) {
    // // TODO: handle exception
    // System.out.println("in getAlldata Exp---" + e);
    // } finally {
    // if (cur != null) {
    // cur.close();
    // }
    // db.close();
    // }
    // return strData;
    // }

    public String insertTxnData(String req, String controlNo, String rptCode) {
        String strReturn = "success";
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues cv = new ContentValues();
            cv.put(colTxnRptCode, rptCode);
            cv.put(colTxnCntrlNo, controlNo);
            cv.put(colTxnData, req);
            long rowId = db.insert(CmsInter.TXNDETAILINGDATA, null, cv);
            if (rowId == -1) {
                strReturn = "error";
            }
        } catch (Exception e) {
            strReturn = "error";
        }
        db.close();
        return strReturn;
    }

    public String[][] getTxnData() {
        String[][] strData = null;
        SQLiteDatabase db = this.getWritableDatabase();
        try {

            String query = "SELECT * FROM " + CmsInter.TXNDETAILINGDATA
                    + " WHERE TXNCOL7= '0'";
            Cursor cur = db.rawQuery(query, new String[]{});
            int noOfRows = cur.getCount();
            if (noOfRows > 0) {
                // cur.moveToFirst();
                strData = new String[noOfRows][2];
                int count = 0;
                while (cur.moveToNext()) {
                    strData[count][0] = cur.getString(1);
                    strData[count][1] = cur.getString(2);
                    count++;
                }
            }
            cur.close();
        } catch (Exception e) {
            System.out.println("Exp in getTxn---" + e);
        }
        db.close();
        return strData;
    }

    public String deleteTxnData(String controlNo) {
        String strReturn = "success";
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            int deletedNoOfRow = db.delete(CmsInter.TXNDETAILINGDATA,
                    colTxnCntrlNo + "=?", new String[]{controlNo});
            if (deletedNoOfRow == 0) {
                strReturn = "error";
            }
        } catch (Exception e) {
            strReturn = "error";
        }
        db.close();
        return strReturn;
    }

    private void clearRecordr(String rpt_code, String cntl_no, String rms_Name) {
        // TODO Auto-generated method stub
        SQLiteDatabase db = ReadWriteData.this.getWritableDatabase();
        String reportCode = rpt_code;
        String ControlNumber = cntl_no;
        String RMS = rms_Name;
        Cursor cur = null;
        try {
            String query = "SELECT * FROM " + rms_Name;
            cur = db.rawQuery(query, new String[]{});
            int noOfRows = 0;
            if (cur != null) {
                noOfRows = cur.getCount();
            }
            if (noOfRows > 0) {
                String where = "TXNCOL0 = ? AND TXNCOL1 = ? ";
                String[] whereArgs = {reportCode, ControlNumber};
                int result = db.delete(RMS, where, whereArgs);
                if (result > 0) {
                    System.out.println("result for------->" + reportCode + "/"
                            + cntl_no);
                }
            }
        } catch (Exception e) {
            // LOG("Utility-deleteRec",e.toString());
            System.out.println("Error in  clearRecordr---->" + e.toString());
        } finally {
            if (cur != null) {
                cur.close();
            }
        }
    }

    public String insertAllDataNew(String tag, String response) {
        String strReturn = "success";
        SQLiteDatabase db = this.getWritableDatabase();
        dynTbName = "TB" + tag;
        try {
            if (response.equals(CmsInter.PERCENT + CmsInter.PERCENT)) {
                response = "error";
                return response;
            }
            if (response.startsWith(CmsInter.PERCENT)
                    && response.endsWith(CmsInter.PERCENT)) {
                response = response.substring(1, response.length() - 1);
            }
            String[] str_data = Utility.split(response, CmsInter.DOLLAR);
            ContentValues cv = new ContentValues();
            Filter = dynTbName;
            blTableExists = TableExist(Filter);
            StringBuffer query = new StringBuffer();
            query.append("CREATE TABLE " + dynTbName + "(");
            int length = 0;
            for (int i = 0; i < str_data[0].length(); i++) {
                if (new String("" + str_data[0].charAt(i))
                        .equalsIgnoreCase(CmsInter.AT)) {
                    length++;
                }
            }
            for (int i = 0; i < length; i++) {
                if (i == length - 1) {
                    query.append("COL" + i + " TEXT)");
                } else {
                    query.append("COL" + i + " TEXT, ");
                }
            }
            if (!blTableExists) {
                db.execSQL(query.toString());
            } else {
                db.execSQL("DROP TABLE " + dynTbName);
                db.execSQL(query.toString());
            }
            for (int i = 0; i < str_data.length; i++) {
                String str_check = "";
                String str[] = Utility.split(str_data[i], CmsInter.AT);
                str_check = str[str.length - 1].trim();
                if (str_check.equalsIgnoreCase("N")
                        || str_check.equalsIgnoreCase("U")) {
                    for (int j = 0; j < str.length - 1; j++) {
                        cv.put("COL" + j, str[j].trim());
                    }
                }

                long rowId = -1;
                String[] whereArgs = new String[1];

                if (str_check.equalsIgnoreCase("N")) {
                    boolean check_data;
                    if (tag.trim().startsWith("MBM")) {
                        check_data = SelectNew(dynTbName, "COL2", str[0].trim()
                                .toString(), "", "");
                    } else {
                        check_data = SelectNew(dynTbName, "COL0", str[0].trim()
                                .toString(), "", "");
                    }
                    if (!check_data) {
                        rowId = db.insert(dynTbName, null, cv);
                    } else {
                        whereArgs[0] = str[0].trim().toString();
                        rowId = db.update(dynTbName, cv, "COL0=?", whereArgs);
                    }

                } else if (str_check.equalsIgnoreCase("U")) {
                    whereArgs[0] = str[0].trim().toString();
                    rowId = db.update(dynTbName, cv, "COL0=?", whereArgs);
                } else if (str_check.equalsIgnoreCase("D")) {
                    whereArgs[0] = str[0].trim().toString();
                    rowId = db.delete(dynTbName, "COL0=?", whereArgs);
                }

                if (rowId == -1) {
                    strReturn = "error";
                    System.out
                            .println("error in " + tag + "--No data inserted");
                }
            }
            blTableExists = false;
        } catch (Exception e) {
            strReturn = "error";
            System.out.println("error in " + tag + "--" + e);
        } finally {
            db.close();
        }
        return strReturn;
    }

    public String getColor(String code) {
        String strTempData = "";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cur = null;
        try {
            cur = db.rawQuery("SELECT * FROM  TBDCO" + " WHERE(" + "COL0 = '"
                    + code + "')", new String[]{});
            int noOfRows = cur.getCount();
            while (cur.moveToNext()) {
                strTempData = cur.getString(1);
            }

        } catch (Exception e) {
        } finally {
            if (cur != null) {
                cur.close();
            }
            db.close();
        }
        return strTempData;
    }

    public String makeVirtualTables(String rptCode, String screenCode,
                                    String[] vheadercode, String[] hhorizontalcode, String[][] data) {
        SQLiteDatabase db = this.getWritableDatabase();
        String strReturn = "success";
        try {
            String tblName = "";
            tblName = "VW" + CmsInter.UNDERSCORE + rptCode
                    + CmsInter.UNDERSCORE + screenCode;

            int noOfCols = hhorizontalcode.length;
            String strColNames = "";
            for (int j = 0; j < noOfCols; j++) {
                strColNames = strColNames + hhorizontalcode[j] + " TEXT,";
            }
            strColNames = strColNames.substring(0, strColNames.length() - 1);
            String strQuery = "CREATE TABLE IF NOT EXISTS " + tblName + "("
                    + colDataID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + strColNames + ") ";
            try {
                db.execSQL(strQuery);
            } catch (Exception e) {
                db.execSQL("DROP TABLE " + tblName);
                db.execSQL(strQuery);
            }
            ContentValues cv = new ContentValues();

            int x = 0;
            for (int i = 0; i < hhorizontalcode.length; i++) {
                if (i == 0) {
                    cv.put(hhorizontalcode[i], vheadercode[x]);
                    x++;
                } else {
                    cv.put(hhorizontalcode[i], data[x - 1][i - 1]);
                }
            }
            long rowId = db.insert(tblName, null, cv);
            if (rowId == -1) {
                strReturn = "error";
            }

        } catch (Exception e) {
            strReturn = "error";
        } finally {
            db.close();
        }
        return strReturn;
    }

    public Vector getVirtualData(String rptCode, String screenCode) {
        String strData[][] = null;
        SQLiteDatabase db = this.getWritableDatabase();
        String tableName = "VW" + CmsInter.UNDERSCORE + rptCode
                + CmsInter.UNDERSCORE + screenCode;
        String query = "SELECT * FROM " + tableName;
        String ColQuery = "pragma table_info(" + tableName + ")";
        Cursor cur0 = null;
        Cursor cur1 = null;
        String[] ColData = null;
        Vector VirtualData = new Vector();
        try {
            cur0 = db.rawQuery(ColQuery, new String[]{});
            int count = 0;
            int noOfCol = cur0.getCount();
            ColData = new String[noOfCol];
            if (noOfCol > 0) {
                while (cur1.moveToNext()) {
                    ColData[count] = cur1.getString(1);
                    count++;
                }
            }
            VirtualData.addElement(ColData);

            cur1 = db.rawQuery(query, new String[]{});
            int noOfRows = cur1.getCount();
            strData = new String[noOfRows][noOfCol];

            if (noOfRows > 0) {
                count = 0;
                while (cur1.moveToNext()) {
                    for (int j = 0; j < noOfCol; j++) {
                        strData[count][j] = cur1.getString(j + 1);
                    }
                    count++;
                }
            }
            VirtualData.addElement(strData);
        } catch (Exception e) {
            System.out.println("In getAllVirtualData block------->" + e);
        } finally {
            if (cur1 != null) {
                cur1.close();
            }
            if (cur0 != null) {
                cur0.close();
            }
            db.close();
        }
        return VirtualData;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public Vector getPcpData(String rptCode, int FormatSet) {
        Vector txnData = new Vector();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cur = null;
        String[] beforeTild = null;
        String[] afterTild = null;
        int whereCount = 0;
        String[] attCode = null;
        String[] brCode = null;
        String[] val = null;
        try {
            String query = "SELECT * FROM TBPCP WHERE COL0 = '" + rptCode + "'";
            cur = db.rawQuery(query, new String[]{});
            int noOfRows = cur.getCount();
            if (noOfRows > 0) {
                afterTild = new String[1];
                while (cur.moveToNext()) {
                    afterTild[0] = cur.getString(1);
                }
            }
        } catch (Exception e) {
            System.out.println("Exp in getTxn---" + e);
        } finally {
            if (cur != null) {
                cur.close();
            }
            db.close();
        }
        switch (FormatSet) {
            case 0:// get FormData
                // Assuming only one data found.
                txnData.add(Utility.split(afterTild[0], CmsInter.CAP));
                break;
            case 1:// get GridData
                // Assuming only one data found.
                String afterString[] = Utility.split(afterTild[0], CmsInter.CAP);
                attCode = new String[afterString.length];
                brCode = new String[afterString.length];
                val = new String[afterString.length];
                int ct = 0;
                for (int i = 0; i < afterString.length; i++) {
                    if (afterString[i].contains(CmsInter.UNCOMMA)) {
                        String afterData[] = Utility.split(afterString[i],
                                CmsInter.UNCOMMA);
                        attCode[ct] = afterData[0];
                        brCode[ct] = afterData[1];
                        val[ct] = afterData[2];
                        ct++;
                    }
                }
                txnData.add(attCode);
                txnData.add(brCode);
                txnData.add(val);
                break;
        }

        return txnData;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public Vector getTxnData(String rptCode, String ctrlNo, String pCode,
                             String pName, String txnDate, int FormatSet) {
        Vector txnData = new Vector();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cur = null;
        String[] beforeTild = null;
        String[] afterTild = null;
        int whereCount = 0;
        String[] attCode = null;
        String[] brCode = null;
        String[] val = null;
        try {
            String query = "SELECT * FROM " + CmsInter.TXNDETAILINGDATA;
            if (rptCode.trim().length() != 0 || ctrlNo.trim().length() != 0
                    || pCode.trim().length() != 0 || pName.trim().length() != 0
                    || txnDate.trim().length() != 0) {
                query = query + " WHERE ";
                if (rptCode.trim().length() != 0) {
                    query = query + "TXNCOL2 = '" + rptCode + "'";
                    whereCount++;
                }
                if (ctrlNo.trim().length() != 0) {
                    if (whereCount != 0) {
                        query = query + " AND ";
                    }
                    query = query + "TXNCOL3 = '" + ctrlNo + "'";
                    whereCount++;
                }
                if (pCode.trim().length() != 0) {
                    if (whereCount != 0) {
                        query = query + " AND ";
                    }
                    query = query + "TXNCOL4 = '" + pCode + "'";
                    whereCount++;
                }
                if (pName.trim().length() != 0) {
                    if (whereCount != 0) {
                        query = query + " AND ";
                    }
                    query = query + "TXNCOL5 = '" + pName + "'";
                    whereCount++;
                }
                if (txnDate.trim().length() != 0) {
                    if (whereCount != 0) {
                        query = query + " AND ";
                    }
                    query = query + "TXNCOL6 = '" + txnDate + "'";
                    whereCount++;
                }
            }
            cur = db.rawQuery(query, new String[]{});
            int noOfRows = cur.getCount();
            if (noOfRows > 0) {
                // cur.moveToFirst();
                beforeTild = new String[noOfRows];
                afterTild = new String[noOfRows];
                int count = 0;
                while (cur.moveToNext()) {
                    beforeTild[count] = cur.getString(1);
                    afterTild[count] = cur.getString(2);
                    count++;
                }
            }
        } catch (Exception e) {
            System.out.println("Exp in getTxn---" + e);
        } finally {
            if (cur != null) {
                cur.close();
            }
            db.close();
        }

        if (beforeTild == null || beforeTild.length == 0 || afterTild == null
                || afterTild.length == 0) {
            return txnData;// Returns null vector if no data
        }

        switch (FormatSet) {
            case 0:// get FormData
                // Assuming only one data found.
                txnData.add(Utility.split(beforeTild[0], CmsInter.CAP));
                txnData.add(Utility.split(afterTild[0], CmsInter.CAP));
                break;
            case 1:// get GridData
                // Assuming only one data found.
                txnData.add(Utility.split(beforeTild[0], CmsInter.CAP));
                String afterString[] = Utility.split(afterTild[0], CmsInter.CAP);
                attCode = new String[afterString.length];
                brCode = new String[afterString.length];
                val = new String[afterString.length];
                int ct = 0;
                for (int i = 0; i < afterString.length; i++) {
                    if (afterString[i].contains(CmsInter.UNCOMMA)) {
                        String afterData[] = Utility.split(afterString[i],
                                CmsInter.UNCOMMA);
                        attCode[ct] = afterData[0];
                        brCode[ct] = afterData[1];
                        val[ct] = afterData[2];
                        ct++;
                    }
                }
                txnData.add(attCode);
                txnData.add(brCode);
                txnData.add(val);
                break;
        }

        return txnData;
    }

    public String insertMsgData(String str_response, String flag) {
        String str_return = "SUCCESS";
        SQLiteDatabase db = this.getWritableDatabase();
        try {

            ContentValues cv = new ContentValues();
            dynTbName = tbMSGDATA;
            if (str_response.equals(CmsInter.PERCENT + CmsInter.PERCENT)) {
                str_return = "error";
                return str_return;
            }
            str_response = str_response.substring(1, str_response.length() - 1);
            try {
                cv.put("COL1", flag);
                cv.put("COL2", str_response);

                long rowId = db.insert(dynTbName, null, cv);
                if (rowId == -1) {
                    str_return = "ERROR";
                }
            } catch (Exception e) {
                str_return = "ERROR" + e.toString();
                db.execSQL("CREATE TABLE " + tbMSGDATA + "(" + colmsgID
                        + " INTEGER PRIMARY KEY AUTOINCREMENT, " + colmsgName
                        + " TEXT, " + colmsgData + " CLOB)");
            }
        } finally {
            db.close();
        }
        return str_return;
    }

    public String deleteMsgData(String id) {
        String strReturn = "success";
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            int deletedNoOfRow = db.delete(tbMSGDATA, colMsgID + "=?",
                    new String[]{id});
            if (deletedNoOfRow == 0) {
                strReturn = "error";
            }
        } catch (Exception e) {
            strReturn = "error";
        }
        db.close();
        return strReturn;
    }

    public String insertContentData(String tag, String response) {
        String strReturn = "success";
        SQLiteDatabase db = this.getWritableDatabase();
        Vector<String> vec = new Vector<String>();
        String str[];
        ContentValues cv = new ContentValues();
        if (response.equals(CmsInter.PERCENT + CmsInter.PERCENT)) {
            strReturn = "error";
            return strReturn;
        }
        response = response.substring(1, response.length() - 1);
        try {
            dynTbName = "TB" + tag;

            // for (int i = 0; i < str_data.length; i++) {
            // str = Utility.split(str_data[i], CmsInter.AT);
            // if (!(vec.contains(str[7]))) {
            // vec.add(str[7]);
            // }
            // }
            // str = new String[vec.size()];
            // vec.copyInto(str);
            // try {
            // db.delete(dynTbName, "COL7 = ?", str);
            // } catch (Exception e) {
            // // TODO: handle exception
            // }
            if (tag.startsWith("DVC")) {
                try {
                    db.execSQL("CREATE TABLE "
                            + dynTbName
                            + "(COL0 TEXT, COL1 TEXT, COL2 TEXT, COL3 TEXT, COL4 TEXT, COL5 TEXT, COL6 TEXT, COL7 TEXT, COL8 TEXT, COL9 TEXT, COL10 TEXT)");

                } catch (Exception e) {
                    // System.out.println("insertAllData 1111---Exp--" + e);
                    db.execSQL("DROP TABLE " + dynTbName);
                    // System.out.println("insertAllData 2222---Dropped--");
                    db.execSQL("CREATE TABLE "
                            + dynTbName
                            + "(COL0 TEXT, COL1 TEXT, COL2 TEXT, COL3 TEXT, COL4 TEXT, COL5 TEXT, COL6 TEXT, COL7 TEXT, COL8 TEXT, COL9 TEXT, COL10 TEXT)");

                }

                String[] str_data = Utility.split(response, CmsInter.DOLLAR);
                for (int i = 0; i < str_data.length; i++) {
                    str = Utility.split(str_data[i], CmsInter.AT);
                    cv.put("COL0", str[0].trim());
                    cv.put("COL1", str[1].trim());
                    cv.put("COL2", str[2].trim());
                    cv.put("COL3", str[3].trim());
                    cv.put("COL4", str[4].trim());
                    cv.put("COL5", str[5].trim());
                    cv.put("COL6", str[6].trim());
                    cv.put("COL7", str[7].trim());
                    cv.put("COL8", str[8].trim());
                    cv.put("COL9", str[9].trim());
                    cv.put("COL10", str[10].trim());
                    long rowId = db.insert(dynTbName, null, cv);

                }
            } else if (tag.startsWith("DPC")) {
                try {
                    db.execSQL("CREATE TABLE "
                            + dynTbName
                            + "(COL0 TEXT, COL1 TEXT, COL2 TEXT, COL3 TEXT, COL4 TEXT, COL5 TEXT, COL6 TEXT, COL7 TEXT, COL8 TEXT, COL9 TEXT, COL10 TEXT, COL11 TEXT)");

                } catch (Exception e) {
                    // System.out.println("insertAllData 1111---Exp--" + e);
                    db.execSQL("DROP TABLE " + dynTbName);
                    // System.out.println("insertAllData 2222---Dropped--");
                    db.execSQL("CREATE TABLE "
                            + dynTbName
                            + "(COL0 TEXT, COL1 TEXT, COL2 TEXT, COL3 TEXT, COL4 TEXT, COL5 TEXT, COL6 TEXT, COL7 TEXT, COL8 TEXT, COL9 TEXT, COL10 TEXT, COL11 TEXT)");

                }
                String[] str_data = Utility.split(response, CmsInter.DOLLAR);
                for (int i = 0; i < str_data.length; i++) {
                    str = Utility.split(str_data[i], CmsInter.AT);
                    cv.put("COL0", str[0].trim());
                    cv.put("COL1", str[1].trim());
                    cv.put("COL2", str[2].trim());
                    cv.put("COL3", str[3].trim());
                    cv.put("COL4", str[4].trim());
                    cv.put("COL5", str[5].trim());
                    cv.put("COL6", str[6].trim());
                    cv.put("COL7", str[7].trim());
                    cv.put("COL8", str[8].trim());
                    cv.put("COL9", str[9].trim());
                    cv.put("COL10", str[10].trim());
                    cv.put("COL11", str[11].trim());
                    long rowId = db.insert(dynTbName, null, cv);
                }

            }

        } catch (Exception e) {
            strReturn = "error";
            System.out.println("error in " + tag + "--" + e);
        } finally {
            db.close();
        }
        return strReturn;
    }

    public String insertDAVData(String tag, String response, Context context) {
        String strReturn = "success";
        SQLiteDatabase db = this.getWritableDatabase();
        Vector<String> vec = new Vector<String>();
        String str[];
        ContentValues cv = new ContentValues();
        try {
            dynTbName = "TB" + tag;
            String[] str_data = Utility.split(response, CmsInter.DOLLAR);
            for (int i = 0; i < str_data.length - 1; i++) {
                str = Utility.split(str_data[i], CmsInter.AT);
                if (!(vec.contains(str[7]))) {
                    vec.add(str[7]);
                }
            }
            str = new String[vec.size()];
            vec.copyInto(str);
            try {
                db.delete(dynTbName, "COL7 = ?", str);
            } catch (Exception e) {
                // TODO: handle exception
            }
            for (int i = 0; i < str_data.length - 1; i++) {
                str = Utility.split(str_data[i], CmsInter.AT);
                cv.put("COL0", str[0].trim());
                cv.put("COL1", str[1].trim());
                cv.put("COL2", str[2].trim());
                cv.put("COL3", str[3].trim());
                cv.put("COL4", str[4].trim());
                cv.put("COL5", str[5].trim());
                cv.put("COL6", str[6].trim());
                cv.put("COL7", str[7].trim());
                cv.put("COL8", str[8].trim());
                cv.put("COL9", str[9].trim());
                if ((str[9].trim().equalsIgnoreCase("D"))) {
                    String filename = str[1].trim();
                    File dir = context.getFilesDir();
                    File file = new File(dir, filename);
                    if (file.exists()) {
                        boolean deleted = file.delete();
                    }
                } else {
                    long rowId = db.insert(dynTbName, null, cv);
                }
            }
        } catch (Exception e) {
            strReturn = "error";
            System.out.println("error in " + tag + "--" + e);
        } finally {
            db.close();
        }
        return strReturn;
    }

    public void updateDAV(String splCode) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            String query = "UPDATE TBDAV SET COL9 = 'U' WHERE COL7= '"
                    + splCode + "'";
            db.execSQL(query);
        } catch (Exception e) {
            System.out.println("EXCEPTION------------>" + e);
        } finally {
            db.close();
        }
    }

    /*
     * This Method will delete all the Plan table
     *
     * @Parameters date and mode if mode = 1 then delete all plan table
     * including today otherwise except date parameter all the plan table will
     * be deleted
     */
    public void deletePlanTable(String date, int mode) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cur = null;
        String str = date.replace("/", "");
        try {
            String query = "select name from sqlite_master where type = 'table'";
            cur = db.rawQuery(query, new String[]{});
            while (cur.moveToNext()) {
                try {

                    if (cur.getString(0).startsWith("TBPLAN")) {
                        // for (int i = 0; i < date.length; i++) {
                        // String str = date[i].replace("/", "");
                        if (mode == 1) {
                            if (!(cur.getString(0).equalsIgnoreCase("TBPLAN"
                                    + str))) {
                                db.execSQL("DROP TABLE " + cur.getString(0));
                            }
                        } else {
                            db.execSQL("DROP TABLE " + cur.getString(0));
                            System.out.println("Drop Table   "
                                    + cur.getString(0));

                        }
                        // }

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
        } finally {
            if (cur != null) {
                cur.close();
            }
            db.close();
            System.gc();
        }
    }

    // public void deletePlanTable(String [] date) {
    // SQLiteDatabase db = this.getWritableDatabase();
    // Cursor cur = null;
    //
    // try {
    // String query = "select name from sqlite_master where type = 'table'";
    // cur = db.rawQuery(query, new String[] {});
    // while (cur.moveToNext()) {
    // try {
    // if (cur.getString(0).startsWith("TBPLAN")) {
    // // for (int i = 0; i < date.length; i++) {
    // // String str = date[i].replace("/", "");
    // // if (!(cur.getString(0).equalsIgnoreCase("TBPLAN" + str))) {
    // // db.execSQL("DROP TABLE " + cur.getString(0));
    // // }
    // // }
    //
    // }
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // }
    // } catch (Exception e) {
    // } finally {
    // if (cur != null) {
    // cur.close();
    // }
    // db.close();
    // System.gc();
    // }
    // }

    // public void updateSts(String partyCode) {
    // SQLiteDatabase db = this.getWritableDatabase();
    // try {
    //
    // String query = "SELECT * FROM " + CmsInter.TXNDETAILINGDATA;
    // Cursor cur = db.rawQuery(query, new String[] {});
    // int noOfRows = cur.getCount();
    // if (noOfRows > 0) {
    // // cur.moveToFirst();
    // strData = new String[noOfRows][2];
    // int count = 0;
    // while (cur.moveToNext()) {
    // strData[count][0] = cur.getString(1);
    // strData[count][1] = cur.getString(2);
    // count++;
    // }
    // }
    // cur.close();
    // } catch (Exception e) {
    // System.out.println("Exp in getTxn---" + e);
    // }
    // db.close();
    // return strData;
    //
    //
    // }
    public boolean insertCompleteTable(String[][] Data, String Tablename) {
        boolean returnVal = true;
        ContentValues cv = new ContentValues();
        SQLiteDatabase db = this.getWritableDatabase();
        try {

            for (int i = 0; i < Data.length; i++) {
                for (int j = 0; j < Data[0].length; j++) {
                    cv.put("COL" + j, Data[i][j].trim());
                }
                db.insert(Tablename, null, cv);
            }
        } catch (Exception e) {
            return false;
        }
        return returnVal;
    }

    public boolean deleteAllData(String TableName) {
        boolean strData = true;
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE  FROM " + TableName;
        try {
            db.execSQL(query);
        } catch (Exception e) {
            System.out.println("In getallData block------->" + e);
            return false;
        }
        return strData;
    }

    public String insertPcpData(String str_response) {
        String str_return = "SUCCESS";
        SQLiteDatabase db = this.getWritableDatabase();
        try {

            ContentValues cv = new ContentValues();
            dynTbName = "TBPCP";
            if (str_response.equals(CmsInter.PERCENT + CmsInter.PERCENT)) {
                str_return = "error";
                return str_return;
            }

            try {
                db.execSQL("CREATE TABLE " + dynTbName
                        + "(COL0 TEXT, COL1 TEXT)");
            } catch (Exception e) {
                // System.out.println("insertAllData 1111---Exp--" + e);
                db.execSQL("DROP TABLE " + dynTbName);
                System.out.println("insertAllData 2222---Dropped--");
                db.execSQL("CREATE TABLE " + dynTbName
                        + "(COL0 TEXT, COL1 TEXT)");
            }
            String[] str_data = Utility.split(str_response, CmsInter.DOLLAR);
            for (int i = 0; i < str_data.length; i++) {
                String[] strData = Utility.split(str_data[i], CmsInter.AT);
                cv.put("COL0", strData[0]); // rpt code
                cv.put("COL1", strData[1]);
                long rowId = db.insert(dynTbName, null, cv);
                if (rowId == -1) {
                    str_return = "error";
                }
            }

        } catch (Exception e) {
            // Utility.LOG("SetData-setPatchData", e.toString());
            str_return = "ERROR" + e.toString();
        } finally {
            db.close();
        }
        return str_return;
    }

    public String insertConfigData(String tag, String data) {
        String strReturn = "success";
        String configTable = "TB" + tag;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        try {
            db = this.getWritableDatabase();
            int count = db.delete(configTable, "1", new String[]{});
            cv.put(colCfgName, tag);
            cv.put(colCfgData, data);
            long rowId = db.insert(configTable, null, cv);
            if (rowId == -1) {
                strReturn = "error";
            }

        } catch (Exception e) {
            strReturn = "error";
        } finally {
            db.close();
        }
        return strReturn;
    }

    public String[][] getTableDataGeneric(String tb_name, int no_of_Colums,
                                          String whreclause, String orderBy, String joinquery,
                                          boolean joinmode) {
        SQLiteDatabase db = this.getWritableDatabase();
        String[][] strdata = null;
        // String whreclause = "";
        Cursor cur = null;
        String query = "";
        try {
            if (joinmode) {
                query = joinquery;
            } else {
                query = "SELECT * FROM " + tb_name + " " + whreclause + " "
                        + orderBy;
            }
            // System.out.println("in getPatch QUERY---" + query);
            cur = db.rawQuery(query, new String[]{});
            int noOfRows = cur.getCount();
            System.out.println("in getParty Count---" + noOfRows);
            if (noOfRows > 0) {
                strdata = new String[noOfRows][no_of_Colums];
                int i = 0;
                while (cur.moveToNext()) {
                    for (int j = 0; j < no_of_Colums; j++) {
                        strdata[i][j] = cur.getString(j);
                    }
                    i++;
                }
            }

        } catch (Exception e) {
            System.out.println("in getTabledata Exp---" + e);
        } finally {
            if (cur != null) {
                cur.close();
            }
            db.close();
        }
        return strdata;
    }

    public String[][] genericSelect(String select, String tableName,
                                    String where, String groupBy, String having, int noCols,
                                    String orderBy) {
        String strData[][] = null;
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + select + " FROM " + tableName;
        if (!where.equals("")) {
            query = query + " WHERE " + where;
        }
        if (!groupBy.equals("")) {
            query = query + " GROUP BY " + groupBy;
        }
        if (!having.equals("")) {
            query = query + " HAVING " + having;
        }
        if (!orderBy.equals("")) {
            query = query + " ORDER BY " + orderBy;
        }
        Cursor cur = null;
        try {
            cur = db.rawQuery(query, new String[]{});
            int noOfRows = cur.getCount();
            int count = 0;

            if (noOfRows > 0) {
                strData = new String[noOfRows][noCols];
                while (cur.moveToNext()) {
                    for (int i = 0; i < noCols; i++) {
                        strData[count][i] = cur.getString(i);
                    }
                    count++;
                }
            } else {
                strData = new String[1][1];
                strData[0][0] = "No response";
            }
        } catch (Exception e) {
            System.out.println("In getallData block------->" + e);
        } finally {
            if (cur != null) {
                cur.close();
            }
            db.close();
        }
        return strData;
    }

    public boolean genericUpdate(String tableName, String columName,
                                 String value, String where) {
        boolean flag = true;
        String strData[][] = null;
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + tableName;
        if (!columName.equals("")) {
            query = query + " SET " + columName + " ='" + value + "'";
        }
        if (!where.equals("")) {
            query = query + " WHERE " + where;
        }
        try {
            db.execSQL(query);
        } catch (Exception e) {
            System.out.println("In getallData block------->" + e);
            return false;
        } finally {
            db.close();
        }
        return flag;
    }

    public void deleteAllFiles(File fileOrDirectory) {
        if (fileOrDirectory.isDirectory())
            for (File child : fileOrDirectory.listFiles())
                deleteAllFiles(child);
        fileOrDirectory.delete();
    }

    public boolean insetmtpparty(String query, Vector<String> vector,
                                 String strPlannedDate) {
        System.out.println("query------------>" + query);
        boolean blReturn = false;
        String strMain = "";
        SQLiteDatabase db = this.getWritableDatabase();
        try {

            for (int i = 0; i < vector.size(); i++) {
                String[] strmain = Utility.split(vector.elementAt(i),
                        CmsInter.CAP);
                String pcode = strmain[0];
                String ptype = strmain[1];
                String patchcode = strmain[2];
                String splcode = strmain[3];

                // if(isrecords("DMT", "COL0"));
                // String[][] partyDetails = getTableData("MTP", 4,
                // " WHERE COL0 LIKE '%" + pcode + "%' AND COL3 ='"
                // + ptype + "'", "");
                if (!db.isOpen()) {

                    db = getWritableDatabase();

                }

                // if (partyDetails != null) {
                // strMain = "UPDATE TBMTP set COL1 = COL1 || ',"
                // + strPlannedDate + "' " + query;
                // db.execSQL(strMain);
                // blReturn = true;
                // } else {
                strMain = "INSERT INTO TBMTP"
                        + " (COL1, COL0, COL5, COL2, COL3) VALUES ('" + pcode
                        + "' , '" + strPlannedDate + "', '" + patchcode
                        + "', '" + ptype + "','" + splcode + "')";
                System.out.println("strMain----------->" + strMain);
                db.execSQL(strMain);
                blReturn = true;
                // }

            }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Exception in insetmtp--->" + e.toString());
        } finally {
            db.close();
        }
        // TODO Auto-generated method stub
        return blReturn;
    }

    public boolean swapPlanParty(String fromDate, String toDate) {
        boolean blReturn = false;
        SQLiteDatabase db = null;
        String query1 = "", query2 = "", query3 = "";
        try {
            db = this.getWritableDatabase();
            query1 = "UPDATE TBMTP SET COL0 = '00/00/0000' WHERE COL0 = '"
                    + fromDate + "'";
            query2 = "UPDATE TBMTP SET COL0 = '" + fromDate + "' WHERE COL0= '"
                    + toDate + "'";
            query3 = "UPDATE TBMTP SET COL0 = '" + toDate
                    + "' WHERE COL0 = '00/00/0000'";
            db.execSQL(query1);
            db.execSQL(query2);
            db.execSQL(query3);
            blReturn = true;
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            db.close();
        }

        return blReturn;

    }

    public String insertDAVData(String contentid, String contentname,
                                String partycode, String brandcode, String mtpntryNo, String date,
                                String splcode, String SqlNo) {
        String strReturn = "success";
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        try {
            cv.put("COL0", contentid);
            cv.put("COL1", contentname);
            cv.put("COL2", partycode);
            cv.put("COL3", brandcode);
            cv.put("COL4", mtpntryNo);
            cv.put("COL5", date);
            cv.put("COL6", splcode);
            cv.put("COL7", SqlNo);

            db.insert("TBDAV", null, cv);

        } catch (Exception e) {
            strReturn = "error";
            System.out.println("error innn .........");
        } finally {
            db.close();
        }
        return strReturn;
    }

    public String insertEXPData(String date, String ta, String da, String dme,
                                String total, String code) {
        String strReturn = "success";
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        String dayType = "";
        String entryNo = "";

        String[][] tbDed = getTableData("DED", 8,
                "WHERE COL0 = '" + date + "'", "");

        if (!db.isOpen()) {
            db = this.getWritableDatabase();

        }
        if (tbDed != null) {
            dayType = tbDed[0][1];
            entryNo = tbDed[0][7];

        }

        try {
            cv.put("COL0", date);
            cv.put("COL1", dayType);
            cv.put("COL2", ta);
            cv.put("COL3", da);
            cv.put("COL4", dme);
            cv.put("COL5", total);
            cv.put("COL6", code);
            cv.put("COL7", entryNo);
            String[] whereArgs = new String[1];
            whereArgs[0] = date;
            System.out.println("code--->" + code);
            int rowId = db.update("TBDED", cv, "COL0=?", whereArgs);

        } catch (Exception e) {
            strReturn = "error";
            System.out.println("error innn ........." + e.toString());
        } finally {
            db.close();
        }
        return strReturn;
    }

    public String insertDMEData(String date, String[] value) {
        String strReturn = "success";
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        String[] miscCode = null;
        String[] miscName = null;
        String[] miscValue = null;

        String[][] tbExp = getTableData("DEM", 5, "WHERE COL0 = '" + date
                + "' AND COL4 = 'D'", "");

        if (tbExp != null) {
            miscCode = new String[tbExp.length];
            miscName = new String[tbExp.length];
            miscValue = new String[tbExp.length];
            for (int i = 0; i < tbExp.length; i++) {
                miscCode[i] = tbExp[i][1];
                miscName[i] = tbExp[i][2];
                miscValue[i] = value[i];

            }

        }
        if (!db.isOpen()) {
            db = this.getWritableDatabase();

        }
        if (tbExp != null) {
            db.delete("TBDEM", "COL0 = '" + date + "' AND COL4 = 'D'", null);
        }

        try {
            for (int i = 0; i < tbExp.length; i++) {

                cv.put("COL0", date);
                cv.put("COL1", miscCode[i]);
                cv.put("COL2", miscName[i]);
                cv.put("COL3", miscValue[i]);
                cv.put("COL4", "D");

                db.insert("TBDEM", null, cv);
            }

        } catch (Exception e) {
            strReturn = "error";
            System.out.println("error innn .........");
        } finally {
            db.close();
        }
        return strReturn;
    }

    public String insertTaData(String date, String[][] taData) {
        String strReturn = "success";
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        String[] fromCode = null;
        String[] fromName = null;
        String[] toCode = null;
        String[] toName = null;
        String[] distance = null;
        String[] modeCode = null;
        String[] modeName = null;
        String[] amount = null;
        String[] id = null;

        String[][] tbExp = getTableData("DTA", 10, "WHERE COL0 = '" + date
                + "'", "");

        if (!db.isOpen()) {
            db = this.getWritableDatabase();

        }

        if (taData != null) {

            fromCode = new String[taData.length];
            fromName = new String[taData.length];
            toCode = new String[taData.length];
            toName = new String[taData.length];
            distance = new String[taData.length];
            modeCode = new String[taData.length];
            modeName = new String[taData.length];
            amount = new String[taData.length];
            id = new String[taData.length];
            for (int i = 0; i < taData.length; i++) {
                id[i] = taData[i][1];
                fromCode[i] = taData[i][2];
                fromName[i] = taData[i][3];
                toCode[i] = taData[i][4];
                toName[i] = taData[i][5];
                distance[i] = taData[i][6];
                modeCode[i] = taData[i][7];
                modeName[i] = taData[i][8];
                amount[i] = taData[i][9];

            }
        }
        if (tbExp != null) {
            db.delete("TBDTA", "COL0 = '" + date + "'", null);
        }
        try {
            for (int i = 0; i < amount.length; i++) {

                cv.put("COL0", date);
                cv.put("COL1", id[i]);
                cv.put("COL2", fromCode[i]);
                cv.put("COL3", fromName[i]);
                cv.put("COL4", toCode[i]);
                cv.put("COL5", toName[i]);
                cv.put("COL6", distance[i]);
                cv.put("COL7", modeCode[i]);
                cv.put("COL8", modeName[i]);
                cv.put("COL9", amount[i]);

                long id1 = db.insert("TBDTA", null, cv);

                if (id1 > 0) {
                    System.out.println("Data inserted........");
                } else {
                    System.out.println("Error in inserting-->");
                }
            }

        } catch (Exception e) {
            strReturn = "error";
            System.out.println("error innn ........." + e.toString());
        } finally {
            db.close();
        }
        return strReturn;
    }

    private boolean SelectNewDCM(String tblName, String srchCol1,
                                 String srchData1, String srchCol2, String srchData2,
                                 String srchCol3, String srchData3) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cur = null;
        try {
            cur = db.rawQuery(
                    "SELECT * FROM " + tblName + " WHERE(" + srchCol1 + "= '"
                            + srchData1 + "' AND " + srchCol2 + "= '"
                            + srchData2 + "'AND " + srchCol3 + "= '"
                            + srchData3 + "')", new String[]{});

            int noOfRows = 0;
            if (cur != null) {
                noOfRows = cur.getCount();
            }
            if (noOfRows > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        } finally {
            if (cur != null) {
                cur.close();
            }

        }

    }

    public boolean deletePlanParty(String pCode, String pType, String date) {
        // TODO Auto-generated method stub
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cur = null;
        boolean blreturn = false;
        try {
            String[] whereArgs = new String[3];
            whereArgs[0] = date;
            whereArgs[1] = pCode;
            whereArgs[2] = pType;
            db.delete("TBMTP", "COL0=? AND COL1=? AND COL2=?", whereArgs);
            blreturn = true;
        } catch (Exception e) {
            // TODO: handle exception

        } finally {
            db.close();
            return blreturn;
        }

    }

    public boolean insertGenericData2D(String table, String[][] insertArray) {
        boolean str_return = true;
        SQLiteDatabase db = this.getWritableDatabase();
        try {

            ContentValues cv = new ContentValues();
            try {
                for (int i = 0; i < insertArray.length; i++) {
                    for (int j = 0; j < insertArray[0].length; j++) {
                        cv.put("COL" + j, insertArray[i][j]);
                    }
                    db.insert(table, null, cv);
                    cv.clear();
                }
                // long rowId = db.insert(table, null, cv);

            } catch (Exception e) {
                str_return = false;
            }
        } finally {
            // db.close();
            close();
        }
        return str_return;
    }

}
