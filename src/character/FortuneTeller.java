package character;

/**
 * 占い師クラス
 * @author 藤岡和真
 */

import java.util.List;
import java.util.Scanner;

import scene.Prepare;

public class FortuneTeller extends Character {
	private static final String fortuneTeller = "占い師"; 

	
	@Override
	public String getJobName() {
		return fortuneTeller;
	}

	
	
	@Override
	public boolean getWereWolf() {
		FortuneTeller fortuneTeller = new FortuneTeller();
		return fortuneTeller instanceof IsWereWolf;
	}
	
	
	
	@Override
	public void jobInfo() {
		System.out.println("あなたは占い師です。\n"
				+ 		   "占い師は毎晩一人を占い、その人物が人狼かどうかを知ることができます\n"
				+ 		   "村人陣営の重要人物です\n");
	}

	
	
	@Override
	public void jobAction(List<Character> actionList) {
		allShow(actionList);
		Scanner scan = new Scanner(System.in);
		while(true){
			System.out.print("占いたい人物の番号を入力してください: ");
			if(scan.hasNextInt()){
				int foretell = scan.nextInt();
				if(foretell < Prepare.characterList.size()){
					/* インスタンスが人狼かをgetWereWolfメソッドを使用して判定 */
					if( Prepare.characterList.get(foretell).getWereWolf() ){
						System.out.println(Prepare.characterList.get(foretell).getName()+"は人狼です");
						break;
					}else{ 
						System.out.println(Prepare.characterList.get(foretell).getName()+"は人狼ではありません");
						break;
					}
				}
			}else scan.next();
		}
	}

}
