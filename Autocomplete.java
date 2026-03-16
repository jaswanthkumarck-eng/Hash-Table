class Autocomplete {

    static String[] query=new String[10000];
    static int[] freq=new int[10000];

    static int hash(String s){
        int h=0;
        for(int i=0;i<s.length();i++)
            h=(h*31+s.charAt(i))%query.length;
        return h;
    }

    static void add(String q){
        int i=hash(q);
        while(query[i]!=null && !query[i].equals(q))
            i=(i+1)%query.length;
        if(query[i]==null){
            query[i]=q;
            freq[i]=1;
        } else freq[i]++;
    }

    public static void main(String[] args){
        add("java tutorial");
        add("java tutorial");
        add("javascript");
    }
}