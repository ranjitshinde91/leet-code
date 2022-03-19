package recursion.all_permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPermutations {

    public List<String> calculate(String word) {
        return getStrings(word.chars().toArray(), 0);
    }

    private List<String> getStrings(int[] word, int index) {
        if (index == word.length - 1) {
            return List.of(Character.toString(word[index]));
        }

        ArrayList<String> objects = new ArrayList<>();

        for (int j = index; j < word.length; j++) {
            char c = (char) word[j];

            swap(word, index, j);
            for (String letter : getStrings(word, index + 1)) {
                objects.add(c + letter);
            }
            swap(word, j, index);
        }
        return objects;
    }

    void swap(int[] word, int from, int to) {
        int temp = word[from];
        word[from] = word[to];
        word[to] = temp;
    }
}

