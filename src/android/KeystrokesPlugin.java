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

// http://www.polyglotprogramminginc.com/interacting-with-the-android-lifecycle-in-a-cordova-plugin/
// http://stackoverflow.com/questions/32776877/cordova-custom-plugin-with-third-party-native-android-library-not-working

public class KeystrokesPlugin extends CordovaPlugin {
    
    private CallbackContext callback = null;
	
    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
       super.initialize(cordova, webView);
       
       Context context = cordova.getActivity().getApplicationContext();
       Intent intent = new Intent(context);

       cordova.startActivityForResult(new KeystrokesActivity(callback), intent, 0);
       
    }

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
        
        // Defining the callback
        if ("register".equals(action)) {
            PluginResult result = new PluginResult(PluginResult.Status.NO_RESULT);
            result.setKeepCallback(true);
            this.callback = callbackContext;
        }
        
        return true;
    }
    
}
