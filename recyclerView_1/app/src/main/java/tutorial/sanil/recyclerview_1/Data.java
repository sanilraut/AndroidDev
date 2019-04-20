package tutorial.sanil.recyclerview_1;

import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("id")
    private int id;
    @SerializedName("first_name")
    private String first_name;
    @SerializedName("last_name")
    private String last_name;
    @SerializedName("avatar")
    private String avatar;

    public Data(int id,String first_name,String last_name,String avatar) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.avatar = avatar;
    }

   public int getId(){
        return id;
   }
   public String getFirst_name(){
        return first_name;
   }
   public String getLast_name(){
        return last_name;
   }
   public String getAvatar(){
        return avatar;
   }
}
