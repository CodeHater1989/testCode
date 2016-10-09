import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Administrator on 2016/10/9.
 */
public class TestCycleList {

    private TNode head;

    @Before
    public void createCycleList() {
        TNode a = new TNode();
        TNode b = new TNode();
        TNode c = new TNode();
        TNode d = new TNode();

        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(b);

        head = a;
    }

    @Test
    public void isCycleList(){

        boolean isCycleList = false;

        int step = 0;
        TNode next = head;

        while (true) {

            if (next == null || next.getNext() == null) {
                break;
            }

            next = next.getNext();
            step++;

            for (int i = 0; i < step; i++) {
                TNode temp = head;
                if(next == temp) {
                    isCycleList = true;
                    break;
                }
            }
        }

        Assert.assertFalse("这是一个带有环的链表！", isCycleList);
    }
}
