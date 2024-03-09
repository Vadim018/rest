const backToTopButton = document.getElementById("back-to-top");
const scrollDuration = 1000;
const scrollOffset = 20;

window.addEventListener("scroll", function () {
    if (window.pageYOffset > scrollOffset) {
        backToTopButton.style.display = "block";
    } else {
        backToTopButton.style.display = "none";
    }
});

backToTopButton.addEventListener("click", function () {
    const currentPosition = window.pageYOffset;
    const startTime = performance.now();

    function scrollToTop(timestamp) {
        const elapsed = timestamp - startTime;
        const easing = easeOutQuad(Math.min(elapsed / scrollDuration, 1));
        window.scrollTo(0, currentPosition * (1 - easing));

        if (elapsed < scrollDuration) {
            window.requestAnimationFrame(scrollToTop);
        } else {
            window.scrollTo(0, 0);
        }
    }
    window.requestAnimationFrame(scrollToTop);
});

function easeOutQuad(t) {
    return t * (2 - t);
}

function toggleAdditionalInfo(button) {
    const card = button.parentNode;
    const additionalInfo = card.querySelector(".additional-info");
    const isExpanded = button.classList.contains("collapsed");

    if (isExpanded) {
        additionalInfo.style.display = "none";
        button.classList.remove("collapsed");
    } else {
        additionalInfo.style.display = "block";
        button.classList.add("collapsed");
    }
}

document.addEventListener('DOMContentLoaded', function() {
    let expandBtns = document.getElementsByClassName('expand-btn');

    for (let i = 0; i < expandBtns.length; i++) {
        expandBtns[i].addEventListener('click', function(event) {
            event.preventDefault();
            let info = this.previousElementSibling;
            info.classList.toggle('show');
        });
    }
});