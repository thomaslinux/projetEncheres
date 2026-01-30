package fr.eni.projetencheres.bo;

public class ArticleCreateDto {

    private String ArticleName;
    private String CategorieName;

    @Override
    public String toString() {
        return "ArticleCreateDto{" +
                "ArticleName='" + ArticleName + '\'' +
                ", CategorieName='" + CategorieName + '\'' +
                '}';
    }

    public String getArticleName() {
        return ArticleName;
    }

    public void setArticleName(String articleName) {
        ArticleName = articleName;
    }

    public String getCategorieName() {
        return CategorieName;
    }

    public void setCategorieName(String categorieName) {
        CategorieName = categorieName;
    }

    public ArticleCreateDto(String articleName, String categorieName) {
        ArticleName = articleName;
        CategorieName = categorieName;
    }
}
