package com.gzf.zfprogresshud.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.TextView;

import com.gzf.zfprogresshud.R;
import com.gzf.zfprogresshud.ui.ZFProgressHUD;

/**
 * Created by JoshuaGeng on 2017/8/4.
 */

public class ZFUtils {

    public static ZFProgressHUD sZFProgressHUD;
    public static TextView progressMsg = null;

    /**
     * 显示加载进度条
     * 不需要文字的话，msg填""
     * 背景默认点击不消失
     * */
    public static void show(Context context, String msg) {
        showProgressHUD(context,msg,1,false);
    }

    public static void show(Context context, String msg, boolean isCancelable) {
        showProgressHUD(context,msg,1,isCancelable);
    }
    /**
     * dismis 对话框
     * */
    public static void dismiss() {
        try {
            if (progressMsg != null) {
                progressMsg = null;
            }
            if (sZFProgressHUD != null) {
                sZFProgressHUD.dismiss();
                sZFProgressHUD = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 私有方法
     * */
    private static void showProgressHUD(Context context, String msg,int style, boolean isCancelable) {

        if (sZFProgressHUD != null) {
            sZFProgressHUD.dismiss();
            sZFProgressHUD = null;
        }
        sZFProgressHUD = new ZFProgressHUD(context, R.style.ZFProgressHUD);
        sZFProgressHUD.setTitle("");
        sZFProgressHUD.setMessage(msg);
        sZFProgressHUD.setIndeterminate(true);
        sZFProgressHUD.show();
        sZFProgressHUD.setCanceledOnTouchOutside(isCancelable);
        sZFProgressHUD.setCancelable(isCancelable);

        if (style == 1) {
            sZFProgressHUD.setContentView(R.layout.loading_process_dialog);
            progressMsg = (TextView) sZFProgressHUD.getWindow().findViewById(R.id.process_msg);
            progressMsg.setText(msg);
        }

        sZFProgressHUD.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
            }
        });
    }
}
