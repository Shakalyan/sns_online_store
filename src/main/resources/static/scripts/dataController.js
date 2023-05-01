const apiEmployeesUrl = "http://localhost:8080/api/employees";
const apiProductsUrl = "http://localhost:8080/api/products";
const apiGetProduct = "http://localhost:8080/api/product";
const apiRegUser = "http://localhost:8080/api/registration";
const xhr = new XMLHttpRequest();
const divElements = {
    divEmployees: document.querySelector("#list_employee"),
    divProducts: document.querySelector("#list_products")
};
const btnElements = {
    addEmployee: document.querySelector('#addButtonEmployee'),
    addProduct: document.querySelector('#addButtonProduct'),
    editButtonProduct: document.querySelector('#editButtonProduct')
};

async function getEmployee() {
    const response = await fetch(apiEmployeesUrl, {method: 'GET'});
    const data = await response.json();
    var dataParse = JSON.parse(JSON.stringify(data));    
    console.log(dataParse);
    for (let i = 0; i < dataParse.length; i++) {
        let div = document.createElement('div');
        div.setAttribute("id", "itemEmployee");
        let name_h3 = document.createElement('h3');
        let post_h3 = document.createElement('h3');
        let delBtn = document.createElement('button');
        delBtn.setAttribute('value', dataParse[i].id);
        delBtn.setAttribute('onclick', `deleteEmployee(${delBtn.value});`);
        delBtn.textContent = "Удалить";
        name_h3.textContent = dataParse[i].name;
        if(dataParse[i].roles[0].name === 'ROLE_DEV') {
            post_h3.textContent = 'Разработчик';
        } else if(dataParse[i].roles[0].name === 'ROLE_ADMIN') {
            post_h3.textContent = 'Админ';
        } else {
            post_h3.textContent = 'Менеджер';
        }
        div.append(name_h3);
        div.append(post_h3);
        div.append(delBtn);
        divElements.divEmployees.append(div);
    }
}

async function getProducts() {
    const response = await fetch(apiProductsUrl, {method: 'GET'});
    const data = await response.json();
    var dataParse = JSON.parse(JSON.stringify(data));
    for (let i = 0; i < dataParse.length; i++) {
        let div = document.createElement('div');
        div.setAttribute("id", "itemProducts");
        let nameProduct = document.createElement('h3');
        let category = document.createElement('h3');
        let price = document.createElement('h3');
        let amount = document.createElement('h3');
        let delBtn = document.createElement('button');
        let editBtn = document.createElement('button');
        delBtn.setAttribute('value', dataParse[i].id);
        editBtn.setAttribute('value', dataParse[i].id);
        delBtn.setAttribute('onclick', `deleteProduct("${delBtn.value}");`);
        editBtn.setAttribute('onclick', `viewEditProducts("${editBtn.value}");`);
        editBtn.setAttribute('type', 'button')
        delBtn.textContent = "Удалить";
        editBtn.textContent = "Изменить";
        nameProduct.textContent = data[i].name;
        category.textContent = data[i].category;
        price.textContent = data[i].price;
        amount.textContent = data[i].amount; 
        div.append(nameProduct);
        div.append(category);
        div.append(price);
        div.append(amount);
        div.append(delBtn);
        div.append(editBtn);
        divElements.divProducts.append(div);
    }
};

getEmployee();
getProducts();

async function sendAuthData() {
    let username = document.querySelector("#reg_login").value;
    let name = document.querySelector("#reg_name").value;
    let email = document.querySelector("#reg_email").value;
    let regPhone = document.querySelector("#reg_phone").value;
    let regPassword = document.querySelector("#reg_password").value;
    let roleUser = document.querySelector("#selectRole").value;
    let data = {
        "username": username,
        "password": regPassword,
        "name": name,
        "email": email,
        "phoneNumber": regPhone,
        "role": roleUser
    }
    const response = await fetch(apiRegUser,
        {
            method: "POST",
            body: JSON.stringify(data),
            headers: {
                'Content-Type': 'application/json'
            }
        });
};

async function deleteEmployee(idEmployee) {
    const response = await fetch(apiEmployeesUrl + "?id=" +idEmployee,
        {
            method: "DELETE"
        });
};

async function sendNewProduct() {
    let name = document.querySelector("#nameProduct").value;
    let manufacturer = document.querySelector("#manufacturerProduct").value;
    let category = document.querySelector("#category").value;
    let price = document.querySelector("#priceProduct").value;
    let amount = document.querySelector("#amountProduct").value;
    let data = {
        "name": name,
        "amount": amount,
        "price": price,
        "manufacturer": manufacturer,
        "category": category
    }
    const response = await fetch(apiProductsUrl,
        {
            method: "POST",
            body: JSON.stringify(data),
            headers: {
                'Content-Type': 'application/json'
            }
        });
};

async function deleteProduct(idProduct) {
    console.log(idProduct)
    const response = await fetch(apiProductsUrl + "?id=" +idProduct,
        {
            method: "DELETE"
        });
    
};

async function viewEditProducts(idProduct) {
    const response = await fetch(apiGetProduct + "?id=" + idProduct, {method: "GET"});
    var data = await response.json();
    var dataParse = JSON.parse(JSON.stringify(data));
    console.log(data); 
    document.getElementById('editProduct').showModal();
    var nameProduct = document.getElementById('nameProductEdit');
    var manufacturerProduct = document.getElementById('manufacturerProductEdit');
    var category = document.getElementById('categoryEdit');
    var priceProduct = document.getElementById('priceProductEdit');
    var amountProduct = document.getElementById('amountProductEdit');
    nameProduct.value = dataParse.name;
    manufacturerProduct.value = dataParse.manufacturer;
    category.value = dataParse.category;
    priceProduct.value = dataParse.price;
    amountProduct.value = dataParse.amount;
    btnElements.editButtonProduct.addEventListener("click", async function() {
        var data = {
            'id': idProduct,
            'name': nameProduct.value,
            'category': category.value,
            'price': priceProduct.value,
            'amount': amountProduct.value,
            'manufacturer': manufacturerProduct.value
        };
        await fetch(apiProductsUrl + "?id=" + idProduct, {
            method: "PATCH",
            body: JSON.stringify(data),
            headers: {
                'Content-Type': 'application/json'
            }
        })
    })
}

btnElements.addEmployee.addEventListener("click", function() {
    sendAuthData();
});

btnElements.addProduct.addEventListener("click", function() {
    sendNewProduct();
})