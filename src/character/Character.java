package character;

/**
 * 役職のクラスの元となる抽象クラス
 * @author 藤岡和真
 */

import java.util.List;
import java.util.Scanner;

import scene.Prepare;

public abstract class Character {
	/* 入力されたプレイヤーネームを入れるフィールド */
	private String name;
	
	
	public Character(){
		
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getName(){
		return name;
	}
	
	
	/**
	 * 役職名を表示する
	 * @return name
	 */
	public abstract String getJobName();
	
	
	/**
	 * 人狼陣営かどうかの判定
	 * @return　IsWereWolfを継承してくるかの判定
	 */
	public abstract boolean getWereWolf();
	
	
	/**
	 * 役職の説明を表示
	 */
	public abstract void jobInfo();
	
	
	/**
	 * 全ての役職のオブジェクトを表示する
	 * @param actionList
	 */
	public void allShow(List<Character> characters){
		for(int i=0; i < characters.size(); i++){
			/* indexOfに変更 */
			System.out.printf("%s %d\n", characters.get(i).getName(), i );
		}
	}
	
	
	/**
	 * アクションメソッド
	 * 各役職の行動の抽象メソッド
	 */
	public abstract void jobAction(List<Character> actionList);
	
	
	/**
	 * 昼に行われる投票のメソッド
	 */
	public void volt(List<Character> characters){
		Scanner scan = new Scanner(System.in);
		allShow(characters);
		loop: while(true){
			System.out.print("投票先の人物の番号を入力してください: ");
			if(scan.hasNextInt()){
				int volt = scan.nextInt();
				if(volt < Prepare.voltDesition.size()){
					int value = Prepare.voltDesition.get(volt);
					value++;
					Prepare.voltDesition.set(volt, value);
					break loop;
				}
			}else scan.next();
		}
	}
}
