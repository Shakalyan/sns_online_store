const listenerAllButton = {
    buttonProducts: document.querySelector("#buttonProducts"),
    buttonEmployee: document.querySelector("#buttonEmployee")
}

const forms = {
    productsForm: document.querySelector("#list_products"),
    employeeForm: document.querySelector("#list_employee")
}

listenerAllButton.buttonEmployee.addEventListener("click", function() {
    document.getElementById(forms.productsForm.id).hidden = true;
    document.getElementById(forms.employeeForm.id).hidden = false;
})

listenerAllButton.buttonProducts.addEventListener("click", function() {
    document.getElementById(forms.productsForm.id).hidden = false;
    document.getElementById(forms.employeeForm.id).hidden = true;
})


