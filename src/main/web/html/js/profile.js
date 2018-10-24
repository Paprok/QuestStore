var isNicknameBeingChanged = false;

function changeNickname(){
    if (isNicknameBeingChanged){
        document.getElementById("title").innerHTML = document.getElementById("nickname-input").value;
        
        isNicknameBeingChanged = false;
        
        document.getElementById("nickname").style.display = "flex";
        document.getElementById("nickname-input").style.display = "none";
        document.getElementById("edit-nickname-button").innerHTML = "Edit nickname";
    } else {
        isNicknameBeingChanged = true;
        
        document.getElementById("nickname").style.display = "none";
        document.getElementById("nickname-input").style.display = "initial";
        document.getElementById("nickname-input").value = document.getElementById("title").innerHTML;
        document.getElementById("edit-nickname-button").innerHTML = "Save";
    }
}