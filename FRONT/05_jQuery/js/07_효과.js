$(document).ready(() => {
    // 효과
    // 1. show()와 hide()
    $('#show').on('click', () => {
        $('#imgFlower').show(1500, 'linear');
    });

    $('#show').on('click', () => {
        $('#imgFlower').hide(1500, 'swing');
    });

    $('#show').on('click', () => {
        // toggle 없이 효과를 구현하는 법 (none 여부에 따라 반영)
        if($('#imgFlower').css('display') === 'none') {
            $('#imgFlower').show(1500, 'linear');
        } else {
            $('#imgFlower').hide(1500, 'swing');
        }

        // toggle 쓰고 구현하는 법
        // $('#imgFlower').toggle(1500, 'swing');
    });

    // 2. slideDown()와 slideUp()
    $('.menu').on('click', (event) => {
        // let content = $(event.target).next();

        // if(content.css('display') === 'none') {
        //     content.slideDown(500, 'swing');
        // } else {
        //     content.slideUp(500, 'swing');
        // }

        // slideToggle()을 사용하여 slideDown, slideUp을 실행
        // $(event.target).next().slideToggle(500, 'swing');

        // 하나의 컨텐츠만 slideDown 되도록 수정 -> 같은 메뉴를 눌렀을 때 다시 닫게 하는 거 검색해보기 (if, 분기문?)
        $('.contents').slideUp(500, 'swing');
        $(event.target).next().slideDown(500, 'swing');
    });

    // 3. fadeIn()와 fadeOut()
    $('#fadeIn').on('click', () => {
        // $('#imgForest').fadeIn(1000);
        $('#imgForest').fadeIn('slow', 'linear');
    });

    $('#fadeOut').on('click', () => {
        // $('#imgForest').fadeOut(1000);
        $('#imgForest').fadeOut('fast', 'swing');
    });

    $('#fadeToggle').on('click', () => {
        $('#imgForest').fadeToggle(1000, 'swing');
    });

    $('imgForest').hover(
        (event) => {
            if(event.type === 'mouseenter') {
                $(event.target).fadeTo(500, 0.5);
            } else if (event.type === 'mouseleave') {
                $(event.target).fadeTo(500, 1);
            }
        }
    );
});