class RateLimiter {

    static String[] client=new String[1000];
    static int[] count=new int[1000];
    static long[] time=new long[1000];

    static int hash(String s){
        int h=0;
        for(int i=0;i<s.length();i++)
            h=(h*31+s.charAt(i))%client.length;
        return h;
    }

    static boolean allow(String id){
        int i=hash(id);
        while(client[i]!=null && !client[i].equals(id))
            i=(i+1)%client.length;

        if(client[i]==null){
            client[i]=id;
            count[i]=1;
            time[i]=System.currentTimeMillis();
            return true;
        }

        if(System.currentTimeMillis()-time[i]>3600000){
            count[i]=1;
            time[i]=System.currentTimeMillis();
            return true;
        }

        if(count[i]<1000){
            count[i]++;
            return true;
        }

        return false;
    }

    public static void main(String[] args){
        System.out.println(allow("abc"));
    }
}