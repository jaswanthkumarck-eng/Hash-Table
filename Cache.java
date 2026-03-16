class Cache{

    static String[] L1=new String[10000];
    static String[] L2=new String[100000];

    static int hash(String s,int size){
        int h=0;
        for(int i=0;i<s.length();i++)
            h=(h*31+s.charAt(i))%size;
        return h;
    }

    static void putL1(String v){
        int i=hash(v,L1.length);
        while(L1[i]!=null)
            i=(i+1)%L1.length;
        L1[i]=v;
    }

    static void putL2(String v){
        int i=hash(v,L2.length);
        while(L2[i]!=null)
            i=(i+1)%L2.length;
        L2[i]=v;
    }

    static boolean get(String v){
        int i=hash(v,L1.length);
        if(L1[i]!=null && L1[i].equals(v))
            return true;

        int j=hash(v,L2.length);
        if(L2[j]!=null && L2[j].equals(v)){
            putL1(v);
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        putL2("video123");
        System.out.println(get("video123"));
    }
}