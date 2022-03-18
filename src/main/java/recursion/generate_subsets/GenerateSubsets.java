package recursion.generate_subsets;

import java.util.ArrayList;
import java.util.List;

public class GenerateSubsets {


    List<String> subsets(String word) {
        if (word.equals("")) {
            return List.of("");
        }
        var subsets = subsets(word.substring(0, word.length() - 1));
        String lastCharacter = word.substring(word.length() - 1);

        List<String> s = new ArrayList<>();
        for (String newWord : subsets) {
            s.add(newWord);
            s.add(newWord + lastCharacter);
        }
        return s;

    }
}
