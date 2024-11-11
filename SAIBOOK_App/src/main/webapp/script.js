document.addEventListener("DOMContentLoaded", function() {
    const forms = document.querySelectorAll("form");

    forms.forEach(form => {
        form.addEventListener("submit", function(event) {
            let isValid = true;

            // Validate book price and quantity to be positive numbers
            const price = form.querySelector('input[name="bprice"]');
            const qty = form.querySelector('input[name="bqty"]');

            if (price && (isNaN(price.value) || price.value <= 0)) {
                alert("Please enter a valid positive number for Book Price.");
                isValid = false;
            }

            if (qty && (isNaN(qty.value) || qty.value <= 0)) {
                alert("Please enter a valid positive number for Book Quantity.");
                isValid = false;
            }

            if (!isValid) {
                event.preventDefault(); // Prevent form submission if invalid
            }
        });
    });
});
