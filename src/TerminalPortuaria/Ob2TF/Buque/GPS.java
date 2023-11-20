package TerminalPortuaria.Ob2TF.Buque;

import java.awt.geom.Point2D;

public class GPS {

	
	public GPS() {
		
	}

	public double  distanciaEntrePuntos( Point2D punto1, Point2D punto2 )
	{        
		double lat1rad = Math.toRadians( punto1.getX() );
	    double lon1rad = Math.toRadians( punto1.getY() );
	    double lat2rad = Math.toRadians( punto2.getX() );
	    double lon2rad = Math.toRadians( punto2.getY() );

	    double difLatitud = lat1rad - lat2rad;
	    double difLongitud = lon1rad - lon2rad;

	    double a = Math.pow(Math.sin(difLatitud/2), 2) +
	            Math.cos(lat1rad) *
	            Math.cos(lat2rad) *
	            Math.pow(Math.sin(difLongitud/2), 2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

	    double radioTierraKm = 6378.0;
	    double distancia = radioTierraKm * c;

	    return Math.round(distancia);
	}
	
	
}


