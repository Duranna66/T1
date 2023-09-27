package ivan.nikolaev.ForT1.service;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class HandlerService implements IHandlerService{
    public Map<Character, Integer> countOfSymb(String inputString) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        int count = 0;

        for(int i = 0; i < inputString.length(); i++) {
            if(!map.containsKey(inputString.charAt(i))) {
                map.put(inputString.charAt(i), 1);
            } else {
                count = map.get(inputString.charAt(i));
                map.put(inputString.charAt(i), ++count);
            }
        }

        Comparator<Map.Entry<Character, Integer>> valueComparator = Map.Entry.comparingByValue(Comparator.reverseOrder());
        Map<Character, Integer> sortedMap = map.entrySet()
                .stream()
                .sorted(valueComparator)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        return sortedMap;
    }
    public String mapToString(Map<Character, Integer> map) {
        StringBuilder stringBuilder = new StringBuilder();
        int k = 0;
        for(Character c : map.keySet()) {
            if(k != map.size() - 1) {
                k++;
                stringBuilder.append("\"" + c + "\"" + " : ").append(map.get(c) + ", ");
            } else {
                stringBuilder.append("\"" + c + "\"" + " : ").append(map.get(c));
            }
        }
        return stringBuilder.toString();

    }

}
