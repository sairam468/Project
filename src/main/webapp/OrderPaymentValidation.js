function updateInputField() {
    var paymentType = document.getElementById("paymentType").value;
    var dynamicField = document.getElementById("dynamicField");
    var label = document.getElementById("dynamicFieldLabel");

    dynamicField.value = "";
    if (paymentType === "Credit Card" || paymentType === "Debit Card") {
        label.textContent = "Card Number:";
        dynamicField.placeholder = "Enter card number";
        dynamicField.type = "text";
        dynamicField.required = true;
        dynamicField.style.display = "block";
        label.style.display = "block";
    } else if (paymentType === "Net Banking") {
        label.textContent = "Net Banking Username:";
        dynamicField.placeholder = "Enter username";
        dynamicField.type = "text";
        dynamicField.required = true;
        dynamicField.style.display = "block";
        label.style.display = "block";
    } else if (paymentType === "UPI") {
        label.textContent = "UPI ID:";
        dynamicField.placeholder = "Enter UPI ID";
        dynamicField.type = "text";
        dynamicField.required = true;
        dynamicField.style.display = "block";
        label.style.display = "block";
    } else {
        dynamicField.style.display = "none";
        label.style.display = "none";
        dynamicField.required = false;
    }
}
window.onload = updateInputField;
