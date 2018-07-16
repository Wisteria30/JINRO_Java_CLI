package system;

import scene.Prepare;

/**
 * ゲームで死亡したプレイヤーをリストから削除するクラス
 * @author 藤岡和真
 */

public class Dead {
	
	public static void Death(int dead){
		/* 死人リストに死人追加 */
		Prepare.deadCharList.add(Prepare.characterList.get(dead));
		/* それ以外のリストから死人を削除 */
		Prepare.characterList.remove(dead);
		Prepare.defenceDesition.remove(dead);
		Prepare.doubtDesition.remove(dead);
		Prepare.killDesition.remove(dead);
		Prepare.voltDesition.remove(dead);
	}
}