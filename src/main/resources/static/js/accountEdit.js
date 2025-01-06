function enableEditing(inputId, editButtonId, saveButtonId) {
    document.getElementById(inputId).removeAttribute("readonly");
    document.getElementById(editButtonId).style.display = "none"; // Скрыть кнопку "Изменить"
    document.getElementById(saveButtonId).style.display = "inline-block"; // Показать кнопку "Сохранить"
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

function saveInn() {
    const newInn = document.getElementById("innInput").value;
    const currentUserEmail = document.getElementById("currentUserEmail").value;

    fetch('/updateInn', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ newInn: newInn, email: currentUserEmail })
    })
    .then(response => {
        if (response.ok) {
            document.getElementById("innInput").setAttribute("readonly", "true");
            document.getElementById("editInnButton").style.display = "inline-block"; // Показать кнопку "Изменить"
            document.getElementById("saveInnButton").style.display = "none"; // Скрыть кнопку "Сохранить"
            window.location.reload(); // Перезагрузить страницу для обновления данных
        } else {
            alert('Ошибка при сохранении ИНН.'); // Обработка ошибок
        }
    });
}

function saveOgrn() {
    const newOgrn = document.getElementById("ogrnInput").value;
    const currentUserEmail = document.getElementById("currentUserEmail").value;

    fetch('/updateOgrn', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ newOgrn: newOgrn, email: currentUserEmail })
    })
    .then(response => {
        if (response.ok) {
            document.getElementById("ogrnInput").setAttribute("readonly", "true");
            document.getElementById("editOgrnButton").style.display = "inline-block"; // Показать кнопку "Изменить"
            document.getElementById("saveOgrnButton").style.display = "none"; // Скрыть кнопку "Сохранить"
            window.location.reload(); // Перезагрузить страницу для обновления данных
        } else {
            alert('Ошибка при сохранении ОГРН/ОГРНИП.'); // Обработка ошибок
        }
    });
}

