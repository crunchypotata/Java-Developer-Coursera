/*
// JavaScript to toggle the sidebar menu
function toggleMenu() {
    var sidebar = document.querySelector('.sidebar');
    if (sidebar.style.display === "block") {
        sidebar.style.display = "none";
    } else {
        sidebar.style.display = "block";
    }
}
*/
// JavaScript to toggle the sidebar menu and change icon color
function toggleMenu() {
    var sidebar = document.querySelector('.sidebar');
    sidebar.classList.toggle('open');
}
