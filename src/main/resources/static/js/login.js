setTimeout(function() {
    const loginCard = document.getElementById("loginCard");
    loginCard.style.display = "block";
    loginCard.classList.add("fadeIn");
}, 2000);

const togglePassword = document.getElementById("togglePassword");
const password = document.getElementById("password");

togglePassword.addEventListener("click", function () {
    const type = password.getAttribute("type") === "password" ? "text" : "password";
    password.setAttribute("type", type);
    togglePassword.querySelector("i").classList.toggle("fa-eye");
    togglePassword.querySelector("i").classList.toggle("fa-eye-slash");
});