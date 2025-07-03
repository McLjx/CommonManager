package android.os.common;

import android.content.Context;
import android.os.RemoteException;
import android.os.common.ICommonService;
import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CommonManager {
    private final Context mContext;
    private final ICommonService mService;
    public static final String TAG = "CommonManager";

    /** @hide */
    public CommonManager(@NonNull Context context, @NonNull ICommonService server) {
        Log.d(TAG, "CommonManager: ");
        this.mContext = context;
        this.mService = server;
    }

    /**
     * 写入VendorStorage数据
     * @param writeData 要写入的字符串数据
     * @param id 要写入的item ID
     * @return 返回 0 表示成功，非 0 表示错误
     */
    @Nullable
    public int writeVendorStorage(@NonNull String writeData, int id) {
        try {
            if (mService != null) {
                return mService.writeVendorStorage(writeData, id);
            }
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to write vendor storage", e);
            return -1;
        }
        return -2;
    }
    /**
     * 读取VendorStorage数据
     * @param id 要读取的item ID
     * @return 读取到的数据，如果失败则返回null
     */
    @Nullable
    public String readVendorStorage(int id) {
        try {
            if (mService != null) {
                return mService.readVendorStorage(id);
            }
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to read vendor storage", e);
            return null;
        }
        return null;
    }


}
