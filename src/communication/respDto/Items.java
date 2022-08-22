package communication.respDto;

import java.util.ArrayList;

// 5. 마지막으로 얘 만들어줌
public class Items {
    private ArrayList<Item> item; // 이새끼보니까 "item":[] 배열 꼴

    public Items(ArrayList<Item> item) {
        this.item = item;
    }

    public Items() {
    }

    public ArrayList<Item> getItem() {
        return item;
    }

    public void setItem(ArrayList<Item> item) {
        this.item = item;
    }
}
