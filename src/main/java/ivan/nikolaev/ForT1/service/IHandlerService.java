package ivan.nikolaev.ForT1.service;

import java.util.Map;

public interface IHandlerService {

    Map<Character, Integer> countOfSymb(String inputString);

    String mapToString(Map<Character, Integer> map);
}
