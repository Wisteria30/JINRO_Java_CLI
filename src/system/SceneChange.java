package system;

import java.util.Scanner;

/**
 * シーンの交代の際の幕の表示やエンターキの入力などを行う
 * @author 藤岡和真
 *
 */
public class SceneChange {

	/* 他人のアクションがわからないように弾幕を張る */
	public void barrage(){
		for(int i=0; i< 22; i++){
			System.out.println("/////////////////////////////////////////////////////");
		}
	}
	
	
	/* エンターキーを入力することで場面を進める */
	public void inputZ(){
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.println("Zキーを押してください");
			String string = scanner.nextLine();
			if(string.equals("z")){
				break;
				/* 処理を入力待ちにするだけなので処理内容はない */
			}else scanner.nextLine();
		}
	}
	
}
