// JavaScript for validating login form
function validateForm() {
    // Get the email and password input fields
    var email = document.getElementById('email').value;
    var password = document.getElementById('password').value;

    // Check if email and password are not empty
    if (email === "" || password === "") {
        alert("Email and password cannot be empty."); // Alert user
        return false; // Stop form submission
    }

    // Check if email contains '@'
    if (email.indexOf('@') === -1) {
        alert("Please enter a valid email address."); // Alert user
        return false; // Stop form submission
    }

    // If everything is fine, allow form submission
    return true;
}
