package com.gzf.zfprogresshud.utils;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.gzf.zfprogresshud.R;
import com.gzf.zfprogresshud.ui.ZFProgressHUD;
/**
 * Created by JoshuaGeng on 2017/8/7.
 */

public class ZFProgressHUDUtils {

    public static ZFProgressHUD sZFProgressHUD;
    public static TextView progressMsg = null;
    public static ProgressBar sProgressBar = null;

    /**
     * 显示加载进度条
     * 不需要文字的话，msg填""
     * 背景默认点击不消失
     * */
    public static void show(Context context, String msg) {
        showProgressHUD(context,msg,1,15,Color.WHITE,false,null);
    }
    /**
     * 显示加载进度条
     * 不需要文字的话，msg填""
     * isCancelable 可以设置是否可以点击背景消失
     * */
    public static void show(Context context, String msg, boolean isCancelable) {
        showProgressHUD(context,msg,1,15,Color.WHITE,isCancelable,null);
    }
    /**
     * 显示加载进度条
     * 不需要文字的话，msg填""
     * 可设置字体颜色和大小
     * isCancelable 可以设置是否可以点击背景消失
     * */
    public static void show(Context context, String msg, float msgTextSize, int msgTextColor, boolean isCancelable) {
        showProgressHUD(context,msg,1,msgTextSize,msgTextColor,isCancelable,null);
    }
    /**
     * 显示加载进度条
     * 不需要文字的话，msg填""
     * 可设置字体颜色和大小
     * isCancelable 可以设置是否可以点击背景消失
     * 可自定义图片
     * */
    public static void show(Context context, String msg, float msgTextSize, int msgTextColor, boolean isCancelable,Drawable drawable) {
        showProgressHUD(context,msg,1,msgTextSize,msgTextColor,isCancelable,drawable);
    }

    /**
     * dismis 对话框
     * */
    public static void dismiss() {
        try {
            if (progressMsg != null) {
                progressMsg = null;
            }
            if (sProgressBar !=null) {
                sProgressBar = null;
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
    private static void showProgressHUD(Context context, String msg,int style, float msgTextSize, int msgTextColor, boolean isCancelable,Drawable drawable) {

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
            progressMsg.setTextSize(msgTextSize);
            progressMsg.setTextColor(msgTextColor);

            sProgressBar = (ProgressBar) sZFProgressHUD.getWindow().findViewById(R.id.process_bar);
            if (drawable!=null) {
                sProgressBar.setIndeterminateDrawable(drawable);
            }
//            mProgressBar.setIndeterminateDrawable(getResources().getDrawable(android.R.drawable.progress_indeterminate_horizontal));
        }

        sZFProgressHUD.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
            }
        });
    }
}
