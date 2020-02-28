
package imagefiltering;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public final class ImageFiltering {
    Picture picture;
    Color color[][];
    Color dumcolor[][];
    int count = 0;
    
    public ImageFiltering(Picture picture){ 
        this.picture = picture;
        color = new Color[height()][width()];
        
        for (int i = 0; i < height(); i++) {
            for (int j = 0; j < width(); j++) {
                color[i][j] = this.picture.get(j, i);
            }
        }
    }
    
    public Picture picture(){ 
        return picture;
    }
    
    public int width(){ 
        return this.picture.width();
    }
     
    public int height(){ 
        return this.picture.height();
    }

    public void MeanFilter(){
        dumcolor = new Color[height()][width()];
        
        for (int i = 0; i < height(); i++) {
            for (int j = 0; j < width(); j++) {
                dumcolor[i][j] = Meancompute(j,i);
            }
        }
    }
    
    public Color Meancompute(int x, int y){
        if(isBorder(x,y)){
            if(x == 0 && y == 0){
                Color X = new Color(picture.get(x, y).getRGB());
                Color R = new Color(picture.get(x + 1, y).getRGB());
                Color B = new Color(picture.get(x, y + 1).getRGB());
                Color BR = new Color(picture.get(x + 1, y + 1).getRGB());
                
                int Red = (X.getRed() + R.getRed() + B.getRed() + BR.getRed())/4;
                int Green = (X.getGreen() + R.getGreen() + B.getGreen() + BR.getGreen())/4;
                int Blue = (X.getBlue() + R.getBlue() +  B.getBlue() + BR.getBlue())/4;
            
                return new Color(Red, Green, Blue);
            }
            else if(x == width() - 1 && y == height() - 1){
                Color TL = new Color(picture.get(x - 1, y - 1).getRGB());
                Color T = new Color(picture.get(x, y - 1).getRGB());
                Color L = new Color(picture.get(x - 1, y).getRGB());
                Color X = new Color(picture.get(x, y).getRGB());
                
                int Red = (TL.getRed() + T.getRed() + L.getRed() + X.getRed())/4;
                int Green = (TL.getGreen() + T.getGreen() + L.getGreen() + X.getGreen())/4;
                int Blue = (TL.getBlue() + T.getBlue() +  L.getBlue() + X.getBlue())/4;
            
                return new Color(Red, Green, Blue);
            }
            else if(x == width() - 1 && y == 0){
                Color L = new Color(picture.get(x - 1, y).getRGB());
                Color X = new Color(picture.get(x, y).getRGB());
                Color BL = new Color(picture.get(x - 1, y + 1).getRGB());
                Color B = new Color(picture.get(x, y + 1).getRGB());
                
                int Red = (L.getRed() + X.getRed() + BL.getRed() + B.getRed())/4;
                int Green = (L.getGreen() + X.getGreen() + BL.getGreen() + B.getGreen())/4;
                int Blue = (L.getBlue() + X.getBlue() +  BL.getBlue() + B.getBlue())/4;
            
                return new Color(Red, Green, Blue);
            }
            else if(x == 0 && y == height() - 1){
                Color T = new Color(picture.get(x, y - 1).getRGB());
                Color TR = new Color(picture.get(x + 1, y - 1).getRGB());
                Color X = new Color(picture.get(x, y).getRGB());
                Color R = new Color(picture.get(x + 1, y).getRGB());

                int Red = (T.getRed() + TR.getRed() + X.getRed() + R.getRed())/4;
                int Green = (T.getGreen() + TR.getGreen() + X.getGreen() + R.getGreen())/4;
                int Blue = (T.getBlue() + TR.getBlue() +  X.getBlue() + R.getBlue())/4;
            
                return new Color(Red, Green, Blue);
        
            }
            else if(x == 0){
                Color T = new Color(picture.get(x, y - 1).getRGB());
                Color TR = new Color(picture.get(x + 1, y - 1).getRGB());
                Color X = new Color(picture.get(x, y).getRGB());
                Color R = new Color(picture.get(x + 1, y).getRGB());
                Color B = new Color(picture.get(x, y + 1).getRGB());
                Color BR = new Color(picture.get(x + 1, y + 1).getRGB());

                int Red = (T.getRed() + TR.getRed() + X.getRed() + R.getRed() + B.getRed() + BR.getRed())/6;
                int Green = (T.getGreen() + TR.getGreen() + X.getGreen() + R.getGreen() + B.getGreen() + BR.getGreen())/6;
                int Blue = (T.getBlue() + TR.getBlue() +  X.getBlue() + R.getBlue() + B.getBlue() + BR.getBlue())/6;
            
                return new Color(Red, Green, Blue);
            }
            else if(y == 0){
                Color L = new Color(picture.get(x - 1, y).getRGB());
                Color X = new Color(picture.get(x, y).getRGB());
                Color R = new Color(picture.get(x + 1, y).getRGB());
                Color BL = new Color(picture.get(x - 1, y + 1).getRGB());
                Color B = new Color(picture.get(x, y + 1).getRGB());
                Color BR = new Color(picture.get(x + 1, y + 1).getRGB());

                int Red = (L.getRed() + X.getRed() + R.getRed() + BL.getRed() + B.getRed() + BR.getRed())/6;
                int Green = (L.getGreen() + X.getGreen() + R.getGreen() + BL.getGreen() + B.getGreen() + BR.getGreen())/6;
                int Blue = (L.getBlue() + X.getBlue() +  R.getBlue() + BL.getBlue() + B.getBlue() + BR.getBlue())/6;
            
                return new Color(Red, Green, Blue);
            }
            else if(x == width() - 1){
                Color TL = new Color(picture.get(x - 1, y - 1).getRGB());
                Color T = new Color(picture.get(x, y - 1).getRGB());
                Color L = new Color(picture.get(x - 1, y).getRGB());
                Color X = new Color(picture.get(x, y).getRGB());
                Color BL = new Color(picture.get(x - 1, y + 1).getRGB());
                Color B = new Color(picture.get(x, y + 1).getRGB());
                
                int Red = (TL.getRed() + T.getRed() + L.getRed() + X.getRed() + BL.getRed() + B.getRed())/6;
                int Green = (TL.getGreen() + T.getGreen() + L.getGreen() + X.getGreen() + BL.getGreen() + B.getGreen())/6;
                int Blue = (TL.getBlue() + T.getBlue() +  L.getBlue() + X.getBlue() + BL.getBlue() + B.getBlue())/6;
            
                return new Color(Red, Green, Blue);
            }
            else if(y == height() - 1){
                Color TL = new Color(picture.get(x - 1, y - 1).getRGB());
                Color T = new Color(picture.get(x, y - 1).getRGB());
                Color TR = new Color(picture.get(x + 1, y - 1).getRGB());
                Color L = new Color(picture.get(x - 1, y).getRGB());
                Color X = new Color(picture.get(x, y).getRGB());
                Color R = new Color(picture.get(x + 1, y).getRGB());
                
                int Red = (TL.getRed() + T.getRed() + TR.getRed() + L.getRed() + X.getRed() + R.getRed())/6;
                int Green = (TL.getGreen() + T.getGreen() + TR.getGreen() + L.getGreen() + X.getGreen() + R.getGreen())/6;
                int Blue = (TL.getBlue() + T.getBlue() +  TR.getBlue() + L.getBlue() + X.getBlue() + R.getBlue())/6;
            
                return new Color(Red, Green, Blue);
            }
        }
        else{
            Color TL = new Color(picture.get(x - 1, y - 1).getRGB());
            Color T = new Color(picture.get(x, y - 1).getRGB());
            Color TR = new Color(picture.get(x + 1, y - 1).getRGB());
            
            Color L = new Color(picture.get(x - 1, y).getRGB());
            Color X = new Color(picture.get(x, y).getRGB());
            Color R = new Color(picture.get(x + 1, y).getRGB());
            
            Color BL = new Color(picture.get(x - 1, y + 1).getRGB());
            Color B = new Color(picture.get(x, y + 1).getRGB());
            Color BR = new Color(picture.get(x + 1, y + 1).getRGB());
            
            int Red = (TL.getRed() + T.getRed() + TR.getRed() + L.getRed() + X.getRed() + R.getRed() + BL.getRed() + B.getRed() + BR.getRed())/9;
            int Green = (TL.getGreen() + T.getGreen() + TR.getGreen() + L.getGreen() + X.getGreen() + R.getGreen() + BL.getGreen() + B.getGreen() + BR.getGreen())/9;
            int Blue = (TL.getBlue() + T.getBlue() + TR.getBlue() + L.getBlue() + X.getBlue() + R.getBlue() + BL.getBlue() + B.getBlue() + BR.getBlue())/9;
            
            return new Color(Red, Green, Blue);
        }
        return null;
    }
    
    public void MaxFilter(){
        dumcolor = new Color[height()][width()];
        for (int i = 0; i < height(); i++) {
            for (int j = 0; j < width(); j++) {
                dumcolor[i][j] = Maxcompute(j,i);
            }
        }
    }
    
    public Color Maxcompute(int x, int y){
        if(isBorder(x,y)){
            if(x == 0 && y == 0){
                Color X = new Color(picture.get(x, y).getRGB());
                Color R = new Color(picture.get(x + 1, y).getRGB());
                Color B = new Color(picture.get(x, y + 1).getRGB());
                Color BR = new Color(picture.get(x + 1, y + 1).getRGB());
                
                int Red = max(X.getRed(), R.getRed(), B.getRed(), BR.getRed(), -1,-1,-1,-1,-1);
                int Green = max(X.getGreen(), R.getGreen(), B.getGreen(), BR.getGreen(), -1,-1,-1,-1,-1);
                int Blue = max(X.getBlue(), R.getBlue(), B.getBlue(), BR.getBlue(), -1,-1,-1,-1,-1);

                return new Color(Red, Green, Blue);
            }
            else if(x == width() - 1 && y == height() - 1){
                Color TL = new Color(picture.get(x - 1, y - 1).getRGB());
                Color T = new Color(picture.get(x, y - 1).getRGB());
                Color L = new Color(picture.get(x - 1, y).getRGB());
                Color X = new Color(picture.get(x, y).getRGB());
                
                int Red = max(TL.getRed(), T.getRed(), L.getRed(), X.getRed(), -1,-1,-1,-1,-1);
                int Green = max(TL.getGreen(), T.getGreen(), L.getGreen(), X.getGreen(), -1,-1,-1,-1,-1);
                int Blue = max(TL.getBlue(), T.getBlue(), L.getBlue(), X.getBlue(), -1,-1,-1,-1,-1);

                return new Color(Red, Green, Blue);
            }
            else if(x == width() - 1 && y == 0){
                Color L = new Color(picture.get(x - 1, y).getRGB());
                Color X = new Color(picture.get(x, y).getRGB());
                Color BL = new Color(picture.get(x - 1, y + 1).getRGB());
                Color B = new Color(picture.get(x, y + 1).getRGB());
                
                int Red = max(L.getRed(), X.getRed(), BL.getRed(), B.getRed(), -1,-1,-1,-1,-1);
                int Green = max(L.getGreen(), X.getGreen(), BL.getGreen(), B.getGreen(), -1,-1,-1,-1,-1);
                int Blue = max(L.getBlue(), X.getBlue(), BL.getBlue(), B.getBlue(), -1,-1,-1,-1,-1);

                return new Color(Red, Green, Blue);
            }
            else if(x == 0 && y == height() - 1){
                Color T = new Color(picture.get(x, y - 1).getRGB());
                Color TR = new Color(picture.get(x + 1, y - 1).getRGB());
                Color X = new Color(picture.get(x, y).getRGB());
                Color R = new Color(picture.get(x + 1, y).getRGB());
                
                int Red = max(T.getRed(), TR.getRed(), R.getRed(), X.getRed(), -1,-1,-1,-1,-1);
                int Green = max(T.getGreen(), TR.getGreen(), R.getGreen(), X.getGreen(), -1,-1,-1,-1,-1);
                int Blue = max(T.getBlue(), TR.getBlue(), R.getBlue(), X.getBlue(), -1,-1,-1,-1,-1);

                return new Color(Red, Green, Blue);
        
            }
            else if(x == 0){
                Color T = new Color(picture.get(x, y - 1).getRGB());
                Color TR = new Color(picture.get(x + 1, y - 1).getRGB());
                Color X = new Color(picture.get(x, y).getRGB());
                Color R = new Color(picture.get(x + 1, y).getRGB());
                Color B = new Color(picture.get(x, y + 1).getRGB());
                Color BR = new Color(picture.get(x + 1, y + 1).getRGB());

                int Red = max(T.getRed(), TR.getRed(), R.getRed(), X.getRed(), B.getRed(), BR.getRed(),-1,-1,-1);
                int Green = max(T.getGreen(), TR.getGreen(), R.getGreen(), X.getGreen(), B.getGreen(), BR.getGreen(), -1,-1,-1);
                int Blue = max(T.getBlue(), TR.getBlue(), R.getBlue(), X.getBlue(), B.getBlue(), BR.getBlue(), -1,-1,-1);

                return new Color(Red, Green, Blue);
            }
            else if(y == 0){
                Color L = new Color(picture.get(x - 1, y).getRGB());
                Color X = new Color(picture.get(x, y).getRGB());
                Color R = new Color(picture.get(x + 1, y).getRGB());

                Color BL = new Color(picture.get(x - 1, y + 1).getRGB());
                Color B = new Color(picture.get(x, y + 1).getRGB());
                Color BR = new Color(picture.get(x + 1, y + 1).getRGB());

                int Red = max(L.getRed(), X.getRed(), R.getRed(), BL.getRed(), B.getRed(), BR.getRed(),-1,-1,-1);
                int Green = max(L.getGreen(), X.getGreen(), R.getGreen(), BL.getGreen(), B.getGreen(), BR.getGreen(), -1,-1,-1);
                int Blue = max(L.getBlue(), X.getBlue(), R.getBlue(), BL.getBlue(), B.getBlue(), BR.getBlue(), -1,-1,-1);

                return new Color(Red, Green, Blue);
            }
            else if(x == width() - 1){
                Color TL = new Color(picture.get(x - 1, y - 1).getRGB());
                Color T = new Color(picture.get(x, y - 1).getRGB());
                Color L = new Color(picture.get(x - 1, y).getRGB());
                Color X = new Color(picture.get(x, y).getRGB());
                Color BL = new Color(picture.get(x - 1, y + 1).getRGB());
                Color B = new Color(picture.get(x, y + 1).getRGB());
                
                int Red = max(T.getRed(), TL.getRed(), L.getRed(), X.getRed(), B.getRed(), BL.getRed(),-1,-1,-1);
                int Green = max(T.getGreen(), TL.getGreen(), L.getGreen(), X.getGreen(), B.getGreen(), BL.getGreen(), -1,-1,-1);
                int Blue = max(T.getBlue(), TL.getBlue(), L.getBlue(), X.getBlue(), B.getBlue(), BL.getBlue(), -1,-1,-1);

                return new Color(Red, Green, Blue);
            }
            else if(y == height() - 1){
                Color TL = new Color(picture.get(x - 1, y - 1).getRGB());
                Color T = new Color(picture.get(x, y - 1).getRGB());
                Color TR = new Color(picture.get(x + 1, y - 1).getRGB());

                Color L = new Color(picture.get(x - 1, y).getRGB());
                Color X = new Color(picture.get(x, y).getRGB());
                Color R = new Color(picture.get(x + 1, y).getRGB());
                
                int Red = max(T.getRed(), TL.getRed(), TR.getRed(), X.getRed(), L.getRed(), R.getRed(),-1,-1,-1);
                int Green = max(T.getGreen(), TL.getGreen(), TR.getGreen(), X.getGreen(), L.getGreen(), R.getGreen(), -1,-1,-1);
                int Blue = max(T.getBlue(), TL.getBlue(), TR.getBlue(), X.getBlue(), L.getBlue(), R.getBlue(), -1,-1,-1);

                return new Color(Red, Green, Blue);
            }
        }
        else{
            Color TL = new Color(picture.get(x - 1, y - 1).getRGB());
            Color T = new Color(picture.get(x, y - 1).getRGB());
            Color TR = new Color(picture.get(x + 1, y - 1).getRGB());
            
            Color L = new Color(picture.get(x - 1, y).getRGB());
            Color X = new Color(picture.get(x, y).getRGB());
            Color R = new Color(picture.get(x + 1, y).getRGB());
            
            Color BL = new Color(picture.get(x - 1, y + 1).getRGB());
            Color B = new Color(picture.get(x, y + 1).getRGB());
            Color BR = new Color(picture.get(x + 1, y + 1).getRGB());
            
            int Red = max(TL.getRed(), T.getRed(), TR.getRed(), L.getRed(), X.getRed(), R.getRed(), BL.getRed(), B.getRed(), BR.getRed());
            int Green = max(TL.getGreen(), T.getGreen(), TR.getGreen(), L.getGreen(), X.getGreen(), R.getGreen(), BL.getGreen(), B.getGreen(), BR.getGreen());
            int Blue = max(TL.getBlue(), T.getBlue(), TR.getBlue(), L.getBlue(), X.getBlue(), R.getBlue(), BL.getBlue(), B.getBlue(), BR.getBlue());
            
            return new Color(Red, Green, Blue);
        }
        return null;
    }
    
    public int max(int a, int b, int c, int d, int e, int f, int g, int h, int i){
        int max = Math.max(a, Math.max(b, Math.max(c, Math.max(d, Math.max(e, Math.max(f, Math.max(g, Math.max(h, i))))))));
        
        if(max == a){
            return a;
        }
        else if(max == b){
            return b;
        }
        else if(max == b){
            return b;
        }
        else if(max == c){
            return c;
        }
        else if(max == d){
            return d;
        }
        else if(max == e){
            return e;
        }
        else if(max == f){
            return f;
        }
        else if(max == g){
            return g;
        }
        else if(max == h){
            return h;
        }
        else{
            return i;
        }
    }
    
    public void MinFilter(){
        dumcolor = new Color[height()][width()];
        
        for (int i = 0; i < height(); i++) {
            for (int j = 0; j < width(); j++) {
                dumcolor[i][j] = Mincompute(j,i);
            }
        }
    }
    
    public Color Mincompute(int x, int y){
        if(isBorder(x,y)){
            if(x == 0 && y == 0){
                Color X = new Color(picture.get(x, y).getRGB());
                Color R = new Color(picture.get(x + 1, y).getRGB());
                Color B = new Color(picture.get(x, y + 1).getRGB());
                Color BR = new Color(picture.get(x + 1, y + 1).getRGB());
                
                int Red = min(X.getRed(), R.getRed(), B.getRed(), BR.getRed(), 256,256,256,256,256);
                int Green = min(X.getGreen(), R.getGreen(), B.getGreen(), BR.getGreen(), 256,256,256,256,256);
                int Blue = min(X.getBlue(), R.getBlue(), B.getBlue(), BR.getBlue(), 256,256,256,256,256);

                return new Color(Red, Green, Blue);
            }
            else if(x == width() - 1 && y == height() - 1){
                Color TL = new Color(picture.get(x - 1, y - 1).getRGB());
                Color T = new Color(picture.get(x, y - 1).getRGB());
                Color L = new Color(picture.get(x - 1, y).getRGB());
                Color X = new Color(picture.get(x, y).getRGB());
                
                int Red = min(TL.getRed(), T.getRed(), L.getRed(), X.getRed(), 256,256,256,256,256);
                int Green = min(TL.getGreen(), T.getGreen(), L.getGreen(), X.getGreen(), 256,256,256,256,256);
                int Blue = min(TL.getBlue(), T.getBlue(), L.getBlue(), X.getBlue(), 256,256,256,256,256);

                return new Color(Red, Green, Blue);
            }
            else if(x == width() - 1 && y == 0){
                Color L = new Color(picture.get(x - 1, y).getRGB());
                Color X = new Color(picture.get(x, y).getRGB());
                Color BL = new Color(picture.get(x - 1, y + 1).getRGB());
                Color B = new Color(picture.get(x, y + 1).getRGB());
                
                int Red = min(L.getRed(), X.getRed(), BL.getRed(), B.getRed(), 256,256,256,256,256);
                int Green = min(L.getGreen(), X.getGreen(), BL.getGreen(), B.getGreen(), 256,256,256,256,256);
                int Blue = min(L.getBlue(), X.getBlue(), BL.getBlue(), B.getBlue(), 256,256,256,256,256);

                return new Color(Red, Green, Blue);
            }
            else if(x == 0 && y == height() - 1){
                Color T = new Color(picture.get(x, y - 1).getRGB());
                Color TR = new Color(picture.get(x + 1, y - 1).getRGB());
                Color X = new Color(picture.get(x, y).getRGB());
                Color R = new Color(picture.get(x + 1, y).getRGB());
                
                int Red = min(T.getRed(), TR.getRed(), R.getRed(), X.getRed(), 256,256,256,256,256);
                int Green = min(T.getGreen(), TR.getGreen(), R.getGreen(), X.getGreen(), 256,256,256,256,256);
                int Blue = min(T.getBlue(), TR.getBlue(), R.getBlue(), X.getBlue(), 256,256,256,256,256);

                return new Color(Red, Green, Blue);
        
            }
            else if(x == 0){
                Color T = new Color(picture.get(x, y - 1).getRGB());
                Color TR = new Color(picture.get(x + 1, y - 1).getRGB());
                Color X = new Color(picture.get(x, y).getRGB());
                Color R = new Color(picture.get(x + 1, y).getRGB());
                Color B = new Color(picture.get(x, y + 1).getRGB());
                Color BR = new Color(picture.get(x + 1, y + 1).getRGB());

                int Red = min(T.getRed(), TR.getRed(), R.getRed(), X.getRed(), B.getRed(), BR.getRed(),256,256,256);
                int Green = min(T.getGreen(), TR.getGreen(), R.getGreen(), X.getGreen(), B.getGreen(), BR.getGreen(), 256,256,256);
                int Blue = min(T.getBlue(), TR.getBlue(), R.getBlue(), X.getBlue(), B.getBlue(), BR.getBlue(), 256,256,256);

                return new Color(Red, Green, Blue);
            }
            else if(y == 0){
                Color L = new Color(picture.get(x - 1, y).getRGB());
                Color X = new Color(picture.get(x, y).getRGB());
                Color R = new Color(picture.get(x + 1, y).getRGB());

                Color BL = new Color(picture.get(x - 1, y + 1).getRGB());
                Color B = new Color(picture.get(x, y + 1).getRGB());
                Color BR = new Color(picture.get(x + 1, y + 1).getRGB());

                int Red = min(L.getRed(), X.getRed(), R.getRed(), BL.getRed(), B.getRed(), BR.getRed(),256,256,256);
                int Green = min(L.getGreen(), X.getGreen(), R.getGreen(), BL.getGreen(), B.getGreen(), BR.getGreen(), 256,256,256);
                int Blue = min(L.getBlue(), X.getBlue(), R.getBlue(), BL.getBlue(), B.getBlue(), BR.getBlue(), 256,256,256);

                return new Color(Red, Green, Blue);
            }
            else if(x == width() - 1){
                Color TL = new Color(picture.get(x - 1, y - 1).getRGB());
                Color T = new Color(picture.get(x, y - 1).getRGB());
                Color L = new Color(picture.get(x - 1, y).getRGB());
                Color X = new Color(picture.get(x, y).getRGB());
                Color BL = new Color(picture.get(x - 1, y + 1).getRGB());
                Color B = new Color(picture.get(x, y + 1).getRGB());
                
                int Red = min(T.getRed(), TL.getRed(), L.getRed(), X.getRed(), B.getRed(), BL.getRed(),256,256,256);
                int Green = min(T.getGreen(), TL.getGreen(), L.getGreen(), X.getGreen(), B.getGreen(), BL.getGreen(), 256,256,256);
                int Blue = min(T.getBlue(), TL.getBlue(), L.getBlue(), X.getBlue(), B.getBlue(), BL.getBlue(), 256,256,256);

                return new Color(Red, Green, Blue);
            }
            else if(y == height() - 1){
                Color TL = new Color(picture.get(x - 1, y - 1).getRGB());
                Color T = new Color(picture.get(x, y - 1).getRGB());
                Color TR = new Color(picture.get(x + 1, y - 1).getRGB());

                Color L = new Color(picture.get(x - 1, y).getRGB());
                Color X = new Color(picture.get(x, y).getRGB());
                Color R = new Color(picture.get(x + 1, y).getRGB());
                
                int Red = min(T.getRed(), TL.getRed(), TR.getRed(), X.getRed(), L.getRed(), R.getRed(),256,256,256);
                int Green = min(T.getGreen(), TL.getGreen(), TR.getGreen(), X.getGreen(), L.getGreen(), R.getGreen(), 256,256,256);
                int Blue = min(T.getBlue(), TL.getBlue(), TR.getBlue(), X.getBlue(), L.getBlue(), R.getBlue(), 256,256,256);

                return new Color(Red, Green, Blue);
            }
        }
        else{
            Color TL = new Color(picture.get(x - 1, y - 1).getRGB());
            Color T = new Color(picture.get(x, y - 1).getRGB());
            Color TR = new Color(picture.get(x + 1, y - 1).getRGB());
            
            Color L = new Color(picture.get(x - 1, y).getRGB());
            Color X = new Color(picture.get(x, y).getRGB());
            Color R = new Color(picture.get(x + 1, y).getRGB());
            
            Color BL = new Color(picture.get(x - 1, y + 1).getRGB());
            Color B = new Color(picture.get(x, y + 1).getRGB());
            Color BR = new Color(picture.get(x + 1, y + 1).getRGB());
            
            int Red = min(TL.getRed(), T.getRed(), TR.getRed(), L.getRed(), X.getRed(), R.getRed(), BL.getRed(), B.getRed(), BR.getRed());
            int Green = min(TL.getGreen(), T.getGreen(), TR.getGreen(), L.getGreen(), X.getGreen(), R.getGreen(), BL.getGreen(), B.getGreen(), BR.getGreen());
            int Blue = min(TL.getBlue(), T.getBlue(), TR.getBlue(), L.getBlue(), X.getBlue(), R.getBlue(), BL.getBlue(), B.getBlue(), BR.getBlue());
            
            return new Color(Red, Green, Blue);
        }
        return null;
    }
    
    public int min(int a, int b, int c, int d, int e, int f, int g, int h, int i){
        int max = Math.min(a, Math.min(b, Math.min(c, Math.min(d, Math.min(e, Math.min(f, Math.min(g, Math.min(h, i))))))));
        
        if(max == a){
            return a;
        }
        else if(max == b){
            return b;
        }
        else if(max == b){
            return b;
        }
        else if(max == c){
            return c;
        }
        else if(max == d){
            return d;
        }
        else if(max == e){
            return e;
        }
        else if(max == f){
            return f;
        }
        else if(max == g){
            return g;
        }
        else if(max == h){
            return h;
        }
        else{
            return i;
        }
    }
    
    public void MedianFilter(){
        dumcolor = new Color[height()][width()];
        
        for (int i = 0; i < height(); i++) {
            for (int j = 0; j < width(); j++) {
                dumcolor[i][j] = Mediancompute(j,i);
            }
        }
    }
    
    public Color Mediancompute(int x, int y){
        if(isBorder(x,y)){
            if(x == 0 && y == 0){
                Color X = new Color(picture.get(x, y).getRGB());
                Color R = new Color(picture.get(x + 1, y).getRGB());
                Color B = new Color(picture.get(x, y + 1).getRGB());
                Color BR = new Color(picture.get(x + 1, y + 1).getRGB());
                
                int a[] = new int[4];
                
                a[0] = X.getRed();
                a[1] = R.getRed();
                a[2] = B.getRed();
                a[3] = BR.getRed();
                
                int Red = (int)getMedina(a);
                
                a[0] = X.getGreen();
                a[1] = R.getGreen();
                a[2] = B.getGreen();
                a[3] = BR.getGreen();
                
                int Green = (int)getMedina(a);
                
                a[0] = X.getBlue();
                a[1] = R.getBlue();
                a[2] = B.getBlue();
                a[3] = BR.getBlue();
                
                int Blue = (int)getMedina(a);
                
                return new Color(Red, Green, Blue);
            }
            else if(x == width() - 1 && y == height() - 1){
                Color TL = new Color(picture.get(x - 1, y - 1).getRGB());
                Color T = new Color(picture.get(x, y - 1).getRGB());
                Color L = new Color(picture.get(x - 1, y).getRGB());
                Color X = new Color(picture.get(x, y).getRGB());
                
                int a[] = new int[4];
                
                a[0] = TL.getRed();
                a[1] = T.getRed();
                a[2] = L.getRed();
                a[3] = X.getRed();
                
                int Red = (int)getMedina(a);
                
                a[0] = TL.getGreen();
                a[1] = T.getGreen();
                a[2] = L.getGreen();
                a[3] = X.getGreen();
                
                int Green = (int)getMedina(a);
                
                a[0] = TL.getBlue();
                a[1] = T.getBlue();
                a[2] = L.getBlue();
                a[3] = X.getBlue();
                
                int Blue = (int)getMedina(a);
                
                return new Color(Red, Green, Blue);
            }
            else if(x == width() - 1 && y == 0){
                Color L = new Color(picture.get(x - 1, y).getRGB());
                Color X = new Color(picture.get(x, y).getRGB());
                Color BL = new Color(picture.get(x - 1, y + 1).getRGB());
                Color B = new Color(picture.get(x, y + 1).getRGB());
                
                int a[] = new int[4];
                
                a[0] = L.getRed();
                a[1] = X.getRed();
                a[2] = BL.getRed();
                a[3] = B.getRed();
                
                int Red = (int)getMedina(a);
                
                a[0] = L.getGreen();
                a[1] = X.getGreen();
                a[2] = BL.getGreen();
                a[3] = B.getGreen();
                
                int Green = (int)getMedina(a);
                
                a[0] = L.getBlue();
                a[1] = X.getBlue();
                a[2] = BL.getBlue();
                a[3] = B.getBlue();
                
                int Blue = (int)getMedina(a);
                
                return new Color(Red, Green, Blue);
            }
            else if(x == 0 && y == height() - 1){
                Color T = new Color(picture.get(x, y - 1).getRGB());
                Color TR = new Color(picture.get(x + 1, y - 1).getRGB());
                Color X = new Color(picture.get(x, y).getRGB());
                Color R = new Color(picture.get(x + 1, y).getRGB());
                
                int a[] = new int[4];
                
                a[0] = T.getRed();
                a[1] = TR.getRed();
                a[2] = X.getRed();
                a[3] = R.getRed();
                
                int Red = (int)getMedina(a);
                
                a[0] = T.getGreen();
                a[1] = TR.getGreen();
                a[2] = X.getGreen();
                a[3] = R.getGreen();
                
                int Green = (int)getMedina(a);
                
                a[0] = T.getBlue();
                a[1] = TR.getBlue();
                a[2] = X.getBlue();
                a[3] = R.getBlue();
                
                int Blue = (int)getMedina(a);
                
                return new Color(Red, Green, Blue);
            }
            else if(x == 0){
                Color T = new Color(picture.get(x, y - 1).getRGB());
                Color TR = new Color(picture.get(x + 1, y - 1).getRGB());
                Color X = new Color(picture.get(x, y).getRGB());
                Color R = new Color(picture.get(x + 1, y).getRGB());
                Color B = new Color(picture.get(x, y + 1).getRGB());
                Color BR = new Color(picture.get(x + 1, y + 1).getRGB());

                int a[] = new int[6];
                
                a[0] = T.getRed();
                a[1] = TR.getRed();
                a[2] = X.getRed();
                a[3] = R.getRed();
                a[4] = B.getRed();
                a[5] = BR.getRed();
                
                int Red = (int)getMedina(a);
                
                a[0] = T.getGreen();
                a[1] = TR.getGreen();
                a[2] = X.getGreen();
                a[3] = R.getGreen();
                a[4] = B.getGreen();
                a[5] = BR.getGreen();
                
                int Green = (int)getMedina(a);
                
                a[0] = T.getBlue();
                a[1] = TR.getBlue();
                a[2] = X.getBlue();
                a[3] = R.getBlue();
                a[4] = B.getBlue();
                a[5] = BR.getBlue();
                
                int Blue = (int)getMedina(a);
                
                return new Color(Red, Green, Blue);

            }
            else if(y == 0){
                Color L = new Color(picture.get(x - 1, y).getRGB());
                Color X = new Color(picture.get(x, y).getRGB());
                Color R = new Color(picture.get(x + 1, y).getRGB());

                Color BL = new Color(picture.get(x - 1, y + 1).getRGB());
                Color B = new Color(picture.get(x, y + 1).getRGB());
                Color BR = new Color(picture.get(x + 1, y + 1).getRGB());

                int a[] = new int[6];
                
                a[0] = L.getRed();
                a[1] = X.getRed();
                a[2] = R.getRed();
                a[3] = BL.getRed();
                a[4] = B.getRed();
                a[5] = BR.getRed();
                
                int Red = (int)getMedina(a);
                
                a[0] = L.getGreen();
                a[1] = X.getGreen();
                a[2] = R.getGreen();
                a[3] = BL.getGreen();
                a[4] = B.getGreen();
                a[5] = BR.getGreen();
                
                int Green = (int)getMedina(a);
                
                a[0] = L.getBlue();
                a[1] = X.getBlue();
                a[2] = R.getBlue();
                a[3] = BL.getBlue();
                a[4] = B.getBlue();
                a[5] = BR.getBlue();
                
                int Blue = (int)getMedina(a);
                
                return new Color(Red, Green, Blue);
            }
            else if(x == width() - 1){
                Color TL = new Color(picture.get(x - 1, y - 1).getRGB());
                Color T = new Color(picture.get(x, y - 1).getRGB());
                Color L = new Color(picture.get(x - 1, y).getRGB());
                Color X = new Color(picture.get(x, y).getRGB());
                Color BL = new Color(picture.get(x - 1, y + 1).getRGB());
                Color B = new Color(picture.get(x, y + 1).getRGB());
                
                int a[] = new int[6];
                
                a[0] = TL.getRed();
                a[1] = T.getRed();
                a[2] = L.getRed();
                a[3] = X.getRed();
                a[4] = BL.getRed();
                a[5] = B.getRed();
                
                int Red = (int)getMedina(a);
                
                a[0] = TL.getGreen();
                a[1] = T.getGreen();
                a[2] = L.getGreen();
                a[3] = X.getGreen();
                a[4] = BL.getGreen();
                a[5] = B.getGreen();
                
                int Green = (int)getMedina(a);
                
                a[0] = TL.getBlue();
                a[1] = T.getBlue();
                a[2] = L.getBlue();
                a[3] = X.getBlue();
                a[4] = BL.getBlue();
                a[5] = B.getBlue();
                
                int Blue = (int)getMedina(a);
                
                return new Color(Red, Green, Blue);
            }
            else if(y == height() - 1){
                Color TL = new Color(picture.get(x - 1, y - 1).getRGB());
                Color T = new Color(picture.get(x, y - 1).getRGB());
                Color TR = new Color(picture.get(x + 1, y - 1).getRGB());

                Color L = new Color(picture.get(x - 1, y).getRGB());
                Color X = new Color(picture.get(x, y).getRGB());
                Color R = new Color(picture.get(x + 1, y).getRGB());
                
                int a[] = new int[6];
                
                a[0] = TL.getRed();
                a[1] = T.getRed();
                a[2] = TR.getRed();
                a[3] = L.getRed();
                a[4] = X.getRed();
                a[5] = R.getRed();
                
                int Red = (int)getMedina(a);
                
                a[0] = TL.getGreen();
                a[1] = T.getGreen();
                a[2] = TR.getGreen();
                a[3] = L.getGreen();
                a[4] = X.getGreen();
                a[5] = R.getGreen();
                
                int Green = (int)getMedina(a);
                
                a[0] = TL.getBlue();
                a[1] = T.getBlue();
                a[2] = T.getBlue();
                a[3] = L.getBlue();
                a[4] = X.getBlue();
                a[5] = R.getBlue();
                
                int Blue = (int)getMedina(a);
                
                return new Color(Red, Green, Blue);
            }
        }
        else{
            Color TL = new Color(picture.get(x - 1, y - 1).getRGB());
            Color T = new Color(picture.get(x, y - 1).getRGB());
            Color TR = new Color(picture.get(x + 1, y - 1).getRGB());
            
            Color L = new Color(picture.get(x - 1, y).getRGB());
            Color X = new Color(picture.get(x, y).getRGB());
            Color R = new Color(picture.get(x + 1, y).getRGB());
            
            Color BL = new Color(picture.get(x - 1, y + 1).getRGB());
            Color B = new Color(picture.get(x, y + 1).getRGB());
            Color BR = new Color(picture.get(x + 1, y + 1).getRGB());
            
            int a[] = new int[9];
                
                a[0] = TL.getRed();
                a[1] = T.getRed();
                a[2] = TR.getRed();
                a[3] = L.getRed();
                a[4] = X.getRed();
                a[5] = R.getRed();
                a[6] = BL.getRed();
                a[7] = B.getRed();
                a[8] = BR.getRed();
                
                int Red = (int)getMedina(a);
                
                a[0] = TL.getGreen();
                a[1] = T.getGreen();
                a[2] = TR.getGreen();
                a[3] = L.getGreen();
                a[4] = X.getGreen();
                a[5] = R.getGreen();
                a[6] = BL.getGreen();
                a[7] = B.getGreen();
                a[8] = BR.getGreen();
                
                int Green = (int)getMedina(a);
                
                a[0] = TL.getBlue();
                a[1] = T.getBlue();
                a[2] = TR.getBlue();
                a[3] = L.getBlue();
                a[4] = X.getBlue();
                a[5] = R.getBlue();
                a[6] = BL.getBlue();
                a[7] = B.getBlue();
                a[8] = BR.getBlue();
                
                int Blue = (int)getMedina(a);
                
                return new Color(Red, Green, Blue);
        }
        return null;
    }
    
    public double getMedina(int[] a){
        Arrays.sort(a);
        
        double median = 0;
        double pos1 = Math.floor((a.length - 1.0) / 2.0);
        double pos2 = Math.ceil((a.length - 1.0) / 2.0);
                
        if (pos1 == pos2) {
            median = a[(int)pos1];
        } 
        else {
            median = (a[(int)pos1] + a[(int)pos2]) / 2.0 ;
        }
        return median;
    }
    
    public boolean isBorder(int x, int y){
        return x == 0 || x == width() - 1 || y == 0 || y == height() - 1;
    }
     
    public void setPicture(){
        Picture newpic = new Picture(width(), height());
        
        for (int i = 0; i < height(); i++) {
            for (int j = 0; j < width(); j++) {
                newpic.set(j, i, dumcolor[i][j]);
            }
        }
        this.picture = newpic;
    }
     
    public static void main(String[] args){
        JFrame frame1 = new JFrame("Image Filtering"); //frame_name("label")
        frame1.setBounds(500,300,500,500); //(x_crd,y_crd,width,height)
        JMenuBar jmb = new JMenuBar();

        JMenu jmFile = new JMenu ("File");
        JMenuItem jmiExit = new JMenuItem ("Exit");
            
        jmFile.add(jmiExit);
        jmb.add(jmFile);

        frame1.add(jmb);
        frame1.setJMenuBar(jmb);
        
        
        final JTextField filepath = new JTextField();  
        filepath.setBounds(150,50, 200,20);  
        
        
        JButton file = new JButton("Choose File");  
        file.setBounds(30,50,100,20);  
        file.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new java.io.File("."));
                chooser.setDialogTitle("choosertitle");
                chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                chooser.setAcceptAllFileFilterUsed(false);

                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    File f = chooser.getSelectedFile();
                    filepath.setText(f.getPath());
                }
            }  
        });
        JRadioButton MeanButton   = new JRadioButton("Mean Filtering", true);
        JRadioButton MaxButton    = new JRadioButton("Max Filtering");
        JRadioButton MinButton    = new JRadioButton("Min Filtering");
        JRadioButton MedianButton    = new JRadioButton("Median Filtering");
        
        MeanButton.setBounds(75,90,150,35);    
        MaxButton.setBounds(75,120,150,35);
        MinButton.setBounds(75,150,150,35);
        MedianButton.setBounds(75,180,150,35);
        
        //... Create a button group and add the buttons.
        ButtonGroup bgroup = new ButtonGroup();
        bgroup.add(MeanButton);
        bgroup.add(MaxButton);
        bgroup.add(MinButton);
        bgroup.add(MedianButton);
        
        frame1.add(MeanButton);
        frame1.add(MaxButton);
        frame1.add(MinButton);
        frame1.add(MedianButton);
        
        JButton b = new JButton("Filter Image");  
        b.setBounds(120,230,150,20);  
        b.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                if(filepath.getText().equals("")){
                    JFrame parent = new JFrame();
                    JOptionPane.showMessageDialog(parent, "No Image Path");
                }
                else{
                    String path = filepath.getText();
                    boolean ext = false;
                    
                    String extension = "";
                    int k = path.lastIndexOf('.');
                    int p = Math.max(path.lastIndexOf('/'), path.lastIndexOf('\\'));

                    if (k > p) {
                        extension = path.substring(k+1);
                    }
                    
                    if(extension.equalsIgnoreCase("JPG") || extension.equalsIgnoreCase("PNG") || extension.equalsIgnoreCase("BMP") || extension.equalsIgnoreCase("WEBMP") || extension.equalsIgnoreCase("GIF")){
                        ext = true;
                    } 
                    
                    if(ext){
                        Picture picture = new Picture(path);
                        ImageFiltering img = new ImageFiltering(picture);
                        
                        img.picture.show();
                        if(MeanButton.isSelected()){
                            img.MeanFilter();
                            img.setPicture();
                        }
                        else if(MaxButton.isSelected()){
                            img.MaxFilter();
                            img.setPicture();
                        }
                        else if(MinButton.isSelected()){
                            img.MinFilter();
                            img.setPicture();
                        }
                        else if(MedianButton.isSelected()){
                            img.MedianFilter();
                            img.setPicture();
                        }
                        img.picture.show();
                    }
                    else{
                        JFrame parent = new JFrame();
                        JOptionPane.showMessageDialog(parent, "Not a Valid Image File");
                    }
                }
            }  
        });  
        
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame1.add(file);
        frame1.add(filepath);
        frame1.add(b);
        frame1.setSize(380, 350);  
        frame1.setLayout(null);  
         
        jmiExit.addActionListener(new ActionListener(){ //Exit
            public void actionPerformed (ActionEvent ae){
               System.exit(0);
            }
        });
        frame1.setVisible(true); 
    }
}
