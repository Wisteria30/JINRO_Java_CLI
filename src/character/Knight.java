package character;

/**
 * 騎士クラス
 * @author 藤岡和真
 */

import java.util.List;
import java.util.Scanner;

import scene.Prepare;


public class Knight extends Character {
	private static final String Knight = "騎士";
	
	
	@Override
	public String getJobName() {
		return Knight;
	}

	
	
	@Override
	public boolean getWereWolf() {
		Knight knight = new Knight();
		return knight instanceof IsWereWolf;
	}
	
	
	
	@Override
	public void jobInfo(){
		System.out.println("あなたは騎士です。\n"
				+ 		   "騎士は毎晩誰か一人を守ることができます\n"
				+ 		   "村人を人狼の魔の手から守りましょう\n");
	}

	
	
	
	@Override
	public void jobAction(List<Character> actionList) {
		allShow(actionList);
		Scanner scan = new Scanner(System.in);
		
		while(true){
			System.out.print("守る人物の番号を入力してください: ");
			if(scan.hasNextInt()){
				int defense = scan.nextInt();
				if(defense < Prepare.defenceDesition.size()){
					/* 指定した要素番号の要素を取得 */
					int value = Prepare.defenceDesition.get(defense);
					/* 要素をインクリメント */
					value++;
					/* リセット */
					Prepare.defenceDesition.set(defense, value);
					break;
				}
			}else scan.next();
		}
	}

}
