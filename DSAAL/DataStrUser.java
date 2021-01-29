package DSAAL;

import java.util.ArrayList;

public class DataStrUser {
    public static void main(String args) {
        ArrayList arrayList = new ArrayList();
        addValues(arrayList);
        getValues(arrayList);
        updateValues(arrayList);
        removeValues(arrayList);
        
    }
    /**
     * 
     * @param arrayList
     * adds values nd gives the size of arraylist
     */
    public void addValues(ArrayList arrayList){
        int size = arrayList.getSize();
        System.out.println("size is " + Integer.toString(size));

        int input[] = new int[2, 3, 4, 5, 6];
        arrayList.addAll(input);
        size = arrayList.getSize();
        System.out.println("size is " + Integer.toString(size));

    }
}
