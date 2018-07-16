package system;

/**
 * リストの最大値が格納されている要素番号を取得
 * @author 藤岡和真
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class MaxSearch {
	public static int maxSearchSystem(List<Integer> searchedList){
		/* 複数の最大値を格納するリスト */
		List<Integer> maxList = new ArrayList<>();
		/* リスト内の最大値サーチ */
		int max = Collections.max(searchedList);
		/* 最大値と同値の要素番号をサーチ */
		for(int i = 0; i < searchedList.size(); i++){
			if(searchedList.get(i).equals(max)){
				maxList.add(i);
			}
		}
		/* maxesをシャッフル */
		Collections.shuffle(maxList);
		/* maxesの初番をとりだす */
		int realMax = maxList.get(0);
		return realMax;
		
	}
}
