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

// http://www.polyglotprogramminginc.com/interacting-with-the-android-lifecycle-in-a-cordova-plugin/
//http://stackoverflow.com/questions/32776877/cordova-custom-plugin-with-third-party-native-android-library-not-working

public class keystrokes extends CordovaPlugin {
    //Activity activity = this.cordova.getActivity();
    private CallbackContext callback = null;
    
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
        
        return true;
    }
    
}

