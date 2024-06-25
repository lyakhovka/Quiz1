
function validateAnswer(){
    let selectedOption = document.querySelector('input[name="userAnswer"]:checked');
    let answerAlert = document.getElementById('answer-alert');
    if(!selectedOption){
        return false;
    }
    else {
        return true;
    }
}

function validateForm(){
    let answerAlert = document.getElementById('answer-alert');
    if(answerAlert.innerText.trim()==="INCORRECT."){
        answerAlert.style.display = 'block';
        answerAlert.style.color = 'red';
        answerAlert.style.backgroundColor = '#ffc107';
        setTimeout(function() {
            answerAlert.style.display = 'none';
        }, 300);
        }
    else if (answerAlert.innerText.trim()==="CORRECT!") {
        answerAlert.style.display = 'block';
        answerAlert.style.color = 'green';
        answerAlert.style.backgroundColor = '#d1f9c9';
        setTimeout(function() {
            answerAlert.style.display = 'none';
        }, 300);
    }
}

window.onload = function (){
    validateForm();
}

function restartGame(){
    let restartInput = document.createElement('input');
    restartInput.type = 'hidden';
    restartInput.name = 'restartButton';
    restartInput.value = 'true';
    document.getElementById('quiz-form').appendChild(restartInput);
    document.getElementById('quiz-form').submit();
}

function goHome(){
    window.location.href="index.jsp";
}