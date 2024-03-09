let totalQuantity = 0;
let totalCost = 0;

const itemRows = document.querySelectorAll('.table-bordered tbody tr');
itemRows.forEach(row => {
    const quantity = parseInt(row.children[1].textContent);
    const cost = parseFloat(row.children[3].textContent);
    totalQuantity += quantity;
    totalCost += cost;
});

document.getElementById('totalQuantity').textContent = totalQuantity;
document.getElementById('totalCost').textContent = totalCost.toFixed(2);

let isCardPayment = false;

function handlePaymentChange(selectElement) {
    let paymentDetailsForm = document.getElementById("paymentDetailsForm");
    let submitButton = document.getElementById("submitButton");
    let paymentValue = selectElement.value;

    if (paymentValue === "card") {
        paymentDetailsForm.style.display = "block";
        submitButton.disabled = true;
    } else {
        paymentDetailsForm.style.display = "none";
        submitButton.disabled = false;
    }
}

function validateForm() {
    let firstName = document.getElementById("firstName").value.trim();
    let lastName = document.getElementById("lastName").value.trim();
    let phone = document.getElementById("phone").value.trim();
    let email = document.getElementById("email").value.trim();
    let address = document.getElementById("address").value.trim();
    let submitButton = document.getElementById("submitButton");

    if (firstName === "" || lastName === "" || phone === "" || email === "" || address === "") {
        alert("Будь ласка, заповніть всі обов'язкові поля");
        submitButton.disabled = true;
        return false;
    }

    if (firstName.length < 2 || firstName.length > 14) {
        alert("Ім'я має містити від 2 до 14 символів");
        submitButton.disabled = true;
        return false;
    }

    if (lastName.length < 2 || lastName.length > 14) {
        alert("Прізвище має містити від 2 до 14 символів");
        submitButton.disabled = true;
        return false;
    }

    let phoneRegex = /^\+?\d{10}$/;
    if (!phoneRegex.test(phone)) {
        alert("Будь ласка, введіть коректний номер телефону (10 цифр)");
        submitButton.disabled = true;
        return false;
    }

    if (!email.includes("@")) {
        alert("Будь ласка, введіть коректну адресу електронної пошти");
        submitButton.disabled = true;
        return false;
    }

    if (isCardPayment) {
        let cardNumber = document.getElementById("cardNumber").value.trim();
        let cardCVV = document.getElementById("cardCVV").value.trim();
        let cardExpiry = document.getElementById("cardExpiry").value.trim();

        if (cardNumber === "" || cardCVV === "" || cardExpiry === "") {
            alert("Будь ласка, заповніть всі обов'язкові поля");
            submitButton.disabled = true;
            return false;
        }

        let cardNumberRegex = /^\d{4}\s\d{4}\s\d{4}\s\d{4}$/;
        if (!cardNumberRegex.test(cardNumber)) {
            alert("Будь ласка, введіть номер карти у форматі: **** **** **** **** (лише цифри)");
            submitButton.disabled = true;
            return false;
        }

        let CVVRegex = /^\d{3}$/;
        if (!CVVRegex.test(cardCVV)) {
            alert("Будь ласка, введіть CVV у форматі: ***");
            submitButton.disabled = true;
            return false;
        }

        let expiryRegex = /^(0[1-9]|1[0-2])\/\d{2}$/;
        if (!expiryRegex.test(cardExpiry)) {
            alert("Будь ласка, введіть дату дійсності у форматі: MM/YY");
            submitButton.disabled = true;
            return false;
        }
    }
    return true;
}

function validateCardDetails() {
    let cardNumber = document.getElementById("cardNumber").value.trim();
    let cardCVV = document.getElementById("cardCVV").value.trim();
    let cardExpiry = document.getElementById("cardExpiry").value.trim();

    if (cardNumber === "" || cardCVV === "" || cardExpiry === "") {
        alert("Будь ласка, заповніть всі обов'язкові поля");
        return;
    }

    let cardNumberRegex = /^\d{4}\s\d{4}\s\d{4}\s\d{4}$/;
    if (!cardNumberRegex.test(cardNumber)) {
        alert("Будь ласка, введіть номер карти у форматі: **** **** **** **** (лише цифри)");
        return;
    }

    let CVVRegex = /^\d{3}$/;
    if (!CVVRegex.test(cardCVV)) {
        alert("Будь ласка, введіть CVV у форматі: ***");
        return;
    }

    let expiryRegex = /^(0[1-9]|1[0-2])\/\d{2}$/;
    if (!expiryRegex.test(cardExpiry)) {
        alert("Будь ласка, введіть дату дійсності у форматі: MM/YY");
        return;
    }

    alert("Дані карти успішно перевірені!");

    let submitButton = document.getElementById("submitButton");
    submitButton.disabled = false;

    document.getElementById("cardNumber").readOnly = true;
    document.getElementById("cardCVV").readOnly = true;
    document.getElementById("cardExpiry").readOnly = true;
}