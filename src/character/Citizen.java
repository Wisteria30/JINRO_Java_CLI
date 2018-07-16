package character;

/**
 * @author 藤岡和真
 */

import java.util.Scanner;

import scene.Prepare;

import java.util.List;

public class Citizen extends Character {
	/* 役職名 */
	private static final String citizen = "市民";
	
	
	public Citizen(){
	}
	
	
	@Override
	public String getJobName() {
		return citizen;
	}
	
	
	@Override
	public boolean getWereWolf() {
		Citizen citizen = new Citizen();
		return citizen instanceof IsWereWolf;
	}
	
	
	
	@Override
	public void jobInfo(){
		System.out.println("あなたは市民です。\n"
				+ 		   "市民は特殊な能力を持っていませんが\n"
				+ 		   "人狼を見つけ出し、勝利に導きましょう\n");
	}
	
	
	
	@Override
	public void jobAction(List<Character> actionList) {
		allShow(actionList);
		Scanner scan = new Scanner(System.in);
		while(true){
			System.out.print("あなたが疑う人物の番号を入力してください: ");
			if(scan.hasNextInt()){
				int doubt = scan.nextInt();
				if(doubt < Prepare.doubtDesition.size()){
					/* 指定した要素番号の値を取得 */
					int value = Prepare.doubtDesition.get(doubt);
					/* 要素をインクリメント */
					value++;
					/* リセット */
					Prepare.doubtDesition.set(doubt, value); 
					break;
				}
			}else scan.next();
		}
	}

}
