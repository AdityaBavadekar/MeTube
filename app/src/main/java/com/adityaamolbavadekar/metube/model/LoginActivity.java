package com.adityaamolbavadekar.metube.model;

import android.os.Build;

import com.adityaamolbavadekar.metube.utils.DateUtils;

import java.util.HashMap;

public class LoginActivity {

    private long timestamp;
    private String deviceDisplayName;
    private String device;
    private String model;
    private String manufacturer;
    private int androidVersionInt;
    private Boolean debuggableDevice;

    public long getTimestamp() {
        return timestamp;
    }

    public String getDeviceDisplayName() {
        return deviceDisplayName;
    }

    public String getDevice() {
        return device;
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getAndroidVersionInt() {
        return androidVersionInt;
    }

    public Boolean getDebuggableDevice() {
        return debuggableDevice;
    }

    public HashMap<String, Object> getHashMap() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put(KEY_TIMESTAMP, timestamp);
        map.put(KEY_DEVICE_DISPLAY_NAME, deviceDisplayName);
        map.put(KEY_DEVICE, device);
        map.put(KEY_MODEL, model);
        map.put(KEY_MANUFACTURER, manufacturer);
        map.put(KEY_ANDROID_VERSION_INT, androidVersionInt);
        map.put(KEY_DEBUGGABLE_DEVICE, debuggableDevice);
        return map;
    }

    private LoginActivity() {
        timestamp = DateUtils.now();
        deviceDisplayName = Build.DISPLAY;
        device = Build.DEVICE;
        model = Build.MODEL;
        manufacturer = Build.MANUFACTURER;
        androidVersionInt = Build.VERSION.SDK_INT;
        debuggableDevice = !Build.TYPE.equals("user");
    }

    private LoginActivity(HashMap<String, Object> map) {
        timestamp = (long) map.get(KEY_TIMESTAMP);
        deviceDisplayName = (String) map.get(KEY_DEVICE_DISPLAY_NAME);
        device = (String) map.get(KEY_DEVICE);
        model = (String) map.get(KEY_MODEL);
        manufacturer = (String) map.get(KEY_MANUFACTURER);
        androidVersionInt = (int) map.get(KEY_ANDROID_VERSION_INT);
        debuggableDevice = (Boolean) map.get(KEY_DEBUGGABLE_DEVICE);
    }

    private static final String KEY_TIMESTAMP = "timestamp";
    private static final String KEY_DEVICE_DISPLAY_NAME = "deviceDisplayName";
    private static final String KEY_DEVICE = "device";
    private static final String KEY_MODEL = "model";
    private static final String KEY_MANUFACTURER = "manufacturer";
    private static final String KEY_ANDROID_VERSION_INT = "androidVersionInt";
    private static final String KEY_DEBUGGABLE_DEVICE = "debuggableDevice";

}
