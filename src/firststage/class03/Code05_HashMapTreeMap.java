package firststage.class03;

import java.util.HashMap;
import java.util.TreeMap;

public class Code05_HashMapTreeMap {
    public static void main(String[] args) {
        /**
         *  HashMap<K, V> 哈希表基础操作
         *  put(key, value) 添加/修改
         *  get(key) 获取key对应的value
         *  containsKey(key) 查询这个key是否存在
         *  基础结构是值传递
         *  自定义结构是引用传递 只传递地址
         * */
//        HashMap<String, String> map = new HashMap<>();
//        map.put("hls", "helisi");
//        System.out.println(map.containsKey("hls"));
//        System.out.println(map.containsKey("h"));
//        System.out.println(map.get("hls"));
//        map.put("hls", "new-helisi");
//        System.out.println(map.containsKey("hls"));
//        System.out.println(map.get("hls"));
//        String test1 = "hls";
//        String test2 = "hls";
//        System.out.println(map.containsKey(test1));
//        System.out.println(map.containsKey(test2));
//        HashMap<Integer, String> map2 = new HashMap<>();
//        map2.put(1234, "1234");
//        Integer test3 = 1234;
//        Integer test4 = 1234;
//        System.out.println(map2.containsKey(test3));
//        System.out.println(map2.containsKey(test4));
//
//        class Node{
//            int a;
//            public Node(int a) {
//                this.a = a;
//            }
//        }
//        HashMap<Node, String> map3 = new HashMap<>();
//        Node node1 = new Node(1);
//        Node node2 = new Node(1);
//        map3.put(node1, "node value 1");
//        System.out.println(map3.containsKey(node1));
//        System.out.println(map3.containsKey(node2));

        /**
         *  TreeMap<K, V>有序表基础操作
         *  要求K必须是可以被排序的类型
         *  put(k, v) 添加/修改
         *  remove(k) 删除这个key和对应的value
         *  firstKey() 获取最小的key
         *  lastKey() 获取最大的key
         *  floorkey(key) <=key最近的key
         *  ceilingKey(key) >=key最近的key
         * */
        TreeMap<Integer, String> map1 = new TreeMap<>();
        map1.put(3, "3");
        map1.put(0, "0");
        map1.put(7, "7");
        map1.put(2, "2");
        map1.put(5, "5");
        map1.put(9, "9");
        System.out.println(map1.firstKey());
        System.out.println(map1.lastKey());
        map1.remove(2);
        System.out.println(map1.floorKey(5));
        System.out.println(map1.ceilingKey(6));
    }
}
