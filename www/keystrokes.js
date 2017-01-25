var keystrokes = {
  register:function(callback, onFail){
    cordova.exec(callback, onFail, 'keystrokes', 'register', []);
  }
};

module.exports = keystrokes;
