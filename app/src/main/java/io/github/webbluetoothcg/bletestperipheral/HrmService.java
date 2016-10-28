package io.github.webbluetoothcg.bletestperipheral;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.os.ParcelUuid;

import java.util.UUID;

/**
 * Created by Trung Vo on 10/28/16.
 */

public class HrmService extends BluetoothGattService {
    private static HrmService gInstance;
    public static HrmService getInstance() {
        if (gInstance == null)
            gInstance = new HrmService();
        return gInstance;
    }

    public static ParcelUuid getParcelUuid() {
        return Const.getParcelUuid(Const.HEART_RATE_SERVICE_UUID_STR);
    }

    public HrmService() {
        super(Const.getUuid(Const.HEART_RATE_SERVICE_UUID_STR), SERVICE_TYPE_PRIMARY);

        mHeartRateMeasurementCharacteristic =
                new BluetoothGattCharacteristic(Const.HEART_RATE_MEASUREMENT_UUID,
                        BluetoothGattCharacteristic.PROPERTY_NOTIFY,
            /* No permissions */ 0);

        mHeartRateMeasurementCharacteristic.addDescriptor(
                Const.getClientCharacteristicConfigurationDescriptor());

        mBodySensorLocationCharacteristic =
                new BluetoothGattCharacteristic(Const.BODY_SENSOR_LOCATION_UUID,
                        BluetoothGattCharacteristic.PROPERTY_READ,
                        BluetoothGattCharacteristic.PERMISSION_READ);

        mHeartRateControlPoint =
                new BluetoothGattCharacteristic(Const.HEART_RATE_CONTROL_POINT_UUID,
                        BluetoothGattCharacteristic.PROPERTY_WRITE,
                        BluetoothGattCharacteristic.PERMISSION_WRITE);

        addCharacteristic(mHeartRateMeasurementCharacteristic);
        addCharacteristic(mBodySensorLocationCharacteristic);
        addCharacteristic(mHeartRateControlPoint);
    }

    public BluetoothGattCharacteristic mHeartRateMeasurementCharacteristic;
    public BluetoothGattCharacteristic mBodySensorLocationCharacteristic;
    public BluetoothGattCharacteristic mHeartRateControlPoint;

}
