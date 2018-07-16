package character;

/**
 * 人狼クラス
 * @author 藤岡和真
 */

import java.util.List;
import java.util.Scanner;

import scene.Prepare;

public class Werewolf extends Character implements IsWereWolf{
	private static final String wereWolf = "人狼";
	/* 人狼の数カウント */
	private int wwc;
	
	
	public Werewolf() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	
	
	@Override
	public String getJobName(){
		return wereWolf;
	}
	
	
	
	@Override
	public boolean getWereWolf() {
		Werewolf werewolf = new Werewolf();
		return werewolf instanceof IsWereWolf;
	}
	
	
	/* 役職の説明 */
	@Override
	public void jobInfo() {
		System.out.println("あなたは人狼です\n"
				+ 		   "人狼は毎晩一人を殺害することができます\n"
				+ 		   "村人を欺き、村を滅ぼしましょう\n");
		
		
		/* 自分以外の人狼の確認 */
		for(int wwnumber : Prepare.jobNumbersList){
			if(wwnumber == 4){
				wwc++;
			}
		}
		/* 人狼が複数いた場合、処理を行う */
		if(wwc > 1){
			System.out.print("人狼は ");
			for(int i=0; i < Prepare.resultList.size(); i++){
				if(Prepare.resultList.get(i).getWereWolf()){
					System.out.print(Prepare.resultList.get(i).getName() +" ");
				}
			}
			System.out.println("です\n");
		}
	}
	
	
	
	/* 役職の夜アクション */
	@Override
	public void jobAction(List<Character> actionList) {
		allShow(actionList);
		Scanner scan = new Scanner(System.in);
		/* 時間的に今回は実装しない処理
		 * 人狼が二人以上のとき、もう一人が誰を殺害するつもりか表示
		if(wwc > 1){
			for(int i=0; i < Prepare.characterList.indexOf(); i++){
				if(Prepare.characterList.get(i).getWereWolf()){
					System.out.print(Prepare.characterList.get(i).getName() +"は"+ );
				}
			}
		}
		*/
		
		
		while(true){
			System.out.print("殺害したい人物の番号を入力してください: ");
			if(scan.hasNextInt()){
				int kill = scan.nextInt();
				if(kill < Prepare.killDesition.size()){
					/* 指定した要素番号の要素を取得 */
					int value = Prepare.killDesition.get(kill);
					/* 要素をインクリメント */
					value++;
					/* リセット */
					Prepare.killDesition.set(kill, value);
					break;
				}
			}else scan.next();
		}
	}

}
