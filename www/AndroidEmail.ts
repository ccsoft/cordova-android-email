/// <reference path="androidemail.d.ts"/>

module CC {
    export class AndroidEmail implements IAndroidEmail {
        getEmail(successcb: (email: string) => void, failcb?: (error: string) => void) {
            if (!(<any>window).cordova) {
                if (failcb) failcb("no cordova");
                return;
            }
            (<any>window).cordova.exec(
                (response) => {                    
                    successcb(response);
                },
                (err) => {
                    console.log("getEmail call failed with error: " + err);
                    if (failcb) failcb(err);
                }, "AndroidEmail", "getEmail", []);
        }        
    }
}
declare var module;
module.exports = CC;
