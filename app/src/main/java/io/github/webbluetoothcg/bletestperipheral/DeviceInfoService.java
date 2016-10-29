package io.github.webbluetoothcg.bletestperipheral;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.os.ParcelUuid;
import android.util.Log;

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

        BluetoothGattCharacteristic characteristic;

        characteristic = new BluetoothGattCharacteristic(Const.getUuid(Const.Serial_Number_String_UUID_STR), BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ);
        characteristic.setValue("W0X002000X");
        addCharacteristic(characteristic);

        characteristic = new BluetoothGattCharacteristic(Const.getUuid(Const.Manufacturer_Name_String_UUID_STR), BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ);
        characteristic.setValue("Trung Inc.");
        addCharacteristic(characteristic);

        characteristic = new BluetoothGattCharacteristic(Const.getUuid(Const.Model_Number_String_UUID_STR), BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ);
        characteristic.setValue("My watch");
        addCharacteristic(characteristic);

        characteristic = new BluetoothGattCharacteristic(Const.getUuid(Const.Firmware_Revision_String_UUID_STR), BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ);
        characteristic.setValue("0.0.2");
        addCharacteristic(characteristic);

        characteristic = new BluetoothGattCharacteristic(Const.getUuid(Const.Software_Revision_String_UUID_STR), BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ);
        characteristic.setValue("0.2.2");
        addCharacteristic(characteristic);
    }
}
