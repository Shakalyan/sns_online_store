const listenerAllButton = {
    buttonProducts: document.querySelector("#buttonProducts"),
    buttonEmployee: document.querySelector("#buttonEmployee"),
    addEmployee: document.querySelector("#add_employee"),
    deleteEmployee: document.querySelector("#delete_employee")
}

const forms = {
    productsForm: document.querySelector("#list_products"),
    employeeForm: document.querySelector("#list_employee"),
    productsList: document.querySelector("#products")
}

listenerAllButton.buttonEmployee.addEventListener("click", function() {
    document.getElementById(forms.productsForm.id).hidden = true;
    document.getElementById(forms.employeeForm.id).hidden = false;
})

listenerAllButton.buttonProducts.addEventListener("click", function() {
    document.getElementById(forms.productsForm.id).hidden = false;
    document.getElementById(forms.employeeForm.id).hidden = true;
})

listenerAllButton.addEmployee.addEventListener("click", function() {
    window.location.replace("auth/registration");
})

