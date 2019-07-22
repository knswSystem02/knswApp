package com.knsw.attendanceApp;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 数値(整数)の入力ダイアログを表示するクラス。
 */
public class PoPupNumpick extends AppCompatActivity {

    // ビルダー
    private AlertDialog.Builder builder;
    // 表示したダイアログ本体
    private AlertDialog dialog;
    // View
    private View popup_numpick;


    /**
     * コンストラクタ
     * @param activity
     */
    public PoPupNumpick(Activity activity) {
        this.builder = new AlertDialog.Builder(activity);

        //コンテキストからインフレータを取得
        LayoutInflater inflater = LayoutInflater.from(activity);
        //レイアウトXMLからビュー(レイアウト)をインフレート
        popup_numpick = inflater.inflate(R.layout.popup_numpick, null);
        //ビルダーにViewを設定
        this.builder.setView(popup_numpick);
        //builder.show();

    }
}