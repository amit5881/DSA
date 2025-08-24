package ByteByteGo.Graph;

public class MergingCommunities {

    UnionFind uf;

    public static class UnionFind {
        int[] parent;
        int[] size;

        public UnionFind(int size) {
            this.parent = new int[size];
            this.size = new int[size];
        }

        public void union(int x, int y) {
            int repX = find(x);
            int repY = find(y);
            if (repX != repY) {
                if (size[repX] > size[repY]) {
                    parent[repY] = repX;
                    size[repX] += size[repY];
                } else {
                    parent[repX] = repY;
                    size[repY] += size[repX];
                }
            }
        }

        private int find(int x) {
            if (x == parent[x]) return x;

            parent[x] = find(parent[x]);
            return parent[x];
        }

        public int getSize(int x) {
            return size[find(x)];
        }
    }

    public MergingCommunities(int n) {
        this.uf = new UnionFind(n);
    }

    public void connect(int x, int y) {
        uf.union(x, y);
    }

    public int getCommunitySize(int x) {
        return uf.getSize(x);
    }

    public static void main(String[] args) {
        int n = 5;
        MergingCommunities mc = new MergingCommunities(n);

        for (int i = 0; i < n; i++) {
            mc.uf.parent[i] = i;
            mc.uf.size[i] = 1;
        }

        mc.connect(0, 1);
        mc.connect(1, 2);
        System.out.println(mc.getCommunitySize(3));
        System.out.println(mc.getCommunitySize(0));
        mc.connect(3, 4);
        System.out.println(mc.getCommunitySize(4));
    }

}
