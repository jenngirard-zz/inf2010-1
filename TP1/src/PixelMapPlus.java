import java.awt.PageAttributes.ColorType;

/**
 * Classe PixelMapPlus
 * Image de type noir et blanc, tons de gris ou couleurs
 * Peut lire et ecrire des fichiers PNM
 * Implemente les methodes de ImageOperations
 * @author : 
 * @date   : 
 */

public class PixelMapPlus extends PixelMap implements ImageOperations 
{
	/**
	 * Constructeur creant l'image a partir d'un fichier
	 * @param fileName : Nom du fichier image
	 */
	PixelMapPlus(String fileName)
	{
		super( fileName );
	}
	
	/**
	 * Constructeur copie
	 * @param type : type de l'image a creer (BW/Gray/Color)
	 * @param image : source
	 */
	PixelMapPlus(PixelMap image)
	{
		super(image); 
	}
	
	/**
	 * Constructeur copie (sert a changer de format)
	 * @param type : type de l'image a creer (BW/Gray/Color)
	 * @param image : source
	 */
	PixelMapPlus(ImageType type, PixelMap image)
	{
		super(type, image); 
	}
	
	/**
	 * Constructeur servant a allouer la memoire de l'image
	 * @param type : type d'image (BW/Gray/Color)
	 * @param h : hauteur (height) de l'image 
	 * @param w : largeur (width) de l'image
	 */
	PixelMapPlus(ImageType type, int h, int w)
	{
		super(type, h, w);
	}
	
	/**
	 * Genere le negatif d'une image
	 */
	public void negate()
	{
		// compl�ter
		AbstractPixel[][] oldData = imageData;
		
		for (int i=0; i < super.height; i++) {
			for(int j=0; j < super.width; j++) {
				super.imageData[i][j] = oldData[i][j].Negative();
				
			}
			
		}

		
	}
	
	/**
	 * Convertit l'image vers une image en noir et blanc
	 */
	public void convertToBWImage()
	{
		// compl�ter
		AbstractPixel[][] oldData = imageData;
		super.clearData();
		super.AllocateMemory(ImageType.BW, super.height, super.width);
		
		for (int i=0; i < super.height; i++) {
			for(int j=0; j < super.width; j++) {
				super.imageData[i][j] = oldData[i][j].toBWPixel();				
			}
			
		}

	}
	
	/**
	 * Convertit l'image vers un format de tons de gris
	 */
	public void convertToGrayImage()
	{
		// compl�ter
		AbstractPixel[][] oldData = imageData;
		super.clearData();
		super.AllocateMemory(ImageType.Gray, super.height, super.width);
		
		for (int i=0; i < super.height; i++) {
			for(int j=0; j < super.width; j++) {
				super.imageData[i][j] = oldData[i][j].toGrayPixel();
			}
			
		}

	}
	
	/**
	 * Convertit l'image vers une image en couleurs
	 */
	public void convertToColorImage()
	{
		// compl�ter
		AbstractPixel[][] oldData = imageData;
		super.clearData();
		super.AllocateMemory(ImageType.Color, super.height, super.width);
		
		for (int i=0; i < super.height; i++) {
			for(int j=0; j < super.width; j++) {
				super.imageData[i][j] = oldData[i][j].toColorPixel();
				
			}
			
		}

	}
	
	public void convertToTransparentImage()
	{
		// compl�ter
		AbstractPixel[][] oldData = imageData;
		super.clearData();
		super.AllocateMemory(ImageType.Transparent, super.height, super.width);
		
		for (int i=0; i < super.height; i++) {
			for(int j=0; j < super.width; j++) {
				super.imageData[i][j] = oldData[i][j].toTransparentPixel();
				
			}
			
		}

	}
	
		
	/**
	 * Modifie la longueur et la largeur de l'image 
	 * @param w : nouvelle largeur
	 * @param h : nouvelle hauteur
	 */
	public void resize(int w, int h) throws IllegalArgumentException
	{
		if(w < 0 || h < 0)
			throw new IllegalArgumentException();
		
		// compl�ter
		AbstractPixel[][] oldData = super.imageData;
		
		double ratioHeight = h/(double)super.height;
		double ratioWidth = w/(double)super.width;
		
		super.clearData();
		super.AllocateMemory(super.getType(), h, w);
		
		for (int i=0; i < h; i++) {
			for(int j=0; j < w; j++) {
				super.imageData[i][j]=oldData[(int)(i/ratioHeight)][(int)(j/ratioWidth)];
			}
		}
		
		super.height = h;
		super.width = w;
		
	}
	
	/**
	 * Insert pm dans l'image a la position row0 col0
	 */
	public void insert(PixelMap pm, int row0, int col0)
	{
		// compl�ter
		for(int i = row0 ; i < pm.getHeight()+row0 ; i++) {
			for(int j = col0 ; j < pm.getWidth()+col0 ; j++) {
				if(super.imageType == ImageType.BW) {
					super.imageData[i][j] = (pm.getPixel(i-row0, j-col0)).toBWPixel();
				}
				else if(super.imageType == ImageType.Color) {
					super.imageData[i][j] = (pm.getPixel(i-row0, j-col0)).toColorPixel();
				}
				else if(super.imageType == ImageType.Gray) {
					super.imageData[i][j] = (pm.getPixel(i-row0, j-col0)).toGrayPixel();
				}
				else {
					super.imageData[i][j] = (pm.getPixel(i-row0, j-col0)).toTransparentPixel();
				}
			}
		}
		
	}
	
	/**
	 * Decoupe l'image 
	 */
	public void crop(int h, int w) throws IllegalArgumentException
	{
		if(w < 0 || h < 0)
			throw new IllegalArgumentException();
		AbstractPixel[][] oldData = super.imageData;
		super.clearData();
		AllocateMemory(super.imageType ,h,w);
		
		for(int i=0;i<h;i++) {
			for(int j = 0; j<w; j++) {
				if  (i<= super.height || j <= super.width) {
					super.imageData[i][j] = oldData[i][j];
				}	
			}
		}
		super.height = h;
		super.width = w;
	}
	/**
	 * Effectue une translation de l'image 
	 */
	public void translate(int rowOffset, int colOffset)
	{
		AbstractPixel[][] oldData = super.imageData;
		super.clearData();
		AllocateMemory(super.imageType,super.height,super.width);	
		
		for(int i=0;i<super.height;i++) {
			for(int j = 0; j<super.width; j++) {
				if(i+rowOffset >= 0 && i+rowOffset < super.height && j+colOffset >= 0 && j+colOffset < super.width) {
					super.imageData[i+rowOffset][j+colOffset]=oldData[i][j];
				}
			}
		}
		
	}
	
}
