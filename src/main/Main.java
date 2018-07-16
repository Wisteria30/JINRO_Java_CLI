package main;

import scene.Scene;

/**
 * メインメソッドがあるクラス
 * @author 藤岡和真
 *
 */

public class Main {

	public static void main(String[] args) {
		/* シーンオブジェクトを生成して実行する */
		Scene scene = new Scene();
		scene.sequence();
	}

}
