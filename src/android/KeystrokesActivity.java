package il.co.pnc.cordova.keystrokes;

import android.content.Intent;
import android.content.Context;

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

public class KeystrokesActivity extends Activity {
    
    private CallbackContext callback;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {	
	 Intent intent = getIntent();
   	 this.callback = intent.getStringExtra("callback");
	      
    }

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
        PluginResult result = new PluginResult(PluginResult.Status.OK, key);
        callback.sendPluginResult(result);
		// Pass on the event to Android
        return super.onKeyUp(keyCode, event);
    }
    
}
