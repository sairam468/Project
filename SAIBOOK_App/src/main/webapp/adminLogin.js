document.addEventListener("DOMContentLoaded", function() {
    const form = document.querySelector("form");

    form.addEventListener("submit", function(event) {
        const username = document.getElementById("uname").value.trim();
        const password = document.getElementById("pword").value.trim();
        
        if (!username || !password) {
            alert("Username and Password are required.");
            event.preventDefault(); // Prevent form submission if invalid
        }
    });
});
