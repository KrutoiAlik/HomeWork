import java.util.ArrayList;
import java.util.List;

public class SharedResource {

    private List<Integer> list;
    private int click;

    public SharedResource() {
        this.list = new ArrayList<>();
    }

    public void clickp(){
        click++;
    }

    public void clickm(){
        click--;
    }

    public int getClick(){
        return click;
    }

    public void setElement(Integer element) {
        this.list.add(element);
    }

    public Integer getElement(){
        if (list.size() > 0)
            return list.remove(0);
        return null;
    }
}
