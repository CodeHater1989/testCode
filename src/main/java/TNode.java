import lombok.Getter;
import lombok.Setter;

/**
 * Created by Administrator on 2016/10/9.
 */
@Setter
@Getter
public class TNode {
    private TNode next;
    private int value;
}
