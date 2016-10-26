package io.github.webbluetoothcg.bletestperipheral;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;

import java.util.List;
import java.util.UUID;

/**
 * Created by Trung Vo on 10/26/16.
 */

public class GattServiceBuilder {
    static public BluetoothGattService build(String serviceUuid, List<BluetoothGattCharacteristic> chars) {
        BluetoothGattService service = new BluetoothGattService(Const.getUuid(serviceUuid),
                BluetoothGattService.SERVICE_TYPE_PRIMARY);
        for (BluetoothGattCharacteristic character: chars) {
            service.addCharacteristic(character);
        }
        return service;
    }

    static public BluetoothGattService build(String serviceUuid, BluetoothGattCharacteristic character) {
        BluetoothGattService service = new BluetoothGattService(Const.getUuid(serviceUuid),
                BluetoothGattService.SERVICE_TYPE_PRIMARY);
        service.addCharacteristic(character);
        return service;
    }
}
