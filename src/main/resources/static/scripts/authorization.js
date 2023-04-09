const authView = {
    card: document.querySelector("#auth_div"),
    toRegButton: document.querySelector("#auth_to_reg_button")
};

const regView = {
    card: document.querySelector("#reg_div"),
    loginField: document.querySelector("#reg_login"),
    emailField: document.querySelector("#reg_email"),
    phoneField: document.querySelector("#reg_phone"),
    passwordField: document.querySelector("#reg_password"),
    repPasswordField: document.querySelector("#reg_rep_password"),
    submitButton: document.querySelector("#reg_submit_button"),
    toBackButton: document.querySelector("#reg_to_back_button")
};


authView.toRegButton.addEventListener("click", function() {
    document.getElementById(authView.card.id).hidden = true;
    document.getElementById(regView.card.id).hidden = false;
    console.log("do that");
});

regView.submitButton.addEventListener("click", function() {
    let user = regDto(regView.loginField.value, regView.passwordField.value, 
        regView.emailField.value, regView.phoneField.value);
    if (regView.passwordField.value != regView.repPasswordField.value) {
        regView.errorField.textContent = "Passwords do not match";
        return
    }
    sendJSONQuery(url, "POST", user).then((response) => {
        if (response.status === 200) {
            regView.errorField.textContent = "OK";
        } else {
            response.text().then((text) => {
                regView.errorField.textContent = text;
            })
        }
    })
})

regView.toBackButton.addEventListener("click", function(){
    document.getElementById(authView.card.id).hidden = false;
    document.getElementById(regView.card.id).hidden = true;
    console.log("do that");
});

function regDto(username, password, email, phone) {
    this.username = username;
    this.password = password;
    this.email = email;
    this.phone = phone;
}

async function sendJSONQuery(url, method, data) {
    return await fetch(url, {
        method: method,
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });
}



