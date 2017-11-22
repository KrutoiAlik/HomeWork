import java.util.ArrayList;
import java.util.List;

public class SharedResource {

    private List<Integer> list;

    public SharedResource() {
        this.list = new ArrayList<>();
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
