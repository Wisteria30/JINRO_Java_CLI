package scene;

import character.Character;

/**
 * シーンパッケージのクラスを実装して、一連の処理を行うクラス
 * @author wis30
 *
 */

public class Scene {
	/* ゲーム上の人間と人狼の数をカウントする */
	private static int isHuman;
	private static int isWereWolf;
	
	
	
	public int getIsHuman() {
		return isHuman;
	}
	
	public int getIsWereWolf() {
		return isWereWolf;
	}
	
	
	/* 人間と人狼の数をカウント */
	public void checkMember(){
			
		isHuman = 0;
		isWereWolf = 0;
		
		for(Character character : Prepare.characterList){
			if(character.getWereWolf()){
				isWereWolf++;
			}
			else{
				isHuman++;
			}
		}
		
	}
	
	
	
	/* ゲームの進行を行う */
	public void sequence(){
		
		/* メソッド内で使用するクラスのインスタンスを生成 */
		Prepare prepare = new Prepare();
		Noon noon = new Noon();
		Night night = new Night();
		Result result = new Result();
		
		/*ゲームセットアップ*/
		prepare.gameSetUp();
		
		/* 陣営カウント */
		checkMember();

		/* 人狼が0になる、もしくは人狼と人間が同数のときループを終了させる */
		while(true){
			
			/* 夜のアクション */
			night.nightAction();
			
			/* 陣営カウント */
			checkMember();
			
			if(isWereWolf == 0 || isHuman <= isWereWolf)
				break;
			
			/* 昼の投票と処刑 */
			noon.volt();
			
			/* 陣営カウント */
			checkMember();
			
			if(isWereWolf == 0 || isHuman <= isWereWolf)
				break;
			
		}
		/* リザルト画面 */
		result.ResultScene();
	}
}
