const categoryList = document.querySelectorAll('.category');
const toutesLesCategories = document.querySelector('#toutesLesCategories');
console.log("keep_categories");
// recupere la categorie actuellement selectionnee
let currentCategory = localStorage.getItem('currentCategory');

toutesLesCategories.addEventListener('click', (event) => {
    e.preventDefault();
    localStorage.setItem('currentCategory', "");
});

categoryList.forEach(category => {
    category.addEventListener('click', (e) => {
        e.preventDefault();

        currentCategory = category.id
        console.log(currentCategory);

        localStorage.setItem('currentCategory', currentCategory);


    })
})

