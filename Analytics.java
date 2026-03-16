class Analytics {

    static String[] page=new String[1000];
    static int[] views=new int[1000];

    static int hash(String s){
        int h=0;
        for(int i=0;i<s.length();i++)
            h=(h*31+s.charAt(i))%page.length;
        return h;
    }

    static void visit(String url){
        int i=hash(url);
        while(page[i]!=null && !page[i].equals(url))
            i=(i+1)%page.length;
        if(page[i]==null){
            page[i]=url;
            views[i]=1;
        } else views[i]++;
    }

    public static void main(String[] args){
        visit("/news");
        visit("/news");
        visit("/sports");
        System.out.println("done");
    }
}