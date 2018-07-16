package scene;

/**
 * 夜のアクションを行うクラス
 * @author 藤岡和真
 */
import scene.Prepare;
import system.Dead;
import system.MaxSearch;
import system.SceneChange;
import character.Character;
import java.util.Scanner;

public class Night {
	
	public void nightAction(){
		Scanner scanner = new Scanner(System.in);
		SceneChange sChange = new SceneChange();
		
		System.out.println("夜時間になりました。\nアクションを開始してください");
		/* プレイヤーのリストを順番に回してそれぞれのアクションを行う */
		for(Character character : Prepare.characterList){
			loop: while(true){
				System.out.println("あなたは"+character.getName()+"さんですか?");
				System.out.println("y n");
				String str = scanner.next();
				if(str.equals("y")){
					character.jobInfo();
					character.jobAction(Prepare.characterList);
					sChange.inputZ();
					break loop;
				}else scanner.nextLine();
			}
			sChange.barrage();
		}
		
		/*夜のアクション終了*/
		System.out.println("全員の夜のアクションが終了しました\n"
				+ 		   "恐ろしい夜が明け、朝がやってきました");
		
		
		
		/* 騎士が守れなければ死人がでる */
		if(MaxSearch.maxSearchSystem(Prepare.killDesition) == MaxSearch.maxSearchSystem(Prepare.defenceDesition)){
			System.out.println("昨晩の犠牲者はいませんでした");	
		} 
		else{
			System.out.println("昨晩の犠牲者は"+Prepare.characterList.get(MaxSearch.maxSearchSystem(Prepare.killDesition)).getName()+"です。");
			/* リストから要素を削除 */
			Dead.Death(MaxSearch.maxSearchSystem(Prepare.killDesition));
		}
		
		System.out.println("現在疑われているのは"+Prepare.characterList.get(MaxSearch.maxSearchSystem(Prepare.doubtDesition)).getName()+"です");
		
		/* 場面転換 */
		sChange.inputZ();
		sChange.barrage();
	}
}
