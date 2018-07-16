package system;

/**
 * 議論で使用するタイマーの元となるクラス
 * @author 西田和馬
 */
import java.awt.Font;
import java.awt.Graphics;

public class DiscussionTime {
	 private int i=3;
	 private int a=0;
	 private int b=0;
	public void updata(){
		if(a==0&&b==0){
			i--;
			a=6;
		}
		if(b==0){
			a--;
			b=540;
		}
		
		b--;
	}
	public void draw(Graphics g) {
		g.setFont(new Font("TimesRoman",Font.ITALIC,650));//250
		g.drawString(i+":"+a+""+b/54, 110, 630);//100, 300
        
    }
	
	public int getI(){
		return i;
	}
	
	public int getA(){
		return a;
	}
	
	public int getB(){
		return b;
	}
}
