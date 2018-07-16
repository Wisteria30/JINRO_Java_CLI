package character;

/**
 * 霊媒師クラス
 * @author 藤岡和真
 */

import java.util.List;

import scene.Prepare;
import system.SceneChange;

public class Mystic extends Character {
	private static final String mystic = "霊媒師";
	
	
	@Override
	public String getJobName() {
		return mystic;
	}

	
	@Override
	public boolean getWereWolf() {
		Mystic mystic = new Mystic();
		return mystic instanceof IsWereWolf;
	}

	
	
	@Override
	public void jobInfo() {
		System.out.println("あなたは霊媒師です。\n"
				+		   "霊媒師は死んだ人物が人狼であったかを知ることができます\n"
				+ 		   "目立ちませんが、推理の鍵になります\n");
	}

	
	
	@Override
	public void jobAction(List<Character> actionList) {
		SceneChange sChange = new SceneChange();
		System.out.println("死者を確認します");
		sChange.inputZ();
		/* deadListの一覧を陣営とともに表示 */
		for(int i=0; i < Prepare.deadCharList.size(); i++){
			System.out.printf("%s ", Prepare.deadCharList.get(i).getName());
			if(Prepare.deadCharList.get(i).getWereWolf()){
				System.out.println("人狼");
			}else
				System.out.println("人間");
		}
	}

}
