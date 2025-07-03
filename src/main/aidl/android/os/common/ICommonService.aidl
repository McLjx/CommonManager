package android.os.common;

// Declare any non-default types here with import statements
 /**
 * @hide
 */
interface ICommonService {

    /**
     * 写入VendorStorage数据
     * @param writeData 要写入的字符串数据
     * @param id 要写入的item ID
     * @return 返回 0 表示成功，非 0 表示错误
     */
    int writeVendorStorage(in String writeData, int id);

    /**
     * 读取VendorStorage数据
     * @param id 要读取的item ID
     * @return 读取到的数据
     */
    String readVendorStorage(int id);
}