import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class RealceDeBorda {
    public static void main(String[] args) throws IOException {

        String img = "src/ImagePath/ImagensSemRuidos/image1.png";
        BufferedImage image = ImageIO.read(new File(img));

        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage novaImagem = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        Color px1,px2,px3,px4,px5,px6,px7,px8,px9;

        int[] filtro = {1, 1, 1, 0, 0, 0, -1, -1, -1};

        for (int largura = 1; largura<width-1; largura++){
            for (int coluna = 1; coluna <height-1; coluna++){

                px1 = new Color(image.getRGB(largura - 1, coluna - 1));
                px2 = new Color(image.getRGB(largura - 1, coluna));
                px3 = new Color(image.getRGB(largura - 1, coluna + 1));

                px4 = new Color(image.getRGB(largura, coluna - 1));
                px5 = new Color(image.getRGB(largura, coluna));
                px6 = new Color(image.getRGB(largura, coluna + 1));

                px7 = new Color(image.getRGB(largura + 1, coluna - 1));
                px8 = new Color(image.getRGB(largura + 1, coluna));
                px9 = new Color(image.getRGB(largura + 1, coluna + 1));

                int valorR = (filtro[0] * px1.getRed()) + (filtro[1] * px2.getRed()) + (filtro[2] * px3.getRed()) + (filtro[3] * px4.getRed()) + (filtro[4] * px5.getRed()) + (filtro[5] * px6.getRed()) + (filtro[6] * px7.getRed()) + (filtro[7] * px8.getRed()) + (filtro[8] * px9.getRed());
                int valorG = (filtro[0] * px1.getGreen()) + (filtro[1] * px2.getGreen()) + (filtro[2] * px3.getGreen()) + (filtro[3] * px4.getGreen()) + (filtro[4] * px5.getGreen()) + (filtro[5] * px6.getGreen()) + (filtro[6] * px7.getGreen()) + (filtro[7] * px8.getGreen()) + (filtro[8] * px9.getGreen());
                int valorB = (filtro[0] * px1.getBlue()) + (filtro[1] * px2.getBlue()) + (filtro[2] * px3.getBlue()) + (filtro[3] * px4.getBlue()) + (filtro[4] * px5.getBlue()) + (filtro[5] * px6.getBlue()) + (filtro[6] * px7.getBlue()) + (filtro[7] * px8.getBlue()) + (filtro[8] * px9.getBlue());

                if (valorR > 255) {
                    valorR = 255;
                }
                if (valorG > 255) {
                    valorG = 255;
                }
                if (valorB > 255) {
                    valorB = 255;
                }

                if (valorR < 0) {
                    valorR = 0;
                }
                if (valorG < 0) {
                    valorG = 0;
                }
                if (valorB < 0) {
                    valorB = 0;
                }

                Color corNova = new Color(valorR,valorG,valorB);

                novaImagem.setRGB(largura,coluna,corNova.getRGB());


            }
        }
        ImageIO.write(novaImagem,"png",new File("src/ImagePath/Resultados/RealceDeBorda/NOVAimage1.png"));
    }
}
