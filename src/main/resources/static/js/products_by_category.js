$(document).ready(function () {
    function updateTotalPrice(card) {
        const pricePerUnit = parseFloat(card.data('price'));
        const quantity = parseInt(card.find("input[name='quantity']").val());
        const totalPrice = pricePerUnit * quantity;
        card.find('.total-price').text(totalPrice.toFixed(0));
    }

    function displayErrorMessage(message) {
        window.alert(message);
    }

    function validateQuantityInput(input) {
        const value = parseInt(input.val());
        if (isNaN(value) || value <= 0) {
            displayErrorMessage('Невірно введено дані. Будь ласка, повторіть спробу!');
            input.val(1);
            return false;
        }
        return true;
    }

    $(".plus").on("click", function () {
        const card = $(this).closest('.card');
        const quantityInput = card.find("input[name='quantity']");
        let quantity = parseInt(quantityInput.val());
        quantity = quantity + 1;
        quantityInput.val(quantity);
        updateTotalPrice(card);
    });

    $(".minus").on("click", function () {
        const card = $(this).closest('.card');
        const quantityInput = card.find("input[name='quantity']");
        let quantity = parseInt(quantityInput.val());
        if (quantity > 1) {
            quantity = quantity - 1;
            quantityInput.val(quantity);
            updateTotalPrice(card);
        }
    });

    $(".counter button").on("click", function (event) {
        event.preventDefault();
    });

    $(".counter input").on("change", function () {
        const card = $(this).closest('.card');
        if (!validateQuantityInput($(this))) {
            updateTotalPrice(card);
        }
    });

    $('.add-to-cart-form').submit(function (event) {
        event.preventDefault();

        let form = $(this);
        let button = form.find('.add-to-cart-btn');
        let addedMessage = form.find('.added-message');
        let productId = form.find('input[name="id"]').val();

        button.prop('disabled', true);
        button.text('Додано');
        addedMessage.addClass('show');

        $.ajax({
            url: form.attr('action'),
            method: 'post',
            data: form.serialize(),
            success: function (response) {
                console.log('Додано до кошика!');
            },
            error: function () {
                console.log('Помилка!');
            }
        });
    });
});