import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Gaussiano {
    public static void main(String[] args) throws IOException {

        String img = "src/ImagePath/ImagensComRuidos/Image5.png";
        BufferedImage image1 = ImageIO.read(new File(img));
        BufferedImage novaImagem = new BufferedImage(image1.getWidth(), image1.getHeight(), BufferedImage.TYPE_INT_RGB);

        int largura = novaImagem.getWidth();
        int altura = novaImagem.getHeight();

        Color px1,px2,px3,px4,px5,px6,px7,px8,px9;

        double[] filtro = {0.0625, 0.125, 0.0625, 0.125, 0.25, 0.125, 0.0625, 0.125, 0.0625};

        for (int linha = 1; linha < largura - 1; linha++) {
            for (int coluna = 1; coluna < altura - 1; coluna++) {

                px1 = new Color(image1.getRGB(linha - 1, coluna - 1));
                px2 = new Color(image1.getRGB(linha - 1, coluna));
                px3 = new Color(image1.getRGB(linha - 1, coluna + 1));

                px4 = new Color(image1.getRGB(linha, coluna - 1));
                px5 = new Color(image1.getRGB(linha, coluna));
                px6 = new Color(image1.getRGB(linha, coluna + 1));

                px7 = new Color(image1.getRGB(linha + 1, coluna - 1));
                px8 = new Color(image1.getRGB(linha + 1, coluna));
                px9 = new Color(image1.getRGB(linha + 1, coluna + 1));

                double r = (filtro[0] * px1.getRed()) + (filtro[1] * px2.getRed()) + (filtro[2] * px3.getRed()) + (filtro[3] * px4.getRed()) + (filtro[4] * px5.getRed()) + (filtro[5] * px6.getRed()) + (filtro[6] * px7.getRed()) + (filtro[7] * px8.getRed()) + (filtro[8] * px9.getRed());
                double g = (filtro[0] * px1.getGreen()) + (filtro[1] * px2.getGreen()) + (filtro[2] * px3.getGreen()) + (filtro[3] * px4.getGreen()) + (filtro[4] * px5.getGreen()) + (filtro[5] * px6.getGreen()) + (filtro[6] * px7.getGreen()) + (filtro[7] * px8.getGreen()) + (filtro[8] * px9.getGreen());
                double b = (filtro[0] * px1.getBlue()) + (filtro[1] * px2.getBlue()) + (filtro[2] * px3.getBlue()) + (filtro[3] * px4.getBlue()) + (filtro[4] * px5.getBlue()) + (filtro[5] * px6.getBlue()) + (filtro[6] * px7.getBlue()) + (filtro[7] * px8.getBlue()) + (filtro[8] * px9.getBlue());

                int valorR = (int) r;
                int valorG = (int) g;
                int valorB = (int) b;

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

                Color novaCor = new Color(valorR, valorG, valorB);

                novaImagem.setRGB(linha, coluna, novaCor.getRGB());
            }
        }

        ImageIO.write(novaImagem,"png",new File("src/ImagePath/Resultados/Gaussiano/NOVAimagem5.png"));

    }
}