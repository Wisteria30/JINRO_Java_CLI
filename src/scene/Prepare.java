package scene;

/**
 * ゲーム開始前の準備をするクラス
 * @author 藤岡和真
 */

import java.util.Scanner;


import character.Character;
import character.Citizen;
import character.FortuneTeller;
import character.Knight;
import character.Mystic;
import character.Psychopath;
import character.Werewolf;
import system.SceneChange;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class Prepare {
	/* 参加人数 */
	public int member;
	
	/* プレイヤーの名前配列 */
	private static String[] names;
	
	/* 役職インスタンスのリストを生成 */
	public static List<Character> characterList = new ArrayList<Character>();
	
	/* ゲームで使用する役職の番号リスト */
	public static List<Integer> jobNumbersList = new ArrayList<Integer>();
	
	/* 死亡したプレイヤーのリスト */
	public static List<Character> deadCharList = new ArrayList<Character>();
	
	/* 最終結果の時に全てのプレイヤーを表示するリスト */
	public static List<Character> resultList;
	
	/* 疑うアクションのリスト */
	public static List<Integer> doubtDesition = new ArrayList<Integer>();
	
	/* 昼の投票アクションのリスト */
	public static List<Integer> voltDesition = new ArrayList<Integer>();
	
	/* 人狼の殺害アクションのリスト */
	public static List<Integer> killDesition = new ArrayList<Integer>();
	
	/* 騎士の防衛アクションのリスト */
	public static List<Integer> defenceDesition = new ArrayList<Integer>();
	
	
	
	/* ゲームの準備する */
	public void gameSetUp(){
		Scanner scan = new Scanner(System.in);
		
		/* 参加人数を指定する */
		while(true){
			System.out.print("参加人数を入力してください: ");
			if(scan.hasNextInt()){
				member = scan.nextInt();
				names = new String[member];
				break;
			}else scan.next();
		}
		
		
		/* ループで名前を入力する */
		for(int i=0; i < member;i++){
			while(true){
				System.out.print("参加者の名前を入力してください: ");
				if(scan.hasNext()){
					names[i] = scan.next();
					break;
				}else scan.next();
			}
		}
		
				
		System.out.println("ゲームで使用する役職の番号入力してください: ");
		System.out.print("市民 0\n"
					   + "占い師 1\n"
					   + "霊媒師 2\n"
					   + "騎士   3\n"
					   + "人狼   4\n"
					   + "狂人   5\n");
		
		
		/* 役職を指定してリストに数字を格納する */
		for(int j=0;j<member;j++){
			while(true){
				if(scan.hasNextInt()){
					jobNumbersList.add(scan.nextInt());
					break;
				}else scan.next();
			}	
		}
		
		
		/* 役職をシャッフル */
		Collections.shuffle(jobNumbersList);
			
			
		/* 入力された数字に応じてインスタンスを生成してcharacterListに要素を追加 */
		for(int jobNumber : jobNumbersList){
			switch (jobNumber) {
			case 0:
				characterList.add(new Citizen());
				break;
				
			case 1:
				characterList.add(new FortuneTeller());
				break;
				
			case 2:
				characterList.add(new Mystic());
				break;
				
			case 3:
				characterList.add(new Knight());
				break;
				
			case 4:
				characterList.add(new Werewolf());
				break;
				
			case 5:
				characterList.add(new Psychopath());

				default:
					break;
					
			}
		}
		
			
		/* インスタンスにプレイヤーネームを代入 */
		for(int k=0;k<member;k++){
			characterList.get(k).setName(names[k]);
		}
		
		
		/* 役職毎に使用するリストの要素を格納 */	
		for(int l=0; l<characterList.size();l++){
			doubtDesition.add(0);	
			voltDesition.add(0);
			killDesition.add(0);
			defenceDesition.add(0);
		}
		
		
		/* resultListにcharacterListをコピー */
		resultList = new ArrayList<Character>(characterList.size());
		for (Character result : characterList) {
			resultList.add(result);
		}
		
		SceneChange sChange = new SceneChange();
		System.out.println("これよりゲームを開始します");
		sChange.inputZ();
		sChange.barrage();
		
	}
}
