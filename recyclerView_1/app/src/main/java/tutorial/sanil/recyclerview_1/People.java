package tutorial.sanil.recyclerview_1;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class People {
    @SerializedName("total_pages")
    private int total_pages;
    @SerializedName("data")
    private List<Data> data;
    People(int pages,List<Data> d){
        total_pages = pages;
        data = d;
    }
    List<Data> getData() {
        return data;
    }
    int getTotal_pages() {
        return total_pages;
    }

}
