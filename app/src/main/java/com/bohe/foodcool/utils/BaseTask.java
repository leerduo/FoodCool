package com.bohe.foodcool.utils;

import android.os.AsyncTask;

/**
 * Created by wangteng.
 * Time:2015/11/2
 * Email:843203996@qq.com
 */
public abstract  class BaseTask extends AsyncTask<String,Void, TaskResult> {

    private TaskCallback callback;

    public BaseTask(TaskCallback callback) {
        this.callback = callback;
    }

    @Override
    protected void onPostExecute(TaskResult result) {
        if (callback != null) {
            callback.onTaskFinished(result);
        }
    }
}