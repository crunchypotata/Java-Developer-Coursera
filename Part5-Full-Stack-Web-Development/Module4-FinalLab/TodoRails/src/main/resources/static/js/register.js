function validateForm()  {

    // Initialize an array to store error messages
    const errors = [];

    /** TODO 7: put try-catch around the code leaving aside the declaration of array "errors"
     *          and the return statement at the end.
     *          If there is an error the push the message "Error handling form fields!" and
     *          return false.
     **/
        // Get form fields

     try {}
        const username = document.getElementById("username").value.trim();
        const email = document.getElementById("email").value.trim();
        const password = document.getElementById("password").value.trim();
        const confirmPassword = document.getElementById("confirmPassword").value.trim();
        const hobbies = document.querySelectorAll('input[name="hobbies"]:checked');

        // Check if the username is empty
        if (!username) {
            errors.push("Username cannot be blank.");
        }

        // Check if the username is between 3 and 20 characters
        if (!(username.length >= 3 && username.length <= 20)) {
            errors.push("Username must be between 3 and 20 characters.");
        }

        // Check if the email is empty first, then check format only if it's not empty
        if (!email) {
            errors.push("Email cannot be blank.");
        } else if (!email.includes("@") || !email.includes(".") || email.indexOf("@") > email.lastIndexOf(".")) {
            errors.push("Please enter a valid email address.");
        }

        // Check if the password is empty
        if (!password) {
            errors.push("Password cannot be blank.");
        }

        // Check if the password is at least 6 characters
        if (!(password.length >= 6)) {
            errors.push("Password must be min 6 characters.");
        }

        // Only check if password matches confirm password if password is not empty
        if (password && password !== confirmPassword) {
            errors.push("Password and confirmation do not match.");
        }

        // Check if at least one hobby is selected
        if (hobbies.length === 0) {
            errors.push("Please select at least one hobby.");
        }

        // Display errors if any exist
        if (errors.length > 0) {
            displayClientErrors(errors);

            // Prevent form submission
            return false;
        }

    } catch (error) {
         errors.push("Error handling form fields!");
         displayClientErrors(errors);
         return false;
    }

    return true;
}


// This function displays client-side error messages in the error-messages-client box
function displayClientErrors(messages) {
    const errorList = document.getElementById("error-list"); // The list to hold each error message
    const errorMessagesDiv = document.getElementById("error-messages-client"); // The error message container

    // Clear any previous error messages
    errorList.innerHTML = "";

    // Loop through messages array and create list items for each error
    messages.forEach(message => {
        const li = document.createElement("li"); // Create a list item
        li.textContent = message; // Set the text of the list item to the error message
        errorList.appendChild(li); // Add the list item to the error list
    });

    // Make the error message container visible
    errorMessagesDiv.style.display = "block";
}
