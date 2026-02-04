const categoryList = document.querySelectorAll('.category');
const currentCategoryInput = document.getElementById('currentCategory');
const searchForm = document.getElementById('searchBar');

console.log("category_ai_keeper");

// Check for a saved category on page load
let currentCategory = localStorage.getItem('currentCategory');
if (currentCategory) {
    currentCategoryInput.value = currentCategory;  // Set the hidden input value
}

// Add event listeners to category buttons
categoryList.forEach(category => {
    category.addEventListener('click', (e) => {
        e.preventDefault();  // Prevent the default link action

        currentCategory = category.id;  // Get the clicked category id
        console.log(currentCategory);

        localStorage.setItem('currentCategory', currentCategory);  // Save to local storage
        currentCategoryInput.value = currentCategory;  // Update the hidden input field

        // Submit the form
        searchForm.submit();
    });
});