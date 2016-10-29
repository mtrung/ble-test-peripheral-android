package io.github.webbluetoothcg.bletestperipheral;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.ParcelUuid;
import android.util.Log;
import android.view.View;

/**
 * Created by Trung Vo on 10/27/16.
 */

public class BatteryService extends BluetoothGattService {

    private static BatteryService gInstance;
    public static BatteryService getInstance() {
        if (gInstance == null)
            gInstance = new BatteryService();
        return gInstance;
    }

    public static ParcelUuid getParcelUuid() {
        return Const.getParcelUuid(Const.BATTERY_SERVICE_UUID_STR);
    }

    public BluetoothGattCharacteristic mBatteryLevelCharacteristic;

    public BatteryService() {
        super(Const.getUuid(Const.BATTERY_SERVICE_UUID_STR), SERVICE_TYPE_PRIMARY);

        mBatteryLevelCharacteristic = new BluetoothGattCharacteristic(Const.BATTERY_LEVEL_UUID,
                        BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY,
                        BluetoothGattCharacteristic.PERMISSION_READ);

        try {
            mBatteryLevelCharacteristic.addDescriptor(Const.getClientCharacteristicConfigurationDescriptor());
        } catch (Exception e) {
            Log.e("Char addDescriptor", e.getLocalizedMessage());
        }

        setBatteryLevel(50);

        addCharacteristic(mBatteryLevelCharacteristic);
    }

    public void setBatteryLevel(int newBatteryLevel) {
        mBatteryLevelCharacteristic.setValue(newBatteryLevel, BluetoothGattCharacteristic.FORMAT_UINT8, /* offset */ 0);
    }

    public void getBatteryLevel() {
        mBatteryLevelCharacteristic.getIntValue(BluetoothGattCharacteristic.FORMAT_UINT8, 0);
    }
}
