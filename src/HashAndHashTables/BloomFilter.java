package HashAndHashTables;
import java.util.BitSet;
import java.util.function.Function;

public class BloomFilter<T> {
    private final BitSet bitSet;
    private final int size;
    private final int numHashFunctions;
    private final Function<T, Integer>[] hashFunctions;

    public BloomFilter(int size, int numHashFunctions) {
        this.size = size;
        this.numHashFunctions = numHashFunctions;
        this.bitSet = new BitSet(size);
        this.hashFunctions = new Function[numHashFunctions];

        for (int i = 0; i < numHashFunctions; i++) {
            int seed = i * 31; // Using different seeds for hash functions
            hashFunctions[i] = item -> (item.hashCode() ^ seed) % size;
        }
    }

    public void add(T item) {
        for (Function<T, Integer> hashFunction : hashFunctions) {
            int index = hashFunction.apply(item);
            bitSet.set(index);
        }
    }

    public boolean contains(T item) {
        for (Function<T, Integer> hashFunction : hashFunctions) {
            int index = hashFunction.apply(item);
            if (!bitSet.get(index)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BloomFilter<String> bloomFilter = new BloomFilter<>(100, 3);

        bloomFilter.add("apple");
        bloomFilter.add("banana");
        bloomFilter.add("cherry");

        System.out.println(bloomFilter.contains("apple"));   // Should print true
        System.out.println(bloomFilter.contains("orange"));  // Should print false
    }
}


