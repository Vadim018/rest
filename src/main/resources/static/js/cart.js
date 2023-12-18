$(document).ready(() => {
    $('.minus').click(function () {
        let input =  $(this).parent().find('input');
        let count = parseInt(input.val()) - 1;
        count = count < 1 ? 1 : count;
        input.val(count);
        input.change();
        return false;});

    $('.plus').click(
        function () {
            let input = $(this).parent().find('input');
            let count = parseInt(input.val()) + 1;
            input.val(count);
            input.change();
            $(this).parent().find('.my_text').text('');
            return false;});});