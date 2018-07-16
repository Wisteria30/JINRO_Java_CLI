package character;

/**
 * 狂人クラス
 * @author 藤岡和真
 */

import java.util.List;
import java.util.Scanner;

import scene.Prepare;

public class Psychopath extends Character{
	private static final String Psychopath = "狂人";

	
	@Override
	public String getJobName() {
		return Psychopath;
	}

	
	@Override
	public boolean getWereWolf() {
		Psychopath psychopath = new Psychopath();
		return psychopath instanceof IsWereWolf;
	}

	
	
	@Override
	public void jobInfo() {
		System.out.println("あなたは狂人です。\n"
				+ 		   "狂人は人狼の味方をする村人です\n"
				+ 		   "人狼を勝利に導きましょう\n");
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
					/* 指定された要素番号の要素を取得 */
					int value = Prepare.voltDesition.get(doubt);
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
