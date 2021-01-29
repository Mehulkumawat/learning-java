package DSAAL;

public class ArrayList {
    private int[] array = new int[8]; // array ki length
    private int size = 0;
    
    public int getsize() {
        return size;
    }

    public int add(int value) {
        if(size >= array.length)
            increaselength()

        array[size++] = value;   
    }

    public int increaselength() {
        // TODO: write code for this meethod
        
        
    }

    public void addAll(int[] value){
        for(int i = 0; i < value.length; i++) {
            add(value[i]);
        }
    }

    public int get(int index) {
        if(index >= size || index < 0)
            throw new IndexOutOfBoundsException("index should be between [0, size)")
        return array[index];
    }

    public int removeLast() {
        if(size == 0) {
            throw new IndexOutOfBoundsException("size is zero ,no further remving possible");
        }
        return array[--size];

    }
}
    

