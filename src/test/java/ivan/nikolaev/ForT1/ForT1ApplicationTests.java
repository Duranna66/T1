package ivan.nikolaev.ForT1;

import ivan.nikolaev.ForT1.dao.HandlerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class ForT1ApplicationTests {
	@Autowired
	private HandlerService handlerService;

	@Test
	void contextLoads() {
	}
	@Test
	public void countOfSymbTest() {
		Map<Character, Integer> map1 = handlerService.countOfSymb("dddwww");
		Map<Character, Integer> map2 = handlerService.countOfSymb("aaaaabcccc");
		Map<Character, Integer> map3 = handlerService.countOfSymb("");
		Assertions.assertEquals(handlerService.mapToString(map1),"\"d\" : 3, \"w\" : 3");
		Assertions.assertEquals(handlerService.mapToString(map2), "\"a\" : 5, \"c\" : 4, \"b\" : 1");
		Assertions.assertEquals(handlerService.mapToString(map3), "");
	}

}
