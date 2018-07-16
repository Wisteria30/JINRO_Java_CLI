package system;
import java.awt.Container;

import javax.swing.JFrame;

/**
 * タイマーを作成するクラス
 * @author 西田和馬
 *
 */
public class TimeFrame extends JFrame {
    public TimeFrame() {
       //タイトルを設定
        setTitle("DiscussionTime");
      //フレームサイズ変更なし
        setResizable(false);
      //メインパネルを製作してフレームに追加
        TimePanel panel = new TimePanel();
        Container contentPane = getContentPane();
        contentPane.add(panel);
      //パネルサイズに合わせてフレームサイズを自動設定
       pack();
    }
}
