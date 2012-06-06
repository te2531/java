package proclass;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class LineDetect {
	public int checkline(BufferedImage image){
		int d=0,theta=0,buff=0,tmp=0,th=0;
		double w=0,h=0;
		w=image.getWidth();
		h=image.getHeight();
		d=(int) (Math.sqrt(Math.pow(w, 2)+Math.pow(h, 2)));
		int vote[][]=new int[d][361];
		for(int i=0;i<image.getHeight();i++){
			for(int j=0;j<image.getWidth();j++){
				if(image.getRGB(j, i)==-16777216){
					for(int t=0;t<=360;t++){
						buff=(int)(Math.abs((Math.cos(Math.toRadians(t))*j)+(Math.sin(Math.toRadians(t))*i)));
						vote[buff][t]=vote[buff][t]+1;
					}
				}
			}
		}
		int c=0;
		for(int i=0;i<d;i++){
			for(int j=0;j<=360;j++){
					if(vote[i][j]>tmp){
						tmp=vote[i][j];
						th=j;
						}
				}
			}
			//System.out.print("Angle : "+th);
			return th;
	}
	
	public void rotate(BufferedImage image,int r){
		 	AffineTransform tx = new AffineTransform();
		    tx.rotate(Math.toRadians(-r), image.getWidth() / 2,  image.getHeight() / 2);
		    AffineTransformOp op = new AffineTransformOp(tx,AffineTransformOp.TYPE_BILINEAR);
		    image = op.filter(image, null);
	}
	
}
