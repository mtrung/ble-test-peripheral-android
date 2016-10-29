package io.github.webbluetoothcg.bletestperipheral;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.ParcelUuid;

import java.util.UUID;

/**
 * Created by Trung Vo on 10/26/16.
 */

public class Const {
//    static final UUID CLIENT_CHARACTERISTIC_CONFIGURATION_UUID = UUID
//        .fromString("00002902-0000-1000-8000-00805f9b34fb");

    static public ParcelUuid getParcelUuid(String uuidStr) {
        return new ParcelUuid(getUuid(uuidStr));
    }

    public static UUID getUuid(String uuidStr) {
        if (uuidStr.length() == 4)
            return UUID.fromString("0000"+uuidStr+"-0000-1000-8000-00805f9b34fb");
        return UUID.fromString(uuidStr);
    }

    public static final String DEVICE_INFORMATION_SERVICE_UUID_STR = "180A";
    public static final String HEART_RATE_SERVICE_UUID_STR = "180D";
    public static final String BATTERY_SERVICE_UUID_STR = "180F";

    public static final String CLIENT_CHARACTERISTIC_CONFIGURATION_UUID_STR = "2902";

    public static final String Serial_Number_String_UUID_STR = "2A25";
    public static final String Manufacturer_Name_String_UUID_STR = "2A29";
    public static final String Model_Number_String_UUID_STR = "2A24";
    public static final String Firmware_Revision_String_UUID_STR = "2A26";
    public static final String Software_Revision_String_UUID_STR = "2A28";

    /**
     * See <a href="https://developer.bluetooth.org/gatt/services/Pages/ServiceViewer.aspx?u=org.bluetooth.service.heart_rate.xml">
     * Heart Rate Service</a>
     */
//    public static final UUID HEART_RATE_SERVICE_UUID = getUuid(HEART_RATE_SERVICE_UUID_STR);
    /**
     * See <a href="https://developer.bluetooth.org/gatt/characteristics/Pages/CharacteristicViewer.aspx?u=org.bluetooth.characteristic.heart_rate_measurement.xml">
     * Heart Rate Measurement</a>
     */
    public static final UUID HEART_RATE_MEASUREMENT_UUID = UUID
        .fromString("00002A37-0000-1000-8000-00805f9b34fb");
    /**
     * See <a href="https://developer.bluetooth.org/gatt/characteristics/Pages/CharacteristicViewer.aspx?u=org.bluetooth.characteristic.body_sensor_location.xml">
     * Body Sensor Location</a>
     */
    public static final UUID BODY_SENSOR_LOCATION_UUID = UUID
        .fromString("00002A38-0000-1000-8000-00805f9b34fb");
    /**
     * See <a href="https://developer.bluetooth.org/gatt/characteristics/Pages/CharacteristicViewer.aspx?u=org.bluetooth.characteristic.heart_rate_control_point.xml">
     * Heart Rate Control Point</a>
     */
    public static final UUID HEART_RATE_CONTROL_POINT_UUID = UUID
        .fromString("00002A39-0000-1000-8000-00805f9b34fb");


//    public static final UUID BATTERY_SERVICE_UUID = getUuid(BATTERY_SERVICE_UUID_STR);
    //UUID.fromString("0000180F-0000-1000-8000-00805f9b34fb");
    public static final UUID BATTERY_LEVEL_UUID = UUID
            .fromString("00002A19-0000-1000-8000-00805f9b34fb");

    ///////////////////////
    ////// Bluetooth //////
    ///////////////////////
    public static BluetoothGattDescriptor getClientCharacteristicConfigurationDescriptor() {
      return new BluetoothGattDescriptor(getUuid(CLIENT_CHARACTERISTIC_CONFIGURATION_UUID_STR),
              (BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
    }
}
