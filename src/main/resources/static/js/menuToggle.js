const menuToggle = document.getElementById('menuToggle');
const sidebar = document.getElementById('sidebar');

// Открытие/закрытие меню при нажатии на "гамбургер"
menuToggle.addEventListener('click', () => {
    sidebar.classList.toggle('active');
});

// Закрытие меню при клике вне бокового меню
document.addEventListener('click', (event) => {
    if (!sidebar.contains(event.target) && !menuToggle.contains(event.target)) {
        sidebar.classList.remove('active');
    }
});
