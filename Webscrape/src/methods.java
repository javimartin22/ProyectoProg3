import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class methods {

	public void Webscrape(String dia,String mes,String anyo, String dia1, String mes1, String anyo1, String ciudad, String codigo,int day, int month, int year) {
		
		final String url="https://espanol.wunderground.com/history/airport/"+codigo+"/"+anyo+"/"+mes+"/"+dia+"/CustomHistory.html?dayend="+dia1+"&monthend="+mes1+"&yearend="+anyo1+"&req_city=&req_state=&req_statename=&reqdb.zip=&reqdb.magic=&reqdb.wmo=";
		ArrayList<DiaRegistrado> diasregistrados = new ArrayList<DiaRegistrado>();
		Date dt= new Date(year,month,day-1);
		Bdatos bd= new Bdatos();
		bd.actualizarEstaciones(codigo);
		bd.insertarEstaciones(codigo, ciudad);
		
		int i =0;
		try {
			final Document document=Jsoup.connect(url).get();
			
			for (Element row : document.select(
					"table.responsive.obs-table.daily tr")) {
				if(row.select("td:nth-of-type(1)").text().equals("Ene")||row.select("td:nth-of-type(1)").text().equals("Feb")||row.select("td:nth-of-type(1)").text().equals("Mar")||row.select("td:nth-of-type(1)").text().equals("Abr")||row.select("td:nth-of-type(1)").text().equals("May")||row.select("td:nth-of-type(1)").text().equals("Jun")||row.select("td:nth-of-type(1)").text().equals("Jul")||row.select("td:nth-of-type(1)").text().equals("Ago")||row.select("td:nth-of-type(1)").text().equals("Sep")||row.select("td:nth-of-type(1)").text().equals("Oct")||row.select("td:nth-of-type(1)").text().equals("Nov")||row.select("td:nth-of-type(1)").text().equals("Dic")) {
					continue;
				}
				else {
					

					try {
						final String snumDia=row.select("td:nth-of-type(1)").text();
						
						final int numDia=Integer.parseInt(snumDia);
						
                          
						 final String stempHigh=row.select("td:nth-of-type(2)").text();
						final int tempHigh= Integer.parseInt(stempHigh);
						
						final String stempAvg=row.select("td:nth-of-type(3)").text();
						final int tempAvg= Integer.parseInt(stempAvg);
						final String stempLow=row.select("td:nth-of-type(4)").text();
						final int tempLow= Integer.parseInt(stempLow);
						final String srocioHigh=row.select("td:nth-of-type(5)").text();
						final int rocioHigh= Integer.parseInt(srocioHigh);
						final String srocioAvg=row.select("td:nth-of-type(6)").text();
						final int rocioAvg= Integer.parseInt(srocioAvg);
						final String srocioLow=row.select("td:nth-of-type(7)").text();
						final int rocioLow= Integer.parseInt(srocioLow);
						final String shumedadHigh=row.select("td:nth-of-type(8)").text();
						final int humedadHigh= Integer.parseInt(shumedadHigh);
						final String shumedadAvg=row.select("td:nth-of-type(9)").text();
						final int humedadAvg= Integer.parseInt(shumedadAvg);
						final String shumedadLow=row.select("td:nth-of-type(10)").text();
						final int humedadLow= Integer.parseInt(shumedadLow);
						final String sprecip=row.select("td:nth-of-type(20)").text();
						final double precip=Double.parseDouble(sprecip);
						
						Calendar c= Calendar.getInstance();
						c.setTime(dt);
						c.add(Calendar.DATE, 1);
						dt=c.getTime();
						System.out.println(dt.getDate());
						System.out.println(dt.getMonth()+1);
						System.out.println(dt.getYear());
						bd.insertarDias(dt.getDate(), (dt.getMonth()+1), dt.getYear(), tempHigh, tempAvg, tempLow, rocioHigh, rocioAvg, rocioLow, humedadHigh, humedadAvg, humedadLow, precip, ciudad);
						DiaRegistrado d=new DiaRegistrado(numDia,tempHigh,tempAvg,tempLow,rocioHigh,rocioAvg,rocioLow,humedadHigh,humedadAvg,humedadLow,precip);
					   System.out.println(d.toString());
						diasregistrados.add(d);
						
						
					} catch (NumberFormatException n) {
					    // ... Do nothing.
					}

					
					
				}
			}
			
			
			
		} 
		catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
	
public void Prediccion(String dia,String mes,String anyo,String codigo) {
		
		final String url="https://espanol.wunderground.com/history/airport/"+codigo+"/"+anyo+"/"+mes+"/"+dia+"/CustomHistory.html?dayend=28&monthend="+mes+"&yearend="+anyo+"&req_city=&req_state=&req_statename=&reqdb.zip=&reqdb.magic=&reqdb.wmo=";
		ArrayList<DiaRegistrado> diasprediccion = new ArrayList<DiaRegistrado>();
		
		
		int i =0;
		try {
			final Document document=Jsoup.connect(url).get();
			
			for (Element row : document.select(
					"table.responsive.obs-table.daily tr")) {
				if(row.select("td:nth-of-type(1)").text().equals("Ene")||row.select("td:nth-of-type(1)").text().equals("Feb")||row.select("td:nth-of-type(1)").text().equals("Mar")||row.select("td:nth-of-type(1)").text().equals("Abr")||row.select("td:nth-of-type(1)").text().equals("May")||row.select("td:nth-of-type(1)").text().equals("Jun")||row.select("td:nth-of-type(1)").text().equals("Jul")||row.select("td:nth-of-type(1)").text().equals("Ago")||row.select("td:nth-of-type(1)").text().equals("Sep")||row.select("td:nth-of-type(1)").text().equals("Oct")||row.select("td:nth-of-type(1)").text().equals("Nov")||row.select("td:nth-of-type(1)").text().equals("Dic")) {
					continue;
				}
				else {
					

					try {
						final String snumDia2=row.select("td:nth-of-type(1)").text();
						
						final int numDia2=Integer.parseInt(snumDia2);
						
                          
						 final String stempHigh2=row.select("td:nth-of-type(2)").text();
						final int tempHigh2= Integer.parseInt(stempHigh2);
						
						final String stempAvg2=row.select("td:nth-of-type(3)").text();
						final int tempAvg2= Integer.parseInt(stempAvg2);
						final String stempLow2=row.select("td:nth-of-type(4)").text();
						final int tempLow2= Integer.parseInt(stempLow2);
						final String srocioHigh2=row.select("td:nth-of-type(5)").text();
						final int rocioHigh2= Integer.parseInt(srocioHigh2);
						final String srocioAvg2=row.select("td:nth-of-type(6)").text();
						final int rocioAvg2= Integer.parseInt(srocioAvg2);
						final String srocioLow2=row.select("td:nth-of-type(7)").text();
						final int rocioLow2= Integer.parseInt(srocioLow2);
						final String shumedadHigh2=row.select("td:nth-of-type(8)").text();
						final int humedadHigh2= Integer.parseInt(shumedadHigh2);
						final String shumedadAvg2=row.select("td:nth-of-type(9)").text();
						final int humedadAvg2= Integer.parseInt(shumedadAvg2);
						final String shumedadLow2=row.select("td:nth-of-type(10)").text();
						final int humedadLow2= Integer.parseInt(shumedadLow2);
						final String sprecip2=row.select("td:nth-of-type(20)").text();
						final double precip2=Double.parseDouble(sprecip2);
						
						//Calendar c= Calendar.getInstance();
						//c.setTime(dt);
						//c.add(Calendar.DATE, 1);
						//dt=c.getTime();
						//System.out.println(dt.getDate());
						//System.out.println(dt.getMonth()+1);
						//System.out.println(dt.getYear());
						DiaRegistrado d=new DiaRegistrado(numDia2,tempHigh2,tempAvg2,tempLow2,rocioHigh2,rocioAvg2,rocioLow2,humedadHigh2,humedadAvg2,humedadLow2,precip2);
					   System.out.println(d.toString());
						diasprediccion.add(d);
						
						
						
					} catch (NumberFormatException n) {
					    // ... Do nothing.
					}

					
					
				}
			}
			System.out.println("loco");
			Iterator <DiaRegistrado> it= diasprediccion.iterator(); 
			int tempmax=0;
			int templow=0;
			int humedadavg=0;
			double cuentalluvia=0;
			while (it.hasNext()) {
				DiaRegistrado ds=it.next();
				tempmax=tempmax+ds.getTempHigh();
				templow=templow+ds.getTempLow();
				humedadavg=humedadavg+ds.getHumedadAvg();
				if(ds.getPrecip()>0) {
					cuentalluvia++;
				}
				
			}
			
			System.out.println(tempmax/28);
			int mex=tempmax/28;
			System.out.println(templow/28);
			int men=templow/28;
			System.out.println(humedadavg/28);
			int hum=humedadavg/28;
			int problluv= (int) (cuentalluvia/28 *100);
			System.out.println(problluv);
			
			VentanaPrediccion v21= new VentanaPrediccion(mex,men,hum,problluv);
			v21.setVisible(true);
		} 
		catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
