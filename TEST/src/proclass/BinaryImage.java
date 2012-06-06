package proclass;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
public class BinaryImage {
	public BinaryImage(){
		
	}
	public void CBinaryImage(BufferedImage image,int rgb[][]){
		

		for(int i=0;i<image.getWidth();i++){
			for(int j=0;j<image.getHeight();j++){
				rgb[i][j] = averageRGB(image.getRGB(i,j));
			}
		}
		
		for(int i=0;i<image.getWidth();i++){
			for(int j=0;j<image.getHeight();j++){
				if(rgb[i][j]>200){
					rgb[i][j]=255;
				}else{
					rgb[i][j]=0;
				}
			}
		}
    }
	
	public void getrgb(BufferedImage image,BufferedImage image2,int rgb[][]){
		for(int i=0;i<image.getWidth();i++){
			for(int j=0;j<image.getHeight();j++){
				image2.setRGB(i,j,averageRGB2(rgb[i][j]));
			}
		}
	}
	public int averageRGB(int rgb)
	{
		int r = (rgb >> 16) & 0xff;
		int g = (rgb >>  8) & 0xff;
		int b = (rgb >>  0) & 0xff;
	
		int nIntensity = (int) (r+g+b)/3;
		r = g = b = nIntensity;
		return nIntensity;
	}	
	public int averageRGB2(int rgb)
	{
		int r = (rgb  & 0xff ) << 16;
		int g = (rgb  & 0xff) << 8;
		int b = (rgb  & 0xff) ;
		int nIntensity = (int) (r+g+b);
		r = g = b = nIntensity;
		return (rgb & 0xff000000)| (r<<16) | (g<<8) | (b<<0);
	}	
	public void writeImage(BufferedImage img,int imgg){
		File f = new File(imgg+".png");
	     try {
			ImageIO.write(img, "png", f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
        public void tmpwriteImage(BufferedImage img,String str,String imgg){
            File fl = new File("D:\\dataexam\\tmp\\"+str);
            boolean mkdir = fl.mkdirs();
            File f = new File("D:\\dataexam\\tmp\\"+str+"\\"+imgg+".jpg");
	     try {
			ImageIO.write(img, "jpg", f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
