$(document).ready(() => {
    // 1 Content 관련 메소드
    //  1) html() 메소드

    // content 영역의 태그와 텍스트를 모두 가져온다. 
    console.log(`$('#content1').html() : ${$('#content1').html()}`);

    // content2에 content영역에 html 안의 내용들을 넣어준다.
    $('#content2').html($('#content1').html());

    // content2에 있는 자식태그 a에 속성부여
    $('#content2').children('a').attr('href', 'https://www.naver.com');

    // 조회시에는 하나만 가지고 오지만 값을 수정할 시 전부 변경된다.
    console.log(`$('.content').html() : ${$('.content').html()}`);
    
    // 콜백함수 : 원래 있던 내용을 가지고 올 수도 있고, return시 각 요소들의 내용들을 변경도 가능하다.
    $('.content').html((index, content) => {
        console.log(index, content);
        
        return `<h1>인덱스 ${index}, 내용 : ${content}</h1>`;
    });
    
    // $('.content').html('aaisdjijoe');
    
    // 2) text() 메소드
    console.log(`$('#content3').text() : ${$('#content3').text()}`);
    
    $('#content4').text($('#content3').text());
    
    // $('.content4').html('<b>aaisdjijoe</b>');
    
    console.log(`$('.content2').text() : ${$('.content2').text()}`);
    
    $('.content2').text((index, content) => {
        console.log(index, content);
        
        return `<h1>인덱스 ${index}, 내용 : ${content}</h1>`;
    })

    // 2. 요소 생성 및 제거 메소드
    //  1) 요소 생성
    //  문자열로 요소를 생성하는 방법
    let p1 = '<p>문자열로 요소를 생성</p>'

    // 자바 스크립트 DOM 메소드로 생성하는 방법
    let p2 = document.createElement('p');
    let textNode = document.createTextNode('DOM 메소드로 요소를 생성');

    p2.appendChild(textNode);

    // jQuery로 요소를 생성하는 방법 1
    let p3 = $('<p>').text('jQuery로 요소를 생성 1');

    // jQuery로 요소를 생성하는 방법 2
    let p4 = $('<p>jQuery로 요소를 생성 2</p>');

    console.log(p1);
    console.log(p2);
    console.log(p3);
    console.log(p4);

    $('#area1').append(p1, p2, p3, p4);

    // 2-1)요소 추가 1
    // $(A).append(B) : A 요소의 자식 요소로 B 요소를 뒷부분에 추가한다.
    $('#add1').append('<span>B</span>');
    
    // $(A).prepend(B) : A 요소의 자식 요소로 B 요소를 앞부분에 추가한다.
    $('#add2').prepend('<span>B</span>');
    
    // $(A).after(B) : A 요소의 형제 요소로 B 요소를 뒷부분에 추가한다.
    $('#add3').after('<span>B</span>');
    
    // $(A).before(B) : A 요소의 형제 요소로 B 요소를 앞부분에 추가한다.
    $('#add4').before('<span>B</span>');

    // 2-2)요소 추가 2
    // $(A).appendTo(B) : A 요소를 B 요소의 자식 요소로 뒷부분에 추가한다.
    $('<span>B</span>').appendTo('#add5');
    
    // $(A).prependTo(B) : A 요소를 B 요소의 자식 요소로 앞부분에 추가한다.
    $('<span>B</span>').prependTo($('#add6'));
    
    // $(A).insertAfter(B) : A 요소를 B 요소의 형제 요소로 뒷부분에 추가한다.
    $('<span>B</span>').insertAfter($('#add7'));
    
    // $(A).insertBefore(B) : A 요소를 B 요소의 형제 요소로 앞부분에 추가한다.
    $('<span>B</span>').insertBefore('#add8');

    // 3. 요소 복제 메소드
    // 복제할 요소에 이벤트 추가
    $('#item1').hover(
        // // 마우스 올렸을 때
        // // 선택된 요소에 클래스 속성값을 추가하는 메소드
        // () => {
        //     $('#item1').addClass('bg-hotpink');
        // },
        // // 마우스 뗐을 때
        // // 선택된 요소에 클래스 속성값을 제거하는 메소드
        // () => {
        //     $('#item1').removeClass('bg-hotpink');
        // }

        // 매개값으로 하나만 넘겼을 때
        // 콜백 함수 하나만 사용해서 동일하게 호출을 할 수 있다.
        (event) => {
            console.log(event);
            // toggleClass : 해당하는 요소에 클래스 속성값이 없으면 추가, 있으면 제거하는 메소드
            $(event.target).toggleClass('bg-hotpink');
        }
    );

    // 버튼 클릭 시 요소를 복제
    $('#btn1').click(() => {
        // 이벤트까지 복제하려면 매개값으로 ture를 전달한다. (생략 시 false이기 때문에 이벤트 반영 X)
        let copyItem = $('#item1').clone(true);

        $('#clone-result').append(copyItem);

        // clone-test에 있던 $('#item1') 요소의 위치가 #clone-result 위치로 이동된다.
        // $('#clone-result').append($('#item1'));
    });

    // 4. 요소 제거 메소드
    // 제거할 요소에 이벤트 추가
    $('#item2').hover(() => {
        $('#item2').toggleClass('bg-hotpink');
    });

    // empty 테스트
    // 요소.empty() : 선택된 요소의 자식 요소들을 제거한다.
    $('#empty').click(() => {
        $('#item2').empty();

        // $('#remove-test')의 모든 해당 자식 요소까지 한 번에 날아감
        // $('#remove-test').empty();
    });
    
    // remove 테스트
    // 요소.remove() : 선택된 요소를 제거 후, 제거된 요소를 리턴해준다. 단, 리턴되는 요소의 이벤트도 삭제된다.
    $('#remove').click(() => {
        let el = $('#item2').remove();

        console.log(el);

        $('#remove-result').append(el);
    });

    // detach 테스트
    // 요소.detach() : 선택된 요소를 제거 후 제거된 요소를 리턴해준다. 단, 리턴되는 요소의 이벤트는 삭제하지 않는다.
    $('#detach').click(() => {
        let el = $('#item2').detach();

        console.log(el);

        $('#remove-result').append(el);
    });

    // 5. 추가적인 메소드
    // 1) each 메소드
    // 객체 배열 생성
    let output = '';
    let arr = [
        {name: '네이버', link: 'https://www.naver.com'},
        {name: '구글', link: 'https://www.google.com'},
        {name: 'w3schools', link: 'https://www.w3schools.com'}
    ];

    // $.each(arr, (index, item) => {
    //     console.log(`index: ${index}, item.name: ${item.name}, item.link: ${item.link}`);

    //     output += `<h4><a href=${item.link}>${item.name}</a><h4>`;
    // });
    
    $(arr).each((index, item) => {
        console.log(`index: ${index}, item.name: ${item.name}, item.link: ${item.link}`);

        output += `<h4><a href=${item.link}>${item.name}</a><h4>`;
    });

    $('#each-test').html(output);
    // $('#each-test').append(output);

    $('#each-test>h4').each((index, item) => {
        console.log(index, item);

        $(item).addClass('bg-hotpink');
    });

    // 자바스크립트에서도 동일한 기능을 하는 메소드가 추가되었다.
    // 콜백함수를 쓸 때 어떤 매개값을 주는 지 모른다면 function형태로 만든 다음 확인하면 된다.
    arr.forEach((item, index, origin) => {
        console.log(item, index, origin);
    });

    // 1119
    // 2) extend 메소드
    let user = {
        name: '냐옹이',
        age: 21
    };

    console.log(user);

    $.extend(user, {job: '동물'});

    console.log(user);

    let user2 = {
        name: '똥똥이',
        hobby: ['산책', '새로운 친구 만나기', '음악듣기']
    }

    $.extend(user, user2);

    // 동일한 속성값이 있으면 두 번째로 전달된 객체로 덮어 씌워진다.
    // 결과적으로 특정값을 반환하는데 처음 값에 합쳐진 매개값이 출력된다.
    console.log(user);
    console.log(user2);
    console.log(result);

    // 3) noConflict 메소드
    // $('#ncTest').css('color', 'red');
    let jq = $.noConflict();

    jq('#ncTest').css('color', 'orange');
});