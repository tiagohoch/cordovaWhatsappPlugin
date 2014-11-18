package com.hochkraft.plugins.whatsapp;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import 	android.content.Context;

/**
 * This class echoes a string called from JavaScript.
 */
//Changed from CDNsms to sms
public class Whats extends CordovaPlugin {

    
    private static final String FEATURE_NOT_SUPPORTED = "FEATURE_NOT_SUPPORTED";
public static final String ACTION_DIAL_NUMBER = "dialNumber";
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
         if (ACTION_DIAL_NUMBER.equals(action)) {
            String phoneNumber = args.getString(0);
            String message = args.getString(1);

          

            return this.sendMessage(phoneNumber,message, callbackContext);

            //return true;
        }

        return false;
    }

    private boolean sendMessage(String phoneNumber,String message, final CallbackContext callbackContext) throws JSONException {
       // boolean isWhatsappInstalled = whatsappInstalledOrNot("com.whatsapp");
        //if (isWhatsappInstalled) {
            Uri uri = Uri.parse("smsto:" + "55"+phoneNumber);
            Intent sendIntent = new Intent(Intent.ACTION_SENDTO, uri);
            sendIntent.putExtra(Intent.EXTRA_TEXT, message);
            sendIntent.setType("text/plain");
            sendIntent.setPackage("com.whatsapp");
        Context context =  cordova.getActivity().getApplicationContext();
            context.startActivity(sendIntent);
            return true;
       // } else {
//            Toast.makeText(this, "WhatsApp not Installed",
//                    Toast.LENGTH_SHORT).show();
//            Uri uri = Uri.parse("market://details?id=com.whatsapp");
//            Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
//            startActivity(goToMarket);
        //    return false;
       // }

    }

   
}
