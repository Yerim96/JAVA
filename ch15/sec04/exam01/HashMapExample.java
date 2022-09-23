package ch15.sec04.exam01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
public class HashMapExample {

	public static void main(String[] args) {
		
		Map<String,Integer>map= new HashMap<>();
		
		map.put("신용권", 85);
		map.put("홍홍홍", 90);
		map.put("길길길", 80);
		map.put("홍홍홍", 95);
		System.out.println("총 ENtry 수" + map.size());
		System.out.println();
		
		//키로 값 얻기
		
		
		String key= "홍홍홍";
		int value = map.get(key);
		System.out.println(key +":"+ value);
		System.out.println();
		
		Set<String> keySet = map.keySet();
		Iterator<String> keyIterator = keySet.iterator();
		
		while(keyIterator.hasNext()) {
			String K =keyIterator.next();
			Integer v= map.get(K);
			System.out.println(K+":"+ v);
		}
		System.out.println();
		Set<Entry<String, Integer>> entrySet= map.entrySet();
		Iterator<Entry<String, Integer>> entryIterator = entrySet.iterator();
		while(entryIterator.hasNext()) {
			Entry<String, Integer> entry = entryIterator.next();
			String k =entry.getKey();
			Integer v=entry.getValue();
			System.out.println(k+":"+v);
		}
		System.out.println();
		
		map.remove("홍길동");
		System.out.println("총 ENtry 수" + map.size());
		System.out.println();
	}

}
