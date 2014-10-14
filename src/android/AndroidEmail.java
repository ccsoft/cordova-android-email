package com.ccsoft.plugin;

import java.util.Dictionary;
import java.util.Hashtable;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import android.util.Log;

public class AndroidEmail extends CordovaPlugin {	
	private final String TAG = "AndroidEmail";
	private static final int REQUEST_CODE_EMAIL = 1;
    private TextView email = (TextView) findViewById(R.id.email);
		
    @Override
    public boolean execute(String action, JSONArray args,
			final CallbackContext callbackContext) throws JSONException {
    	Log.i(TAG, "action:" + action);

    	if (action.equals("getEmail")) {
    		try {
    	        Intent intent = AccountPicker.newChooseAccountIntent(null, null,
    	                new String[] { GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE }, false, null, null, null, null);
    	        startActivityForResult(intent, REQUEST_CODE_EMAIL);
    	    } catch (ActivityNotFoundException e) {
    	        // TODO
    	    }
    		return true;
    	}    	
    	
        return false;
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_EMAIL && resultCode == RESULT_OK) {
            String accountName = data.getStringExtra(AccountManager.KEY_ACCOUNT_NAME);
            email.setText(accountName);
        }
    }
}