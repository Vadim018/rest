$(document).ready(function() {
    setTimeout(function() {
        $('.card').removeClass('hidden');
    }, 2000);

    $('.peephole').click(function() {
        const input = $(this).siblings('input');
        const icon = $(this).children('i');
        if (input.attr('type') === 'password') {
            input.attr('type', 'text');
            icon.removeClass('fa-eye').addClass('fa-eye-slash');
        } else {
            input.attr('type', 'password');
            icon.removeClass('fa-eye-slash').addClass('fa-eye');
        }
    });
});