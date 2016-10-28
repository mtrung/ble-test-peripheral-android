package io.github.webbluetoothcg.bletestperipheral;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.os.ParcelUuid;

/**
 * Created by Trung Vo on 10/27/16.
 */

public class DeviceInfoService extends BluetoothGattService {

    private static DeviceInfoService gInstance;
    public static DeviceInfoService getInstance() {
        if (gInstance == null)
            gInstance = new DeviceInfoService();
        return gInstance;
    }

    public static ParcelUuid getParcelUuid() {
        return Const.getParcelUuid(Const.DEVICE_INFORMATION_SERVICE_UUID_STR);
    }

    public DeviceInfoService() {
        super(Const.getUuid(Const.DEVICE_INFORMATION_SERVICE_UUID_STR), SERVICE_TYPE_PRIMARY);

//        mBatteryLevelCharacteristic = new BluetoothGattCharacteristic(Const.BATTERY_LEVEL_UUID,
//                BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY,
//                BluetoothGattCharacteristic.PERMISSION_READ);
//        mBatteryLevelCharacteristic.addDescriptor(
//                PeripheralActivity.getClientCharacteristicConfigurationDescriptor());
//
//        addCharacteristic(mBatteryLevelCharacteristic);
    }

//    public void setBatteryLevel(int newBatteryLevel) {
//        mBatteryLevelCharacteristic.setValue(newBatteryLevel,
//                BluetoothGattCharacteristic.FORMAT_UINT8, /* offset */ 0);
//    }
}
