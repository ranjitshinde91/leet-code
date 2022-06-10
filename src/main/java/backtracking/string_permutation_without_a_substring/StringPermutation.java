package backtracking.string_permutation_without_a_substring;

public class StringPermutation {

    public void permutations(String s) {
        _permutations(s, 0, s.length());
    }

    private void _permutations(String s, int index, int size) {
        if(index == size && !s.contains("AB")){
            System.out.println(s);
            return;
        }
        if (index == size) {
            return;
        }
        for (int i = index; i < size; i++) {
            _permutations(swap(s, index, i), index + 1, size);
        }
    }

    static String swap(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }
}
