package proclass;
import com.sun.image.codec.jpeg.ImageFormatException;
import java.awt.image.BufferedImage;
import java.util.Arrays;
public class horizontal {
	public int Cuthorizontal(BufferedImage image,BufferedImage image2,BufferedImage image3[],int rgb[][]) {
		//System.out.println("Width: " + image.getWidth());
		//System.out.println("Height: " + image.getHeight());
		int Cpoint[] = new int[image.getHeight()],height = 0,start = 0,cut = 0;
		boolean status = false,status2 = false;
		BufferedImage buff;
		for(int i=0;i<image.getHeight();i++){
			for(int j=100;j<image.getWidth()-300;j++){
				if(rgb[j][i]==0){			
					Cpoint[i]=Cpoint[i]+1;
				}
			}
		}
		try {
			for(int i=0;i<image.getHeight();i++){
				if(Cpoint[i]!=0){
					if(status==false){
						if(status2==false){
							start=i;
							status2=true;
						}
						status=true;
					}
					height=height+1;
				}
				else
				{
					if(status==true){
						status=false;
						status2=false;
						buff=image2.getSubimage(0, start, image.getWidth(),height);
						if(buff.getHeight()>100){
						image3[cut]=image2.getSubimage(0, start, image.getWidth(),height);
						cut=cut+1;
						}
						height=0;
						
						
					}
				}
			}
		} catch (ImageFormatException e) {
			e.printStackTrace();
		}
		return cut;
	}
	public void CutExamHor(BufferedImage image,BufferedImage image2[]){
		int Cpoint[] = new int[image.getHeight()];
		int max[] = new int[image.getHeight()],vmax=0;
		int height = 0,start = 0,cut = 0;
		boolean status = false;
		BufferedImage buff;
		for(int i=0;i<image.getHeight();i++){
			for(int j=0;j<image.getWidth();j++){
				if(image.getRGB(j, i)==-16777216){			
					Cpoint[i]=Cpoint[i]+1;
					max[i]=max[i]+1;
				}
			}	
		}
		Arrays.sort(max);
		vmax=max[max.length-1];
		if(vmax>200){
			vmax=150;
		}
		try {
			for(int i=1;i<image.getHeight();i++){
				if((Cpoint[i-1]>=vmax-50)&&(Cpoint[i]<=vmax-50)){
					if(status==false){
						start=i-1;
						status=true;
					}
				}	
				if(status==true){
					height=height+1;
				if((Cpoint[i]>=vmax-50)&&(Cpoint[i-1]<=vmax-50)){
					status=false;
					buff=image.getSubimage(0, start, image.getWidth(),height);
					if(buff.getHeight()>15){
					image2[cut]=image.getSubimage(0, start, image.getWidth(),height);
					cut=cut+1;
					}
					height=0;
				}
				}
			}
		} catch (ImageFormatException e) {
			e.printStackTrace();
		}
	}
}