package system;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JPanel;

import densan.s.game.input.KeyInput;
import scene.Noon;


/**
 * タイマーパネルの元になるクラス
 * @author 西田和馬
 *  
 */
public class TimePanel extends JPanel implements Runnable{
	//縦横の大きさ
    public static final int WIDTH = 1440; //640
    public static final int HEIGHT = 960;
    
    //スレッドループ
    private Thread gameLoop;
    DiscussionTime discussion;

    public TimePanel() {
    	//画面サイズ設定
    	setPreferredSize(new Dimension(WIDTH, HEIGHT));
        // 
    	discussion = new DiscussionTime();
        setFocusable(true);
   
        gameLoop = new Thread(this);
        gameLoop.start();
    }

    /**
     *ゲームの骨組み
    */
    public void run() {
    	
        while (true) {
        	discussion.updata();
        	
        	/* タイマーが0:00になると終了 */
        	if(discussion.getI()==0 && discussion.getA()==0 && discussion.getB()==0 ){
        		break;
        	}
        	/* エンタキーを入力すると終了 */
        	if(KeyInput.isPressing(KeyEvent.VK_ENTER)){
        		break;
        	}
            repaint(); // 繰り返す

            // 少し止める
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        	}
    }
    /**
     * 画像表示
     */
     public void paintComponent(Graphics g) {
        super.paintComponent(g);
    	g.setColor(Color.red);
        discussion.draw(g);
    }
}