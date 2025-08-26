// Function to validate the form fields
function validateForm() {
    // Get all the values from the form fields
    const todoName = document.getElementById("todoName").value.trim();
    const description = document.getElementById("description").value.trim();
    const priority = document.getElementById("priority").value;
    const dueDate = document.getElementById("dueDate").value.trim();
    const type = document.getElementById("type").value;

    // Error messages container and specific error elements
    const errorMessagesClient = document.getElementById("error-messages-client");
    const errorList = document.getElementById("error-list");

    // Clear previous errors
    errorList.innerHTML = "";
    errorMessagesClient.style.display = "none";
    document.getElementById("todoNameError").textContent = "";
    document.getElementById("descriptionError").textContent = "";
    document.getElementById("priorityError").textContent = "";
    document.getElementById("dueDateError").textContent = "";
    document.getElementById("typeError").textContent = "";

    let isValid = true;

    // Validate TODO Name
    if (!todoName) {
        document.getElementById("todoNameError").textContent = "TODO Name is required.";
        errorList.innerHTML += "<li>TODO Name is required.</li>";
        isValid = false;
    }

    // Validate Description
    if (!description) {
        document.getElementById("descriptionError").textContent = "Description is required.";
        errorList.innerHTML += "<li>Description is required.</li>";
        isValid = false;
    }

    // Validate Priority
    if (!priority) {
        document.getElementById("priorityError").textContent = "Please select a priority.";
        errorList.innerHTML += "<li>Please select a priority.</li>";
        isValid = false;
    }

    // Validate Due Date format (YYYY-MM-DD without regex)
    if (!dueDate) {
        document.getElementById("dueDateError").textContent = "Due Date is required.";
        errorList.innerHTML += "<li>Due Date is required.</li>";
        isValid = false;
    } else {
        const parts = dueDate.split("-");
        if (parts.length === 3) {
            const year = parseInt(parts[0], 10);
            const month = parseInt(parts[1], 10);
            const day = parseInt(parts[2], 10);

            // Check that year, month, and day are valid numbers
            if (
                !isNaN(year) && year > 999 && year < 10000 &&
                !isNaN(month) && month >= 1 && month <= 12 &&
                !isNaN(day) && day >= 1 && day <= daysInMonth(year, month)
            ) {
                // Date is valid
            } else {
                document.getElementById("dueDateError").textContent = "Due Date must be in YYYY-MM-DD format and valid.";
                errorList.innerHTML += "<li>Due Date must be in YYYY-MM-DD format and valid.</li>";
                isValid = false;
            }
        } else {
            document.getElementById("dueDateError").textContent = "Due Date must be in YYYY-MM-DD format.";
            errorList.innerHTML += "<li>Due Date must be in YYYY-MM-DD format.</li>";
            isValid = false;
        }
    }

    // Validate Type
    if (!type) {
        document.getElementById("typeError").textContent = "Please select a type.";
        errorList.innerHTML += "<li>Please select a type.</li>";
        isValid = false;
    }

    // Show error messages at the top if there are any
    if (!isValid) {
        errorMessagesClient.style.display = "block";
    }

    // Return false if form is not valid
    return isValid;
}

// Helper function to get the number of days in a month, considering leap years
function daysInMonth(year, month) {
    return new Date(year, month, 0).getDate();
}


