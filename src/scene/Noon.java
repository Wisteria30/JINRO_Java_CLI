package scene;

/**
 * 昼の議論や投票を行うクラス
 * @author 藤岡和真
 */

import java.util.Scanner;

import javax.swing.JFrame;

import system.Dead;
import system.TimeFrame;
import system.MaxSearch;
import system.SceneChange;

public class Noon {
	/*
	 * 時間がうまく実装できないので今回はなし
	public void discussionTime(){
		
		SceneChange sChange = new SceneChange();
		System.out.println("議論の時間になりました");
		
		sChange.inputZ();
		
		TimeFrame frame = new TimeFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}
	*/
	
	
	/* 投票をするメソッド */
	public void volt(){
		Scanner scanner = new Scanner(System.in);
		SceneChange sChange = new SceneChange();
		
		
		System.out.println("これより議論の時間に移ります\n"
				+ 		   "時間を決めて、議論を開始してください\n"
				+ 		   "時間が経過したら");
		sChange.inputZ();
		sChange.barrage();
		
		
		System.out.println("投票の時間になりました\n"
				+ 		   "以後の投票の際、会話はしないでください");
		sChange.inputZ();
		sChange.barrage();
		
		/* プレイヤーのリストを順番に回してそれぞれのアクションを行う */
		for(int i=0; i < Prepare.characterList.size(); i++){
			loop: while(true){
				System.out.println("あなたは"+Prepare.characterList.get(i).getName()+"ですか");
				System.out.println("y n");
				String str = scanner.nextLine();
				
				if(str.equals("y")){
					Prepare.characterList.get(i).volt(Prepare.characterList);
					sChange.inputZ();
					break loop;
				}else scanner.nextLine();
			}
		
			sChange.barrage();
		}
		
		/* 投票によって殺害される人物の要素 */
		int voltKill = MaxSearch.maxSearchSystem(Prepare.voltDesition);
		System.out.println(Prepare.characterList.get(voltKill).getName()+"さんが処刑されました");
		/* リストから要素を削除 */
		Dead.Death(voltKill);
		
		sChange.inputZ();
		sChange.barrage();
	}
}
