package android.os.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtils {
    private static volatile CommonUtils instance;
    private final Context appContext;
    public static CommonManager manager;
    @SuppressLint("WrongConstant")
    private CommonUtils(Context context) {
        // 使用Application Context避免内存泄漏
        this.appContext = context.getApplicationContext();
        // 初始化操作...
        manager=(CommonManager)context.getSystemService(MyContent.COMMON);
    }

    public static CommonUtils getInstance(Context context) {
        if (instance == null) {
            synchronized (CommonUtils.class) {
                if (instance == null) {
                    instance = new CommonUtils(context);
                }
            }
        }
        return instance;
    }
    public String getSpKey() {
        manager=(CommonManager)appContext.getSystemService(MyContent.COMMON);
        if (manager!=null) {
            String type = manager.readVendorStorage(MyContent.KEY_PRODUCTION_TESTING_ID);
            if (!TextUtils.isEmpty(type)) {
                Pattern pattern = Pattern.compile("\\d+\\.?\\d*");
                Matcher matcher = pattern.matcher(type);
                StringBuffer buffer=new StringBuffer();
                while (matcher.find()) {
                    buffer.append(matcher.group());
                }
                if (buffer.length()>0) {
                   // Constant.HOME_LIST_KEY = Constant.HOME_LIST_KEY + "_" + buffer.toString();
                    return buffer.toString();
                }
            }
        }
        return "";
    }

    public  int getType(){
        String type = manager.readVendorStorage(MyContent.KEY_PRODUCTION_TESTING_ID);
        if (!TextUtils.isEmpty(type)) {
            Pattern pattern = Pattern.compile("\\d+\\.?\\d*");
            Matcher matcher = pattern.matcher(type);
            StringBuffer buffer=new StringBuffer();
            while (matcher.find()) {
                buffer.append(matcher.group());
            }
            if (buffer.length()>0) {
                return Integer.valueOf(buffer.toString());
            }
        }
        return 0;
    }

    public  void setType(int type){
        manager.writeVendorStorage(""+type,MyContent.KEY_PRODUCTION_TESTING_ID);
    }

}
