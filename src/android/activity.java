package il.co.pnc.cordova.keystrokes;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.KeyEvent;
import android.view.*;

import android.webkit.WebView;

public class Activity extends WebView implements CordovaWebView {
    
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        // Grab the "Key" character
        String key = "";
        if (event != null) {
            key = String.valueOf((char)event.getUnicodeChar());
        } else {
            key = String.valueOf(Character.toChars(keyCode)[0]);
        }
        // Submit it back to the Javascript Callback function
        /*PluginResult result = new PluginResult(PluginResult.Status.OK, key);
        result.setKeepCallback(true);
        this.callback.sendPluginResult(result);*/
        // Pass on the event to Android
		PluginResult result = new PluginResult(PluginResult.Status.OK, key);
        result.setKeepCallback(true);
		Keystrokes.getInstance().sendPluginResult(result);
		
        return super.onKeyUp(keyCode, event);
    }
    
}
