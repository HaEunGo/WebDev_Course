// 텍스트 노드가 있는 요소 노드 생성
let btn1 = document.getElementById('btn1');

btn1.addEventListener('click', () => {
    // element 생성
    let title = document.createElement('h3');

    // 텍스트 노드 생성
    let textNode = document.createTextNode('안녕하세요.');

    title.appendChild(textNode);
    document.getElementById('area1').appendChild(title);

    // 아래 코드는 동일한 결과로 출력이 된다.
    // document.getElementById('area1').innerHTML = '<h3>안녕하세요.</h3>';
});

// 1112
// 텍스트 노드가 없는 요소 노드 생성
let btn2 = document.getElementById('btn2');

btn2.addEventListener('click', () => {
    // element 생성
    let img = document.createElement('img');

    // 속성 지정
    img.src = "../resources/image/flower1.PNG";
    img.setAttribute('width', '150px');
    img.setAttribute('height', '100px');
    // css나 기능 추가시 사용
    img.setAttribute('myAttr', 'p123');

    document.getElementById('area2').appendChild(img);
    
    document.getElementById('area2').innerHTML +=
        '<img src="../resources/image/flower2.PNG" width="150px" height="100px" myAttr="p123">';
});

// Node 객체 삭제
let btn3 = document.getElementById('btn3');

btn3.addEventListener('click', (event) => {
    // 직접 읽어와서 삭제하는 법
    document.getElementById('area1').remove();
    // 자식을 통해 삭제하는 법
    document.body.removeChild(document.getElementById('area2'));
    event.target.parentNode.removeChild(document.getElementById('area3'));
});