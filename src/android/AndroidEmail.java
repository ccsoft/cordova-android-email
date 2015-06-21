package com.ccsoft.plugin;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.AccountPicker;

import android.accounts.AccountManager;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.util.Log;

public class AndroidEmail extends CordovaPlugin {	
	private final String TAG = "AndroidEmail";
	private static final int REQUEST_CODE_EMAIL = 1;
	private CallbackContext _callbackContext = null;
	
    @Override
    public boolean execute(String action, JSONArray args,
			final CallbackContext callbackContext) throws JSONException {
    	Log.i(TAG, "action:" + action);
    	cordova.setActivityResultCallback(this);
    	
    	if (action.equals("getEmail")) {
    		_callbackContext = callbackContext;
    		Runnable runnable = new Runnable() {
    			public void run() {
    				try {
    	    	        Intent intent = AccountPicker.newChooseAccountIntent(null, null,
    	    	                new String[] { GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE }, true, null, null, null, null);
    	    	        cordova.getActivity().startActivityForResult(intent, REQUEST_CODE_EMAIL);
    	    	    } catch (ActivityNotFoundException e) {
    	    	       	Log.e(TAG, "Activity not found: " + e.toString() );
    	    	       	_callbackContext.error("Plugin cannot find activity: " + e.toString());
    	    	    } catch (Exception e) {
    	    	    	Log.e(TAG, "Exception: " + e.toString() );
    	    	    	_callbackContext.error("Plugin failed to get email: " + e.toString());
    	    	    }
    			};
    		};
    		cordova.getActivity().runOnUiThread(runnable);
    		return true;
    	}
        return false;
    }
    
    @Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
    	if (_callbackContext != null){            
    		try {
		        if (requestCode == REQUEST_CODE_EMAIL && _callbackContext != null /*&& resultCode == RESULT_OK*/) {
		            String accountName = data.getStringExtra(AccountManager.KEY_ACCOUNT_NAME);
		            _callbackContext.success(accountName);
		        } else {
		        	_callbackContext.error("plugin failed to get email");	        	
		        }
    		} catch (Exception e) {
    			_callbackContext.error("Plugin failed to get email: " + e.toString());
    			Log.e(TAG, "Exception: " + e.toString() );
    		}
        } else {
        	Log.d(TAG, "No callback to go to!");
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
