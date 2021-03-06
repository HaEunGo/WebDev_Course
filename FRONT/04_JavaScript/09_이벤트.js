// 이벤트 모델의 종류
// 1) 고전 이벤트 모델
let btn1 = document.getElementById('btn1');
let btn2 = document.getElementById('btn2');

btn1.onclick = () => {
    alert('btn1이 클릭되었습니다.');
};

btn2.onclick = () => {
    alert('btn2이 클릭되면서 btn1의 이벤트를 제거하였습니다.');

    // btn1 이벤트 제거됨
    btn1.onclick = null;
};

// 2) 인라인 이벤트 모델
function test1() {
    alert('이벤트에 당첨되셨습니다.')
};

// 3) 표준 이벤트 모델
let btn3 = document.getElementById('btn3');

// 콜백 함수로 넘겨줄 때, 함수를 참조할 수 있는 레퍼런스 값을 전달해줘야 한다.
// 함수 호출하고 그 결과 값을 출력 -> undefined
// btn3.addEventListener('click', clickEventHandler());
// 함수명으로 매개값을 전달할 시 콜백 함수로 전달 됨
btn3.addEventListener('click', clickEventHandler);
btn3.addEventListener('mouseenter', (event) => {
    event.target.style.backgroundColor = 'salmon';

    console.log(event);
});
btn3.addEventListener('mouseout', (event) => {
    event.target.style.backgroundColor = 'green';

    console.log(event);
});

function clickEventHandler() {
    alert('표준 이벤트 모델');
}

// 이벤트가 발생한 해당 요소 객체에 접근하는 방법
// 1) 고전 이벤트 방식
let btn4 = document.getElementById('btn4');
// btn4.onclick = function(event) {
//     console.log(event.target);
//     console.log(window.event.target);
//     console.log(this);
// };

btn4.onclick = (event) => {
    console.log(event.target);
    console.log(window.event.target);
    // console.log(this);
};

// 2) 인라인 이벤트 방식
function test2(event) {
    // 매개값으로 이벤트 객체를 가져올 수 없다.
    console.log(event);
    
    console.log(window.event.target);
    // window 객체를 가리킨다.
    console.log(this);
};

// 3) 표준 이벤트 방식
let btn5 = document.getElementById('btn5');

// btn5.addEventListener('click', function(event) {
//     console.log(event.target);
//     console.log(window.event.target);
    // console.log(this);
// });

btn5.addEventListener('click', (event) => {
    console.log(event.target);
    console.log(window.event.target);
    // console.log(this);
});

// 태그별 기본적으로 가지고 있는 이벤트 제거
// 1) 기본 이벤트 제거 1
function test3() {
    let pass1 = document.getElementById('pass1').value;
    let pass2 = document.getElementById('pass2').value;

    console.log(pass1);
    console.log(pass2);

    if(pass1 !== pass2) {
        alert('비밀번호가 일치하지 않습니다.');

        return false;
    }
}

// 2) 기본 이벤트 제거 2
let submit = document.getElementById('submit');

// submit.onclick = () => {
//     alert('아이디를 정상적으로 입력해 주세요.');

//     return false;
// }

submit.addEventListener('click', (event) => {
    let userId = document.getElementById('userId').value;
    // 정규표현식 사용
    let regExp = /^[a-zA-Z0-9]{5,12}$/;

    console.log(userId);
    // 영문자, 숫자로만 총 5 ~ 12자 사이로 입력해 주세요.
    if (!regExp.test(userId)) {
        alert('아이디를 정상적으로 입력해 주세요.');
        
        event.preventDefault();
    }
});