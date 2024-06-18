
function validateAnswer(){
    let selectedOption = document.querySelector('input[name="userAnswer"]:checked');
    let answerAlert = document.getElementById('answer-alert');

    if(!selectedOption){
        answerAlert.style.display = 'block';
        return false;
    }
    else {
        answerAlert.style.display = 'none';
        return true;
    }
}

function validateForm(){
    let answerAlert = document.getElementById('answer-alert');

    if(answerAlert.innerText.trim()==="Incorrect"){
        makeScreenRed()
        document.getElementById('quiz-form').style.display = 'none';
        document.getElementById('timer-message').innerHTML = "Wrong answer. Game is over.";
        answerAlert.style.display='block';
        document.getElementById('reset-button').style.display='block';
        }
    else if (answerAlert.innerText.trim()==="Correct!") {
        makeScreenGreen();
    }
}

function makeScreenGreen(){
    let opacity = 1;
    const interval = 20;
    const duration = 1000;
    const steps = duration/interval;

    const intervalId = setInterval(function(){
        document.body.style.backgroundColor = 'rgba(144, 238, 144, ${opacity})';
        opacity -=1/steps;

        if(opacity <=0){
            clearInterval(intervalId);
            document.body.style.backgroundColor='';
        }
    }, interval);
}

function makeScreenRed(){
    let opacity = 1;
    const interval = 20;
    const duration = 1500;
    const steps = duration/interval;

    const intervalId = setInterval(function(){
        document.body.style.backgroundColor = 'rgba(220, 20, 60, ${opacity})';
        opacity -=1/steps;

        if(opacity <=0){
            clearInterval(intervalId);
            document.body.style.backgroundColor='';
        }
    }, interval);
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
    window,location.href="index.jsp";
}