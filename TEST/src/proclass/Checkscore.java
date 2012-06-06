package proclass;
import java.awt.image.BufferedImage;
public class Checkscore {
	public String checkstudentid(BufferedImage image[][]){
		int buff[][]=new int[14][10],cid=0,tmp=0,cid2=0;
		String stdid = "",stdid2 = "";
		for(int i=1;i<14;i++){
			for(int j=0;j<10;j++){
				for(int k=0;k<image[i][j].getWidth();k++){
					for(int l=0;l<image[i][j].getHeight();l++){
						if(image[i][j].getRGB(k, l)==-16777216){
							cid=cid+1;
						}
					}
				}
                                
				buff[i][j]=cid;
                		cid=0;
				if(buff[i][j]>tmp){
					tmp=buff[i][j];
					stdid=String.valueOf(j);
				}
			}
			cid2=cid2+1;
			if(cid2==13){
			stdid2=stdid2+"-"+stdid;	
			}else{
			stdid2=stdid2+stdid;
			}
			tmp=0;
		}
                for(int i=1;i<14;i++){
		for(int j=0;j<10;j++){
                       if(buff[i][j]>70){
                           buff[i][j]=1;
                       }else{
                           buff[i][j]=0;
                       }
                       //System.out.print(buff[i][j]+" ");
                }    
                //System.out.println();
                }
                   
		return stdid2;
	}
	
	public String checksubjectid(BufferedImage image[][]){
		int buff[][]=new int[9][10],cid=0,tmp=0,cid2 = 0;
		String sjid = "",sjid2 = "";
		for(int i=1;i<9;i++){
			for(int j=0;j<10;j++){
				for(int k=0;k<image[i][j].getWidth();k++){
					for(int l=0;l<image[i][j].getHeight();l++){
						if(image[i][j].getRGB(k, l)==-16777216){
							cid=cid+1;
						}
					}
				}
				buff[i][j]=cid;
				cid=0;
				if(buff[i][j]>tmp){
					tmp=buff[i][j];
					sjid=String.valueOf(j);
				}
			}
                        cid2=cid2+1;
                        if(cid2==3){
			sjid2=sjid2+"-"+sjid;
                        }
                        else if(cid2==6){
			sjid2=sjid2+"-"+sjid;
			}else{
			sjid2=sjid2+sjid;
			}
			tmp=0;
		}
                
                for(int i=1;i<9;i++){
		for(int j=0;j<10;j++){
                       if(buff[i][j]>70){
                           buff[i][j]=1;
                       }else{
                           buff[i][j]=0;
                       }
                       //System.out.print(buff[i][j]+" ");
                }    
                //System.out.println();
                }
                //System.out.println();
                
		return sjid2;
	}
	
	public void checkchoid(BufferedImage image[][],int buff[][]){
		int cid=0,total=0;
                int avg[]=new int[120];
		for(int i=0;i<120;i++){
                    //System.out.print(i+1+" ");
			for(int j=0;j<5;j++){
				for(int k=0;k<image[i][j].getWidth();k++){
					for(int l=0;l<image[i][j].getHeight();l++){
						if(image[i][j].getRGB(k, l)==-16777216){
							cid=cid+1;
						}
					}
				}
                                total=total+cid;
                                buff[i][j]=cid;
                                //System.out.print(buff[i][j]+" ");
				//if(cid>100){
				//	buff[i][j]=1;
				//}else{
				//	buff[i][j]=0;
				//}
                                
				//System.out.print(cid+" ");
				cid=0;
			}
                        avg[i]=total/4;
                        total=0;
			//System.out.println();
		}
                for(int i=0;i<120;i++){
                    for(int j=0;j<5;j++){
                        if(buff[i][j]>avg[i]){
                            buff[i][j]=1;
                        }else{
                            buff[i][j]=0;
                        }
                    }
                }
                
	}
}
