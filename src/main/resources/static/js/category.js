function showEmptyMessage() {
    const emptyMessage = document.createElement('div');
    emptyMessage.classList.add('card');
    const cardBody = document.createElement('div');
    cardBody.classList.add('card-body');
    const cardTitle = document.createElement('h5');
    cardTitle.classList.add('card-title');
    cardTitle.textContent = "It's still empty here...";
    cardBody.appendChild(cardTitle);
    emptyMessage.appendChild(cardBody);
    document.querySelector('.menu-container').appendChild(emptyMessage);
}

if (!document.querySelector('.card')) {
    setTimeout(showEmptyMessage, 2000);
}

const categoryCards = document.querySelectorAll('.category-card');

categoryCards.forEach(card => {
    card.addEventListener('mouseover', () => {
        card.style.transform = 'translateY(-10px)';
        card.style.transition = 'transform 0.3s ease';
    });

    card.addEventListener('mouseout', () => {
        card.style.transform = 'translateY(0)';
    });
});

document.body.style.opacity = 0;
window.addEventListener('DOMContentLoaded', () => {
    document.body.style.transition = 'opacity 1s';
    document.body.style.opacity = 1;
});