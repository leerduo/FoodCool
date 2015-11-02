package com.bohe.foodcool.utils;

/**
 * Created by wangteng.
 * Time:2015/11/2
 * Email:843203996@qq.com
 */
public interface TaskCallback {
    /**
     * 当异步任务执行完成时，会回调这个方法，将数据结果传递给相应的实现类
     * @param result    返回的结果
     */
    void onTaskFinished(TaskResult result);

}
