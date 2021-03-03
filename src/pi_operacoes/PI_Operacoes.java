package pi_operacoes;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class PI_Operacoes {

    BufferedImage abreImagem(String Imagem) throws IOException{
        BufferedImage image = ImageIO.read(new File("Imagens-imput\\"+Imagem));
        return image;
    }

    public int[][] Image_To_Matriz(BufferedImage ImagemCarregada){
        int altura, largura;
        altura = ImagemCarregada.getHeight();
        largura = ImagemCarregada.getWidth();
        int vetAuxPixel[] = new int[largura*altura];
        vetAuxPixel = ImagemCarregada.getRGB(0, 0, largura, altura, null, 0, largura);
        int matrizPixel[][] = new int[altura][largura];
        int count = 0;
        for (int i=0;i<altura;i++)
        {
            for (int j=0;j<largura;j++)
            {
                matrizPixel[i][j]= vetAuxPixel[count];
                count++;
            }
        }
        return matrizPixel;
    }

    public void Cria_Imagem_Alterada(int [][] MatrizPixel,String NomeImagem) throws IOException{
        int new_altura,new_largura;
        new_altura=MatrizPixel.length;
        new_largura=MatrizPixel[1].length;
        int[] vetAux= new int[new_largura*new_altura];
        int count=0;
        for (int i=0;i<new_altura;i++){
            for(int j=0;j<new_largura;j++){
                vetAux[count]=MatrizPixel[i][j];
                count++;
            }
        }
        BufferedImage new_image_altera = new BufferedImage(new_largura, new_altura,BufferedImage.TYPE_INT_RGB);
        new_image_altera.setRGB(0, 0, new_largura, new_altura, vetAux, 0, new_largura);
        ImageIO.write(new_image_altera,"JPG", new File(NomeImagem+".jpg"));
    }

    public void OpSoma(BufferedImage ImagemCarregada1, BufferedImage ImagemCarregada2) throws IOException{
        if(ImagemCarregada1.getHeight() == ImagemCarregada2.getHeight() && ImagemCarregada1.getWidth() == ImagemCarregada2.getWidth()){
            int altura, largura;
            altura = ImagemCarregada1.getHeight();
            largura = ImagemCarregada1.getWidth();

            int matrizPixel[][] = new int[altura][largura];
            int count = 0;
            int[] VetRed1 = new int[largura*altura];
            int[] VetGreen1 = new int[largura*altura];
            int[] VetBlue1 = new int[largura*altura];
            int[] VetRed2 = new int[largura*altura];
            int[] VetGreen2 = new int[largura*altura];
            int[] VetBlue2 = new int[largura*altura];
            int [][] matrizRed = new int[altura][largura];
            int [][] matrizGreen = new int[altura][largura];
            int [][] matrizBlue = new int[altura][largura];
            for(int i=0;i<altura;i++){
                for(int j=0;j<largura;j++){
                    Color color = new Color(ImagemCarregada1.getRGB(j, i));
                    VetRed1[count]=color.getRed();
                    VetBlue1[count]=color.getBlue();
                    VetGreen1[count]=color.getGreen();
                    count++;
                }
            }
            count = 0;
            for(int i=0;i<altura;i++){
                for(int j=0;j<largura;j++){
                    Color color = new Color(ImagemCarregada2.getRGB(j, i));
                    VetRed2[count]=color.getRed();
                    VetBlue2[count]=color.getBlue();
                    VetGreen2[count]=color.getGreen();
                    count++;
                }
            }
            count=0;

            int [][] matrizRed1 = new int[altura][largura];
            int [][] matrizGreen1 = new int[altura][largura];
            int [][] matrizBlue1 = new int[altura][largura];
            for(int i=0;i<matrizBlue1.length;i++){
                for(int j=0;j<matrizBlue1[1].length;j++){
                    matrizRed1[i][j]=VetRed1[count];
                    matrizGreen1[i][j]=VetGreen1[count];
                    matrizBlue1[i][j]=VetBlue1[count];
                    count++;
                }
            }
            count = 0;
            int [][] matrizRed2 = new int[altura][largura];
            int [][] matrizGreen2 = new int[altura][largura];
            int [][] matrizBlue2 = new int[altura][largura];
            for(int i=0;i<matrizBlue2.length;i++){
                for(int j=0;j<matrizBlue2[1].length;j++){
                    matrizRed2[i][j]=VetRed2[count];
                    matrizGreen2[i][j]=VetGreen2[count];
                    matrizBlue2[i][j]=VetBlue2[count];
                    count++;
                }
            }

            for(int i=0;i<altura; i++){
                for(int j=0;j<largura; j++){
                    matrizBlue[i][j] = ((matrizBlue1[i][j] + matrizBlue2[i][j])/2)%256;
                    matrizRed[i][j] = ((matrizRed1[i][j] + matrizRed2[i][j])/2)%256;
                    matrizGreen[i][j] = ((matrizGreen1[i][j] + matrizGreen2[i][j])/2)%256;
                }
            }

            BufferedImage aux = new BufferedImage(matrizPixel[1].length, matrizPixel.length, BufferedImage.TYPE_INT_ARGB);
            for(int i=0;i<matrizPixel.length;i++){
                for(int j=0;j<matrizPixel[1].length;j++){
                    Color color = new Color(matrizRed[i][j], matrizGreen[i][j], matrizBlue[i][j]);
                    aux.setRGB(j, i, color.getRGB());
                }
            }

            Cria_Imagem_Alterada(Image_To_Matriz(aux), "OpSoma");
        }
    }
    public void OpSub(BufferedImage ImagemCarregada1, BufferedImage ImagemCarregada2) throws IOException{
        if(ImagemCarregada1.getHeight() == ImagemCarregada2.getHeight() && ImagemCarregada1.getWidth() == ImagemCarregada2.getWidth()){
            int altura, largura;
            altura = ImagemCarregada1.getHeight();
            largura = ImagemCarregada1.getWidth();

            int matrizPixel[][] = new int[altura][largura];
            int count = 0;
            int[] VetRed1 = new int[largura*altura];
            int[] VetGreen1 = new int[largura*altura];
            int[] VetBlue1 = new int[largura*altura];
            int[] VetRed2 = new int[largura*altura];
            int[] VetGreen2 = new int[largura*altura];
            int[] VetBlue2 = new int[largura*altura];
            int [][] matrizRed = new int[altura][largura];
            int [][] matrizGreen = new int[altura][largura];
            int [][] matrizBlue = new int[altura][largura];
            for(int i=0;i<altura;i++){
                for(int j=0;j<largura;j++){
                    Color color = new Color(ImagemCarregada1.getRGB(j, i));
                    VetRed1[count]=color.getRed();
                    VetBlue1[count]=color.getBlue();
                    VetGreen1[count]=color.getGreen();
                    count++;
                }
            }
            count = 0;
            for(int i=0;i<altura;i++){
                for(int j=0;j<largura;j++){
                    Color color = new Color(ImagemCarregada2.getRGB(j, i));
                    VetRed2[count]=color.getRed();
                    VetBlue2[count]=color.getBlue();
                    VetGreen2[count]=color.getGreen();
                    count++;
                }
            }
            count=0;

            int [][] matrizRed1 = new int[altura][largura];
            int [][] matrizGreen1 = new int[altura][largura];
            int [][] matrizBlue1 = new int[altura][largura];
            for(int i=0;i<matrizBlue1.length;i++){
                for(int j=0;j<matrizBlue1[1].length;j++){
                    matrizRed1[i][j]=VetRed1[count];
                    matrizGreen1[i][j]=VetGreen1[count];
                    matrizBlue1[i][j]=VetBlue1[count];
                    count++;
                }
            }
            count = 0;
            int [][] matrizRed2 = new int[altura][largura];
            int [][] matrizGreen2 = new int[altura][largura];
            int [][] matrizBlue2 = new int[altura][largura];
            for(int i=0;i<matrizBlue2.length;i++){
                for(int j=0;j<matrizBlue2[1].length;j++){
                    matrizRed2[i][j]=VetRed2[count];
                    matrizGreen2[i][j]=VetGreen2[count];
                    matrizBlue2[i][j]=VetBlue2[count];
                    count++;
                }
            }

            for(int i=0;i<altura; i++){
                for(int j=0;j<largura; j++){
                    matrizBlue[i][j] = ((matrizBlue1[i][j] - matrizBlue2[i][j]));
                    if(matrizBlue[i][j]<0)
                        matrizBlue[i][j]=0;
                    matrizRed[i][j] = ((matrizRed1[i][j] - matrizRed2[i][j]));
                    if(matrizRed[i][j]<0)
                        matrizRed[i][j]=0;
                    matrizGreen[i][j] = ((matrizGreen1[i][j] - matrizGreen2[i][j]));
                    if(matrizGreen[i][j]<0)
                        matrizGreen[i][j]=0;
                }
            }

            BufferedImage aux = new BufferedImage(matrizPixel[1].length, matrizPixel.length, BufferedImage.TYPE_INT_ARGB);
            for(int i=0;i<matrizPixel.length;i++){
                for(int j=0;j<matrizPixel[1].length;j++){
                    Color color = new Color(matrizRed[i][j], matrizGreen[i][j], matrizBlue[i][j]);
                    aux.setRGB(j, i, color.getRGB());
                }
            }

            Cria_Imagem_Alterada(Image_To_Matriz(aux), "OpSub");
        }
    }

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        PI_Operacoes Executar = new PI_Operacoes();
        BufferedImage Imagem1 = Executar.abreImagem("1.jpg");
        BufferedImage Imagem2 = Executar.abreImagem("2.jpg");
        Executar.OpSoma(Imagem1, Imagem2);
        Executar.OpSub(Imagem1,Imagem2);


    }
}