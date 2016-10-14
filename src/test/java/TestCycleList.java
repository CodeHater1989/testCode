import com.google.common.collect.Sets;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

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

        a.setValue('a');
        b.setValue('b');
        c.setValue('c');
        d.setValue('d');

        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(b);

        head = a;
    }

    @Test
    public void isCycleListPlanA(){

        boolean isCycleList = false;

        int step = 0;
        TNode next = head;

        loopLabel: while (true) {

            if (next == null || next.getNext() == null) {
                break;
            }

            next = next.getNext();
            step++;

            TNode temp = head;
            for (int i = 0; i < step; i++) {
                if(next == temp) {
                    isCycleList = true;
                    break loopLabel;
                }

                temp = temp.getNext();
            }
        }

        Assert.assertFalse("这是一个带有环的链表！", isCycleList);
    }

    @Test
    public void isCycleListPlanB(){
        Set set = Sets.newHashSet();

        boolean isCycleList = false;
        TNode node = head;
        while (true) {
            if(node == null){
                break;
            }

            if (set.contains(node)) {
                isCycleList = true;
                break;
            }

            set.add(node);
            node = node.getNext();
        }

        Assert.assertFalse("这是一个带有环的链表！", isCycleList);
    }

    @Test
    public void isCycleListPlanC(){
        TNode p = head;
        TNode q = head;

        boolean isCycleList = false;

        while (true) {
            if (p != null && q != null && p.getNext() != null && q.getNext() != null && q.getNext().getNext() != null){
                p = p.getNext();
                q = q.getNext().getNext();
            } else {
                break;
            }

            if (p == q) {
                isCycleList = true;
                break;
            }
        }

        Assert.assertFalse("这是一个带有环的链表！", isCycleList);
    }
}
