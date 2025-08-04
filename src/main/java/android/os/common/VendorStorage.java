package android.os.common;

import androidx.annotation.NonNull;

public class VendorStorage {
    private static final String TAG = "VendorStorage";

    public native static  int writeVendorStorage(@NonNull String writeData, int id);

    public native static String readVendorStorage(int id);

    static {
        System.loadLibrary("vendorstorage");
    }
}
