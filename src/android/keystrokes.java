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

public class keystrokes extends CordovaPlugin {
    Activity activity = this.cordova.getActivity();
    private CallbackContext callback = null;
    
    // Not sure if this is needed
    /*
    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
       super.initialize(cordova, webView);
    }
    */
    
    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
        /*
        View view;
    	try {
    	    view = (View)webView.getClass().getMethod("getView").invoke(webView);
    	} catch (Exception e){
    	    view = (View)webView;
    	}
        */
        
        // Defining the callback
        if ("register".equals(action)) {
            this.callback = callbackContext;
        }
    }
    
}
    
public class activity extends Activity {
    
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
        return super.onKeyUp(keyCode, event);
    }
    
}

