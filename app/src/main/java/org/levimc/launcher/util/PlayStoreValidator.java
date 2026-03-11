package org.levimc.launcher.util;

import android.content.Context;

/**
 * PlayStoreValidator - License Check Bypass
 * Location: app/src/main/java/org/levimc/launcher/util/PlayStoreValidator.java
 */
public class PlayStoreValidator {

    // ========================================
    // LICENSE BYPASS - ALWAYS RETURNS TRUE
    // ========================================
    
    private static final boolean BYPASS_LICENSE_CHECK = true;  // Set to false to enable real check
    
    /**
     * Main license verification method - BYPASSED
     */
    public static boolean isLicenseVerified(Context context) {
        if (BYPASS_LICENSE_CHECK) {
            return true;  // Bypass enabled - always passes
        }
        return isMinecraftFromPlayStore(context);  // Real check
    }
    
    /**
     * Check if Minecraft is from Play Store - BYPASSED
     */
    public static boolean isMinecraftFromPlayStore(Context context) {
        if (BYPASS_LICENSE_CHECK) {
            return true;  // Bypass enabled - always passes
        }
        
        // Original check code (disabled when bypass is on)
        try {
            String installer = context.getPackageManager().getInstallerPackageName(context.getPackageName());
            return installer != null && installer.equals("com.android.vending");
        } catch (Exception e) {
            return false;
        }
    }
}
