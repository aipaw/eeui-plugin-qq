package eeui.android.tencent.entry;

import android.content.Context;

import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.common.WXException;
import com.tencent.tauth.Tencent;

import app.eeui.framework.extend.annotation.ModuleEntry;
import app.eeui.framework.extend.module.eeuiBase;
import app.eeui.framework.extend.module.eeuiJson;
import eeui.android.tencent.module.ApptencentModule;

@ModuleEntry
public class tencentEntry {
    public static Tencent mTencent;

    /**
     * APP启动会运行此函数方法
     * @param content Application
     */
    public void init(Context content) {
        JSONObject tencent = eeuiJson.parseObject(eeuiBase.config.getObject("tencent").get("android"));
        mTencent = Tencent.createInstance(eeuiJson.getString(tencent, "appid"), content);

        //1、注册weex模块
        try {
            WXSDKEngine.registerModule("eeuiQq", ApptencentModule.class);
        } catch (WXException e) {
            e.printStackTrace();
        }
    }
}
