package u2Home.task1;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "trains")
public class TrainList {

    @XmlElement(name="train")
    private List<Train> list = new ArrayList<Train>();

    public void addList(Train train) {
        list.add(train);
    }
}
