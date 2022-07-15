package disjoint_set;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DisjointSetTest {

    @Test
    void shouldCreateDisjointSetOfGiveSize() {
        var disjointSet = new DisjointSet(5);

        int parent = disjointSet.find(2);

        assertThat(parent).isEqualTo(2);
    }

    @Test
    void shouldReturnParentAfterUnion() {
        var disjointSet = new DisjointSet(5);

        disjointSet.union(1, 2);

        assertThat(disjointSet.find(2)).isEqualTo(1);

        disjointSet.union(2, 3);
        assertThat(disjointSet.find(3)).isEqualTo(1);
    }
}