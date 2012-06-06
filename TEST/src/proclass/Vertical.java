package proclass;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import com.sun.image.codec.jpeg.ImageFormatException;
public class Vertical {
	public int CutVertical(BufferedImage img[],BufferedImage img2[],int pic) {
		int Cpoint[] = new int[img[pic].getWidth()],height = 0,start = 0,cut = 0;
		boolean status = false,status2 = false;
		BufferedImage buff;
		//BinaryImage BI3 = new BinaryImage();
		
		for(int i=0;i<img[pic].getWidth();i++){
			for(int j=0;j<img[pic].getHeight();j++){
				if(img[pic].getRGB(i, j)==-16777216){
					Cpoint[i]=Cpoint[i]+1;
				}
			}
		}
		
			for(int i=0;i<img[pic].getWidth();i++){
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
						buff=img[pic].getSubimage(start, 0,height,img[pic].getHeight());
						if(buff.getWidth()>120){
						img2[cut]=img[pic].getSubimage(start, 0,height,img[pic].getHeight());
						//BI3.writeImage(img2[cut],cut);
						cut=cut+1;
						}
						height=0;
						}
				}
			}
			return cut;
			}
	public void CutExamVer(BufferedImage image[],BufferedImage image2[],int pic){
		int Cpoint[] = new int[image[pic].getWidth()];
		int max[] = new int[image[pic].getWidth()],vmax=0;
		int height = 0,start = 0,cut = 0;
		boolean status = false;
		for(int i=0;i<image[pic].getWidth();i++){
			for(int j=0;j<image[pic].getHeight();j++){
				if(image[pic].getRGB(i, j)==-16777216){			
					Cpoint[i]=Cpoint[i]+1;
					max[i]=max[i]+1;
				}
			}
			//System.out.print(Cpoint[i]+" ");
		}
		Arrays.sort(max);
		vmax=max[max.length-1];
		//System.out.print(vmax);
		try {
			for(int i=1;i<image[pic].getWidth();i++){
				if((Cpoint[i-1]>=vmax-4)&&(Cpoint[i]<=vmax-4)){
					if(status==false){
						start=i-1;
						status=true;
					}
				}	
				if(status==true){
					height=height+1;
				if((Cpoint[i]>=vmax-4)&&(Cpoint[i-1]<=vmax-4)){
					status=false;
					image2[cut]=image[pic].getSubimage(start,0,height, image[pic].getHeight());
					cut=cut+1;
					height=0;
				}
				}
			}
		} catch (ImageFormatException e) {
			e.printStackTrace();
		}
	}
	}
