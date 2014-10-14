cordova-android-email
=====================

Cordova plugin to retrieve Android user email account.  We rely on Google Play Services instead of asking user android.permission.GET_ACCOUNTS

Instead of asking the above permission for only getting user e-mail, we use Google Play Services and to install Google Play Services, the plugin has a dependency on the following plugin: https://github.com/MobileChromeApps/google-play-services

This post gave us the idea to wrap the code in a Cordova plugin: http://stackoverflow.com/questions/6502017/getting-android-owners-email-address-nicely/19444640#19444640

##Installing the plugin
To add this plugin just type:
```cordova plugin add https://github.com/ccsoft/cordova-android-email.git```

To remove this plugin type:
```cordova plugin remove com.ccsoft.plugin.AndroidEmail```

The plugin has the following method only:

##Usage
* [getEmail](#getEmail)
Retrieves the email with success callback

*** 

##Versions
Testing with Cordova 3.6
