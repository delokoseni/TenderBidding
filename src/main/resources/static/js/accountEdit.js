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
            return response.text().then(errorMessage => {
                alert('Ошибка при сохранении: ' + errorMessage); // Обработка ошибок с сообщением
            });
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
            return response.text().then(errorMessage => {
                alert('Ошибка при сохранении ИНН: ' + errorMessage); // Обработка ошибок с сообщением
            });
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
            return response.text().then(errorMessage => {
                alert('Ошибка при сохранении ОГРН/ОГРНИП: ' + errorMessage); // Обработка ошибок с сообщением
            });
        }
    });
}

function saveOwnershipType() {
    const newOwnershipType = document.getElementById("ownershipTypeInput").value;
    const currentUserEmail = document.getElementById("currentUserEmail").value;

    fetch('/updateOwnershipType', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ newOwnershipType, email: currentUserEmail })
    })
    .then(response => {
        if (response.ok) {
            document.getElementById("ownershipTypeInput").setAttribute("readonly", "true");
            document.getElementById("ownershipTypeInput").style.display = "none"; // Скрыть выпадающий список
            document.getElementById("editOwnershipTypeButton").style.display = "inline-block"; // Показать кнопку "Изменить"
            document.getElementById("saveOwnershipTypeButton").style.display = "none"; // Скрыть кнопку "Сохранить"
            window.location.reload(); // Перезагрузить страницу для обновления данных
        } else {
            return response.text().then(errorMessage => {
                alert('Ошибка при сохранении формы собственности: ' + errorMessage); // Обработка ошибок с сообщением
            });
        }
    });
}

function saveEstablishmentDate() {
    const newEstablishmentDate = document.getElementById("establishmentDateInput").value;
    const currentUserEmail = document.getElementById("currentUserEmail").value;

    fetch('/updateEstablishmentDate', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ newEstablishmentDate: newEstablishmentDate, email: currentUserEmail })
    })
    .then(response => {
        if (response.ok) {
            document.getElementById("establishmentDateInput").setAttribute("readonly", "true");
            document.getElementById("editEstablishmentDateButton").style.display = "inline-block"; // Показать кнопку "Изменить"
            document.getElementById("saveEstablishmentDateButton").style.display = "none"; // Скрыть кнопку "Сохранить"
            window.location.reload(); // Перезагрузить страницу для обновления данных
        } else {
            alert('Ошибка при сохранении даты основания.'); // Обработка ошибок
        }
    });
}

function saveEmail() {
    const newEmail = document.getElementById("emailInput").value;
    const currentUserEmail = document.getElementById("currentUserEmail").value; // Получаем текущий email пользователя

    fetch('/updateEmail', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ newEmail: newEmail, email: currentUserEmail })
    })
    .then(response => {
        if (response.ok) {
            document.getElementById("emailInput").setAttribute("readonly", "true");
            document.getElementById("editEmailButton").style.display = "inline-block"; // Показать кнопку "Изменить"
            document.getElementById("saveEmailButton").style.display = "none"; // Скрыть кнопку "Сохранить"
            window.location.reload(); // Перезагрузить страницу для обновления данных
        } else {
            return response.text().then(errorMessage => {
                alert('Ошибка при сохранении email: ' + errorMessage); // Обработка ошибок с сообщением
            });
        }
    });
}
