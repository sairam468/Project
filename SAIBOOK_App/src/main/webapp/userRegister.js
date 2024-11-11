document.addEventListener("DOMContentLoaded", function() {
    const form = document.querySelector("form");

    form.addEventListener("submit", function(event) {
        const username = form.querySelector('input[name="uname"]').value.trim();
        const password = form.querySelector('input[name="pword"]').value.trim();
        const email = form.querySelector('input[name="mid"]').value.trim();
        const phone = form.querySelector('input[name="phno"]').value.trim();

        if (!username || !password || !email || !phone) {
            alert("All fields are required.");
            event.preventDefault(); // Prevent form submission if invalid
            return;
        }

        // Simple email validation
        const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (!emailPattern.test(email)) {
            alert("Please enter a valid email address.");
            event.preventDefault(); // Prevent form submission if invalid
        }

        // Phone number validation
        if (phone.length !== 10 || isNaN(phone)) {
            alert("Please enter a valid 10-digit phone number.");
            event.preventDefault(); // Prevent form submission if invalid
        }
    });
});
