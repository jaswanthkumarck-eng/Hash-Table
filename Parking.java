class Parking {

    static String[] lot=new String[500];

    static int hash(String plate){
        int h=0;
        for(int i=0;i<plate.length();i++)
            h=(h*31+plate.charAt(i))%lot.length;
        return h;
    }

    static int park(String plate){
        int i=hash(plate);
        while(lot[i]!=null)
            i=(i+1)%lot.length;
        lot[i]=plate;
        return i;
    }

    static void leave(String plate){
        for(int i=0;i<lot.length;i++)
            if(lot[i]!=null && lot[i].equals(plate))
                lot[i]=null;
    }

    public static void main(String[] args){
        System.out.println(park("ABC123"));
    }
}