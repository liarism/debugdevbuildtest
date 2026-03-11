package com.mojang.minecraftpe;

import android.content.Context;

public class PlayStoreValidator {

    // ========================================
    // CHOOSE YOUR BYPASS METHOD BELOW:
    // ========================================
    
    // METHOD 1: Always bypass (simplest - uncomment this method)
    /*
    public static boolean isLicenseVerified(Context context) {
        return true;  // Always returns true - bypasses all checks
    }
    */
    
    // METHOD 2: Manual toggle (recommended - currently active)
    private static final boolean BYPASS_LICENSE_CHECK = true;  // Change to false to enable real check
    
    public static boolean isLicenseVerified(Context context) {
        if (BYPASS_LICENSE_CHECK) {
            return true;  // Bypass enabled
        }
        return isMinecraftFromPlayStore(context);  // Real check
    }
    
    // METHOD 3: Environment variable based (advanced)
    /*
    public static boolean isLicenseVerified(Context context) {
        String bypassEnv = System.getenv("BYPASS_LICENSE");
        if ("true".equals(bypassEnv)) {
            return true;
        }
        return isMinecraftFromPlayStore(context);
    }
    */

    // ========================================
    // Original validation method
    // ========================================
    
    private static boolean isMinecraftFromPlayStore(Context context) {
        try {
            String installer = context.getPackageManager().getInstallerPackageName(context.getPackageName());
            return installer != null && installer.equals("com.android.vending");
        } catch (Exception e) {
            return false;
        }
    }
}
