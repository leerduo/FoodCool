package com.bohe.foodcool.utils;

/**
 * Created by wangteng.
 * Time:2015/11/2
 * Email:843203996@qq.com
 */

/**
 *
 * 异步任务的 doInBackground 返回的结果
 *
 */
public class TaskResult {

    /**
     * 异步任务唯一标识，每一个异步任务的标识都不同
     */
    public int action;
    /**
     * 服务器返回的 ret 值 0 代表成功
     */
    public int resultCode = -1;
    /**
     * 任意数据类型，只要实现类支持即可
     */
    public Object data;

}
