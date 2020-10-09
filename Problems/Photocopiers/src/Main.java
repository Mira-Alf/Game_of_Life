/**
 * Class to work with
 */
class Multiplicator {

	public static <T extends Copy<T>> Folder<T>[] multiply(Folder<T> folder, int arraySize) {
		T item = folder.get();
		Folder<T>[] folders = new Folder[arraySize];
        for(int i=0; i < arraySize; i++) {
            folders[i] = new Folder();
            folders[i].put(item.copy());
        }
        return folders;
	}

}

// Don't change the code below
interface Copy<T> {
	T copy();
}

class Folder<T> {

    private T item;

    public void put(T item) {
    	this.item = item;
    }

    public T get() {
        return this.item;
    }
}