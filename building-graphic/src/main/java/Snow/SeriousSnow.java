package Snow;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.sun.awt.AWTUtilities;

import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JPanel;


public class SeriousSnow extends JDialog {//主窗口
    private static final long serialVersionUID = -6073107021198223228L;
    //获取屏幕分辨率
    public final static int Width = (int) java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
    public final static int Height = (int) java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;

    public static void main(String[] args) {
        new SeriousSnow().setVisible(true);
    }

    public SeriousSnow() {
        this.setLocation(0, 0);//位置
        this.setSize(Width, Height);//大小,大小为屏幕分辨率
        this.setUndecorated(true);//隐藏最大化最小化那一栏，一时想不起叫什么了
        this.setAlwaysOnTop(true);//窗口始终在最顶上
        this.setDefaultCloseOperation(0);//防止按Alt+F4关闭
        hua hua = new hua();
        this.add(hua);
        AWTUtilities.setWindowOpaque(this, false);//实现透明窗口建议使用jre1.7版本
    }
}

class hua extends JPanel implements Runnable {//画布
    private static final long serialVersionUID = -2986761287590314088L;
    public static ArrayList<xue> list = new ArrayList<xue>();
    private BufferedImage img;

    public hua() {
        try {

            img = ImageIO.read(new File(ClassLoader.getSystemResource("snow.png").getFile()));//加载雪花图片
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setOpaque(false);//设为透明的
        new Thread(this).start();//启动线程
    }

    @Override
    public void paint(Graphics g) {
        // TODO 自动生成的方法存根
        super.paint(g);
        for (int i = 0; i < list.size(); i++) {
            xue x = list.get(i);
            g.drawImage(img, (int) x.x, (int) x.y, x.w, x.h, null);
        }
    }

    @Override
    public void run() {
        // TODO 自动生成的方法存根
        int fps = 150;//每秒帧数
        int time = 1000 / fps;
        int ii = 0;
        while (true) {
            long a = System.currentTimeMillis();
            if (ii > 3) {
                new xue();
                ii = 0;
            }
            ii++;
            for (int i = 0; i < list.size(); i++) {//调用所有雪花的run方法
                list.get(i).run();
            }
            repaint();//画雪
            long b = System.currentTimeMillis();
            long c = b - a;
            if (time - c > 0)
                try {
                    Thread.sleep(time - c);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }

}

class xue {//雪0
    public int w, h;
    public float x, y, sdx, sdy;

    public xue() {
        w = h = (int) (Math.random() * 20 + 10);//随机大小
        sdx = (float) (Math.random() * 0.7 + 0.3);//x轴移动速度
        sdy = (float) (Math.random() * 0.4 + 0.3);//y轴移动速度

        //雪花出现的位置只能在屏幕的上右方
        double gailv = (double) (SeriousSnow.Width + SeriousSnow.Height) / SeriousSnow.Width - 1;
        if (Math.random() < gailv) {//雪花在屏幕上方
            y = -h;
            x = (int) (Math.random() * SeriousSnow.Width);
        } else {//雪花在屏幕右方
            x = SeriousSnow.Width;
            y = (int) (Math.random() * SeriousSnow.Height);
        }
        hua.list.add(this);//添加进集合
    }

    public void run() {//雪花的移动
        //如果雪花超出屏幕范围的话就从集合中删掉
        if (x + w < 0 || y > SeriousSnow.Height || x + w < 0 || y > SeriousSnow.Height) {
            hua.list.remove(this);
        }
        y += sdy;
        x -= sdx;
    }
}
