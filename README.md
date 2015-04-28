cordova-android-email
=====================

Cordova plugin to retrieve Android user email account.  We rely on Google Play Services instead of asking user android.permission.GET_ACCOUNTS

Instead of asking the above permission for only getting user e-mail, we use Google Play Services and to install Google Play Services, the plugin has a dependency on the following plugin: https://github.com/MobileChromeApps/google-play-services

Following SO post gave us the idea to wrap the code in a Cordova plugin:
http://stackoverflow.com/questions/6502017/getting-android-owners-email-address-nicely/19444640#19444640

To quote from the post:
> If your app has the GET_ACCOUNTS permission and there's only one account, you get it right away. If your app doesn't have it, or if there are more than one account, users get a prompt so they can authorize or not the action.

> Your app needs to include the Google Play Services but it doesn't need any permissions.

> This whole process will fail on older versions of Android (2.2+ is required), or if Google Play is not available so you should consider that case.

##Installing the plugin
To add this plugin just type:
```cordova plugin add https://github.com/ccsoft/cordova-android-email.git```

To remove this plugin type:
```cordova plugin remove com.ccsoft.plugin.AndroidEmail```

The plugin has the following method only:

##Usage
* [getEmail](#getEmail)
Retrieves the email with success callback. Error callback is called with error message when needed.
```
var plugin = new CC.AndroidEmail();
plugin.getEmail(
  function(email) {
  	// Use email
  },
  function(error) {
  	// Handle error
  }
)
```

##Versions
Tested with Cordova 3.6
