class TwoSum {

    static int[] table=new int[1000];
    static boolean[] used=new boolean[1000];

    static int hash(int x){
        return x%table.length;
    }

    static boolean check(int[] arr,int target){
        for(int i=0;i<arr.length;i++){
            int c=target-arr[i];
            int h=hash(c);

            while(used[h]){
                if(table[h]==c) return true;
                h=(h+1)%table.length;
            }

            int p=hash(arr[i]);
            while(used[p])
                p=(p+1)%table.length;

            table[p]=arr[i];
            used[p]=true;
        }
        return false;
    }

    public static void main(String[] args){
        int[] a={300,200,500};
        System.out.println(check(a,500));
    }
}