/// <reference path="androidemail.d.ts"/>
var CC;
(function (CC) {
    var AndroidEmail = (function () {
        function AndroidEmail() {
        }
        AndroidEmail.prototype.getEmail = function (successcb, failcb) {
            if (!window.cordova) {
                if (failcb)
                    failcb("no cordova");
                return;
            }
            window.cordova.exec(function (response) {
                successcb(response);
            }, function (err) {
                console.log("getEmail call failed with error: " + err);
                if (failcb)
                    failcb(err);
            }, "AndroidEmail", "getEmail", []);
        };
        return AndroidEmail;
    })();
    CC.AndroidEmail = AndroidEmail;
})(CC || (CC = {}));

module.exports = CC;
