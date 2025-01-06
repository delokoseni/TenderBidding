function enableEditing() {
    document.getElementById("organizationInput").removeAttribute("readonly");
    document.getElementById("editButton").style.display = "none"; // Скрыть кнопку "Изменить"
    document.getElementById("saveButton").style.display = "inline-block"; // Показать кнопку "Сохранить"
}

function saveOrganizationName() {
    const newName = document.getElementById("organizationInput").value;

    // Отправка данных методом POST
    fetch('/updateOrganizationName', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ newOrganizationName: newName })
    })
    .then(response => {
        if (response.ok) {
            document.getElementById("organizationInput").setAttribute("readonly", "true");
            document.getElementById("editButton").style.display = "inline-block"; // Показать кнопку "Изменить"
            document.getElementById("saveButton").style.display = "none"; // Скрыть кнопку "Сохранить"
            window.location.reload(); // Перезагрузить страницу для обновления данных
        } else {
            alert('Ошибка при сохранении.'); // Обработка ошибок
        }
    });
}
