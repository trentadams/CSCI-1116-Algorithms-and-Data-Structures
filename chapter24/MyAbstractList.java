package chapter24;

public abstract class MyAbstractList<E> implements MyList<E> {
	protected int size = 0; // The size of the list

	/** Create a default list */
	protected MyAbstractList() {
	}

	/** Create a list from an array of objects */
	protected MyAbstractList(E[] objects) {
		for (int i = 0; i < objects.length; i++)
			add(objects[i]);
	}

	/** Add a new element at the end of this list */
	public void add(E e) {
		add(size, e);
	}

	/** Return true if this list contains no elements */
	public boolean isEmpty() {
		return size == 0;
	}

	/** Return the number of elements in this list */
	public int size() {
		return size;
	}

	/** Remove the first occurrence of the element o from this list.
	 *  Shift any subsequent elements to the left.
	 *  Return true if the element is removed. */
	public boolean remove(E e) {
		if (indexOf(e) >= 0) {
			remove(indexOf(e));
			return true;
		}
		else 
			return false;
	}
	
	 /** Add all elements in otherList to this list */
    public boolean addAll(MyList<E> otherList) {
        boolean changed = false;
        for (int i = 0; i < otherList.size(); i++) {
            add(otherList.get(i));
                changed = true;
        }
        return changed;
    }

    /** Remove all elements in otherList from this list */
    public boolean removeAll(MyList<E> otherList) {
        boolean changed = false;
        for (int i = 0; i < otherList.size(); i++) {
            if (contains(otherList.get(i)) && remove(otherList.get(i))) {  // Check if element exists and remove it
                changed = true;
            }
        }
        return changed;
    }

    /** Retain only the elements that are also in otherList */
    public boolean retainAll(MyList<E> otherList) {
        boolean changed = false;
        for (int i = 0; i < size; i++) {
            E element = get(i);  // Assuming a `get(i)` method exists in MyAbstractList or MyList
            if (!otherList.contains(element)) {  // If element is not in otherList
                remove(element);  // Remove it from this list
                changed = true;
                i--;  // Adjust index since we've removed an element
            }
        }
        return changed;
    }
}