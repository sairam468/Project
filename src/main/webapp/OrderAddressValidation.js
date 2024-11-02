document.addEventListener("DOMContentLoaded", function () {
    const form = document.querySelector("form");
    
    form.addEventListener("submit", function (event) {
        let isValid = true;
        const messages = [];

        // Validate Full Name
        const nameInput = document.getElementById("name");
        if (nameInput.value.trim() === "") {
            messages.push("Full Name is required.");
            isValid = false;
        }

        // Validate Address
        const addressInput = document.getElementById("address");
        if (addressInput.value.trim() === "") {
            messages.push("Address is required.");
            isValid = false;
        }

        // Validate City
        const cityInput = document.getElementById("city");
        if (cityInput.value.trim() === "") {
            messages.push("City is required.");
            isValid = false;
        }

        // Validate State
        const stateInput = document.getElementById("state");
        if (stateInput.value.trim() === "") {
            messages.push("State is required.");
            isValid = false;
        }

        // Validate Zip Code (Basic check for 5 digits)
        const zipcodeInput = document.getElementById("zipcode");
        const zipcodePattern = /^\d{6}$/;
        if (!zipcodePattern.test(zipcodeInput.value)) {
            messages.push("Zip Code must be 5 digits.");
            isValid = false;
        }

        // Validate Country
        const countryInput = document.getElementById("country");
        if (countryInput.value.trim() === "") {
            messages.push("Country is required.");
            isValid = false;
        }

        // If form is not valid, prevent submission and show messages
        if (!isValid) {
            event.preventDefault(); // Prevent form submission
            alert(messages.join("\n")); // Show alert with validation messages
        }
    });
});
