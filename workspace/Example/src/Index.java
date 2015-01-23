import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Index is just like the index in the back of a book.
 * 
 * Given some collection of things, we want to know
 * where something occurs in that collection.
 * 
 * Because we use a HashMap, this'll be O(1) lookup.
 * 
 * @param <Something>
 */
public class Index<Something> {
	HashMap<Something,HashSet<Integer>> index =
			new HashMap<Something,HashSet<Integer>>();
	
	
	/**
	 * Build up the index with entries at locations.
	 * 
	 * @param entry
	 * @param location
	 */
	public void addItem(Something entry, int location) {
		//if the index doesnt have an entry in it
		//put something there(create a set)
		if(!index.containsKey(entry))
		{
			index.put(entry, new HashSet<Integer>());
		}
		//no matter what we need to add to an entry
		//the location
		index.get(entry).add(location);
//		if(index.containsKey(entry))
//		{
//			HashSet<Integer> hashSet = index.get(entry);
//			hashSet.add(new Integer(location));
//		}
//		else{
//			HashSet<Integer> hashSet = new HashSet<>();
//			hashSet.add(new Integer(location));
//			index.put(entry,hashSet);
//		}
	}
	
	/**
	 * Given some entry, return where it occurs
	 * 
	 * @param entry
	 * @return
	 */
	public Set<Integer> getIndices(Something entry) {
		return index.get(entry);
	}
}
