package celine.chang.mynest;

public class UserDTO {

    String name;
    String UID;

    public UserDTO(String name, String UID){
        this.name = name;
        this.UID = UID;
    }

    public UserDTO(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }
}
