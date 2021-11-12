const nameBtn = document.querySelector('.userName');
const passwordBtn = document.querySelector('.userPassword');
const loginBtn = document.querySelector('.loginBtn');

function goToMain(){
    location.href = "main.html"
}

nameBtn.addEventListener('keyup', function(){
    let nameLength = nameBtn.value.length;
    let passwordLength = passwordBtn.value.length;

    if(nameLength >= 1 && passwordLength >= 5 && nameBtn.value.indexOf('@') !== -1 ){
        loginBtn.style.backgroundColor = "#0095f6"; 
        loginBtn.addEventListener('click', goToMain)       
    } else {
        loginBtn.style.backgroundColor = "#b2dffc";
    }
});

passwordBtn.addEventListener('keyup', function(){
    let nameLength = nameBtn.value.length;
    let passwordLength = passwordBtn.value.length;

    if(nameLength >= 1 && passwordLength >= 5 && nameBtn.value.indexOf('@') !== -1){
        loginBtn.style.backgroundColor = "#0095f6"; 
        loginBtn.addEventListener('click', goToMain)       
    } else {
        loginBtn.style.backgroundColor = "#b2dffc";
    }
});



