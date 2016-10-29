package io.github.webbluetoothcg.bletestperipheral;

import android.bluetooth.BluetoothGattService;

import java.util.UUID;

/**
 * Created by Trung Vo on 10/29/16.
 */

public class HidService extends BluetoothGattService {
    public HidService(UUID uuid, int serviceType) {
        super(uuid, serviceType);
    }
}
