var whatsExport = {};

whatsExport.sendMessage = function(messageInfo, successCallback, errorCallback) {
    if (messageInfo == null || typeof messageInfo !== 'object') {
    
        if (errorCallback) {
            errorCallback({
                code: "INVALID_INPUT",
                message: "Invalid Input"
            });
        }
       
        return;
    }
           
    var phoneNumber = messageInfo.phoneNumber;
           
    if (! phoneNumber) {
        console.log("Missing Phone Number");
    
        if (errorCallback) {
            errorCallback({
                code: "MISSING_PHONE_NUMBER",
                message: "Missing Phone number"
            });
        }
           
        return;
    }
           
    cordova.exec(successCallback, errorCallback, "Whats", "sendMessage", [phoneNumber]);
};

module.exports = whatsExport;
