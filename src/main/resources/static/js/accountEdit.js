function enableEditing(inputId, editButtonId, saveButtonId) {
    document.getElementById(inputId).removeAttribute("readonly");
    document.getElementById(inputId).removeAttribute("disabled");
    document.getElementById(editButtonId).style.display = "none"; // Скрыть кнопку "Изменить"
    document.getElementById(saveButtonId).style.display = "inline-block"; // Показать кнопку "Сохранить"
    document.getElementById(inputId).focus();
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
            const inputElement = document.getElementById("ownershipTypeInput");
            inputElement.setAttribute("disabled", "true"); // Запретить изменения после сохранения
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

function saveOkved() {
    const newOkved = document.getElementById("okvedInput").value;
    const currentUserEmail = document.getElementById("currentUserEmail").value;

    fetch('/updateOkved', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ newOkved, email: currentUserEmail })
    })
    .then(response => {
        if (response.ok) {
            const inputElement = document.getElementById("okvedInput");
            inputElement.setAttribute("disabled", "true"); // Запретить изменения после сохранения
            document.getElementById("editOkvedButton").style.display = "inline-block"; // Показать кнопку "Изменить"
            document.getElementById("saveOkvedButton").style.display = "none"; // Скрыть кнопку "Сохранить"
            window.location.reload(); // Перезагрузить страницу для обновления данных
        } else {
            return response.text().then(errorMessage => {
                alert('Ошибка при сохранении ОКВЭД: ' + errorMessage); // Обработка ошибок с сообщением
            });
        }
    });
}

function openChangePasswordModal() {
    document.getElementById('changePasswordModal').style.display = 'block';
}

function closeChangePasswordModal() {
    document.getElementById('changePasswordModal').style.display = 'none';
    document.getElementById('oldPassword').value = '';
    document.getElementById('newPassword').value = '';
    document.getElementById('confirmPassword').value = '';
}


// Закрытие окна при клике вне его
window.onclick = function(event) {
    const modal = document.getElementById('changePasswordModal');
    if (event.target == modal) {
        closeChangePasswordModal();
    }
}

function changePassword(event) {
    event.preventDefault(); // Предотвращаем отправку формы

    const oldPassword = document.getElementById('oldPassword').value;
    const newPassword = document.getElementById('newPassword').value;
    const confirmPassword = document.getElementById('confirmPassword').value;

    if (newPassword !== confirmPassword) {
        alert('Новый пароль не совпадает с подтверждением!');
        return;
    }

    // Здесь добавьте код для отправки старого и нового паролей на сервер
    fetch('/changePassword', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            oldPassword: oldPassword,
            newPassword: newPassword
        })
    }).then(response => {
        if (response.ok) {
            alert('Пароль успешно изменён!');
            closeChangePasswordModal();
        } else {
            response.text().then(errorMessage => {
                alert('Ошибка: ' + errorMessage);
            });
        }
    });
}

