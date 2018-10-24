  function resizeIframe() {
      var iFrameID = document.getElementById('content-iframe');
      if(iFrameID) {
            // here you can make the height, I delete it first, then I make it again
            iFrameID.height = "";
            iFrameID.height = iFrameID.contentWindow.document.body.scrollHeight + 100 + "px";
      }   
  }