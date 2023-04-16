package celine.chang.mynest;

public class ItemDTO {

    String title;
    int img;
    String description;

    public ItemDTO(String title, int img, String description){
        this.title=title;
        this.img=img;
        this.description=description;
    }

    public ItemDTO(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
