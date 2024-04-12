import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        MyList<String> list = new MyLinkedList<>();

        fillList(list);

        list.addFirst("London");

        printList(list);
    }

    public static void fillList(MyList<String> list) {
        list.add("Almaty");
        list.add("Astana");
        list.add("Shymkent");

        list.clear();

        list.add("Kyzylorda");
        list.add("Atyrau");
        list.add("Aktau");
        list.add("Semey");
    }


    // Complexity: O(N)
    public static void printList(Iterable<String> list) {
        for (String s : list) {
            System.out.println(s);
        }
    }
}
