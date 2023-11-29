package linked_list.lru_cache;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LRUCacheTest {

  @Test
  void test() {
    LRUCache lruCache = new LRUCache(2);

    lruCache.put(1, 1);
    lruCache.put(2, 2);
    assertThat(lruCache.get(1)).isEqualTo(1);

    lruCache.put(3, 3);
    assertThat(lruCache.get(2)).isEqualTo(-1);

    lruCache.put(4, 4);
    assertThat(lruCache.get(1)).isEqualTo(-1);
    assertThat(lruCache.get(3)).isEqualTo(3);
    assertThat(lruCache.get(4)).isEqualTo(4);
  }

  @Test
  void test2() {
    LRUCache lruCache = new LRUCache(2);

    lruCache.put(2, 1);
    lruCache.put(1, 1);
    lruCache.put(2, 3);
    lruCache.put(4, 1);

    assertThat(lruCache.get(1)).isEqualTo(-1);
    assertThat(lruCache.get(4)).isEqualTo(1);
  }

  @Test
  void test3() {
    LRUCache lruCache = new LRUCache(1);

    lruCache.put(2, 1);
    assertThat(lruCache.get(2)).isEqualTo(1);
    lruCache.put(3, 2);
    assertThat(lruCache.get(2)).isEqualTo(-1);
    assertThat(lruCache.get(3)).isEqualTo(2);
  }
}
