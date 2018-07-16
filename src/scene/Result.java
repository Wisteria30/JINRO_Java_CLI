package scene;
/**
 * ゲーム終了後のリザルト画面を表示するクラス
 * @author 藤岡和真
 *
 */


public class Result {
	
	public void ResultScene(){
		
		System.out.println("ゲームが終了しました");
		
		Scene scene = new Scene();
		/* 陣営の勝利判定 */
		if( scene.getIsWereWolf() == 0 ){
			System.out.println("これ以降、村が襲われることはありませんでした"
					+ 		   "人狼はいなくなったようです\n"
					+ 		   "村人の勝利です\n");
		}
		else if( scene.getIsHuman() <= scene.getIsWereWolf() ){
			System.out.println("その後、残りの村人も皆食い殺されてしまいました\n"
					+ 		   "村には誰もいなくなりました\n"
					+ 		   "人狼の勝利です\n");
		}
		
		
		/* 役職リストの表示 */
		System.out.println("役職リスト");
		for(int i=0; i < Prepare.resultList.size(); i++ ){
			System.out.printf("%s %s\n", Prepare.resultList.get(i).getName(), Prepare.resultList.get(i).getJobName());
		}
		
		
	}

}
