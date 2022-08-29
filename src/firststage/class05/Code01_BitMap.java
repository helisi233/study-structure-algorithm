package firststage.class05;

public class Code01_BitMap {

    // 位图适用于确定数据上限的情况
    public static class BitMap {

        // 一个long类型 可以表示0~63共64个数
        public long[] bitmap;

        public BitMap(int max) {
            bitmap = new long[(max + 64) >> 6];
        }

        public void add(int num) {
            bitmap[num >> 6] |= (1L << (num & 63));
        }

        public void delete(int num) {
            bitmap[num >> 6] &= ~(1L << (num & 63));
        }

        public boolean contain(int num) {
            return (bitmap[num >> 6] & (1L << (num & 63))) == 0;
        }

    }

    public static void main(String[] args) {
        BitMap bitMap = new BitMap(64);
        int randomNum = (int)(Math.random() * 64) + 1;
    }
}
