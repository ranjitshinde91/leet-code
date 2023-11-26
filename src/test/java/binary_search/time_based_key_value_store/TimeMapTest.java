package binary_search.time_based_key_value_store;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TimeMapTest {
  @Test
  void test() {
    var timeMap = new TimeMap();

    assertThat(timeMap.get("foo", 1)).isEqualTo("");

    timeMap.set("foo", "bar", 1);
    assertThat(timeMap.get("foo", 1)).isEqualTo("bar");
    assertThat(timeMap.get("foo", 3)).isEqualTo("bar");

    timeMap.set("foo", "bar2", 4);
    assertThat(timeMap.get("foo", 4)).isEqualTo("bar2");
    assertThat(timeMap.get("foo", 5)).isEqualTo("bar2");

    timeMap.set("foo3", "bar3", 5);
    assertThat(timeMap.get("foo", 5)).isEqualTo("bar2");
    assertThat(timeMap.get("foo3", 5)).isEqualTo("bar3");
  }

  @Test
  void test2() {
    var timeMap = new TimeMap();

    timeMap.set("love", "high", 10);
    timeMap.set("love", "low", 20);
    timeMap.set("love", "middle", 30);

    assertThat(timeMap.get("love", 5)).isEqualTo("");
    assertThat(timeMap.get("love", 10)).isEqualTo("high");
    assertThat(timeMap.get("love", 15)).isEqualTo("high");
    assertThat(timeMap.get("love", 20)).isEqualTo("low");
    assertThat(timeMap.get("love", 25)).isEqualTo("low");
    assertThat(timeMap.get("love", 30)).isEqualTo("middle");
    assertThat(timeMap.get("love", 35)).isEqualTo("middle");
  }

  @Test
  void test3() {
    var timeMap = new TimeMap();
    timeMap.set("ctondw", "ztpearaw", 1);
    timeMap.set("vrobykydll", "hwliiq", 2);
    timeMap.set("gszaw", "ztpearaw", 3);
    timeMap.set("ctondw", "gszaw", 4);
    assertThat(timeMap.get("gszaw", 5)).isEqualTo("ztpearaw");
    assertThat(timeMap.get("ctondw", 6)).isEqualTo("gszaw");
    assertThat(timeMap.get("ctondw", 7)).isEqualTo("gszaw");
    assertThat(timeMap.get("gszaw", 8)).isEqualTo("ztpearaw");
    assertThat(timeMap.get("vrobykydll", 9)).isEqualTo("hwliiq");
    assertThat(timeMap.get("ctondw", 10)).isEqualTo("gszaw");

    timeMap.set("vrobykydll", "kcvcjzzwx", 11);

    assertThat(timeMap.get("vrobykydll", 12)).isEqualTo("kcvcjzzwx");
    assertThat(timeMap.get("ctondw", 13)).isEqualTo("gszaw");
    assertThat(timeMap.get("vrobykydll", 14)).isEqualTo("kcvcjzzwx");

    timeMap.set("ztpearaw", "zondoubtib", 15);
    timeMap.set("kcvcjzzwx", "hwliiq", 16);
    timeMap.set("wtgbfvg", "vrobykydll", 17);
    timeMap.set("hwliiq", "gzsiivks", 18);

    assertThat(timeMap.get("kcvcjzzwx", 19)).isEqualTo("hwliiq");
    assertThat(timeMap.get("ztpearaw", 20)).isEqualTo("zondoubtib");
  }
}
